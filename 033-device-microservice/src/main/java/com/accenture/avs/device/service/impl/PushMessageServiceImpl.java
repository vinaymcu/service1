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

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.client.PushMessageClient;
import com.accenture.avs.device.entity.Device;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.unicastnotifier.EventUpdateRequest;
import com.accenture.avs.device.repository.DeviceRepository;
import com.accenture.avs.device.service.PushMessageService;
import com.accenture.avs.device.util.DeviceManagerUtil;
import com.accenture.avs.device.util.RequestResponseGenerator;

/**
 * PushMessageServiceImpl
 * 
 * @author Singh.Saurabh
 *
 */
@Service
public class PushMessageServiceImpl implements PushMessageService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(PushMessageServiceImpl.class);
	
	/** deviceRepository */
	@Autowired
	private DeviceRepository deviceRepository;
	
	/** pushMessageClient */
	@Autowired
	private PushMessageClient pushMessageClient;
	
	/** notificationRetries */
	@Value("${failed.notification.retrials:0}")
	private Integer notificationRetries;
	
	/**
	 * This method sends notification to Push Message MS.
	 * 
	 * @param equipmentIdListForNotification
	 * @param subscriberId
	 * @param triggerType
	 * @param triggerInfo
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void sendNotification(List<Long> equipmentIdListForNotification, String subscriberId, String triggerType,
			String triggerInfo) {
		List<Device> devicesList = deviceRepository.findAll(equipmentIdListForNotification);
		for (Device device : devicesList) {
			EventUpdateRequest eventUpdateRequest = RequestResponseGenerator.getEventUpdateRequest(subscriberId,
					Arrays.asList(device.getDeviceId()), triggerType, triggerInfo);
			sendNotification(eventUpdateRequest);
		}
	}
	
	/**
	 * This method sends notification to UnicastNotifier.
	 * 
	 * @param eventUpdateRequest
	 */
	private void sendNotification(EventUpdateRequest eventUpdateRequest) {

		int retries = notificationRetries;
		ResponseEntity<GenericResponse> response = null;
		boolean isSuccessfull = Boolean.FALSE;
		int diff = 1000 / retries;
		int lowerBound = 0;
		int upperBound = diff;

		LOGGER.logMessage("Total Number of Retries = " + retries);
		LOGGER.logMessage("Sending notification for MAC Address = "
				+ eventUpdateRequest.getEventUpdate().getMACAddress().get(0) + " for Subscriber Id= "
				+ eventUpdateRequest.getEventUpdate().getSubscriberId());

		do {
			try {
				response = pushMessageClient.trigger(eventUpdateRequest);
			} catch (Exception exp) {
				try {
					TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(lowerBound, upperBound));
				} catch (InterruptedException interruptedException) {
					/*if (LOGGER.isDebugEnabled()) {
						LOGGER.logMessage(interruptedException);
					}*/
				}
			}

			if (DeviceManagerUtil.checkNullObject(response)) {
				isSuccessfull = Boolean.FALSE;
			} else if (response.getStatusCode().equals(HttpStatus.OK)) {
				isSuccessfull = Boolean.TRUE;
				LOGGER.logMessage("Notification send sucessfully for MAC Address = "
						+ eventUpdateRequest.getEventUpdate().getMACAddress().get(0) + " for Subscriber Id= "
						+ eventUpdateRequest.getEventUpdate().getSubscriberId());
			}

			if (!isSuccessfull) {
				retries--;
				lowerBound = upperBound;
				upperBound = upperBound + diff;
				LOGGER.logMessage("Retrying to send notification for MAC Address = "
							+ eventUpdateRequest.getEventUpdate().getMACAddress().get(0) + " for Subscriber = "
							+ eventUpdateRequest.getEventUpdate().getSubscriberId());
			}
		} while (retries > 0 && !isSuccessfull);
	}

}
