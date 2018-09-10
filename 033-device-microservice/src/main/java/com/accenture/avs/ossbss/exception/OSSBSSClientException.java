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
package com.accenture.avs.ossbss.exception;

/**
 * The Class OSSBSSClientException.
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 */
public class OSSBSSClientException extends RuntimeException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Prepare message.
   *
   * @param errorCode the error code
   * @param args the args
   * @return the string
   */
  private static String prepareMessage(final ErrorCode errorCode, final String... args) {
    final StringBuilder messageBuilder = new StringBuilder();
    messageBuilder.append(" [ ");
    messageBuilder.append(errorCode.getErrorCode());
    messageBuilder.append(" ] ");

    messageBuilder.append(" - [ ");
    if (args != null) {
      messageBuilder.append(String.format(errorCode.getErrorMessage(), (Object[]) args));
    } else {
      messageBuilder.append(errorCode.getErrorMessage());
    }
    messageBuilder.append(" ] ");

    return messageBuilder.toString();
  }

  /**
   * Instantiates a new OSSBSS client exception.
   *
   * @param errorCode the error code
   */
  public OSSBSSClientException(final ErrorCode errorCode) {
    super(prepareMessage(errorCode, (String[]) null));
  }

  /**
   * Instantiates a new OSSBSS client exception.
   *
   * @param errorCode the error code
   * @param args the args
   */
  public OSSBSSClientException(final ErrorCode errorCode, final String... args) {
    super(prepareMessage(errorCode, args));
  }

  /**
   * Instantiates a new OSSBSS client exception.
   *
   * @param errorCode the error code
   * @param e the e
   */
  public OSSBSSClientException(final ErrorCode errorCode, final Throwable e) {
    super(prepareMessage(errorCode, (String[]) null), e);
  }

  /**
   * Instantiates a new OSSBSS client exception.
   *
   * @param message the message
   * @param e the e
   */
  public OSSBSSClientException(final String message, final Throwable e) {
    super(message, e);
  }

  /**
   * Instantiates a new OSSBSS client exception.
   *
   * @param e the e
   */
  public OSSBSSClientException(final Throwable e) {
    super(e);
  }

  /**
   * Instantiates a new OSSBSS client exception.
   *
   * @param e the e
   * @param errorCode the error code
   * @param args the args
   */
  public OSSBSSClientException(final Throwable e, final ErrorCode errorCode, final String... args) {
    super(prepareMessage(errorCode, args));
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Throwable#toString()
   */
  @Override
  public String toString() {
    return "OSSBSSClientException Message =" + getMessage();
  }

}
