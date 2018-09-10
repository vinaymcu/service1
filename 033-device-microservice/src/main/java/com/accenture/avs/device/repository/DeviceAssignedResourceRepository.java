package com.accenture.avs.device.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.avs.device.entity.DeviceAssignedResource;
import com.accenture.avs.device.entity.DeviceAssignedResourceId;

/**
 * The Interface DeviceAssignedResourceRepository.
 * 
 * @author Singh.Saurabh
 *
 */
public interface DeviceAssignedResourceRepository extends JpaRepository<DeviceAssignedResource, DeviceAssignedResourceId> {

	/**
	 * Finds list of DeviceAssignedResource on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return List<DeviceAssignedResource>
	 */
	@Query("SELECT SAR FROM DeviceAssignedResource SAR where SAR.id.equipmentId = :equipmentId")
	List<DeviceAssignedResource> findDeviceAssignedResourcesByEquipmentId(@Param("equipmentId") Long equipmentId);

	/**
	 * This method deletes assigned device resources on the basis of
	 * equipment id.
	 * 
	 * @param equipmentId
	 * @return int
	 */
	@Modifying
	@Query("DELETE DeviceAssignedResource SAR WHERE SAR.id.equipmentId = :equipmentId")
	int deleteByequipmentId(@Param("equipmentId") Long equipmentId);

}
