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

package com.accenture.avs.device.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.client.GlobalConfigurationClient;
import com.accenture.avs.device.client.ResourceManagerClient;
import com.accenture.avs.device.client.SubscriberClient;
import com.accenture.avs.device.entity.ConnectionMode;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceAssignedResource;
import com.accenture.avs.device.entity.DeviceMaxBWAllowedPerQuality;
import com.accenture.avs.device.entity.Language;
import com.accenture.avs.device.entity.Location;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.entity.Resource;
import com.accenture.avs.device.entity.Subscriber;
import com.accenture.avs.device.entity.SubscriberDeviceLimit;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.enums.SearchOperator;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.AssignedResources;
import com.accenture.avs.device.json.object.devicemanager.DeviceList;
import com.accenture.avs.device.json.object.devicemanager.DeviceListDto;
import com.accenture.avs.device.json.object.devicemanager.GetDeviceListResponse;
import com.accenture.avs.device.json.object.devicemanager.MaxSTBsPerContentQuality;
import com.accenture.avs.device.json.object.devicemanager.STBRegistration;
import com.accenture.avs.device.json.object.devicemanager.SubscriberDetail;
import com.accenture.avs.device.json.object.devicemanager.Subscribers;
import com.accenture.avs.device.json.object.devicemanager.UpdateGlobalData;
import com.accenture.avs.device.json.object.resourcemanager.AssignedDeviceProfile;
import com.accenture.avs.device.json.object.resourcemanager.GetProfileReq;
import com.accenture.avs.device.json.object.resourcemanager.ResSubscriber;
import com.accenture.avs.device.json.object.resourcemanager.STBProfile;
import com.accenture.avs.device.json.object.resourcemanager.TVQualityProfile;
import com.accenture.avs.device.repository.ConnectionModeRepository;
import com.accenture.avs.device.repository.CustomDeviceRepository;
import com.accenture.avs.device.repository.DeviceMaxBWAllowedPerQualityRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.LanguageRepository;
import com.accenture.avs.device.repository.LocationRepository;
import com.accenture.avs.device.repository.ModelRepository;
import com.accenture.avs.device.repository.ResourcesRepository;
import com.accenture.avs.device.repository.SubscriberDeviceLimitRepository;
import com.accenture.avs.device.repository.SubscriberRepository;
import com.accenture.avs.device.service.DeviceServiceHelper;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.DeviceProfileDto;
import com.accenture.avs.device.util.EntityObjectGenerator;
import com.accenture.avs.device.util.RequestResponseGenerator;
import com.accenture.avs.device.util.SearchFilter;
import com.accenture.avs.device.util.validation.JsonRequestValidator;
import com.accenture.avs.device.util.validation.JsonSchema;
import com.accenture.avs.ossbss.config.ConfigurationProvider;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;
import com.accenture.avs.ossbss.request.ClientBuilder;

/**
 * This is a Helper Class for DeviceServiceBeanImpl.
 * 
 * @author Singh.Saurabh
 *
 */
