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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.json.object.swupgradecount.GetSwUpgradeCountDTO;
import com.accenture.avs.device.json.object.swupgradecount.ResultObj;
import com.accenture.avs.device.service.SoftwareUpgradeCountService;
import com.accenture.avs.device.service.SoftwareUpgradeCountServiceHelper;

/**
 * The Interface SoftwareUpgradeCountServiceImpl.
 */
@Component
public class SoftwareUpgradeCountServiceImpl implements SoftwareUpgradeCountService {
	
	/** SoftwareUpgradeCountServiceHelper */
	@Autowired
	SoftwareUpgradeCountServiceHelper softwareUpgradeCountServiceHelper;

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(SoftwareUpgradeCountServiceImpl.class);
	
	/**
	 * This service method to get software upgrade count
	 * 
	 * @param swVersions
	 * @return GetSwUpgradeCountDTO
	 */
	public GetSwUpgradeCountDTO getSoftwareUpgradeCount(String swVersions) {
		long startTime = System.currentTimeMillis();
		LOGGER.logMessage("swVersions : "+swVersions);
		
		String[] softwareVersions = swVersions.split(",");
		GetSwUpgradeCountDTO getSwUpgradeCountDTO = new GetSwUpgradeCountDTO();
		List<ResultObj> resultObjList = getSwUpgradeCountDTO.getResultObj();
		
		for(String softwareVersion : softwareVersions) {
			Long softwareCount = softwareUpgradeCountServiceHelper.getSoftwareUpgradeCount(softwareVersion.trim());
			
			ResultObj resultObj = new ResultObj();
			resultObj.setSwVersion(softwareVersion.trim());
			resultObj.setUpgradeCount(softwareCount.intValue());
			
			resultObjList.add(resultObj);
		}
		getSwUpgradeCountDTO.setResultObj(resultObjList);
		getSwUpgradeCountDTO.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		getSwUpgradeCountDTO.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
		
		LOGGER.logMethodEnd(System.currentTimeMillis() - startTime);
		return getSwUpgradeCountDTO;
	}

}
