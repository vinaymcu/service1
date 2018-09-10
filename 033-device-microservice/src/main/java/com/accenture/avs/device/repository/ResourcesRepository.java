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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.avs.device.entity.Resource;
import com.accenture.avs.device.entity.ResourceId;

/**
 * The Interface ResourcesRepository.
 * 
 * @author Singh.Saurabh
 *
 */
@Repository
public interface ResourcesRepository extends JpaRepository<Resource, ResourceId> {
	
	/**
	 * This method finds Resources based on provided name list
	 * 
	 * @param nameList
	 * @return
	 */
	@Query("SELECT r FROM Resource r where r.id.name IN :nameList")
	List<Resource> findByName(@Param("nameList") List<String> nameList);
	
	/**
	 * This method finds Resource on the basis of resource name.
	 * 
	 * @param nameList
	 * @return Resource
	 */
	@Query("SELECT r FROM Resource r where r.id.name = :name")
	Resource findByName(@Param("name") String name);
	
	/**
	 * Finds list of Resource on the basis of resourceId.
	 * 
	 * @param resourceId
	 * @return List<Resource>
	 */
	@Query("SELECT RES FROM Resource RES where RES.id.id = :resourceId")
	List<Resource> findResourcesByResourceId(@Param("resourceId") Long resourceId);

}
