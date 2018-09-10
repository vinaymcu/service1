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

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.client.GlobalConfigurationClient;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceAudit;
import com.accenture.avs.device.entity.DeviceResourceAllocation;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.entity.Subscriber;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.DeviceDto;
import com.accenture.avs.device.repository.CustomDeviceAuditRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.DeviceResourceAllocationRepository;
import com.accenture.avs.device.repository.HardwareMtpMappingRepository;
import com.accenture.avs.device.repository.ModelRepository;
import com.accenture.avs.device.repository.SubscriberRepository;
import com.accenture.avs.device.service.DeviceServiceHelper;
import com.accenture.avs.device.service.UpdateDeviceService;
import com.accenture.avs.device.service.UpdateRemoveDeviceServiceHelper;
import com.accenture.avs.device.util.AvsJmsProducerUtil;
import com.accenture.avs.device.util.Constants;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.DeviceManagerValidator;
import com.accenture.avs.device.util.EntityObjectGenerator;

/**
 * @author rajesh.karna
 *
 */
@Service
public class UpdateDeviceServiceImpl implements UpdateDeviceService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(UpdateDeviceServiceImpl.class);

	/** avsJmsProducerUtil */
	@Autowired
	AvsJmsProducerUtil avsJmsProducerUtil;

	/** deviceRepository */
	@Autowired
	DeviceRepository deviceRepository;

	/** deviceServiceHelper */
	@Autowired
	DeviceServiceHelper deviceServiceHelper;

	/** deviceManagerValidator */
	@Autowired
	DeviceManagerValidator deviceManagerValidator;

	/** deviceRepository */
	@Autowired
	ModelRepository hardwareVersionRepository;

	/** globalConfigurationClient */
	@Autowired
	GlobalConfigurationClient globalConfigurationClient;

	/** updateRemoveDeviceServiceHelper */
	@Autowired
	UpdateRemoveDeviceServiceHelper updateRemoveDeviceServiceHelper;

	/** customDeviceBoxAuditRepository */
	@Autowired
	private CustomDeviceAuditRepository customDeviceAuditRepository;

	/** deviceResourceAllocationRepository */
	@Autowired
	private DeviceResourceAllocationRepository deviceResourceAllocationRepository;

	/** subscriberRepository */
	@Autowired
	private SubscriberRepository subscriberRepository;

	/** hardwareMtpMappingRepository */
	@Autowired
	HardwareMtpMappingRepository hardwareMtpMappingRepository;

	/**
	 * This method validates and updates the device.
	 * 
	 * @param deviceDto
	 * @param lastUpdateUserName
	 */
	@Override
	public void updateDevice(DeviceDto deviceDto, String lastUpdateUserName) {

		LOGGER.logMessage("Update Device :: deviceId={}", deviceDto.getDeviceId());
		
		// Device Validation
		Device deviceEntity = deviceServiceHelper.getDevice(deviceDto.getDeviceId());

		// DrmId Validation
		deviceManagerValidator.validateDrmIdUniqueness(deviceDto.getDrmId(), deviceDto.getDeviceId());

		// Device Triplet Validation
		deviceManagerValidator.validateDeviceTripletUniqueness(deviceDto.getSerialNumber(), deviceDto.getModel(),
				deviceDto.getVendor(), deviceDto.getDeviceId());
		
		// Model Validation
		Model deviceModelEntity = deviceServiceHelper.getDeviceModel(deviceDto.getModel(), Boolean.TRUE);

		if (StringUtils.isNotEmpty(deviceEntity.getAssignedToUserName())) {
			// Model Updation Validation
			if (!DeviceManagerUtil.checkNullObject(deviceDto.getModel())
					&& !deviceEntity.getModel().getModelName().equals(deviceDto.getModel())) {
				throw new DeviceManagerException(ErrorCode.DEVICE_ASSIGNED_CANNOT_UPDATE_MODEL);
			}
			
			// Device Name validation
			deviceManagerValidator.validateDeviceNameUniqueness(deviceDto.getDeviceName(),
					deviceEntity.getAssignedToUserName(), deviceDto.getDeviceId());
		}

		// Setting correct value for Platform and deviceType
		updatePlatformAndDeviceType(deviceDto, deviceDto.getPlatform(), deviceDto.getDeviceType());

		// Find changed values
		List<String> changedValues = getChangedValuesMap(deviceDto, deviceEntity);

		// Save Device
		deviceEntity = deviceRepository.save(EntityObjectGenerator.createDeviceEntity(deviceDto, deviceEntity,
				deviceModelEntity, lastUpdateUserName, deviceDto.getDeviceName()));

		// Post operations
		if (StringUtils.isNotEmpty(deviceEntity.getAssignedToUserName())) {
			updateRemoveDeviceServiceHelper.updateAssignedDevicePostOperations(changedValues, deviceEntity);
		}
		
		LOGGER.logMessage("Update Device Successful :: deviceId={}", deviceDto.getDeviceId());
	}

	/**
	 * This method creates a list of updated values required for further action.
	 * 
	 * @param deviceDto
	 * @param deviceEntity
	 * @return
	 */
	private List<String> getChangedValuesMap(DeviceDto deviceDto, Device deviceEntity) {
		List<String> changedValues = new ArrayList<>();
		if (!DeviceManagerUtil.checkNullObject(deviceDto.getTvQualityInterest())
				&& !deviceDto.getTvQualityInterest().equals(deviceEntity.getTvQualityInterest())) {
			changedValues.add(Constants.TV_QUALITY_INTEREST);
		}
		if (!DeviceManagerUtil.checkNullObject(deviceDto.getSoftwareVersion())
				&& !deviceDto.getSoftwareVersion().equals(deviceEntity.getSoftwareVersion())) {
			changedValues.add(Constants.SOFTWARE_VERSION);
		}
		if (!DeviceManagerUtil.checkNullObject(deviceDto.getVendor())
				&& !deviceDto.getVendor().equals(deviceEntity.getVendor())) {
			changedValues.add(Constants.VENDOR);
		}
		return changedValues;
	}

	/**
	 * This method updates the platform and device type if values are provided.
	 * 
	 * @param deviceDto
	 * @param platform
	 * @param deviceType
	 */
	private void updatePlatformAndDeviceType(DeviceDto deviceDto, String platform, String deviceType) {
		if (!DeviceManagerUtil.checkNullObject(platform)) {
			deviceDto.setPlatform(DeviceManagerUtil.getPlatformValue(platform));
		}

		if (!DeviceManagerUtil.checkNullObject(deviceType)) {
			deviceDto.setDeviceType(DeviceManagerUtil.getDeviceTypeValue(deviceType));
		}
	}

	/**
	 * This method gets the list of subscribers who’s Devices have been updated
	 * within the given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return Map<String, Long>
	 */
	@Override
	public Map<String, Long> getUpdatedDeviceListing(Long startDate, Long endDate) {

		validateStartAndEndTime(startDate, endDate);

		Map<String, Long> updatedDevicesAccountNumberList = getAccountsListWithLatestLastUpdatedOnForDeviceUpdate(
				startDate, endDate);
		Map<String, Long> updatedDeviceProfileAccountNumberList = getAccountsListWithLatestLastUpdatedOnForProfileUpdates(
				startDate, endDate);

		filterMapWithLatestLastUpdateTime(updatedDevicesAccountNumberList, updatedDeviceProfileAccountNumberList);

		return updatedDeviceProfileAccountNumberList;
	}

	/**
	 * This method decides the latest last update for each account number.
	 * 
	 * @param updatedDeviceAccountNumberList
	 * @param updatedDeviceProfileAccountNumberList
	 */
	private void filterMapWithLatestLastUpdateTime(Map<String, Long> updatedDeviceAccountNumberList,
			Map<String, Long> updatedDeviceProfileAccountNumberList) {
		for (Map.Entry<String, Long> updatedDeviceAccountNumber : updatedDeviceAccountNumberList.entrySet()) {
			String updatedDeviceAccountNumberKey = updatedDeviceAccountNumber.getKey();
			Long updatedDeviceAccountNumberValue = updatedDeviceAccountNumber.getValue();
			Long updatedDeviceProfileAccountNumberValue = updatedDeviceProfileAccountNumberList
					.get(updatedDeviceAccountNumberKey);
			if (DeviceManagerUtil.checkNullObject(updatedDeviceProfileAccountNumberValue)
					|| updatedDeviceProfileAccountNumberValue < updatedDeviceAccountNumberValue) {
				updatedDeviceProfileAccountNumberList.put(updatedDeviceAccountNumberKey,
						updatedDeviceAccountNumberValue);
			}
		}
	}

	/**
	 * This method gets a map of account numbers whose Devices were last updated
	 * within a given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return Map<String, Long>
	 */
	private Map<String, Long> getAccountsListWithLatestLastUpdatedOnForDeviceUpdate(Long startDate, Long endDate) {

		Map<String, Long> updatedDevicesAccountList = new HashMap<>();

		// Get updated devices within the time frame
		List<DeviceAudit> deviceAuditList = customDeviceAuditRepository
				.findAssignedToSubscriberIdAndMaxLastUpdatedOnByStartAndEndDate(startDate, endDate);

		// Map subscriber ids with last update time
		Map<String, Long> subscriberIdLastUpdateMap = new HashMap<>();
		for (DeviceAudit deviceAudit : deviceAuditList) {
			subscriberIdLastUpdateMap.put(deviceAudit.getLastUpdateUsername(), deviceAudit.getLastUpdatedDatetime());
		}

		// Get and map account numbers with last update time
		List<Subscriber> subscribers = subscriberRepository.findAll(subscriberIdLastUpdateMap.keySet());
		for (Subscriber subscriber : subscribers) {
			if (subscriberIdLastUpdateMap.containsKey(subscriber.getSubscriberId())) {
				updatedDevicesAccountList.put(subscriber.getAccountNumber(),
						subscriberIdLastUpdateMap.get(subscriber.getSubscriberId()));
			}
		}
		return updatedDevicesAccountList;
	}

	/**
	 * This method gets accounts a map of account numbers whose devices profiles
	 * might have been updated within the given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return Map<String, Long>
	 */
	private Map<String, Long> getAccountsListWithLatestLastUpdatedOnForProfileUpdates(Long startDate, Long endDate) {

		Map<String, Long> updatedDeviceProfilesAccountList = new HashMap<>();

		// Get Devices Profiles updated within the time frame
		List<DeviceResourceAllocation> deviceResourceAllocationList = deviceResourceAllocationRepository
				.findByLastUpdatedOnBetween(startDate, endDate);

		Map<Long, Long> equipmentIdLastUpdateMap = new HashMap<>();
		for (DeviceResourceAllocation deviceResourceAllocation : deviceResourceAllocationList) {
			equipmentIdLastUpdateMap.put(deviceResourceAllocation.getEquipmentId(),
					deviceResourceAllocation.getLastUpdatedOn());
		}

		// Get devices whose profiles are updated
		List<Device> devicesList = deviceRepository.findAll(equipmentIdLastUpdateMap.keySet());

		// Get Subscribers for the devices along with last updated time of each
		// assigned STB
		Map<String, List<Long>> accountNumberLastUpdateMap = new HashMap<>();
		for (Device device : devicesList) {
			/*
			 * if (accountNumberLastUpdateMap.containsKey(device.getAssignedToSubscriber().
			 * getAccountNumber())) {
			 * accountNumberLastUpdateMap.get(device.getAssignedToSubscriber().
			 * getAccountNumber()) .add(equipmentIdLastUpdateMap.get(device.getId())); }
			 * else { List<Long> lastUpdateOnList = new ArrayList<>();
			 * lastUpdateOnList.add(equipmentIdLastUpdateMap.get(device.getId()));
			 * accountNumberLastUpdateMap.put(device.getAssignedToSubscriber().
			 * getAccountNumber(), lastUpdateOnList); }
			 */
		}

		// Mapping account number with latest last updated time
		for (Map.Entry<String, List<Long>> accountNumberLastUpdateEntrySet : accountNumberLastUpdateMap.entrySet()) {
			Long lastUpdateOn = Collections.max(accountNumberLastUpdateEntrySet.getValue());
			updatedDeviceProfilesAccountList.put(accountNumberLastUpdateEntrySet.getKey(), lastUpdateOn);
		}
		return updatedDeviceProfilesAccountList;
	}

	/**
	 * This method validates the Start and End Date.
	 * 
	 * @param startDate
	 * @param endDate
	 */
	private void validateStartAndEndTime(Long startDate, Long endDate) {

		Instant currentInstant = Instant.now();
		Instant startDateInstant = Instant.ofEpochMilli(startDate);
		Instant endDateInstant = Instant.ofEpochMilli(endDate);

		/*
		 * if (Duration.between(startDateInstant, endDateInstant).toDays() > 7) { throw
		 * new DeviceManagerException(ErrorCode.TIME_WINDOW_GREATER_THAN_ONE_WEEK,
		 * "Time window cannot be greater than one week"); }
		 */

		if (Duration.between(startDateInstant, currentInstant).toDays() > 30) {
			throw new DeviceManagerException(ErrorCode.TIME_DIFFERENCE_GREATER_THAN_3O_DAYS,
					"Start time cannot be less than 30 days from the current date");
		}

		if (startDateInstant.isAfter(endDateInstant)) {
			throw new DeviceManagerException(ErrorCode.STARTDATE_GREATER_THAN_ENDDATE,
					"Start date cannot be greater than the end date");
		}

		if (endDateInstant.isAfter(currentInstant)) {
			throw new DeviceManagerException(ErrorCode.ENDDATE_GREATER_THAN_CURRENTDATE,
					"End date cannot be greater the current date");
		}

	}

}
