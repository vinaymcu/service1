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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.avs.commons.lib.LoggerWrapper;

/**
 * Class for reading and managing resource files(Schema/Mapper) in memory.
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 */

public class InMemoryResourceRepository extends AbstractResourceRepository {
  
  /** Instance of LoggerWrapper for logging purpose */
  private static final LoggerWrapper LOGGER = new LoggerWrapper(InMemoryResourceRepository.class);
  
  private final Map<String, String> RESOURCE_MAP = new ConcurrentHashMap<>();
  
  /**
   * constructor
   */
  public InMemoryResourceRepository() {
    
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.resource.ResourceRepository#findMapper(java.lang. String)
   */
  @Override
  public String findMapper(final String applicationName, final String mapperPath) {
    LOGGER.logMessage("Finding mapper for application [{}] at [{}]", applicationName, mapperPath);
    final String resourceName = applicationName + "." + mapperPath;
    if (!RESOURCE_MAP.containsKey(resourceName)) {
      LOGGER.logMessage("Mapper not found in memory, reading form [{}]", mapperPath);
      RESOURCE_MAP.put(resourceName, super.readResource(mapperPath));
    }
    return RESOURCE_MAP.get(resourceName);
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.resource.ResourceRepository#findSchema(java.lang. String)
   */
  @Override
  public String findSchema(final String applicationName, final String schemaPath) {	  
    LOGGER.logMessage("Finding schema for application [{}] at [{}]", applicationName, schemaPath);
    final String resourceName = applicationName + "." + schemaPath;
    if (!RESOURCE_MAP.containsKey(resourceName)) {
      LOGGER.logMessage("Schema not found in memory, reading form [{}]", schemaPath);
      RESOURCE_MAP.put(resourceName, super.readResource(schemaPath));
    }
    return RESOURCE_MAP.get(resourceName);
  }
  
}
