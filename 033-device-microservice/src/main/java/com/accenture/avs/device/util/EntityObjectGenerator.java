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
package com.accenture.avs.device.util;

import java.util.ArrayList;
import java.util.List;

import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.entity.DeviceAssignedResource;
import com.accenture.avs.device.entity.DeviceAssignedResourceId;
import com.accenture.avs.device.entity.DeviceMaxBWAllowedPerQuality;
import com.accenture.avs.device.entity.DeviceMaxBWAllowedPerQualityId;
import com.accenture.avs.device.entity.DeviceResourceAllocation;
import com.accenture.avs.device.entity.DeviceServicePortMapping;
import com.accenture.avs.device.entity.DeviceServicePortMappingId;
import com.accenture.avs.device.entity.HardwareMtpMapping;
import com.accenture.avs.device.entity.HardwareMtpMappingId;
import com.accenture.avs.device.entity.Location;
import com.accenture.avs.device.entity.Model;
import com.accenture.avs.device.entity.ModelMaxStreamsAllowedPerQuality;
import com.accenture.avs.device.entity.ModelMaxStreamsAllowedPerQualityId;
import com.accenture.avs.device.entity.SubscriberDeviceLimit;
import com.accenture.avs.device.entity.SubscriberDeviceLimitId;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.json.object.devicemanager.CreateDeviceModelRequest;
import com.accenture.avs.device.json.object.devicemanager.DeviceDto;
import com.accenture.avs.device.json.object.devicemanager.MaxStreamsPerQuality;
import com.accenture.avs.device.json.object.devicemanager.SubscriberDetail;
import com.accenture.avs.device.json.object.devicemanager.UpdateDeviceModelRequest;

/**
 * This class generates the entity objects.
 * 
 * @author singh.saurabh
 *
 */
public class EntityObjectGenerator {

	/**
	 * This method creates an entity object for Subscriber
	 * 
	 * @param subscriberUpdate
	 * @param location
	 * @return
	 */
	public static com.accenture.avs.device.entity.Subscriber getSubscriberEntity(SubscriberDetail subscriberDetail) {

		com.accenture.avs.device.entity.Subscriber subscriber = new com.accenture.avs.device.entity.Subscriber();
		subscriber.setAccountNumber(subscriberDetail.getAccountNumber());
		subscriber.setCity(subscriberDetail.getCity());
		subscriber.setName(subscriberDetail.getName());
		subscriber.setPhoneNumber(subscriberDetail.getPhoneNumber());
		subscriber.setRccEnable(subscriberDetail.getRccEnable());
		subscriber.setRetEnable(subscriberDetail.getRetEnable());
		subscriber.setStatus(subscriberDetail.getStatus());
		subscriber.setSubscriberBWProfile(subscriberDetail.getSubscriberBWProfile());
		subscriber.setSubscriberId(subscriberDetail.getSubscriberId());
		subscriber.setType(subscriberDetail.getType());

		if (!DeviceManagerUtil.checkNullObject(subscriberDetail.getLocationId())) {
			subscriber.setLocationId(subscriberDetail.getLocationId().longValue());
		}

		if (!DeviceManagerUtil.checkNullObject(subscriberDetail.getMaxBWOverride())) {
			subscriber.setMaxBWOverride(subscriberDetail.getMaxBWOverride().longValue());
		}

		if (!DeviceManagerUtil.checkNullObject(subscriberDetail.getNetworkBufferSize())) {
			subscriber.setNetworkBufferSize(subscriberDetail.getNetworkBufferSize().longValue());
		}

		if (!DeviceManagerUtil.checkNullObject(subscriberDetail.getQoeControlBandwidth())) {
			subscriber.setQoeControlBandwidth(subscriberDetail.getQoeControlBandwidth().longValue());
		}

		return subscriber;
	}

	/**
	 * This method creates an entity object for SubscriberDeviceLimit
	 * 
	 * @param subscriberId
	 * @param contentQuality
	 * @param deviceLimit
	 * @return
	 */
	public static SubscriberDeviceLimit getSubscriberDeviceLimitEntity(String subscriberId, String contentQuality,
			Long deviceLimit) {
		SubscriberDeviceLimit subscriberDeviceLimit = new SubscriberDeviceLimit();
		subscriberDeviceLimit.setId(new SubscriberDeviceLimitId(subscriberId, contentQuality));
		subscriberDeviceLimit.setDeviceLimit(deviceLimit);
		return subscriberDeviceLimit;
	}

