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

package com.accenture.avs.device.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.avs.device.config.ConfigurationManager;
import com.accenture.avs.device.config.SystemMessage;
import com.accenture.avs.device.config.SystemsParameter;

/**
 * The Configuration client class for interacting with ConfigurationManager to
 * read system message and parameters.
 * 
 * @author Singh.Saurabh
 */
@Component
public class ConfigurationClient {

	/** ConfigurationManager instance */
	@Autowired
	private ConfigurationManager manager;

	/**
	 * Method to find system message based on given language and code
	 * 
	 * @param language
	 * @param msgKey
	 * 
	 * @return SystemMessage
	 */
	public SystemMessage findSystemMessage(String language, String msgKey) {
		return manager.findSystemMessage(language, msgKey);
	}

	/**
	 * Method to find system parameter based on given param name.
	 * 
	 * @param paramName
	 * 
	 * @return SystemParameter
	 */
	public SystemsParameter findSystemsParameter(String paramName) {
		return manager.findSystemsParameter(paramName);
	}
}
