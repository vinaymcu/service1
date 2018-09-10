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

package com.accenture.avs.device.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.avs.device.entity.DeviceMaxBWAllowedPerQuality;
import com.accenture.avs.device.entity.DeviceMaxBWAllowedPerQualityId;

/**
 * Repository interface for DeviceMaxBWAllowedPerQuality entity.
 * 
 * @author rajesh.karna
 *
 */
@Repository
public interface DeviceMaxBWAllowedPerQualityRepository
		extends JpaRepository<DeviceMaxBWAllowedPerQuality, DeviceMaxBWAllowedPerQualityId> {

	/**
	 * Deletes DeviceMaxBWAllowedPerQuality data on the basis of equipmentId.
	 * 
	 * @param id
	 * @return int
	 */
	@Modifying
	@Query("delete DeviceMaxBWAllowedPerQuality SMBAPQ where SMBAPQ.id.id = :id")
	int deleteById(@Param("id") Long id);
	
	/**
	 * This method finds all DeviceMaxBWAllowedPerQuality for the provided equipment id
	 * 
	 * @param id
	 * 
	 * @return List<DeviceMaxBWAllowedPerQuality>
	 */
	@Query("SELECT SMBAPQ FROM DeviceMaxBWAllowedPerQuality SMBAPQ where SMBAPQ.id.id = :id")
	List<DeviceMaxBWAllowedPerQuality> findById(@Param("id") Long id);

}
