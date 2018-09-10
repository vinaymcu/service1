package com.accenture.avs.ossbss.config;

import java.util.Map;

/**
 * The Class RequestMetadata.
 *
 * @author Sumit.Sharma
 * @version 1.0
 * @since 1.0
 *
 */
public interface RequestMetadata {

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType();

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public Map<String, String> getHeaders();

	/**
	 * Gets the mapper path.
	 *
	 * @return the mapper path
	 */
	public String getMapperPath();

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod();

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath();

	/**
	 * Gets the root element.
	 *
	 * @return the root element
	 */
	public String getRootElement();

	/**
	 * Gets the schema path.
	 *
	 * @return the schema path
	 */
	public String getSchemaPath();
}