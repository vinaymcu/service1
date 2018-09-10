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
package com.accenture.avs.device.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for DEVICE_AUDIT table
 * 
 * @author Singh.Saurabh
 *
 */
@Entity 
@Table(name = "DEVICE_AUDIT_VIEW")
public class DeviceAudit {

	/**
	 * Default Constructor
	 * 
	 */
	public DeviceAudit() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param assignedToUsername
	 * @param id
	 */
	public DeviceAudit(String assignedToUsername, Long id) {
		this.assignedToUsername = assignedToUsername;
		this.id = id;
	}
	
	/** ID is PK */
	@Id
	@Column(name = "ID")
	private Long id;
	
	/** deviceType */
	@Column(name = "DEVICE_TYPE")
	private String deviceType;
	
	/** PLATFORM */
	@Column(name = "PLATFORM")
	private String platform;

	/** serialNumber */
	@Column(name = "SERIAL_NUMBER")
	private String serialNumber;
	
	/** internalIpAddress */
	@Column(name = "INTERNAL_IP_ADDRESS")
	private String internalIpAddress;

	/** externalIpAddress */
	@Column(name = "EXTERNAL_IP_ADDRESS")
	private String externalIpAddress;
	
	/** deviceId */
	@Column(name = "DEVICEID")
	private String deviceId;
	
	/** deviceName */
	@Column(name = "DEVICE_NAME")
	private String deviceName;
	
	/** tvQualityInterest */
	@Column(name = "TV_QUALITY_INTEREST")
	private String tvQualityInterest;
	
	/** model */
	@Column(name = "MODEL")
	private String model;
	
	/** vendor */
	@Column(name = "VENDOR")
	private String vendor;

	/** softwareVersion */
	@Column(name = "SOFTWARE_VERSION")
	private String softwareVersion;

	/** uiVersion */
	@Column(name = "UI_VERSION")
	private String uiVersion;
	
	/** assignmentStatus */
	@Column(name = "ASSIGNMENT_STATUS")
	private String assignmentStatus;
	
	/** assignedToUsername */ 
	@Column(name = "ASSIGNED_TO_USERNAME")
	private String assignedToUsername;
	
	/** datetimeOfAssignment */ 
	@Column(name = "DATETIME_OF_ASSIGNMENT")
	private Long datetimeOfAssignment;
	
	/** overridingDefault */
	@Column(name = "OVERRIDING_DEFAULT")
	private Long overridingDefault;
	
	/** maxBandwidthUpdate */
	@Column(name = "MAX_BANDWIDTH_UPDATE")
	private Long maxBandwidthUpdate;
	
	/** deviceProfile */
	@Column(name = "DEVICE_PROFILE")
	private String deviceProfile;
	
	/** deviceProfileBandwidth */
	@Column(name = "DEVICE_PROFILE_BANDWIDTH")
	private Long deviceProfileBandwidth;
	
	/** qoeBandwidth */
	@Column(name = "QOE_BANDWIDTH")
	private Long qoeBandwidth;
	
	/** drmId */
	@Column(name = "DRMID")
	private String drmId;

	/** supportedModes */
	@Column(name = "SUPPORTED_MODES")
	private String supportedModes;

	/** connectionMode */
	@Column(name = "CONNECTION_MODE")
	private String connectionMode;
	
	/** lastUpdatedDatetime */
	//@Id
	@Column(name = "LAST_UPDATED_DATETIME")
	private Long lastUpdatedDatetime;
	
	/** lastUpdateUsername */
	@Column(name = "LAST_UPDATE_USERNAME")
	private String lastUpdateUsername;
	
	/** operation */ 
	@Column(name = "OPERATION")
	private String operation;

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the internalIpAddress
	 */
	public String getInternalIpAddress() {
		return internalIpAddress;
	}

	/**
	 * @param internalIpAddress
	 *            the internalIpAddress to set
	 */
	public void setInternalIpAddress(String internalIpAddress) {
		this.internalIpAddress = internalIpAddress;
	}

	/**
	 * @return the externalIpAddress
	 */
	public String getExternalIpAddress() {
		return externalIpAddress;
	}

	/**
	 * @param externalIpAddress
	 *            the externalIpAddress to set
	 */
	public void setExternalIpAddress(String externalIpAddress) {
		this.externalIpAddress = externalIpAddress;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 *            the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @param vendor
	 *            the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}	

	/**
	 * @return the softwareVersion
	 */
	public String getSoftwareVersion() {
		return softwareVersion;
	}

	/**
	 * @param softwareVersion
	 *            the softwareVersion to set
	 */
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	/**
	 * @return the uiVersion
	 */
	public String getUiVersion() {
		return uiVersion;
	}

	/**
	 * @param uiVersion
	 *            the uiVersion to set
	 */
	public void setUiVersion(String uiVersion) {
		this.uiVersion = uiVersion;
	}

