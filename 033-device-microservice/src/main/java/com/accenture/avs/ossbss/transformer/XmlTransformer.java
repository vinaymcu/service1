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

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

/**
 * The Class XmlTransformer.
 *
 * @author Sumit.Sharma
 *
 */
public class XmlTransformer extends AbstractTransformer {
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.transformer.AbstractTransformer#toString(org.json.JSONArray,
   * java.lang.String)
   */
  @Override
  public String toString(final JSONArray object, final String rootElement) {
    return XML.toString(object, rootElement);
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.transformer.AbstractTransformer#toString(org.json.JSONObject,
   * java.lang.String)
   */
  @Override
  public String toString(final JSONObject object, final String rootElement) {
    return XML.toString(object, rootElement);
  }
  
}
