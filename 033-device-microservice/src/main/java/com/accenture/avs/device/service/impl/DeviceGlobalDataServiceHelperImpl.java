/**************************************************************************
 * Copyright (C) Accenture
 *
 * The reproduction, transmission or use of this document or its contents is not permitted without
 * prior express written consent of Accenture. Offenders will be liable for damages. All rights,
 * including but not limited to rights created by patent grant or registration of a utility model or
 * design, are reserved.
 *
 * Accenture reserves the right to modify technical specifications and features.
 *
 * Technical specifications and features are binding only insofar as they are specifically and
 * expressly agreed upon in a written contract.
 *
 **************************************************************************/

package com.accenture.avs.device.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.ConnectionMode;
import com.accenture.avs.device.entity.QoeGlobalSetting;
import com.accenture.avs.device.json.object.devicemanager.GlobalQoESettings;
import com.accenture.avs.device.json.object.devicemanager.Language;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;
import com.accenture.avs.device.repository.ConnectionModeRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.LanguageRepository;
import com.accenture.avs.device.repository.QoeGlobalSettingRepository;
import com.accenture.avs.device.service.DefaultServicePortMappingService;
import com.accenture.avs.device.service.DeviceGlobalDataServiceHelper;
import com.accenture.avs.device.service.ModelVersionService;
import com.accenture.avs.device.service.InterProcessCommunicationService;
import com.accenture.avs.device.service.LocationService;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;
import com.accenture.avs.device.util.DeviceGlobalDataServiceUtil;

/**
 * @author rajesh.karna
 *
 */
