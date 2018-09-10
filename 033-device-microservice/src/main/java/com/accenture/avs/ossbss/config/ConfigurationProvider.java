package com.accenture.avs.ossbss.config;

import java.util.Map;

/**
 * The Interface ConfigurationProvider.
 *
 * @author Sumit.Sharma
 * @version 1.0
 * @since 1.0
 */
public interface ConfigurationProvider {

	/**
	 * Gets the application name.
	 *
	 * @return the application name
	 */
	public String getApplicationName();

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl();

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType();

	/**
	 * Gets the repository type.
	 *
	 * @return the repository type
	 */
	public String getRepositoryType();

	/**
	 * Gets the requests.
	 *
	 * @return the requests
	 */
	public Map<String, ? extends RequestMetadata> getRequests();

	/**
	 * Checks if is security enabled.
	 *
	 * @return true, if is security enabled
	 */
	public boolean isSecurityEnabled();

	/**
	 * Gets the security password.
	 *
	 * @return the security password
	 */
	public String getSecurityPassword();

	/**
	 * Gets the security keystore path.
	 *
	 * @return the security keystore path
	 */
	public String getSecurityKeystorePath();

	/**
	 * Gets the security protocols.
	 *
	 * @return the security protocols
	 */
	public String[] getSecurityProtocols();

	/**
	 * Gets the security ciphersuites.
	 *
	 * @return the security ciphersuites
	 */
	public String[] getSecurityCiphersuites();

}
