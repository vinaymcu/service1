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
package com.accenture.avs.ossbss.validator;

import org.apache.commons.lang3.StringUtils;

/**
 * Factory class for creating the {@link Validator} object base on content type (xml or json)
 *
 *
 * @author <a href="Sumit.Sharma@rsystems.com">Sumit.Sharma</a>
 * @version Sep 16, 2016
 */
public class ValidatorFactory {
  
  private Validator jsonValidator;
  
  private Validator xmlValidator;
  
  public ValidatorFactory() {
    super();
  }
  
  /**
   * New instance.
   *
   * @param type the type
   * @return the Validator
   */
  public Validator newInstance(final String type) {
    if (StringUtils.containsIgnoreCase(type, "json")) {
      if (jsonValidator == null) {
        jsonValidator = new JsonValidator();
      }
      return jsonValidator;
      
    }
    if (xmlValidator == null) {
      xmlValidator = new XmlValidator();
    }
    return xmlValidator;
  }
  
}
