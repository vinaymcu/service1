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

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Composite Primary Key for SUBSCRIBER_DEVICE_LIMIT table
 * 
 * @author rajesh.karna
 *
 */
@Embeddable
public class SubscriberDeviceLimitId implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 7903874055034327823L;

	/** subscriberId */
	@Column(name = "SUBSCRIBER_ID", nullable = false, unique = false, length = 100)
	private String subscriberId;

	/** resolutionTypeName */
	@Column(name = "RESOLUTION_TYPE_NAME", nullable = false, unique = false, length = 10)
	private String resolutionTypeName;

	/**
	 * Default constructor
	 */
	public SubscriberDeviceLimitId() {

	}

	/**
	 * constructor
	 * 
	 * @param subscriberId
	 * @param contentQuality
	 */
	public SubscriberDeviceLimitId(String subscriberId, String resolutionTypeName) {
		this.subscriberId = subscriberId;
		this.resolutionTypeName = resolutionTypeName;
	}

	/**
	 * Gets subscriberId
	 * 
	 * @return String
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * Sets subscriberId
	 * 
	 * @param subscriberId
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	/**
	 * Gets resolution type name.
	 * 
	 * @return String
	 */
	public String getResolutionTypeName() {
		return resolutionTypeName;
	}

	/**
	 * Sets resolution type name.
	 * 
	 * @param contentQuality
	 */
	public void setResolutionTypeName(String resolutionTypeName) {
		this.resolutionTypeName = resolutionTypeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (subscriberId == null ? 0 : subscriberId.hashCode());
		result = prime * result + (resolutionTypeName == null ? 0 : resolutionTypeName.hashCode());
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

		final SubscriberDeviceLimitId other = (SubscriberDeviceLimitId) obj;

		if (subscriberId == null) {

			if (other.subscriberId != null) {
				return false;
			}
		} else if (!subscriberId.equals(other.subscriberId)) {
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