	/**
	 * @return the assignedToUsername
	 */
	public String getAssignedToUsername() {
		return assignedToUsername;
	}

	/**
	 * @param assignedToUsername
	 *            the assignedToUsername to set
	 */
	public void setAssignedToUsername(String assignedToUsername) {
		this.assignedToUsername = assignedToUsername;
	}

	/**
	 * @return the assignmentStatus
	 */
	public String getAssignmentStatus() {
		return assignmentStatus;
	}

	/**
	 * @param assignmentStatus
	 *            the assignmentStatus to set
	 */
	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	/**
	 * @return the overridingDefault
	 */
	public Long getOverridingDefault() {
		return overridingDefault;
	}

	/**
	 * @param overridingDefault
	 *            the overridingDefault to set
	 */
	public void setOverridingDefault(Long overridingDefault) {
		this.overridingDefault = overridingDefault;
	}

	/**
	 * @return the maxBandwidthUpdate
	 */
	public Long getMaxBandwidthUpdate() {
		return maxBandwidthUpdate;
	}

	/**
	 * @param maxBandwidthUpdate
	 *            the maxBandwidthUpdate to set
	 */
	public void setMaxBandwidthUpdate(Long maxBandwidthUpdate) {
		this.maxBandwidthUpdate = maxBandwidthUpdate;
	}

	/**
	 * @return the tvQualityInterest
	 */
	public String getTvQualityInterest() {
		return tvQualityInterest;
	}

	/**
	 * @param tvQualityInterest
	 *            the tvQualityInterest to set
	 */
	public void setTvQualityInterest(String tvQualityInterest) {
		this.tvQualityInterest = tvQualityInterest;
	}

	/**
	 * @return the datetimeOfAssignment
	 */
	public Long getDatetimeOfAssignment() {
		return datetimeOfAssignment;
	}

	/**
	 * @param datetimeOfAssignment
	 *            the datetimeOfAssignment to set
	 */
	public void setDatetimeOfAssignment(Long datetimeOfAssignment) {
		this.datetimeOfAssignment = datetimeOfAssignment;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the supportedModes
	 */
	public String getSupportedModes() {
		return supportedModes;
	}

	/**
	 * @param supportedModes
	 *            the supportedModes to set
	 */
	public void setSupportedModes(String supportedModes) {
		this.supportedModes = supportedModes;
	}

	/**
	 * @return the connectionMode
	 */
	public String getConnectionMode() {
		return connectionMode;
	}

	/**
	 * @param connectionMode
	 *            the connectionMode to set
	 */
	public void setConnectionMode(String connectionMode) {
		this.connectionMode = connectionMode;
	}

	/**
	 * @return the getLastUpdatedDatetime
	 */
	public Long getLastUpdatedDatetime() {
		return lastUpdatedDatetime;
	}

	/**
	 * @param lastUpdatedDatetime
	 *            the lastUpdatedDatetime to set
	 */
	public void setLastUpdatedDatetime(Long lastUpdatedDatetime) {
		this.lastUpdatedDatetime = lastUpdatedDatetime;
	}

	/**
	 * @return the lastUpdateUsername
	 */
	public String getLastUpdateUsername() {
		return lastUpdateUsername;
	}

	/**
	 * @param lastUpdateUsername
	 *            the lastUpdateUsername to set
	 */
	public void setLastUpdateUsername(String lastUpdateUsername) {
		this.lastUpdateUsername = lastUpdateUsername;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the deviceProfile
	 */
	public String getDeviceProfile() {
		return deviceProfile;
	}

	/**
	 * @param deviceProfile the deviceProfile to set
	 */
	public void setDeviceProfile(String deviceProfile) {
		this.deviceProfile = deviceProfile;
	}

	/**
	 * @return the deviceProfileBandwidth
	 */
	public Long getDeviceProfileBandwidth() {
		return deviceProfileBandwidth;
	}

	/**
	 * @param deviceProfileBandwidth the deviceProfileBandwidth to set
	 */
	public void setDeviceProfileBandwidth(Long deviceProfileBandwidth) {
		this.deviceProfileBandwidth = deviceProfileBandwidth;
	}

	/**
	 * @return the qoeBandwidth
	 */
	public Long getQoeBandwidth() {
		return qoeBandwidth;
	}

	/**
	 * @param qoeBandwidth the qoeBandwidth to set
	 */
	public void setQoeBandwidth(Long qoeBandwidth) {
		this.qoeBandwidth = qoeBandwidth;
	}

	/**
	 * @return the drmId
	 */
	public String getDrmId() {
		return drmId;
	}

	/**
	 * @param drmId the drmId to set
	 */
	public void setDrmId(String drmId) {
		this.drmId = drmId;
	}
}
