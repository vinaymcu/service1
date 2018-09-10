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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.accenture.avs.device.client.PushMessageClient;
import com.accenture.avs.device.config.ConfigurationProperties;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdateRequest;

/**
 * This is the Client to communicate with the Push Message Service
 * 
 * @author Singh.Saurabh
 *
 */
@Component
public class PushMessageClientImpl implements PushMessageClient {

	/** restTemplate */
	@Autowired
	private RestTemplate restTemplate;

	/** config */
	@Autowired
	private ConfigurationProperties config;

	/**
	 * This method sends trigger to unicast notifier
	 * 
	 * @param eventUpdateRequest
	 * @return
	 */
	@Override
	public ResponseEntity<GenericResponse> trigger(EventUpdateRequest eventUpdateRequest) {
		String finalUrl = config.getPushMessageUrl();
		return restTemplate.postForEntity(finalUrl, eventUpdateRequest, GenericResponse.class, new Object[] {});
	}

}