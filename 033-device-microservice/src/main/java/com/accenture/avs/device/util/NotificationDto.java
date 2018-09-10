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

import java.util.List;

import com.accenture.avs.device.entity.Device;

/**
 * DTO class for sending notification to Unicast Notifier
 * 
 * @author Singh.Saurabh
 *
 */
public class NotificationDto {

	/** equipmentIdListForNotification */
	private List<Long> equipmentIdListForNotification;

	/** subscriberId */
	private String subscriberId;

	/** triggerType */
	private String triggerType;

	/** triggerInfo */
	private String triggerInfo;

	/** device */
	private Device device;

	/**
	 * gets equipmentIdListForNotification
	 * 
	 * @return
	 */
	public List<Long> getEquipmentIdListForNotification() {
		return equipmentIdListForNotification;
	}

	/**
	 * sets equipmentIdListForNotification
	 * 
	 * @param equipmentIdListForNotification
	 */
	public void setEquipmentIdListForNotification(List<Long> equipmentIdListForNotification) {
		this.equipmentIdListForNotification = equipmentIdListForNotification;
	}

	/**
	 * gets subscriberId
	 * 
	 * @return
	 */
	public String getSubscriberId() {
		return subscriberId;
	}

	/**
	 * sets subscriberId
	 * 
	 * @param subscriberId
	 */
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * gets triggerType
	 * 
	 * @return
	 */
	public String getTriggerType() {
		return triggerType;
	}

	/**
	 * sets triggerType
	 * 
	 * @param triggerType
	 */
	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	/**
	 * gets triggerInfo
	 * 
	 * @return
	 */
	public String getTriggerInfo() {
		return triggerInfo;
	}

	/**
	 * sets triggerInfo
	 * 
	 * @param triggerInfo
	 */
	public void setTriggerInfo(String triggerInfo) {
		this.triggerInfo = triggerInfo;
	}

	/**
	 * gets device
	 * 
	 * @return
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * sets device
	 * 
	 * @param device
	 */
	public void setDevice(Device device) {
		this.device = device;
	}
}
