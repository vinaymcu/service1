/****************************************************************************
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceMaxBWAllowedPerQuality;
import com.accenture.avs.device.entity.DeviceMaxBWAllowedPerQualityId;
import com.accenture.avs.device.entity.DeviceResourceAllocation;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.entity.Subscriber;
import com.accenture.avs.device.entity.SubscriberDeviceLimit;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.resourcemanager.AssignedDevice;
import com.accenture.avs.device.json.object.resourcemanager.AssignedDeviceProfile;
import com.accenture.avs.device.json.object.resourcemanager.GetProfileReq;
import com.accenture.avs.device.json.object.resourcemanager.MaxDeviceProfile;
import com.accenture.avs.device.json.object.resourcemanager.ResSubscriber;
import com.accenture.avs.device.json.object.resourcemanager.STBProfile;
import com.accenture.avs.device.json.object.resourcemanager.TVQualityProfile;
import com.accenture.avs.device.repository.DeviceMaxBWAllowedPerQualityRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.DeviceResourceAllocationRepository;
import com.accenture.avs.device.repository.SubscriberRepository;
import com.accenture.avs.device.service.InterProcessCommunicationService;
import com.accenture.avs.device.service.ResourceRedistributionService;
import com.accenture.avs.device.util.DeviceGlobalDataServiceUtil;
import com.accenture.avs.device.util.DeviceSubscriberServiceUtil;

/**
 * @author rajesh.karna
 *
 */
