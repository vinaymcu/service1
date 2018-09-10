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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for SUBSCRIBER_DEVICE_LIMIT table
 * 
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "SUBSCRIBER_DEVICE_LIMIT")
public class SubscriberDeviceLimit implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -6129427113466503364L;

	/** id */
	@EmbeddedId
	private SubscriberDeviceLimitId id;

	/** deviceLimit */
	@Column(name = "DEVICE_LIMIT", nullable = false, precision = 2, scale = 0)
	private Long deviceLimit;
	
	/** subscriberId */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SUBSCRIBER_ID", insertable=false, updatable=false)
	private Subscriber subscriber;

	/**
	 * Default constructor
	 */
	public SubscriberDeviceLimit() {

	}

	/**
	 * constructor
	 * 
	 * @param id
	 */
	public SubscriberDeviceLimit(SubscriberDeviceLimitId id) {
		this.id = id;
	}

	/**
	 * Gets deviceLimit
	 * 
	 * @return Long
	 */
	public Long getDeviceLimit() {
		return deviceLimit;
	}

	/**
	 * Sets deviceLimit
	 * 
	 * @param deviceLimit
	 */
	public void setDeviceLimit(Long deviceLimit) {
		this.deviceLimit = deviceLimit;
	}

	/**
	 * Gets id
	 * 
	 * @return SubscriberDeviceLimitId
	 */
	public SubscriberDeviceLimitId getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(SubscriberDeviceLimitId id) {
		this.id = id;
	}

	/**
	 * Gets subscriber.
	 * 
	 * @return the subscriber
	 */
	public Subscriber getSubscriber() {
		return subscriber;
	}

	/**
	 * Sets subscriber.
	 * 
	 * @param subscriber the subscriber to set
	 */
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
}
