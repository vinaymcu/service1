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
package com.accenture.avs.ossbss.mapping;

import java.util.Collections;
import java.util.List;

/**
 * The Class Mapping.
 */
public class Mapping {
  
  /** The type. */
  private String type;
  
  /** The properties. */
  private List<PropertyMapping> properties;
  
  /**
   * Instantiates a new mapping.
   */
  public Mapping() {
    super();
  }
  
  /**
   * Gets the properties.
   *
   * @return the properties
   */
  public List<PropertyMapping> getProperties() {
    return Collections.unmodifiableList(properties);
  }
  
  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
  
  /**
   * Sets the properties.
   *
   * @param properties the new properties
   */
  public void setProperties(final List<PropertyMapping> properties) {
    this.properties = Collections.unmodifiableList(properties);
  }
  
  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }
  
}
