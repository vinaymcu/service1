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

package com.accenture.avs.device.util;

import java.util.List;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.json.object.resourcemanager.AssignedDeviceProfile;
import com.accenture.avs.device.json.object.resourcemanager.TVQualityProfile;
import com.accenture.avs.device.json.object.devicemanager.SubscriberUpdate;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdate;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdateRequest;

/**
 * Device Subscriber Service Util class.
 * 
 * @author rajesh.karna
 *
 */
public class DeviceSubscriberServiceUtil {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceSubscriberServiceUtil.class);

	/** TRIGGER_SUB_INFO */
	public static final String TRIGGER_SUB_INFO = "T_SUBSCRIBER_INFO";

	/**
	 * Prints log for subscriber details.
	 * 
	 * @param subscriberUpdate
	 */
	public static void printSubscriberUpdateLog(SubscriberUpdate subscriberUpdate) {
		StringBuilder stringBuilder = new StringBuilder("\nSubscriber details with the following parameters:");
		stringBuilder.append("\nSubscriberId = ");
		stringBuilder.append(subscriberUpdate.getSubscriberId());
		stringBuilder.append("\nCity = ");
		stringBuilder.append(subscriberUpdate.getCity());
		stringBuilder.append("\nLocation = ");
		stringBuilder.append(subscriberUpdate.getLocationId());
		stringBuilder.append("\nMaxBWOverride = ");
		stringBuilder.append(subscriberUpdate.getMaxBWOverride());
		stringBuilder.append("\nNetworkBufferSize = ");
		stringBuilder.append(subscriberUpdate.getNetworkBufferSize());
		stringBuilder.append("\nName = ");
		stringBuilder.append(subscriberUpdate.getName());
		stringBuilder.append("\nPhoneNumber = ");
		stringBuilder.append(subscriberUpdate.getPhoneNumber());
		stringBuilder.append("\nStatus = ");
		stringBuilder.append(subscriberUpdate.getStatus());
		stringBuilder.append("\nSubscriberBWProfile = ");
		stringBuilder.append(subscriberUpdate.getSubscriberBWProfile());
		stringBuilder.append("\nQoeControlBandwidth = ");
		stringBuilder.append(subscriberUpdate.getQoeControlBandwidth());
		stringBuilder.append("\nRccEnable = ");
		stringBuilder.append(subscriberUpdate.getRccEnable());
		stringBuilder.append("\nRetEnable = ");
		stringBuilder.append(subscriberUpdate.getRetEnable());
		stringBuilder.append("\nType = ");
		stringBuilder.append(subscriberUpdate.getType());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Prints log for resource allocation.
	 * 
	 * @param assignedDeviceProfile
	 */
	public static void printLogForResourceAllocation(AssignedDeviceProfile assignedDeviceProfile) {
		StringBuilder stringBuilder = new StringBuilder("Subscriber Resource Allocation data:")
				.append("\nEquipmentId = ").append(assignedDeviceProfile.getEquipmentID())
				.append("\nAssignedProfile = ").append(assignedDeviceProfile.getAssignedProfile())
				.append("\nAssignedBW = ").append(assignedDeviceProfile.getAssignedBW())
				.append("\nAssignedVQEOverheadBW = ").append(assignedDeviceProfile.getAssignedVQEOverheadBW());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Prints log for Device Max Allowed Per Quality data.
	 * 
	 * @param equipmentId
	 * @param tvQualityProfile
	 */
	public static void printLogForDeviceMaxAllowedPerQuality(Long equipmentId, TVQualityProfile tvQualityProfile) {
		StringBuilder stringBuilder = new StringBuilder("Max Allowed Device Per Quality data:");
		stringBuilder.append("\nEquipmentId = ").append(equipmentId).append("\nTvQualityInterest = ")
				.append(tvQualityProfile.getTvQualityInterest()).append("\nTvQualityMaxBW = ")
				.append(tvQualityProfile.getTvQualityMaxBW());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Prepares and returns EventUpdateRequest on the basis of assigned subscriber
	 * id and list of macAddress.
	 * 
	 * @param assignedSubscriberId
	 * @param listMacs
	 * @return EventUpdate
	 */
	public static EventUpdateRequest getEventUpdateRequest(String assignedSubscriberId, List<String> listMacs) {
		EventUpdateRequest eventUpdateRequest = new EventUpdateRequest();
		EventUpdate eventUpdate = new EventUpdate();
		eventUpdate.setMACAddress(listMacs);
		eventUpdate.setSubscriberId(assignedSubscriberId);
		eventUpdate.setTimestamp(String.valueOf(System.currentTimeMillis()));
		eventUpdate.setTriggerInfo(TRIGGER_SUB_INFO);
		eventUpdate.setTriggerType(TRIGGER_SUB_INFO);
		eventUpdateRequest.setEventUpdate(null);
		return eventUpdateRequest;
	}
}
