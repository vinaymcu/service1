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

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.ossbss.exception.ErrorCode;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;

/**
 * File system resource Reader.
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 */
public class FileSystemReader implements Reader {
  
  /** Instance of LoggerWrapper for logging purpose */
  private static final LoggerWrapper LOGGER = new LoggerWrapper(FileSystemReader.class);
  
  /**
   * Read the resource file from file system as string.
   *
   * @param path the resource path
   * @return the string
   *
   */
  @Override
  public String read(final String path) {
    LOGGER.logMessage("Reading file [{}] ", path);
    final String finalPath = StringUtils.substringAfter(path, "file:");
    final File file = new File(finalPath);
    if (!file.exists()) {
      LOGGER.logMessage("No such file found "+path);
      throw new OSSBSSClientException(ErrorCode.FILE_NOT_FOUND, finalPath);
    }
    try {
      return IOUtils.toString(file.toURI(), "UTF-8");
    } catch (final IOException exception) {
      LOGGER.logError(exception, "Unable to reade file "+path);
      throw new OSSBSSClientException(exception, ErrorCode.UNABLE_TO_READ_FILE, finalPath);
    }
  }
  
}
