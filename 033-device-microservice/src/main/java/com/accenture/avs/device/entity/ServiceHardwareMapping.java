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

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class for SERVICE_HARDWARE_MAPPING table.
 * 
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "SERVICE_HARDWARE_MAPPING")
public class ServiceHardwareMapping implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** id */
	@EmbeddedId
	private ServiceHardwareMappingId id;

	/**
	 * Gets id.
	 * 
	 * @return ServiceHardwareMappingId
	 */
	public ServiceHardwareMappingId getId() {
		return id;
	}

	/**
	 * Sets id.
	 * 
	 * @param id
	 */
	public void setId(ServiceHardwareMappingId id) {
		this.id = id;
	}
}