	/**
	 * This method creates an entity object for Device
	 * 
	 * @param request
	 * @param device
	 * @param deviceModel
	 * @param lastUpdateUserName
	 * @param deviceName
	 * 
	 * @return Device
	 */
	public static Device createDeviceEntity(Object request, Device device, Model deviceModel,
			String lastUpdateUserName, String deviceName) {

		if (DeviceManagerUtil.checkNullObject(device)) {
			device = new Device();
		}

		if (request instanceof DeviceDto) {
			DeviceDto createDeviceDto = (DeviceDto) request;
			getDeviceEntityForCreateUpdateDevice(device, createDeviceDto);
		}
		device.setModel(deviceModel);
		device.setDeviceName(deviceName);
		device.setLastUpdatedBy(lastUpdateUserName);
		device.setLastUpdatedOn(System.currentTimeMillis());
		return device;
	}
	
	/**
	 * Sets Device entity for Create/Update Device Request
	 * 
	 * @param device
	 * @param deviceDto
	 */
	private static void getDeviceEntityForCreateUpdateDevice(Device device, DeviceDto deviceDto) {
		device.setAssignmentStatus(Constants.AssignmentStatus.UNASSIGNED);
		device.setDrmId(validateAndGetId(deviceDto.getDeviceId(), deviceDto.getDrmId()));
		device.setDeviceId(deviceDto.getDeviceId());
		if (!DeviceManagerUtil.checkNullObject(deviceDto.getMaxBandwidthUpdates())) {
			device.setMaxBandwidthUpdate(deviceDto.getMaxBandwidthUpdates().longValue());
		}
		if (!DeviceManagerUtil.checkNullObject(deviceDto.getOverridingDefaults())) {
			device.setOverridingDefault(deviceDto.getOverridingDefaults().longValue());
		}
		device.setSerialNumber(deviceDto.getSerialNumber());
		device.setSoftwareVersion(deviceDto.getSoftwareVersion());
		device.setUiVersion(deviceDto.getUiVersion());
		device.setDeviceType(deviceDto.getDeviceType());
		device.setPlatform(deviceDto.getPlatform());
		device.setVendor(deviceDto.getVendor());
		device.setTvQualityInterest(deviceDto.getTvQualityInterest());
		device.setSupportedMode(Constants.IMPLICIT_NAT);
		device.setConnectionMode(Constants.IMPLICIT_NAT);
	}
	
	/**
	 * This method helps to decide the VMXClientId or CASDeviceId.
	 * 
	 * @param macAddress
	 * @param id
	 * @return
	 */
	private static String validateAndGetId(String macAddress, String id) {
		return DeviceManagerUtil.checkNullObject(id) ? macAddress : id;
	}

	/**
	 * This method creates an entity object for HardwareVersion
	 * 
	 * @param hwVersionName
	 * @param isQoeCapable
	 * @param isDisableDeviceAutoRegistration
	 * @return
	 */
	public static Model getHardwareVersionEntity(String hwVersionName, boolean isQoeCapable,
			boolean isDisableDeviceAutoRegistration) {
		Model hardwareVersion = new Model();
		hardwareVersion.setModelName(hwVersionName);
		hardwareVersion.setQoeCapable(isQoeCapable);
		hardwareVersion.setDisableDeviceAutoRegistration(isDisableDeviceAutoRegistration);
		return hardwareVersion;
	}

	/**
	 * This method creates an entity object for HardwareMtpMapping
	 * 
	 * @param hardwareName
	 * @param mtpId
	 * @return
	 */
	public static HardwareMtpMapping getHardwareMtpMappingEntity(String hardwareName, String mtpId) {
		HardwareMtpMapping hardwareMtpMapping = new HardwareMtpMapping();
		hardwareMtpMapping.setId(new HardwareMtpMappingId(hardwareName, mtpId));
		return hardwareMtpMapping;
	}

	/**
	 * This method creates an entity object for Location
	 * 
	 * @param id
	 * @param locationName
	 * @param parentId
	 * @param tvRegionId
	 * @return
	 */
	public static Location getLocationEntity(Long id, String locationName, Long parentId, Long tvRegionId) {
		Location loc = new Location();
		loc.setLocationId(id);
		loc.setName(locationName);
		loc.setParentId(parentId);
		loc.setTvRegionId(tvRegionId);
		return loc;
	}

	/**
	 * This method creates an entity object for Language
	 * 
	 * @param languageName
	 * @param languageType
	 * @param isAvailableForUI
	 * @param isAvailableForAudio
	 * @return
	 */
	public static com.accenture.avs.device.entity.Language getLanguageEntity(String languageName, String languageType,
			boolean isAvailableForUI, boolean isAvailableForAudio) {
		com.accenture.avs.device.entity.Language lang = new com.accenture.avs.device.entity.Language();
		lang.setName(languageName);
		lang.setType(languageType);
		lang.setAvailableForui(isAvailableForUI);
		lang.setAvailableForAudio(isAvailableForAudio);
		return lang;
	}

