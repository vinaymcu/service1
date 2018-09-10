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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for DEVICE_ASSIGNED_RESOURCES table
 * 
 * @author Singh.Saurabh
 *
 */
@Entity
@Table(name = "DEVICE_ASSIGNED_RESOURCES")
public class DeviceAssignedResource implements java.io.Serializable {

	private static final long serialVersionUID = -4220405238756913242L;

	/** id */
	@EmbeddedId
	private DeviceAssignedResourceId id;

	/** amount */
	@Column(name = "AMOUNT", length = 20)
	private String amount;
	
	/** device */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EQUIPMENT_ID", insertable=false, updatable=false)
	private Device device;

	/**
	 * Default constructor
	 */
	public DeviceAssignedResource() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 */
	public DeviceAssignedResource(DeviceAssignedResourceId id) {
		this.id = id;
	}

	/**
	 * Gets id
	 * 
	 * @return DeviceAssignedResourceId
	 */
	public DeviceAssignedResourceId getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(DeviceAssignedResourceId id) {
		this.id = id;
	}

	/**
	 * Gets amount
	 * 
	 * @return String
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * Sets amount
	 * 
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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

	/**
	 * Override hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
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

		if (!(object instanceof DeviceAssignedResource)) {
			return false;
		}
		DeviceAssignedResource other = (DeviceAssignedResource) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

}