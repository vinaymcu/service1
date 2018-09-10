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

import com.accenture.avs.device.entity.DefaultServicePortMapping;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.json.object.devicemanager.STBPortMapping;
import com.accenture.avs.device.json.object.devicemanager.STBPortMappings;

/**
 * This is a Interface for Helper Class DevicePropertiesServiceImpl.
 * 
 * @author Singh.Saurabh
 *
 */
public interface DevicePropertiesServiceHelper {

	/**
	 * This method gets the Default Service Port Mappings from database.
	 * 
	 * @param prop
	 * @return
	 */
	DefaultServicePortMapping getDefaultServicePortMapping(STBPortMapping prop);
	
	/**
	 * This method validates and save Device Service Port Mappings
	 * 
	 * @param stbPortMappings
	 * @param equipmentId
	 * @param connectionModeId
	 */
	void validateAndSaveServicePortMappings(STBPortMappings stbPortMappings, Long equipmentId,
			Long connectionModeId);
	
	/**
	 * This method validate macAddress/SubscriberId and returns Device.
	 * 
	 * @param macAddress
	 * @param subscriberId
	 * 
	 * @return SetTopBox
	 */
	Device validateDeviceAndSubscriber(String macAddress, String subscriberId);
}
