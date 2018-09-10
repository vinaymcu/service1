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
package com.accenture.avs.ossbss.resource.reader;

import org.apache.commons.lang3.StringUtils;

import com.accenture.avs.commons.lib.LoggerWrapper;

/**
 * A factory for creating Reader objects.
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 */
public class ReaderFactory {
    
  /** Instance of LoggerWrapper for logging purpose */
  private static final LoggerWrapper LOGGER = new LoggerWrapper(ReaderFactory.class);
  
  /** The class path reader. */
  private Reader classPathReader;
  
  /** The file system reader. */
  private Reader fileSystemReader;
  
  /**
   * Constructor
   */
  public ReaderFactory() {
    
  }
  
  /**
   * create instance of {@link Reader} family based on path prefix (file: or classpath:).
   *
   * @param path the path
   * @return the reader
   */
  public Reader newInstance(final String path) {
    LOGGER.logMessage("Creating instance of Reader ");
    if (StringUtils.containsIgnoreCase(path, "file:")) {
      if (fileSystemReader == null) {
        LOGGER.logMessage("Creating instance of FileSystemReader ");
        fileSystemReader = new FileSystemReader();
      }
      return fileSystemReader;
      
    }
    if (classPathReader == null) {
      LOGGER.logMessage("Creating instance of ClassPathReader ");
      classPathReader = new ClassPathReader();
    }
    return classPathReader;
  }
  
}
