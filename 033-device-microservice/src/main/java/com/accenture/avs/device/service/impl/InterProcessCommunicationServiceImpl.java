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

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.client.DocumentManagerClient;
import com.accenture.avs.device.client.ResourceManagerClient;
import com.accenture.avs.device.client.PushMessageClient;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.json.object.resourcemanager.ConfigurationDataUpdate;
import com.accenture.avs.device.json.object.resourcemanager.GetProfileReq;
import com.accenture.avs.device.json.object.resourcemanager.STBProfile;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdateRequest;
import com.accenture.avs.device.service.InterProcessCommunicationService;
import com.accenture.avs.device.util.DeviceGlobalDataServiceUtil;

/**
 * @author rajesh.karna
 *
 */
@Service
public class InterProcessCommunicationServiceImpl implements InterProcessCommunicationService {
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(InterProcessCommunicationServiceImpl.class);

	@Autowired
	ResourceManagerClient resourceManagerFeignClient;

	@Autowired
	PushMessageClient unicastnotifierFeignClient;

	@Autowired
	DocumentManagerClient documentManagerFeignClient;

	@Value("${notification.retrial.interval:200}")
	long notificationRetrialInterval;

	/** ONE_THOUSAND */
	private static final int ONE_THOUSAND = 1000;

	/**
	 * Sends notification using unicast notifier service on the basis of
	 * eventUpdateRequest and notificationRetrials.
	 * 
	 * @param eventUpdateRequest
	 * @param notificationRetrials
	 */
	@Override
	public void notifyDevices(EventUpdateRequest eventUpdateRequest, int notificationRetrials) {

		LOGGER.logMessage("notifyDevices++");

		try {
			unicastnotifierFeignClient.trigger(eventUpdateRequest);
		} catch (Exception exception) {

			LOGGER.logMessage("Notification to Device(s) could not be sent as there is problem in"
					+ " communication with unicast notifier service.", exception);

			if (notificationRetrials != 0) {
				try {
					TimeUnit.MILLISECONDS.sleep(
							notificationRetrialInterval > ONE_THOUSAND ? ONE_THOUSAND : notificationRetrialInterval);
				} catch (InterruptedException interruptedException) {
					LOGGER.logMessage("InterruptedException", interruptedException);
				}
				int retrials = notificationRetrials - 1;
				notifyDevices(eventUpdateRequest, retrials);
			}
		}
		LOGGER.logMessage("notifyDevices--");
	}

	/**
	 * Gets device profile data from resource manager.
	 * 
	 * @param subscriberList
	 * @param subscriberId
	 * 
	 * @return deviceProfile
	 */
	@Override
	public STBProfile getDeviceProfile(GetProfileReq getProfileReq, String subscriberId) {

		LOGGER.logMessage("getDeviceProfile++");
		STBProfile deviceProfile = resourceManagerFeignClient.getDeviceProfile(getProfileReq, subscriberId).getBody();
		LOGGER.logMessage("getDeviceProfile--");
		return deviceProfile;
	}

	/**
	 * Sends request to resource Manager to update config data.
	 * 
	 * @param ConfigurationDataUpdate
	 */
	@Override
	public void sendReqToResourceMgrToUpdConfigData(ConfigurationDataUpdate ConfigurationDataUpdate) {

		LOGGER.logMessage("sendReqToResourceMgrToUpdConfigData++");

		try {
			GenericResponse genericResponseForB2B = resourceManagerFeignClient
					.resourceManagerConfigData(ConfigurationDataUpdate).getBody();

			if (!DeviceGlobalDataServiceUtil.isResponseResultCodeValid((String) genericResponseForB2B.getResultCode())) {
				LOGGER.logMessage("Status code retured from resource manager service is not OK.");
				if (hardwareVersionAvailable(ConfigurationDataUpdate)) {
					throw new DeviceManagerException(ErrorCode.HARDWARE_VERSION_UPDATE_FAILED);
				}
			}
		} catch (Exception exception) {

			LOGGER.logMessage(
					"Configuration data could not be sent for saving as there is no communication with resource manager service.",
					exception);

			if (hardwareVersionAvailable(ConfigurationDataUpdate)) {
				throw new DeviceManagerException(ErrorCode.HARDWARE_VERSION_UPDATE_FAILED, exception);
			}
		}
		LOGGER.logMessage("sendReqToResourceMgrToUpdConfigData--");
	}

	/**
	 * Checks whether hardware version available in the UpdateConfigurationData
	 * data.
	 * 
	 * @param configurationDataUpdate
	 * @return boolean
	 */
	private boolean hardwareVersionAvailable(ConfigurationDataUpdate configurationDataUpdate) {
		return configurationDataUpdate.getUpdateConfigurationData() != null
				&& configurationDataUpdate.getUpdateConfigurationData().getHWList() != null
				&& !configurationDataUpdate.getUpdateConfigurationData().getHWList().isEmpty();
	}

	/**
	 * Sends request to document manager for the generation of global install
	 * document.
	 * 
	 * @param globalInstallDocumentId
	 */
	@Override
	public void generateGlobalInstallDocument(String globalInstallDocumentId) {

		LOGGER.logMessage("generateGlobalInstallDocument++");

		try {
			GenericResponse genericResponseForB2B = documentManagerFeignClient
					.generateDocument(globalInstallDocumentId).getBody();
			if (!DeviceGlobalDataServiceUtil.isResponseResultCodeValid(
					(String) genericResponseForB2B.getResultObj().get(0).getResultCode())) {
				LOGGER.logMessage("Global document generation failed as response code returned is not ok.");
			}

		} catch (Exception exception) {
			LOGGER.logMessage("Global document generation failed as there is no communication with document manager servcie.",
					exception);
		}
		LOGGER.logMessage("generateGlobalInstallDocument--");
	}
}
