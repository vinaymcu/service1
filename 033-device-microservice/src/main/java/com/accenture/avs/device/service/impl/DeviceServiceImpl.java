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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.config.SystemMessage;
import com.accenture.avs.device.config.client.ConfigurationClient;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceAudit;
import com.accenture.avs.device.entity.DeviceProperty;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.TokenException;
import com.accenture.avs.device.json.object.devicemanager.AssignSTB;
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
import com.accenture.avs.device.json.object.devicemanager.ResultObject;
import com.accenture.avs.device.json.object.devicemanager.STBAssignmentDetail;
import com.accenture.avs.device.json.object.devicemanager.STBPortMappings;
import com.accenture.avs.device.json.object.devicemanager.STBProperties;
import com.accenture.avs.device.json.object.devicemanager.STBPropertiesResponse;
import com.accenture.avs.device.json.object.devicemanager.SetTopBoxDelete;
import com.accenture.avs.device.json.object.devicemanager.SubscriberDelete;
import com.accenture.avs.device.json.object.devicemanager.Subscribers;
import com.accenture.avs.device.json.object.devicemanager.UnassignSTB;
import com.accenture.avs.device.json.object.devicemanager.UnassignSetTopBox;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceRequest;
import com.accenture.avs.device.json.object.devicemanager.UpdateSubscriber;
import com.accenture.avs.device.json.object.devicemanager.UpdatedStbListingResponse;
import com.accenture.avs.device.service.DeviceAuditLogsService;
import com.accenture.avs.device.service.DeviceDmlService;
import com.accenture.avs.device.service.DevicePropertiesService;
import com.accenture.avs.device.service.DeviceService;
import com.accenture.avs.device.service.DeviceServiceHelper;
import com.accenture.avs.device.service.GetUserDevicesService;
import com.accenture.avs.device.service.PushMessageService;
import com.accenture.avs.device.service.RemoveDeviceService;
import com.accenture.avs.device.service.StbGlobalDataService;
import com.accenture.avs.device.service.SubscriberCreationService;
import com.accenture.avs.device.service.SubscriberDeletionService;
import com.accenture.avs.device.service.SubscriberUpdateService;
import com.accenture.avs.device.service.UpdateDeviceService;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.NotificationDto;
import com.accenture.avs.device.util.RequestResponseGenerator;
import com.accenture.avs.device.util.tokenmanager.Token;
import com.accenture.avs.device.util.tokenmanager.TokenManager;

