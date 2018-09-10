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
import javax.persistence.Embeddable;

/**
 * @author rajesh.karna
 *
 */
@Embeddable
public class DeviceServicePortMappingId implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** equipmentId */
	@Column(name = "EQUIPMENT_ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long equipmentId;
	
	/** serviceId */
	@Column(name = "SERVICE_ID", nullable = false, precision = 9, scale = 0)
	private Long serviceId;
	
	/** Empty constructor */
	public DeviceServicePortMappingId() {
	}

	/**
	 * Constructor for the creation of DeviceServicePortMapping.
	 * 
	 * @param equipmentId
	 * @param serviceId
	 */
	public DeviceServicePortMappingId(Long equipmentId, Long serviceId) {
		
		this.equipmentId = equipmentId;
		this.serviceId = serviceId;
	}

	/**
	 * @return the equipmentId
	 */
	public Long getEquipmentId() {
		return equipmentId;
	}

	/**
	 * @param equipmentId the equipmentId to set
	 */
	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * @return the serviceId
	 */
	public Long getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (equipmentId == null ? 0 : equipmentId.hashCode());
		result = prime * result + (serviceId == null ? 0 : serviceId.hashCode());
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
        
        final DeviceServicePortMappingId other = (DeviceServicePortMappingId) obj;
        
        if (equipmentId == null) {
            
            if (other.equipmentId != null) {
                return false;
            }
        } else if (!equipmentId.equals(other.equipmentId)) {
            return false;
        }
        
        if (serviceId == null) {
            
            if (other.serviceId != null) {
                return false;
            }
        } else if (!serviceId.equals(other.serviceId)) {
            return false;
        }
        
        return true;
    }
}
