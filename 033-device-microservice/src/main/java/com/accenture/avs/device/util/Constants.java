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

/**
 * The interface Constants used for define constant
 * 
 * @author muhammad.yunus
 *
 */
public interface Constants {	
	/** START_INDEX_DEFAULT */
	String  START_INDEX_DEFAULT = "0";	
	/** MAX_RESULTS_DEFAULT */
	String  MAX_RESULTS_DEFAULT = "50";
	String  DB_PARAM_DEVICEID = "deviceId";
	String  DB_PARAM_STARTINDEX = "startIndex";
	String  DB_PARAM_MAXRESULTS = "maxResults";
	String  DEFAULT_USER_NAME = "System";
	String  DB_PARAM_HARDWARENAME = "hardwareName";
	String  DB_PARAM_SERVICEID = "serviceId";
	String  DB_PARAM_STARTDATE = "startDate";
	String  DB_PARAM_ENDDATE = "endDate";
	String  DB_PARAM_EQUIPMENTID_LIST = "equipmentIdList";
	String  DB_PARAM_ACCOUNTNUMBER = "accountNumber";
	String  DB_PARAM_SUBSCRIBERID = "subscriberId";

	String DB_PARAM_LASTUPDATE_DATETIME = "lastUpdateDatetime";
	String DB_PARAM_LASTUPDATE_USER_ID = "lastUpdateUserId";
	String DB_PARAM_NAME = "name";
	//String DB_PARAM_UDF_NAME = "udfName";
	String DB_PARAM_EQUIPMENTID = "equipmentId";
	//String DB_PARAM_UDFID = "udfId";
	String DB_PARAM_RULEID = "ruleId";
	String DB_PARAM_SOFTWAREVERSION = "softwareVersion";
	
	String UPDATE_DEVICE_API = "UPDATE_DEVICE";
	String ASSIGN_DEVICE_API = "ASSIGN_DEVICE";
	String CREATE_AND_ASSIGN_DEVICE_API = "CREATE_AND_ASSIGN_DEVICE";
	String UNASSIGN_DEVICE_API = "UNASSIGN_DEVICE";
	String SET_DEVICE_PROPERTIES_API =  "SET_DEVICE_PROPERTIES";
	String USER_NAMES = "userNames";
	
	String TV_QUALITY_INTEREST = "tvQualityInterest";
	String SOFTWARE_VERSION = "softwareVersion";
	String VENDOR = "vendor";
	
	String IMPLICIT_NAT = "Implicit NAT";
	
	interface LoggingParams {

		String USER_AGENT_HEADER_NAME = "User-Agent";
		String USER_ID_HEADER_NAME = "USER_ID";
		String HEADER_CHANNEL = "channel";
		String HEADER_CLIENTIP = "ClientIP";
		

		String TS = "ts";
		String APP_ID = "appId";
		String THREAD = "thread";
		String SID = "SID";
		String TN = "TN";
		String CLIENT_IP = "clientIp";
		String USER = "user";
		String API_TYPE = "apiType";
		String API = "api";
		String PLATFORM = "platform";

		String EVENT_TYPE = "eventType";
		String USER_AGENT = "userAgent";
		String EXECUTION_TIME = "executionTime";
		
		// Header Parameters
		String X_AVS_USER_NAME = "X-avs-username";
		String X_AVS_TRANSACTION_ID = "X-avs-transactionId";
		String X_AVS_SESSION_ID = "X-avs-sessionId";

	}

	public interface AssignmentStatus {
		String ASSIGNED = "Assigned";
		String UNASSIGNED = "Unassigned";
	}
	
	public interface Status {
		String SUCCESS_RESULT_CODE = "ACN_200";
		String SUCCESS_RESULT_DESCRIPTION = "OK";
		String FAILURE_RESULT_DESCRIPTION = "KO";
	}
	
	public interface ApiType {
		String B2B = "B2B";
		String CREATEDEVICE = "CreateDevice";
		String UPDATEDEVICE = "UpdateDevice";
	}
	
	public interface DeviceType {
		String STB = "STB";
		String TABLET_ANDROID = "TABLET_ANDROID";
		String SMARTWATCH_ANDROID = "SMARTWATCH_ANDROID";
		String IPHONE_IOS = "IPHONE_IOS";
	}
	
	public interface PlatformType {
		String IPTV = "IPTV";
		String OTT = "OTT";
	}
	
	public interface Trigger {
		String T_SUBSCRIBER_INFO = "T_SUBSCRIBER_INFO";
		String T_TRIGGER_INFO = "";
	}

}
