package com.accenture.avs.device.config;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import com.accenture.avs.ossbss.config.ConfigurationProvider;
import com.accenture.avs.ossbss.config.RequestMetadata;

/**
 * The Class ApplicationMetadata.
 */

@ConfigurationProperties("ossbss.client.default")
public class CRMConfigurationProvider implements ConfigurationProvider {

	/** The application name. */
	private String applicationName;

	/** The url. */
	private String url;

	/** The content type. */
	private String contentType;

	/** The repository type. */
	private String repositoryType;

	private boolean securityEnabled;

	/** The password. */
	private String securityPassword;

	/** The keystore path. */
	private String securityKeystorePath;

	/** The protocols. */
	private String[] securityProtocols;

	/** The ciphersuites. */
	private String[] securityCiphersuites;

	/** The requests. */
	@NestedConfigurationProperty
	private Map<String, RequestMetadataImpl> requests;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getRepositoryType() {
		return repositoryType;
	}

	public void setRepositoryType(String repositoryType) {
		this.repositoryType = repositoryType;
	}

	public Map<String, ? extends RequestMetadata> getRequests() {
		return requests;
	}

	public void setRequests(Map<String, RequestMetadataImpl> requests) {
		this.requests = requests;
	}

	public boolean isSecurityEnabled() {
		return securityEnabled;
	}

	public void setSecurityEnabled(boolean securityEnabled) {
		this.securityEnabled = securityEnabled;
	}

	public String getSecurityPassword() {
		return securityPassword;
	}

	public void setSecurityPassword(String securityPassword) {
		this.securityPassword = securityPassword;
	}

	public String getSecurityKeystorePath() {
		return securityKeystorePath;
	}

	public void setSecurityKeystorePath(String securityKeystorePath) {
		this.securityKeystorePath = securityKeystorePath;
	}

	public String[] getSecurityProtocols() {
		return Arrays.copyOf(securityProtocols, securityProtocols.length);
	}

	public void setSecurityProtocols(String[] securityProtocols) {
		this.securityProtocols = securityProtocols.clone();
	}

	public String[] getSecurityCiphersuites() {
		return Arrays.copyOf(securityCiphersuites, securityCiphersuites.length);
	}

	public void setSecurityCiphersuites(String[] securityCiphersuites) {
		this.securityCiphersuites = securityCiphersuites.clone();
	}

}
