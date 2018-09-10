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
package com.accenture.avs.device.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.DeviceAudit;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.repository.CustomDeviceAuditRepository;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;
import com.accenture.avs.device.util.Constants;

/**
 * A custom repository for DeviceAudit
 * 
 * @author Singh.Saurabh
 *
 */
@Repository
public class CustomDeviceAuditRepositoryImpl implements CustomDeviceAuditRepository {
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(CustomDeviceAuditRepositoryImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * This method returns DeviceAudit list containing those elements whose LastUpdatedOn is between the provided startDate and endDate
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @return List<DeviceAudit>
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceAudit> findAssignedToSubscriberIdAndMaxLastUpdatedOnByStartAndEndDate(Long startDate,
			Long endDate) {
		long startTime = System.currentTimeMillis();
		Map<String, Object> queryDBParameters = new HashMap<>();
		queryDBParameters.put(Constants.DB_PARAM_STARTDATE, startDate);
		queryDBParameters.put(Constants.DB_PARAM_ENDDATE, endDate);
		String printQuery = new StringBuilder(
				"SELECT NEW com.accenture.avs.device.entity.DeviceAudit(DEVA.assignedToUsername as assignedToUsername, MAX(DEVA.lastUpdatedDatetime) as lastUpdatedDatetime)")
						.append(" FROM DeviceAudit DEVA").append(" WHERE DEVA.assignedToUsername IS NOT NULL")
						.append(" AND DEVA.lastUpdatedDatetime BETWEEN :startDate AND :endDate")
						.append(" GROUP BY DEVA.assignedToUsername").toString();

		TenantContext.setCurrentTenant(Tenants.READ);

		List<DeviceAudit> deviceAuditList = new ArrayList<>();

		try {
			Query query = entityManager.createNamedQuery(
					"DEVICEAUDIT.FIND_SUBSCRIBER_ID_MAX_LAST_UPDATE_BY_START_END_DATE", DeviceAudit.class);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);

			deviceAuditList = query.getResultList();

		} catch (NoResultException noResultException) {
			LOGGER.logMessage("No Devices Inserted/Updated between startDate= {} , endDate={}", startDate, endDate);
		} finally {
			LOGGER.logDBQuery(printQuery, queryDBParameters, System.currentTimeMillis() - startTime);
		}
		return deviceAuditList;
	}
	

	/**
	 * This method finds Device Audit Logs for the provided deviceId using offset and max result	
	 * 
	 * @param deviceId
	 * @param startIndex
	 * @param maxResults
	 * 
	 * @return List<DeviceAudit>
	 */
	public List<DeviceAudit> findByDeviceIdAndStartIndexAndMaxResults(String deviceId, Integer startIndex, Integer maxResults) {
		long startTime = System.currentTimeMillis();
		Map<String, Object> queryDBParameters = new HashMap<>();
		queryDBParameters.put(Constants.DB_PARAM_DEVICEID, deviceId);
		queryDBParameters.put(Constants.DB_PARAM_STARTINDEX, startIndex);
		queryDBParameters.put(Constants.DB_PARAM_MAXRESULTS, maxResults);
		String printQuery = GET_DEVICES_AUDIT_BY_DEVICEID;
		TenantContext.setCurrentTenant(Tenants.READ);
		List<DeviceAudit> deviceAuditList = null;
		try {	
			deviceAuditList = entityManager.createQuery(GET_DEVICES_AUDIT_BY_DEVICEID, DeviceAudit.class)
							.setParameter(Constants.DB_PARAM_DEVICEID, deviceId)
							.setFirstResult(startIndex).setMaxResults(maxResults).getResultList();			
		} catch (NoResultException noResultException) {
			LOGGER.logMessage("No devices audit log found for deviceId={},  startIndex= {} , maxResults={}", deviceId, startIndex, maxResults);		
		} finally {
			LOGGER.logDBQuery(printQuery, queryDBParameters, System.currentTimeMillis() - startTime);
		}		
		return deviceAuditList;
	}
}
