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

/**
 * The Class JsonTransformer.
 *
 * @author <a href="Sumit.Sharma@rsystems.com">Sumit.Sharma</a>
 * @version Sep 16, 2016
 */
public class JsonTransformer extends AbstractTransformer {
  
  /**
   * constructor
   */
  public JsonTransformer() {
    
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.transformer.AbstractTransformer#toString(org.json. JSONArray,
   * java.lang.String)
   */
  @Override
  public String toString(final JSONArray object, final String rootElement) {
    return object.toString();
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.accenture.avs.ossbss.transformer.AbstractTransformer#toString(org.json. JSONObject,
   * java.lang.String)
   */
  @Override
  public String toString(final JSONObject object, final String rootElement) {
    return object.toString();
  }
  
}
