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

import com.accenture.avs.device.json.object.devicemanager.AssignSetTopBox;
import com.accenture.avs.device.json.object.devicemanager.AutoConfig;
import com.accenture.avs.device.json.object.devicemanager.AutoConfigResponse;
import com.accenture.avs.device.json.object.devicemanager.CreateAndAssignSTB;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceRequest;
import com.accenture.avs.device.json.object.devicemanager.DeviceDetails;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceAuditLogsResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceListResponse;
import com.accenture.avs.device.json.object.devicemanager.GetUserDevicesResponse;
import com.accenture.avs.device.json.object.devicemanager.STBPortMappings;
import com.accenture.avs.device.json.object.devicemanager.STBProperties;
import com.accenture.avs.device.json.object.devicemanager.STBPropertiesResponse;
import com.accenture.avs.device.json.object.devicemanager.SetTopBoxDelete;
import com.accenture.avs.device.json.object.devicemanager.SubscriberDelete;
import com.accenture.avs.device.json.object.devicemanager.Subscribers;
//import com.accenture.avs.device.json.object.devicemanager.UDFDefinitions;
import com.accenture.avs.device.json.object.devicemanager.UnassignSetTopBox;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceRequest;
import com.accenture.avs.device.json.object.devicemanager.UpdateSubscriber;
import com.accenture.avs.device.json.object.devicemanager.UpdatedStbListingResponse;

/**
 * The Interface DeviceService
 * 
 * @author Singh.Saurabh
 *
 */
public interface DeviceService {

	/**
	 * This method validates and creates a new Device
	 * 
	 * @param createDeviceRequest
	 * @param lastUpdateUserName
	 * 
	 * @return
	 */
	GenericResponse createDevice(CreateDeviceRequest createDeviceRequest, String lastUpdateUserName);

	/**
	 * This method validates and assigns Device to the intended Subscriber.
	 * 
	 * @param assignSetTopBox
	 * @param userId
	 * 
	 * @return GenericResponse
	 */
	GenericResponse assignDevice(AssignSetTopBox assignSetTopBox, String userId);

	/**
	 * This method Creates and Assigns Device to the Subscriber.
	 * 
	 * @param createAndAssignSTB
	 * @param userId
	 * @return
	 */
	GenericResponse createAndAssignDevice(CreateAndAssignSTB createAndAssignSTB, String userId);

	/**
	 * This method validates and registers Device.
	 * 
	 * @param autoConfig
	 * @param extIdAddress
	 * @param userId
	 * 
	 * @return
	 */
	AutoConfigResponse autoConfig(AutoConfig autoConfig, String extIdAddress, String userId);

	/**
	 * This method updates the device.
	 * 
	 * @param updateDeviceRequest
	 * @param lastUpdateUserName
	 * 
	 * @return GenericResponse
	 */
	GenericResponse updateDevice(UpdateDeviceRequest updateDeviceRequest, String lastUpdateUserName);

	/**
	 * Removes devices.
	 * 
	 * @param setTopBoxDelete
	 * @return GenericResponse
	 */
	GenericResponse removeDevices(SetTopBoxDelete setTopBoxDelete);


	/**
	 * This method validates and Unassigns/Unregister Device for the intended
	 * Subscriber.
	 * 
	 * @param unassignSetTopBox
	 * @param userId
	 * 
	 * @return GenericResponse
	 */
	GenericResponse unassignDevice(UnassignSetTopBox unassignSetTopBox, String userId);
	
	/**
	 * This method validates and create/update/delete Device properties.
	 * 
	 * @param stbProperties
	 * @param extIpAddress
	 * @param authenticationCookie
	 * 
	 * @return STBProperties
	 */
	STBPropertiesResponse setDeviceProperties(STBProperties stbProperties, String extIpAddress, String authenticationCookie);
	
	/**
	 * This method validates and gets Device properties.
	 * 
	 * @param extIpAddress
	 * @param authenticationCookie
	 * 
	 * @return STBPropertiesResponse
	 */
	STBPropertiesResponse getDeviceProperties(String extIpAddress, String authenticationCookie);
	
	/**
	 * This method validates and create/update/delete Device Port Mappings.
	 * 
	 * @param stbPortMappings
	 * @param extIpAddress
	 * @param authenticationCookie
	 * 
	 * @return GenericResponse
	 */
	GenericResponse setDevicePortMappings(STBPortMappings stbPortMappings, String extIpAddress,
			String authenticationCookie);

	/**
	 * This method gets the list of subscribers who’s Devices have been updated
	 * within the given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return UpdatedStbListingResponse
	 */
	UpdatedStbListingResponse getUpdatedDeviceListing(Long startDate, Long endDate);
	
	/**
	 * This method gets the audit logs of all the updates done on the requested
	 * devices using offset and maxResult
	 * 
	 * @param deviceId
	 * @param startIndex
	 * @param maxResults
	 * 
	 * @return GetDeviceAuditLogsResponse
	 */
	GetDeviceAuditLogsResponse getDeviceAuditLogs(String deviceId, Integer startIndex, Integer maxResults);

	/**
	 * Creates subscribers.
	 * 
	 * @param subscribers
	 * @return GenericResponse
	 */
	GenericResponse createSubscribers(Subscribers subscribers);

	/**
	 * Updates subscribers.
	 * 
	 * @param updateSubscriber
	 * @return GenericResponse
	 */
	GenericResponse updateSubscribers(UpdateSubscriber updateSubscriber);

	/**
	 * Deletes subscribers.
	 * 
	 * @param subscriberDelete
	 * @return GenericResponse
	 */
	GenericResponse deleteSubscribers(SubscriberDelete subscriberDelete);
	
	/**
	 * Gets user devices response.
	 * @param userNames
	 * @param limitDeviceFields
	 * @return GetUserDevicesResponse
	 */
	GetUserDevicesResponse getUserDevices(List<String> userNames, Boolean limitDeviceFields);
	

	/**
	 * This method returns the Device details for the provided deviceId.
	 * @param deviceId
	 * @return
	 */
	DeviceDetails getDeviceDetails(String deviceId);

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
