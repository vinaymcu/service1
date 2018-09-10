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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.entity.ConnectionMode;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceProperty;
import com.accenture.avs.device.entity.DevicePropertyId;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.json.object.devicemanager.Property;
import com.accenture.avs.device.json.object.devicemanager.STBPortMappings;
import com.accenture.avs.device.json.object.devicemanager.STBProperties;
import com.accenture.avs.device.repository.ConnectionModeRepository;
import com.accenture.avs.device.repository.DevicePropertyRepository;
import com.accenture.avs.device.repository.DeviceServicePortMappingRepository;
import com.accenture.avs.device.service.DevicePropertiesService;
import com.accenture.avs.device.service.DevicePropertiesServiceHelper;
import com.accenture.avs.device.service.DeviceServiceHelper;

/**
 * This class will perform Device Properties Operations like (SETPROPERTIES,
 * GETPROPERTIES AND SETSTBSERVICEPORTMAPPINGS)
 * 
 * @author Singh.Saurabh
 *
 */
@Service
public class DevicePropertiesServiceImpl implements DevicePropertiesService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DevicePropertiesServiceImpl.class);

	/** devicePropertyRepository */
	@Autowired
	private DevicePropertyRepository devicePropertyRepository;

	/** deviceServicePortMappingRepository */
	@Autowired
	private DeviceServicePortMappingRepository deviceServicePortMappingRepository;

	/** devicePropertiesServiceHelper */
	@Autowired
	private DevicePropertiesServiceHelper devicePropertiesServiceHelper;

	/** deviceServiceHelper */
	@Autowired
	private DeviceServiceHelper deviceServiceHelper;
	
	/** connectionModeRepository */
	@Autowired
	private ConnectionModeRepository connectionModeRepository;

	/**
	 * This method validates and create/update/delete Device properties.
	 * 
	 * @param deviceProperties
	 * @param extIpAddress
	 * @param macAddress
	 * @param subscriberId
	 * 
	 * @return List<StbProperty>
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<DeviceProperty> setDeviceProperties(STBProperties deviceProperties, String extIpAddress, String macAddress,
			String subscriberId) {

		LOGGER.logMessage("Set Device Properties :: macAddress=" + macAddress + ", subscriberId=" + subscriberId);

		Device device = devicePropertiesServiceHelper.validateDeviceAndSubscriber(macAddress, subscriberId);

		// Deleting old properties
		devicePropertyRepository.deleteByEquipmentId(device.getId());

		// Saving new properties
		List<DeviceProperty> devicePropertyList = new ArrayList<>();
		for (Property property : deviceProperties.getProperties()) {
			DeviceProperty deviceProperty = new DeviceProperty();
			deviceProperty.setId(new DevicePropertyId(device.getId(), property.getName()));
			deviceProperty.setPropertyValue(property.getValue());
			devicePropertyList.add(deviceProperty);
		}

		List<DeviceProperty> resultList = devicePropertyRepository.save(devicePropertyList);
		LOGGER.logMessage("Set Device Properties Successful :: macAddress=" + macAddress + ", subscriberId=" + subscriberId);
		return resultList;
	}

	/**
	 * This method validates and gets Device properties.
	 * 
	 * @param extIpAddress
	 * @param macAddress
	 * @param subscriberId
	 * 
	 * @return List<StbProperty>
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<DeviceProperty> getDeviceProperties(String extIpAddress, String macAddress, String subscriberId) {
		LOGGER.logMessage("Get Device Properties :: macAddress=" + macAddress + ", subscriberId=" + subscriberId);
		Device device = devicePropertiesServiceHelper.validateDeviceAndSubscriber(macAddress, subscriberId);
		return devicePropertyRepository.findByEquipmentId(device.getId());
	}

	/**
	 * This method validates and create/update/delete Device Port Mapping.
	 * 
	 * @param devicePortMappings
	 * @param extIpAddress
	 * @param macAddress
	 * @param subscriberId
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void setDevicePortMappings(STBPortMappings devicePortMappings, String extIpAddress, String macAddress,
			String subscriberId) {

		LOGGER.logMessage("Set Device Port Mappings :: macAddress=" + macAddress + ", subscriberId=" + subscriberId
				+ ", InternalIP=" + devicePortMappings.getIPAddress() + ", ExternalIP=" + extIpAddress);

		Device device = devicePropertiesServiceHelper.validateDeviceAndSubscriber(macAddress, subscriberId);

		//LOGGER.logMessage("Device ConnectionMode " + device.getConnectionMode().getName());

		if (devicePortMappings.getIPAddress().equals(extIpAddress)) {
			// set connection mode to 'Bridged'
			try {
				ConnectionMode desiredConnectionMode = connectionModeRepository.findOne(1L);
				ConnectionMode connectionMode = deviceServiceHelper.getConnectionMode(desiredConnectionMode.getName(),
						devicePortMappings.getIPAddress(), extIpAddress);
				//device.setConnectionMode(connectionMode);
				LOGGER.logMessage("Updated ConnectionMode " + connectionMode.getName());
			} catch (DeviceManagerException exception) {
				LOGGER.logMessage(IdentificationType.connectionModeBridged.getProperty()
						+ " mode could not be assigned", exception);
			}
		}
		
		// Deleting old mappings
		deviceServicePortMappingRepository.deleteByEquipmentId(device.getId());

		// Save new port mappings
		devicePropertiesServiceHelper.validateAndSaveServicePortMappings(devicePortMappings, device.getId(),
				null);

		// Updating internal and external ip
		deviceServiceHelper.updateInternalExternalIpAddress(device, devicePortMappings.getIPAddress(), extIpAddress);

		LOGGER.logMessage("Set Device Port Mappings Successful:: macAddress=" + macAddress + ", subscriberId=" + subscriberId);
	}

	/**
	 * 
	 * @param tvQualityInterest
	 * @param avsCookie
	 */
