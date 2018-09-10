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
 * Entity class for LANGUAGES table.
 * 
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "LANGUAGES")
public class Language implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** type */
	@Id
	@Column(name = "LANGUAGE_TYPE", nullable = false, length = 10)
	private String type;
	
	/** name */
	@Column(name = "DISPLAY_NAME", nullable = false, length = 30)
	private String name;
	
	/** availableForui */
	@Column(name = "AVAILABLE_FOR_UI", columnDefinition="TINYINT", length = 1)
	private Boolean availableForui;
	
	/** availableForAudio */
	@Column(name = "AVAILABLE_FOR_AUDIO", columnDefinition="TINYINT", length = 1)
	private Boolean availableForAudio;

	/**
	 * Gets type.
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets type.
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * Gets available for uri flag.
	 * 
	 * @return Boolean
	 */
	public Boolean getAvailableForui() {
		return availableForui;
	}

	/**
	 * Sets available for uri flag.
	 * 
	 * @param availableForui
	 */
	public void setAvailableForui(Boolean availableForui) {
		this.availableForui = availableForui;
	}

	/**
	 * Gets available for audio flag.
	 * 
	 * @return Boolean
	 */
	public Boolean getAvailableForAudio() {
		return availableForAudio;
	}

	/**
	 * Sets available for audio flag.
	 * 
	 * @param availableForAudio
	 */
	public void setAvailableForAudio(Boolean availableForAudio) {
		this.availableForAudio = availableForAudio;
	}

}
