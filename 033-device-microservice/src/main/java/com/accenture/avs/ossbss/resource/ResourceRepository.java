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
 * Interface for reading and managing resource files(Schema/Mapper).
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 *
 */
public interface ResourceRepository {
  
  /**
   * Find and read mapper resource.
   *
   * @param applicationName the application name
   * @param mapperPath the mapper path
   * @return the string
   */
  String findMapper(String applicationName, String mapperPath);
  
  /**
   * Find and read schema resource.
   *
   * @param applicationName the application name
   * @param schemaPath the schema path
   * @return the string
   */
  String findSchema(String applicationName, String schemaPath);
  
}
