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
import javax.persistence.Embeddable;

/**
 * 
 * @author rajesh.karna
 *
 */
@Embeddable
public class ServiceHardwareMappingId implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** serviceId */
	@Column(name = "SERVICE_ID", nullable = false, precision = 9, scale = 0)
	private Long serviceId;

	/** hardwareName */
	@Column(name = "HARDWARE_NAME", length = 20)
	private String hardwareName;

	/** Empty constructor */
	public ServiceHardwareMappingId() {

	}

	/**
	 * Constructor for the creation of ServiceHardwareMappingId.
	 * 
	 * @param serviceId
	 * @param hardwareName
	 */
	public ServiceHardwareMappingId(Long serviceId, String hardwareName) {

		this.serviceId = serviceId;
		this.hardwareName = hardwareName;
	}

	/**
	 * Gets service id.
	 * 
	 * @return Long
	 */
	public Long getServiceId() {
		return serviceId;
	}

	/**
	 * Sets service id.
	 * 
	 * @param serviceId
	 */
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * Sets hardware name.
	 * 
	 * @return String
	 */
	public String getHardwareName() {
		return hardwareName;
	}

	/**
	 * Gets hardware name.
	 * 
	 * @param hardwareName
	 */
	public void setHardwareName(String hardwareName) {
		this.hardwareName = hardwareName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (serviceId == null ? 0 : serviceId.hashCode());
		result = prime * result + (hardwareName == null ? 0 : hardwareName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final ServiceHardwareMappingId other = (ServiceHardwareMappingId) obj;

		if (serviceId == null) {

			if (other.serviceId != null) {
				return false;
			}
		} else if (!serviceId.equals(other.serviceId)) {
			return false;
		}

		if (hardwareName == null) {

			if (other.hardwareName != null) {
				return false;
			}
		} else if (!hardwareName.equals(other.hardwareName)) {
			return false;
		}

		return true;
	}
}
