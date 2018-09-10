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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for LOCATIONS table.
 * 
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "LOCATIONS")
public class Location implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** id */
	@Id
	@Column(name = "LOCATION_ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long locationId;

	/** parentId */
	@Column(name = "PARENT_ID", nullable = false, precision = 9, scale = 0)
	private Long parentId;

	/** name */
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;
	
	/** tvRegionId */
	@Column(name = "TV_REGION_ID", nullable = false, precision = 9, scale = 0)
	private Long tvRegionId;
	
	/**
	 * Gets locationId.
	 * 
	 * @return the locationId
	 */
	public Long getLocationId() {
		return locationId;
	}

	/**
	 * Sets locationId.
	 * 
	 * @param locationId the locationId to set
	 */
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * Gets parent id.
	 * 
	 * @return Long
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * Sets parent id.
	 * 
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * Gets name.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Long the tvRegionId
	 */
	public Long getTvRegionId() {
		return tvRegionId;
	}

	/**
	 * @param tvRegionId the tvRegionId to set
	 */
	public void setTvRegionId(Long tvRegionId) {
		this.tvRegionId = tvRegionId;
	}
}
