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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.avs.device.client.ResourceManagerClient;
import com.accenture.avs.device.config.ConfigurationProperties;
import com.accenture.avs.device.json.object.resourcemanager.ConfigurationDataUpdate;
import com.accenture.avs.device.json.object.resourcemanager.GetProfileReq;
import com.accenture.avs.device.json.object.resourcemanager.STBProfile;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;

/**
 * This is the Client to communicate with the ResourceManager
 * 
 * @author Singh.Saurabh
 *
 */
@Component
public class ResourceManagerClientImpl implements ResourceManagerClient {

	/** restTemplate */
	@Autowired
	private RestTemplate restTemplate;

	/** config */
	@Autowired
	private ConfigurationProperties config;

	/**
	 * This method gets Device Profile
	 * 
	 * @param GetProfileReq
	 * @param subscriberId
	 * 
	 * @return
	 */
	@Override
	public ResponseEntity<STBProfile> getDeviceProfile(GetProfileReq GetProfileReq, String subscriberId) {
		String finalUrl = config.getResourcemanagerUrl() + "/" + subscriberId;
		return restTemplate.postForEntity(finalUrl, GetProfileReq, STBProfile.class, new Object[] {});
	}

	/**
	 * This method gets Resource Manager config data
	 * 
	 * @param configurationDataUpdate
	 * 
	 * @return
	 */
	@Override
	public ResponseEntity<GenericResponse> resourceManagerConfigData(ConfigurationDataUpdate configurationDataUpdate) {
		String finalUrl = config.getResourcemanagerUrl() + "/configurationData";
		return restTemplate.exchange(finalUrl, HttpMethod.PUT,
				new HttpEntity<ConfigurationDataUpdate>(configurationDataUpdate), GenericResponse.class,
				new Object[] {});
	}

}