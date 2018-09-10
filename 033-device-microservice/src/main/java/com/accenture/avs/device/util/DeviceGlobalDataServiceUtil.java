/**************************************************************************
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.GlobalQoESettings;
import com.accenture.avs.device.json.object.devicemanager.Language;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;

/**
 * Device Global Data Service Util class.
 * 
 * @author rajesh.karna
 *
 */
public class DeviceGlobalDataServiceUtil {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceGlobalDataServiceUtil.class);

	/** IMPLICIT_NAT */
	private static final String IMPLICIT_NAT = "Implicit NAT";

	/** UPNP */
	private static final String UPNP = "UPnP NAPT";

	/** ENABLED */
	private static final String ENABLED = "Enabled";

	/**
	 * Prints log for Global VQE Setting.
	 * 
	 * @param globalQoESettings
	 */
	public static void printLogForQOEGlobalSetting(GlobalQoESettings globalQoESettings) {
		StringBuilder stringBuilder = new StringBuilder("QOE Global Setting with the following parameters:");
		stringBuilder.append("\nAllowRCCOverSubscription = ");
		stringBuilder.append(globalQoESettings.getAllowRCCOverSubscription());
		stringBuilder.append("\nQoeRCCEnableDefault = ");
		stringBuilder.append(globalQoESettings.getQoeRCCEnableDefault());
		stringBuilder.append("\nQoeRETEnableDefault = ");
		stringBuilder.append(globalQoESettings.getQoeRETEnableDefault());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Prints log for connection mode.
	 * 
	 * @param connectionMode
	 */
	public static void printLogForConnectionMode(
			com.accenture.avs.device.json.object.devicemanager.ConnectionMode connectionMode) {
		StringBuilder stringBuilder = new StringBuilder("Connection Mode with the following parameters:");
		stringBuilder.append("\nName = ");
		stringBuilder.append(connectionMode.getName());
		stringBuilder.append("\nStatus = ");
		stringBuilder.append(connectionMode.getStatus());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Prints log for Language.
	 * 
	 * @param language
	 */
	public static void printLogForLanguage(Language language) {
		StringBuilder stringBuilder = new StringBuilder("Lanuguage with the following parameters:");
		stringBuilder.append("\nDisplayName = ");
		stringBuilder.append(language.getDisplayName());
		stringBuilder.append("\nAvailableForAudio = ");
		stringBuilder.append(language.getAvailableForAudio());
		stringBuilder.append("\nAvailableForUI = ");
		stringBuilder.append(language.getAvailableForUI());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Generates response for device manager exception.
	 * 
	 * @param genericResponseForB2B
	 * @param errorCode
	 * @param errorDescription
	 */
	public static void generateResponseForDeviceManagerException(GenericResponse genericResponseForB2B,
			String errorCode, String errorDescription) {
		genericResponseForB2B.setResultCode(errorCode);
		genericResponseForB2B.setResultDescription(errorDescription);
		genericResponseForB2B.setResultObj(null);
		genericResponseForB2B.setExecutionTime(((Long) System.currentTimeMillis()).intValue());
	}

	/**
	 * Generates response for successful request.
	 * 
	 * @param genericResponseForB2B
	 */
	public static void generateResponseForSuccessfullRequest(GenericResponse genericResponseForB2B) {
		genericResponseForB2B.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		genericResponseForB2B.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
		genericResponseForB2B.setResultObj(null);
		genericResponseForB2B.setExecutionTime(((Long) System.currentTimeMillis()).intValue());
	}

	/**
	 * Checks whether result code is valid or not.
	 * 
	 * @param resultCodeFromResponse
	 * @return boolean
	 */
	public static boolean isResponseResultCodeValid(String resultCodeFromResponse) {
		String resultCodeSuccess = (String) IdentificationType.genericSuccessResultCode
				.toDataType(IdentificationType.genericSuccessResultCode.getProperty());
		LOGGER.logMessage("resultCodeFromResponse:: " + resultCodeFromResponse);
		return resultCodeSuccess.equals(resultCodeFromResponse);
	}

	/**
	 * Compares optional Long and Integer values and returns true if there is
	 * difference in two values else returns false.
	 * 
	 * @param value1
	 * @param value2
	 * @return boolean
	 */
	public static boolean compareOptionalLongAndIntegerValues(Long value1, Integer value2) {
		return (value1 == null && value2 != null)
				|| (value1 != null && value2 != null && compareLongAndIntegerValues(value1, value2));
	}

	/**
	 * Compares mandatory Long and optional Integer values and returns true if there
	 * is difference in two values else returns false.
	 * 
	 * @param value1
	 * @param value2
	 * @return boolean
	 */
	public static boolean compareMandatoryLongAndOptionalIntegerValues(Long value1, Integer value2) {
		return value2 != null && compareLongAndIntegerValues(value1, value2);
	}

	/**
	 * Compares Boolean values and returns true if there is difference in two values
	 * else returns false.
	 * 
	 * @param value1
	 * @param value2
	 * @return boolean
	 */
	public static boolean compareBooleanValues(Boolean value1, Boolean value2) {
		return (value1 == null && value2 != null)
				|| (value1 != null && value2 != null && value1.booleanValue() != value2.booleanValue());
	}

	/**
	 * Compares String values and returns true if there is difference in two values
	 * else returns false.
	 * 
	 * @param value1
	 * @param value2
	 * @return boolean
	 */
	public static boolean compareStringValues(String value1, String value2) {
		return value1 != null && value2 != null && !value1.equals(value2);
	}

	/**
	 * Compares Long and Integer values and returns true if there is difference in
	 * two values else returns false.
	 * 
	 * @param value1
	 * @param value2
	 * @return boolean
	 */
	private static boolean compareLongAndIntegerValues(Long value1, Integer value2) {
		return value1.intValue() != value2;
	}

	/**
	 * Validates updateGlobalData.
	 * 
	 * @param updateGlobalData
	 */
	public static void validateUpdateGlobalData(UpdateGlobalData updateGlobalData) {
		List<com.accenture.avs.device.json.object.devicemanager.ConnectionMode> connectionModes = updateGlobalData
				.getGlobalData().getConnectionModes();
		if (connectionModes != null && !connectionModes.isEmpty()) {
			Map<String, String> connectionModemap = new HashMap<>();
			connectionModes.stream().forEach(connectionMode -> {
				connectionModemap.put(connectionMode.getName().toString(), connectionMode.getStatus().toString());
			});
			validateConnectionMode(connectionModemap);
		}
	}

	/**
	 * Validates connection mode.
	 * 
	 * @param connectionModemap
	 */
	private static void validateConnectionMode(Map<String, String> connectionModemap) {
		boolean allConnectionStatusDisabled = true;
		for (String status : connectionModemap.values()) {
			if (status.equals(ENABLED)) {
				allConnectionStatusDisabled = false;
				break;
			}
		}

		if (allConnectionStatusDisabled) {
			throw new DeviceManagerException(ErrorCode.ATLEAST_ONE_CONN_MODE_SHOULD_ACTIVE);
		}

		if (connectionModemap.get(IMPLICIT_NAT) != null && connectionModemap.get(UPNP) != null
				&& ENABLED.equals(connectionModemap.get(IMPLICIT_NAT)) && ENABLED.equals(connectionModemap.get(UPNP))) {
			throw new DeviceManagerException(ErrorCode.CONNECTION_MODES_CAN_NOT_BE_UPDATED);
		}
	}
}