//	@Override
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	public NotificationDto updateTvQualityInterest(String tvQualityInterest, String avsCookie) throws STBException{
//		LOGGER.logMessage("++ updateTvQualityInterest for tvQualityInterest : "+tvQualityInterest);
//		try {
//			Token stbToken = TokenManager.parseJWT(avsCookie);
//			
//			String macAddress = stbToken.getPayload().getDeviceInfo().getDeviceId();
//			String subscriberId = stbToken.getPayload().getUserId();
//			
//			SetTopBox stb = stbRepository.findByMacAddress(macAddress);
//			if(stb == null){				
//				STBException stbExp =  new STBException(ErrorCode.NO_STB_FOUND,"No STB is found as per provided macAddress : "+macAddress);
//				LOGGER.logError(stbExp, "No STB is found as per provided macAddress : "+macAddress);
//				throw stbExp;
//			}
//			
//			if(stb.getAssignedToSubscriber() == null || !stb.getAssignedToSubscriber().getSubscriberId().equals(subscriberId)){
//				
//				STBException stbExp = new STBException(ErrorCode.USER_NOT_FOUND, "STB is not assigned to the given subscriber ");
//				LOGGER.logError(stbExp, "STB : "+macAddress+" is not assigned to the given subscriber : "+subscriberId);
//				throw stbExp;
//			}
//			
//			stb.setTvQualityInterest(tvQualityInterest);
//			stbRepository.save(stb);
//			NotificationDto dto = stbServiceHelper.calculateDeviceProfile(stb.getAssignedToSubscriber(), stb, false,
//					IdentificationType.tSubscriberInfo.getProperty(), "");
//			
//			LOGGER.logMessage("-- updateTvQualityInterest for macAddress : "+macAddress+ ", and subscriberId : "+subscriberId);
//			
//			return dto;
//			
//		} catch (TokenException exp) {			
//			LOGGER.logError(exp,"Error in decipher the authentication token : "+exp.getMessage());
//			throw new STBException(ErrorCode.USER_NOT_LOGGED, exp);
//		}
//	}

	/**
	 * 
	 * @param ipAddress
	 * @param supportedModes
	 * @param extIdAddress
	 * @param avsCookie
	 * @return
	 */
//	@Override
//	public String stbIpRenewal(String ipAddress, String supportedModes, String extIdAddress, String avsCookie) {
//		long startTime = System.currentTimeMillis();	
//		
//		if (STBManagerUtil.checkNullorBlankString(supportedModes)) {
//			ConnectionMode desiredConnectionMode = connectionModeRepository.findOne(1L);
//			supportedModes = desiredConnectionMode.getName();
//		} else {
//			validateSupportedModes(supportedModes);
//		}
//		
//		try {
//			Token stbToken = TokenManager.parseJWT(avsCookie);
//			
//			String macAddress = stbToken.getPayload().getDeviceInfo().getDeviceId();
//			String subscriberId = stbToken.getPayload().getUserId();
//			
//			SetTopBox setTopBox = stbRepository.findByMacAddress(macAddress);
//			
//			if(setTopBox == null){
//				throw new STBException(ErrorCode.NO_STB_FOUND,"No STB is found as per provided macAddress : "+macAddress);
//			}
//			
//			if(setTopBox.getAssignedToSubscriber() == null || !setTopBox.getAssignedToSubscriber().getSubscriberId().equals(subscriberId)){
//				throw new STBException(ErrorCode.USER_NOT_FOUND, "STB is not assigned to the given subscriber ");
//			}
//			
//			 ConnectionMode connectionMode = stbServiceHelper.getConnectionMode(supportedModes, ipAddress, extIdAddress);
//			 setTopBox.setConnectionMode(connectionMode);
//			
//			// Updating internal and external ip
//			stbServiceHelper.updateInternalExternalIpAddress(setTopBox, ipAddress, extIdAddress);
//			
//			stbRepository.save(setTopBox);
//			
//			LOGGER.logMessage("-- stbIpRenewal Done for macAddress : "+macAddress+ ", and subscriberId : "+subscriberId);
//			
//			LOGGER.logMethodEnd(System.currentTimeMillis() - startTime);
//			
//			return connectionMode.getName();
//			
//		} catch (TokenException exp) {
//			LOGGER.logError(exp, "Error in decipher the authentication token : "+exp.getMessage());
//			throw new STBException(ErrorCode.USER_NOT_LOGGED, exp);
//		}
//		
//	}

	/**
	 * @param supportedModes
	 */
//	private void validateSupportedModes(String supportedModes) {
//		
//		StringTokenizer splittedSupportedModes = new StringTokenizer(supportedModes, ",");
//		while(splittedSupportedModes.hasMoreElements()) {
//			String mode = splittedSupportedModes.nextElement().toString();
//			try{
//				STBConnectionMode.ConnectionMode.fromValue(mode);
//			}catch(IllegalArgumentException iae) {
//				throw new STBException(ErrorCode.INVALID_PARAM,"Invalid supportedmode : "+mode);
//			}
//		}
//	}
}
