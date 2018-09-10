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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Composite Primary Key for MODEL_MAX_STREAMS_ALLOWED_PER_QUALITY table
 * 
 * @author rajesh.kumar
 *
 */
@Embeddable
public class ModelMaxStreamsAllowedPerQualityId implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -3244894299331131853L;

	/** modelId */
	@Column(name = "MODEL_NAME", unique = true, nullable = false)
	private String modelId;

//	/** hardwareVersion */
//	@JoinColumn(name = "MODEL_NAME", referencedColumnName = "MODEL_NAME")
//	@ManyToOne(fetch = FetchType.LAZY)
//	private HardwareVersion hardwareVersion;
	
	/** resolutionTypeName */ 
	@Column(name = "RESOLUTION_TYPE_NAME", length = 10)
	private String resolutionTypeName;

	/**
	 * Default Constructor
	 * 
	 */
	public ModelMaxStreamsAllowedPerQualityId() {

	}

	/**
	 * Constructor for the creation of ModelMaxStreamsAllowedPerQualityId.
	 * 
	 * @param modelId
	 * @param resolutionTypeName
	 */
	public ModelMaxStreamsAllowedPerQualityId(String modelId, String resolutionTypeName) {
		this.modelId = modelId;
		this.resolutionTypeName = resolutionTypeName;
	}

	

	/**
	 * Gets tvQuality
	 * 
	 * @return String
	 */
	public String getResolutionTypeName() {
		return resolutionTypeName;
	}

	/**
	 * Sets tvQuality
	 * 
	 * @param tvQuality
	 */
	public void setResolutionTypeName(String resolutionTypeName) {
		this.resolutionTypeName = resolutionTypeName;
	}

	/**
	 * Override hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) modelId.length();
		hash += (resolutionTypeName != null ? resolutionTypeName.hashCode() : 0);
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

		if (!(obj instanceof ModelMaxStreamsAllowedPerQualityId)) {
			return false;
		}

		final ModelMaxStreamsAllowedPerQualityId other = (ModelMaxStreamsAllowedPerQualityId) obj;

		if (modelId == null) {
			if (other.modelId != null) {
				return false;
			}
		} else if (!modelId.equals(other.modelId)) {
			return false;
		}

		if (resolutionTypeName == null) {
			if (other.resolutionTypeName != null) {
				return false;
			}
		} else if (!resolutionTypeName.equals(other.resolutionTypeName)) {
			return false;
		}

		return true;
	}
}
