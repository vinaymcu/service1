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

import java.util.List;

import com.accenture.avs.device.entity.ConnectionMode;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.Model;
//import com.accenture.avs.device.entity.StbUdf;
import com.accenture.avs.device.entity.Subscriber;
import com.accenture.avs.device.json.object.devicemanager.DeviceDetails;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceListResponse;
import com.accenture.avs.device.json.object.devicemanager.STBRegistration;
import com.accenture.avs.device.json.object.devicemanager.SetTopBoxDetails;
import com.accenture.avs.device.json.object.resourcemanager.STBProfile;

/**
 * This is a Helper Class for DeviceServiceBeanImpl.
 * 
 * @author Singh.Saurabh
 *
 */
public interface DeviceServiceHelper {

	/**
	 * This method finds the device model in database. If found then
	 * returns, else throws error.
	 * 
	 * @param deviceModel
	 * @param checkIsActive
	 * 
	 * @return
	 */
	Model getDeviceModel(String deviceModel, boolean checkIsActive);
	
	/**
	 * This method is only used for CreateAndAssignDevice. It allows the
	 * HardwareVersion to commit in the database even if the CreateAndAssignDevice
	 * request fails.
	 * 
	 * @param hwVersionName
	 * @return
	 */
	Model getHardwareVersionAndSave(String hwVersionName);
	
	/**
	 * This method finds the Subscriber in database. If found, then
	 * returns, else it calls AVS Mediator to getSubscriber
	 * and save received Subscriber Details in database and returns.
	 * 
	 * @param accountNumber
	 * 
	 * @return Subscriber
	 */
	Subscriber getSubscriber(String accountNumber);
	
	/**
	 * This method calls AVS Mediator to get the DeviceProfile for the
	 * Subscriber.
	 * 
	 * @param assignedToUserName
	 * @param assignedDevicesList
	 * 
	 * @return StbProfile
	 */
	STBProfile getDeviceProfile(String assignedToUserName, List<Device> assignedDevicesList);
	
	/**
	 * This method calculates the connection mode of the Device.
	 * 
	 * @param supportedModes
	 * @param ipAddress
	 * @param extIpAddress
	 * 
	 * @return ConnectionMode
	 */
	ConnectionMode getConnectionMode(String supportedModes, String ipAddress, String extIpAddress);
	
	/**
	 * This method returns Device according to provided value
	 * 
	 * @param macAddress
	 * @param equipmentId
	 * 
	 * @return Device
	 */
	Device getDevice(String macAddress, Integer equipmentId);
	
	/**
	 * This method returns Device according to provided device id
	 * 
	 * @param deviceId
	 * @return
	 */
	Device getDevice(String deviceId);
	
	/**
	 * This method performs following operations:-
	 * 1. Call ResourceManager to "Get Device Profiles" 
	 * 2. Update Device Profile in database 
	 * 
	 * @param assignedToUserName
	 * @param device
	 * @param isUnassigned
	 * @return
	 * 
	 */
	List<Long> calculateDeviceProfile(String assignedToUserName, Device device, boolean isUnassigned);
	
	/**
	 * This method checks if the Global data is Synced in database. If not and
	 * then call AVS Mediator to getGlobalData and saves in database.
	 * 
	 * @return
	 */
	boolean syncGlobalData();
	
	/**
	 * This method updates internal and external ip of the Device according to the
	 * assigned connection mode.
	 * 
	 * @param device
	 * @param ipAddress
	 * @param extIpAddress
	 */
	void updateInternalExternalIpAddress(Device device, String ipAddress, String extIpAddress);

	/**
	 * This method sends notification to OSS-BSS client.
	 * 
	 * @param deviceRegistration
	 * @param extIpAddress
	 * @param assignedConnectionMode
	 * 
	 */
	void sendNotificationToOssBssClient(STBRegistration deviceRegistration, String extIpAddress,
			String assignedConnectionMode);
	
	/**
	 * This generates a unique device name for the Subscriber. The default name will
	 * be DEVICE_X where X shall be replaced incrementally in such way a subscriber
	 * shall not have two devices with same name
	 * 
	 * @param assignedToUserName
	 * @return
	 */
	String getDeviceName(String assignedToUserName);
	
	/**
	 * This method validates if the Device Auto registration is allowed or if it is
	 * already assigned.
	 * 
	 * @param device
	 * @param hardwareVersion
	 * @param deviceRegistration
	 * 
	 * @return SetTopBox
	 */
	Device validateAutoRegistrationAndDeviceAssignment(Device device,
			Model hardwareVersion, STBRegistration deviceRegistration);
	
	/**
	 * This method validates if Device assigned Resources are valid or not.
	 * If valid, then saves them.
	 * 
	 * @param createDeviceRequest
	 * @param entity
	 */
	 void validateAndSaveDeviceAssignedResources(com.accenture.avs.device.json.object.devicemanager.SetTopBox createDeviceRequest,
			 Device entity);
	
	/**
	 * This method calls validator to validate request parameters
	 * 
	 * @param request
	 * @param jsonFileName
	 */
	<T> void validateRequestParameters(T request, String jsonFileName);

	/**
	 * 
	 * @param searchBy
	 * @param searchValue
	 * @param searchOperation
	 * @param sortBy
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	GetDeviceListResponse getDeviceList(String searchBy, String searchValue, String searchOperation, String sortBy,
			Integer startIndex, Integer pageSize);
}
