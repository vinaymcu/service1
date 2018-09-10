/****************************************************************************
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
package com.accenture.avs.device.client.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.avs.device.client.GlobalConfigurationClient;
import com.accenture.avs.device.config.ConfigurationProperties;
import com.accenture.avs.device.json.object.devicemanager.HWVersion;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;

/**
 * This is the Client to communicate with the Global Configuration Service
 * 
 * @author Singh.Saurabh
 *
 */
@Component
public class GlobalConfigurationClientImpl implements GlobalConfigurationClient {

	/** restTemplate */
	@Autowired
	private RestTemplate restTemplate;

	/** config */
	@Autowired
	private ConfigurationProperties config;

	/**
	 * This method gets Device Global Data
	 * 
	 * @param requiredData
	 */
	@Override
	public ResponseEntity<UpdateGlobalData> getDeviceGlobalData(String requiredData) {
		String finalUrl = config.getGlobalconfigurationUrl() + "/stbManager/configurationData";
		Map<String, Object> uriVariables = new HashMap<>();
		if (StringUtils.isNotBlank(requiredData)) {
			uriVariables.put("requiredData", requiredData);
		}
		return restTemplate.getForEntity(finalUrl, UpdateGlobalData.class, uriVariables);
	}

	/**
	 * This method gets the HardwareVersion
	 * 
	 * @param hardwareName
	 */
	@Override
	public ResponseEntity<HWVersion> getHardwareVersion(String hardwareName) {
		String finalUrl = config.getGlobalconfigurationUrl() + "/stbHardwareDefinition/" + hardwareName;
		return restTemplate.getForEntity(finalUrl, HWVersion.class, new Object[] {});
	}
}
