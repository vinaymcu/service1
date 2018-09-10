/****************************************************************************
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
package com.accenture.avs.device.client;

import org.springframework.http.ResponseEntity;

import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdateRequest;

/**
 * This is the Client to communicate with the Push Message MS
 * 
 * @author Singh.Saurabh
 *
 */
public interface PushMessageClient {

	/**
	 * This method sends trigger to push message ms
	 * 
	 * @param eventUpdateRequest
	 * @return
	 */
	ResponseEntity<GenericResponse> trigger(EventUpdateRequest eventUpdateRequest);
}
