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
package com.accenture.avs.device.enums;

/**
 * The Enum IdentificationType.
 */
public enum IdentificationType {

	/** The mac address. */
	macAddress(DataType.STRING, "macAddress"),
	/** The equipment id. */
	equipmentId(DataType.INTEGER, "equipmentId"),
	/** The serial number. */
	serialNumber(DataType.STRING, "serialNumber"),
	/** The ext IP address. */
	extIPAddress(DataType.STRING, "extIPAddress"),
	/** genericSuccessResultCode */
	genericSuccessResultCode(DataType.STRING, "ACN_200"),
	/** genericSuccessResultDescription */
	genericSuccessResultDescription(DataType.STRING, "OK"),
	/** genericFailureResultNotOk */
	genericFailureResultNotOk(DataType.STRING, "KO"),
	/** genericFailureResultCode */
	genericFailureResultCode(DataType.STRING, "ACN_300"),
	/** defaultLanguage */
	defaultLanguage(DataType.STRING, "en"),
	/** genericFailureResultDescription */
	genericFailureResultDescription(DataType.STRING, "300-GENERIC ERROR"),
	/** trueString */
	trueString(DataType.STRING, "true"),
	/** falseString */
	falseString(DataType.STRING, "false"),
	/** uniqueRuleId */
	uniqueRuleId(DataType.LONG, "5"),
	/** formatRuleId */
	formatRuleId(DataType.LONG, "4"),
	/** numericRuleId */
	numericRuleId(DataType.LONG, "3"),
	/** lengthRuleId */
	lengthRuleId(DataType.LONG, "2"),
	/** requiredRuleId */
	requiredRuleId(DataType.LONG, "1"),
	/** commaString */
	commaString(DataType.STRING, ","),
	/** connectionModeBridged */
	connectionModeBridged(DataType.STRING, "Bridged"),
	/** connectionModeImplicitNAT */
	connectionModeImplicitNAT(DataType.STRING, "Implicit NAT"),
	/** connectionModeUpnpNapt */
	connectionModeUpnpNapt(DataType.STRING, "UPnP NAPT"),
	/** connectionModeBridgedId */
	connectionModeBridgedId(DataType.LONG, "1"),
	/** connectionModeImplicitNATId */
	connectionModeImplicitNATId(DataType.LONG, "2"),
	/** connectionModeUpnpNaptId */
	connectionModeUpnpNaptId(DataType.LONG, "3"),
	/** statusEnabled */
	statusEnabled(DataType.STRING, "Enabled"),
	/** statusDisabled */
	statusDisabled(DataType.STRING, "Disabled"),
	/** statusAssigned */
	statusAssigned(DataType.STRING, "Assigned"),
	/** statusUnassigned */
	statusUnassigned(DataType.STRING, "Unassigned"),
    /** missingParameterResultCode */
    missingParameterResultCode(DataType.STRING, "ACN_3000"),
    /** assignedProfileOff */
    assignedProfileOff(DataType.STRING, "OFF");

	/** The data type. */
	private DataType dataType;

	/** The property. */
	private String property;

  /**
   * Instantiates a new identification type.
   *
   * @param dataType the data type
   * @param property the property
   */
  private IdentificationType(DataType dataType, String property) {
    this.dataType = dataType;
    this.property = property;
  }

	/**
	 * Gets the data type.
	 *
	 * @return the data type
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * Gets the property.
	 *
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

  /**
   * To data type.
   *
   * @param value the value
   * @return the object
   */
  public Object toDataType(String value) {
    if (value == null) {
      return value;
    }

		switch (dataType) {
		case INTEGER:
			return Integer.parseInt(value);
		case DATE:
			// TODO use of system level date format to parse the date
		case LONG:
			return Long.parseLong(value);
		default:
			return value;

		}

	}

}
