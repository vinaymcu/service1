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
package com.accenture.avs.device.util.validation;

/**
 * @author surendra.kumar
 *
 */
public enum JsonSchema {

	CREATEDEVICEMODEL("CreateDeviceModelRequest.json"),
	
	UPDATEDEVICEMODEL("UpdateDeviceModelRequest.json"),
	
	SUBSCRIBERS("Subscribers.json"),
	
	UPDATESUBSCRIBER("UpdateSubscriber.json"),
	
	DELETESUBSCRIBER("SubscriberDelete.json"),

	UPDATEGLOBALDATA("UpdateGlobalData.json"),
	
	CREATEDEVICE("CreateDeviceRequest.json"),
	
	ASSIGNSTB("AssignSetTopBox.json"),
	
	UNASSIGNSTB("UnassignSetTopBox.json"),
	
	CREATEANDASSIGNSTB("CreateAndAssignSTB.json"),
	
	AUTOCONFIG("AutoConfig.json"),
	
	SETTOPBOXDELETE("SetTopBoxDelete.json"),	
	
	UPDATEDEVICE("UpdateDeviceRequest.json"),

	STBPROPERTIES("STBProperties.json"),
	
	STBPORTMAPPINGS("STBPortMappings.json");
	
	/**
	 * The schemaName.
	 */
	private String schemaName;

	/**
	 * @return the schemaPath
	 */
	public String getFileName() {
		
		return schemaName;
	}

	/**
	 * @param schemaPath
	 */
	private JsonSchema(String schemaPath) {
		this.schemaName = schemaPath;
	}
	
	/**
	 * Fully qualified resource path start with public .
	 * 
	 * @return String
	 */
	public static String getSchemaFolderPath() {

		return "/public/schema/devicemanager/";
	}

}
