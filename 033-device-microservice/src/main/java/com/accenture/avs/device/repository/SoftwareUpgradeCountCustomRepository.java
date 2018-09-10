package com.accenture.avs.device.repository;


public interface SoftwareUpgradeCountCustomRepository {

	/** GET_SOFTWARE_UPGRADE_COUNT */
	String GET_SOFTWARE_UPGRADE_COUNT = "SELECT COUNT(*) FROM Device WHERE softwareVersion=:softwareVersion";

	/**
	 * This method is used to get software upgrade count.
	 * 
	 * @param softwareVersion
	 * @return Integer
	 */
	Long getSoftwareUpgradeCount(String softwareVersion);


}
