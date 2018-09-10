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

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.repository.CustomHardwareMtpMappingRepository;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;
import com.accenture.avs.device.util.Constants;

/**
 * @author rajesh.karna
 *
 */
@Repository
public class CustomHardwareMtpMappingRepositoryImpl implements CustomHardwareMtpMappingRepository {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(CustomHardwareMtpMappingRepositoryImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Deletes hardware mtp mapping on the basis of hardware name.
	 * 
	 * @param  hardwareName
	 * @return int
	 */
	@Override
	public int deleteHardwareMtpMappingByHardwareName(String hardwareName) {
		long startTime = System.currentTimeMillis();
		Map<String, Object> queryDBParameters = new HashMap<>();
		queryDBParameters.put(Constants.DB_PARAM_HARDWARENAME, hardwareName);
		TenantContext.setCurrentTenant(Tenants.WRITE);
		int deletedRows = 0;
		try {
			deletedRows = entityManager
					.createNamedQuery("HMM.DELETE_HMM_BY_HARDWARE_NAME")
					.setParameter("hardwareName", hardwareName).executeUpdate();
		} catch (NoResultException noResultException) {
		} finally {
			LOGGER.logMessage("Rows deleted :{} ",deletedRows);
			LOGGER.logDBQuery("DELETE FROM HardwareMtpMapping HMM WHERE HMM.id.hardwareName = :hardwareName",
					queryDBParameters, System.currentTimeMillis() - startTime);
		}
		return deletedRows;
	}
}
