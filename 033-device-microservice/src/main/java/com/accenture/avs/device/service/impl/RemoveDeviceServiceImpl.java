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

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.config.SystemMessage;
import com.accenture.avs.device.config.client.ConfigurationClient;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.ResultObject;
import com.accenture.avs.device.json.object.devicemanager.STBDeletion;
import com.accenture.avs.device.json.object.devicemanager.SetTopBoxDelete;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.service.RemoveDeviceService;
import com.accenture.avs.device.service.UpdateRemoveDeviceServiceHelper;
import com.accenture.avs.device.util.RequestResponseGenerator;

/**
 * @author rajesh.karna
 *
 */
@Service
public class RemoveDeviceServiceImpl implements RemoveDeviceService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(RemoveDeviceServiceImpl.class);

	/** deviceRepository */
	@Autowired
	DeviceRepository deviceRepository;
	
	/** updateRemoveDeviceServiceHelper */
	@Autowired
	UpdateRemoveDeviceServiceHelper updateRemoveDeviceServiceHelper;
	
	/** configClient */
	@Autowired
	private ConfigurationClient configClient;

	/** EXT_IP_ADDRESS */
	private static final String EXT_IP_ADDRESS = "ExtIPAddress";

	/** EQUIPMENT_ID */
	private static final String EQUIPMENT_ID = "EquipmentId";

	/** MAC_ADDRESS */
	private static final String MAC_ADDRESS = "MACAddress";

	/**
	 * Removes Devices.
	 * 
	 * @param deviceDelete
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse removeDevices(SetTopBoxDelete deviceDelete) {

		Long startTime = System.currentTimeMillis();		
		int successfulRequests = 0;
		int failedRequests = 0;

		List<ResultObject> resultObjectList = new ArrayList<>();

		for (STBDeletion deviceDeletion : deviceDelete.getSTBDeletions()) {

			try {
				printDeleteStbLog(deviceDeletion);
				if (EXT_IP_ADDRESS.equals(deviceDeletion.getIdType().value())) {

					validateDeleteDeviceForIdTypeExtIpAddressAndGetListOfDevices(deviceDeletion).stream()
							.forEach(device -> {
								updateRemoveDeviceServiceHelper.removeDevice(device);
							});
				} else {

					updateRemoveDeviceServiceHelper.removeDevice(validateDeleteDeviceForIdTypeMacAddressOrEquipmentIdAndGetDevice(deviceDeletion));
				}
				RequestResponseGenerator.getGenericResultObject(resultObjectList, deviceDeletion.getValue(),
						(String) IdentificationType.genericSuccessResultCode
								.toDataType(IdentificationType.genericSuccessResultCode.getProperty()),
						(String) IdentificationType.genericSuccessResultDescription
								.toDataType(IdentificationType.genericSuccessResultDescription.getProperty()));
				successfulRequests++;
			} catch (DeviceManagerException stbException) {
				SystemMessage sysMessage = configClient.findSystemMessage(IdentificationType.defaultLanguage.getProperty(),
						stbException.getErrorCode().getCode());
				LOGGER.logMessage("Device removal failed.", stbException);
				RequestResponseGenerator.getGenericResultObject(resultObjectList, deviceDeletion.getValue(),
						sysMessage.getMessageCode(), sysMessage.getMessageText());
				failedRequests++;
			}
		}

		Long executionTime = System.currentTimeMillis() - startTime;
		GenericResponse genericResponseForB2B = RequestResponseGenerator
				.getGenericResponse(resultObjectList, successfulRequests, failedRequests, executionTime);

		LOGGER.logMethodEnd(executionTime);
		return genericResponseForB2B;
	}

	/**
	 * Validate Delete Device for IdType MacAddress or EquipmentId and gets
	 * Devices.
	 * 
	 * @param deviceDeletion
	 * @return device
	 */
	private Device validateDeleteDeviceForIdTypeMacAddressOrEquipmentIdAndGetDevice(STBDeletion deviceDeletion) {

		Device device = null;
		String idTypeName = deviceDeletion.getIdType().value();
		String value = deviceDeletion.getValue();

		if (EQUIPMENT_ID.equals(idTypeName)) {
			if (value == null || !value.matches("\\d*")) {
				throw new DeviceManagerException(ErrorCode.INVALID_PARAM);
			}
		}

		if (MAC_ADDRESS.equals(idTypeName)) {
			device = deviceRepository.findByDeviceId(value);
		} else if (EQUIPMENT_ID.equals(idTypeName)) {
			device = deviceRepository.findById(Long.valueOf(value));
		}

		if (device == null) {
			throw new DeviceManagerException(ErrorCode.DEVICE_NOT_FOUND);
		}

		return device;
	}

	/**
	 * Validate Delete Device for IdType ExtIPAddress and gets list of Devices.
	 * 
	 * @param deviceDeletion
	 * @return devices
	 */
	private List<Device> validateDeleteDeviceForIdTypeExtIpAddressAndGetListOfDevices(STBDeletion deviceDeletion) {

		String value = deviceDeletion.getValue();
		
		if (value == null) {
			throw new DeviceManagerException(ErrorCode.INVALID_PARAM);
		}
		
		List<Device> devices = deviceRepository.findByExternalIpAddress(value);

		if (devices.isEmpty()) {
			throw new DeviceManagerException(ErrorCode.DEVICE_NOT_FOUND);
		}
		return devices;
	}

	/**
	 * Prints Delete Device log.
	 * 
	 * @param deviceDeletion
	 */
	private void printDeleteStbLog(STBDeletion deviceDeletion) {
		StringBuilder stringBuilder = new StringBuilder("\nDelete device with following parameters:");
		stringBuilder.append("\nIdType = ");
		stringBuilder.append(deviceDeletion.getIdType());
		stringBuilder.append("\nValue = ");
		stringBuilder.append(deviceDeletion.getValue());
		LOGGER.logMessage(stringBuilder.toString());
	}
}
