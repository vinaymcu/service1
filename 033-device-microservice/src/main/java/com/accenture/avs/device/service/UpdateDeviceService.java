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

import java.util.Map;

import com.accenture.avs.device.json.object.devicemanager.DeviceDto;

/**
 * @author rajesh.karna
 *
 */
public interface UpdateDeviceService {

	/**
	 * This method validates and updates the device.
	 * 
	 * @param deviceDto
	 * @param lastUpdateUserName
	 * 
	 */
	void updateDevice(DeviceDto deviceDto, String lastUpdateUserName);

	/**
	 * This method gets the list of subscribers who’s Devices have been updated
	 * within the given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return Map<String, Long>
	 */
	Map<String, Long> getUpdatedDeviceListing(Long startDate, Long endDate);

}