@Service
public class DeviceServiceHelperImpl implements DeviceServiceHelper {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceServiceHelperImpl.class);

	/** modelRepository */
	@Autowired
	private ModelRepository modelRepository;

	/** deviceRepository */
	@Autowired
	private DeviceRepository deviceRepository;

	/** subscriberRepository */
	@Autowired
	private SubscriberRepository subscriberRepository;

	/** locationsRepository */
	@Autowired
	private LocationRepository locationRepository;

	/** languageRepository */
	@Autowired
	private LanguageRepository languageRepository;

	/** subscriberDeviceLimitRepository */
	@Autowired
	private SubscriberDeviceLimitRepository subscriberDeviceLimitRepository;

	/** deviceMaxBwAllowedPerQualityRepository */
	@Autowired
	private DeviceMaxBWAllowedPerQualityRepository deviceMaxBwAllowedPerQualityRepository;

	/** resourcesRepository */
	@Autowired
	private ResourcesRepository resourcesRepository;

	/** connectionModeRepository */
	@Autowired
	private ConnectionModeRepository connectionModeRepository;

	/** GlobalConfigurationClient */
	@Autowired
	private GlobalConfigurationClient globalConfigurationClient;

	/** resourceManagerClient */
	@Autowired
	private ResourceManagerClient resourceManagerClient;

	@Autowired
	private SubscriberClient subscribersClient;

	/** jsonRequestValidator */
	@Autowired
	private JsonRequestValidator jsonRequestValidator;

	/** customDeviceRepository */
	@Autowired
	private ConfigurationProvider configurationProvider;
	
	/** customDeviceRepository */
	@Autowired
	private CustomDeviceRepository customDeviceRepository;

	/** notificationRetries */
	@Value("${failed.notification.retrials:0}")
	private Integer notificationRetries;

	/** BRIDGEDMODEID */
	private static final Long BRIDGEDMODEID = 1L;

	/** IMPLICITNATMODEID */
	private static final Long IMPLICITNATMODEID = 2L;

	/** UPNPNAPTMODEID */
	private static final Long UPNPNAPTMODEID = 3L;

	/**
	 * This method finds the device model in database. If found, then returns, else
	 * it throw error.
	 * 
	 * @param deviceModelName
	 * @param checkIsActive
	 * 
	 * @return
	 */
	@Override
	public Model getDeviceModel(String deviceModelName, boolean checkIsActive) {
		LOGGER.logMessage("Device Model : " + deviceModelName);

		if (DeviceManagerUtil.checkNullObject(deviceModelName)) {
			return null;
		}

		Model deviceModel = modelRepository.findOne(deviceModelName);
		if (DeviceManagerUtil.checkNullObject(deviceModel) || (checkIsActive && !deviceModel.getStatus())) {
			throw new DeviceManagerException(ErrorCode.INVALID_MODEL);
		}

		return deviceModel;
	}
	
	/**
	 * This method is only used for CreateAndAssignDevice. It allows the
	 * HardwareVersion to commit in the database even if the CreateAndAssignDevice
	 * request fails.
	 * 
	 * @param hwVersionName
	 * @return HardwareVersion
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Model getHardwareVersionAndSave(String hwVersionName) {
		return getDeviceModel(hwVersionName, Boolean.TRUE);
	}

	/**
	 * This method finds the Subscriber in database. If found, then returns,
	 * else it calls AVS Mediator to getSubscriber and save received Subscriber
	 * Details in database and returns.
	 * 
	 * @param accountNumber
	 * @return Subscriber
	 */
	@Override
	public Subscriber getSubscriber(String accountNumber) {
		if (StringUtils.isEmpty(accountNumber.trim())) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_FOUND, "Incorrect Account Number Provided");
		}
		
		Subscriber subscriber = subscriberRepository.findByAccountNumber(accountNumber);
		if (DeviceManagerUtil.checkNullObject(subscriber)) {
			LOGGER.logMessage("Subscriber not present in database, Calling AVS Mediator :: AccountNumber=" + accountNumber);
			// Call AVS Mediator "Get Subscriber Details"
			ResponseEntity<Subscribers> subscribersResponse;
			try {
				subscribersResponse = subscribersClient.getSubscriberDetails(accountNumber);
			} catch (Exception exp) {
				throw new DeviceManagerException(ErrorCode.INTERNAL_COMMUNICATION_FAILED,
						"Unable to communicate with AVS Mediator :: getSubscriber", exp);
			}

			SubscriberDetail subscriberDetail = validateSubscriber(subscribersResponse);
			// save newly recieved subscriber in database
			subscriber = subscriberRepository.save(EntityObjectGenerator.getSubscriberEntity(subscriberDetail));

			List<SubscriberDeviceLimit> subscriberDeviceLimits = new ArrayList<SubscriberDeviceLimit>();
			for (MaxSTBsPerContentQuality maxDeviceLimt : subscriberDetail.getMaxSTBsPerContentQuality()) {
				subscriberDeviceLimits.add(EntityObjectGenerator.getSubscriberDeviceLimitEntity(subscriber.getSubscriberId(),
						maxDeviceLimt.getContentQuality(), maxDeviceLimt.getSTBLimit().longValue()));
			}
			subscriberDeviceLimitRepository.save(subscriberDeviceLimits);
			LOGGER.logMessage("Subscriber saved sucessfully");
		}
		return subscriber;
	}

	/**
	 * This method calls AVS Mediator to get the DeviceProfile for the
	 * Subscriber.
	 * 
	 * @param assignedToUserName
	 * 
	 * @return StbProfile
	 */
	@Override
	public STBProfile getDeviceProfile(String assignedToUserName, List<Device> assignedDevicesList) {

		// Call RM "Get Device Profiles"
		GetProfileReq getProfileReq = RequestResponseGenerator.getDeviceProfileRequest(assignedToUserName, assignedDevicesList);

		LOGGER.logMessage("Calling Resource Manager :: getDeviceProfile for Subscriber AccountNumber="+assignedToUserName);
		ResponseEntity<STBProfile> deviceProfileResponse;
		try {
			deviceProfileResponse = resourceManagerClient.getDeviceProfile(getProfileReq, assignedToUserName);
		} catch (Exception exp) {
			throw new DeviceManagerException(ErrorCode.GENERIC_ERROR, "Call to Resource Manager Failed", exp);
		}
		return validateDeviceProfile(deviceProfileResponse);
	}

	/**
	 * This method calculates the connection mode of the Device.
	 * 
	 * @param supportedModes
	 * @param ipAddress
	 * @param extIpAddress
	 * @return String
	 */
	@Override
	public ConnectionMode getConnectionMode(String supportedModes, String ipAddress, String extIpAddress) {

		LOGGER.logMessage("supportedModes=" + supportedModes + ", InternalIpAddress=" + ipAddress + ", ExternalIpAddress="
				+ extIpAddress);

		Long assinedConnectionModeId = 0L;
		List<ConnectionMode> connectionModes = connectionModeRepository
				.findByStatusLike(IdentificationType.statusEnabled.getProperty());
		Map<Long, ConnectionMode> connectionModeMap = new HashMap<Long, ConnectionMode>();
		for (ConnectionMode connectionMode : connectionModes) {
			connectionModeMap.put(connectionMode.getId(), connectionMode);
		}
		Map<Long, String> connectionModeIdNameMap = getConnectionModeIdNameMap(connectionModeMap);

		if (ipAddress.equals(extIpAddress)) {
			if (supportedModes.contains(connectionModeIdNameMap.get(BRIDGEDMODEID))) {
				assinedConnectionModeId = BRIDGEDMODEID;
			}
		} else {
			if (supportedModes.contains(connectionModeIdNameMap.get(IMPLICITNATMODEID))) {
				assinedConnectionModeId = IMPLICITNATMODEID;
			} else if (supportedModes.contains(connectionModeIdNameMap.get(UPNPNAPTMODEID))) {
				assinedConnectionModeId = UPNPNAPTMODEID;
			}
		}

		// If no connection mode could be assigned throw exception
		if (assinedConnectionModeId.equals(0L)) {
			throw new DeviceManagerException(ErrorCode.NO_DEVICE_CONNECTION_MODE, "Unable to assign connection mode");
		}
		return connectionModeMap.get(assinedConnectionModeId);
	}
	
	/**
	 * This method creates a map of connection mode id and name.
	 * 
	 * @param availableConnectionModeMap
	 * @return
	 */
	private Map<Long, String> getConnectionModeIdNameMap(Map<Long, ConnectionMode> availableConnectionModeMap) {
		String none = "None";
		Map<Long, String> connectionModeIdNameMap = new HashMap<Long, String>();
		for (int i = 1; i < 4; i++) {
			connectionModeIdNameMap.put(Long.valueOf(i),
					DeviceManagerUtil.checkNullObject(availableConnectionModeMap.get(Long.valueOf(i))) ? none
							: availableConnectionModeMap.get(Long.valueOf(i)).getName());
		}
		return connectionModeIdNameMap;
	}
	
	/**
	 * This method returns Device according to provided value
	 * 
	 * @param macAddress
	 * @param equipmentId
	 * @return Device
	 */
	@Override
	public Device getDevice(String macAddress, Integer equipmentId) {
		Device device = null;
		if (DeviceManagerUtil.checkNullObject(equipmentId)) {
			device = deviceRepository.findByDeviceId(macAddress);
		} else {
			device = deviceRepository.findOne(equipmentId.longValue());
		}
		return device;
	}

	/**
	 * This method returns Device according to provided device id
	 * 
	 * @param deviceId
	 * @return
	 */
	@Override
	public Device getDevice(String deviceId) {
		Device device = deviceRepository.findByDeviceId(deviceId);
		if (DeviceManagerUtil.checkNullObject(device)) {
			throw new DeviceManagerException(ErrorCode.DEVICE_NOT_FOUND);
		}
		return device;
	}
	
	/**
	 * This method performs following operations:- 
	 * 1. Call ResourceManager to "Get Device Profiles" 
	 * 2. Update Device Profile in database 
	 * 
	 * @param assignedToUserName
	 * @param device
	 * @param isUnassigned
	 * 
	 * @return
	 * 
	 */
	@Override
	public List<Long> calculateDeviceProfile(String assignedToUserName, Device device, boolean isUnassigned) {
		
		List<Device> assignedDevicesList = deviceRepository.findByAssignedToUserName(assignedToUserName);
		
		// Call RM "Get Device Profiles"
		STBProfile deviceProfile = getDeviceProfile(assignedToUserName, assignedDevicesList);

		// Update Device Profile in DB
		ResSubscriber resSubscriber = deviceProfile.getResultObject().get(0).getResSubscriber();

		// Save new Device Profile information in database
		List<DeviceMaxBWAllowedPerQuality> toUpdateMaxBwAllowedPerQualityList = new ArrayList<DeviceMaxBWAllowedPerQuality>();
		List<DeviceMaxBWAllowedPerQuality> toDeleteMaxBwAllowedPerQualityList = new ArrayList<DeviceMaxBWAllowedPerQuality>();
		List<Long> equipmentIdListForNotification = new ArrayList<Long>();
		Map<Long, DeviceProfileDto> deviceProfilesUpdatedMap = new HashMap<Long, DeviceProfileDto>();
		
		filterDataToInsertAndDelete(resSubscriber.getAssignedDeviceProfile(), deviceProfilesUpdatedMap,
				toUpdateMaxBwAllowedPerQualityList, toDeleteMaxBwAllowedPerQualityList, equipmentIdListForNotification);

		// Updating the device profiles
		for (Device devicesToUpdate : assignedDevicesList) {
			for (Entry<Long, DeviceProfileDto> entry : deviceProfilesUpdatedMap.entrySet()) {
				if (entry.getKey() == devicesToUpdate.getId()) {
					devicesToUpdate.setDeviceProfile(entry.getValue().getDeviceProfile());
					devicesToUpdate.setDeviceProfileBandwidth(entry.getValue().getDeviceProfileBandwidth());
					devicesToUpdate.setQoeBandwidth(entry.getValue().getQoeBandwidth());
				}
			}
		}
		
		// When Device is unassigned
		if (isUnassigned) {
			LOGGER.logMessage("Deleting Device Profiles for Unassigned Device :: Id={}", device.getId());
			device.setDeviceProfile(null);
			device.setDeviceProfileBandwidth(null);
			device.setQoeBandwidth(null);
			deviceMaxBwAllowedPerQualityRepository.deleteById(device.getId());
		}

		// Update Device Max Bandwidth Allowed
		if (!deviceProfilesUpdatedMap.isEmpty()) {
			LOGGER.logMessage("Updating Device Profiles");
			// Delete old profiles
			deviceMaxBwAllowedPerQualityRepository.delete(toDeleteMaxBwAllowedPerQualityList);
			// Save new profiles
			deviceMaxBwAllowedPerQualityRepository.save(toUpdateMaxBwAllowedPerQualityList);
		}

		LOGGER.logMessage("Device Profile calculation successful for Subscriber={}", assignedToUserName);
		return equipmentIdListForNotification;
	}
	
	/**
	 * This method filters out data from AssignedDeviceProfile.
	 * 
	 * @param assignedDeviceProfileList
	 * @param deviceProfilesUpdatedMap
	 * @param toUpdateMaxBwAllowedPerQualityList
	 * @param toDeleteMaxBwAllowedPerQualityList
	 * @param equipmentIdListForNotification
	 */
	private void filterDataToInsertAndDelete(List<AssignedDeviceProfile> assignedDeviceProfileList,
			Map<Long, DeviceProfileDto> deviceProfilesUpdatedMap,
			List<DeviceMaxBWAllowedPerQuality> toUpdateMaxBwAllowedPerQualityList,
			List<DeviceMaxBWAllowedPerQuality> toDeleteMaxBwAllowedPerQualityList,
			List<Long> equipmentIdListForNotification) {
		for (AssignedDeviceProfile assignedDeviceProfile : assignedDeviceProfileList) {
			if (IdentificationType.assignedProfileOff.getProperty()
					.equals(assignedDeviceProfile.getAssignedProfile())) {
				deviceProfilesUpdatedMap.put(Long.parseLong(assignedDeviceProfile.getEquipmentID()),
						new DeviceProfileDto(Long.parseLong(assignedDeviceProfile.getEquipmentID()), null, null, null));
			} else {
				deviceProfilesUpdatedMap.put(Long.parseLong(assignedDeviceProfile.getEquipmentID()),
						new DeviceProfileDto(Long.parseLong(assignedDeviceProfile.getEquipmentID()),
								assignedDeviceProfile.getAssignedProfile(),
								assignedDeviceProfile.getAssignedBW().longValue(),
								assignedDeviceProfile.getAssignedVQEOverheadBW().longValue()));

				List<DeviceMaxBWAllowedPerQuality> existingMaxBWPerQualityList = deviceMaxBwAllowedPerQualityRepository
						.findById(Long.parseLong(assignedDeviceProfile.getEquipmentID()));
				toDeleteMaxBwAllowedPerQualityList.addAll(existingMaxBWPerQualityList);

				for (TVQualityProfile tvQualityProfile : assignedDeviceProfile.getTVQualityProfile()) {
					DeviceMaxBWAllowedPerQuality deviceMaxBWAllowedPerQuality = EntityObjectGenerator
							.getStbMaxBwAllowedPerQualityEntity(Long.parseLong(assignedDeviceProfile.getEquipmentID()),
									tvQualityProfile.getTvQualityInterest(),
									tvQualityProfile.getTvQualityMaxBW().longValue());

					toUpdateMaxBwAllowedPerQualityList.add(deviceMaxBWAllowedPerQuality);
					if (existingMaxBWPerQualityList.contains(deviceMaxBWAllowedPerQuality)) {
						toDeleteMaxBwAllowedPerQualityList.remove(deviceMaxBWAllowedPerQuality);
					}
				}
			}
			equipmentIdListForNotification.add(Long.parseLong(assignedDeviceProfile.getEquipmentID()));
			LOGGER.logMessage("EquipmentId=" + assignedDeviceProfile.getEquipmentID() + ", AssignedProfile="
					+ assignedDeviceProfile.getAssignedProfile());
		}
	}
	
	/**
	 * This method updates internal and external ip of the Device according to the
	 * assigned connection mode.
	 * 
	 * @param device
	 * @param ipAddress
	 * @param extIpAddress
	 */
	@Override
	public void updateInternalExternalIpAddress(Device device, String ipAddress, String extIpAddress) {

		device.setInternalIpAddress(ipAddress);
		device.setExternalIpAddress(extIpAddress);

		//List<Device> deviceList = deviceRepository.findByExternalIpAddress(extIpAddress);
		List<Device> filteredDeviceList = new ArrayList<>();
/*		if (device.getConnectionMode().getId().equals(1L)) {
			// filtering out current device
			for (Device otherDevice : deviceList) {
				if (!otherDevice.getDeviceId().equals(device.getDeviceId())) {
					filteredDeviceList.add(otherDevice);
				}
			}
		} else {
			// filtering out devices assigned to same subscriber
			for (Device otherDevice : deviceList) {
				if (DeviceManagerUtil.checkNullObject(otherDevice.getAssignedToSubscriber()) || !otherDevice.getAssignedToSubscriber()
						.getSubscriberId().equals(device.getAssignedToSubscriber().getSubscriberId())) {
					filteredDeviceList.add(otherDevice);
				}
			}
		}*/

		if (!filteredDeviceList.isEmpty()) {
			List<Long> equipmentIds = new ArrayList<>();
			// internal and external ips blanked
			for (Device filterDevice : filteredDeviceList) {
				equipmentIds.add(filterDevice.getId());
				filterDevice.setInternalIpAddress("");
				filterDevice.setExternalIpAddress("");
			}
			LOGGER.logMessage("External Ip already exists, blanking ips for EquipmentIds=" + equipmentIds);
		}
	}

	/**
	 * This method sends notification to OSS-BSS client.
	 * 
	 * @param deviceRegistration
	 * @param extIpAddress
	 * @param connectionMode
	 */
	@Override
	public void sendNotificationToOssBssClient(STBRegistration deviceRegistration, String extIpAddress,
			String connectionMode) {
		
		LOGGER.logMessage("Sending notification to CRM Server for AccountNumber=" + deviceRegistration.getAccountNumber());
		String requestName = "register-device";
		
		deviceRegistration.setPassword(DeviceManagerUtil.getStringValue(deviceRegistration.getPassword()));
		deviceRegistration.setMasterPIN(
				DeviceManagerUtil.checkNullObject(deviceRegistration.getMasterPIN()) ? 0 : deviceRegistration.getMasterPIN());
		deviceRegistration.setSoftwareVersion(DeviceManagerUtil.getStringValue(deviceRegistration.getSoftwareVersion()));
		String assignedConnectionMode = DeviceManagerUtil.getStringValue(connectionMode);
		
		Map<String, Object> autoConfigMap = new HashMap<>();
		autoConfigMap.put("device", deviceRegistration);
		autoConfigMap.put("extIpAddress", extIpAddress);
		autoConfigMap.put("assignedConnectionMode", assignedConnectionMode);

		try {
			ClientBuilder.create(configurationProvider, requestName).build().exchange(autoConfigMap);
		} catch (OSSBSSClientException exception) {
			throw new DeviceManagerException(ErrorCode.CRM_COMMUNICATION_FAILED,
					"CRM Communication failed for AccountNumber=" + deviceRegistration.getAccountNumber(), exception);
		}
		LOGGER.logMessage("Notification to CRM Server Successful");
	}

	/**
	 * This method checks if the Global data is Synced in database. If not and
	 * then call AVS Mediator to getGlobalData and saves in database.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean syncGlobalData() {

		boolean isGlobalDataUpdated = Boolean.FALSE;
		String logForCallingAVSMediator = "Calling AVS Mediator :: getDeviceGlobalData";

		// Check in DB
		long locationCount = locationRepository.count();
		long languageCount = languageRepository.count();

		List<String> requiredDataList = new ArrayList<String>();
		if (languageCount == 0) {
			requiredDataList.add("Languages");
		}

		if (locationCount == 0) {
			requiredDataList.add("Locations");
		}
		String requiredData = String.join(",", requiredDataList);

		// Call AVS Mediator "Get Global Data"
		ResponseEntity<UpdateGlobalData> globalDataResponse;
		try {
			if (languageCount == 0 || locationCount == 0) {
				LOGGER.logMessage(logForCallingAVSMediator);
				globalDataResponse = globalConfigurationClient.getDeviceGlobalData(requiredData);
			} else {
				LOGGER.logMessage("STB Global Data in Sync");
				return Boolean.TRUE;
			}
		} catch (Exception exp) {
			throw new DeviceManagerException(ErrorCode.INTERNAL_COMMUNICATION_FAILED,
					"Unable to communicate with AVS Mediator :: getSTBGlobalData", exp);
		}

		if (globalDataResponse.getStatusCode().equals(HttpStatus.OK)) {
			saveGlobalData(globalDataResponse);
			isGlobalDataUpdated = Boolean.TRUE;
			LOGGER.logMessage("STB Global Data updated successfully");
		}
		return isGlobalDataUpdated;
	}

	/**
	 * This method save the received GlobalData in the database.
	 * 
	 * @param globalDataResponse
	 */
	private void saveGlobalData(ResponseEntity<UpdateGlobalData> globalDataResponse) {
		UpdateGlobalData updateGlobalData = globalDataResponse.getBody();

		List<com.accenture.avs.device.json.object.devicemanager.Language> languages = updateGlobalData.getGlobalData()
				.getLanguages();
		if (!DeviceManagerUtil.checkNullObject(languages)) {
			saveLanguagesData(languages);
		}

		List<com.accenture.avs.device.json.object.devicemanager.Location> locations = updateGlobalData.getGlobalData()
				.getLocations();
		if (!DeviceManagerUtil.checkNullObject(locations)) {
			saveLocationsData(locations);
		}
	}

	/**
	 * This method saves the Languages data.
	 * 
	 * @param languages
	 */
	private void saveLanguagesData(List<com.accenture.avs.device.json.object.devicemanager.Language> languages) {
		List<Language> languageList = new ArrayList<Language>();
		for (com.accenture.avs.device.json.object.devicemanager.Language language : languages) {
			languageList.add(EntityObjectGenerator.getLanguageEntity(language.getDisplayName(), language.getType(),
					language.getAvailableForUI(), language.getAvailableForAudio()));
		}
		if (!languageList.isEmpty()) {
			languageRepository.deleteAll();
			languageRepository.save(languageList);
		}
	}

	/**
	 * This method saves the Locations data.
	 * 
	 * @param updateGlobalData
	 */
	private void saveLocationsData(List<com.accenture.avs.device.json.object.devicemanager.Location> locations) {
		List<Location> locationList = new ArrayList<Location>();
		for (com.accenture.avs.device.json.object.devicemanager.Location location : locations) {
			locationList.add(EntityObjectGenerator.getLocationEntity(location.getID().longValue(), location.getName(),
					location.getParentID().longValue(), location.getTVRegionID().longValue()));
		}
		if (!locationList.isEmpty()) {
			locationRepository.deleteAll();
			locationRepository.save(locationList);
		}
	}

	/**
	 * This method calls validator to validate request parameters
	 * 
	 * @param request
	 * @param jsonFileName
	 */
	@Override
	public <T> void validateRequestParameters(T request, String jsonFileName) {
		String requestValidationResult = jsonRequestValidator.validate(request, jsonFileName,
				JsonSchema.getSchemaFolderPath());
		if (!requestValidationResult.isEmpty()) {
			throw new DeviceManagerException(ErrorCode.JSON_PARSING_FAILED, requestValidationResult);
		}
	}

	/**
	 * This method validates if Device assigned Resources are valid or not. If valid,
	 * then saves them.
	 * 
	 * @param createSTBRequest
	 * @param device
	 */
	@Override
	public void validateAndSaveDeviceAssignedResources(
			com.accenture.avs.device.json.object.devicemanager.SetTopBox createSTBRequest, Device device) {
		// Resource Validation
		List<String> resourceNameList = new ArrayList<String>();
		for (AssignedResources assignedResource : createSTBRequest.getAssignedResources()) {
			resourceNameList.add(assignedResource.getName());
		}

		List<Resource> resourceList = resourcesRepository.findByName(resourceNameList);
		if (resourceNameList.size() != resourceList.size()) {
			throw new DeviceManagerException(ErrorCode.INVALID_DATA, "Invalid Device Assigned Resources");
		}

		Map<String, Long> resourceMap = new HashMap<String, Long>();
		for (Resource resource : resourceList) {
			resourceMap.put(resource.getId().getName(), resource.getId().getId());
		}

		// Save Assigned Resources
		List<DeviceAssignedResource> deviceAssignedResourcesList = new ArrayList<DeviceAssignedResource>();
		for (AssignedResources assignedResource : createSTBRequest.getAssignedResources()) {
			deviceAssignedResourcesList.add(EntityObjectGenerator.getDeviceAssignedResourceEntity(device.getId(),
					resourceMap.get(assignedResource.getName()), assignedResource.getAllocation()));
		}
		LOGGER.logMessage("Device Assigned Resources saved Sucessfully");
	}

	/**
	 * This generates a unique device name for the Subscriber. The default name will
	 * be DEVICE_X where X shall be replaced incrementally in such way a subscriber
	 * shall not have two devices with same name
	 * 
	 * @param assignedToUserName
	 * @return
	 */
	@Override
	public String getDeviceName(String assignedToUserName) {
		String uniqueDeviceName = "DEVICE_";

		List<String> deviceNameList = deviceRepository
				.findDeviceNamesByDeviceNameAndAssignedToUserNameOrderByDeviceNameDesc(uniqueDeviceName,
						assignedToUserName);

		if (deviceNameList.isEmpty()) {
			return uniqueDeviceName + "1";
		} else {
			Long counter = Long.parseLong(deviceNameList.get(0).substring(8));
			uniqueDeviceName = uniqueDeviceName + (counter + 1);
		}
		return uniqueDeviceName;
	}

	/**
	 * This method validates and saves the UDF Rules
	 * 
	 * @param setTopBox
	 * @param stbUdfList
	 */
