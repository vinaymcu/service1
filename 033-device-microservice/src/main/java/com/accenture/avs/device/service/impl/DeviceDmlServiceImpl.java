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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.ConnectionMode;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.entity.Subscriber;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.AssignSTB;
import com.accenture.avs.device.json.object.devicemanager.DeviceDto;
import com.accenture.avs.device.json.object.devicemanager.STBAssignmentDetail;
import com.accenture.avs.device.json.object.devicemanager.STBRegistration;
import com.accenture.avs.device.json.object.devicemanager.UnassignSTB;
import com.accenture.avs.device.repository.DevicePropertyRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.DeviceServicePortMappingRepository;
import com.accenture.avs.device.repository.ResourcesRepository;
//import com.accenture.avs.device.repository.StbUdfRepository;
import com.accenture.avs.device.service.DeviceDmlService;
import com.accenture.avs.device.service.DeviceServiceHelper;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.DeviceManagerValidator;
import com.accenture.avs.device.util.EntityObjectGenerator;
import com.accenture.avs.device.util.NotificationDto;

/**
 * This class will perform Device management Operations like (CREATE, ASSIGN,
 * UNASSIGN, CREATEANDASSIGN AND AUTO-CONFIG)
 * 
 * @author Singh.Saurabh
 *
 */
@Service
public class DeviceDmlServiceImpl implements DeviceDmlService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceDmlServiceImpl.class);

	/** deviceServiceHelper */
	@Autowired
	private DeviceServiceHelper deviceServiceHelper;

	/** deviceRepository */
	@Autowired
	private DeviceRepository deviceRepository;

	/** devicePropertyRepository */
	@Autowired
	private DevicePropertyRepository devicePropertyRepository;
	
	/** deviceServicePortMappingRepository */
	@Autowired
	private DeviceServicePortMappingRepository deviceServicePortMappingRepository;

	/** stbUdfRepository */
