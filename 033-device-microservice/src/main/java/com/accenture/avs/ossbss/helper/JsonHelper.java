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
package com.accenture.avs.ossbss.helper;

import java.io.IOException;
import java.io.InputStream;

import com.accenture.avs.ossbss.exception.ErrorCode;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class JsonHelper.
 */
public class JsonHelper {
  
  /** The mapper. */
  private final ObjectMapper mapper = new ObjectMapper();
  
  /**
   * From json string.
   *
   * @param <T> the generic type
   * @param is the is
   * @param resultType the result type
   * @return the t
   */
  public <T> T fromJsonString(final InputStream is, final Class<T> resultType) {
    try {
      return mapper.readValue(is, resultType);
    } catch (final IOException e) {
      throw new OSSBSSClientException(ErrorCode.JSON_PROCESSING_EXCEPTION, e);
    }
    
  }
  
  /**
   * From json string.
   *
   * @param <T> the generic type
   * @param jsonString the json string
   * @param resultType the result type
   * @return the t
   */
  public <T> T fromJsonString(final String jsonString, final Class<T> resultType) {
    try {
      return mapper.readValue(jsonString, resultType);
    } catch (final IOException e) {
      throw new OSSBSSClientException(ErrorCode.JSON_PROCESSING_EXCEPTION, e);
    }
    
  }
  
  /**
   * To json string.
   *
   * @param object the object
   * @return the string
   */
  public String toJsonString(final Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (final JsonProcessingException e) {
      throw new OSSBSSClientException(ErrorCode.JSON_PROCESSING_EXCEPTION, e);
    }
    
  }
  
}
