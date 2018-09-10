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

package com.accenture.avs.device.config.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Entity class for reading sys_messages table.
 * 
 * @author Singh.Saurabh
 */
public class SystemMessageEntity implements RowMapper<SystemMessageEntity> {

	/** messageKey */
	private String messageKey;

	/** language */
	private String language;

	/** messageCode */
	private String messageCode;

	/** messageText */
	private String messageText;

	/** type */
	private String type;

	/** restStatus */
	private String restStatus;

	/**
	 * Get message key
	 * 
	 * @return String the message key
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * Set message key
	 * 
	 * @param messageKey
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * Get language
	 * 
	 * @return String the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Set language
	 * 
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

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
	 * Set messaage text
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
	 * @return String the rest status
	 */
	public String getRestStatus() {
		return restStatus;
	}

	/**
	 * Set rest status
	 * 
	 * @param restStatus
	 */
	public void setRestStatus(String restStatus) {
		this.restStatus = restStatus;
	}

	/**
	 * Hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageCode == null) ? 0 : messageCode.hashCode());
		return result;
	}

	/**
	 * Equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		}

		SystemMessageEntity other = (SystemMessageEntity) obj;
		if (messageCode == null) {
			if (other.messageCode != null)
				return false;
		} else if (!messageCode.equals(other.messageCode))
			return false;
		return true;
	}

	/**
	 * Get SystemMessage entity from result set
	 * 
	 * @param resultset
	 * @param row
	 *            number
	 * 
	 * @return SystemMessageEntity
	 * 
	 * @throws SQLException
	 */
	@Override
	public SystemMessageEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		SystemMessageEntity entity = new SystemMessageEntity();
		entity.setMessageKey(rs.getString("message_key"));
		entity.setLanguage(rs.getString("language"));
		entity.setMessageCode(rs.getString("message_code"));
		entity.setMessageText(rs.getString("message_text"));
		entity.setType(rs.getString("type"));
		entity.setRestStatus(rs.getString("rest_status"));
		return entity;
	}

}
