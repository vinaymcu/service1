/*************************************************************************
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
import com.accenture.avs.device.json.object.devicemanager.SubscriberDetail;
import com.accenture.avs.device.json.object.devicemanager.Subscribers;
import com.accenture.avs.device.service.SubscriberCreationService;
import com.accenture.avs.device.service.SubscriberHelperService;
import com.accenture.avs.device.util.RequestResponseGenerator;

/**
 * Subscriber creation service class.
 * 
 * @author rajesh.karna
 *
 */
@Service
public class SubscriberCreationServiceImpl implements SubscriberCreationService {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(SubscriberCreationServiceImpl.class);

	@Autowired
	SubscriberHelperService subscriberHelperService;

	/** configClient */
	@Autowired
	private ConfigurationClient configClient;

	/**
	 * Creates subscribers on the basis of subscriberDetail.
	 * 
	 * @param subscriberDetail
	 * @return GenericResponseForB2B
	 */
	@Override
	public GenericResponse createSubscribers(Subscribers subscribers) {	
		Long startTime = System.currentTimeMillis();
		int successfulRequests = 0;
		int failedRequests = 0;

		List<ResultObject> resultObjectList = new ArrayList<>();

		List<SubscriberDetail> subscriberDetails = subscribers.getSubscriberDetails();
		for (SubscriberDetail subscriberDetail : subscriberDetails) {

			try {
				printSubscriberDetailLog(subscriberDetail);
				subscriberHelperService.createSubscriber(subscriberDetail);
				RequestResponseGenerator.getGenericResultObject(resultObjectList,
						subscriberDetail.getSubscriberId(),
						(String) IdentificationType.genericSuccessResultCode
								.toDataType(IdentificationType.genericSuccessResultCode.getProperty()),
						(String) IdentificationType.genericSuccessResultDescription
								.toDataType(IdentificationType.genericSuccessResultDescription.getProperty()));
				successfulRequests++;
			} catch (DeviceManagerException deviceException) {
				LOGGER.logMessage("Subscriber creation failed.", deviceException);
				SystemMessage sysMessage = configClient.findSystemMessage(IdentificationType.defaultLanguage.getProperty(),
						deviceException.getErrorCode().getCode());
				RequestResponseGenerator.getGenericResultObject(resultObjectList,
						subscriberDetail.getSubscriberId(), sysMessage.getMessageCode(), sysMessage.getMessageText());
				failedRequests++;
			}
		}
		Long executionTime = System.currentTimeMillis() - startTime;
		GenericResponse genericResponseForB2B = RequestResponseGenerator
				.getGenericResponse(resultObjectList, successfulRequests, failedRequests, executionTime);
		LOGGER.logMethodEnd(executionTime);
		return genericResponseForB2B;
	}

	/**
	 * Prints log for subscriber details.
	 * 
	 * @param subscriberDetail
	 */
	private static void printSubscriberDetailLog(SubscriberDetail subscriberDetail) {

		StringBuilder stringBuilder = new StringBuilder("\nSubscriber details with the following parameters:");
		stringBuilder.append("\nSubscriberId = ");
		stringBuilder.append(subscriberDetail.getSubscriberId());
		stringBuilder.append("\nAccountNumber = ");
		stringBuilder.append(subscriberDetail.getAccountNumber());
		stringBuilder.append("\nCity = ");
		stringBuilder.append(subscriberDetail.getCity());
		stringBuilder.append("\nLocation = ");
		stringBuilder.append(subscriberDetail.getLocationId());
		stringBuilder.append("\nMaxBWOverride = ");
		stringBuilder.append(subscriberDetail.getMaxBWOverride());
		stringBuilder.append("\nName = ");
		stringBuilder.append(subscriberDetail.getName());
		stringBuilder.append("\nPhoneNumber = ");
		stringBuilder.append(subscriberDetail.getPhoneNumber());
		stringBuilder.append("\nStatus = ");
		stringBuilder.append(subscriberDetail.getStatus());
		stringBuilder.append("\nSubscriberBWProfile = ");
		stringBuilder.append(subscriberDetail.getSubscriberBWProfile());
		stringBuilder.append("\nType = ");
		stringBuilder.append(subscriberDetail.getType());
		stringBuilder.append("\nQoeControlBandwidth = ");
		stringBuilder.append(subscriberDetail.getQoeControlBandwidth());
		stringBuilder.append("\nRetEnable = ");
		stringBuilder.append(subscriberDetail.getRetEnable());
		stringBuilder.append("\nRccEnable = ");
		stringBuilder.append(subscriberDetail.getRccEnable());
		stringBuilder.append("\nNetworkBufferSize = ");
		stringBuilder.append(subscriberDetail.getNetworkBufferSize());
		LOGGER.logMessage(stringBuilder.toString());
	}
}
