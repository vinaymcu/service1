/*******com.accenture.avs.device.entity******************************************
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

import com.accenture.avs.device.entity.SubscriberDeviceLimit;
import com.accenture.avs.device.entity.SubscriberDeviceLimitId;
/**
 * Repository interface for SubscriberDeviceLimit entity.
 * 
 * @author rajesh.karna
 *
 */
@Repository
public interface SubscriberDeviceLimitRepository extends JpaRepository<SubscriberDeviceLimit, SubscriberDeviceLimitId> {
	
	/**
	 * 
	 * @param subscriberId
	 * @return
	 */
	@Query("SELECT dev FROM SubscriberDeviceLimit dev where dev.id.subscriberId = :subscriberId") 
	List<SubscriberDeviceLimit> findBySubscriberId(@Param("subscriberId") String subscriberId);

	/**
	 * Deletes subscriber device limit on the basis of service id.
	 * 
	 * @param  subscriberId
	 * @return int
	 */
	@Modifying
	@Query("DELETE FROM SubscriberDeviceLimit dev where dev.id.subscriberId = :subscriberId")
	 int deleteSubscriberDeviceLimitBySubscriberId(@Param("subscriberId") String subscriberId);
}