@Service
public class ResourceRedistributionServiceImpl implements ResourceRedistributionService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(ResourceRedistributionServiceImpl.class);

	/** deviceRepository */
	@Autowired
	DeviceRepository deviceRepository;

	/** subscriberRepository */
	@Autowired
	SubscriberRepository subscriberRepository;

	/** deviceResourceAllocationRepository */
	@Autowired
	DeviceResourceAllocationRepository deviceResourceAllocationRepository;

	/** deviceMaxBWAllowedPerQualityRepository */
	@Autowired
	DeviceMaxBWAllowedPerQualityRepository deviceMaxBWAllowedPerQualityRepository;

	/** interProcessCommunicationService */
	@Autowired
	InterProcessCommunicationService interProcessCommunicationService;

	/** failedNotificationRetrials */
	@Value("${failed.notification.retrials:2}")
	int failedNotificationRetrials;

	/**
	 * Processes subscriber resource redistribution.
	 * 
	 * @param subscriber
	 */
	@Override
	public void resourceRedistribution(Subscriber subscriber) {
		
		LOGGER.logMessage("resourceRedistribution++");
		
		String subscriberId = subscriber.getSubscriberId();
		GetProfileReq getProfileReq = new GetProfileReq();
		com.accenture.avs.device.json.object.resourcemanager.Subscriber subscriberJson = new com.accenture.avs.device.json.object.resourcemanager.Subscriber();
		subscriberJson.setAssignedDevices(getAssignedDevices(subscriberId));
		subscriberJson.setBWProfile(subscriber.getSubscriberBWProfile());
		subscriberJson
				.setOverrideBW(subscriber.getMaxBWOverride() == null ? 0 : subscriber.getMaxBWOverride().intValue());
		subscriberJson.setMaxDeviceProfile(getMaxDeviceProfiles(subscriber));
		subscriberJson.setVqEBW(
				subscriber.getQoeControlBandwidth() == null ? 0 : subscriber.getQoeControlBandwidth().intValue());

		getProfileReq.setSubscriber(subscriberJson);
		
		updateDeviceProfiles(subscriber, interProcessCommunicationService.getDeviceProfile(getProfileReq, subscriberId));

		List<String> listMacs = new ArrayList<>();
		LOGGER.logMessage("Notification(s) to be sent to Device(s) having MacAddress(s):: " + listMacs);
		
		if (!listMacs.isEmpty()) {
			interProcessCommunicationService.notifyDevices(
					DeviceSubscriberServiceUtil.getEventUpdateRequest(subscriberId, listMacs), failedNotificationRetrials);
		}
		
		LOGGER.logMessage("resourceRedistribution--");
	}

	/**
	 * Gets a list of MaxDeviceProfile on the basis of subscriber.
	 * 
	 * @param subscriber
	 * @return List<MaxDeviceProfile>
	 */
	private List<MaxDeviceProfile> getMaxDeviceProfiles(Subscriber subscriber) {
		List<MaxDeviceProfile> maxDeviceProfiles = new ArrayList<>();
		MaxDeviceProfile maxDeviceProfile = new MaxDeviceProfile();

		Map<String, Long> subscriberDeviceLimitMap = new HashedMap();
		for (SubscriberDeviceLimit subscriberDeviceLimit : subscriber.getSubscriberDeviceLimits()) {
			subscriberDeviceLimitMap.put(subscriberDeviceLimit.getId().getResolutionTypeName(),
					subscriberDeviceLimit.getDeviceLimit());
		}

		Iterator<Entry<String, Long>> iterator = subscriberDeviceLimitMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<String, Long> deviceNameAndMaxLimit = iterator.next();
			maxDeviceProfile.setTvQuality(deviceNameAndMaxLimit.getKey());
			maxDeviceProfile.setTvQualityMaxDevice(deviceNameAndMaxLimit.getValue().intValue());
			maxDeviceProfiles.add(maxDeviceProfile);
		}
		return maxDeviceProfiles;
	}

	/**
	 * Gets a list of AssignedDevice on the basis of subscriberId.
	 * 
	 * @param subscriberId
	 * @return List<assignedDevices>
	 */
	private List<AssignedDevice> getAssignedDevices(String subscriberId) {
		List<AssignedDevice> assignedDevices = new ArrayList<>();

		List<Device> devices = new ArrayList<>();
		
		devices.stream().forEach(device -> {
			AssignedDevice assignedDevice = new AssignedDevice();
			assignedDevice.setEquipmentID(String.valueOf(device.getId()));
			
			Model hardwareVersion = device.getModel();
			if (hardwareVersion != null) {
				assignedDevice.setHWVersion(hardwareVersion.getModelName());
			}
			
			assignedDevice.setTvQualityInterest(device.getTvQualityInterest());
			assignedDevice.setAssigmentDateTime(String.valueOf(device.getDatetimeOfAssignment()));
			assignedDevices.add(assignedDevice);
		});
		return assignedDevices;
	}

	/**
	 * Saves or updates device profile on the basis of subscriber and DeviceProfile.
	 * 
	 * @param subscriber
	 * @param deviceProfile
	 */
	private void updateDeviceProfiles(Subscriber subscriber, STBProfile deviceProfile) {
		
		LOGGER.logMessage("updateDeviceProfiles++");

		List<Long> offAssignedDeviceProfileEquipmentIds = new ArrayList<>();
		
		for (com.accenture.avs.device.json.object.resourcemanager.ResultObject resultObject : deviceProfile.getResultObject()) {
			ResSubscriber resSubscriber = resultObject.getResSubscriber();
			LOGGER.logMessage("Resource subscriber Id:: " + resSubscriber.getId());

			if (DeviceGlobalDataServiceUtil.isResponseResultCodeValid(resultObject.getResultCode())) {

				if (subscriber.getSubscriberId().equals(resSubscriber.getId())) {
					subscriber.setFreeBandwidth(resSubscriber.getFreeBW().longValue());
					subscriberRepository.save(subscriber);
				}

				updateAssignedDeviceProfiles(offAssignedDeviceProfileEquipmentIds, resSubscriber);
			} else {
				LOGGER.logMessage(
							"Resource manager is not able to send stb profile data successfully for subscriber id:: "
									+ subscriber.getSubscriberId());
				throw new DeviceManagerException(ErrorCode.RESOURCE_DISTRIBUTION_FAILED);
			}
		}
		
		LOGGER.logMessage("The list of equipmentIds of OFF AssignedDeviceProfile:: "
					+ offAssignedDeviceProfileEquipmentIds);
		
		offAssignedDeviceProfileEquipmentIds.stream()
				.forEach(equipmentId -> deviceResourceAllocationRepository.delete(equipmentId));

		LOGGER.logMessage("updateDeviceProfiles--");
	}

	/**
	 * Updates assigned device profiles on the basis of ResSubscriber.
	 * 
	 * @param offAssignedDeviceProfileEquipmentIds
	 * @param resSubscriber
	 */
	private void updateAssignedDeviceProfiles(List<Long> offAssignedDeviceProfileEquipmentIds,
			ResSubscriber resSubscriber) {
		for (AssignedDeviceProfile assignedDeviceProfile : resSubscriber.getAssignedDeviceProfile()) {

			Long equipmentId = Long.valueOf(assignedDeviceProfile.getEquipmentID());

			if (equipmentId != null && deviceRepository.findById(equipmentId) != null) {
				
				LOGGER.logMessage("AssignedProfile for equipmentId " + equipmentId + " is:: " + assignedDeviceProfile.getAssignedProfile());
				
				deviceMaxBWAllowedPerQualityRepository.deleteById(equipmentId);

				if (IdentificationType.assignedProfileOff.getProperty()
						.equals(assignedDeviceProfile.getAssignedProfile())) {
					if (deviceResourceAllocationRepository.findOne(equipmentId) != null) {
						offAssignedDeviceProfileEquipmentIds.add(equipmentId);
					}
				} else {
					updateStbResourceAllocation(assignedDeviceProfile);
					List<TVQualityProfile> tvQualityProfiles = assignedDeviceProfile.getTVQualityProfile();
					for (TVQualityProfile tvQualityProfile : tvQualityProfiles) {
						updateStbMaxBWAllowedPerQuality(tvQualityProfile, equipmentId);
					}
				}
			}
		}
	}
	
	/**
	 * updates device max bandwidth allowed per quality on the basis of
	 * tvQualityProfile and equipmentId.
	 * 
	 * @param tvQualityProfile
	 * @param equipmentId
	 */
	private void updateStbMaxBWAllowedPerQuality(TVQualityProfile tvQualityProfile, Long equipmentId) {
		DeviceSubscriberServiceUtil.printLogForDeviceMaxAllowedPerQuality(equipmentId, tvQualityProfile);
		DeviceMaxBWAllowedPerQuality deviceMaxBWAllowedPerQuality;
		DeviceMaxBWAllowedPerQualityId deviceMaxBWAllowedPerQualityId;
		deviceMaxBWAllowedPerQuality = new DeviceMaxBWAllowedPerQuality();
		deviceMaxBWAllowedPerQualityId = new DeviceMaxBWAllowedPerQualityId(equipmentId,
				tvQualityProfile.getTvQualityInterest());
		deviceMaxBWAllowedPerQuality.setId(deviceMaxBWAllowedPerQualityId);
		deviceMaxBWAllowedPerQuality.setMaxBandwidth(tvQualityProfile.getTvQualityMaxBW().longValue());
		deviceMaxBWAllowedPerQualityRepository.save(deviceMaxBWAllowedPerQuality);
	}

	/**
	 * updates device resource allocation on the basis of assignedDeviceProfile.
	 * 
	 * @param assignedDeviceProfile
	 */
	private void updateStbResourceAllocation(AssignedDeviceProfile assignedDeviceProfile) {
		DeviceSubscriberServiceUtil.printLogForResourceAllocation(assignedDeviceProfile);
		DeviceResourceAllocation deviceResourceAllocation = new DeviceResourceAllocation();
		deviceResourceAllocation.setEquipmentId(Long.valueOf(assignedDeviceProfile.getEquipmentID()));
		deviceResourceAllocation.setDeviceProfile(assignedDeviceProfile.getAssignedProfile());
		deviceResourceAllocation.setProfileBandwidth(assignedDeviceProfile.getAssignedBW().longValue());
		deviceResourceAllocation.setQoeBandwidth(assignedDeviceProfile.getAssignedVQEOverheadBW().longValue());
		deviceResourceAllocation.setLastUpdatedOn(System.currentTimeMillis());
		deviceResourceAllocationRepository.save(deviceResourceAllocation);
	}
}
