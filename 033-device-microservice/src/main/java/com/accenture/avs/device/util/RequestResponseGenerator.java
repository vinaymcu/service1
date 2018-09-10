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

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceAudit;
import com.accenture.avs.device.entity.DeviceProperty;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.entity.ModelMaxStreamsAllowedPerQuality;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.json.object.devicemanager.AssignedResources;
import com.accenture.avs.device.json.object.devicemanager.AutoConfigResponse;
import com.accenture.avs.device.json.object.devicemanager.DeviceDetails;
import com.accenture.avs.device.json.object.devicemanager.DeviceDetailsResultObject;
import com.accenture.avs.device.json.object.devicemanager.DeviceDto;
import com.accenture.avs.device.json.object.devicemanager.DeviceLogDTO;
import com.accenture.avs.device.json.object.devicemanager.DeviceLogs;
import com.accenture.avs.device.json.object.devicemanager.DeviceModelListDto;
import com.accenture.avs.device.json.object.devicemanager.DeviceModelResultObj;
import com.accenture.avs.device.json.object.devicemanager.Error;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceAuditLogsResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceModelListResponse;
import com.accenture.avs.device.json.object.devicemanager.MaxStreamsPerQuality;
import com.accenture.avs.device.json.object.devicemanager.PortMapping;
import com.accenture.avs.device.json.object.devicemanager.Property;
import com.accenture.avs.device.json.object.devicemanager.ResultObject;
import com.accenture.avs.device.json.object.devicemanager.STBAssigned;
import com.accenture.avs.device.json.object.devicemanager.STBDetailList;
import com.accenture.avs.device.json.object.devicemanager.STBPropertiesResponse;
//import com.accenture.avs.device.json.object.devicemanager.SetTopBoxUDF;
import com.accenture.avs.device.json.object.devicemanager.StbAssignedResultObj;
import com.accenture.avs.device.json.object.devicemanager.StbPropertiesResultObj;
import com.accenture.avs.device.json.object.devicemanager.UpdatedAccount;
import com.accenture.avs.device.json.object.devicemanager.UpdatedProfiles;
import com.accenture.avs.device.json.object.devicemanager.UpdatedStbListingResponse;
import com.accenture.avs.device.json.object.resourcemanager.AssignedDevice;
import com.accenture.avs.device.json.object.resourcemanager.GetProfileReq;
import com.accenture.avs.device.json.object.resourcemanager.Subscriber;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdate;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdateRequest;

/**
 * This class generates Request and Response objects.
 * 
 * @author singh.saurabh
 *
 */
public class RequestResponseGenerator {

	/**
	 * This method generates a GetDeviceProfiles Request
	 * 
	 * @param sub
	 * @param assignedDevicesList
	 * @return
	 */
	public static GetProfileReq getDeviceProfileRequest(String assignedToUserName,
			List<Device> assignedDevicesList) {

		// Devices assigned to the Subscriber
		List<AssignedDevice> assignedDevices = getAssignedResourceList(assignedDevicesList);

		Subscriber subscriber = new Subscriber();
		subscriber.setAssignedDevices(assignedDevices);

		GetProfileReq getProfileReq = new GetProfileReq();
		getProfileReq.setSubscriber(subscriber);

		return getProfileReq;
	}
	
	/**
	 * This method returns GetDeviceModelListResponse corresponding to the provided
	 * Model Entity list.
	 * 
	 * @param modelEntityList
	 * @param resultCode
	 * @param resultDescription
	 * @param executionTime
	 * @return
	 */
	public static GetDeviceModelListResponse getGetDeviceModelListResponse(List<Model> modelEntityList,
			String resultCode, String resultDescription, Long executionTime) {
		List<DeviceModelListDto> deviceModelDtoList = new ArrayList<>();
		for (Model modelEntity : modelEntityList) {
			deviceModelDtoList.add(getDeviceModelListDto(modelEntity));
		}

		DeviceModelResultObj deviceModelResultObj = new DeviceModelResultObj();
		deviceModelResultObj.setDeviceModelList(deviceModelDtoList);
		deviceModelResultObj.setTotalResults(deviceModelDtoList.size());

		GetDeviceModelListResponse getDeviceModelListResponse = new GetDeviceModelListResponse();
		getDeviceModelListResponse.setResultCode(resultCode);
		getDeviceModelListResponse.setResultDescription(resultDescription);
		getDeviceModelListResponse.setExecutionTime(executionTime.intValue());
		getDeviceModelListResponse.setResultObj(deviceModelResultObj);

		return getDeviceModelListResponse;
	}

