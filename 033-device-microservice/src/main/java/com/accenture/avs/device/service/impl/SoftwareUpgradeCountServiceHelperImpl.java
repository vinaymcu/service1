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

package com.accenture.avs.device.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.repository.SoftwareUpgradeCountCustomRepository;
import com.accenture.avs.device.service.SoftwareUpgradeCountServiceHelper;

/**
 * The implementation class for {@link SoftwareUpgradeCountServiceHelper }.
 * 
 */
@Component
@Transactional
public class SoftwareUpgradeCountServiceHelperImpl implements SoftwareUpgradeCountServiceHelper {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(SoftwareUpgradeCountServiceHelperImpl.class);

	/** SoftwareUpgradeCountCustomRepository */
	@Autowired
	SoftwareUpgradeCountCustomRepository softwareUpgradeCountCustomRepository;

	/**
	 * This method get software upgrade count
	 * 
	 * @param swVersion
	 * @return Long
	 */
	@Override
	public Long getSoftwareUpgradeCount(String swVersion) {
		long startTime = System.currentTimeMillis();
		
		Map<String,Object> queryParams = new HashMap<>();
		queryParams.put("softwareVersion", swVersion);
		
		String query = SoftwareUpgradeCountCustomRepository.GET_SOFTWARE_UPGRADE_COUNT;
		Long softwareUpgradeCount = 0L;
		try {
			softwareUpgradeCount = softwareUpgradeCountCustomRepository.getSoftwareUpgradeCount(swVersion);
		}
		finally {
			LOGGER.logMessage("Software Upgrade Count for sw version "+swVersion+" is "+softwareUpgradeCount);
			LOGGER.logDBQuery(query, queryParams, System.currentTimeMillis() - startTime);
		}
		return softwareUpgradeCount;
	}

}
