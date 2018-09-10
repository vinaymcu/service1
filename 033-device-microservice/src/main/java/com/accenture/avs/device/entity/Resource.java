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
import javax.persistence.Table;

/**
 * Entity class for RESOURCES table
 * 
 * @author Singh.Saurabh
 *
 */
@Entity
@Table(name = "RESOURCES")
public class Resource implements java.io.Serializable {

	private static final long serialVersionUID = -6241026165523153503L;

	/** id */
	@EmbeddedId
	private ResourceId id;

	/** description */
	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	/** unit */
	@Column(name = "UNIT", length = 20)
	private String unit;

	/**
	 * Default constructor
	 */
	public Resource() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param description
	 * @param unit
	 */
	public Resource(ResourceId id, String description, String unit) {
		this.id = id;
		this.description = description;
		this.unit = unit;
	}

	/**
	 * Gets id
	 * 
	 * @return ResourceId
	 */
	public ResourceId getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(ResourceId id) {
		this.id = id;
	}

	/**
	 * Gets description
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets unit
	 * 
	 * @return String
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Sets unit
	 * 
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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

		if (!(object instanceof Resource)) {
			return false;
		}
		Resource other = (Resource) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
}
