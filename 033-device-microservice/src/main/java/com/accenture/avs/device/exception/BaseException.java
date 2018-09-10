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
package com.accenture.avs.device.exception;

import java.util.Arrays;

/**
 * The Class BaseException.
 *
 * @author Sumit.Sharma
 * @version 1.0
 */

public abstract class BaseException extends RuntimeException {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;
  
  /** The error code. */
  private final IErrorCode errorCode;
  
  /** The args. */
  private final Object[] args;
  
  /**
   * Instantiates a new base exception.
   *
   * @param errorCode the error code
   */
  public BaseException(final IErrorCode errorCode) {
    super();
    this.errorCode = errorCode;
    this.args = null;
  }
  
  /**
   * Instantiates a new base exception.
   *
   * @param errorCode the error code
   * @param msgParams the msg params
   */
  public BaseException(final IErrorCode errorCode, final Object[] msgParams) {
    super();
    this.errorCode = errorCode;
    this.args = Arrays.copyOf(msgParams, msgParams.length);
  }

  /**
   * 
   * @param errorCode
   * @param msg
   * @param msgParams
   */
  public BaseException(final IErrorCode errorCode, final String msg, final Object[] msgParams) {
      super(msg);
      this.errorCode = errorCode;
      this.args = Arrays.copyOf(msgParams, msgParams.length);
  }
  
  /**
   * Instantiates a new base exception.
   *
   * @param errorCode the error code
   * @param msgParams the msg params
   * @param throwable the throwable
   */
  public BaseException(final IErrorCode errorCode, final Object[] msgParams,
      final Throwable throwable) {
    super(throwable);
    this.errorCode = errorCode;
    this.args = Arrays.copyOf(msgParams, msgParams.length);
  }
  
  /**
   * Instantiates a new base exception.
   *
   * @param errorCode the error code
   * @param throwable the throwable
   */
  public BaseException(final IErrorCode errorCode, final Throwable throwable) {
    super(throwable);
    this.errorCode = errorCode;
    this.args = null;
  }
  
  /**
   * Instantiates a new base exception.
   *
   * @param errorCode the error code
   * @param msgParams the msg params
   */
  public BaseException(final IErrorCode errorCode, final String msg) {
    super(msg);
    this.errorCode = errorCode;
    this.args = null;
  }
  
  /**
   * Instantiates a new base exception.
   *
   * @param errorCode the error code
   * @param msgParams the msg params
   * @param throwable the throwable
   */
  public BaseException(final IErrorCode errorCode, final String msg, final Throwable throwable) {
    super(msg, throwable);
    this.errorCode = errorCode;
    this.args = null;
  }
  
  /**
   * Gets the args.
   *
   * @return the args
   */
  public Object[] getArgs() {
    if (args != null) {
      return Arrays.copyOf(args, args.length);
    }
    return new Object[0];
  }
  
  /**
   * Gets the error code.
   *
   * @return the error code
   */
  public IErrorCode getErrorCode() {
    return errorCode;
  }
  
}
