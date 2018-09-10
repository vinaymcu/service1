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
package com.accenture.avs.ossbss.resource;

import com.accenture.avs.ossbss.resource.reader.Reader;
import com.accenture.avs.ossbss.resource.reader.ReaderFactory;

/**
 * The Class AbstractResourceRepository.
 *
 * @author Sumit.Sharma
 * @version 1.0
 * @since 1.0
 *
 */

public abstract class AbstractResourceRepository implements ResourceRepository {
  
  /** The factory. */
  private final ReaderFactory factory;
  
  /**
   * Instantiates a new abstract resource repository.
   */
  public AbstractResourceRepository() {
    super();
    factory = new ReaderFactory();
  }
  
  /**
   * Read resource.
   *
   * @param path the path
   * @return the string
   */
  public String readResource(final String path) {
    final Reader reader = factory.newInstance(path);
    return reader.read(path);
  }
  
}
