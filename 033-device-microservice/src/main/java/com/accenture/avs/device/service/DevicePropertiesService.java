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

import com.accenture.avs.device.entity.DeviceProperty;
import com.accenture.avs.device.json.object.devicemanager.STBPortMappings;
import com.accenture.avs.device.json.object.devicemanager.STBProperties;

/**
 * Interface for DevicePropertiesServiceImpl
 * 
 * @author Singh.Saurabh
 *
 */
public interface DevicePropertiesService {

	/**
	 * This method validates and create/update/delete Device properties.
	 * 
	 * @param deviceProperties
	 * @param extIpAddress
	 * @param macAddress
	 * @param subscriberId
	 * 
	 * @return List<StbProperty>
	 * 
	 */
	List<DeviceProperty> setDeviceProperties(STBProperties deviceProperties, String extIpAddress, String macAddress,
			String subscriberId);

	/**
	 * This method validates and gets Device properties.
	 * 
	 * @param extIpAddress
	 * @param macAddress
	 * @param subscriberId
	 * 
	 * @return List<StbProperty>
	 * 
	 */
	List<DeviceProperty> getDeviceProperties(String extIpAddress, String macAddress, String subscriberId);

	/**
	 * This method validates and create/update/delete STB Port Mapping.
	 * 
	 * @param devicePortMappings
	 * @param extIpAddress
	 * @param macAddress
	 * @param subscriberId
	 * 
	 */
	void setDevicePortMappings(STBPortMappings devicePortMappings, String extIpAddress, String macAddress,
			String subscriberId);

	
	/**
	 * 
	 * @param tvQualityInterest
	 * @param avsCookie
	 */
	//NotificationDto updateTvQualityInterest(String tvQualityInterest, String avsCookie);

	/**
	 * 
	 * @param ipAddress
	 * @param supportedModes
	 * @param extIdAddress
	 * @param avsCookie
	 * @return
	 */
	//String stbIpRenewal(String ipAddress, String supportedModes, String extIdAddress, String avsCookie);
}
