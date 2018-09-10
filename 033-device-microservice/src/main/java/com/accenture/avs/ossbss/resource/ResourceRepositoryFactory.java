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
package com.accenture.avs.ossbss.resource;

/**
 * A factory for creating ResourceRepository objects.
 */
public class ResourceRepositoryFactory {

	/**
	 * constructor
	 */
	public ResourceRepositoryFactory() {
		super();
	}

	/**
	 * create instance of {@link ResourceRepository} family based on type.<br/>
	 *
	 * Supported types are file-system and in-memory
	 *
	 * <ul>
	 * <li>{@link InMemoryResourceRepository} Read the file from target source
	 * at fist call and keep it into in-memory for later use.</li>
	 * <li>{@link FileSystemResourceRepository} Read the file from target source
	 * for every call</li>
	 * </ul>
	 *
	 * @param type
	 *            the type
	 * @return the resource repository
	 */
	public ResourceRepository newInstance(final String type) {
		if ("in-memory".equalsIgnoreCase(type)) {
			return new InMemoryResourceRepository();
		} else {
			return new FileSystemResourceRepository();
		}
	}
}
