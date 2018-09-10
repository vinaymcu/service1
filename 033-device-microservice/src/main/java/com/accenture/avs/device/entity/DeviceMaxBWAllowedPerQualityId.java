/************************************************************************
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
import javax.persistence.Embeddable;

/**
 * Composite Primary Key for DEVICE_MAX_BW_ALLOWED_PER_QUALITY table
 * 
 * @author rajesh.karna
 *
 */
@Embeddable
public class DeviceMaxBWAllowedPerQualityId implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -3244894299331131855L;

	/** id */
	@Column(name = "ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long id;

	/** tvQuality */
	@Column(name = "RESOLUTION_TYPE_NAME", length = 10)
	private String resolutionTypeName;

	/**
	 * Default Constructor
	 * 
	 */
	public DeviceMaxBWAllowedPerQualityId() {

	}

	/**
	 * Constructor for the creation of DeviceMaxBWAllowedPerQualityId.
	 * 
	 * @param id
	 * @param resolutionTypeName
	 */
	public DeviceMaxBWAllowedPerQualityId(Long id, String resolutionTypeName) {
		this.id = id;
		this.resolutionTypeName = resolutionTypeName;
	}

	/**
	 * Gets id
	 * 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets tvQuality
	 * 
	 * @return String
	 */
	public String getResolutionTypeName() {
		return resolutionTypeName;
	}

	/**
	 * Sets tvQuality
	 * 
	 * @param tvQuality
	 */
	public void setResolutionTypeName(String resolutionTypeName) {
		this.resolutionTypeName = resolutionTypeName;
	}

	/**
	 * Override hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) id;
		hash += (resolutionTypeName != null ? resolutionTypeName.hashCode() : 0);
		return hash;
	}

	/**
	 * Override equals()
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof DeviceMaxBWAllowedPerQualityId)) {
			return false;
		}

		final DeviceMaxBWAllowedPerQualityId other = (DeviceMaxBWAllowedPerQualityId) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}

		if (resolutionTypeName == null) {
			if (other.resolutionTypeName != null) {
				return false;
			}
		} else if (!resolutionTypeName.equals(other.resolutionTypeName)) {
			return false;
		}

		return true;
	}
}
