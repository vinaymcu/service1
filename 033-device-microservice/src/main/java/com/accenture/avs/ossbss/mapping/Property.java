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

/**
 * The Class Property.
 */
public class Property {
  
  /** The name. */
  private String name;
  
  /** The type. */
  private String type;
  
  /** The path. */
  private String path;
  
  /**
   * Instantiates a new Property.
   */
  public Property() {
    super();
  }
  
  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Gets the path.
   *
   * @return the path
   */
  public String getPath() {
    return path;
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
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }
  
  /**
   * Sets the path.
   *
   * @param path the new path
   */
  public void setPath(final String path) {
    this.path = path;
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
