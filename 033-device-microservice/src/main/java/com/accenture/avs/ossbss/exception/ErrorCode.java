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
package com.accenture.avs.ossbss.exception;

/**
 * The ErrorCodes Intended for use with the {@link OSSBSSClientException}.
 */
public enum ErrorCode {

	/** The request name null. */
	CONFIGURATION_PROVIDER_NULL("OBC-1002", "Configuration Provider can not be null. "),

	/** The resource file read failed. */
	RESOURCE_FILE_READ_FAILED("OBC-1001", "Error occured while reading file [%s]."),

	/** The error occurred making http call. */
	ERROR_OCCURRED_MAKING_HTTP_CALL("OBC-1002", "Error occured while making http call."),

	/** The file not found. */
	FILE_NOT_FOUND("OBC-1003", "Configuration file [%s] not found at class path."),

	/** The unable to read file. */
	UNABLE_TO_READ_FILE("OBC-1003", "Unable to reade file [%s]"),

	/** The configuration property missing. */
	CONFIGURATION_PROPERTY_MISSING("OBC-1002", "Configuration Properties missing [%s] "),

	/** The json processing exception. */
	JSON_PROCESSING_EXCEPTION("OBC-1002", "Error occurred while processing josn."),

	/** The no such application found. */
	NO_SUCH_APPLICATION_FOUND("OBC-1002", "No such application [%s] found in configuration file [%s]"),

	/** The no such request found. */
	NO_SUCH_REQUEST_FOUND("OBC-1002", "[%s] No such request mapping found."),

	/** The application name null. */
	APPLICATION_NAME_NULL("OBC-1002", "Application name can not be null, Either set the application name or call defaultApplication() method."),

	/** The configuration file path null. */
	CONFIGURATION_FILE_PATH_NULL("OBC-1002", "Configuration file path can not be null, Either set the Configuration file path or call defaultConfiguration() method."),

	/** The request name null. */
	REQUEST_NAME_NULL("OBC-1002", "Request name can not be null"),

	/** The schema valdiation failed. */
	SCHEMA_VALDIATION_FAILED("OBC-1002", "Validation Failed \n Message [%s]"),

	/** The transformation error. */
	TRANSFORMATION_ERROR("OBC-1002", "Error occurred while tranforming request obejct."),;

	/** The error code. */
	private String errorCode;

	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new error code.
	 *
	 * @param errorCode
	 *            the error code
	 * @param errorMessage
	 *            the error message
	 */
	private ErrorCode(final String errorCode, final String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
