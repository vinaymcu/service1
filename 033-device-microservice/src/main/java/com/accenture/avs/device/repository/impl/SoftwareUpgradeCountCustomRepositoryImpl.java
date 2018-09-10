package com.accenture.avs.device.repository.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.repository.SoftwareUpgradeCountCustomRepository;
import com.accenture.avs.device.util.Constants;

@Repository
public class SoftwareUpgradeCountCustomRepositoryImpl implements SoftwareUpgradeCountCustomRepository {
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(SoftwareUpgradeCountCustomRepositoryImpl.class);

	/** Instance of EntityManager as entityManager */
	@Autowired
	private EntityManager entityManager;

	/**
	 * This method is used to get software upgrade count from db.
	 * 
	 * @param softwareVersion
	 * @return Long
	 */
	@Override
	public Long getSoftwareUpgradeCount(String softwareVersion) {
		long startTime = System.currentTimeMillis();
		Map<String, Object> queryDBParameters = new HashMap<>();
		queryDBParameters.put(Constants.DB_PARAM_SOFTWAREVERSION, softwareVersion);
		
		try {
			return entityManager.createQuery(GET_SOFTWARE_UPGRADE_COUNT, Long.class).setParameter("softwareVersion", softwareVersion).getSingleResult();
		} finally {
			LOGGER.logDBQuery(GET_SOFTWARE_UPGRADE_COUNT, 
					queryDBParameters, System.currentTimeMillis() - startTime);
		}
	}

}
