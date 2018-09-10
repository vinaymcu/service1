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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class for DEVICE_PROPERTIES table
 * 
 * @author Singh.Saurabh
 *
 */
@Entity
@Table(name = "DEVICE_PROPERTIES")
public class DeviceProperty implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7618545369439757145L;

	/** id */
	@EmbeddedId
	protected DevicePropertyId id;

	/** propertyValue */
	@Column(name = "PROPERTY_VALUE", length = 200)
	private String propertyValue;

	/**
	 * Constructor
	 * 
	 */
	public DeviceProperty() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 */
	public DeviceProperty(DevicePropertyId id) {
		this.id = id;
	}

	/**
	 * Gets id
	 * 
	 * @return id
	 */
	public DevicePropertyId getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(DevicePropertyId id) {
		this.id = id;
	}

	/**
	 * Gets propertyValue
	 * 
	 * @return propertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * Sets propertyValue
	 * 
	 * @param propertyValue
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof DeviceProperty)) {
			return false;
		}
		DeviceProperty other = (DeviceProperty) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

}
