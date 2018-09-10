/*****************************************************************************
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
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.config.SystemMessage;
import com.accenture.avs.device.config.client.ConfigurationClient;
import com.accenture.avs.device.entity.DefaultServicePortMapping;
import com.accenture.avs.device.entity.ServiceHardwareMapping;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.json.object.devicemanager.AvaliableResources;
import com.accenture.avs.device.json.object.devicemanager.ConnectionMode;
import com.accenture.avs.device.json.object.devicemanager.DefaultPortMapping;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.HWList;
import com.accenture.avs.device.json.object.devicemanager.ParameterList;
import com.accenture.avs.device.json.object.devicemanager.STBGlobalData;
import com.accenture.avs.device.json.object.devicemanager.STBHWVersions;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;
import com.accenture.avs.device.repository.ConnectionModeRepository;
import com.accenture.avs.device.repository.DefaultServicePortMappingRepository;
import com.accenture.avs.device.repository.ModelRepository;
import com.accenture.avs.device.repository.ResourcesRepository;
import com.accenture.avs.device.repository.ServiceHardwareMappingRepository;
import com.accenture.avs.device.service.StbGlobalDataService;
import com.accenture.avs.device.service.DeviceGlobalDataServiceHelper;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.DeviceGlobalDataServiceUtil;

/**
 * STB Global data service class.
 * 
 * @author rajesh.karna
 *
 */
