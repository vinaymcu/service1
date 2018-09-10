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
package com.accenture.avs.device.repository;

import java.util.List;

import com.accenture.avs.device.entity.DeviceAudit;

/**
 * Interface for CustomSetTopBoxAuditRepositoryImpl.
 * 
 * @author Singh.Saurabh
 *
 */
public interface CustomDeviceAuditRepository {

	/** GET_DEVICES_AUDIT_BY_DEVICEID */
	String GET_DEVICES_AUDIT_BY_DEVICEID = "SELECT DA FROM DeviceAudit DA WHERE deviceId =:deviceId";
	
	/**
	 * This method finds SetTopBoxAudit records for provided SubscriberId and
	 * within the given time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return List<DeviceAudit>
	 */
	List<DeviceAudit> findAssignedToSubscriberIdAndMaxLastUpdatedOnByStartAndEndDate(Long startDate, Long endDate);
	
	/**
	 * This method finds Device Audit Logs for the provided deviceId using offset and max result	
	 * 
	 * @param deviceId
	 * @param startIndex
	 * @param maxResults
	 * 
	 * @return List<DeviceAudit>
	 */
	List<DeviceAudit> findByDeviceIdAndStartIndexAndMaxResults(String deviceId, Integer startIndex, Integer maxResults);
	
}
