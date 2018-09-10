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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class for SUBSCRIBERS table
 * 
 * @author Singh.Saurabh
 *
 */
@Entity
@Table(name = "SUBSCRIBERS")
public class Subscriber implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 8986667161566174321L;

	/** subscriberid */
	@Id
	@Column(name = "SUBSCRIBER_ID", unique = true, nullable = false, length = 100)
	private String subscriberId;

	/** accountNumber */
	@Column(name = "ACCOUNT_NUMBER", unique = true, length = 200)
	private String accountNumber;

	/** name */
	@Column(name = "NAME", nullable = false, length = 75)
	private String name;

	/** city */
	@Column(name = "CITY", length = 50)
	private String city;

	/** locationId */
	@Column(name = "LOCATION_ID", nullable = false, precision = 9, scale = 0)
	private Long locationId;

	/** type */
	@Column(name = "TYPE", length = 20)
	private String type;

	/** phoneNumber */
	@Column(name = "PHONE_NUMBER", length = 25)
	private String phoneNumber;

	/** subscriberBWProfile */
	@Column(name = "SUBSCRIBER_BANDWIDTH_PROFILE", nullable = false, length = 30)
	private String subscriberBWProfile;

	/** maxBWOverride */
	@Column(name = "MAX_BANDWIDTH_OVERRIDE", precision = 9, scale = 0)
	private Long maxBWOverride;

	/** qoeControlBandwidth */
	@Column(name = "QOE_CONTROL_BANDWIDTH", precision = 9, scale = 0)
	private Long qoeControlBandwidth;

	/** isRETEnable */
	@Column(name = "RET_ENABLE", columnDefinition = "TINYINT", length = 1)
	private Boolean retEnable;

	/** isRCCEnable */
	@Column(name = "RCC_ENABLE", columnDefinition = "TINYINT", length = 1)
	private Boolean rccEnable;

	/** networkBufferSize */
	@Column(name = "NETWORK_BUFFER_SIZE", precision = 9, scale = 0)
	private Long networkBufferSize;

	/** freeBandwidth */
	@Column(name = "FREE_BANDWIDTH", precision = 9, scale = 0)
	private Long freeBandwidth;

	/** status */
	@Column(name = "STATUS", nullable = false, length = 10)
	private String status;

	/** subscriberDeviceLimits */
	@OneToMany(mappedBy = "subscriber", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SubscriberDeviceLimit> subscriberDeviceLimits;
	
	/**
	 * Default Constructor
	 * 
	 */
	public Subscriber() {
	}

	/**
	 * Subscriber Constructor
	 * 
	 */
	public Subscriber(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * Subscriber Constructor
	 * 
	 */
	public Subscriber(String subscriberId, String name, String subscriberBWProfile, String status) {
		this.subscriberId = subscriberId;
		this.name = name;
		this.subscriberBWProfile = subscriberBWProfile;
		this.status = status;
	}

	/**
	 * Gets subscriberid
	 * 
	 * @return String
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * Sets subscriberid
	 * 
	 * @param subscriberid
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * Gets accountNumber
	 * 
	 * @return String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets accountNumber
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets name
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets city
	 * 
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets city
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets location id.
	 * 
	 * @return Long
	 */
	public Long getLocationId() {
		return locationId;
	}

	/**
	 * Sets location id.
	 * 
	 * @param locationId
	 */
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * Gets type
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets phoneNumber
	 * 
	 * @return String
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phoneNumber
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets subscriberBWProfile
	 * 
	 * @return String
	 */
	public String getSubscriberBWProfile() {
		return subscriberBWProfile;
	}

	/**
	 * Sets subscriberBWProfile
	 * 
	 * @param subscriberBWProfile
	 */
	public void setSubscriberBWProfile(String subscriberBWProfile) {
		this.subscriberBWProfile = subscriberBWProfile;
	}

	/**
	 * Gets maxBWOverride
	 * 
	 * @return Long
	 */
	public Long getMaxBWOverride() {
		return maxBWOverride;
	}

	/**
	 * Sets maxBWOverride
	 * 
	 * @param maxBWOverride
	 */
	public void setMaxBWOverride(Long maxBWOverride) {
		this.maxBWOverride = maxBWOverride;
	}

	/**
	 * Gets qoeControlBandwidth
	 * 
	 * @return Long
	 */
	public Long getQoeControlBandwidth() {
		return qoeControlBandwidth;
	}

	/**
	 * Sets qoeControlBandwidth
	 * 
	 * @param qoeControlBandwidth
	 */
	public void setQoeControlBandwidth(Long qoeControlBandwidth) {
		this.qoeControlBandwidth = qoeControlBandwidth;
	}

	/**
	 * Gets networkBufferSize
	 * 
	 * @return Long
	 */
	public Long getNetworkBufferSize() {
		return networkBufferSize;
	}

	/**
	 * Sets networkBufferSize
	 * 
	 * @param networkBufferSize
	 */
	public void setNetworkBufferSize(Long networkBufferSize) {
		this.networkBufferSize = networkBufferSize;
	}

	/**
	 * Gets freeBandwidth
	 * 
	 * @return
	 */
	public Long getFreeBandwidth() {
		return freeBandwidth;
	}

	/**
	 * Sets freeBandwidth
	 * 
	 * @param freeBandwidth
	 */
	public void setFreeBandwidth(Long freeBandwidth) {
		this.freeBandwidth = freeBandwidth;
	}

	/**
	 * Gets status
	 * 
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets status
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public List<SubscriberDeviceLimit> getSubscriberDeviceLimits() {
		return subscriberDeviceLimits;
	}

	/**
	 * @param subscriberDeviceLimits
	 */
	public void setSubscriberDeviceLimits(List<SubscriberDeviceLimit> subscriberDeviceLimits) {
		this.subscriberDeviceLimits = subscriberDeviceLimits;
	}

	/**
	 * @return the retEnable
	 */
	public Boolean getRetEnable() {
		return retEnable;
	}

	/**
	 * @param retEnable
	 *            the retEnable to set
	 */
	public void setRetEnable(Boolean retEnable) {
		this.retEnable = retEnable;
	}

	/**
	 * @return the rccEnable
	 */
	public Boolean getRccEnable() {
		return rccEnable;
	}

	/**
	 * @param rccEnable
	 *            the rccEnable to set
	 */
	public void setRccEnable(Boolean rccEnable) {
		this.rccEnable = rccEnable;
	}

	/**
	 * Override hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (subscriberId != null ? subscriberId.hashCode() : 0);
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

		if (!(obj instanceof Subscriber)) {
			return false;
		}

		final Subscriber other = (Subscriber) obj;

		if (subscriberId == null) {

			if (other.subscriberId != null) {
				return false;
			}
		} else if (!subscriberId.equals(other.subscriberId)) {
			return false;
		}

		return true;
	}
}
