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

import com.accenture.avs.device.client.DocumentManagerClient;
import com.accenture.avs.device.config.ConfigurationProperties;
import com.accenture.avs.device.json.object.devicemanager.DocumentGeneratorRequest;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;

/**
 * This is the Client to communicate with the DocumentManager
 * 
 * @author Singh.Saurabh
 *
 */
@Component
public class DocumentManagerClientImpl implements DocumentManagerClient {

	/** restTemplate */
	@Autowired
	private RestTemplate restTemplate;

	/** config */
	@Autowired
	private ConfigurationProperties config;

	/**
	 * This method generate document for provided ids
	 * 
	 * @param ids
	 */
	public ResponseEntity<GenericResponse> generateDocument(String ids) {
		String finalUrl = config.getDocumentManagerUrl() + "/generateDocument/" + ids;
		return restTemplate.getForEntity(finalUrl, GenericResponse.class, new Object[] {});
	}

	/**
	 * This method generate document while Model operation is active for provided JSON schema
	 * 
	 * @param documentRequest
	 */
	@Override
	public ResponseEntity<GenericResponse> generateDocument(DocumentGeneratorRequest documentRequest) {
		String finalUrl = config.getDocumentManagerUrl();
		return restTemplate.postForEntity(finalUrl, documentRequest, GenericResponse.class);
	}

}