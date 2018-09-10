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
package com.accenture.avs.device.exception;

/**
 * The Enum ErrorCode
 * 
 * @author Singh.Saurabh
 */
public enum ErrorCode implements IErrorCode {

	/** GENERIC_ERROR. */
	GENERIC_ERROR("ERROR_BE_ACTION_300_GENERIC_ERROR"),

	/** MISSING_PARAM */
	MISSING_PARAM("ERROR_BE_ACTION_3000_MISSING_PARAMETER"),

	/** INVALID_PARAM */
	INVALID_PARAM("ERROR_BE_ACTION_3019_INVALID_PARAMETER"),

	/** REQUEST_VALIDATION_FAILED */
	REQUEST_VALIDATION_FAILED("ERROR_BE_ACTION_3258_VALIDATE_REQUEST_ERROR"),
	
	/** JSON_PARSING_FAILED */
	JSON_PARSING_FAILED("ERROR_BE_ACTION_3258_JSON_PARSING_FAILED"),
	
	/** USER_NOT_FOUND */
	USER_NOT_FOUND("ERROR_BE_ACTION_3055_USER_NOT_FOUND"),

	/** USER_NOT_LOGGED */
	USER_NOT_LOGGED("ERROR_3147_USER_NOT_LOGGED"),

	/** RESOURCE_NOT_FOUND */
	RESOURCE_NOT_FOUND("ERROR_BE_ACTION_3304_RESOURCE_NOT_FOUND"),

	/** BAD_REQUEST */
	BAD_REQUEST("ERROR_BE_ACTION_3305_BAD_REQUEST"),

	/** DEVICE_ALREADY_ASSIGNED */
	DEVICE_ALREADY_ASSIGNED("ERROR_BE_ACTION_3217_DEVICE_ALREADY_ASSOCIATED"),

	/** DEVICE_ALREADY_EXISTS */
	DEVICE_ALREADY_EXISTS("ERROR_BE_ACTION_9000_DEVICE_ALREADY_EXISTS"),
	
	/** INVALID_MODEL */
	INVALID_MODEL("ERROR_BE_ACTION_9001_INVALID_MODEL"),

	/** DEVICE_MODEL_NOT_UPDATE_ALLOWED */
	DEVICE_MODEL_NOT_UPDATE_ALLOWED("ERROR_BE_ACTION_9014_DEVICE_MODEL_NOT_UPDATE_ALLOWED"),
	
	/** INVALID_DEVICE */
	INVALID_DEVICE("ERROR_BE_ACTION_9002_INVALID_DEVICE"),

	/** DEVICE_NOT_FOUND */
	DEVICE_NOT_FOUND("ERROR_BE_ACTION_9002_DEVICE_NOT_FOUND"),

	/** RESOURCE_DISTRIBUTION_FAILED */
	RESOURCE_DISTRIBUTION_FAILED("ERROR_BE_ACTION_9003_RESOURCE_DISTRIBUTION_FAILED"),
	
	/** INVALID_HARDWARE_VERSION */
	INVALID_HARDWARE_VERSION("ERROR_BE_ACTION_9004_INVALID_HARDWARE_VERSION"),

	/** NO_DEVICE_CONNECTION_MODE */
	NO_DEVICE_CONNECTION_MODE("ERROR_BE_ACTION_9005_NO_DEVICE_CONNECTION_MODE"),

	/** DUPLICATE_DEVICE_NAME */
	DUPLICATE_DEVICE_NAME("ERROR_BE_ACTION_9016_DUPLICATE_DEVICE_NAME"),

	/** INVALID_SUBSCRIBER_ID_OR_ACCOUNT_NUMBER */
	INVALID_SUBSCRIBER_ID_OR_ACCOUNT_NUMBER("ERROR_BE_ACTION_9007_INVALID_SUBSCRIBER_ID_OR_ACCOUNT_NUMBER"),

	/** NO_DEVICE_FOUND */
	NO_DEVICE_FOUND("ERROR_BE_ACTION_9008_NO_DEVICE_FOUND"),
	
	/** DRM_ID_MUST_BE_UNIQUE */
	DRM_ID_MUST_BE_UNIQUE("ERROR_BE_ACTION_9007_DRM_ID_MUST_BE_UNIQUE"),
	
	/** TRIPLET_MUST_BE_UNIQUE */
	TRIPLET_MUST_BE_UNIQUE("ERROR_BE_ACTION_9008_TRIPLET_MUST_BE_UNIQUE"),

	/** COUPLE_MUST_BE_UNIQUE_FOR_MODEL */
	COUPLE_MUST_BE_UNIQUE_FOR_MODEL("ERROR_BE_ACTION_9010_COUPLE_MUST_BE_UNIQUE_FOR_MODEL"),

	/** TIME_DIFFERENCE_GREATER_THAN_3O_DAYS */
	TIME_DIFFERENCE_GREATER_THAN_3O_DAYS("ERROR_BE_ACTION_9011_TIME_DIFFERENCE_GREATER_THAN_3O_DAYS"),

	/** STARTDATE_GREATER_THAN_ENDDATE */
	STARTDATE_GREATER_THAN_ENDDATE("ERROR_BE_ACTION_9012_STARTDATE_GREATER_THAN_ENDDATE"),
	
