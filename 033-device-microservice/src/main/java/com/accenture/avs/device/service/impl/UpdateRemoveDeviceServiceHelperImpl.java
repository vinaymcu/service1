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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.repository.DeviceAssignedResourceRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.ResourcesRepository;
import com.accenture.avs.device.service.DeviceServiceHelper;
import com.accenture.avs.device.service.PushMessageService;
import com.accenture.avs.device.service.ResourceRedistributionService;
import com.accenture.avs.device.service.SubscriberHelperService;
import com.accenture.avs.device.service.UpdateRemoveDeviceServiceHelper;
import com.accenture.avs.device.util.AvsJmsProducerUtil;
import com.accenture.avs.device.util.Constants;

/**
 * @author rajesh.karna
 *
 */
@Service
public class UpdateRemoveDeviceServiceHelperImpl implements UpdateRemoveDeviceServiceHelper {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(UpdateRemoveDeviceServiceHelperImpl.class);

	/** deviceRepository */
	@Autowired
	DeviceRepository deviceRepository;

	/** resourcesRepository */
	@Autowired
	ResourcesRepository resourcesRepository;

	/** deviceAssignedResourceRepository */
	@Autowired
	DeviceAssignedResourceRepository deviceAssignedResourceRepository;

	/** subscriberHelperService */
	@Autowired
	SubscriberHelperService subscriberHelperService;

	/** resourceRedistributionService */
	@Autowired
	ResourceRedistributionService resourceRedistributionService;

	/** deviceServiceHelper */
	@Autowired
	DeviceServiceHelper deviceServiceHelper;

	/** pushMessageService */
	@Autowired
	private PushMessageService pushMessageService;

	/** avsJmsProducerUtil */
	@Autowired
	AvsJmsProducerUtil avsJmsProducerUtil;

	/** ASSIGNED */
	private static final String ASSIGNED = "Assigned";

	/**
	 * Removes device.
	 * 
	 * @param device
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void removeDevice(Device device) {
		LOGGER.logMessage("removeDevice++");
		LOGGER.logMessage("EquipmentId:: " + device.getId());
		if (ASSIGNED.equals(device.getAssignmentStatus()) /* || device.getSubscriberId() != null */) {
			throw new DeviceManagerException(ErrorCode.DEVICE_SHOULD_BE_UNASSIGNED);
		}
		deviceRepository.delete(device.getId());
		LOGGER.logMessage("removeDevice--");

	}

	/**
	 * This method performs further required action on updation of certain Device
	 * Properties.
	 * 
	 * @param changedValues
	 * @param deviceEntity
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void updateAssignedDevicePostOperations(List<String> changedValues, Device deviceEntity) {
		LOGGER.logMessage("Platform={}", deviceEntity.getPlatform());
		LOGGER.logMessage("AssignedToUserName={}", deviceEntity.getAssignedToUserName());
		for (String deviceProperty : changedValues) {
			if (deviceProperty.equals(Constants.TV_QUALITY_INTEREST)) {
				LOGGER.logMessage("TVQualityInterest Changed");
				profileRecalculationForIptv(deviceEntity);
				notifyGroupMs(deviceEntity);
			}
		}
	}

	/**
	 * This method performs all the post operations when the device is assigned and
	 * TVQualityInterest is changed.
	 * 
	 * @param deviceEntity
	 */
	private void notifyGroupMs(Device deviceEntity) {
		List<String> userNames = new ArrayList<>();
		userNames.add(deviceEntity.getAssignedToUserName());
		avsJmsProducerUtil.sendMessageToGroupMs(Constants.ApiType.UPDATEDEVICE, userNames);
	}

	/**
	 * This method calls resource manager for profile recalculation and sends
	 * notification to Push Message MS.
	 * 
	 * @param deviceEntity
	 */
	private void profileRecalculationForIptv(Device deviceEntity) {
		if (deviceEntity.getPlatform().equals(Constants.PlatformType.IPTV)) {
			// Calculate device profile
			List<Long> equipmentIdListForNotification = deviceServiceHelper
					.calculateDeviceProfile(deviceEntity.getAssignedToUserName(), deviceEntity, Boolean.FALSE);
			// Push Message
			pushMessageService.sendNotification(equipmentIdListForNotification, deviceEntity.getAssignedToUserName(),
					Constants.Trigger.T_SUBSCRIBER_INFO, Constants.Trigger.T_TRIGGER_INFO);
		}
	}
}
