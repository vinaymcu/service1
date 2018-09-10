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
import com.accenture.avs.device.entity.DefaultServicePortMapping;
import com.accenture.avs.device.entity.DeviceAssignedResource;
import com.accenture.avs.device.entity.DeviceResourceAllocation;
import com.accenture.avs.device.entity.DeviceServicePortMapping;
import com.accenture.avs.device.entity.Resource;
import com.accenture.avs.device.entity.Subscriber;
import com.accenture.avs.device.entity.SubscriberDeviceLimit;
import com.accenture.avs.device.entity.SubscriberDeviceLimitId;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.AssignedResources;
import com.accenture.avs.device.json.object.devicemanager.MaxSTBsPerContentQuality;
import com.accenture.avs.device.json.object.devicemanager.PortMapping;
import com.accenture.avs.device.json.object.devicemanager.Profile;
import com.accenture.avs.device.json.object.devicemanager.SubscriberDetail;
import com.accenture.avs.device.json.object.devicemanager.SubscriberUpdate;
import com.accenture.avs.device.repository.DefaultServicePortMappingRepository;
import com.accenture.avs.device.repository.DeviceAssignedResourceRepository;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.repository.DeviceResourceAllocationRepository;
import com.accenture.avs.device.repository.DeviceServicePortMappingRepository;
import com.accenture.avs.device.repository.ResourcesRepository;
import com.accenture.avs.device.repository.SubscriberDeviceLimitRepository;
import com.accenture.avs.device.repository.SubscriberRepository;
import com.accenture.avs.device.service.ResourceRedistributionService;
import com.accenture.avs.device.service.SubscriberHelperService;
import com.accenture.avs.device.tenant.TenantContext;
import com.accenture.avs.device.tenant.Tenants;
import com.accenture.avs.device.util.DeviceGlobalDataServiceUtil;
import com.accenture.avs.device.util.DeviceManagerUtil;

/**
 * @author rajesh.karna
 *
 */
@Service
public class SubscriberHelperServiceImpl implements SubscriberHelperService {
	
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(SubscriberHelperServiceImpl.class);

	@Autowired
	SubscriberRepository subscriberRepository;

	/** subscriberDeviceLimitRepository */
	@Autowired
	SubscriberDeviceLimitRepository subscriberDeviceLimitRepository;

	/** deviceResourceAllocationRepository */
	@Autowired
	DeviceResourceAllocationRepository deviceResourceAllocationRepository;

	/** deviceServicePortMappingRepository */
	@Autowired
	DeviceServicePortMappingRepository deviceServicePortMappingRepository;

	/** defaultServicePortMappingRepository */
	@Autowired
	DefaultServicePortMappingRepository defaultServicePortMappingRepository;

	/** deviceAssignedResourceRepository */
	@Autowired
	DeviceAssignedResourceRepository deviceAssignedResourceRepository;

	/** resourcesRepository */
	@Autowired
	ResourcesRepository resourcesRepository;

	/** deviceRepository */
	@Autowired
	DeviceRepository deviceRepository;

	/** resourceRedistributionService */
	@Autowired
	ResourceRedistributionService resourceRedistributionService;

	/** ACTIVE */
	private static final String ACTIVE = "Active";

	/** INACTIVE */
	private static final String INACTIVE = "Inactive";