	/** SERIAL_NUMBER_MUST_BE_UNIQUE */
	SERIAL_NUMBER_MUST_BE_UNIQUE("ERROR_BE_ACTION_9012_SERIAL_NUMBER_MUST_BE_UNIQUE"),

	/** ENDDATE_GREATER_THAN_CURRENTDATE */
	ENDDATE_GREATER_THAN_CURRENTDATE("ERROR_BE_ACTION_9013_ENDDATE_GREATER_THAN_CURRENTDATE"),
	
	/** DEVICE_ASSIGNED_CANNOT_UPDATE_MODEL */
	DEVICE_ASSIGNED_CANNOT_UPDATE_MODEL("ERROR_BE_ACTION_9013_DEVICE_ASSIGNED_CANNOT_UPDATE_MODEL"),

	/** AUTO_REGISTRATION_NOT_ALLOWED */
	AUTO_REGISTRATION_NOT_ALLOWED("ERROR_BE_ACTION_9014_AUTO_REGISTRATION_NOT_ALLOWED"),

	/** HW_OF_ASSIGNED_DEVICE_CANNOT_BE_UPDATED */
	HW_OF_ASSIGNED_DEVICE_CANNOT_BE_UPDATED("ERROR_BE_ACTION_9021_HW_OF_ASSIGNED_DEVICE_CANNOT_BE_UPDATED"),

	/** INTERNAL_COMMUNICATION_FAILED */
	INTERNAL_COMMUNICATION_FAILED("ERROR_BE_ACTION_9023_INTERNAL_COMMUNICATION_FAILED"),

	/** FAILED_TO_UPDATE_GLOBAL_SETTING */
	FAILED_TO_UPDATE_GLOBAL_SETTING("ERROR_BE_ACTION_9027_FAILED_TO_UPDATE_GLOBAL_SETTING"),

	/** CRM_COMMUNICATION_FAILED */
	CRM_COMMUNICATION_FAILED("ERROR_BE_ACTION_9028_CRM_COMMUNICATION_FAILED"),

	/** CONNECTION_MODES_CAN_NOT_BE_UPDATED */
	CONNECTION_MODES_CAN_NOT_BE_UPDATED("ERROR_BE_ACTION_9029_CONNECTION_MODES_CAN_NOT_BE_UPDATED"),

	/** STARTTIME_GREATER_THAN_ENDTIME */
	STARTTIME_GREATER_THAN_ENDTIME("ERROR_BE_ACTION_9030_STARTTIME_GREATER_THAN_ENDTIME"),

	/** ENDDATE_GREATER_THAN_CURRENTTIME */
	ENDDATE_GREATER_THAN_CURRENTTIME("ERROR_BE_ACTION_9031_ENDDATE_GREATER_THAN_CURRENTTIME"),

	/** CANNOT_REMOVE_SUBSCRIBER */
	CANNOT_REMOVE_SUBSCRIBER("ERROR_BE_ACTION_9032_CANNOT_REMOVE_SUBSCRIBER"),

	/** SUBSCRIBER_ALREADY_EXISTS */
	SUBSCRIBER_ALREADY_EXISTS("ERROR_BE_ACTION_9034_SUBSCRIBER_ALREADY_EXISTS"),

	/** HARDWARE_VERSION_UPDATE_FAILED( */
	HARDWARE_VERSION_UPDATE_FAILED("ERROR_BE_ACTION_9035_HARDWARE_VERSION_UPDATE_FAILED"),

	/** INVALID_DATA */
	INVALID_DATA("ERROR_BE_ACTION_9036_INVALID_DATA"),

	/** ATLEAST_ONE_CONN_MODE_SHOULD_ACTIVE */
	ATLEAST_ONE_CONN_MODE_SHOULD_ACTIVE("ERROR_BE_ACTION_9037_ATLEAST_ONE_CONN_MODE_SHOULD_ACTIVE"),

	/** DEVICE_SHOULD_BE_UNASSIGNED */
	DEVICE_SHOULD_BE_UNASSIGNED("ERROR_BE_ACTION_9038_DEVICE_SHOULD_BE_UNASSIGNED"),

	/** INVALID_SERVICE_TYPE */
	INVALID_SERVICE_TYPE("ERROR_BE_ACTION_9039_INVALID_SERVICE_TYPE"),

	/** STARTDATE_GREATER_THAN_CURRENTTIME */
	STARTDATE_GREATER_THAN_CURRENTTIME("ERROR_BE_ACTION_9040_STARTDATE_GREATER_THAN_CURRENTTIME"),
	
	/** DEVICE_MODEL_ACTIVE */
	DEVICE_MODEL_ACTIVE("ERROR_BE_ACTION_9009_DEVICE_MODEL_ACTIVE"),
	
	/** DEVICE_MODEL_ASSOCIATED_TO_DEVICE */
	DEVICE_MODEL_ASSOCIATED_TO_DEVICE("ERROR_BE_ACTION_9011_DEVICE_MODEL_ASSOCIATED_TO_DEVICE");
	
	/** The error code. */
	private String errorCode;

	/**
	 * Instantiates a new error code.
	 *
	 * @param errorCode
	 *            the error code
	 */
	private ErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.accenture.avs.common.exception.IErrorCode#getCode()
	 */
	@Override
	public String getCode() {
		return this.errorCode;
	}

}