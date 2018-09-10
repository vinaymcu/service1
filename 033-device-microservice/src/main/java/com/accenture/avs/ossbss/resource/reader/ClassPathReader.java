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

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.ossbss.exception.ErrorCode;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;

/**
 * ClassPath resource Reader.
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 */
public class ClassPathReader implements Reader {
  
  
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(ClassPathReader.class);
  
  /**
   * Read the resource file from classpath as string.
   *
   * @param path the resource path
   * @return the string
   *
   */
  @Override
  public String read(final String path) {
    LOGGER.logMessage(" Reading file [{}] ", path);
    final String finalPath = StringUtils.substringAfter(path, "classpath:");
    final InputStream is = ClassPathReader.class.getResourceAsStream(finalPath);
    if (is == null) {
      LOGGER.logMessage(" No such file found [{}] ", path);
      throw new OSSBSSClientException(ErrorCode.FILE_NOT_FOUND, finalPath);
    }
    try {
      return IOUtils.toString(is, "UTF-8");
    } catch (final IOException exception) {
      LOGGER.logError(exception, " Unable to reade file "+path);
      throw new OSSBSSClientException(exception, ErrorCode.UNABLE_TO_READ_FILE, finalPath);
    }
  }
  
}
