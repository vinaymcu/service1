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
 * The Class PropertyMapping.
 */
public class PropertyMapping {
  
  /** The origin. */
  private Property origin;
  
  /** The destination. */
  private Property destination;
  
  /** The mapping. */
  private Mapping mapping;
  
  /**
   * Instantiates a new PropertyMapping.
   */
  public PropertyMapping() {
    super();
  }
  
  /**
   * Gets the destination.
   *
   * @return the destination
   */
  public Property getDestination() {
    return destination;
  }
  
  /**
   * Gets the mapping.
   *
   * @return the mapping
   */
  public Mapping getMapping() {
    return mapping;
  }
  
  /**
   * Gets the origin.
   *
   * @return the origin
   */
  public Property getOrigin() {
    return origin;
  }
  
  /**
   * Sets the destination.
   *
   * @param destination the new destination
   */
  public void setDestination(final Property destination) {
    this.destination = destination;
  }
  
  /**
   * Sets the mapping.
   *
   * @param mapping the new mapping
   */
  public void setMapping(final Mapping mapping) {
    this.mapping = mapping;
  }
  
  /**
   * Sets the origin.
   *
   * @param origin the new origin
   */
  public void setOrigin(final Property origin) {
    this.origin = origin;
  }
  
}
