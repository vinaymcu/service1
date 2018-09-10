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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.avs.device.entity.Model;

/**
 * Repository interface for Model entity.
 * 
 * @author 
 *
 */
@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

	/**
	 * This method finds number of model having provided couple(model and vendor)
	 * 
	 * @param modelName
	 * @param vendor
	 * @return
	 */
	@Query("SELECT COUNT(model) FROM Model model WHERE model.modelName = :modelName AND model.vendor = :vendor")
	long countByModelNameAndVendor(@Param("modelName") String modelName, @Param("vendor") String vendor);
	
	/**
	 * This method gets list of device model base on status
	 * 
	 * @param status
	 * @return
	 */
	List<Model> findByStatus(Boolean status);
	
	/**
	 * This method finds the number of device model(s) having provided model name.
	 * 
	 * @param modelName
	 * @return
	 */
	long countByModelName(String modelName);
	
}
