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
package com.accenture.avs.device.web.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.commons.lib.LoggerWrapper.BodyContentType;
import com.accenture.avs.commons.lib.support.JsonUtils;
import com.accenture.avs.device.json.object.devicemanager.AssignSetTopBox;
import com.accenture.avs.device.json.object.devicemanager.AutoConfig;
import com.accenture.avs.device.json.object.devicemanager.AutoConfigResponse;
import com.accenture.avs.device.json.object.devicemanager.CreateAndAssignSTB;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceModelRequest;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceRequest;
import com.accenture.avs.device.json.object.devicemanager.DeleteDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.DeviceDetails;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceAuditLogsResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceListResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceModelListResponse;
import com.accenture.avs.device.json.object.devicemanager.GetUserDevicesResponse;
import com.accenture.avs.device.json.object.devicemanager.STBPortMappings;
import com.accenture.avs.device.json.object.devicemanager.STBProperties;
import com.accenture.avs.device.json.object.devicemanager.STBPropertiesResponse;
import com.accenture.avs.device.json.object.devicemanager.SetTopBoxDelete;
import com.accenture.avs.device.json.object.devicemanager.SubscriberDelete;
import com.accenture.avs.device.json.object.devicemanager.Subscribers;
import com.accenture.avs.device.json.object.devicemanager.UnassignSetTopBox;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelRequest;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceRequest;
import com.accenture.avs.device.json.object.devicemanager.UpdateSubscriber;
import com.accenture.avs.device.json.object.devicemanager.UpdatedStbListingResponse;
import com.accenture.avs.device.json.object.swupgradecount.GetSwUpgradeCountDTO;
import com.accenture.avs.device.service.DeviceService;
import com.accenture.avs.device.service.DeviceServiceHelper;
import com.accenture.avs.device.service.ModelVersionService;
import com.accenture.avs.device.service.SoftwareUpgradeCountService;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;
import com.accenture.avs.device.util.Constants;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.validation.JsonSchema;