	/**
	 * This method returns DeviceModelListDto corresponding to the provided Model
	 * Entity.
	 * 
	 * @param deviceModelEntity
	 * @return DeviceModelListDto
	 */
	private static DeviceModelListDto getDeviceModelListDto(Model deviceModelEntity) {
		DeviceModelListDto objDeviceModelListDto = new DeviceModelListDto();
		objDeviceModelListDto.setDeviceModel(deviceModelEntity.getModelName());
		objDeviceModelListDto.setVendor(deviceModelEntity.getVendor());
		objDeviceModelListDto.setPlatform(deviceModelEntity.getPlatform());
		objDeviceModelListDto.setOsName(deviceModelEntity.getOsName());
		objDeviceModelListDto.setOsVersion(deviceModelEntity.getOsVersion());
		objDeviceModelListDto.setSwId(deviceModelEntity.getSoftwareVersion());
		objDeviceModelListDto.setQoeCapable(deviceModelEntity.getQoeCapable());
		objDeviceModelListDto.setUiVersion(deviceModelEntity.getUiVersion());
		objDeviceModelListDto.setSdChannelTimeshiftBuffer(
				DeviceManagerUtil.convertLongToInteger(deviceModelEntity.getSdChannelTimeshiftBuffer()));
		objDeviceModelListDto.setHdChannelTimeshiftBuffer(
				DeviceManagerUtil.convertLongToInteger(deviceModelEntity.getHdChannelTimeshiftBuffer()));
		objDeviceModelListDto.setStatus(DeviceManagerUtil.convertBooleanToInt(deviceModelEntity.getStatus()));
		objDeviceModelListDto.setVqeProfile(deviceModelEntity.getVqeProfile());
		objDeviceModelListDto.setDeviceAutoRegistration(deviceModelEntity.getDisableDeviceAutoRegistration());
		objDeviceModelListDto.setLastUpdatedInterface(deviceModelEntity.getLastUpdateInterface());
		objDeviceModelListDto.setLastUpdateUserName(deviceModelEntity.getLastUpdateUsername());

		List<MaxStreamsPerQuality> maxStreamsPerQuality = objDeviceModelListDto.getMaxStreamsPerQuality();
		for (ModelMaxStreamsAllowedPerQuality maxStream : deviceModelEntity.getModelMaxStreamsAllowedPerQuality()) {
			MaxStreamsPerQuality objMaxStreamsPerQuality = new MaxStreamsPerQuality();
			objMaxStreamsPerQuality.setContentQuality(maxStream.getId().getResolutionTypeName());
			objMaxStreamsPerQuality.setStreamLimit(DeviceManagerUtil.convertLongToInteger(maxStream.getMaxStreams()));
			maxStreamsPerQuality.add(objMaxStreamsPerQuality);
		}
		objDeviceModelListDto.setMaxStreamsPerQuality(maxStreamsPerQuality);
		return objDeviceModelListDto;
	}
	
	/**
	 * This method returns assigned resource list
	 * 
	 * @param assignedDevicesList
	 * @return List<AssignedDevice>
	 */
	private static List<AssignedDevice> getAssignedResourceList(List<Device> assignedDevicesList) {
		List<AssignedDevice> assignedDevices = new ArrayList<>();
		for (Device device : assignedDevicesList) {
			AssignedDevice assignedDevice = new AssignedDevice();
			assignedDevice.setEquipmentID(String.valueOf(device.getId()));
			assignedDevice.setHWVersion(device.getModel().getModelName());
			assignedDevice.setTvQualityInterest(device.getTvQualityInterest());
			assignedDevice.setAssigmentDateTime(String.valueOf(device.getDatetimeOfAssignment()));
			assignedDevices.add(assignedDevice);
		}
		return assignedDevices;
	}

