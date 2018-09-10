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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.avs.device.entity.QoeGlobalSetting;

/**
 * Repository interface for QoeGlobalSetting entity.
 * 
 * @author rajesh.karna
 *
 */
@Repository
public interface QoeGlobalSettingRepository extends JpaRepository<QoeGlobalSetting, Long> {

}