	/**
	 * This method creates an entity object for DeviceAssignedResource
	 * 
	 * @param equipmentId
	 * @param resourceId
	 * @param amount
	 * @return
	 */
	public static DeviceAssignedResource getDeviceAssignedResourceEntity(Long equipmentId, Long resourceId,
			String amount) {
		DeviceAssignedResource deviceAssignedResource = new DeviceAssignedResource();
		deviceAssignedResource.setId(new DeviceAssignedResourceId(equipmentId, resourceId));
		deviceAssignedResource.setAmount(amount);
		return deviceAssignedResource;
	}

	/**
	 * This method creates an entity object for DeviceResourceAllocation
	 * 
	 * @param equipmentId
	 * @param deviceProfile
	 * @param profileBandwidth
	 * @param qoeBandwidth
	 * @return
	 */
	public static DeviceResourceAllocation getDeviceResourceAllocationEntity(Long equipmentId, String deviceProfile,
			Long profileBandwidth, Long qoeBandwidth) {
		DeviceResourceAllocation deviceResourceAllocation = new DeviceResourceAllocation(equipmentId);
		deviceResourceAllocation.setDeviceProfile(deviceProfile);
		deviceResourceAllocation.setProfileBandwidth(profileBandwidth);
		deviceResourceAllocation.setQoeBandwidth(qoeBandwidth);
		deviceResourceAllocation.setLastUpdatedOn(System.currentTimeMillis());
		return deviceResourceAllocation;
	}

	/**
	 * This method creates an entity object for DeviceMaxBwAllowedPerQuality
	 * 
	 * @param id
	 * @param tvQuality
	 * @param maxBandwidth
	 * 
	 * @return DeviceMaxBWAllowedPerQuality
	 */
	public static DeviceMaxBWAllowedPerQuality getStbMaxBwAllowedPerQualityEntity(Long id, String tvQuality,
			Long maxBandwidth) {
		DeviceMaxBWAllowedPerQuality deviceMaxBwAllowedPerQuality = new DeviceMaxBWAllowedPerQuality();
		deviceMaxBwAllowedPerQuality.setId(new DeviceMaxBWAllowedPerQualityId(id, tvQuality));
		deviceMaxBwAllowedPerQuality.setMaxBandwidth(maxBandwidth);
		return deviceMaxBwAllowedPerQuality;
	}

	/**
	 * This method creates an entity object for DeviceServicePortMapping
	 * 
	 * @param equipmentId
	 * @param serviceId
	 * @param internalPort
	 * @param externalPort
	 * @return
	 */
	public static DeviceServicePortMapping getStbServicePortMappingEntity(Long equipmentId, Long serviceId,
			Long internalPort, Long externalPort) {
		DeviceServicePortMapping deviceServicePortMapping = new DeviceServicePortMapping();
		deviceServicePortMapping.setId(new DeviceServicePortMappingId(equipmentId, serviceId));
		deviceServicePortMapping.setInternalPort(internalPort);
		deviceServicePortMapping.setExternalPort(externalPort);
		return deviceServicePortMapping;
	}
	
	/**
	 * This method creates an entity object for Device Model for
	 * CreateDeviceModelRequest.
	 * 
	 * @param deviceModel
	 * @param lastUpdateUserName
	 * @param lastUpdatedInterface
	 * @return
	 */
	public static Model createModelEntity(CreateDeviceModelRequest deviceModel, String lastUpdateUserName,
			String lastUpdatedInterface) {
		Model deviceModelEntity = new Model();
		deviceModelEntity.setModelName(deviceModel.getDeviceModel());
		deviceModelEntity.setVendor(deviceModel.getVendor());
		deviceModelEntity.setPlatform(deviceModel.getPlatform());
		deviceModelEntity.setOsName(deviceModel.getOsName());
		deviceModelEntity.setOsVersion(deviceModel.getOsVersion());
		deviceModelEntity.setSoftwareVersion(deviceModel.getSwId());
		deviceModelEntity.setQoeCapable(deviceModel.getQoeCapable());
		deviceModelEntity.setUiVersion(deviceModel.getUiVersion());
		deviceModelEntity.setSdChannelTimeshiftBuffer(
				DeviceManagerUtil.convertIntegerToLong(deviceModel.getSdChannelTimeshiftBuffer()));
		deviceModelEntity.setHdChannelTimeshiftBuffer(
				DeviceManagerUtil.convertIntegerToLong(deviceModel.getHdChannelTimeshiftBuffer()));
		deviceModelEntity.setStatus(DeviceManagerUtil.convertIntToBoolean(deviceModel.getStatus()));
		deviceModelEntity.setVqeProfile(deviceModel.getVqeProfile());
		deviceModelEntity.setDisableDeviceAutoRegistration(deviceModel.getDeviceAutoRegistration());
		deviceModelEntity.setTstvBufferSize(DeviceManagerUtil.convertIntegerToLong(deviceModel.getTstvBufferSize()));
		deviceModelEntity.setHdCapable(deviceModel.getHdCapable());
		deviceModelEntity.setLastUpdatedDatetime(System.currentTimeMillis());
		deviceModelEntity.setLastUpdateUsername(lastUpdateUserName);
		deviceModelEntity.setLastUpdateInterface(lastUpdatedInterface);
		deviceModelEntity.setModelMaxStreamsAllowedPerQuality(getModelMaxStreamsAllowedPerQuality(
				deviceModel.getMaxStreamsPerQuality(), deviceModel.getDeviceModel()));
		return deviceModelEntity;
	}
	