//	@Autowired
//	private StbUdfRepository stbUdfRepository;
	
	/** resourcesRepository */
	@Autowired
	private ResourcesRepository resourcesRepository;
	
	/** deviceManagerValidator */
	@Autowired
	private DeviceManagerValidator deviceManagerValidator;
	
	/** isGlobalDataInSync */
	private boolean isGlobalDataInSync;

	/**
	 * This method validates and creates Device
	 * 
	 * @param deviceDto
	 * @param lastUpdateUserName
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createDevice(DeviceDto deviceDto, String lastUpdateUserName) {

		LOGGER.logMessage("Create Device :: DeviceId=" + deviceDto.getDeviceId());

		// Device Validation
		deviceManagerValidator.validateDeviceExistence(deviceDto.getDeviceId());

		// Device Model Validation
		Model deviceModel = deviceServiceHelper.getDeviceModel(deviceDto.getModel(), Boolean.TRUE);

		// Drm Id Validation
		deviceManagerValidator.validateDrmIdUniqueness(deviceDto.getDrmId(), deviceDto.getDeviceId());

		// Device Triplet Validation
		deviceManagerValidator.validateDeviceTripletUniqueness(deviceDto.getSerialNumber(), deviceDto.getModel(),
				deviceDto.getVendor(), deviceDto.getDeviceId());

		// Set platform and device type
		deviceDto.setPlatform(DeviceManagerUtil.getPlatformValue(deviceDto.getPlatform()));
		deviceDto.setDeviceType(DeviceManagerUtil.getDeviceTypeValue(deviceDto.getDeviceType()));
		
		// Save Device
		deviceRepository.save(
				EntityObjectGenerator.createDeviceEntity(deviceDto, null, deviceModel, lastUpdateUserName, null));

		LOGGER.logMessage("Create Device Successful:: DeviceId=" + deviceDto.getDeviceId());
	}
	
	/**
	 * This method validates and Assigns Device to the intended Subscriber.
	 * 
	 * @param deviceToAssign
	 * @param userId
	 * 
	 * @return 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public NotificationDto assignDevice(STBAssignmentDetail deviceToAssign, String userId) {

		// MAC/EquipmentID validation
		if (DeviceManagerUtil.checkNullorBlankString(deviceToAssign.getMACAddress())
				&& DeviceManagerUtil.checkNullObject(deviceToAssign.getEquipmentId())) {
			throw new DeviceManagerException(ErrorCode.REQUEST_VALIDATION_FAILED, "One of MAC Address or EquipmentId is required.");
		}

		LOGGER.logMessage("Assign Device with following parameters :: " + "AccountNumber=" + deviceToAssign.getAccountNumber()
				+ ", MacAddress=" + deviceToAssign.getMACAddress() + ", EquipmentId=" + deviceToAssign.getEquipmentId());

		// Device validation
		Device deviceEntity = deviceServiceHelper.getDevice(deviceToAssign.getMACAddress(),
				deviceToAssign.getEquipmentId());

		if (DeviceManagerUtil.checkNullObject(deviceEntity)) {
			throw new DeviceManagerException(ErrorCode.DEVICE_NOT_FOUND, "Device doesnot exists :: MacAddress="
					+ deviceToAssign.getMACAddress() + ", EquipmentId=" + deviceToAssign.getEquipmentId());
		}

		// Subscriber Validation
		Subscriber subscriber = deviceServiceHelper.getSubscriber(deviceToAssign.getAccountNumber());

		// Global Data Sync
		if (!isGlobalDataInSync) {
			isGlobalDataInSync = deviceServiceHelper.syncGlobalData();
		}

		// Check already assigned
/*		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getAssignedToSubscriber())) {
			if (deviceToAssign.getAccountNumber().equals(deviceEntity.getAssignedToSubscriber().getAccountNumber())) {
				LOGGER.logMessage("Device is already assigned to the Subscriber :: MacAddress=" + deviceEntity.getDeviceId()
						+ ", AccountNumber=" + deviceToAssign.getAccountNumber());
				return null;
			}
			throw new DeviceManagerException(ErrorCode.DEVICE_ALREADY_ASSIGNED,
					"Device already assigned to another subscriber :: MacAddress=" + deviceEntity.getDeviceId());
		}*/

		// Generate Unique Name, if not already present
		String deviceName = deviceServiceHelper.getDeviceName(deviceToAssign.getAccountNumber());

		// Assign STB
