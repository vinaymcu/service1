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

import com.accenture.avs.device.json.object.resourcemanager.ConfigurationDataUpdate;
import com.accenture.avs.device.json.object.resourcemanager.GetProfileReq;
import com.accenture.avs.device.json.object.resourcemanager.STBProfile;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;

/**
 * ResourceManagerClient
 * 
 * @author Singh.Saurabh
 *
 */
public interface ResourceManagerClient {

	/**
	 * Calls resource manager service to get device profile data.
	 * 
	 * @param getProfileReq
	 * @param subscriberId
	 * @return ResponseEntity<StbProfile>
	 */
	ResponseEntity<STBProfile> getDeviceProfile(GetProfileReq getProfileReq, String subscriberId);

	/**
	 * Calls resource manager service to save configuration data.
	 * 
	 * @param configurationDataUpdate
	 * @return ResponseEntity<GenericResponse>
	 */
	ResponseEntity<GenericResponse> resourceManagerConfigData(ConfigurationDataUpdate configurationDataUpdate);

}
