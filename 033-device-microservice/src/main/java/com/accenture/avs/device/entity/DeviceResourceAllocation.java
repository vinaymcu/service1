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

package com.accenture.avs.device.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity class for STB_RESOURCES_ALLOCATION table
 * 
 * @author Singh.Saurabh
 *
 */
@Entity
@Table(name = "DEVICE_RESOURCES_ALLOCATION")
public class DeviceResourceAllocation implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -5854632476589876832L;

	/** equipmentId */
	@Id
	@Column(name = "EQUIPMENT_ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long equipmentId;

	/** deviceProfile */
	@Column(name = "DEVICE_PROFILE", length = 20)
	private String deviceProfile;

	/** profileBandwidth */
	@Column(name = "PROFILE_BANDWIDTH", precision = 8, scale = 0)
	private Long profileBandwidth;

	/** qoeBandwidth */
	@Column(name = "QOE_BANDWIDTH", precision = 8, scale = 0)
	private Long qoeBandwidth;

	/** lastUpdateOn */
	@Column(name = "LAST_UPDATED_ON", precision = 20, scale = 0)
	private Long lastUpdatedOn;
	
	/** setTopBox */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EQUIPMENT_ID", insertable=false, updatable=false)
	private Device device;
	/**
	 * Default constructor
	 */
	public DeviceResourceAllocation() {
	}

	/**
	 * Constructor
	 * 
	 * @param equipmentId
	 */
	public DeviceResourceAllocation(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * Gets equipmentId
	 * 
	 * @return Long
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
	 * Gets deviceProfile
	 * 
	 * @return String
	 */
	public String getDeviceProfile() {
		return deviceProfile;
	}

	/**
	 * Sets deviceProfile
	 * 
	 * @param deviceProfile
	 */
	public void setDeviceProfile(String deviceProfile) {
		this.deviceProfile = deviceProfile;
	}

	/**
	 * Gets profileBandwidth
	 * 
	 * @return Long
	 */
	public Long getProfileBandwidth() {
		return profileBandwidth;
	}

	/**
	 * Sets profileBandwidth
	 * 
	 * @param profileBandwidth
	 */
	public void setProfileBandwidth(Long profileBandwidth) {
		this.profileBandwidth = profileBandwidth;
	}

	/**
	 * Gets qoeBandwidth
	 * 
	 * @return Long
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

	/**
	 * Gets lastUpdatedOn
	 * 
	 * @return Long
	 */
	public Long getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	/**
	 * Sets lastUpdatedOn
	 * 
	 * @param lastUpdatedOn
	 */
	public void setLastUpdatedOn(Long lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	/**
	 * Override hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (equipmentId != null ? equipmentId.hashCode() : 0);
		return hash;
	}

	/**
	 * Override equals()
	 * 
	 */
	@Override
	public boolean equals(Object object) {

		if (object == null) {
			return false;
		}

		if (!(object instanceof DeviceResourceAllocation)) {
			return false;
		}
		DeviceResourceAllocation other = (DeviceResourceAllocation) object;
		if ((this.equipmentId == null && other.equipmentId != null)
				|| (this.equipmentId != null && !this.equipmentId.equals(other.equipmentId))) {
			return false;
		}
		return true;
	}

	/**
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}

	
}