/**
 * The Class DeviceServiceImpl.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceServiceImpl.class);

	/** deviceDmlService */
	@Autowired
	private DeviceDmlService deviceDmlService;
	
	/** devicePropertiesService */
	@Autowired
	private DevicePropertiesService devicePropertiesService;

	/** subscriberCreationService */
	@Autowired
	SubscriberCreationService subscriberCreationService;

	/** subscriberUpdateService */
	@Autowired
	SubscriberUpdateService subscriberUpdateService;

	/** subscriberDeletionService */
	@Autowired
	SubscriberDeletionService subscriberDeletionService;

	/** getUserDevicesService */
	@Autowired
	GetUserDevicesService getUserDevicesService;

	/** deviceGlobalDataService */
	@Autowired
	StbGlobalDataService deviceGlobalDataService;
	
	/** stbAuditLogsService */
	@Autowired
	DeviceAuditLogsService deviceAuditLogsService;

	/** configClient */
	@Autowired
	private ConfigurationClient configClient;

	/** removeStbService */
	@Autowired
	RemoveDeviceService removeStbService;

	/** updateDeviceService */
	@Autowired
	UpdateDeviceService updateDeviceService;
	
	/** deviceServiceHelper */
	@Autowired
	private DeviceServiceHelper deviceServiceHelper;
	
	/** unicastNotifierService */
	@Autowired
	private PushMessageService unicastNotifierService;

	/**
	 * This method validates and creates a new Device
	 * 
	 * @param createDeviceRequest
	 * @param lastUpdateUserName
	 * 
	 * @return
	 */
	@Override
	public GenericResponse createDevice(CreateDeviceRequest createDeviceRequest, String lastUpdateUserName) {
		long startTime = System.currentTimeMillis();
		deviceDmlService.createDevice(createDeviceRequest.getDevice(), lastUpdateUserName);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getGenericResponse(null, 1, 0, executionTime);
	}

	/**
	 * This method validates and assigns Device to the intended Subscriber.
	 * 
	 * @param assignDevice
	 * @param userId
	 * 
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse assignDevice(AssignSetTopBox assignDevice, String userId) {
		long startTime = System.currentTimeMillis();
		List<ResultObject> resultObjectList = new ArrayList<ResultObject>();

		int successfulRequests = 0;
		int failedRequests = 0;

		for (STBAssignmentDetail deviceToAssign : assignDevice.getSTBAssignmentDetails()) {
			try {
				NotificationDto dto = deviceDmlService.assignDevice(deviceToAssign, userId);
				successfulRequests++;
				if (dto!=null) {
					unicastNotifierService.sendNotification(dto.getEquipmentIdListForNotification(),
							dto.getSubscriberId(), dto.getTriggerType(), dto.getTriggerInfo());
				}
			} catch (Exception exception) {
				getErrorResponse(exception,
						DeviceManagerUtil.getFailureResponseId(deviceToAssign.getMACAddress(), deviceToAssign.getEquipmentId()),
						resultObjectList, null, Boolean.TRUE);
				failedRequests++;
			}
		}
		
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMessage("Assign Device request :: Total Requests = " + assignDevice.getSTBAssignmentDetails().size()
				+ ", Successful= " + successfulRequests + ", Failed=" + failedRequests);
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getGenericResponse(resultObjectList, successfulRequests, failedRequests, executionTime);
	}

	/**
	 * This method validate and then creating and assigning new Device to the
	 * intended Subscriber.
	 * 
	 * @param createAndAssignDevice
	 * @param userId
	 * 
	 * @return GenericResponse
	 * 
	 */
	@Override
	public GenericResponse createAndAssignDevice(CreateAndAssignSTB createAndAssignDevice, String userId) {
		long startTime = System.currentTimeMillis();
		List<ResultObject> resultObjectList = new ArrayList<ResultObject>();
		int successfulRequests = 0;
		int failedRequests = 0;

		for (AssignSTB assignDevice : createAndAssignDevice.getAssignSTBs()) {
			try {
				Model hardwareVersion = deviceServiceHelper.getHardwareVersionAndSave(assignDevice.getHardwareVersion());
				NotificationDto dto = deviceDmlService.createAndAssign(assignDevice, userId, hardwareVersion);
				successfulRequests++;
				if (dto!=null) {
					unicastNotifierService.sendNotification(dto.getEquipmentIdListForNotification(),
							dto.getSubscriberId(), dto.getTriggerType(), dto.getTriggerInfo());
				}
			} catch (Exception exception) {
				getErrorResponse(exception, assignDevice.getMACAddress(), resultObjectList, null, Boolean.TRUE);
				failedRequests++;
			}
		}
		
		LOGGER.logMessage("CreateAndAssign Device request :: Total Requests = " + createAndAssignDevice.getAssignSTBs().size()
				+ ", Successful= " + successfulRequests + ", Failed=" + failedRequests);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getGenericResponse(resultObjectList, successfulRequests, failedRequests, executionTime);
	}

	/**
	 * This method validates and registers Device by Auto-Config
	 * 
	 * @param autoConfig
	 * @param extIdAddress
	 * @param userId
	 * 
	 * @return AutoConfigResponse
	 */
	@Override
	public AutoConfigResponse autoConfig(AutoConfig autoConfig, String extIdAddress, String userId) {
		long startTime = System.currentTimeMillis();
		NotificationDto dto = deviceDmlService.autoConfig(autoConfig.getSTBRegistration(), extIdAddress, userId);
		if (dto != null) {
			unicastNotifierService.sendNotification(dto.getEquipmentIdListForNotification(), dto.getSubscriberId(),
					dto.getTriggerType(), dto.getTriggerInfo());
		}
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getAutoConfigResponse(null,
				dto.getDevice().getId().intValue(), dto.getDevice().getDeviceId(), executionTime);
	}

	/**
	 * This method validates and Unassigns/Unregister Device for the intended
	 * Subscriber.
	 * 
	 * @param unassignDevices
	 * @param userId
	 * 
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse unassignDevice(UnassignSetTopBox unassignDevices, String userId) {
		long startTime = System.currentTimeMillis();
		
		List<ResultObject> resultObjectList = new ArrayList<ResultObject>();
		int successfulRequests = 0;
		int failedRequests = 0;

		for (UnassignSTB unassignDevice : unassignDevices.getUnassignSTBs()) {
			try {
				NotificationDto dto = deviceDmlService.unAssignDevice(unassignDevice, userId);
				successfulRequests++;
				if (dto!=null) {
					unicastNotifierService.sendNotification(dto.getEquipmentIdListForNotification(),
							dto.getSubscriberId(), dto.getTriggerType(), dto.getTriggerInfo());
				}
			} catch (Exception exception) {
				getErrorResponse(exception,
						DeviceManagerUtil.getFailureResponseId(unassignDevice.getMACAddress(), unassignDevice.getEquipmentId()),
						resultObjectList, null, Boolean.TRUE);
				failedRequests++;
			}
		}
		LOGGER.logMessage("Unassign Device request :: Total Requests = " + unassignDevices.getUnassignSTBs().size()
				+ ", Successful= " + successfulRequests + ", Failed=" + failedRequests);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getGenericResponse(resultObjectList, successfulRequests, failedRequests, executionTime);
	}

	/**
	 * This method validates and create/update/delete Device properties.
	 * 
	 * @param deviceProperties
	 * @param extIpAddress
	 * @param authenticationCookie
	 * 
	 * @return STBPropertiesResponse
	 */
	@Override
	public STBPropertiesResponse setDeviceProperties(STBProperties deviceProperties, String extIpAddress,
			String authenticationCookie) {
		long startTime = System.currentTimeMillis();
		List<DeviceProperty> devicePropertyList = new ArrayList<>();
		try {
			Token stbToken = TokenManager.parseJWT(authenticationCookie);

			String macAddress = stbToken.getPayload().getDeviceInfo().getDeviceId();
			String subscriberId = stbToken.getPayload().getUserId();

			devicePropertyList = devicePropertiesService.setDeviceProperties(deviceProperties, extIpAddress, macAddress,
					subscriberId);
		} catch (TokenException tokenException) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_LOGGED, tokenException);
		}
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getSTBPropertiesResponse(devicePropertyList, executionTime);
	}

	/**
	 * This method validates and gets Device properties.
	 * 
	 * @param extIpAddress
	 * @param authenticationCookie
	 * 
	 * @return STBPropertiesResponse
	 */
	@Override
	public STBPropertiesResponse getDeviceProperties(String extIpAddress, String authenticationCookie) {
		long startTime = System.currentTimeMillis();
		
		List<DeviceProperty> deviceProperties = new ArrayList<>();
		try {
			Token deviceToken = TokenManager.parseJWT(authenticationCookie);
			
	        String macAddress = deviceToken.getPayload().getDeviceInfo().getDeviceId();
	        String subscriberId = deviceToken.getPayload().getUserId();
	        
	        deviceProperties = devicePropertiesService.getDeviceProperties(extIpAddress, macAddress, subscriberId);
		} catch (TokenException tokenException) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_LOGGED, tokenException);
		}
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getSTBPropertiesResponse(deviceProperties, executionTime);
	}

	/**
	 * This method validates and create/update/delete Device Port Mappings.
	 * 
	 * @param devicePortMappings
	 * @param extIpAddress
	 * @param authenticationCookie
	 * 
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse setDevicePortMappings(STBPortMappings devicePortMappings, String extIpAddress,
			String authenticationCookie) {
		long startTime = System.currentTimeMillis();
		try {
			Token deviceToken = TokenManager.parseJWT(authenticationCookie);

			String macAddress = deviceToken.getPayload().getDeviceInfo().getDeviceId();
			String subscriberId = deviceToken.getPayload().getUserId();

			devicePropertiesService.setDevicePortMappings(devicePortMappings, extIpAddress, macAddress, subscriberId);
		} catch (TokenException tokenException) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_LOGGED, tokenException);
		}
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getGenericResponse(null, 1, 0, executionTime);
	}
	
	/**
	 * This method gets the list of subscribers who’s Devices have been updated within
	 * the given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return UpdatedStbListingResponse
	 */
	@Override
	public UpdatedStbListingResponse getUpdatedDeviceListing(Long startDate, Long endDate) {
		long startTime = System.currentTimeMillis();
		Map<String, Long> updatedAccountsList = updateDeviceService.getUpdatedDeviceListing(startDate, endDate);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getUpdatedDeviceListingResponse(updatedAccountsList, executionTime);
	}

	/**
	 * This method gets the audit logs of all the updates done on the requested
	 * devices using offset and max results.
	 * 
	 * @param deviceId
	 * @param startIndex
	 * @param maxResults
	 * 
	 * @return GetDeviceAuditLogsResponse
	 */
	@Override
	public GetDeviceAuditLogsResponse getDeviceAuditLogs(String deviceId, Integer startIndex, Integer maxResults) {
		long methodStartTime = System.currentTimeMillis();
		List<DeviceAudit> deviceAuditList = deviceAuditLogsService.getDeviceAuditLogs(deviceId, startIndex, maxResults);
		Long executionTime = System.currentTimeMillis() - methodStartTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getSetTopBoxAuditLogsResponse(deviceAuditList);
	}
	
	/**
	 * This method adds an Error ResultObject in the provided ResultObject List.
	 * 
	 * @param exception
	 * @param id
	 * @param resultObjectList
	 * @param isGenericResponse
	 * 
	 */
	private void getErrorResponse(Exception exception, String id, List<ResultObject> resultObjectList,
			List<com.accenture.avs.device.json.object.devicemanager.Error> errorList, boolean isGenericResponse) {
		SystemMessage sysMessage = null;
		String failureResultCode;
		String failureResultDescription;
		if (exception instanceof DeviceManagerException) {			
			DeviceManagerException stbException = (DeviceManagerException) exception;
			sysMessage = configClient.findSystemMessage(IdentificationType.defaultLanguage.getProperty(),
					stbException.getErrorCode().getCode());
		} else {
			sysMessage = configClient.findSystemMessage(IdentificationType.defaultLanguage.getProperty(),
					ErrorCode.GENERIC_ERROR.getCode());
		}
		failureResultCode = sysMessage.getMessageCode();
		failureResultDescription = sysMessage.getMessageText();
		LOGGER.logError(exception, failureResultDescription);
		if (isGenericResponse) {
			RequestResponseGenerator.getGenericResultObject(resultObjectList, id, failureResultCode,
					failureResultDescription);
		} else {
			RequestResponseGenerator.getErrorObject(errorList, id, failureResultCode, failureResultDescription);
		}
	}

	/**
	 * This method updates the device.
	 * 
	 * @param updateDeviceRequest
	 * @param lastUpdateUserName
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse updateDevice(UpdateDeviceRequest updateDeviceRequest, String lastUpdateUserName) {
		long startTime = System.currentTimeMillis();
		updateDeviceService.updateDevice(updateDeviceRequest.getDevice(), lastUpdateUserName);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getGenericResponse(null, 1, 0, executionTime);
	}

	/**
	 * Removes devices.
	 * 
	 * @param deviceDelete
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse removeDevices(SetTopBoxDelete deviceDelete) {
		long startTime = System.currentTimeMillis();
		GenericResponse response = removeStbService.removeDevices(deviceDelete);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return response;
	}

	/**
	 * Creates subscribers.
	 * 
	 * @param subscribers
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse createSubscribers(Subscribers subscribers) {
		long startTime = System.currentTimeMillis();
		GenericResponse response = subscriberCreationService.createSubscribers(subscribers);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return response;
	}

	/**
	 * Updates subscribers.
	 * 
	 * @param updateSubscriber
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse updateSubscribers(UpdateSubscriber updateSubscriber) {
		long startTime = System.currentTimeMillis();
		GenericResponse response = subscriberUpdateService.updateSubscribers(updateSubscriber);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return response;
	}

	/**
	 * Deletes subscribers.
	 * 
	 * @param subscriberDelete
	 * @return GenericResponse
	 */
	@Override
	public GenericResponse deleteSubscribers(SubscriberDelete subscriberDelete) {
		long startTime = System.currentTimeMillis();
		GenericResponse response = subscriberDeletionService.deleteSubscribers(subscriberDelete);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return response;
	}	


	/**
	 * Gets user devices response.
	 * @param userNames
	 * @param limitDeviceFields
	 * @return GetUserDevicesResponse
	 */
	@Override
	public GetUserDevicesResponse getUserDevices(List<String> userName, Boolean limitDeviceFields) {
		long startTime = System.currentTimeMillis();
		GetUserDevicesResponse response = getUserDevicesService.getUserDevices(userName, limitDeviceFields);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return response;
	}

	/**
	 * This method returns the Device details for the provided deviceId.
	 * 
	 * @param deviceId
	 * @return
	 */
	@Override
	public DeviceDetails getDeviceDetails(String deviceId) {
		long startTime = System.currentTimeMillis();
		LOGGER.logMessage("GetDeviceDetails for deviceId={}", deviceId);
		Device deviceEntity = deviceServiceHelper.getDevice(deviceId);
		LOGGER.logMessage("GetDeviceDetails for deviceId={} successful", deviceId);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getDeviceDetailsResponse(deviceEntity, executionTime);
	}

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
	@Override
	public GetDeviceListResponse getDeviceList(String searchBy, String searchValue, String searchOperation, String sortBy,
			Integer startIndex, Integer pageSize) {
		long startTime = System.currentTimeMillis();
		GetDeviceListResponse response = deviceServiceHelper.getDeviceList(searchBy, searchValue, searchOperation, sortBy, startIndex,
				pageSize);
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMethodEnd(executionTime);
		return response;
	}
}
