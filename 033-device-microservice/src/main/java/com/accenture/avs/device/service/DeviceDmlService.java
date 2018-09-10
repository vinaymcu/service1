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

package com.accenture.avs.device.service;

import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.json.object.devicemanager.AssignSTB;
import com.accenture.avs.device.json.object.devicemanager.DeviceDto;
import com.accenture.avs.device.json.object.devicemanager.STBAssignmentDetail;
import com.accenture.avs.device.json.object.devicemanager.STBRegistration;
import com.accenture.avs.device.json.object.devicemanager.UnassignSTB;
import com.accenture.avs.device.util.NotificationDto;

/**
 * Interface for DeviceDmlServiceImpl
 * 
 * @author Singh.Saurabh
 *
 */
public interface DeviceDmlService {

	/**
	 * This method validates and creates Device
	 * 
	 * @param deviceDto
	 * @param lastUpdateUserName
	 * 
	 */
	void createDevice(DeviceDto deviceDto, String lastUpdateUserName);
	
	/**
	 * This method validates and Assigns Device to the intended Subscriber.
	 * 
	 * @param stbToAssign
	 * @param userId
	 * 
	 */
	NotificationDto assignDevice(STBAssignmentDetail stbToAssign, String userId);
	
	/**
	 * This method validate and then creating and assigning new Device to the
	 * intended Subscriber.
	 * 
	 * @param assignSTB
	 * @param userId
	 * @param hardwareVersion
	 * 
	 */
	NotificationDto createAndAssign(AssignSTB assignSTB, String userId, Model hardwareVersion);
	
	/**
	 * This method validates and registers Device by Auto-Config
	 * 
	 * @param stbRegistration
	 * @param extIdAddress
	 * @param userId
	 * 
	 * @return STBAssigned
	 */
	NotificationDto autoConfig(STBRegistration stbRegistration, String extIdAddress, String userId);
	
	/**
	 * This method validates and Unassigns/Unregisters Device for the intended Subscriber.
	 * 
	 * @param unassignSTB
	 * @param userId
	 * 
	 */
	NotificationDto unAssignDevice(UnassignSTB unassignSTB, String userId);
}
