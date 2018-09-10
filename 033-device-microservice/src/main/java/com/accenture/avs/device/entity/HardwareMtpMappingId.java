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
 * 
 * @author rajesh.karna
 *
 */
@Embeddable
public class HardwareMtpMappingId implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** hardwareName */
	@Column(name = "HARDWARE_NAME", length = 30)
	private String hardwareName;
	
	/** videoTypeName */
	@Column(name = "VIDEO_TYPE_NAME", length = 20)
	private String videoTypeName;
	
	/**
	 * Empty constructor.
	 */
	public HardwareMtpMappingId() {

	}

	/**
	 * Constructor for the creation of HardwareMtpMappingId object.
	 * 
	 * @param hardwareName
	 * @param videoTypeName
	 */
	public HardwareMtpMappingId(String hardwareName, String videoTypeName) {

		this.hardwareName = hardwareName;
		this.videoTypeName = videoTypeName;
	}

	/**
	 * Gets hardware name.
	 * 
	 * @return String
	 */
	public String getHardwareName() {
		return hardwareName;
	}

	/**
	 * Sets hardware name.
	 * 
	 * @param hardwareName
	 */
	public void setHardwareName(String hardwareName) {
		this.hardwareName = hardwareName;
	}

	/**
	 * Gets video type name.
	 * 
	 * @return the videoTypeName
	 */
	public String getVideoTypeName() {
		return videoTypeName;
	}

	/**
	 * Sets video type name.
	 * 
	 * @param videoTypeName the videoTypeName to set
	 */
	public void setVideoTypeName(String videoTypeName) {
		this.videoTypeName = videoTypeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hardwareName == null ? 0 : hardwareName.hashCode());
		result = prime * result + (videoTypeName == null ? 0 : videoTypeName.hashCode());
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
        
        final HardwareMtpMappingId other = (HardwareMtpMappingId) obj;
        
        if (hardwareName == null) {
            
            if (other.hardwareName != null) {
                return false;
            }
        } else if (!hardwareName.equals(other.hardwareName)) {
            return false;
        }
        
        if (videoTypeName == null) {
            
            if (other.videoTypeName != null) {
                return false;
            }
        } else if (!videoTypeName.equals(other.videoTypeName)) {
            return false;
        }
        
        return true;
    }
}
