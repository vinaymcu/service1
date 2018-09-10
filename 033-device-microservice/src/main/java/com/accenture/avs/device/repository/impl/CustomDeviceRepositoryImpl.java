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

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.repository.CustomDeviceRepository;
import com.accenture.avs.device.util.SearchFilter;

/**
 * The Class CustomDeviceRepositoryImpl.
 *
 * @author sumit.sharma
 * @since 1.0
 */

@Repository
@CacheConfig(cacheNames = "devices")
public class CustomDeviceRepositoryImpl implements CustomDeviceRepository {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(CustomDeviceRepositoryImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private DeviceSearchCriteriaMapperImpl criteriaMapperImpl;

	/* (non-Javadoc)
	 * @see com.accenture.avs.device.repository.CustomDeviceRepository#search(com.accenture.avs.device.util.SearchFilter)
	 */
	@Override
	public List<Device> search(SearchFilter filter) {
		final String searchValue = filter.getSearchValue();
		final StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT S FROM Device S ");
		filter.setMapper(criteriaMapperImpl);
		queryBuilder.append(filter.buildCompeleteCriteria("S"));
		final Query query = entityManager.createQuery(queryBuilder.toString());

		if (queryBuilder.indexOf("param") > 0) {
			query.setParameter("param", searchValue);
		}

		if (filter.getStartIndex() != null) {
			query.setFirstResult(filter.getStartIndex());
		}
		if (filter.getPageSize() != null) {
			query.setMaxResults(filter.getPageSize());
		}
		return query.getResultList();
	}

}
