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

import java.util.List;

import com.accenture.avs.device.json.object.devicemanager.AssignedResources;
import com.accenture.avs.device.json.object.devicemanager.PortMapping;
import com.accenture.avs.device.json.object.devicemanager.Profile;
import com.accenture.avs.device.json.object.devicemanager.SubscriberDetail;
import com.accenture.avs.device.json.object.devicemanager.SubscriberUpdate;

/**
 * @author rajesh.karna
 *
 */
public interface SubscriberHelperService {

	/**
	 * Creates Subscriber on the basis of SubscriberDetail.
	 * 
	 * @param subscriberDetail
	 */
	void createSubscriber(SubscriberDetail subscriberDetail);

	/**
	 * Updates subscriber on the basis of subscriberUpdate.
	 * 
	 * @param subscriberUpdate
	 */
	void updateSubscriber(SubscriberUpdate subscriberUpdate);

	/**
	 * Deletes subscriber on the basis of subscriberId.
	 * 
	 * @param subscriberId
	 */
	void deleteSubscriber(String subscriberId);

	/**
	 * Gets Profile on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return Profile
	 */
	Profile getProfile(Long equipmentId);

	/**
	 * Gets List<PortMapping> on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return List<PortMapping>
	 */
	List<PortMapping> getPortMappings(Long equipmentId);

	/**
	 * Gets list of AssignedResources on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return List<AssignedResources>
	 */
	List<AssignedResources> getAssignedResources(Long equipmentId);

}