/**
 * The Class DeviceRestController.
 *
 * @author Sumit Kunmar Sahrma
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/b2b", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DeviceRestController {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper log = new LoggerWrapper(DeviceRestController.class);

	/** USER_OPERATION_CREATE_UPDATE_DEVICE_MAPPING */
	private static final String USER_OPERATION_CREATE_UPDATE_DEVICE_MAPPING = "/device";

	/** USER_OPERATION_ASSIGN_DEVICE_MAPPING */
	private static final String USER_OPERATION_ASSIGN_DEVICE_MAPPING = "/stb/operation/assignment";

	/** USER_OPERATION_CREATE_AND_ASSIGN_DEVICE_MAPPING */
	private static final String USER_OPERATION_CREATE_AND_ASSIGN_DEVICE_MAPPING = "/stb/operation/creationAndAssignment";

	/** USER_OPERATION_AUTO_CONFIG_MAPPING */
	private static final String USER_OPERATION_AUTO_CONFIG_MAPPING = "/stb/operation/autoConfiguration";

	/** USER_OPERATION_UNASSIGN_DEVICE_MAPPING */
	private static final String USER_OPERATION_UNASSIGN_DEVICE_MAPPING = "/stb/operation/unassignment";

	/** USER_OPERATION_SET_DEVICE_PROPERTIES_MAPPING */
	private static final String USER_OPERATION_SET_DEVICE_PROPERTIES_MAPPING = "/stb/properties";

	/** USER_OPERATION_GET_DEVICE_PROPERTIES_MAPPING */
	private static final String USER_OPERATION_GET_DEVICE_PROPERTIES_MAPPING = "/stb/properties/operation/listing";

	/** USER_OPERATION_SET_DEVICE_PORT_MAPPING */
	private static final String USER_OPERATION_SET_DEVICE_PORT_MAPPING = "/stb/portMappings";

	/** GET_UPDATED_DEVICE_PROFILES_MAPPING */
	private static final String GET_UPDATED_DEVICE_PROFILES_MAPPING = "/stb/operation/updatedSTBListing";

	/** GET_DEVICE_AUDIT_LOGS_MAPPING */
	private static final String GET_DEVICE_AUDIT_LOGS_MAPPING = "/device/{deviceId}/auditLogs";

	/** USER_OPERATION_CREATION_REQUEST_MAPPING */
	private static final String USER_OPERATION_CREATION_REQUEST_MAPPING = "/user/operation/creation";

	/** USER_OPERATION_UPDATE_REQUEST_MAPPING */
	private static final String USER_OPERATION_UPDATE_REQUEST_MAPPING = "/user/operation/update";

	/** USER_OPERATION_DELETE_REQUEST_MAPPING */
	private static final String USER_OPERATION_DELETE_REQUEST_MAPPING = "/user/operation/deletion";

	/** GET_USER_DEVICES_REQUEST_MAPPING */
	private static final String GET_USER_DEVICES_REQUEST_MAPPING = "/users/devices";

	/** REMOVE_DEVICE_REQUEST_MAPPING */
	private static final String REMOVE_DEVICE_REQUEST_MAPPING = "/stb/operation/deletion";

	/** DEFAULT_USER_ID */
	private static final String DEFAULT_LASTUPDATEDUSERNAME = "System";

	/** DEFAULT_LASTINTERFACE */
	private static final String DEFAULT_LASTINTERFACE = "";

	/** LASTUPDATEUSERNAME */
	private static final String LASTUPDATEUSERNAME = "X-avs-username";

	/** LAST_INTERFACE */
	private static final String LAST_INTERFACE = "lastUpdatedInterface";

	/** CLIENT_IP */
	private static final String CLIENT_IP = "ClientIP";

	/** AUTHENTICATION_COOKIE */
	private static final String AUTHENTICATION_COOKIE = "avs_cookie";

	/** GET_DEVICE_DETAILS_REQUEST_MAPPING */
	private static final String GET_DEVICE_DETAILS_REQUEST_MAPPING = "/device/{deviceId}";

	/** deviceId */
	private static final String DEVICEID = "deviceId";

	/** GET_DEVICE_LIST */
	private static final String GET_DEVICE_LIST = "/devices";

	/** SEARCHBYSTR */
	private static final String SEARCHBYSTR = "searchBy";

	/** SEARCHVALUESTR */
	private static final String SEARCHVALUESTR = "searchValue";

	/** SEARCHOPERATIONSTR */
	private static final String SEARCHOPERATIONSTR = "searchOperation";

	/** SORTBYSTR */
	private static final String SORTBYSTR = "sortBy";

	/** STARTINDEXSTR */
	private static final String STARTINDEXSTR = "startIndex";

	/** PAGESIZESTR */
	private static final String PAGESIZESTR = "pageSize";

	/** DEFAULTSTARTINDEX */
	private static final Integer DEFAULTSTARTINDEX = 0;

	/** DEFAULTPAGESIZE */
	private static final Integer DEFAULTPAGESIZE = 100;

	/** USER_NAME */
	private static final String USER_NAME = "userName";

	/** RET_ENABLE */
	private static final String RET_ENABLE = "retEnable";

	/** RCC_ENABLE */
	private static final String RCC_ENABLE = "rccEnable";

	/** NETWORK_BUFFER_SIZE */
	private static final String NETWORK_BUFFER_SIZE = "networkBufferSize";

	/** LIMIT_DEVICE_FIELDS */
	private static final String LIMIT_DEVICE_FIELDS = "limitDeviceFields";

	/** VALUE */
	private static final String VALUE = "value";

	/** USER_OPERATION_GET_SW_UPGRADE_COUNT */
	private static final String USER_OPERATION_GET_SW_UPGRADE_COUNT = "/swUpgradeCount";

	/** USER_OPERATION_GET_SW_UPGRADE_VERSIONS */
	private static final String USER_OPERATION_GET_SW_UPGRADE_VERSIONS = "swVersions";

	/** SoftwareUpgradeCountService */
	@Autowired
	private SoftwareUpgradeCountService softwareUpgradeCountService;

	/** The device service */
	@Autowired
	private DeviceService deviceService;

	/** The device model service */
	@Autowired
	private ModelVersionService deviceModelService;

	/** stbServiceHelper */
	@Autowired
	private DeviceServiceHelper deviceServiceHelper;

	/** USER_OPERATION_DEVICE_MODEL_MAPPING */
	private static final String USER_OPERATION_DEVICE_MODEL_MAPPING = "/devicemodel";

	/** USER_OPERATION_DEVICE_MODEL_MAPPING */
	private static final String USER_OPERATION_DEVICE_MODEL_DELETE_MAPPING = "/devicemodel/{deviceModel}";

	/** USER_OPERATION_LIST_MODEL_MAPPING */
	private static final String USER_OPERATION_LIST_MODEL_MAPPING = "/deviceModels";

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation and create a new Device.
	 *
	 * @param createDeviceRequest
	 * @param lastUpdateUserName
	 * @param httpRequest
	 * @return ResponseEntity<GenericResponse>
	 */
	@RequestMapping(value = USER_OPERATION_CREATE_UPDATE_DEVICE_MAPPING, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> createDevice(@RequestBody CreateDeviceRequest createDeviceRequest,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String lastUpdateUserName,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "createDevice");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(createDeviceRequest));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(createDeviceRequest, JsonSchema.CREATEDEVICE.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		GenericResponse response = deviceService.createDevice(createDeviceRequest, lastUpdateUserName);
		
		Long executionTime = System.currentTimeMillis() - startTime;

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation and assign Device to the Subscriber.
	 * 
	 * @param assignDevice
	 * @param userId
	 * 
	 * @return GenericResponse
	 */
	@RequestMapping(value = USER_OPERATION_ASSIGN_DEVICE_MAPPING, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> assignDevice(@RequestBody AssignSetTopBox assignDevice,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String userId,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "assignDevice");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(assignDevice));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(assignDevice, JsonSchema.ASSIGNSTB.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		GenericResponse response = deviceService.assignDevice(assignDevice, userId);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation and then creating and assigning new Device to the
	 * intended Subscriber.
	 * 
	 * @param createAndAssignDevice
	 * @param userId
	 * 
	 * @return GenericResponse
	 */
	@RequestMapping(value = USER_OPERATION_CREATE_AND_ASSIGN_DEVICE_MAPPING, method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> createAndAssignDevice(@RequestBody CreateAndAssignSTB createAndAssignDevice,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String userId,
			HttpServletRequest httpRequest) {
		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "createAndAssignDevice");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(createAndAssignDevice));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(createAndAssignDevice,
				JsonSchema.CREATEANDASSIGNSTB.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		GenericResponse response = deviceService.createAndAssignDevice(createAndAssignDevice, userId);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation for Auto-Config.
	 * 
	 * @param autoConfig
	 * @param userId
	 * @param extIdAddress
	 * 
	 * @return ResponseEntity<AutoConfigResponse>
	 */
	@RequestMapping(value = USER_OPERATION_AUTO_CONFIG_MAPPING, method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AutoConfigResponse> autoConfig(@RequestBody AutoConfig autoConfig,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String userId,
			@RequestHeader(value = CLIENT_IP, required = true) String extIdAddress, HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "autoConfig");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(autoConfig));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(autoConfig, JsonSchema.AUTOCONFIG.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		AutoConfigResponse response = deviceService.autoConfig(autoConfig, extIdAddress, userId);

		Long executionTime = System.currentTimeMillis() - startTime;

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation for Device Unassignment.
	 * 
	 * @param unassignDevice
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = USER_OPERATION_UNASSIGN_DEVICE_MAPPING, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> unassignDevice(@RequestBody UnassignSetTopBox unassignDevice,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String userId,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "unassignDevice");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(unassignDevice));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(unassignDevice, JsonSchema.UNASSIGNSTB.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		GenericResponse response = deviceService.unassignDevice(unassignDevice, userId);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation for creating/updating/deleting Device Properties.
	 * 
	 * @param deviceProperties
	 * @param extIdAddress
	 * @param authenticationCookie
	 * 
	 * @return ResponseEntity<STBPropertiesResponse>
	 */
	@RequestMapping(value = USER_OPERATION_SET_DEVICE_PROPERTIES_MAPPING, method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<STBPropertiesResponse> setDeviceProperties(@RequestBody STBProperties deviceProperties,
			@RequestHeader(value = CLIENT_IP, required = true) String extIdAddress,
			@CookieValue(value = AUTHENTICATION_COOKIE, required = true) String authenticationCookie,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "setDeviceProperties");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(deviceProperties));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(deviceProperties, JsonSchema.STBPROPERTIES.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		STBPropertiesResponse response = deviceService.setDeviceProperties(deviceProperties, extIdAddress,
				authenticationCookie);

		Long executionTime = System.currentTimeMillis() - startTime;

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation for getting Device Properties.
	 * 
	 * @param userId
	 * @param extIdAddress
	 * @param authenticationCookie
	 * 
	 * @return ResponseEntity<STBPropertiesResponse>
	 */
	@RequestMapping(value = USER_OPERATION_GET_DEVICE_PROPERTIES_MAPPING, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<STBPropertiesResponse> getDeviceProperties(
			@RequestHeader(value = CLIENT_IP, required = true) String extIdAddress,
			@CookieValue(value = AUTHENTICATION_COOKIE, required = true) String authenticationCookie,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getDeviceProperties");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));

		TenantContext.setCurrentTenant(Tenants.READ);
		STBPropertiesResponse response = deviceService.getDeviceProperties(extIdAddress, authenticationCookie);

		Long executionTime = System.currentTimeMillis() - startTime;

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation for creating/updating Device Port Mappings.
	 * 
	 * @param stbPortMappings
	 * @param extIdAddress
	 * @param authenticationCookie
	 * 
	 * @return ResponseEntity<GenericResponse>
	 */
	@RequestMapping(value = USER_OPERATION_SET_DEVICE_PORT_MAPPING, method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponse> setDevicePortMappings(@RequestBody STBPortMappings stbPortMappings,
			@RequestHeader(value = CLIENT_IP, required = true) String extIdAddress,
			@CookieValue(value = AUTHENTICATION_COOKIE, required = true) String authenticationCookie,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "setDevicePortMappings");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(stbPortMappings));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(stbPortMappings, JsonSchema.STBPORTMAPPINGS.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		GenericResponse response = deviceService.setDevicePortMappings(stbPortMappings, extIdAddress,
				authenticationCookie);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method sends the request to service bean to get the list of subscribers
	 * who’s devices have been updated within the given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return ResponseEntity<UpdatedStbListingResponse>
	 */
	@RequestMapping(value = GET_UPDATED_DEVICE_PROFILES_MAPPING, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UpdatedStbListingResponse> getUpdatedDeviceListing(
			@RequestParam(value = "startDate", required = true) Long startDate,
			@RequestParam(value = "endDate", required = true) Long endDate, HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getUpdatedDeviceListing");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		log.logMessage("startDate:{}, endDate:{}", startDate, endDate);

		TenantContext.setCurrentTenant(Tenants.READ);
		UpdatedStbListingResponse response = deviceService.getUpdatedDeviceListing(startDate, endDate);

		Long executionTime = System.currentTimeMillis() - startTime;

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method sends the request to service bean to get the audit logs of all
	 * the updates done on the requested set top boxes using deviceId, offset and
	 * max result size
	 * 
	 * @param deviceId
	 * @param startIndex
	 * @param maxResults
	 * 
	 * @return ResponseEntity<SetTopBoxAuditLogs>
	 */
	@RequestMapping(value = GET_DEVICE_AUDIT_LOGS_MAPPING, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GetDeviceAuditLogsResponse> getDeviceAuditLogs(@PathVariable("deviceId") String deviceId,
			@RequestParam(value = "startIndex", defaultValue = Constants.START_INDEX_DEFAULT, required = false) Integer startIndex,
			@RequestParam(value = "maxResults", defaultValue = Constants.MAX_RESULTS_DEFAULT, required = false) Integer maxResults,
			HttpServletRequest httpRequest) {

		long sTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getDeviceAuditLogs");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		log.logMessage("deviceId:{}, startIndex:{}, maxResults:{}", deviceId, startIndex, maxResults);
		TenantContext.setCurrentTenant(Tenants.READ);
		GetDeviceAuditLogsResponse response = deviceService.getDeviceAuditLogs(deviceId,
				startIndex < 0 ? Integer.valueOf(Constants.START_INDEX_DEFAULT) : startIndex,
				maxResults < 0 ? Integer.valueOf(Constants.MAX_RESULTS_DEFAULT) : maxResults);
		Long executionTime = System.currentTimeMillis() - sTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation and updates the Device.
	 * 
	 * @param updateDeviceRequest
	 * @param lastUpdateUserName
	 * @param httpRequest
	 * @return ResponseEntity<GenericResponse>
	 */
	@RequestMapping(method = RequestMethod.PUT, value = USER_OPERATION_CREATE_UPDATE_DEVICE_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse> updateDevice(@RequestBody UpdateDeviceRequest updateDeviceRequest,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String lastUpdateUserName,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "updateDevice");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(updateDeviceRequest));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(updateDeviceRequest, JsonSchema.UPDATEDEVICE.getFileName());
		GenericResponse response = deviceService.updateDevice(updateDeviceRequest, lastUpdateUserName);

		Long executionTime = System.currentTimeMillis() - startTime;

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * Removes devices.
	 * 
	 * @param deviceDelete
	 * @return ResponseEntity<GenericResponse>
	 */
	@RequestMapping(value = REMOVE_DEVICE_REQUEST_MAPPING, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse> removeDevices(@RequestBody SetTopBoxDelete deviceDelete,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "updateDevices");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(deviceDelete));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(deviceDelete, JsonSchema.SETTOPBOXDELETE.getFileName());
		GenericResponse response = deviceService.removeDevices(deviceDelete);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());
		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * Creates subscribers.
	 * 
	 * @param subscribers
	 * @return ResponseEntity<GenericResponse>
	 */
	@RequestMapping(method = RequestMethod.POST, value = USER_OPERATION_CREATION_REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse> createSubscriber(@RequestBody Subscribers subscribers,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "createSubscriber");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(subscribers));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(subscribers, JsonSchema.SUBSCRIBERS.getFileName());
		GenericResponse response = deviceService.createSubscribers(subscribers);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());
		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * Updates subscribers.
	 * 
	 * @param updateSubscriber
	 * @return ResponseEntity<GenericResponse>
	 */
	@RequestMapping(method = RequestMethod.POST, value = USER_OPERATION_UPDATE_REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse> updateSubscribers(@RequestBody UpdateSubscriber updateSubscriber,
			HttpServletRequest httpRequest) {
		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "updateSubscribers");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(updateSubscriber));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(updateSubscriber, JsonSchema.UPDATESUBSCRIBER.getFileName());
		GenericResponse response = deviceService.updateSubscribers(updateSubscriber);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());
		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * Deletes subscribers.
	 * 
	 * @param subscriberDelete
	 * @return ResponseEntity<GenericResponse>
	 */
	@RequestMapping(method = RequestMethod.POST, value = USER_OPERATION_DELETE_REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse> deleteSubscribers(@RequestBody SubscriberDelete subscriberDelete,
			HttpServletRequest httpRequest) {
		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "deleteSubscribers");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(subscriberDelete));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(subscriberDelete, JsonSchema.DELETESUBSCRIBER.getFileName());
		GenericResponse response = deviceService.deleteSubscribers(subscriberDelete);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());
		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);
		return ResponseEntity.ok(response);
	}

	/**
	 * Gets user devices. 
	 * @param userName
	 * @param limitDeviceFields
	 * @param httpRequest
	 * @return ResponseEntity<GetUserDevicesResponse>
	 */
	@RequestMapping(method = RequestMethod.GET, value = GET_USER_DEVICES_REQUEST_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUserDevicesResponse> getUserDevices(
			@RequestParam(value = USER_NAME, required = true) List<String> userName,		
			@RequestParam(value = LIMIT_DEVICE_FIELDS, required = false, defaultValue = "true") Boolean limitDeviceFields,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getUserDevices");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		log.logMessage("userName:{}, limitDeviceFields:{} ", userName, limitDeviceFields);
		
		TenantContext.setCurrentTenant(Tenants.READ);
		GetUserDevicesResponse response = deviceService.getUserDevices(userName, limitDeviceFields);
		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());
		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = GET_DEVICE_DETAILS_REQUEST_MAPPING, method = RequestMethod.GET)
	public ResponseEntity<DeviceDetails> getDeviceDetails(@PathVariable(DEVICEID) String deviceId,
			HttpServletRequest httpRequest) {
		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getDeviceDetails");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));

		TenantContext.setCurrentTenant(Tenants.READ);
		DeviceDetails response = deviceService.getDeviceDetails(deviceId);

		Long executionTime = System.currentTimeMillis() - startTime;
		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);
		return ResponseEntity.ok(response);
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
	@RequestMapping(value = GET_DEVICE_LIST, method = RequestMethod.GET)
	public ResponseEntity<GetDeviceListResponse> getDeviceList(
			@RequestParam(value = SEARCHBYSTR, required = false) String searchBy,
			@RequestParam(value = SEARCHVALUESTR, required = false) String searchValue,
			@RequestParam(value = SEARCHOPERATIONSTR, required = false) String searchOperation,
			@RequestParam(value = SORTBYSTR, required = false) String sortBy,
			@RequestParam(value = STARTINDEXSTR, defaultValue = "0") Integer startIndex,
			@RequestParam(value = PAGESIZESTR, defaultValue = "100") Integer pageSize, HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getDeviceList");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		log.logMessage("searchBy:{}, searchValue:{}, searchOperation:{} ", searchBy, searchValue, searchOperation);
		log.logMessage("sortBy:{}, startIndex:{}, pageSize:{} ", sortBy, startIndex, pageSize);

		GetDeviceListResponse response = deviceService.getDeviceList(searchBy, searchValue, searchOperation, sortBy,
				startIndex < 0 ? DEFAULTSTARTINDEX : startIndex, pageSize < 0 ? DEFAULTPAGESIZE : pageSize);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());
		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);
		return ResponseEntity.ok(response);

	}

	/**
	 * This interface supposed to get count of software versions.
	 * 
	 * @param swVersions
	 * @param httpRequest
	 * @return ResponseEntity<GenericResponse>
	 */
	@GetMapping(value = USER_OPERATION_GET_SW_UPGRADE_COUNT)
	public ResponseEntity<GetSwUpgradeCountDTO> getSoftwareUpgradeCount(
			@RequestParam(value = USER_OPERATION_GET_SW_UPGRADE_VERSIONS, required = true) String swVersions,
			HttpServletRequest httpRequest) {
		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getSoftwareUpgradeCount");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		log.logMessage("swVersions:{}", swVersions);

		GetSwUpgradeCountDTO response = softwareUpgradeCountService.getSoftwareUpgradeCount(swVersions);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);

	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation and create a new Device Model.
	 *
	 * @param deviceModel
	 * @param lastUpdatedUserName
	 * @param lastUpdatedInterface
	 * @param httpRequest
	 * @return ResponseEntity<CreateDeviceModelResponse>
	 */
	@RequestMapping(value = USER_OPERATION_DEVICE_MODEL_MAPPING, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateDeviceModelResponse> createDeviceModel(
			@RequestBody CreateDeviceModelRequest deviceModel,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String lastUpdatedUserName,
			@RequestHeader(value = LAST_INTERFACE, defaultValue = DEFAULT_LASTINTERFACE) String lastUpdatedInterface,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "createDeviceModel");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(deviceModel));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(deviceModel, JsonSchema.CREATEDEVICEMODEL.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		CreateDeviceModelResponse response = deviceModelService.createDeviceModel(deviceModel, lastUpdatedUserName,
				lastUpdatedInterface);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation and update a Device Model.
	 *
	 * @param deviceModel
	 * @param lastUpdatedUserName
	 * @param lastUpdatedInterface
	 * @param httpRequest
	 * @return ResponseEntity<UpdateDeviceModelResponse>
	 */
	@RequestMapping(value = USER_OPERATION_DEVICE_MODEL_MAPPING, method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UpdateDeviceModelResponse> updateDeviceModel(
			@RequestBody UpdateDeviceModelRequest deviceModel,
			@RequestHeader(value = LASTUPDATEUSERNAME, defaultValue = DEFAULT_LASTUPDATEDUSERNAME) String lastUpdatedUserName,
			@RequestHeader(value = LAST_INTERFACE, defaultValue = DEFAULT_LASTINTERFACE) String lastUpdatedInterface,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "updateDeviceModel");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(deviceModel));
		} catch (IOException e) {
			log.logError(e);
		}

		deviceServiceHelper.validateRequestParameters(deviceModel, JsonSchema.UPDATEDEVICEMODEL.getFileName());

		TenantContext.setCurrentTenant(Tenants.WRITE);
		UpdateDeviceModelResponse response = deviceModelService.updateDeviceModel(deviceModel, lastUpdatedUserName,
				lastUpdatedInterface);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method validate request parameters and sends the request to service bean
	 * for further validation and delete model.
	 *
	 * @param deviceModel
	 * @param httpRequest
	 * @return ResponseEntity<DeleteDeviceModelResponse>
	 */
	@RequestMapping(value = USER_OPERATION_DEVICE_MODEL_DELETE_MAPPING, method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DeleteDeviceModelResponse> deleteDeviceModel(@PathVariable("deviceModel") String deviceModel,
			HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "deleteDeviceModel");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(deviceModel));
		} catch (IOException e) {
			log.logError(e);
		}

		TenantContext.setCurrentTenant(Tenants.WRITE);
		DeleteDeviceModelResponse response = deviceModelService.deleteDeviceModel(deviceModel);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method get device model list and specific model details.
	 * 
	 * @param status
	 * @param deviceModel
	 * @param httpRequest
	 * @return ResponseEntity<GetDeviceModelListResponse>
	 */
	@RequestMapping(value = USER_OPERATION_LIST_MODEL_MAPPING, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GetDeviceModelListResponse> getDeviceModelList(
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "deviceModel", required = false) String deviceModel, HttpServletRequest httpRequest) {

		long startTime = System.currentTimeMillis();
		ThreadContext.put(Constants.LoggingParams.API, "getDeviceModelList");
		log.logStartApi();
		log.logRequestHeader(DeviceManagerUtil.getHeaderMapFormat(httpRequest));
		try {
			log.logRequestBody(JsonUtils.writeAsJsonString(deviceModel));
		} catch (IOException e) {
			log.logError(e);
		}

		// TenantContext.setCurrentTenant(Tenants.WRITE);
		GetDeviceModelListResponse response = deviceModelService.getDeviceModelList(status, deviceModel);

		Long executionTime = System.currentTimeMillis() - startTime;
		response.setExecutionTime(executionTime.intValue());

		log.logResponseBody(response, BodyContentType.JSON);
		log.logEndApi(httpRequest.getHeader(Constants.LoggingParams.USER_AGENT_HEADER_NAME),
				httpRequest.getParameterMap(), Integer.toString(HttpStatus.OK.value()),
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);

		return ResponseEntity.ok(response);
	}
}
