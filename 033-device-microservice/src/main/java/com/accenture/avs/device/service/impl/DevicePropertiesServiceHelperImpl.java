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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.avs.device.entity.DefaultServicePortMapping;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceServicePortMapping;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.STBPortMapping;
import com.accenture.avs.device.json.object.devicemanager.STBPortMappings;
import com.accenture.avs.device.repository.DefaultServicePortMappingRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.DeviceServicePortMappingRepository;
import com.accenture.avs.device.service.DevicePropertiesServiceHelper;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.EntityObjectGenerator;

/**
 * This is a Helper Class for DevicePropertiesServiceImpl.
 * 
 * @author Singh.Saurabh
 *
 */
@Service
public class DevicePropertiesServiceHelperImpl implements DevicePropertiesServiceHelper {

	/** defaultServicePortMappingRepository */
	@Autowired
	private DefaultServicePortMappingRepository defaultServicePortMappingRepository;

	/** deviceServicePortMappingRepository */
	@Autowired
	private DeviceServicePortMappingRepository deviceServicePortMappingRepository;

	/** deviceRepository */
	@Autowired
	private DeviceRepository deviceRepository;

	/**
	 * This method gets the Default Service Port Mappings from database.
	 * 
	 * @param prop
	 * 
	 * @return DefaultServicePortMapping
	 */
	@Override
	public DefaultServicePortMapping getDefaultServicePortMapping(STBPortMapping prop) {
		DefaultServicePortMapping defaultServicePortMapping = defaultServicePortMappingRepository
				.findByServiceName(prop.getServiceType());
		if (DeviceManagerUtil.checkNullObject(defaultServicePortMapping)) {
			throw new DeviceManagerException(ErrorCode.INVALID_SERVICE_TYPE,
					"Wrong ServiceType = " + prop.getServiceType() + " provided");
		}
		return defaultServicePortMapping;
	}

	/**
	 * This method validates and save Device Service Port Mappings
	 * 
	 * @param devicePortMappings
	 * @param equipmentId
	 * @param connectionModeId
	 */
	@Override
	public void validateAndSaveServicePortMappings(STBPortMappings devicePortMappings, Long equipmentId,
			Long connectionModeId) {
		List<DeviceServicePortMapping> deviceServicePortMappingList = new ArrayList<>();
		for (STBPortMapping devicePortMapping : devicePortMappings.getSTBPortMappings()) {
			Long newInternalPort = devicePortMapping.getInternalPort().longValue();
			Long newExternalPort = devicePortMapping.getExternalPort().longValue();
			DefaultServicePortMapping defaultServicePortMapping = getDefaultServicePortMapping(devicePortMapping);
			if (connectionModeId.equals(IdentificationType.connectionModeBridgedId
					.toDataType(IdentificationType.connectionModeBridgedId.getProperty()))) {
				// set internal and external port to internal port provided in the request
				newInternalPort = devicePortMapping.getInternalPort().longValue();
				newExternalPort = devicePortMapping.getInternalPort().longValue();
			}
			deviceServicePortMappingList.add(EntityObjectGenerator.getStbServicePortMappingEntity(equipmentId,
					defaultServicePortMapping.getServiceId(), newInternalPort, newExternalPort));
		}
		deviceServicePortMappingRepository.save(deviceServicePortMappingList);
	}

	/**
	 * This method validate macAddress/SubscriberId and returns Device.
	 * 
	 * @param macAddress
	 * @param subscriberId
	 * 
	 * @return Device
	 */
	@Override
	public Device validateDeviceAndSubscriber(String macAddress, String subscriberId) {

		Device deviceEntity = deviceRepository.findByDeviceId(macAddress);

		// Device validation
		if (DeviceManagerUtil.checkNullObject(deviceEntity)) {
			throw new DeviceManagerException(ErrorCode.NO_DEVICE_FOUND,
					"Device with MACAddress=" + macAddress + " doesn't exists");
		}

		// Subscriber Validation
/*		if (DeviceManagerUtil.checkNullObject(deviceEntity.getAssignedToSubscriber())
				|| !subscriberId.equals(deviceEntity.getAssignedToSubscriber().getSubscriberId())) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_FOUND,
					"Device with MACAddress=" + macAddress + " is not assigned to SubscriberId=" + subscriberId);
		}*/
		return deviceEntity;
	}

}
