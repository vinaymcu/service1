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
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.accenture.avs.ossbss.exception.OSSBSSClientException;

/**
 * The Class XmlValidator.
 */
public class XmlValidator implements com.accenture.avs.ossbss.validator.Validator {
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.validator.Validator#validate(java.lang.String, java.lang.String)
   */
  @Override
  public void validate(final String requestData, final String schemaContenet)
      throws OSSBSSClientException {
    try {
      final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      final Schema schema = factory.newSchema(new StreamSource(new StringReader(schemaContenet)));
      final Validator validator = schema.newValidator();
      validator.validate(new StreamSource(new StringReader(requestData)));
    } catch (final IOException | SAXException exception) {
      throw new OSSBSSClientException(exception);
    }
    
  }
  
}
