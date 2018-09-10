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

/**
 *
 */
package com.accenture.avs.device.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.avs.device.entity.Device;

/**
 * The Interface DeviceRepository.
 *
 * @author sumit.sharma
 */

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

	/**
	 * Finds device based on deviceId
	 *
	 * @param deviceId
	 * @return device, if found
	 */
	Device findByDeviceId(String deviceId);

	/**
	 * Finds device based on externalIpAddress
	 * 
	 * @param externalIpAddress
	 * @return List<Device>
	 */
	List<Device> findByExternalIpAddress(String externalIpAddress);
	
	/**
	 * Finds devices based on assignedToUserName
	 * 
	 * @param assignedToUserName
	 * @return List<Device>
	 */
	List<Device> findByAssignedToUserName(String assignedToUserName);
	
	
	/**
	 * Finds devices based on assignedToUserName list 
	 * 
	 * @param userNameList
	 * @return List<Device>
	 */
	@Query("SELECT dev FROM Device dev WHERE dev.assignedToUserName IN :userNameList")
	List<Device> findByAssignedToUserNameList(@Param("userNameList") List<String> userNameList);

	/**
	 * Finds device based on Id
	 * 
	 * @param equipmentId
	 * @return Device
	 */
	Device findById(Long id);
	
	/**
	 * This method finds number of devices having provided triplet(serial number,
	 * model and vendor) excluding the same device.
	 * 
	 * @param serialNumber
	 * @param modelName
	 * @param vendor
	 * @param deviceId
	 * 
	 * @return
	 */
	@Query("SELECT COUNT(dev) FROM Device dev WHERE dev.serialNumber = :serialNumber AND dev.model.modelName = :modelName AND dev.vendor = :vendor AND dev.deviceId NOT LIKE :deviceId")
	long findCountByTripletAndDeviceIdNotLike(@Param("serialNumber") String serialNumber,
			@Param("modelName") String modelName, @Param("vendor") String vendor, @Param("deviceId") String deviceId);
	
	/**
	 * This method finds number of devices having provided model name and
	 * assignement status.
	 * 
	 * @param modelName
	 * @param assignmentStatus
	 * @return
	 */
	@Query("SELECT COUNT(dev) FROM Device dev WHERE dev.model.modelName = :modelName AND dev.assignmentStatus LIKE :assignmentStatus")
	long findCountByModelAndAssignmentStatus(@Param("modelName") String modelName,
			@Param("assignmentStatus") String assignmentStatus);
	
	/**
	 * This method finds number of devices having provided model name.
	 * 
	 * @param modelName
	 * @return
	 */
	@Query("SELECT COUNT(dev) FROM Device dev WHERE dev.model.modelName = :modelName")
	long findCountByModel(@Param("modelName") String modelName);
	
	/**
	 * This method finds the number of device(s) having provided drm id excluding
	 * the same device.
	 * 
	 * @param drmId
	 * @param deviceId
	 * 
	 * @return
	 */
	long countByDrmIdAndDeviceIdNotLike(String drmId, String deviceId);
	
	/**
	 * This method finds the number of device(s) having provided device id.
	 * 
	 * @param deviceId
	 * @return
	 */
	long countByDeviceId(String deviceId);
	
	/**
	 * This method finds if there exists any device for the subscriber with given
	 * name and excluding same device.
	 * 
	 * @param deviceName
	 * @param assignedToUserName
	 * @param deviceId
	 * @return
	 */
	long countByDeviceNameAndAssignedToUserNameAndDeviceIdNotLike(String deviceName, String assignedToUserName,
			String deviceId);
	
	/**
	 * This method returns devices assigned to a subscriber by descending order of
	 * the device name.
	 * 
	 * @param deviceName
	 * @param assignedToUserName
	 * @return
	 */
	@Query("SELECT dev.deviceName FROM Device dev WHERE dev.deviceName LIKE :deviceName AND dev.assignedToUserName = :assignedToUserName ORDER BY dev.deviceName DESC")
	List<String> findDeviceNamesByDeviceNameAndAssignedToUserNameOrderByDeviceNameDesc(
			@Param("deviceName") String deviceName, @Param("assignedToUserName") String assignedToUserName);
	
	/**
	 * This method counts the Model associated to Device.
	 * 
	 * @param modelName
	 * @return
	 */
	@Query("SELECT COUNT(dev) FROM Device dev WHERE dev.model.modelName LIKE :modelName")
	long findModelToAssocitedDevice(@Param("modelName")String modelName);
	
}