	/**
	 * This method generates a EventUpdate Request
	 * 
	 * @param subscriberId
	 * @param macAddressList
	 * @param triggerName
	 * @param triggerInfo
	 * 
	 * @return EventUpdate
	 */
	public static EventUpdateRequest getEventUpdateRequest(String subscriberId, List<String> macAddressList,
			String triggerName, String triggerInfo) {

		EventUpdate event = new EventUpdate();
		event.setTriggerInfo(triggerInfo);
		event.setTriggerType(triggerName);
		event.setSubscriberId(subscriberId);
		event.setMACAddress(macAddressList);
		event.setTimestamp(String.valueOf(Instant.now().getEpochSecond()));

		EventUpdateRequest eventUpdateRequest = new EventUpdateRequest();
		eventUpdateRequest.setEventUpdate(event);
		return eventUpdateRequest;
	}

	/**
	 * This method returns DeviceDetails Object
	 * 
	 * @param deviceEntity
	 * @param executionTime
	 * 
	 * @return
	 */
	public static DeviceDetails getDeviceDetailsResponse(Device deviceEntity, Long executionTime) {
		DeviceDto deviceDto = new DeviceDto();
		deviceDto.setDeviceId(deviceEntity.getDeviceId());
		deviceDto.setDeviceName(deviceEntity.getDeviceName());
		deviceDto.setDeviceType(deviceEntity.getDeviceType());
		deviceDto.setDrmId(deviceEntity.getDrmId());
		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getMaxBandwidthUpdate())) {
			deviceDto.setMaxBandwidthUpdates(deviceEntity.getMaxBandwidthUpdate().intValue());
		}
		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getModel())) {
			deviceDto.setModel(deviceEntity.getModel().getModelName());
		}
		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getOverridingDefault())) {
			deviceDto.setOverridingDefaults(deviceEntity.getOverridingDefault().intValue());
		}

		deviceDto.setPlatform(deviceEntity.getPlatform());
		deviceDto.setSerialNumber(deviceEntity.getSerialNumber());
		deviceDto.setSoftwareVersion(deviceEntity.getSoftwareVersion());
		deviceDto.setTvQualityInterest(deviceEntity.getTvQualityInterest());
		deviceDto.setUiVersion(deviceEntity.getUiVersion());
		deviceDto.setVendor(deviceEntity.getVendor());

		deviceDto.setAssignedProfile(deviceEntity.getDeviceProfile());
		deviceDto.setAssignmentStatus(deviceEntity.getAssignmentStatus());
		deviceDto.setExtIPAddress(deviceEntity.getExternalIpAddress());
		deviceDto.setIpAddress(deviceEntity.getInternalIpAddress());
		deviceDto.setLastUpdateTime(deviceEntity.getLastUpdatedOn().toString());
		deviceDto.setLastUpdateUserName(deviceEntity.getLastUpdatedBy());

		DeviceDetailsResultObject deviceDetailsResultObject = new DeviceDetailsResultObject();
		deviceDetailsResultObject.setDevice(deviceDto);

		DeviceDetails deviceDetails = new DeviceDetails();
		deviceDetails.setResultCode(Constants.Status.SUCCESS_RESULT_CODE);
		deviceDetails.setResultDescription(Constants.Status.SUCCESS_RESULT_DESCRIPTION);
		deviceDetails.setExecutionTime(executionTime.intValue());
		deviceDetails.setResultObj(deviceDetailsResultObject);

		return deviceDetails;
	}

	/**
	 * This method returns DeviceDetailList Object
	 * 
	 * @param deviceEntity
	 * @param resourcesMap
	 * @param serviceMap
	 * 
	 * @return STBDetailList
	 */
	public static STBDetailList getDeviceDetailsList(Device deviceEntity, Map<Long, String> resourcesMap,
			Map<Long, String> serviceMap) {

		STBDetailList deviceDetailList = new STBDetailList();

		deviceDetailList.setMACAddress(deviceEntity.getDeviceId());
		deviceDetailList.setSerialNumber(deviceEntity.getSerialNumber());
		deviceDetailList.setIPAddress(deviceEntity.getInternalIpAddress());
		deviceDetailList.setExtIPAddress(deviceEntity.getExternalIpAddress());
		deviceDetailList.setSoftwareVersion(deviceEntity.getSoftwareVersion());
		deviceDetailList.setUIVersion(deviceEntity.getUiVersion());
		deviceDetailList.setSTBName(deviceEntity.getDeviceName());
		deviceDetailList.setTVQualityInterest(deviceEntity.getTvQualityInterest());
		deviceDetailList.setAssignmentStatus(deviceEntity.getAssignmentStatus());
		deviceDetailList.setLastUpdateTime(deviceEntity.getLastUpdatedOn().toString());
		deviceDetailList.setLastUpdateUserName(deviceEntity.getLastUpdatedBy());

		deviceDetailList.setAssignedResources(getDeviceAssignedResourceList(deviceEntity, resourcesMap));
		deviceDetailList.setPortMappings(getPortMappingsList(deviceEntity, serviceMap));
		//stbDetailList.setSetTopBoxUDFs(getStbUdfList(setTopBoxEntity));

		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getId())) {
			deviceDetailList.setEquipmentId(deviceEntity.getId().toString());
		}

		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getModel())) {
			deviceDetailList.setHardwareVersion(deviceEntity.getModel().getModelName());
		}

		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getMaxBandwidthUpdate())) {
			deviceDetailList.setMaxBandwidthUpdates(deviceEntity.getMaxBandwidthUpdate().toString());
		}

		if (!DeviceManagerUtil.checkNullObject(deviceEntity.getOverridingDefault())) {
			deviceDetailList.setOverridingDefaults(deviceEntity.getOverridingDefault().toString());
		}
		return deviceDetailList;
	}

	/**
	 * This method returns a list of Device Port Mappings
	 * 
	 * @param deviceEntity
	 * @param serviceMap
	 * @return
	 */
	private static List<PortMapping> getPortMappingsList(Device deviceEntity, Map<Long, String> serviceMap) {

		List<PortMapping> portMappingsList = new ArrayList<>();
/*		for (DeviceServicePortMapping stbServicePortMapping : deviceEntity.getDeviceServicePortMappings()) {
			PortMapping portMapping = new PortMapping();
			portMapping.setServiceName(serviceMap.get(stbServicePortMapping.getId().getServiceId()));
			portMapping.setInternalPort(stbServicePortMapping.getInternalPort().intValue());
			portMapping.setExternalPort(stbServicePortMapping.getExternalPort().intValue());
			portMappingsList.add(portMapping);
		}*/
		return portMappingsList;

	}

	/**
	 * This method returns a list of Device Assigned Resources
	 * 
	 * @param deviceEntity
	 * @param resourcesMap
	 * @return
	 */
	private static List<AssignedResources> getDeviceAssignedResourceList(Device deviceEntity,
			Map<Long, String> resourcesMap) {

		List<AssignedResources> assignedResourceList = new ArrayList<>();
/*		for (DeviceAssignedResource stbAssignedResource : deviceEntity.getDeviceAssignedResources()) {
			AssignedResources assignedResources = new AssignedResources();
			assignedResources.setName(resourcesMap.get(stbAssignedResource.getId().getResourceId()));
			assignedResources.setAllocation(stbAssignedResource.getAmount());
			assignedResourceList.add(assignedResources);
		}*/
		return assignedResourceList;
	}

	/**
	 * This method returns an Error Object.
	 * 
	 * @param errorList
	 * @param macAddress
	 * @param resultCode
	 * @param resultDescription
	 * 
	 */
	public static void getErrorObject(List<Error> errorList, String macAddress, String resultCode,
			String resultDescription) {
		Error error = new Error();
		error.setMacAddress(macAddress);
		error.setResultCode(resultCode);
		error.setResultDescription(resultDescription);
		errorList.add(error);
	}

	/**
	 * This method creates a Generic Result Object for Response and adds it
	 * to the provided List
	 * 
	 * @param resultObjectList
	 * @param id
	 * @param resultCode
	 * @param description
	 */
	public static void getGenericResultObject(List<ResultObject> resultObjectList, String id, String resultCode,
			String description) {
		ResultObject resultObject = new ResultObject();
		resultObject.setId(id);
		resultObject.setResultCode(resultCode);
		resultObject.setResultDescription(description);
		resultObjectList.add(resultObject);
	}

	/**
	 * This method generates a Generic Response for B2B
	 * 
	 * @param resultObjectList
	 * @param successfulRequests
	 * @param failedRequests
	 * @param executionTime
	 * 
	 * @return GenericResponseForB2B
	 */
	public static GenericResponse getGenericResponse(List<ResultObject> resultObjectList,
			int successfulRequests, int failedRequests, Long executionTime) {

		GenericResponse genericResponse = new GenericResponse();
		if (failedRequests == 0) {
			genericResponse.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
			genericResponse.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
			genericResponse.setResultObj(null);			
		} else{
			genericResponse.setResultObj(resultObjectList);
		}
		genericResponse.setExecutionTime(executionTime.intValue());	
		return genericResponse;
	}
	
	/**
	 * This method generates Response for Auto-Config
	 * 
	 * @param accountNumber
	 * @param equipmentId
	 * @param macAddress
	 * @param executionTime
	 * 
	 * @return
	 */
	public static AutoConfigResponse getAutoConfigResponse(String accountNumber, Integer equipmentId, String macAddress,
			Long executionTime) {
		STBAssigned deviceAssigned = new STBAssigned();
		deviceAssigned.setAccountNumber(accountNumber);
		deviceAssigned.setEquipmentId(equipmentId);
		deviceAssigned.setMACAddress(macAddress);

		StbAssignedResultObj deviceAssignedResultObj = new StbAssignedResultObj();
		deviceAssignedResultObj.setSTBAssigned(deviceAssigned);

		AutoConfigResponse autoConfigResponse = new AutoConfigResponse();
		autoConfigResponse.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		autoConfigResponse.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
		autoConfigResponse.setExecutionTime(executionTime.intValue());
		autoConfigResponse.setResultObj(deviceAssignedResultObj);
		return autoConfigResponse;
	}

	/**
	 * This method generates a DeviceProperties Response
	 * 
	 * @param devicePropertyList
	 * @param executionTime
	 * 
	 * @return
	 */
	public static STBPropertiesResponse getSTBPropertiesResponse(List<DeviceProperty> devicePropertyList, Long executionTime) {

		List<Property> propertyList = new ArrayList<>();
		for (DeviceProperty deviceProperty : devicePropertyList) {
			Property property = new Property();
			property.setName(deviceProperty.getId().getPropertyName());
			property.setValue(deviceProperty.getPropertyValue());
			propertyList.add(property);
		}

		StbPropertiesResultObj devicePropertiesResultObj = new StbPropertiesResultObj();
		devicePropertiesResultObj.setTotalResults(propertyList.size());
		devicePropertiesResultObj.setProperties(propertyList);

		STBPropertiesResponse devicePropertiesResponse = new STBPropertiesResponse();
		devicePropertiesResponse.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		devicePropertiesResponse.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
		devicePropertiesResponse.setExecutionTime(executionTime.intValue());
		devicePropertiesResponse.setResultObj(devicePropertiesResultObj);

		return devicePropertiesResponse;
	}
	
	/**
	 * This method generates a UpdatedDeviceListingResponse
	 * 
	 * @param updatedAccountsMap
	 * @param executionTime
	 * 
	 * @return
	 */
	public static UpdatedStbListingResponse getUpdatedDeviceListingResponse(Map<String, Long> updatedAccountsMap,
			Long executionTime) {

		List<UpdatedAccount> updatedAccounts = new ArrayList<>();
		for (Map.Entry<String, Long> updatedAccountsEntrySet : updatedAccountsMap.entrySet()) {
			UpdatedAccount updatedAccount = new UpdatedAccount();
			updatedAccount.setAccountNumber(updatedAccountsEntrySet.getKey());
			updatedAccount.setLastModified(updatedAccountsEntrySet.getValue().toString());
			updatedAccounts.add(updatedAccount);
		}
		UpdatedProfiles updatedProfiles = new UpdatedProfiles();
		updatedProfiles.setUpdatedAccounts(updatedAccounts);
		updatedProfiles.setTotalResults(updatedAccounts.size());

		UpdatedStbListingResponse updatedDeviceListingResponse = new UpdatedStbListingResponse();
		updatedDeviceListingResponse.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		updatedDeviceListingResponse
				.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
		updatedDeviceListingResponse.setExecutionTime(executionTime.intValue());
		updatedDeviceListingResponse.setResultObj(updatedProfiles);

		return updatedDeviceListingResponse;
	}

	/**
	 * This method generates a DeviceAuditDTO Response
	 * 
	 * @param GetDeviceAuditLogsResponse
	 * 
	 * @return 
	 */
	public static GetDeviceAuditLogsResponse getSetTopBoxAuditLogsResponse(List<DeviceAudit> deviceAuditList) {

		List<DeviceLogDTO> devicesLogList = new ArrayList<>();

		for (DeviceAudit deviceAudit : deviceAuditList) {
			DeviceLogDTO deviceLog = new DeviceLogDTO();			
			deviceLog.setDeviceId(deviceAudit.getDeviceId());
			deviceLog.setSerialNumber(deviceAudit.getSerialNumber());
			deviceLog.setIpAddress(deviceAudit.getInternalIpAddress());
			deviceLog.setExtIPAddress(deviceAudit.getExternalIpAddress());
			deviceLog.setDeviceName(deviceAudit.getDeviceName());
			deviceLog.setSoftwareVersion(deviceAudit.getSoftwareVersion());
			deviceLog.setModel(deviceAudit.getModel());
			deviceLog.setVendor(deviceAudit.getVendor());
			deviceLog.setDeviceType(deviceAudit.getDeviceType());
			deviceLog.setPlatform(deviceAudit.getPlatform());
			deviceLog.setUiVersion(deviceAudit.getUiVersion());
			deviceLog.setAssignmentStatus(deviceAudit.getAssignmentStatus());
			deviceLog.setUserName(deviceAudit.getAssignedToUsername());
			deviceLog.setLastUpdateTime(String.valueOf(deviceAudit.getLastUpdatedDatetime()));
			deviceLog.setLastUpdateUserName(deviceAudit.getLastUpdateUsername());
			deviceLog.setOverridingDefaults(String.valueOf(deviceAudit.getOverridingDefault()));
			deviceLog.setMaxBandwidthUpdates(String.valueOf(deviceAudit.getMaxBandwidthUpdate()));
			deviceLog.setTvQualityInterest(deviceAudit.getTvQualityInterest());
			deviceLog.setAssignedProfile(deviceAudit.getDeviceProfile());
			deviceLog.setDrmId(deviceAudit.getDrmId());
			deviceLog.setOperation(deviceAudit.getOperation());			
			devicesLogList.add(deviceLog);
		}
		DeviceLogs deviceLogs = new DeviceLogs();
		deviceLogs.setDeviceLogs(devicesLogList);
		deviceLogs.setTotalResults(devicesLogList.size());
		
		GetDeviceAuditLogsResponse response = new GetDeviceAuditLogsResponse();
		response.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		response.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());		
		response.setResultObj(deviceLogs);
		return response;
	}
	
}
