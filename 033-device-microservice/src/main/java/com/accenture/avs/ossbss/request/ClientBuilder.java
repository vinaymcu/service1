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

package com.accenture.avs.ossbss.request;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.accenture.avs.ossbss.config.Configuration;
import com.accenture.avs.ossbss.config.ConfigurationProvider;
import com.accenture.avs.ossbss.config.RequestMetadata;
import com.accenture.avs.ossbss.exception.ErrorCode;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;

/**
 * The Class ClientBuilder.
 *
 */
public class ClientBuilder {

	/**
	 * Creates the.
	 *
	 * @return the client builder
	 */
	public static ClientBuilder create(ConfigurationProvider configurationProvider, String requestName) {
		ClientBuilder clientBuilder = new ClientBuilder();
		clientBuilder.configurationProvider = configurationProvider;
		clientBuilder.requestName = requestName;
		return clientBuilder;
	}

	/** The application name. */
	private ConfigurationProvider configurationProvider;

	/** The request name. */
	private String requestName;

	/**
	 * Instantiates a new client builder.
	 */
	private ClientBuilder() {
	}

	/**
	 * Builds the.
	 *
	 * @return the client
	 */
	public Client build() {
		validateConfigurationProvider(configurationProvider);
		final Configuration configuration = Configuration.getInstance();
		return new Client(configuration, configurationProvider, configurationProvider.getRequests().get(requestName));
	}

	/**
	 * Sets the request name.
	 *
	 * @param requestName
	 *            the request name
	 * @return the client builder
	 */
	public ClientBuilder setRequestName(final String requestName) {
		this.requestName = requestName;
		return this;
	}

	private void validateConfigurationProvider(ConfigurationProvider configurationProvider) {
		if (configurationProvider == null) {
			throw new OSSBSSClientException(ErrorCode.CONFIGURATION_PROVIDER_NULL);
		}
		if (StringUtils.isBlank(requestName)) {
			throw new OSSBSSClientException(ErrorCode.REQUEST_NAME_NULL);
		}

		if (configurationProvider.getRequests() == null
				|| configurationProvider.getRequests().get(requestName) == null) {
			throw new OSSBSSClientException(ErrorCode.NO_SUCH_REQUEST_FOUND, requestName);
		}
		StringBuilder missingProperties = new StringBuilder();

		if (configurationProvider.isSecurityEnabled()) {
			if (StringUtils.isEmpty(configurationProvider.getSecurityKeystorePath())) {
				missingProperties.append("\n ossbss.client.<application-name>.security.keystore-path ");
			}
			if (StringUtils.isEmpty(configurationProvider.getSecurityPassword())) {
				missingProperties.append("\n ossbss.client.<application-name>.security.password ");
			}
			if (ArrayUtils.isNotEmpty(configurationProvider.getSecurityProtocols())
					&& ArrayUtils.isEmpty(configurationProvider.getSecurityCiphersuites())) {
				missingProperties.append("\n ossbss.client.<application-name>.security.ciphersuites ");
			}
			if (ArrayUtils.isNotEmpty(configurationProvider.getSecurityCiphersuites())
					&& ArrayUtils.isEmpty(configurationProvider.getSecurityProtocols())) {
				missingProperties.append("\n ossbss.client.<application-name>.security.protocols ");
			}
		}

		final RequestMetadata requestMetadata = configurationProvider.getRequests().get(requestName);
		if (StringUtils.isEmpty(requestMetadata.getPath())) {
			missingProperties.append("\n ossbss.client.<application-name>.<request-name>.path ");
		}
		if (StringUtils.isEmpty(requestMetadata.getMethod())) {
			missingProperties.append("\n ossbss.client.<application-name>.<request-name>.method ");
		}
		if (StringUtils.isEmpty(requestMetadata.getContentType())) {
			missingProperties.append("\n ossbss.client.<application-name>.<request-name>.content-type ");
		}
		if (StringUtils.containsIgnoreCase(requestMetadata.getContentType(), "xml")
				&& StringUtils.isEmpty(requestMetadata.getRootElement())) {
			missingProperties.append("\n ossbss.client.<application-name>.<request-name>.root-element ");
		}
		if (StringUtils.isEmpty(requestMetadata.getSchemaPath())) {
			missingProperties.append("\n ossbss.client.<application-name>.<request-name>.schema-path ");
		}
		if (StringUtils.isEmpty(requestMetadata.getMapperPath())) {
			missingProperties.append("\n ossbss.client.<application-name>.<request-name>.mapper-path ");
		}
		if (missingProperties.length() > 0) {
			missingProperties.append("\n");
			throw new OSSBSSClientException(ErrorCode.CONFIGURATION_PROPERTY_MISSING, missingProperties.toString());
		}
	}

}
