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

package com.accenture.avs.device.service;

import com.accenture.avs.device.json.object.devicemanager.CreateDeviceModelRequest;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.DeleteDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceModelListResponse;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelRequest;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;


/**
 * @author rajesh.karna
 *
 */
public interface ModelVersionService{

	/**
	 * Creates or updates hardware versions.
	 * 
	 * @param updateGlobalData
	 */
	public void updateHardwareVersions(UpdateGlobalData updateGlobalData);
	
	/**
	 * This method validates and creates a Model (i.e. Hardware Version)
	 * 
	 * @param deviceModel
	 * @param userId
	 * @param lastUpdatedInterface
	 * 
	 * @return CreateDeviceModelResponse
	 */
	CreateDeviceModelResponse createDeviceModel(CreateDeviceModelRequest deviceModel, String userId,String lastUpdatedInterface);
	
	/**
	 * This method validates and update a Model (i.e. Hardware Version)
	 * 
	 * @param deviceModel
	 * @param userId
	 * @param lastUpdatedInterface
	 * 
	 * @return UpdateDeviceModelResponse
	 */
	UpdateDeviceModelResponse updateDeviceModel(UpdateDeviceModelRequest deviceModel, String userId,String lastUpdatedInterface);
	
	/**
	 * This method deletes model (hardware version) from database.
	 * @param modelName
	 * @return DeleteDeviceModelResponse
	 */
	DeleteDeviceModelResponse deleteDeviceModel(String modelName);
	
	/**
	 * This method get the model (hardware version) list.
	 * @param status
	 * @param deviceModel
	 * @return GetDeviceModelListResponse
	 */
	GetDeviceModelListResponse getDeviceModelList(String status, String deviceModel);
	
}
