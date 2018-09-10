/***********************************************************************
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

package com.accenture.avs.device.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.client.DocumentManagerClient;
import com.accenture.avs.device.entity.HardwareMtpMapping;
import com.accenture.avs.device.entity.HardwareMtpMappingId;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.entity.ModelMaxStreamsAllowedPerQuality;
import com.accenture.avs.device.entity.ModelMaxStreamsAllowedPerQualityId;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceModelRequest;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.DeleteDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.DocumentGeneratorRequest;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceModelListResponse;
import com.accenture.avs.device.json.object.devicemanager.HWVersion;
import com.accenture.avs.device.json.object.devicemanager.MaxStreamsPerQuality;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelRequest;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelResponse;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;
import com.accenture.avs.device.json.object.resourcemanager.ConfigurationDataUpdate;
import com.accenture.avs.device.json.object.resourcemanager.HWList;
import com.accenture.avs.device.json.object.resourcemanager.UpdateConfigurationData;
import com.accenture.avs.device.repository.CustomHardwareMtpMappingRepository;
import com.accenture.avs.device.repository.HardwareMtpMappingRepository;
import com.accenture.avs.device.repository.MaxStreamsPerQualityRepository;
import com.accenture.avs.device.repository.ModelRepository;
import com.accenture.avs.device.service.DeviceServiceHelper;
import com.accenture.avs.device.service.InterProcessCommunicationService;
import com.accenture.avs.device.service.ModelVersionService;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;
import com.accenture.avs.device.util.Constants;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.DeviceManagerValidator;
import com.accenture.avs.device.util.EntityObjectGenerator;
import com.accenture.avs.device.util.RequestResponseGenerator;

/**
 * @author rajesh.karna
 *
 */
