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

import com.accenture.avs.ossbss.helper.JsonHelper;
import com.accenture.avs.ossbss.resource.ResourceRepositoryFactory;
import com.accenture.avs.ossbss.resource.reader.ReaderFactory;
import com.accenture.avs.ossbss.transformer.TransformerFactory;
import com.accenture.avs.ossbss.validator.ValidatorFactory;

/**
 * The Class Configuration.
 *
 *
 */
public class Configuration {
  
  /** The instance. */
  private static Configuration instance;
  
  /**
   * Gets the single instance of Configuration.
   *
   * @return single instance of Configuration
   */
  public static Configuration getInstance() {
    if (instance == null) {
      synchronized (Configuration.class) {
        if (instance == null) {
          instance = new Configuration();
          instance.init();
        }
      }
    }
    return instance;
  }
  
  /** The reader factory. */
  private ReaderFactory readerFactory;
  
  /** The resource repository factory. */
  private ResourceRepositoryFactory resourceRepositoryFactory;
  
  /** The validator factory. */
  private ValidatorFactory validatorFactory;
  
  /** The transformer factory. */
  private TransformerFactory transformerFactory;
  
  /** The json helper. */
  private JsonHelper jsonHelper;
  
  /**
   * Instantiates a new configuration.
   */
  private Configuration() {
  }
  
  /**
   * Gets the json helper.
   *
   * @return the json helper
   */
  public JsonHelper getJsonHelper() {
    return jsonHelper;
  }
  
  /**
   * Gets the reader factory.
   *
   * @return the reader factory
   */
  public ReaderFactory getReaderFactory() {
    return readerFactory;
  }
  
  /**
   * Gets the resource repository factory.
   *
   * @return the resource repository factory
   */
  public ResourceRepositoryFactory getResourceRepositoryFactory() {
    return resourceRepositoryFactory;
  }
  
  /**
   * Gets the transformer factory.
   *
   * @return the transformer factory
   */
  public TransformerFactory getTransformerFactory() {
    return transformerFactory;
  }
  
  /**
   * Gets the validator factory.
   *
   * @return the validator factory
   */
  public ValidatorFactory getValidatorFactory() {
    return validatorFactory;
  }
  
  /**
   * Inits the.
   */
  private void init() {
    readerFactory = new ReaderFactory();
    resourceRepositoryFactory = new ResourceRepositoryFactory();
    validatorFactory = new ValidatorFactory();
    transformerFactory = new TransformerFactory();
    jsonHelper = new JsonHelper();
  }
  
}
