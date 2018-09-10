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

import com.accenture.avs.device.entity.DeviceResourceAllocation;

/**
 * Repository interface for DeviceResourceAllocationRepository entity.
 * 
 * @author rajesh.karna
 *
 */
@Repository
public interface DeviceResourceAllocationRepository extends JpaRepository<DeviceResourceAllocation, Long> {

	/**
	 * This method returns all the DeviceResourceAllocation which are updated
	 * between the provided time frame.
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<DeviceResourceAllocation> findByLastUpdatedOnBetween(Long startDate, Long endDate);
	
	/**
	 * Deletes DeviceResourceAllocation data on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return int
	 */
	@Modifying
	@Query("delete DeviceResourceAllocation DRA where DRA.equipmentId = :equipmentId")
	int deleteByEquipmentId(@Param("equipmentId") Long equipmentId);
}
