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
package com.accenture.avs.device.enums;

import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.exception.DeviceManagerException;

/**
 * The Enum SearchOperator.
 */
public enum SearchOperator {
  
  /** The equals. */
  EQUALS,
  /** The endswith. */
  ENDSWITH,
  /** The contains. */
  CONTAINS,
  /** The beginswith. */
  BEGINSWITH;
  
	/**
	 * 
	 * @param searchOperation
	 * @return
	 */
	public static SearchOperator getOperation(String searchOperation){
		try {
			return SearchOperator.valueOf(searchOperation);
		}catch(IllegalArgumentException | NullPointerException exception) {
			//throw new DeviceManagerException(ErrorCode.INVALID_PARAM, "Invalid searchOperation provided.");
			throw new DeviceManagerException(ErrorCode.INVALID_PARAM);
		}
	}
}
