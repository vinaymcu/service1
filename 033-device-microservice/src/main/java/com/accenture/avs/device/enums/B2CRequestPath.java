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
package com.accenture.avs.device.enums;

/**
 * This is an ENUM class for B2C Request Paths.
 * 
 * @author Singh.Saurabh
 *
 */
public enum B2CRequestPath {

	/** SET_STB_PROPETIES */
	SET_STB_PROPETIES("/stb/properties"),
	/** GET_STB_PROPETIES */
	GET_STB_PROPETIES("/stb/properties/operation/listing"),
	/** SET_STB_SERVICE_PORT_MAPPINGS */
	SET_STB_SERVICE_PORT_MAPPINGS("/stb/portMappings");

	/** path */
	private String path;

	/**
	 * Instantiates a new B2CRequestPath type.
	 * 
	 * @param path
	 */
	B2CRequestPath(String path) {
		this.path = path;
	}

	/**
	 * Gets path
	 * 
	 * @return
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * This method returns B2CRequestPath type, if found
	 * 
	 * @param path
	 * @return
	 */
	public static B2CRequestPath fromString(String path) {
		if (path != null) {
			for (B2CRequestPath requestPath : B2CRequestPath.values()) {
				if (path.equalsIgnoreCase(requestPath.path)) {
					return requestPath;
				}
			}
		}
		return null;
	}
}
