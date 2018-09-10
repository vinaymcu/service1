/***************************************************************************
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
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.DefaultServicePortMapping;
import com.accenture.avs.device.entity.ServiceHardwareMapping;
import com.accenture.avs.device.entity.ServiceHardwareMappingId;
import com.accenture.avs.device.json.object.devicemanager.DefaultPortMapping;
import com.accenture.avs.device.json.object.devicemanager.STBHWVersions;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;
import com.accenture.avs.device.repository.CustomServiceHardwareMappingRepository;
import com.accenture.avs.device.repository.DefaultServicePortMappingRepository;
import com.accenture.avs.device.repository.ServiceHardwareMappingRepository;

import com.accenture.avs.device.service.DefaultServicePortMappingService;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;

/**
 * @author rajesh.karna
 *
 */
@Service
public class DefaultServicePortMappingServiceImpl implements DefaultServicePortMappingService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DefaultServicePortMappingServiceImpl.class);

	@Autowired
	DefaultServicePortMappingRepository defaultServicePortMappingRepository;

	@Autowired
	ServiceHardwareMappingRepository serviceHardwareMappingRepository;

	/** STB_TRIGGER_UPDATE */
	private static final String STB_TRIGGER_UPDATE = "STB Trigger Update";

	/** SECURE_SHELL */
	private static final String SECURE_SHELL = "Secure Shell";

	/** DEFAULT_SERVICE */
	private static final boolean DEFAULT_SERVICE = false;

	/** ALL */
	private static final String ALL = "ALL";

	/** UNICAST_PUSH_MESSAGING */
	private static final String UNICAST_PUSH_MESSAGING = "UnicastPushMessaging";

	/** TRUE */
	private static final boolean TRUE = true;
	
	/** DEFAULT_SERVICE_NAMES */
	private static final List<String> DEFAULT_SERVICE_NAMES = Arrays.asList(STB_TRIGGER_UPDATE, SECURE_SHELL, UNICAST_PUSH_MESSAGING);
	
	@Autowired
	CustomServiceHardwareMappingRepository customServiceHardwareMappingRepository;

	@Override
	/**
	 * Saves or updates default service port mapping data.
	 * 
	 * @param updateGlobalData
	 * @return boolean
	 */
	public boolean updateDefaultServicePortMappings(UpdateGlobalData updateGlobalData) {

		LOGGER.logMessage("updateDefaultServicePortMappings++");

		boolean defaultPortMappingExecuted = false;

		if (updateGlobalData.getGlobalData().getDefaultPortMappings() != null) {

			List<DefaultPortMapping> defaultPortMappings = updateGlobalData.getGlobalData().getDefaultPortMappings();

			defaultPortMappings.stream()
					.forEach(servicePortMapping -> updateDefaultServicePortMapping(servicePortMapping));

			List<String> serviceNamesInRequest = defaultPortMappings.stream()
					.map(servicePortMapping -> servicePortMapping.getServiceName()).collect(Collectors.toList());

			List<String> serviceProtMappingsToBeDeleted = new ArrayList<>();
			defaultServicePortMappingRepository.findAll().stream().forEach(servicePortMapping -> {
				if (!serviceNamesInRequest.contains(servicePortMapping.getServiceName())
						&& !DEFAULT_SERVICE_NAMES.contains(servicePortMapping.getServiceName())
						&& !servicePortMapping.getDefaultService()) {

					serviceProtMappingsToBeDeleted.add(servicePortMapping.getServiceName());
				}
			});

			serviceProtMappingsToBeDeleted.stream()
					.forEach(serviceName -> defaultServicePortMappingRepository.deleteByServiceName(serviceName));

			if (!defaultPortMappings.isEmpty()) {
				defaultPortMappingExecuted = TRUE;
			}
		}

		LOGGER.logMessage("updateDefaultServicePortMappings--");
		return defaultPortMappingExecuted;
	}

	/**
	 * Saves or updates default service port mapping data in the database.
	 * 
	 * @param defaultPortMapping
	 */
	private void updateDefaultServicePortMapping(DefaultPortMapping defaultPortMapping) {

		printLogForServicePortMapping(defaultPortMapping);
		DefaultServicePortMapping defaultServicePortMapping = defaultServicePortMappingRepository
				.findByServiceName(defaultPortMapping.getServiceName());

		if (defaultServicePortMapping == null) {
			defaultServicePortMapping = new DefaultServicePortMapping();
		}

		defaultServicePortMapping.setServiceName(defaultPortMapping.getServiceName());
		defaultServicePortMapping.setDefaultInternalPort(defaultPortMapping.getDefaultInternalPort().longValue());
		defaultServicePortMapping.setDefaultExternalPort(defaultPortMapping.getDefaultExternalPort().longValue());
		defaultServicePortMapping.setProtocol(defaultPortMapping.getProtocol());
		defaultServicePortMapping.setDefaultService(DEFAULT_SERVICE);

		TenantContext.setCurrentTenant(Tenants.WRITE);
		defaultServicePortMappingRepository.save(defaultServicePortMapping);

		STBHWVersions deviceHwVersions = defaultPortMapping.getSTBHWVersions();

		if (deviceHwVersions != null) {
			Long serviceId = defaultServicePortMapping.getServiceId();
			customServiceHardwareMappingRepository.deleteServiceHardwareMappingByServiceId(serviceId);
			boolean allHardware = false;
			if (deviceHwVersions.getAllHardwares() != null && deviceHwVersions.getAllHardwares().booleanValue() == TRUE) {
				allHardware = TRUE;
			} else if (deviceHwVersions.getSTBHWVersion() == null) {
				allHardware = TRUE;
			} else {
				List<String> deviceHwNames = deviceHwVersions.getSTBHWVersion();
				for (String deviceHwName : deviceHwNames) {
					updateServiceHardwareMapping(serviceId, deviceHwName);
				}
			}

			if (allHardware) {
				updateServiceHardwareMapping(serviceId, ALL);
			}
		}
	}

	/**
	 * Saves or updates service hardware mapping data in the database.
	 * 
	 * @param serviceId
	 * @param deviceHardwareVersion
	 */
	private void updateServiceHardwareMapping(Long serviceId, String deviceHardwareVersion) {
		printLogForServiceHardwareMapping(serviceId, deviceHardwareVersion);
		ServiceHardwareMapping serviceHardwareMapping = new ServiceHardwareMapping();
		ServiceHardwareMappingId serviceHardwareMappingId = new ServiceHardwareMappingId(serviceId, deviceHardwareVersion);
		serviceHardwareMapping.setId(serviceHardwareMappingId);
		TenantContext.setCurrentTenant(Tenants.WRITE);
		serviceHardwareMappingRepository.save(serviceHardwareMapping);
	}

	/**
	 * Prints log for Service Port Mapping.
	 * 
	 * @param defaultPortMapping
	 */
	public static void printLogForServicePortMapping(DefaultPortMapping defaultPortMapping) {
		StringBuilder stringBuilder = new StringBuilder("Service Port Mapping with the following parameters:");
		stringBuilder.append("\nServiceName = ");
		stringBuilder.append(defaultPortMapping.getServiceName());
		stringBuilder.append("\nDefaultInternalPort = ");
		stringBuilder.append(defaultPortMapping.getDefaultInternalPort());
		stringBuilder.append("\nDefaultExternalPort = ");
		stringBuilder.append(defaultPortMapping.getDefaultExternalPort());
		stringBuilder.append("\nProtocol = ");
		stringBuilder.append(defaultPortMapping.getProtocol());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Prints log for Service Hardware Mapping.
	 * 
	 * @param serviceId
	 * @param deviceHardwareVersion
	 */
	public static void printLogForServiceHardwareMapping(Long serviceId, String deviceHardwareVersion) {
		StringBuilder stringBuilder = new StringBuilder("Service Hardware Mapping with the following parameters:");
		stringBuilder.append("\nServiceId = ");
		stringBuilder.append(serviceId);
		stringBuilder.append("\nstbHardwareVersion = ");
		stringBuilder.append(deviceHardwareVersion);
		LOGGER.logMessage(stringBuilder.toString());
	}
}