@Service
public class StbGlobalDataServiceImpl implements StbGlobalDataService {/*

	private static final String ALL = "ALL";

	*//** Instance of LoggerWrapper for logging purpose *//*
	private static final LoggerWrapper LOGGER = new LoggerWrapper(StbGlobalDataServiceImpl.class);

	*//** configClient *//*
	@Autowired
	private ConfigurationClient configClient;

	@Autowired
	StbGlobalDataServiceHelper stbGlobalDataServiceHelper;

	@Autowired
	ConnectionModeRepository connectionModeRepository;

	@Autowired
	DefaultServicePortMappingRepository defaultServicePortMappingRepository;

	@Autowired
	ServiceHardwareMappingRepository serviceHardwareMappingRepository;

	@Autowired
	ResourcesRepository resourcesRepository;

	@Autowired
	HardwareVersionRepository hardwareVersionRepository;

	*//** DEFAULT_PORT_MAPPING *//*
	private static final String DEFAULT_PORT_MAPPING = "DefaultPortMappings";

	*//** CONNECTION_MODES *//*
	private static final String CONNECTION_MODES = "ConnectionModes";

	*//** PARAMETER_LIST *//*
	private static final String PARAMETER_LIST = "ParameterList";

	*//** REQUIRED_DATA *//*
	private static final List<String> REQUIRED_DATA = Arrays.asList(DEFAULT_PORT_MAPPING, CONNECTION_MODES,
			PARAMETER_LIST);

	*//** UPNP_NAPT *//*
	private static final String UPNP_NAPT = "UPnP NAPT";

	*//** IMPLICIT_NAT *//*
	private static final String IMPLICIT_NAT = "Implicit NAT";

	*//** BRIDGED *//*
	private static final String BRIDGED = "Bridged";

	*//** ENABLED *//*
	private static final String ENABLED = "Enabled";

	*//** DISABLED *//*
	private static final String DISABLED = "Disabled";

	*//**
	 * Creates/Updates STB global data.
	 * 
	 * @param updateGlobalData
	 * @return GenericResponse
	 *//*
	@Override
	public GenericResponse updateSTBGlobalData(UpdateGlobalData updateGlobalData) {

		Long startTime = System.currentTimeMillis();

		LOGGER.logMessage("updateSTBGlobalData++");

		GenericResponse genericResponseForB2B = new GenericResponse();

		try {

			StbGlobalDataServiceUtil.validateUpdateGlobalData(updateGlobalData);

			stbGlobalDataServiceHelper.processDBOperations(updateGlobalData);

			StbGlobalDataServiceUtil.generateResponseForSuccessfullRequset(genericResponseForB2B);
		} catch (STBException stbException) {
			LOGGER.logError(stbException, "Update STB Global data failed.");
			SystemMessage sysMessage = configClient.findSystemMessage(IdentificationType.defaultLanguage.getProperty(),
					stbException.getErrorCode().getCode());
			StbGlobalDataServiceUtil.generateResponseForSTBException(genericResponseForB2B, sysMessage.getMessageCode(),
					sysMessage.getMessageText());
		}

		LOGGER.logMethodEnd(System.currentTimeMillis() - startTime);
		return genericResponseForB2B;
	}

	*//**
	 * Gets STB global data.
	 * 
	 * @param requiredData
	 * @return STBGlobalData
	 *//*
	@Override
	public STBGlobalData getSTBGlobalData(String requiredData) {
		Long startTime = System.currentTimeMillis();
		LOGGER.logMessage("getSTBGlobalData++\nrequiredData:: " + requiredData);
		validateRequiredData(requiredData);
		LOGGER.logMethodEnd(System.currentTimeMillis() - startTime);
		return getStbGlobalDataResponse(requiredData);
	}

	*//**
	 * Validates requiredData.
	 * 
	 * @param requiredData
	 *//*
	private void validateRequiredData(String requiredData) {

		if (requiredData != null) {
			Arrays.stream(requiredData.split(",")).forEach(data -> {

				if (!REQUIRED_DATA.contains(data)) {

					throw new STBException(ErrorCode.REQUEST_VALIDATION_FAILED);
				}
			});
		}

	}

	*//**
	 * Gets StbGlobalData response.
	 * 
	 * @param requiredData
	 * @return STBGlobalData
	 *//*
	private STBGlobalData getStbGlobalDataResponse(String requiredData) {

		STBGlobalData stbGlobalData = new STBGlobalData();

		stbGlobalData.setConnectionModes(null);
		stbGlobalData.setDefaultPortMappings(null);
		stbGlobalData.setParameterList(null);
		
		if (requiredData == null) {

			stbGlobalData.setConnectionModes(getConnectionModes());
			stbGlobalData.setDefaultPortMappings(getDefaultPortMappings());
			stbGlobalData.setParameterList(getParameterList());
		} else {
			Arrays.stream(requiredData.split(",")).forEach(data -> {

				if (CONNECTION_MODES.equals(data)) {

					stbGlobalData.setConnectionModes(getConnectionModes());
				} else if (DEFAULT_PORT_MAPPING.equals(data)) {

					stbGlobalData.setDefaultPortMappings(getDefaultPortMappings());
				} else if (PARAMETER_LIST.equals(data)) {

					stbGlobalData.setParameterList(getParameterList());
				}
			});
		}

		return stbGlobalData;
	}

	*//**
	 * Gets ParameterList.
	 * 
	 * @return ParameterList
	 *//*
	private ParameterList getParameterList() {
		ParameterList parameterList = new ParameterList();
		AvaliableResources avaliableResources = new AvaliableResources();
		List<String> resourceNames = new ArrayList<>();

		resourcesRepository.findAll().stream().forEach(resource -> {

			resourceNames.add(resource.getId().getName());
		});

		avaliableResources.setName(resourceNames);
		parameterList.setAvaliableResources(avaliableResources);
		HWList hWList = new HWList();
		List<String> hwNames = new ArrayList<>();
		hardwareVersionRepository.findAll().stream().forEach(hardwareVersion -> {

			hwNames.add(hardwareVersion.getHardwareName());
		});
		hWList.setName(hwNames);
		parameterList.setHWList(hWList);
		return parameterList;
	}

	*//**
	 * Gets list of DefaultPortMapping.
	 * 
	 * @return List<DefaultPortMapping>
	 *//*
	private List<DefaultPortMapping> getDefaultPortMappings() {
		List<DefaultPortMapping> defaultPortMappings = new ArrayList<>();

		defaultServicePortMappingRepository.findAll().stream().forEach(defaultPortMappingFromDB -> {

			defaultPortMappings.add(getDefaultPortMapping(defaultPortMappingFromDB));
		});

		return defaultPortMappings;
	}

	*//**
	 * Gets DefaultPortMapping.
	 * 
	 * @param defaultPortMappingFromDB
	 * @return DefaultPortMapping
	 *//*
	private DefaultPortMapping getDefaultPortMapping(DefaultServicePortMapping defaultPortMappingFromDB) {

		DefaultPortMapping defaultPortMapping = new DefaultPortMapping();
		defaultPortMapping.setDefaultExternalPort(
				STBManagerUtil.getIntegerFromLong(defaultPortMappingFromDB.getDefaultExternalPort()));
		defaultPortMapping.setDefaultInternalPort(
				STBManagerUtil.getIntegerFromLong(defaultPortMappingFromDB.getDefaultInternalPort()));
		defaultPortMapping.setProtocol(defaultPortMappingFromDB.getProtocol());
		defaultPortMapping.setServiceName(defaultPortMappingFromDB.getServiceName());

		STBHWVersions stbHWVersions = new STBHWVersions();
		List<String> stbHWVersion = new ArrayList<>();

		for (ServiceHardwareMapping serviceHardwareMapping : serviceHardwareMappingRepository
				.findByServiceId(defaultPortMappingFromDB.getServiceId())) {

			if (ALL.equals(serviceHardwareMapping.getId().getHardwareName())) {

				stbHWVersions.setAllHardwares(Boolean.TRUE);
				stbHWVersion = null;
			} else {

				stbHWVersion.add(serviceHardwareMapping.getId().getHardwareName());
			}
		}

		stbHWVersions.setSTBHWVersion(stbHWVersion);
		defaultPortMapping.setSTBHWVersions(stbHWVersions);
		return defaultPortMapping;
	}

	*//**
	 * Gets list of ConnectionMode.
	 * 
	 * @return List<ConnectionMode>
	 *//*
	private List<ConnectionMode> getConnectionModes() {
		List<ConnectionMode> connectionModes = new ArrayList<>();

		connectionModeRepository.findAll().stream().forEach(connectionModeFromDB -> {

			connectionModes.add(getConnectionMode(connectionModeFromDB));
		});

		return connectionModes;
	}

	*//**
	 * Gets ConnectionMode.
	 * 
	 * @param connectionModeFromDB
	 * @return ConnectionMode
	 *//*
	private ConnectionMode getConnectionMode(com.accenture.avs.device.entity.ConnectionMode connectionModeFromDB) {
		ConnectionMode connectionMode = new ConnectionMode();
		connectionMode.setName(getConnectionModeName(connectionModeFromDB.getName()));
		connectionMode.setStatus(getConnectionModeStatus(connectionModeFromDB.getStatus()));
		return connectionMode;
	}

	*//** Gets ConnectionMode.Name on the basis of connection mode name.
	 * 
	 * @param name
	 * @return ConnectionMode.Name
	 *//*
	private ConnectionMode.Name getConnectionModeName(String name) {

		ConnectionMode.Name connectionModeName = null;
		switch (name) {
		case BRIDGED:
			connectionModeName = ConnectionMode.Name.BRIDGED;
			break;
		case IMPLICIT_NAT:
			connectionModeName = ConnectionMode.Name.IMPLICIT_NAT;
			break;
		case UPNP_NAPT:
			connectionModeName = ConnectionMode.Name.U_PN_P_NAPT;
			break;
		default:
			break;
		}
		return connectionModeName;
	}

	*//** Gets ConnectionMode.Status on the basis of connection mode status.
	 * 
	 * @param status
	 * @return ConnectionMode.Status
	 *//*
	private ConnectionMode.Status getConnectionModeStatus(String status) {

		ConnectionMode.Status connectionModeStatus = null;
		switch (status) {
		case ENABLED:
			connectionModeStatus = ConnectionMode.Status.ENABLED;
			break;
		case DISABLED:
			connectionModeStatus = ConnectionMode.Status.DISABLED;
			break;
		default:
			break;
		}
		return connectionModeStatus;
	}
*/}
