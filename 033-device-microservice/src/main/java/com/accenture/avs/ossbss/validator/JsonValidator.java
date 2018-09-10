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

import java.io.IOException;

import com.accenture.avs.ossbss.exception.ErrorCode;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

/**
 * The Class JsonValidator.
 */
public class JsonValidator implements Validator {
  
  /** The factory. */
  private final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();;
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.validator.Validator#validate(java.lang.String, java.lang.String)
   */
  @Override
  public void validate(final String requestData, final String schema) throws OSSBSSClientException {
    try {
      final JsonNode schemaNode = JsonLoader.fromString(schema);
      final JsonNode dataNode = JsonLoader.fromString(requestData);
      final JsonSchema jsonSchema = factory.getJsonSchema(schemaNode);
      final ProcessingReport report = jsonSchema.validate(dataNode);
      if (!report.isSuccess()) {
        throw new OSSBSSClientException(ErrorCode.SCHEMA_VALDIATION_FAILED, report.toString());
      }
    } catch (final OSSBSSClientException e) {
      throw e;
    } catch (final IOException | ProcessingException e) {
      throw new OSSBSSClientException(e);
    }
  }
}
