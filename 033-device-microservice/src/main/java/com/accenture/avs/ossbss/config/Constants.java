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
package com.accenture.avs.ossbss.config;

/**
 * The Interface Constants.
 */
public interface Constants {
  
  /** The default namespace. */
  String DEFAULT_NAMESPACE = "ossbss.client.";
  
  /** The configuration file name. */
  String CONFIGURATION_FILE_NAME = "ossbss-client";
  
  /** The default configuration file path. */
  String DEFAULT_CONFIGURATION_FILE_PATH = "classpath:/ossbss-client.properties";
  
  /** The default application. */
  String DEFAULT_APPLICATION = "default";
  
  /** The register device request name. */
  String REGISTER_DEVICE_REQUEST_NAME = "register-device";
  
}