//	@Override
//	public List<StbUdf> validateAndSaveStbUdfRules(SetTopBox setTopBox, List<SetTopBoxUDF> stbUdfList) {
//		udfHelper.validateUdfRule(stbUdfList, setTopBox.getEquipmentId());
//		customUdfRepository.deteleStbUdfByEquipmentId(setTopBox.getEquipmentId());
//
//		List<StbUdf> stbUdfEntityList = new ArrayList<>();
//		for (SetTopBoxUDF stbUdf : stbUdfList) {
//			StbUdf stbUdfEntity = new StbUdf();
//			stbUdfEntity.setId(new StbUdfId(setTopBox.getEquipmentId(), stbUdf.getName()));
//			stbUdfEntity.setUdfValue(stbUdf.getValue());
//			stbUdfEntityList.add(stbUdfEntity);
//		}
//		if(!stbUdfEntityList.isEmpty()){
//			setTopBox.setStbUdfs(stbUdfEntityList);
//		}
//		return stbUdfRepository.save(stbUdfEntityList);
//	}
	
	/**
	 * This method validates if the STB Auto registration is allowed or if it is
	 * already assigned.
	 * 
	 * @param device
	 * @param hardwareVersion
	 * @param deviceRegistration
	 * @return SetTopBox
	 */
	@Override
	public Device validateAutoRegistrationAndDeviceAssignment(Device device,
			Model hardwareVersion, STBRegistration deviceRegistration) {
		if (DeviceManagerUtil.checkNullObject(device)) {
			if (!DeviceManagerUtil.checkNullObject(hardwareVersion) && hardwareVersion.getDisableStbAutoRegistration()) {
				throw new DeviceManagerException(ErrorCode.AUTO_REGISTRATION_NOT_ALLOWED, "Auto-Registration not allowed :: "+hardwareVersion.getModelName());
			}
		} else {
			// Device already Assigned Validation
/*			if (!DeviceManagerUtil.checkNullObject(device.getAssignedToSubscriber())) {
				if (deviceRegistration.getAccountNumber().equals(device.getAssignedToSubscriber().getAccountNumber())) {
					return device;
				} else {
					throw new DeviceManagerException(ErrorCode.DEVICE_ALREADY_ASSIGNED,
							"Device already assigned to another subscriber :: MacAddress=" + device.getDeviceId());
				}
			}*/
		}
		return null;
	}

	/**
	 * This method validates the Subscriber recieved from the AVS Mediator.
	 * 
	 * @param subscribersResponse
	 * @return SubscriberUpdate
	 */
	private SubscriberDetail validateSubscriber(ResponseEntity<Subscribers> subscribersResponse) {
		if (!subscribersResponse.getStatusCode().equals(HttpStatus.OK)) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_FOUND,
					"Error Response from AVS Mediator :: HTTP Status Code=" + subscribersResponse.getStatusCode());
		}
		if (subscribersResponse.getBody().getSubscriberDetails().size() == 0) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_FOUND, "No Subscriber recieved from AVS Mediator");
		}
		return subscribersResponse.getBody().getSubscriberDetails().get(0);
	}

	/**
	 * This method validates the DeviceProfile received from the AVS Mediator.
	 * 
	 * @param deviceProfileResponse
	 * @return
	 */
	private STBProfile validateDeviceProfile(ResponseEntity<STBProfile> deviceProfileResponse) {
		if (!deviceProfileResponse.getStatusCode().equals(HttpStatus.OK)) {
			throw new DeviceManagerException(ErrorCode.GENERIC_ERROR,
					"Error Response from Resource Manager :: HTTP Status Code=" + deviceProfileResponse.getStatusCode());
		}

		STBProfile deviceProfile = deviceProfileResponse.getBody();
		if (DeviceManagerUtil.checkNullorBlankString(deviceProfile.getResultCode())) {
			String resultCode = deviceProfile.getResultObject().get(0).getResultCode();
			String resultDescription = deviceProfile.getResultObject().get(0).getResultDescription();
			if (resultCode.equals(IdentificationType.genericFailureResultNotOk.getProperty())) {
				throw new DeviceManagerException(ErrorCode.GENERIC_ERROR,
						"Error Response from Resource Manager :: ResultCode=" + resultCode + ", ResultDescription="
								+ resultDescription);
			}
		} else {
			throw new DeviceManagerException(ErrorCode.GENERIC_ERROR,
					"Error Response from Resource Manager :: ResultCode=" + deviceProfile.getResultCode()
							+ ", ResultDescription=" + deviceProfile.getResultDescription());
		}

		return deviceProfile;
	}

	/**
	 * 
	 * @param searchBy
	 * @param searchValue
	 * @param searchOperation
	 * @param sortBy
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public GetDeviceListResponse getDeviceList(String searchBy, String searchValue, String searchOperation, String sortBy,
			Integer startIndex, Integer pageSize) {
		long startTime = System.currentTimeMillis();
		
		SearchFilter searchFilter = new SearchFilter();
		searchFilter.setSearchBy(searchBy);
		searchFilter.setSearchValue(searchValue);
		searchFilter.setSearchOperation(searchOperation == null? null : SearchOperator.getOperation(searchOperation));
		searchFilter.setSortBy(sortBy);
		searchFilter.setStartIndex(startIndex);
		searchFilter.setPageSize(pageSize);
		
		List<Device> devices = customDeviceRepository.search(searchFilter);
		GetDeviceListResponse response = new GetDeviceListResponse();
		DeviceList devicesList = new DeviceList();
		devicesList.setTotalResults(devices.size());
		for(Device device : devices){			
			DeviceListDto deviceListDto =  new DeviceListDto();
			deviceListDto.setDeviceId(device.getDeviceId());
			deviceListDto.setSerialNumber(device.getSerialNumber());
			deviceListDto.setDrmId(device.getDrmId());
			deviceListDto.setUserName(device.getAssignedToUserName());
			deviceListDto.setIpAddress(device.getInternalIpAddress());
			deviceListDto.setAssignmentStatus(device.getAssignmentStatus());
			deviceListDto.setModel(device.getModel().getModelName());
			deviceListDto.setVendor(device.getVendor());
			deviceListDto.setDeviceType(device.getDeviceType());
			deviceListDto.setPlatform(device.getPlatform());
			deviceListDto.setSoftwareVersion(device.getSoftwareVersion());
			
			devicesList.getDeviceList().add(deviceListDto);
		}
		response.setResultCode(IdentificationType.genericSuccessResultCode.getProperty());
		response.setResultDescription(IdentificationType.genericSuccessResultDescription.getProperty());
		response.setResultObj(devicesList);		
		LOGGER.logMessage("getDeviceList with total Devices : "+devices.size());
		LOGGER.logMethodEnd(System.currentTimeMillis() - startTime);
		return response;
	}

}
