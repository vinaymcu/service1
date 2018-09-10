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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for DEFAULT_SERVICE_PORT_MAPPINGS table.
 * 
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "DEFAULT_SERVICE_PORT_LINK")
public class DefaultServicePortMapping implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** serviceId */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SERVICE_ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long serviceId;

	@Column(name = "SERVICE_NAME", unique = true, nullable = false, length = 20)
	private String serviceName;
	
	/** defaultInternalPort */
	@Column(name = "DEFAULT_INTERNAL_PORT", nullable = false, precision = 6, scale = 0)
	private Long defaultInternalPort;
	
	/** defaultExternalPort */
	@Column(name = "DEFAULT_EXTERNAL_PORT", nullable = false, precision = 6, scale = 0)
	private Long defaultExternalPort;
	
	/** protocol */
	@Column(name = "PROTOCOL", nullable = false, length = 10)
	private String protocol;
	
	/** defaultService */
	@Column(name = "DEFAULT_SERVICE", columnDefinition = "TINYINT", length = 1)
	private Boolean defaultService;

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
	 * Gets service name.
	 * 
	 * @return String
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * Sets service name.
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * Gets default internal port.
	 * 
	 * @return Long
	 */
	public Long getDefaultInternalPort() {
		return defaultInternalPort;
	}

	/**
	 * Sets default internal port.
	 * 
	 * @param defaultInternalPort
	 */
	public void setDefaultInternalPort(Long defaultInternalPort) {
		this.defaultInternalPort = defaultInternalPort;
	}

	/**
	 * Gets default external port.
	 * 
	 * @return Long
	 */
	public Long getDefaultExternalPort() {
		return defaultExternalPort;
	}

	/**
	 * Sets default external port.
	 * 
	 * @param defaultExternalPort
	 */
	public void setDefaultExternalPort(Long defaultExternalPort) {
		this.defaultExternalPort = defaultExternalPort;
	}

	/**
	 * Gets protocol.
	 * 
	 * @return String
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * Sets protocol.
	 * 
	 * @param protocol
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * Gets defaultService.
	 * 
	 * @return Boolean
	 */
	public Boolean getDefaultService() {
		return defaultService;
	}

	/**
	 * Sets defaultService.
	 * 
	 * @param defaultService
	 */
	public void setDefaultService(Boolean defaultService) {
		this.defaultService = defaultService;
	}
}
