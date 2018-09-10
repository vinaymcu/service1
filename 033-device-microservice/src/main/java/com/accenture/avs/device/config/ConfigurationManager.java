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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.accenture.avs.device.config.entity.SystemMessageEntity;
import com.accenture.avs.device.config.entity.SystemsParameterEntity;

/**
 * The manager class for fetching and caching the system messages and system
 * parameters.
 * 
 * @author Singh.Saurabh
 */
@Component
public class ConfigurationManager {

	/** ConfigurationRepository instance */
	@Autowired
	private ConfigurationRepository repository;

	/** systemMessages collection of SystemMessageEntity */
	private List<SystemMessageEntity> systemMessages = new ArrayList<>();

	/** systemParams collection of SystemsParameterEntity */
	private List<SystemsParameterEntity> systemParams = new ArrayList<>();

	/**
	 * Find systems parameters by parameter name
	 * 
	 * @param paramName
	 * 
	 * @return SystemsParameter
	 * 
	 * @throws IllegalArgumentException
	 *             if system parameter not found by given name
	 */
	public SystemsParameter findSystemsParameter(String paramName) {
		for (SystemsParameterEntity systemParam : systemParams) {
			if (systemParam.getParamName().equals(paramName)) {
				SystemsParameter systemsParameter = new SystemsParameter();
				systemsParameter.setParamName(systemParam.getParamName());
				systemsParameter.setParamType(systemParam.getParamType());
				systemsParameter.setParamValue(systemParam.getParamValue());
				return systemsParameter;
			}
		}
		throw new IllegalArgumentException("SystemsParameter not found for paramName " + paramName);
	}

	/**
	 * Find system message by language and code
	 * 
	 * @param language
	 * @param code
	 * 
	 * @return SystemMessage
	 * 
	 * @throws IllegalArgumentException
	 *             if system message not found by given language and code
	 */
	public SystemMessage findSystemMessage(String language, String msgKey) {
		for (SystemMessageEntity systemMessageEntity : systemMessages) {
			if (systemMessageEntity.getLanguage().equals(language)
					&& systemMessageEntity.getMessageKey().equals(msgKey)) {
				SystemMessage systemMessage = new SystemMessage();
				systemMessage.setMessageCode(systemMessageEntity.getMessageCode());
				systemMessage.setMessageText(systemMessageEntity.getMessageText());
				systemMessage.setRestStatus(Integer.parseInt(systemMessageEntity.getRestStatus()));
				systemMessage.setType(systemMessageEntity.getType());
				return systemMessage;
			}
		}
		throw new IllegalArgumentException("SystemMessage not found for code " + msgKey + " and language " + language);
	}

	/**
	 * Refresh system messages
	 * 
	 */
	private void refreshSystemMessage() {
		systemMessages = repository.findAllSystemMessage();
	}

	/**
	 * Refresh systems parameters at configured interval.
	 */
	@Scheduled(fixedDelayString = "${system.params.refresh.interval:300000}")
	private void refreshSystemsParameter() {
		systemParams = repository.findAllSystemsParameter();
	}

	/**
	 * Initializing the System message and System parameters once application
	 * start-up is finished.
	 * 
	 */
	@PostConstruct
	public void init() {
		refreshSystemMessage();
		refreshSystemsParameter();
	}

}
