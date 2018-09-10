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

import com.accenture.avs.commons.lib.LoggerWrapper;

/**
 * Class for reading and managing resource files(Schema/Mapper) from file system.
 *
 * @author Sumit.Sharma
 * @version 1.0
 */

public class FileSystemResourceRepository extends AbstractResourceRepository {
  
  /** Instance of LoggerWrapper for logging purpose */
  private static final LoggerWrapper LOGGER = new LoggerWrapper(FileSystemResourceRepository.class);
  
  /**
   * constructor
   */
  public FileSystemResourceRepository() {
    
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.resource.ResourceRepository#findMapper(java.lang. String)
   */
  @Override
  public String findMapper(final String applicationName, final String mapperPath) {
    LOGGER.logMessage(" Finding mapper for application [{}] at [{}]", applicationName, mapperPath);
    return super.readResource(mapperPath);
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.resource.ResourceRepository#findSchema(java.lang. String)
   */
  @Override
  public String findSchema(final String applicationName, final String schemaPath) {
    LOGGER.logMessage(" Finding schema for application [{}] at [{}]", applicationName, schemaPath);
    return super.readResource(schemaPath);
  }
  
}
