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
package com.accenture.avs.device.repository.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.accenture.avs.device.util.SearchCriteriaMapper;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.DeviceManagerException;

/**
 * The Class DeviceSearchCriteriaMapperImpl.
 */
@Component
public class DeviceSearchCriteriaMapperImpl implements SearchCriteriaMapper {

	/** The map. */
	private Map<String, String> searchByMap;

	private Map<String, String> sortMap ;

	/**
	 * The Init method.
	 */
	@PostConstruct
	public void init() {
		searchByMap = new HashMap<String, String>();
		searchByMap.put("userName", "assignedToUserName");
		searchByMap.put("serialNumber", "serialNumber");
		searchByMap.put("drmId", "drmId");
		searchByMap.put("ipAddress", "externalIpAddress");
		searchByMap.put("deviceId", "deviceId");
		searchByMap.put("softwareVersion", "softwareVersion");
		searchByMap.put("uiVersion", "uiVersion");
		searchByMap.put("model", "model.modelName");
		searchByMap.put("assignedStatus", "assignmentStatus");
		
		sortMap = new HashMap<String, String>();
		sortMap.put("deviceId", "deviceId");
		sortMap.put("serialNumber", "serialNumber");
		sortMap.put("ipAddress", "externalIpAddress");
		sortMap.put("assignmentStatus", "assignmentStatus");
		
	}

	/*
	 * com.accenture.avs.common.model.SearchCriteriaMapper#mapProperty(java.lang.
	 * String)
	 */
	@Override
	public String searchByMapProperty(String criteria) {
		String property = StringUtils.isEmpty(criteria) ? "userName" : criteria;
		property = searchByMap.get(property);
		if (StringUtils.isEmpty(property)) {
			throw new DeviceManagerException(ErrorCode.INVALID_PARAM);
		}
		return property;
	}

	/**
	 * 
	 * @param criteria
	 * @return
	 */
	@Override
	public String sortMapProperty(String criteria) {
		String property = StringUtils.isEmpty(criteria) ? "deviceId" : criteria;		
		property = sortMap.get(property);		
		if (StringUtils.isEmpty(property)) {			
			throw new DeviceManagerException(ErrorCode.INVALID_PARAM);
		}
		return property;

	}
}
