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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.avs.device.entity.ModelMaxStreamsAllowedPerQuality;
import com.accenture.avs.device.entity.ModelMaxStreamsAllowedPerQualityId;

/**
 * A repository for DeviceProperty
 * 
 * @author
 *
 */
@Repository
public interface MaxStreamsPerQualityRepository
		extends JpaRepository<ModelMaxStreamsAllowedPerQuality, ModelMaxStreamsAllowedPerQualityId> {

	@Modifying
	@Query("DELETE FROM ModelMaxStreamsAllowedPerQuality MMSQ WHERE MMSQ.id.modelId = :modelName")
	void deleteMaxStreamPerQuality(@Param("modelName") String modelName);

	/**
	 * This method deletes ModelMaxStreamsAllowedPerQuality based on provided
	 * modelName and resolutionTypeName.
	 * 
	 * @param modelName
	 * @param resolutionTypeName
	 */
	@Modifying
	@Query("DELETE FROM ModelMaxStreamsAllowedPerQuality MMSQ WHERE MMSQ.id.modelId = :modelName AND MMSQ.id.resolutionTypeName = :resolutionTypeName")
	void deleteByModelNameAndResolutionTypeName(@Param("modelName") String modelName,
			@Param("resolutionTypeName") String resolutionTypeName);
	
	/**
	 * This method deletes ModelMaxStreamsAllowedPerQuality based on provided
	 * modelName and resolutionTypeName.
	 * 
	 * @param modelName
	 * @param resolutionTypeNameList
	 */
	@Modifying
	@Query("DELETE FROM ModelMaxStreamsAllowedPerQuality MMSQ WHERE MMSQ.id.modelId = :modelName AND MMSQ.id.resolutionTypeName IN :resolutionTypeNameList")
	void deleteByModelNameAndResolutionTypeName(@Param("modelName") String modelName,
			@Param("resolutionTypeNameList") List<String> resolutionTypeNameList);

}