	/**
	 * Creates Subscriber on the basis of SubscriberDetail.
	 * 
	 * @param subscriberDetail
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void createSubscriber(SubscriberDetail subscriberDetail) {

		LOGGER.logMessage("createSubscriber++");

		validateSubscriberDetail(subscriberDetail);

		Subscriber subscriber = prepareSubscriberDataFromSubscriberDetail(subscriberDetail);
		subscriberRepository.save(subscriber);

		updateStbContentQuality(subscriber, subscriberDetail.getMaxSTBsPerContentQuality());

		LOGGER.logMessage("createSubscriber--");
	}

	/**
	 * Updates subscriber on the basis of subscriberUpdate.
	 * 
	 * @param subscriberUpdate
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void updateSubscriber(SubscriberUpdate subscriberUpdate) {
		LOGGER.logMessage("updateSubscriber++");

		Subscriber subscriber = validateSubscriberUpdate(subscriberUpdate);
		resourceRedistribution(subscriber, subscriberUpdate);
		prepareSubscriberDataFromSubscriberUpdate(subscriber, subscriberUpdate);
		subscriberRepository.save(subscriber);

		if (subscriberUpdate.getMaxSTBsPerContentQuality() != null) {
			subscriberUpdate.getMaxSTBsPerContentQuality().stream().forEach(maxDevicesPerContentQuality -> {
				SubscriberDeviceLimit subscriberDeviceLimit = new SubscriberDeviceLimit();
				subscriberDeviceLimit.setId(getSubscriberDeviceLimitId(subscriber.getSubscriberId(),
						maxDevicesPerContentQuality.getContentQuality()));
				subscriberDeviceLimit.setDeviceLimit(Long.valueOf(maxDevicesPerContentQuality.getSTBLimit()));
				subscriberDeviceLimitRepository.save(subscriberDeviceLimit);
			});
		}
		LOGGER.logMessage("updateSubscriber--");
	}

	/**
	 * Deletes subscriber on the basis of subscriberId.
	 * 
	 * @param subscriberId
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteSubscriber(String subscriberId) {
		LOGGER.logMessage("deleteSubscriber++");
		Subscriber subscriber = subscriberRepository.findOne(subscriberId);
		validateSubscriber(subscriber);
		subscriberRepository.delete(subscriber);
		LOGGER.logMessage("deleteSubscriber--");
	}

	/**
	 * Gets Profile on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return Profile
	 */
	@Override
	public Profile getProfile(Long equipmentId) {
		TenantContext.setCurrentTenant(Tenants.READ);
		DeviceResourceAllocation deviceResourceAllocation = deviceResourceAllocationRepository.findOne(equipmentId);
		Profile profile = null;

		if (deviceResourceAllocation != null) {
			profile = new Profile();
			profile.setAssignedVQEOverheadBW(
					DeviceManagerUtil.getIntegerFromLong(deviceResourceAllocation.getQoeBandwidth()));
			profile.setName(deviceResourceAllocation.getDeviceProfile());
			profile.setNetworkBandwidth(DeviceManagerUtil.getIntegerFromLong(deviceResourceAllocation.getProfileBandwidth()));
		}
		return profile;
	}

	/**
	 * Gets List<PortMapping> on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return List<PortMapping>
	 */
	@Override
	public List<PortMapping> getPortMappings(Long equipmentId) {
		List<PortMapping> portMappings = new ArrayList<>();
		TenantContext.setCurrentTenant(Tenants.READ);
		for (DeviceServicePortMapping deviceServicePortMapping : deviceServicePortMappingRepository
				.findDeviceServicePortMappingsByEquipmentId(equipmentId)) {
			portMappings.add(getPortMapping(deviceServicePortMapping));
		}
		return portMappings.isEmpty() ? null : portMappings;
	}

	/**
	 * Gets list of AssignedResources on the basis of equipmentId.
	 * 
	 * @param equipmentId
	 * @return List<AssignedResources>
	 */
	@Override
	public List<AssignedResources> getAssignedResources(Long equipmentId) {
		List<AssignedResources> assignedResources = new ArrayList<>();
		TenantContext.setCurrentTenant(Tenants.READ);
		List<DeviceAssignedResource> deviceAssignedResources = deviceAssignedResourceRepository
				.findDeviceAssignedResourcesByEquipmentId(equipmentId);
		deviceAssignedResources.stream().forEach(deviceAssignedResource -> {
			List<Resource> resources = resourcesRepository
					.findResourcesByResourceId(deviceAssignedResource.getId().getResourceId());
			resources.stream().forEach(resource -> {
				assignedResources.add(getAssignedResource(deviceAssignedResource.getAmount(), resource));
			});
		});
		return assignedResources.isEmpty() ? null : assignedResources;
	}

