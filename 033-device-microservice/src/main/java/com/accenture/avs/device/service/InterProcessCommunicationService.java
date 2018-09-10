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

package com.accenture.avs.device.service;

import com.accenture.avs.device.json.object.resourcemanager.ConfigurationDataUpdate;
import com.accenture.avs.device.json.object.resourcemanager.GetProfileReq;
import com.accenture.avs.device.json.object.resourcemanager.STBProfile;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdateRequest;

/**
 * @author rajesh.karna
 *
 */
public interface InterProcessCommunicationService {

	/**
	 * Sends notification using unicast notifier service on the basis of
	 * eventUpdateRequest and notificationRetrials.
	 * 
	 * @param eventUpdateRequest
	 * @param notificationRetrials
	 */
	void notifyDevices(EventUpdateRequest eventUpdateRequest, int notificationRetrials);

	/**
	 * Gets Device profile data from resource manager.
	 * 
	 * @param getProfileReq
	 * @param subscriberId
	 * 
	 * @return StbProfile
	 */
	STBProfile getDeviceProfile(GetProfileReq getProfileReq, String subscriberId);

	/**
	 * Sends request to resource Manager to update config data.
	 * 
	 * @param configurationDataUpdate
	 */
	void sendReqToResourceMgrToUpdConfigData(ConfigurationDataUpdate configurationDataUpdate);

	/**
	 * Sends request to document manager for the generation of global install
	 * document.
	 * 
	 * @param globalInstallDocumentId
	 */
	void generateGlobalInstallDocument(String globalInstallDocumentId);
}
