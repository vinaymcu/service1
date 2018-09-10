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
package com.accenture.avs.ossbss.transformer;

/**
 * The Interface Transformer.
 */
public interface Transformer {
  
  /**
   * Transform.
   *
   * @param requestJson the request json
   * @param rootElement the root element
   * @param mapper the mapper
   * @return the string
   */
  public String transform(String requestJson, String rootElement, String mapper);
  
}