	/**
	 * Validates SubscriberUpdate.
	 * 
	 * @param subscriberUpdate
	 * @return Subscriber
	 */
	private Subscriber validateSubscriberUpdate(SubscriberUpdate subscriberUpdate) {
		Subscriber subscriber = subscriberRepository.findOne(subscriberUpdate.getSubscriberId());
		if (subscriber == null) {
			throw new DeviceManagerException(ErrorCode.INVALID_SUBSCRIBER_ID_OR_ACCOUNT_NUMBER);
		}
		return subscriber;
	}

	/**
	 * This method does resource redistribution on the basis of subscriber and
	 * subscriberDetail.
	 * 
	 * @param subscriber
	 * @param subscriberDetail
	 */
	private void resourceRedistribution(Subscriber subscriber, SubscriberUpdate subscriberDetail) {

		try {
			LOGGER.logMessage("resourceRedistribution++");
			if (resourceRedistributionRequired(subscriber, subscriberDetail)) {
				resourceRedistributionService.resourceRedistribution(subscriber);
			}

			LOGGER.logMessage("resourceRedistribution--");
		} catch (Exception exception) {
			throw new DeviceManagerException(ErrorCode.RESOURCE_DISTRIBUTION_FAILED, exception);
		}
	}

	/**
	 * Prepares subscriber data from SubscriberUpdate for updating in the database
	 * and returns the same.
	 * 
	 * @param subscriber
	 * @param subscriberUpdate
	 * @return Subscriber
	 */
	private Subscriber prepareSubscriberDataFromSubscriberUpdate(Subscriber subscriber,
			SubscriberUpdate subscriberUpdate) {

		if (subscriberUpdate.getCity() != null) {
			subscriber.setCity(subscriberUpdate.getCity());
		}

		if (subscriberUpdate.getLocationId() != null) {
			subscriber.setLocationId(Long.valueOf(subscriberUpdate.getLocationId()));
		}

		if (subscriberUpdate.getMaxBWOverride() != null) {
			subscriber.setMaxBWOverride(Long.valueOf(subscriberUpdate.getMaxBWOverride()));
		}

		if (subscriberUpdate.getName() != null) {
			subscriber.setName(subscriberUpdate.getName());
		}

		if (subscriberUpdate.getNetworkBufferSize() != null) {
			subscriber.setNetworkBufferSize(subscriberUpdate.getNetworkBufferSize().longValue());
		}

		if (subscriberUpdate.getPhoneNumber() != null) {
			subscriber.setPhoneNumber(subscriberUpdate.getPhoneNumber());
		}

		if (subscriberUpdate.getQoeControlBandwidth() != null) {
			subscriber.setQoeControlBandwidth(subscriberUpdate.getQoeControlBandwidth().longValue());
		}

		if (subscriberUpdate.getRccEnable() != null) {
			subscriber.setRccEnable(subscriberUpdate.getRccEnable());
		}

		if (subscriberUpdate.getRetEnable() != null) {
			subscriber.setRetEnable(subscriberUpdate.getRetEnable());
		}

		if (subscriberUpdate.getStatus() != null) {
			subscriber.setStatus(subscriberUpdate.getStatus());
		}

		if (subscriberUpdate.getSubscriberBWProfile() != null) {
			subscriber.setSubscriberBWProfile(subscriberUpdate.getSubscriberBWProfile());
		}

		if (subscriberUpdate.getType() != null) {
			subscriber.setType(subscriberUpdate.getType());
		}

		return subscriber;
	}

	/**
	 * Gets SubscriberDeviceLimitId on the basis of subscriberId and contentQuality.
	 * 
	 * @param subscriberId
	 * @param contentQuality
	 * @return SubscriberDeviceLimit
	 */
	private SubscriberDeviceLimitId getSubscriberDeviceLimitId(String subscriberId, String contentQuality) {
		return new SubscriberDeviceLimitId(subscriberId, contentQuality);
	}