	/**
	 * This method creates an entity object for Device Model for
	 * UpdateDeviceModelRequest.
	 * 
	 * @param deviceModel
	 * @param lastUpdateUserName
	 * @param lastUpdatedInterface
	 * @return
	 */
	public static Model updateModelEntity(UpdateDeviceModelRequest deviceModel, Model deviceModelEntity,
			String lastUpdateUserName, String lastUpdatedInterface) {
		deviceModelEntity.setVendor(deviceModel.getVendor());
		deviceModelEntity.setPlatform(deviceModel.getPlatform());
		deviceModelEntity.setOsName(deviceModel.getOsName());
		deviceModelEntity.setOsVersion(deviceModel.getOsVersion());
		deviceModelEntity.setSoftwareVersion(deviceModel.getSwId());
		deviceModelEntity.setQoeCapable(deviceModel.getQoeCapable());
		deviceModelEntity.setUiVersion(deviceModel.getUiVersion());
		deviceModelEntity.setSdChannelTimeshiftBuffer(
				DeviceManagerUtil.convertIntegerToLong(deviceModel.getSdChannelTimeshiftBuffer()));
		deviceModelEntity.setHdChannelTimeshiftBuffer(
				DeviceManagerUtil.convertIntegerToLong(deviceModel.getHdChannelTimeshiftBuffer()));
		deviceModelEntity.setStatus(DeviceManagerUtil.convertIntToBoolean(deviceModel.getStatus()));
		deviceModelEntity.setVqeProfile(deviceModel.getVqeProfile());
		deviceModelEntity.setDisableDeviceAutoRegistration(deviceModel.getDeviceAutoRegistration());
		deviceModelEntity.setTstvBufferSize(DeviceManagerUtil.convertIntegerToLong(deviceModel.getTstvBufferSize()));
		deviceModelEntity.setHdCapable(deviceModel.getHdCapable());
		deviceModelEntity.setLastUpdatedDatetime(System.currentTimeMillis());
		deviceModelEntity.setLastUpdateUsername(lastUpdateUserName);
		deviceModelEntity.setLastUpdateInterface(lastUpdatedInterface);
		deviceModelEntity.setModelMaxStreamsAllowedPerQuality(getModelMaxStreamsAllowedPerQuality(
				deviceModel.getMaxStreamsPerQuality(), deviceModel.getDeviceModel()));
		return deviceModelEntity;
	}
	
	/**
	 * This method creates a List of ModelMaxStreamsAllowedPerQuality.
	 * 
	 * @param maxStreamsPerQualityList
	 * @param modelName
	 * @return
	 */
	public static List<ModelMaxStreamsAllowedPerQuality> getModelMaxStreamsAllowedPerQuality(
			List<MaxStreamsPerQuality> maxStreamsPerQualityList, String modelName) {
		List<ModelMaxStreamsAllowedPerQuality> modelMaxStreamsAllowedPerQualityList = new ArrayList<>();
		for (MaxStreamsPerQuality maxStreamsPerQuality : maxStreamsPerQualityList) {
			ModelMaxStreamsAllowedPerQuality modelMaxStreamsAllowedPerQuality = new ModelMaxStreamsAllowedPerQuality();
			modelMaxStreamsAllowedPerQuality
					.setId(new ModelMaxStreamsAllowedPerQualityId(modelName, maxStreamsPerQuality.getContentQuality()));
			modelMaxStreamsAllowedPerQuality.setMaxStreams(maxStreamsPerQuality.getStreamLimit().longValue());
			modelMaxStreamsAllowedPerQualityList.add(modelMaxStreamsAllowedPerQuality);
		}
		return modelMaxStreamsAllowedPerQualityList;
	}
}
