package com.accenture.avs.device.config;

import java.util.Map;

import com.accenture.avs.ossbss.config.RequestMetadata;


/**
 * The Class RequestMetadata.
 */
public class RequestMetadataImpl implements RequestMetadata {

	/** The path. */
	private String path;

	/** The method. */
	private String method;

	/** The headers. */
	private Map<String, String> headers;

	/** The schema path. */
	private String schemaPath;

	/** The mapper path. */
	private String mapperPath;

	/** The content type. */
	private String contentType;

	/** The root element. */
	private String rootElement;

	/**
	 * Instantiates a new request metadata.
	 */
	public RequestMetadataImpl() {
		super();
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * Gets the mapper path.
	 *
	 * @return the mapper path
	 */
	public String getMapperPath() {
		return mapperPath;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the root element.
	 *
	 * @return the root element
	 */
	public String getRootElement() {
		return rootElement;
	}

	/**
	 * Gets the schema path.
	 *
	 * @return the schema path
	 */
	public String getSchemaPath() {
		return schemaPath;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType
	 *            the new content type
	 */
	public void setContentType(final String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Sets the headers.
	 *
	 * @param headers
	 *            the headers
	 */
	public void setHeaders(final Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 * Sets the mapper path.
	 *
	 * @param mapperPath
	 *            the new mapper path
	 */
	public void setMapperPath(final String mapperPath) {
		this.mapperPath = mapperPath;
	}

	/**
	 * Sets the method.
	 *
	 * @param method
	 *            the new method
	 */
	public void setMethod(final String method) {
		this.method = method;
	}

	/**
	 * Sets the path.
	 *
	 * @param path
	 *            the new path
	 */
	public void setPath(final String path) {
		this.path = path;
	}

	/**
	 * Sets the root element.
	 *
	 * @param rootElement
	 *            the new root element
	 */
	public void setRootElement(final String rootElement) {
		this.rootElement = rootElement;
	}

	/**
	 * Sets the schema path.
	 *
	 * @param schemaPath
	 *            the new schema path
	 */
	public void setSchemaPath(final String schemaPath) {
		this.schemaPath = schemaPath;
	}

}