	/**
	 * Checks whether resource redistribution is required or not and returns true
	 * value if redistribution is required else returns false.
	 * 
	 * @param subscriber
	 * @param subscriberDetail
	 * @return boolean
	 */
	private boolean resourceRedistributionRequired(Subscriber subscriber, SubscriberUpdate subscriberDetail) {

		boolean result = DeviceGlobalDataServiceUtil.compareStringValues(subscriber.getSubscriberBWProfile(),
				subscriberDetail.getSubscriberBWProfile())
				|| DeviceGlobalDataServiceUtil.compareOptionalLongAndIntegerValues(subscriber.getQoeControlBandwidth(),
						subscriberDetail.getQoeControlBandwidth())
				|| DeviceGlobalDataServiceUtil.compareBooleanValues(subscriber.getRetEnable(),
						subscriberDetail.getRetEnable())
				|| DeviceGlobalDataServiceUtil.compareBooleanValues(subscriber.getRccEnable(),
						subscriberDetail.getRccEnable())
				|| DeviceGlobalDataServiceUtil.compareOptionalLongAndIntegerValues(subscriber.getNetworkBufferSize(),
						subscriberDetail.getNetworkBufferSize())
				|| DeviceGlobalDataServiceUtil.compareOptionalLongAndIntegerValues(subscriber.getMaxBWOverride(),
						subscriberDetail.getMaxBWOverride())
				|| maxDeviceAllowedDataModified(subscriberDetail);

		if (!result && INACTIVE.equals(subscriber.getStatus()) && ACTIVE.equals(subscriberDetail.getStatus())) {
			result = true;
		}

		LOGGER.logMessage("Resource redistribution " + (result ? "is " : "is not ") + "required.");

		return result;
	}

	/**
	 * Checks whether maximum device allowed data have been modified or not and returns
	 * true if modification takes place.
	 * 
	 * @param subscriberDetail
	 * @return boolean
	 */
	private boolean maxDeviceAllowedDataModified(SubscriberUpdate subscriberDetail) {
		boolean maxDeviceAllowed = false;
		for (MaxSTBsPerContentQuality maxDevicePerContentQuality : subscriberDetail.getMaxSTBsPerContentQuality()) {
			SubscriberDeviceLimit subscriberDeviceLimit = subscriberDeviceLimitRepository.findOne(getSubscriberDeviceLimitId(
					subscriberDetail.getSubscriberId(), maxDevicePerContentQuality.getContentQuality()));
			if (subscriberDeviceLimit == null || subscriberDeviceLimit.getDeviceLimit().intValue() != Integer
					.valueOf(maxDevicePerContentQuality.getSTBLimit())) {
				maxDeviceAllowed = true;
				break;
			}
		}
		return maxDeviceAllowed;
	}

	/**
	 * Validates subscriber on the basis of subscriber and subscriberDetails.
	 * 
	 * @param subscriberDetail
	 */
	private void validateSubscriberDetail(SubscriberDetail subscriberDetail) {
		if (subscriberDetail.getSubscriberId() == null) {
			throw new DeviceManagerException(ErrorCode.INVALID_SUBSCRIBER_ID_OR_ACCOUNT_NUMBER);
		} else if (subscriberRepository.findOne(subscriberDetail.getSubscriberId()) == null) {
			if (subscriberDetail.getAccountNumber() == null
					|| subscriberRepository.findByAccountNumber(subscriberDetail.getAccountNumber()) != null) {
				throw new DeviceManagerException(ErrorCode.INVALID_SUBSCRIBER_ID_OR_ACCOUNT_NUMBER);
			}
		} else {
			throw new DeviceManagerException(ErrorCode.SUBSCRIBER_ALREADY_EXISTS);
		}
	}

