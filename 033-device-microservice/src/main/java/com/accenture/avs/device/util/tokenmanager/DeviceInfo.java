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
package com.accenture.avs.device.util.tokenmanager;

/**
 * @author surendra.kumar
 *
 */
public class DeviceInfo {
	
	/** deviceId */
	private String deviceId;
	/** deviceIdType */
	private String deviceIdType;
	/** deviceModel */
	private String deviceModel;
	/** deviceVendor */
	private String deviceVendor;
	/** deviceType */
	private String deviceType;
	/** deviceYear */
	private String deviceYear;
	
	/**
	 * default constructor
	 */
	public DeviceInfo() {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * 
	 * @param deviceId
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDeviceIdType() {
		return deviceIdType;
	}
	
	/**
	 * 
	 * @param deviceIdType
	 */
	public void setDeviceIdType(String deviceIdType) {
		this.deviceIdType = deviceIdType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDeviceModel() {
		return deviceModel;
	}
	
	/**
	 * 
	 * @param deviceModel
	 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDeviceVendor() {
		return deviceVendor;
	}
	
	/**
	 * 
	 * @param deviceVendor
	 */
	public void setDeviceVendor(String deviceVendor) {
		this.deviceVendor = deviceVendor;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDeviceType() {
		return deviceType;
	}
	
	/**
	 * 
	 * @param deviceType
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDeviceYear() {
		return deviceYear;
	}
	
	/**
	 * 
	 * @param deviceYear
	 */
	public void setDeviceYear(String deviceYear) {
		this.deviceYear = deviceYear;
	}
	
	/**
	 * 
	 * @param deviceId
	 * @param deviceIdType
	 * @param deviceModel
	 * @param deviceVendor
	 * @param deviceType
	 * @param deviceYear
	 */
	public DeviceInfo(String deviceId, String deviceIdType, String deviceModel,
			String deviceVendor, String deviceType, String deviceYear) {
		super();
		this.deviceId = deviceId;
		this.deviceIdType = deviceIdType;
		this.deviceModel = deviceModel;
		this.deviceVendor = deviceVendor;
		this.deviceType = deviceType;
		this.deviceYear = deviceYear;
	}
	
	
	
	
	
}
