package com.accenture.avs.device.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelRequest;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.ModelRepository;

/**
 * This class contains methods to validate Device Manager business logic.
 * 
 * @author Singh.Saurabh
 *
 */
@Component
public class DeviceManagerValidator {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceManagerValidator.class);

	/** deviceRepository */
	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	ModelRepository modelRepository;
	
	/**
	 * This method validates the uniqueness of the Device Triplet(serial number,
	 * model and vendor). Throws error if not unique.
	 * 
	 * @param serialNumber
	 * @param modelName
	 * @param vendor
	 * @param deviceId
	 * 
	 */
	public void validateDeviceTripletUniqueness(String serialNumber, String modelName, String vendor, String deviceId) {
		long count = deviceRepository.findCountByTripletAndDeviceIdNotLike(serialNumber, modelName, vendor, deviceId);
		if (count > 0) {
			throw new DeviceManagerException(ErrorCode.TRIPLET_MUST_BE_UNIQUE);
		}
	}

	/**
	 * This method validates the uniqueness of the provided DRM ID. Throws error if
	 * not unique.
	 * 
	 * @param drmId
	 * @param deviceId
	 */
	public void validateDrmIdUniqueness(String drmId, String deviceId) {
		long count = deviceRepository.countByDrmIdAndDeviceIdNotLike(drmId, deviceId);
		if (count > 0) {
			throw new DeviceManagerException(ErrorCode.DRM_ID_MUST_BE_UNIQUE);
		}
	}

	/**
	 * This method validates the uniqueness of the provided device name for the
	 * given user and excluding same device. Throws error if not unique.
	 * 
	 * @param deviceName
	 * @param assignedToUserName
	 * @param deviceId
	 * 
	 */
	public void validateDeviceNameUniqueness(String deviceName, String assignedToUserName, String deviceId) {
		long count = deviceRepository.countByDeviceNameAndAssignedToUserNameAndDeviceIdNotLike(deviceName,
				assignedToUserName, deviceId);
		if (count > 0) {
			throw new DeviceManagerException(ErrorCode.DUPLICATE_DEVICE_NAME);
		}
	}
	
	/**
	 * database or not. Throws error based on operation.
	 * 
	 * @param deviceId
	 * 
	 */
	public void validateDeviceExistence(String deviceId) {
		long count = deviceRepository.countByDeviceId(deviceId);
		if (count > 0) {
			throw new DeviceManagerException(ErrorCode.DEVICE_ALREADY_EXISTS);
		}
	}

	/**
	 * This method validates vendor and model-name couple is unique. Throws
	 * error if found unique.
	 * 
	 * @param newModel
	 * @param oldModel
	 */
	public void validateDeviceModelUniqueness(UpdateDeviceModelRequest newModel, Model oldModel) {
		if (newModel.getMaxStreamsPerQuality() != null && !newModel.getMaxStreamsPerQuality().isEmpty()) {
			if (!oldModel.getVendor().equalsIgnoreCase(newModel.getVendor())) {
				validateModelCoupleUniqueness(newModel.getDeviceModel(), newModel.getVendor());
			}
		}
	}

	/**
	 * This method validates vendor and model-name couple is unique. Throws
	 * error if found unique.
	 * 
	 * @param newModel
	 */
	public void validateModelCoupleUniqueness(String modelName, String vendor) {
		long count = modelRepository.countByModelNameAndVendor(modelName, vendor);
		if (count > 0) {
			throw new DeviceManagerException(ErrorCode.COUPLE_MUST_BE_UNIQUE_FOR_MODEL);
		}
	}
	
	/**
	 * This method validates if model status can be updated to inactive if its
	 * assigned to any device
	 * 
	 * @param modelEntity
	 */
	public void validateModelStatusUpdate(Model modelEntity) {		
		if (modelEntity.getStatus()) {
			long count = deviceRepository.findCountByModel(modelEntity.getModelName());
			if (count > 0) {
				throw new DeviceManagerException(ErrorCode.DEVICE_MODEL_NOT_UPDATE_ALLOWED);
			}
		}
	}
	
	/**
	 * This method validates model-name is unique. Throws
	 * error if found.
	 * 
	 * @param modelName
	 */
	public void validateModelUniqueness(String modelName) {
		long count = modelRepository.countByModelName(modelName);
		if (count > 0) {
			throw new DeviceManagerException(ErrorCode.INVALID_MODEL);
		}
	}
	
	/**
	 * This method validates model exists in database or not.
	 * Throws error if not found.
	 * 
	 * @param oldModel
	 */
	public void validateDeviceModelExistance(Model oldModel) {
		if(oldModel==null) {
			throw new DeviceManagerException(ErrorCode.INVALID_MODEL);
		}
	}
	
	/**
	 * This method validates model active or not.
	 * Throws error if active found.
	 * 
	 * @param status
	 */
	public void checkModelStatusActive(Boolean status) {
		if(status == true) {
			throw new DeviceManagerException(ErrorCode.DEVICE_MODEL_ACTIVE);
		}
	}
	
	/**
	 * This method validates model associated to device.
	 * Throws error if found count > 0.
	 * 
	 * @param status
	 */
	public void checkModelAssociatedToDevice(String modelName) {
		long count = deviceRepository.findModelToAssocitedDevice(modelName);
		if (count > 0) {
			throw new DeviceManagerException(ErrorCode.DEVICE_MODEL_ASSOCIATED_TO_DEVICE);
		}
	}
	
}
