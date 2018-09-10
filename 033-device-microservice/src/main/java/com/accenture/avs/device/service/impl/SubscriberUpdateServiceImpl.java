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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.config.SystemMessage;
import com.accenture.avs.device.config.client.ConfigurationClient;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.DeviceManagerException;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;
import com.accenture.avs.device.json.object.devicemanager.ResultObject;
import com.accenture.avs.device.json.object.devicemanager.SubscriberUpdate;
import com.accenture.avs.device.json.object.devicemanager.UpdateSubscriber;
import com.accenture.avs.device.service.SubscriberHelperService;
import com.accenture.avs.device.service.SubscriberUpdateService;
import com.accenture.avs.device.util.RequestResponseGenerator;
import com.accenture.avs.device.util.DeviceSubscriberServiceUtil;

/**
 * Subscriber update service class.
 * 
 * @author rajesh.karna
 *
 */
@Service
public class SubscriberUpdateServiceImpl implements SubscriberUpdateService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(SubscriberUpdateServiceImpl.class);

	@Autowired
	SubscriberHelperService subscriberHelperService;
	
	/** configClient */
	@Autowired
	private ConfigurationClient configClient;

	/**
	 * Updates subscribers on the basis of updateSubscriber.
	 * 
	 * @param updateSubscriber
	 * @return GenericResponseForB2B
	 */
	@Override
	public GenericResponse updateSubscribers(UpdateSubscriber updateSubscriber) {

		LOGGER.logMessage("updateSubscribers++");

		Long startTime = System.currentTimeMillis();		
		int successfulRequests = 0;
		int failedRequests = 0;

		List<ResultObject> resultObjectList = new ArrayList<>();

		List<SubscriberUpdate> subscriberUpdates = updateSubscriber.getSubscriberUpdates();
		for (SubscriberUpdate subscriberUpdate : subscriberUpdates) {

			try {
				DeviceSubscriberServiceUtil.printSubscriberUpdateLog(subscriberUpdate);
				subscriberHelperService.updateSubscriber(subscriberUpdate);
				RequestResponseGenerator.getGenericResultObject(resultObjectList,
						subscriberUpdate.getSubscriberId(),
						(String) IdentificationType.genericSuccessResultCode
								.toDataType(IdentificationType.genericSuccessResultCode.getProperty()),
						(String) IdentificationType.genericSuccessResultDescription
								.toDataType(IdentificationType.genericSuccessResultDescription.getProperty()));
				successfulRequests++;
			} catch (DeviceManagerException deviceException) {
				LOGGER.logMessage("Subscriber updating failed.", deviceException);
				SystemMessage sysMessage = configClient.findSystemMessage(
						IdentificationType.defaultLanguage.getProperty(), deviceException.getErrorCode().getCode());
				RequestResponseGenerator.getGenericResultObject(resultObjectList,
						subscriberUpdate.getSubscriberId(), sysMessage.getMessageCode(), sysMessage.getMessageText());
				failedRequests++;
			}
		}

		Long executionTime = System.currentTimeMillis() - startTime;
		GenericResponse genericResponseForB2B = RequestResponseGenerator
				.getGenericResponse(resultObjectList, successfulRequests, failedRequests, executionTime);
		LOGGER.logMethodEnd(executionTime);
		return genericResponseForB2B;
	}
}
