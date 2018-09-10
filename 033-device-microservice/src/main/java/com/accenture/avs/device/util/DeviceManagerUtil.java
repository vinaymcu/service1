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

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.accenture.avs.commons.lib.support.Utilities;

/**
 * Utility Class for Device Manager
 * 
 * @author Singh.Saurabh
 *
 */
public class DeviceManagerUtil {
	
	/**
	 * Checks if the provided String in null or blank
	 * 
	 * @param value
	 * @return true, if null or blank
	 */
	public static boolean checkNullorBlankString(String value) {
		if (value == null || value.isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Checks if the provided Object in null
	 * 
	 * @param value
	 * @return true, if null
	 */
	public static boolean checkNullObject(Object value) {
		if (value == null) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * Checks if the provided Collection in null or empty
	 * 
	 * @param value
	 * @return true, if null
	 */
	public static boolean checkNullOrEmptyCollection(Collection collection) {
		if (checkNullObject(collection) || collection.isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * Gets Long from Integer value.
	 * 
	 * @param value
	 * @return Long
	 */
	public static Long getLongFromInteger(Integer value) {
		return value == null ? null : value.longValue();
	}
	
	/**
	 * Gets Integer from Long value.
	 * 
	 * @param value
	 * @return Integer
	 */
	public static Integer getIntegerFromLong(Long value) {
		return value == null ? null : value.intValue();
	}

	/**
	 * Gets String from Long.
	 * 
	 * @param value
	 * @return String
	 */
	public static String getStringFromLong(Long value) {
		return value == null ? "" : value.toString();
	}
	
	/**
	 * This method returns blank string if null
	 * 
	 * @param value
	 * @return
	 */
	public static String getStringValue(String value) {
		if (checkNullorBlankString(value)) {
			return "";
		}
		return value;
	}
	
	/**
	 * This method returns id to be used to give in the error response.
	 * 
	 * @param macAddress
	 * @param equipmentId
	 * 
	 * @return String
	 */
	public static String getFailureResponseId(String macAddress, Integer equipmentId) {
		String id;
		if (DeviceManagerUtil.checkNullorBlankString(macAddress) && DeviceManagerUtil.checkNullObject(equipmentId)) {
			id = "";
		} else if (DeviceManagerUtil.checkNullorBlankString(macAddress)) {
			id = equipmentId.toString();
		} else {
			id = macAddress;
		}
		return id;
	}
	
	/**
	 * This method checks if two lists are equal or not. Lists should contain no
	 * duplicates.
	 * 
	 * @param listOne
	 * @param listTwo
	 * @return boolean
	 */
	public static <T> boolean isListEqualNoOrderNoDuplicates(List<T> listOne, List<T> listTwo) {
		final Set<T> setOne = new HashSet<>(listOne);
		final Set<T> setTwo = new HashSet<>(listTwo);
		return setOne.equals(setTwo);
	}
	
	/**
	 * Get Header Value
	 * @param httpRequest
	 * @return
	 */
	public static String getHeaderValue(HttpServletRequest httpRequest){
		String val = httpRequest.getHeader(Constants.LoggingParams.X_AVS_USER_NAME);
		if (Objects.isNull(val)){
			return Constants.DEFAULT_USER_NAME;
		}
		return val;
	}
	
	/**
	 * Gets headerMap
	 * @param request
	 * @return header map
	 */
	public static Map<String, String> getHeaderMapFormat(HttpServletRequest request) {
		Map<String, String> requestMap = new HashMap<>();
		Enumeration<String> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String keyHeader = enumeration.nextElement();
			if (!Utilities.isEmpty(keyHeader)) {
				String valueHeader = request.getHeader(keyHeader);
				requestMap.put(keyHeader, valueHeader);
			}
		}
		return requestMap;
	}
	
	/**
	 * This method returns the correct value for platform.
	 * 
	 * @param platform
	 * @return
	 */
	public static String getPlatformValue(String platform) {
		String platformValue = Constants.PlatformType.IPTV;
		if (checkNullObject(platform)) {
			return platform;
		} else if (Constants.PlatformType.OTT.equals(platform)) {
			platformValue = Constants.PlatformType.OTT;
		}
		return platformValue;
	}

	/**
	 * This method returns the correct device type value.
	 * 
	 * @param deviceType
	 * @return
	 */
	public static String getDeviceTypeValue(String deviceType) {
		String deviceTypeValue = Constants.DeviceType.STB;
		if (checkNullObject(deviceType)) {
			return deviceTypeValue;
		}
		switch (deviceType) {
		case Constants.DeviceType.TABLET_ANDROID:
			deviceTypeValue = Constants.DeviceType.TABLET_ANDROID;
			break;
		case Constants.DeviceType.SMARTWATCH_ANDROID:
			deviceTypeValue = Constants.DeviceType.SMARTWATCH_ANDROID;
			break;
		case Constants.DeviceType.IPHONE_IOS:
			deviceTypeValue = Constants.DeviceType.IPHONE_IOS;
			break;
		default:
			return deviceTypeValue;
		}
		return deviceTypeValue;
	}
	
	/**
	 * @param stringValue
	 * @return
	 */
	public static Boolean convertStringToBoolean(String stringValue) {
		Boolean booleanValue = null;
		if (checkNullorBlankString(stringValue)) {
			return booleanValue;
		}
		switch (stringValue) {
		case "1":
			booleanValue = Boolean.TRUE;
			break;
		case "true":
			booleanValue = Boolean.TRUE;
			break;
		case "0":
			booleanValue = Boolean.FALSE;
			break;
		case "false":
			booleanValue = Boolean.FALSE;
			break;
		}
		return booleanValue;
	}
	
	/**
	 * @param intValue
	 * @return
	 */
	public static Boolean convertIntToBoolean(Integer intValue) {
		Boolean booleanValue = null;
		if (intValue == null) {
			booleanValue = null;
		} else {
			booleanValue = intValue == 0 ? Boolean.FALSE : Boolean.TRUE;
		}
		return booleanValue;
	}
	
	/**
	 * @param booleanValue
	 * @return
	 */
	public static Integer convertBooleanToInt(Boolean booleanValue) {
		Integer intValue = null;
		if (booleanValue == null) {
			intValue = null;
		} else {
			intValue = booleanValue == Boolean.TRUE ? 1 : 0;
		}
		return intValue;
	}
	
	/**
	 * @param intVal
	 * @return Long
	 */
	public static Long convertIntegerToLong(Integer intVal) {
		Long longVal = null;
		if(intVal == null) {
			longVal =  null;
		}else{
			longVal = intVal.longValue(); 
		}
		return longVal;
	}
	
	/**
	 * @param longVal
	 * @return intVal
	 */
	public static Integer convertLongToInteger(Long longVal) {
		Integer intVal = null;
		if(longVal == null) {
			intVal =  null;
		}else{
			intVal = longVal.intValue(); 
		}
		return intVal;
	}
}
