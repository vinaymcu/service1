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

import java.io.Serializable;

/**
 * This interface defines commonly encoutered error codes.
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 */
public interface IErrorCode extends Serializable{
  
  /** The system exception. */
  String SYSTEM_EXCEPTION = "SYSTEM-000";
  
  /**
   * Gets the code.
   *
   * @return the code
   */
  public String getCode();
  
}
