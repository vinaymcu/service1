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

import com.accenture.avs.ossbss.exception.OSSBSSClientException;

/**
 * The validator interface for validating request data with schema .
 */
public interface Validator {
  
  /**
   * Validate the request data with schema.
   *
   * @param requestData the request data
   * @param schema the schema
   * @throws OSSBSSClientException the OSSBSS client exception
   */
  void validate(String requestData, String schema) throws OSSBSSClientException;
  
}
