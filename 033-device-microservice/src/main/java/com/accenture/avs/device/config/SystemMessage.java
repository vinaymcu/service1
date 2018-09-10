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

package com.accenture.avs.device.config;

/**
 * Model class for holding System Message.
 * 
 * @author Singh.Saurabh
 *
 */
public class SystemMessage {

	/** messageCode */
	private String messageCode;

	/** messageText */
	private String messageText;

	/** type */
	private String type;

	/** restStatus */
	private Integer restStatus;

	/**
	 * Get message code
	 * 
	 * @return String the message code
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * Set message code
	 * 
	 * @param messageCode
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * Get message text
	 * 
	 * @return String the message text
	 */
	public String getMessageText() {
		return messageText;
	}

	/**
	 * Set message text
	 * 
	 * @param messageText
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	/**
	 * Get type
	 * 
	 * @return String the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get rest status
	 * 
	 * @return Integer the rest status
	 */
	public Integer getRestStatus() {
		return restStatus;
	}

	/**
	 * Set rest status
	 * 
	 * @param restStatus
	 */
	public void setRestStatus(Integer restStatus) {
		this.restStatus = restStatus;
	}

}