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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class for MODEL_MAX_STREAMS_ALLOWED_PER_QUALITY  table
 * 
 * @author rajesh.kumar
 *
 */
@Entity 
@Table(name = "MODEL_MAX_STREAMS_ALLOWED_PER_QUALITY")
public class ModelMaxStreamsAllowedPerQuality implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

    /** id */
	@EmbeddedId
	private ModelMaxStreamsAllowedPerQualityId id;

	/** maxStreams */ 
	@Column(name = "MAX_STREAMS", precision = 10, scale = 0)
	private Long maxStreams;
	
	/**
	 * Default constructor
	 */
	public ModelMaxStreamsAllowedPerQuality() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 */
	public ModelMaxStreamsAllowedPerQuality(ModelMaxStreamsAllowedPerQualityId id) {
		this.id = id;
	}

	/**
	 * Gets id
	 * 
	 * @return ModelMaxStreamsAllowedPerQuality
	 */
	public ModelMaxStreamsAllowedPerQualityId getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id
	 */
	public void setId(ModelMaxStreamsAllowedPerQualityId id) {
		this.id = id;
	}

	/**
	 * @return the maxStreams
	 */
	public Long getMaxStreams() {
		return maxStreams;
	}

	/**
	 * @param maxStreams the maxStreams to set
	 */
	public void setMaxStreams(Long maxStreams) {
		this.maxStreams = maxStreams;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ModelMaxStreamsAllowedPerQuality)) {
			return false;
		}
		ModelMaxStreamsAllowedPerQuality other = (ModelMaxStreamsAllowedPerQuality) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
}
