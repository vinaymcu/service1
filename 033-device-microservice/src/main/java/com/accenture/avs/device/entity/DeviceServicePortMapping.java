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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "DEVICE_SERVICE_PORT_MAPPINGS")
public class DeviceServicePortMapping implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** equipmentId */
	@EmbeddedId
	DeviceServicePortMappingId id;

	/** internalPort */
	@Column(name = "INTERNAL_PORT", nullable = false, precision = 5, scale = 0)
	private Long internalPort;

	/** externalPort */
	@Column(name = "EXTERNAL_PORT", nullable = false, precision = 5, scale = 0)
	private Long externalPort;
	
	/** device */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EQUIPMENT_ID", insertable=false, updatable=false)
	private Device device;

	/**
	 * @return the id
	 */
	public DeviceServicePortMappingId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DeviceServicePortMappingId id) {
		this.id = id;
	}

	/**
	 * @return the internalPort
	 */
	public Long getInternalPort() {
		return internalPort;
	}

	/**
	 * @param internalPort the internalPort to set
	 */
	public void setInternalPort(Long internalPort) {
		this.internalPort = internalPort;
	}

	/**
	 * @return the externalPort
	 */
	public Long getExternalPort() {
		return externalPort;
	}

	/**
	 * @param externalPort the externalPort to set
	 */
	public void setExternalPort(Long externalPort) {
		this.externalPort = externalPort;
	}

	/**
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * @param device the setTopBox to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}
	
}
