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
 * Feature class for Device Properties
 * 
 * @author Singh.Saurabh
 *
 */
public class DevicesFeature {

	/** equipmentId */
	private Long equipmentId;

	/** macAddress */
	private String macAddress;

	/** hardwareVersion */
	private String hardwareVersion;

	/** tvQualityInterest */
	private String tvQualityInterest;

	/** deviceProfile */
	private String deviceProfile;

	/** assignmentDate */
	private Long assignmentDate;

	/**
	 * Constructor
	 * 
	 * @param equipmentId
	 * @param macAddress
	 * @param hardwareVersion
	 * @param tvQualityInterest
	 * @param deviceProfile
	 * @param assignmentDate
	 */
	public DevicesFeature(Long equipmentId, String macAddress, String hardwareVersion, String tvQualityInterest,
			String deviceProfile, Long assignmentDate) {
		super();
		this.equipmentId = equipmentId;
		this.macAddress = macAddress;
		this.hardwareVersion = hardwareVersion;
		this.tvQualityInterest = tvQualityInterest;
		this.deviceProfile = deviceProfile;
		this.assignmentDate = assignmentDate;
	}

	/**
	 * Gets equipmentId
	 * 
	 * @return
	 */
	public Long getEquipmentId() {
		return equipmentId;
	}

	/**
	 * Sets equipmentId
	 * 
	 * @param equipmentId
	 */
	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * Gets macAddress
	 * 
	 * @return
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * Sets macAddress
	 * 
	 * @param macAddress
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * Gets hardwareVersion
	 * 
	 * @return
	 */
	public String getHardwareVersion() {
		return hardwareVersion;
	}

	/**
	 * Sets hardwareVersion
	 * 
	 * @return
	 */
	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}

	/**
	 * Gets tvQualityInterest
	 * 
	 * @return
	 */
	public String getTvQualityInterest() {
		return tvQualityInterest;
	}

	/**
	 * Sets tvQualityInterest
	 * 
	 * @return
	 */
	public void setTvQualityInterest(String tvQualityInterest) {
		this.tvQualityInterest = tvQualityInterest;
	}

	/**
	 * Gets deviceProfile
	 * 
	 * @return
	 */
	public String getDeviceProfile() {
		return deviceProfile;
	}

	/**
	 * Sets deviceProfile
	 * 
	 * @return
	 */
	public void setDeviceProfile(String deviceProfile) {
		this.deviceProfile = deviceProfile;
	}

	/**
	 * Gets assignmentDate
	 * 
	 * @return
	 */
	public Long getAssignmentDate() {
		return assignmentDate;
	}

	/**
	 * Sets assignmentDate
	 * 
	 * @return
	 */
	public void setAssignmentDate(Long assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

}