@Service
public class ModelVersionServiceImpl implements ModelVersionService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(ModelVersionServiceImpl.class);

	@Autowired
	ModelRepository modelRepository;

	@Autowired
	HardwareMtpMappingRepository hardwareMtpMappingRepository;

	@Autowired
	InterProcessCommunicationService interProcessCommunicationService;

	@Autowired
	CustomHardwareMtpMappingRepository customHardwareMtpMappingRepository;

	/** maxStreamsPerQualityRepository */
	@Autowired
	MaxStreamsPerQualityRepository maxStreamsPerQualityRepository;
	
	@Autowired
	DeviceManagerValidator deviceManagerValidator;
	
	@Autowired
	DocumentManagerClient documentClient;
	
	/** deviceServiceHelper */
	@Autowired
	DeviceServiceHelper deviceServiceHelper;
	
	/**
	 * Creates or updates hardware versions.
	 * 
	 * @param updateGlobalData
	 */
	@Override
	public void updateHardwareVersions(UpdateGlobalData updateGlobalData) {

		List<HWVersion> hwVersions = updateGlobalData.getGlobalData().getHWVersion();

		if (hwVersions != null) {

			LOGGER.logMessage("updateHardwareVersions++");

			List<HWVersion> hwVersionsForConfigData = new ArrayList<>();

			hwVersions.stream().forEach(hwVersion -> {

				if (modelRepository.findOne(hwVersion.getName()) != null) {
					hwVersionsForConfigData.add(hwVersion);
				}
			});

			if (!hwVersionsForConfigData.isEmpty()) {
				LOGGER.logMessage("The hardware Version is already available in the database, therefore"
						+ " calling resource manager service to update configuration data.");
				interProcessCommunicationService.sendReqToResourceMgrToUpdConfigData(
						getConfigurationDataUpdateForHWVersion(hwVersionsForConfigData));
			}

			hwVersions.stream().forEach(hwVersion -> {
				updateHardwareVersion(hwVersion);
				TenantContext.setCurrentTenant(Tenants.WRITE);
				updateHardwareMTPPappings(hwVersion);
			});

			LOGGER.logMessage("updateHardwareVersions--");
		}
	}

	/**
	 * Saves or updates hardware mtp mappings.
	 * 
	 * @param hwVersion
	 */
	private void updateHardwareMTPPappings(HWVersion hwVersion) {

		String hardwareName = hwVersion.getName();
		customHardwareMtpMappingRepository.deleteHardwareMtpMappingByHardwareName(hardwareName);
		hwVersion.getVideoTypeProfile().stream().forEach(mtpName -> {
			printLogForHardwareMTPMapping(hardwareName, mtpName);
			HardwareMtpMapping hardwareMtpMapping = new HardwareMtpMapping();
			HardwareMtpMappingId hardwareMtpMappingId = new HardwareMtpMappingId(hardwareName, mtpName);
			hardwareMtpMapping.setId(hardwareMtpMappingId);
			hardwareMtpMappingRepository.save(hardwareMtpMapping);
		});
	}

	/**
	 * Prepares and returns configuration data for hardware version.
	 * 
	 * @param hwVersionsForConfigData
	 * 
	 * @return ConfigurationDataUpdate
	 */
	private ConfigurationDataUpdate getConfigurationDataUpdateForHWVersion(List<HWVersion> hwVersions) {

		ConfigurationDataUpdate configurationDataUpdate = new ConfigurationDataUpdate();

		List<HWList> hwLists = new ArrayList<>();
		HWList hwList = new HWList();
		hwVersions.stream().forEach(hardwareVersion -> {
			hwList.setHWVersion(hardwareVersion.getName());
			hwList.setHWVIDEOTYPENAMELIST(hardwareVersion.getVideoTypeProfile());
			hwList.setQoECapable(hardwareVersion.getQoECapable());
			hwLists.add(hwList);
		});

		UpdateConfigurationData updateConfigurationData = new UpdateConfigurationData();
		updateConfigurationData.setHWList(hwLists);
		configurationDataUpdate.setUpdateConfigurationData(updateConfigurationData);

		return configurationDataUpdate;
	}

	/**
	 * Saves or updates hardware version data in database.
	 * 
	 * @param hwVersion
	 */
	private void updateHardwareVersion(HWVersion hwVersion) {
		printLogForHardware(hwVersion);
		Model hardwareVersion = new Model();
		hardwareVersion.setModelName(hwVersion.getName());
		hardwareVersion.setDisableDeviceAutoRegistration(hwVersion.getDisableSTBAutoRegistration());
		hardwareVersion.setQoeCapable(hwVersion.getQoECapable());
		TenantContext.setCurrentTenant(Tenants.WRITE);
		modelRepository.save(hardwareVersion);
	}

	/**
	 * Prints log for hardware version details.
	 * 
	 * @param hwVersion
	 */
	private static void printLogForHardware(HWVersion hwVersion) {
		StringBuilder stringBuilder = new StringBuilder("Hardware version details with the following parameters:");
		stringBuilder.append("\nName = ");
		stringBuilder.append(hwVersion.getName());
		stringBuilder.append("\nDisableSTBAutoRegistration = ");
		stringBuilder.append(hwVersion.getDisableSTBAutoRegistration());
		stringBuilder.append("\nQoECapable = ");
		stringBuilder.append(hwVersion.getQoECapable());
		LOGGER.logMessage(stringBuilder.toString());
	}

	/**
	 * Prints log for hardware port mapping.
	 * 
	 * @param hardwareName
	 * @param mtpName
	 */
	private void printLogForHardwareMTPMapping(String hardwareName, String mtpName) {
		StringBuilder stringBuilder = new StringBuilder("Hardware Port Mapping with the following parameters:");
		stringBuilder.append("\nHardwareName = ");
		stringBuilder.append(hardwareName);
		stringBuilder.append("\nMtpName = ");
		stringBuilder.append(mtpName);
		LOGGER.logMessage(stringBuilder.toString());
	}
	
	/**
	 * This method validates and creates a new Model (i.e. Hardware Version)
	 * 
	 * @param deviceModel
	 * 
	 * @return CreateDeviceModelResponse
	 */
	@Override
	public CreateDeviceModelResponse createDeviceModel(CreateDeviceModelRequest deviceModel, String lastUpdateUserName,
			String lastUpdatedInterface) {
		LOGGER.logMessage("++ createDeviceModel() ");
		long startTime = System.currentTimeMillis();

		// Validate Device Model
		deviceManagerValidator.validateModelUniqueness(deviceModel.getDeviceModel());

		// Save Model and MaxStreamsAllowedPerQuality
		Model deviceModelEntity = modelRepository
				.save(EntityObjectGenerator.createModelEntity(deviceModel, lastUpdateUserName, lastUpdatedInterface));

		// Trigger Document Generator
		triggerDocumentGeneration(deviceModelEntity);

		CreateDeviceModelResponse response = new CreateDeviceModelResponse();
		response.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		response.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMessage("-- createDeviceModel() ");
		LOGGER.logMethodEnd(executionTime);
		return response;
	}

	/**
	 * This method validates and update a Model (i.e. Hardware Version)
	 * 
	 * @param deviceModel
	 * @param lastUpdateUserName
	 * @param lastUpdatedInterface
	 * 
	 * @return UpdateDeviceModelResponse
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public UpdateDeviceModelResponse updateDeviceModel(UpdateDeviceModelRequest deviceModel, String lastUpdateUserName,
			String lastUpdatedInterface) {
		LOGGER.logMessage("+ updateDeviceModel() ");
		long startTime = System.currentTimeMillis();

		// Validate Model Existence
		Model deviceModelEntity = deviceServiceHelper.getDeviceModel(deviceModel.getDeviceModel(), Boolean.FALSE);

		// Validate Model Status Update
		if (!DeviceManagerUtil.checkNullObject(deviceModel.getStatus()) && deviceModel.getStatus() == 0) {
			deviceManagerValidator.validateModelStatusUpdate(deviceModelEntity);
		}

		// Delete Old Model Max Streams Allowed Per Quality
		deleteOldModelMaxStreamsAllowedPerQuality(deviceModel, deviceModelEntity);
		
		// Update Device Model and Save Model Max Streams Allowed Per Quality
		deviceModelEntity = modelRepository.save(EntityObjectGenerator.updateModelEntity(deviceModel, deviceModelEntity,
				lastUpdateUserName, lastUpdatedInterface));

		// Trigger Document Generator
		triggerDocumentGeneration(deviceModelEntity);

		Long executionTime = System.currentTimeMillis() - startTime;
		UpdateDeviceModelResponse response = new UpdateDeviceModelResponse();
		response.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		response.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());

		LOGGER.logMessage("- updateDeviceModel() ");
		LOGGER.logMethodEnd(executionTime);
		return response;
	}
	
	/**
	 * This method deletes the old ModelMaxStreamsAllowedPerQuality for the updated
	 * device model.
	 * 
	 * @param deviceModel
	 * @param deviceModelEntity
	 */
	private void deleteOldModelMaxStreamsAllowedPerQuality(UpdateDeviceModelRequest deviceModel,
			Model deviceModelEntity) {
		List<ModelMaxStreamsAllowedPerQuality> existingModelMaxStreamsAllowedPerQualityList = deviceModelEntity
				.getModelMaxStreamsAllowedPerQuality();
		List<ModelMaxStreamsAllowedPerQuality> toUpdateModelMaxStreamsAllowedPerQualityList = EntityObjectGenerator
				.getModelMaxStreamsAllowedPerQuality(deviceModel.getMaxStreamsPerQuality(),
						deviceModel.getDeviceModel());

		for (ModelMaxStreamsAllowedPerQuality modelMaxStreamsAllowedPerQuality : toUpdateModelMaxStreamsAllowedPerQualityList) {
			existingModelMaxStreamsAllowedPerQualityList.remove(modelMaxStreamsAllowedPerQuality);
		}

		List<String> toDeleteResolutionType = new ArrayList<>();
		for (ModelMaxStreamsAllowedPerQuality modelMaxStreamsAllowedPerQuality : existingModelMaxStreamsAllowedPerQualityList) {
			toDeleteResolutionType.add(modelMaxStreamsAllowedPerQuality.getId().getResolutionTypeName());
		}
		if (!toDeleteResolutionType.isEmpty()) {
			maxStreamsPerQualityRepository.deleteByModelNameAndResolutionTypeName(deviceModel.getDeviceModel(),
					toDeleteResolutionType);
		}
	}
	
	/**
	 * This method deletes model (hardware version) from database.
	 * @param modelName
	 * @return UpdateDeviceModelResponse
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public DeleteDeviceModelResponse deleteDeviceModel(String modelName) {
		LOGGER.logMessage("+ deleteDeviceModel() ");
		long startTime = System.currentTimeMillis();

		Model deviceModelEntityObj = modelRepository.findOne(modelName);

		deviceManagerValidator.validateDeviceModelExistance(deviceModelEntityObj);
		deviceManagerValidator.checkModelStatusActive(deviceModelEntityObj.getStatus());
		deviceManagerValidator.checkModelAssociatedToDevice(deviceModelEntityObj.getModelName());
		
		// delete all records from child table as ModelMaxStreamsAllowedPerQuality associated with model
		maxStreamsPerQualityRepository.deleteMaxStreamPerQuality(deviceModelEntityObj.getModelName());
				
		//update parent table as model (i.e. Hardware version) data. 
		modelRepository.delete(deviceModelEntityObj.getModelName());

		Long executionTime = System.currentTimeMillis() - startTime;
		DeleteDeviceModelResponse response = new DeleteDeviceModelResponse();
		response.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		response.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());

		LOGGER.logMessage("- deleteDeviceModel() ");
		LOGGER.logMethodEnd(executionTime);
		return response;
	}
	
	/**
	 * This method get the model (hardware version) list.
	 * 
	 * @param status
	 * @param deviceModel
	 * @return GetDeviceModelListResponse
	 */
	public GetDeviceModelListResponse getDeviceModelList(String status, String deviceModel) {
		LOGGER.logMessage("+ deleteDeviceModel() ");
		long startTime = System.currentTimeMillis();

		List<Model> modelEntityList = new ArrayList<>();
		
		if (StringUtils.isNotBlank(deviceModel)) {
			Model deviceModelEntity = deviceServiceHelper.getDeviceModel(deviceModel, Boolean.FALSE);
			modelEntityList.add(deviceModelEntity);
		} else if (StringUtils.isNotBlank(status) && (status.equals("1") || status.equals("0"))) {
			modelEntityList = modelRepository.findByStatus(DeviceManagerUtil.convertStringToBoolean(status));
		} else {
			modelEntityList = modelRepository.findAll();
		}

		Long executionTime = System.currentTimeMillis() - startTime;
		LOGGER.logMessage("- deleteDeviceModel() ");
		LOGGER.logMethodEnd(executionTime);
		return RequestResponseGenerator.getGetDeviceModelListResponse(modelEntityList,
				Constants.Status.SUCCESS_RESULT_CODE, Constants.Status.SUCCESS_RESULT_DESCRIPTION, executionTime);
	}

	/**
	 * This method triggers document generation.
	 * 
	 * @param deviceModelEntity
	 */
	private void triggerDocumentGeneration(Model deviceModelEntity) {
		if (deviceModelEntity.getStatus()) {
			DocumentGeneratorRequest documentGeneratorRequest = new DocumentGeneratorRequest();
			documentGeneratorRequest.setDocName("GLOBALINSTALL");
			try {
				ResponseEntity<GenericResponse> response = documentClient.generateDocument(documentGeneratorRequest);
				LOGGER.logMessage(" Trigger the generation of Global Install document success, response code: {}",
						response.getBody().getResultCode());
			} catch (HttpClientErrorException exp) {
				LOGGER.logMessage(" Trigger the generation of Global Install document failed.", exp);
			}
		}
	}
	
	/**
	 * @param deviceModel
	 * @param record
	 */
	private void updateMaxStreamLimitPerQuality(UpdateDeviceModelRequest deviceModel, MaxStreamsPerQuality record) {
		ModelMaxStreamsAllowedPerQuality maxStreamsPerQuality = new ModelMaxStreamsAllowedPerQuality();
		ModelMaxStreamsAllowedPerQualityId maxStreamsPerQualityid = new ModelMaxStreamsAllowedPerQualityId(
				deviceModel.getDeviceModel(), record.getContentQuality());
		maxStreamsPerQuality.setId(maxStreamsPerQualityid);
		maxStreamsPerQuality.setMaxStreams(record.getStreamLimit().longValue());
		maxStreamsPerQualityRepository.save(maxStreamsPerQuality);
	}
}
