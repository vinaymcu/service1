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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accenture.avs.device.config.entity.SystemMessageEntity;
import com.accenture.avs.device.config.entity.SystemsParameterEntity;

/**
 * ConfigurationRepository class used to interact with database for system
 * messages and system parameters
 * 
 * @author Singh.Saurabh
 */
@Repository
public class ConfigurationRepository {

	/** SYSTEMMESSAGE_FINDALL query string */
	private static final String SYSTEMMESSAGE_FINDALL = "SELECT * FROM sys_messages S";

	/** SYSTEMSPARAMETER_FINDALL query string */
	private static final String SYSTEMSPARAMETER_FINDALL = "SELECT * FROM sys_parameters S";

	/** JdbcTemplate instance */
	@Autowired
	private JdbcTemplate template;

	/**
	 * Method to find all system messages
	 * 
	 * @return List of System message entities
	 */
	public List<SystemMessageEntity> findAllSystemMessage() {
		return template.query(SYSTEMMESSAGE_FINDALL, new SystemMessageEntity());
	}

	/**
	 * Method to find all system parameters
	 * 
	 * @return List of system parameters
	 */
	public List<SystemsParameterEntity> findAllSystemsParameter() {
		return template.query(SYSTEMSPARAMETER_FINDALL, new SystemsParameterEntity());
	}

}
