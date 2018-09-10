/**************************************************************************
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

package com.accenture.avs.device.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.json.object.devicemanager.Location;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;
import com.accenture.avs.device.repository.LocationRepository;
import com.accenture.avs.device.service.LocationService;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;

/**
 * @author rajesh.karna
 *
 */
@Service
public class LocationServiceImpl implements LocationService {
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(LocationServiceImpl.class);
	
	@Autowired
	LocationRepository locationRepository;
	
	/**
	 * Saves or updates locations.
	 * 
	 * @param updateGlobalData
	 */
	@Override
	public void updateLocations(UpdateGlobalData updateGlobalData) {
		List<Location> locations = updateGlobalData.getGlobalData().getLocations();
		if (locations != null) {
			LOGGER.logMessage("updateLocations++");
			locationRepository.deleteAll();
			locations.stream().forEach(location -> updateLocation(location));
			LOGGER.logMessage("updateLocations--");
		}
	}
	
	/**
	 * Saves or updates location in the database.
	 * 
	 * @param location
	 */
	private void updateLocation(Location location) {
		printLogForLocation(location);
		com.accenture.avs.device.entity.Location locationEntity = new com.accenture.avs.device.entity.Location();
		locationEntity.setLocationId(Long.valueOf(location.getID()));
		locationEntity.setParentId(Long.valueOf(location.getParentID()));
		locationEntity.setName(location.getName());
		locationEntity.setTvRegionId(location.getTVRegionID().longValue());
		TenantContext.setCurrentTenant(Tenants.WRITE);
		locationRepository.save(locationEntity);
	}
	
	/**
	 * Prints log for location parameters.
	 * 
	 * @param location
	 */
	private void printLogForLocation(Location location) {
		StringBuilder stringBuilder = new StringBuilder("Location with the following parameters:");
		stringBuilder.append("\nName = ");
		stringBuilder.append(location.getName());
		stringBuilder.append("\nID = ");
		stringBuilder.append(location.getID());
		stringBuilder.append("\nParentID = ");
		stringBuilder.append(location.getParentID());
		stringBuilder.append("\nTVRegionID = ");
		stringBuilder.append(location.getTVRegionID());
		LOGGER.logMessage(stringBuilder.toString());
	}
}