	/**
	 * Prepares subscriber data for creation in the database and returns the same.
	 * 
	 * @param subscriberDetail
	 */
	private Subscriber prepareSubscriberDataFromSubscriberDetail(SubscriberDetail subscriberDetail) {

		Subscriber subscriber = new Subscriber();
		subscriber.setSubscriberId(subscriberDetail.getSubscriberId());
		subscriber.setAccountNumber(subscriberDetail.getAccountNumber());
		subscriber.setCity(subscriberDetail.getCity());
		subscriber.setLocationId(Long.valueOf(subscriberDetail.getLocationId()));
		subscriber.setName(subscriberDetail.getName());
		subscriber.setPhoneNumber(subscriberDetail.getPhoneNumber());
		subscriber.setRccEnable(subscriberDetail.getRccEnable());
		subscriber.setRetEnable(subscriberDetail.getRetEnable());
		subscriber.setStatus(subscriberDetail.getStatus());
		subscriber.setSubscriberBWProfile(subscriberDetail.getSubscriberBWProfile());
		subscriber.setType(subscriberDetail.getType());

		if (subscriberDetail.getMaxBWOverride() != null) {
			subscriber.setMaxBWOverride(Long.valueOf(subscriberDetail.getMaxBWOverride()));
		}

		if (subscriberDetail.getNetworkBufferSize() != null) {
			subscriber.setNetworkBufferSize(subscriberDetail.getNetworkBufferSize().longValue());
		}

		if (subscriberDetail.getQoeControlBandwidth() != null) {

			subscriber.setQoeControlBandwidth(subscriberDetail.getQoeControlBandwidth().longValue());
		}

		return subscriber;
	}

	/**
	 * Validates subscriber on the basis of subscriberId.
	 *
	 * @param subscriberId
	 */
	private void validateSubscriber(Subscriber subscriber) {
		if (subscriber == null) {
			throw new DeviceManagerException(ErrorCode.USER_NOT_FOUND);
		}/* else if (!deviceRepository.findBySubscriberId(subscriber.getSubscriberId()).isEmpty()) {
			throw new DeviceManagerException(ErrorCode.CANNOT_REMOVE_SUBSCRIBER);
		}*/
	}

	/**
	 * Saves or updates device content quality on the basis of subscriber and
	 * maxDevicesPerContentQuality.
	 * 
	 * @param subscriber
	 * @param maxDevicesPerContentQualities
	 */
	private void updateStbContentQuality(Subscriber subscriber,
			List<MaxSTBsPerContentQuality> maxDevicesPerContentQualities) {
		maxDevicesPerContentQualities.stream().forEach(maxDevicesPerContentQuality -> {
			SubscriberDeviceLimit subscriberDeviceLimit = new SubscriberDeviceLimit();
			SubscriberDeviceLimitId subscriberStbLimitId = new SubscriberDeviceLimitId(subscriber.getSubscriberId(),
					maxDevicesPerContentQuality.getContentQuality());
			subscriberDeviceLimit.setId(subscriberStbLimitId);
			subscriberDeviceLimit.setDeviceLimit(Long.valueOf(maxDevicesPerContentQuality.getSTBLimit()));
			subscriberDeviceLimitRepository.save(subscriberDeviceLimit);
		});
	}

	/**
	 * Gets AssignedResources on the basis of assigendRresourceAmount and resource.
	 *
	 * @param assigendRresourceAmount
	 * @param resource
	 * @return AssignedResources
	 */
	private AssignedResources getAssignedResource(String assigendRresourceAmount, Resource resource) {
		AssignedResources assignedResource = new AssignedResources();
		assignedResource.setName(resource.getId().getName());
		assignedResource.setAllocation(assigendRresourceAmount);
		return assignedResource;
	}

	/**
	 * Gets PortMapping on the basis of deviceServicePortMapping.
	 * 
	 * @param deviceServicePortMapping
	 * @return PortMapping
	 */
	private PortMapping getPortMapping(DeviceServicePortMapping deviceServicePortMapping) {
		PortMapping portMapping;
		portMapping = new PortMapping();
		portMapping.setExternalPort(DeviceManagerUtil.getIntegerFromLong(deviceServicePortMapping.getExternalPort()));
		portMapping.setInternalPort(DeviceManagerUtil.getIntegerFromLong(deviceServicePortMapping.getInternalPort()));
		TenantContext.setCurrentTenant(Tenants.READ);
		DefaultServicePortMapping defaultServicePortMapping = defaultServicePortMappingRepository
				.findOne(deviceServicePortMapping.getId().getServiceId());
		portMapping.setServiceName(defaultServicePortMapping.getServiceName());
		return portMapping;
	}
}
