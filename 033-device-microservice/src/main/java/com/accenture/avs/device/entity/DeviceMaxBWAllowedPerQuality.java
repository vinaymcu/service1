/*******com.accenture.avs.device.entity******************************************
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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class for DEVICE_MAX_BANDWIDTH_ALLOWED_PER_QUALITY table
 * 
 * @author rajesh.karna
 *
 */
@Entity 
@Table(name = "DEVICE_MAX_BANDWIDTH_ALLOWED_PER_QUALITY")
public class DeviceMaxBWAllowedPerQuality implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

    /** id */
	@EmbeddedId
	private DeviceMaxBWAllowedPerQualityId id;

	/** maxBandwidth */
	@Column(name = "MAX_BANDWIDTH", precision = 9, scale = 0)
	private Long maxBandwidth;
	
	/**
	 * Default constructor
	 */
	public DeviceMaxBWAllowedPerQuality() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 */
	public DeviceMaxBWAllowedPerQuality(DeviceMaxBWAllowedPerQualityId id) {
		this.id = id;
	}

	/**
	 * Gets id
	 * 
	 * @return DeviceMaxBWAllowedPerQualityId
	 */
	public DeviceMaxBWAllowedPerQualityId getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(DeviceMaxBWAllowedPerQualityId id) {
		this.id = id;
	}

	/**
	 * Gets maxBandwidth
	 * 
	 * @return Long
	 */
	public Long getMaxBandwidth() {
		return maxBandwidth;
	}

	/**
	 * Sets maxBandwidth
	 * 
	 * @param maxBandwidth
	 */
	public void setMaxBandwidth(Long maxBandwidth) {
		this.maxBandwidth = maxBandwidth;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof DeviceMaxBWAllowedPerQuality)) {
			return false;
		}
		DeviceMaxBWAllowedPerQuality other = (DeviceMaxBWAllowedPerQuality) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
}