/*		deviceRepository.save(EntityObjectGenerator.getDeviceEntity(deviceToAssign, deviceEntity, subscriber, null, userId,
				subscriber.getLocationId(), deviceName, null));*/

		// Recalculate Device Profile and send trigger to Unicast Notifier
		NotificationDto dto = null;

		LOGGER.logMessage("Device successfully assigned :: MacAddress=" + deviceToAssign.getMACAddress() + ", AccountNumber="
				+ deviceToAssign.getAccountNumber());
		
		return dto;
	}

	/**
	 * This method validate and then creating and assigning new Device to the
	 * intended Subscriber.
	 * 
	 * @param assignDevice
	 * @param userId
	 * @param hardwareVersion
	 * 
	 * @return GenericResponseForB2B
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public NotificationDto createAndAssign(AssignSTB assignDevice, String userId, Model hardwareVersion) {

		LOGGER.logMessage("Create and Assign Device with following parameters :: " + "AccountNumber="
				+ assignDevice.getAccountNumber() + ", MacAddress=" + assignDevice.getMACAddress());

		Device deviceEntity = deviceServiceHelper.getDevice(assignDevice.getMACAddress(), null);

		// MAC validation
		if (!DeviceManagerUtil.checkNullObject(deviceEntity)) {
			throw new DeviceManagerException(ErrorCode.DEVICE_ALREADY_EXISTS,
					"Device already exists :: MacAddress=" + assignDevice.getMACAddress());
		}

		// Connection mode validation
		ConnectionMode connectionMode = deviceServiceHelper.getConnectionMode(assignDevice.getSupportedConnectionModes(),
				assignDevice.getIPAddress(), assignDevice.getExtIPAddress());

		// Subscriber Validation
		Subscriber subscriber = deviceServiceHelper.getSubscriber(assignDevice.getAccountNumber());

		// Global Data
		if (!isGlobalDataInSync) {
			isGlobalDataInSync = deviceServiceHelper.syncGlobalData();
		}
		
		// Generate Unique Name, if not already present
		String deviceName = assignDevice.getSTBName();
		if(StringUtils.isEmpty(deviceName)) {
			deviceName = deviceServiceHelper.getDeviceName(assignDevice.getAccountNumber());
		}else {
			deviceManagerValidator.validateDeviceNameUniqueness(assignDevice.getSTBName(), assignDevice.getAccountNumber(), assignDevice.getMACAddress());
		}

		// Create and Assign new Device
/*		deviceEntity = deviceRepository.save(EntityObjectGenerator.getDeviceEntity(assignDevice, null, subscriber, hardwareVersion,
				userId, subscriber.getLocationId(), deviceName, connectionMode));*/

		// Recalculate Device Profile and send trigger to Unicast Notifier
		NotificationDto dto = null;
		
		LOGGER.logMessage("Create and Assign Device successful :: MacAddress=" + assignDevice.getMACAddress() + ", AccountNumber="
				+ assignDevice.getAccountNumber());
		
		return dto;
	}
	
	/**
	 * This method validates and registers Device by Auto-Config
	 * 
	 * @param deviceRegistration
	 * @param extIdAddress
	 * @param userId
	 * 
	 * @return 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public NotificationDto autoConfig(STBRegistration deviceRegistration, String extIdAddress,
			String userId) {

		// Password/MasterPIN validation
		if (DeviceManagerUtil.checkNullorBlankString(deviceRegistration.getPassword())
				&& deviceRegistration.getMasterPIN() == null) {
			throw new DeviceManagerException(ErrorCode.MISSING_PARAM, "One of MasterPIN or Password required",
					new Object[] { "MasterPIN,Password" });
		}

		LOGGER.logMessage("Auto-config with following parameters :: " + "AccountNumber="
				+ deviceRegistration.getAccountNumber() + ", MacAddress=" + deviceRegistration.getMACAddress());

		com.accenture.avs.device.entity.Device deviceEntity = deviceServiceHelper.getDevice(deviceRegistration.getMACAddress(),
				null);

		// Validation for Supported Mode
		ConnectionMode connectionMode = deviceServiceHelper.getConnectionMode(deviceRegistration.getSupportedModes(),
				deviceRegistration.getIPAddress(), extIdAddress);

		// Subscriber Validation
		Subscriber subscriber = deviceServiceHelper.getSubscriber(deviceRegistration.getAccountNumber());

		// Global Data
		if (!isGlobalDataInSync) {
			isGlobalDataInSync = deviceServiceHelper.syncGlobalData();
		}

		// Validate hardware version
		Model hardwareVersion = deviceServiceHelper.getDeviceModel(deviceRegistration.getHardwareVersion(), Boolean.TRUE);
		
		// Validate Device AutoRegistration and Device Assignment
		if (!DeviceManagerUtil.checkNullObject(deviceServiceHelper.validateAutoRegistrationAndDeviceAssignment(deviceEntity,
				hardwareVersion, deviceRegistration))) {
			LOGGER.logMessage("Device is already assigned to the Subscriber :: MacAddress=" + deviceEntity.getDeviceId()
			+ ", AccountNumber=" + deviceRegistration.getAccountNumber());
			NotificationDto dto = new NotificationDto();
			dto.setDevice(deviceEntity);
			return dto;
		}

		// Generate Unique Name, if not already present
		String deviceName = deviceRegistration.getSTBName();
		if (StringUtils.isEmpty(deviceName)) {
			deviceName = deviceServiceHelper.getDeviceName(deviceRegistration.getAccountNumber());
		} else {
			deviceManagerValidator.validateDeviceNameUniqueness(deviceName, deviceRegistration.getAccountNumber(), deviceRegistration.getMACAddress());
		}

/*		deviceEntity = EntityObjectGenerator.getDeviceEntity(deviceRegistration, deviceEntity, subscriber, hardwareVersion, userId,
				subscriber.getLocationId(), deviceName, connectionMode);*/

		// updating IP Addresses
		deviceServiceHelper.updateInternalExternalIpAddress(deviceEntity, deviceRegistration.getIPAddress(), extIdAddress);

		deviceEntity = deviceRepository.save(deviceEntity);

		// Recalculate Device Profile and send trigger to Unicast Notifier
		NotificationDto dto = new NotificationDto();

		// Call CRM adapter
		deviceServiceHelper.sendNotificationToOssBssClient(deviceRegistration, deviceEntity.getExternalIpAddress(), null);

		LOGGER.logMessage("Auto-config successful :: MacAddress=" + deviceRegistration.getMACAddress() + ", AccountNumber="
				+ deviceRegistration.getAccountNumber());
		
		return dto;
	}

	/**
	 * This method validates and Unassigns/Unregisters Device for the intended
	 * Subscriber.
	 * 
	 * @param unassignDevice
	 * @param userId
	 * @return
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public NotificationDto unAssignDevice(UnassignSTB unassignDevice, String userId) {

		// MAC/EquipmentID validation
		if (DeviceManagerUtil.checkNullorBlankString(unassignDevice.getMACAddress())
				&& DeviceManagerUtil.checkNullObject(unassignDevice.getEquipmentId())) {
			throw new DeviceManagerException(ErrorCode.REQUEST_VALIDATION_FAILED,
					"One of MAC Address or EquipmentId is required.");
		}

		LOGGER.logMessage("Unassign Device with following parameters :: " + "AccountNumber=" + unassignDevice.getAccountNumber()
				+ ", MacAddress=" + unassignDevice.getMACAddress() + ", EquipmentId=" + unassignDevice.getEquipmentId());

		Device deviceEntity = deviceServiceHelper.getDevice(unassignDevice.getMACAddress(),
				unassignDevice.getEquipmentId());

		// Device validation
		if (DeviceManagerUtil.checkNullObject(deviceEntity)) {
			throw new DeviceManagerException(ErrorCode.DEVICE_NOT_FOUND,
					"Device doesnot exists :: MacAddress=" + unassignDevice.getMACAddress());
		}

		Subscriber subscriber = new Subscriber();
		
		// Device assignment validation
		if (DeviceManagerUtil.checkNullObject(subscriber)) {
			LOGGER.logMessage("Device is already unassigned :: MacAddress=" + deviceEntity.getDeviceId());
			return null;
		} else if (!unassignDevice.getAccountNumber().equals(subscriber.getAccountNumber())) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_FOUND, "Device not assigned :: MacAddress="
					+ unassignDevice.getMACAddress() + ", AccountNumber=" + unassignDevice.getAccountNumber());
		}

		// delete device properties
		devicePropertyRepository.deleteByEquipmentId(deviceEntity.getId());
		
		// delete device service port mappings
		deviceServicePortMappingRepository.deleteByEquipmentId(deviceEntity.getId());

		// delete stb udfs
		//stbUdfRepository.deleteByEquipmentId(stb.getEquipmentId());

		// Unassign STB
		deviceEntity.setAssignmentStatus(IdentificationType.statusUnassigned.getProperty());
		//deviceEntity.setAssignedToSubscriber(null);
		deviceEntity.setDeviceName(null);
		deviceEntity.setLastUpdatedOn(System.currentTimeMillis());
		deviceEntity.setLastUpdatedBy(userId);
		
		// Recalculate Device Profile and send trigger to Unicast Notifier
		NotificationDto dto = null;

		LOGGER.logMessage("Unassign Device successful :: " + "AccountNumber=" + unassignDevice.getAccountNumber()
				+ ", MacAddress=" + unassignDevice.getMACAddress() + ", EquipmentId=" + unassignDevice.getEquipmentId());
		return dto;
	}

}