@Service
public class DeviceGlobalDataServiceHelperImpl implements DeviceGlobalDataServiceHelper {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceGlobalDataServiceHelperImpl.class);

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	LocationService locationService;

	@Autowired
	ConnectionModeRepository connectionModeRepository;

	@Autowired
	DefaultServicePortMappingService defaultServicePortMappingService;

	@Autowired
	LanguageRepository languageRepository;

	@Autowired
	QoeGlobalSettingRepository qoeGlobalSettingRepository;

	@Autowired
	ModelVersionService hardwareVersionService;

	@Autowired
	InterProcessCommunicationService interProcessCommunicationService;

	@Value("${global.install.document.id:1}")
	private String globalInstallDocumentId;

	/**
	 * Processes all the database operations.
	 * 
	 * @param updateGlobalData
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void processDBOperations(UpdateGlobalData updateGlobalData) {

		LOGGER.logMessage("processDBOperations++");

		updateLanguages(updateGlobalData);

		locationService.updateLocations(updateGlobalData);

		boolean connectionModeExecuted = updateConnectionMode(updateGlobalData);

		boolean defaultPortMappingExecuted = defaultServicePortMappingService
				.updateDefaultServicePortMappings(updateGlobalData);

		boolean qoeGlobalSettingExecuted = updateGlobalQoESettings(updateGlobalData);

		hardwareVersionService.updateHardwareVersions(updateGlobalData);

		if (defaultPortMappingExecuted || qoeGlobalSettingExecuted || connectionModeExecuted) {
			interProcessCommunicationService.generateGlobalInstallDocument(globalInstallDocumentId);
		}

		LOGGER.logMessage("processDBOperations--");
	}

	/**
	 * Saves or updates languages.
	 * 
	 * @param updateGlobalData
	 */
	private void updateLanguages(UpdateGlobalData updateGlobalData) {

		List<Language> languages = updateGlobalData.getGlobalData().getLanguages();

		if (languages != null) {

			LOGGER.logMessage("updateLanguages++");

			languageRepository.deleteAll();

			languages.stream().forEach(language -> {

				DeviceGlobalDataServiceUtil.printLogForLanguage(language);
				com.accenture.avs.device.entity.Language lang = new com.accenture.avs.device.entity.Language();
				lang.setType(language.getType());
				lang.setName(language.getDisplayName());
				lang.setAvailableForAudio(Boolean.valueOf(language.getAvailableForAudio()));
				lang.setAvailableForui(Boolean.valueOf(language.getAvailableForUI()));
				TenantContext.setCurrentTenant(Tenants.WRITE);
				languageRepository.save(lang);
			});

			LOGGER.logMessage("updateLanguages--");
		}
	}

	/**
	 * Saves or updates connection modes in the database.
	 * 
	 * @param updateGlobalData
	 *            return boolean
	 */
	private boolean updateConnectionMode(UpdateGlobalData updateGlobalData) {

		boolean connectionModeExecuted = false;
		List<com.accenture.avs.device.json.object.devicemanager.ConnectionMode> connectionModes = updateGlobalData
				.getGlobalData().getConnectionModes();

		if (connectionModes != null && !connectionModes.isEmpty()) {

			LOGGER.logMessage("updateConnectionMode++");

			Map<String, String> connectionModemap = new HashMap<>();
			connectionModes.stream().forEach(connectionMode -> {
				DeviceGlobalDataServiceUtil.printLogForConnectionMode(connectionMode);
				connectionModemap.put(connectionMode.getName().toString(), connectionMode.getStatus().toString());
			});

			List<String> requestedConnectionModeNames = new ArrayList<String>();

			Iterator<Entry<String, String>> iterator = connectionModemap.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<String, String> entry = iterator.next();
				requestedConnectionModeNames.add(entry.getKey());
			}

			requestedConnectionModeNames.stream().forEach(requestedconnectionName -> {
				saveOrUpdateConnectionMode(connectionModemap, requestedconnectionName);
			});

			connectionModeExecuted = true;

			LOGGER.logMessage("updateConnectionMode--");
		}
		return connectionModeExecuted;
	}

	/**
	 * Updates global qoe settingS data in the database.
	 * 
	 * @param updateGlobalData
	 *            return boolean
	 */
	private boolean updateGlobalQoESettings(UpdateGlobalData updateGlobalData) {

		boolean qoeGlobalSettingExecuted = false;
		GlobalQoESettings globalQoESettingsJson = updateGlobalData.getGlobalData().getGlobalQoESettings();

		if (globalQoESettingsJson != null) {

			LOGGER.logMessage("updateGlobalQoESettings++");

			DeviceGlobalDataServiceUtil.printLogForQOEGlobalSetting(globalQoESettingsJson);

			TenantContext.setCurrentTenant(Tenants.READ);
			List<QoeGlobalSetting> qoeGlobalSettings = qoeGlobalSettingRepository.findAll();

			QoeGlobalSetting qoeGlobalSetting = null;
			if (qoeGlobalSettings.isEmpty()) {
				qoeGlobalSetting = new QoeGlobalSetting();
			} else {
				qoeGlobalSetting = qoeGlobalSettings.get(0);
			}

			qoeGlobalSetting.setAllowRccOverSubscription(globalQoESettingsJson.getAllowRCCOverSubscription());
			qoeGlobalSetting.setQoeRetEnableDefault(globalQoESettingsJson.getQoeRETEnableDefault());
			qoeGlobalSetting.setQoeRccEnableDefault(globalQoESettingsJson.getQoeRCCEnableDefault());
			TenantContext.setCurrentTenant(Tenants.WRITE);
			qoeGlobalSettingRepository.save(qoeGlobalSetting);
			qoeGlobalSettingExecuted = true;
			LOGGER.logMessage("updateGlobalQoESettings--");
		}

		return qoeGlobalSettingExecuted;
	}

	/**
	 * saves or updates the connection mode.
	 * 
	 * @param connectionModemap
	 * @param requestedconnectionName
	 */
	private void saveOrUpdateConnectionMode(Map<String, String> connectionModemap, String requestedconnectionName) {

		LOGGER.logMessage("saveOrUpdateConnectionMode++");

		ConnectionMode connModeToSave = connectionModeRepository.findByName(requestedconnectionName);
		connModeToSave.setName(requestedconnectionName);
		connModeToSave.setStatus(connectionModemap.get(requestedconnectionName));
		TenantContext.setCurrentTenant(Tenants.WRITE);
		connectionModeRepository.save(connModeToSave);

		LOGGER.logMessage("saveOrUpdateConnectionMode--");
	}
}
