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
 * Feature class for Device Profile
 * 
 * @author Singh.Saurabh
 *
 */
public class DeviceProfileDto {

	/** id */
	private Long id;

	/** deviceProfile */
	private String deviceProfile;

	/** deviceProfileBandwidth */
	private Long deviceProfileBandwidth;

	/** qoeBandwidth */
	private Long qoeBandwidth;

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
	public DeviceProfileDto(Long id, String deviceProfile, Long deviceProfileBandwidth, Long qoeBandwidth) {
		super();
		this.id = id;
		this.deviceProfile = deviceProfile;
		this.deviceProfileBandwidth = deviceProfileBandwidth;
		this.qoeBandwidth = qoeBandwidth;
	}

	/**
	 * Gets equipmentId
	 * 
	 * @return
	 */
	public Long getEquipmentId() {
		return id;
	}

	/**
	 * Sets equipmentId
	 * 
	 * @param equipmentId
	 */
	public void setEquipmentId(Long equipmentId) {
		this.id = equipmentId;
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
	 * Gets deviceProfileBandwidth
	 * 
	 * @return
	 */
	public Long getDeviceProfileBandwidth() {
		return deviceProfileBandwidth;
	}

	/**
	 * Sets deviceProfileBandwidth
	 * 
	 * @param deviceProfileBandwidth
	 */
	public void setDeviceProfileBandwidth(Long deviceProfileBandwidth) {
		this.deviceProfileBandwidth = deviceProfileBandwidth;
	}

	/**
	 * Gets qoeBandwidth
	 * 
	 * @return
	 */
	public Long getQoeBandwidth() {
		return qoeBandwidth;
	}

	/**
	 * Sets qoeBandwidth
	 * 
	 * @param qoeBandwidth
	 */
	public void setQoeBandwidth(Long qoeBandwidth) {
		this.qoeBandwidth = qoeBandwidth;
	}

}
