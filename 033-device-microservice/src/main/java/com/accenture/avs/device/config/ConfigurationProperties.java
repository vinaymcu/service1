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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author surendra.kumar
 *
 */
@Component
public class ConfigurationProperties {

	@Value("${spring.datasorce.write.jndi-name}")
	private String readJndiName;

	@Value("${spring.datasorce.write.jndi-name}")
	private String writeJndiName;

	/** device.token.manager.algorithm */
	@Value("${device.token.manager.algorithm:AES}")
	private String algorithm;

	/** device.token.manager.algorithm-eas */
	@Value("${device.token.manager.algorithm-eas:AES/ECB/PKCS5Padding}")
	private String algorithmEas;

	/** device.token.manager.secretKey */
	@Value("${device.token.manager.secretKey}")
	private String payloadSecretKey;

	/** device.token.manager.signatureKey */
	@Value("${device.token.manager.signatureKey}")
	private String signatureKey;

	@Value("${pushmessage.url}")
	private String pushMessageUrl;

	@Value("${subscriber.url}")
	private String subscriberUrl;

	@Value("${resourcemanager.url}")
	private String resourcemanagerUrl;

	@Value("${globalconfiguration.url}")
	private String globalconfigurationUrl;

	@Value("${documentManager.url}")
	private String documentManagerUrl;
	
	/** The avsbe configuration jndi. */
	@Value("${avsbe.datasource.configuration.jndi-name}")
	private String avsbeConfigurationJndi;

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getAlgorithmEas() {
		return algorithmEas;
	}

	public void setAlgorithmEas(String algorithmEas) {
		this.algorithmEas = algorithmEas;
	}

	public String getPayloadSecretKey() {
		return payloadSecretKey;
	}

	public void setPayloadSecretKey(String payloadSecretKey) {
		this.payloadSecretKey = payloadSecretKey;
	}

	public String getSignatureKey() {
		return signatureKey;
	}

	public void setSignatureKey(String signatureKey) {
		this.signatureKey = signatureKey;
	}

	public String getReadJndiName() {
		return readJndiName;
	}

	public void setReadJndiName(String readJndiName) {
		this.readJndiName = readJndiName;
	}

	public String getWriteJndiName() {
		return writeJndiName;
	}

	public void setWriteJndiName(String writeJndiName) {
		this.writeJndiName = writeJndiName;
	}

	public String getPushMessageUrl() {
		return pushMessageUrl;
	}

	public void setPushMessageUrl(String pushMessageUrl) {
		this.pushMessageUrl = pushMessageUrl;
	}

	public String getSubscriberUrl() {
		return subscriberUrl;
	}

	public void setSubscriberUrl(String subscriberUrl) {
		this.subscriberUrl = subscriberUrl;
	}

	public String getResourcemanagerUrl() {
		return resourcemanagerUrl;
	}

	public void setResourcemanagerUrl(String resourcemanagerUrl) {
		this.resourcemanagerUrl = resourcemanagerUrl;
	}

	public String getGlobalconfigurationUrl() {
		return globalconfigurationUrl;
	}

	public void setGlobalconfigurationUrl(String globalconfigurationUrl) {
		this.globalconfigurationUrl = globalconfigurationUrl;
	}

	public String getDocumentManagerUrl() {
		return documentManagerUrl;
	}

	public void setDocumentManagerUrl(String documentManagerUrl) {
		this.documentManagerUrl = documentManagerUrl;
	}

	/**
	 * Gets the avsbe configuration jndi.
	 *
	 * @return the avsbe configuration jndi
	 */
	public String getAvsbeConfigurationJndi() {
		return avsbeConfigurationJndi;
	}
}
