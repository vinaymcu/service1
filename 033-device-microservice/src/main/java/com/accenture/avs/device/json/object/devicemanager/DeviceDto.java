package com.accenture.avs.device.json.object.devicemanager;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "deviceId",
    "serialNumber",
    "ipAddress",
    "extIPAddress",
    "deviceName",
    "softwareVersion",
    "model",
    "vendor",
    "deviceType",
    "platform",
    "uiVersion",
    "assignmentStatus",
    "lastUpdateTime",
    "lastUpdateUserName",
    "overridingDefaults",
    "maxBandwidthUpdates",
    "tvQualityInterest",
    "assignedProfile",
    "drmId"
})
public class DeviceDto {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceId")
    private String deviceId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("ipAddress")
    private String ipAddress;
    @JsonProperty("extIPAddress")
    private String extIPAddress;
    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("softwareVersion")
    private String softwareVersion;
    @JsonProperty("model")
    private String model;
    @JsonProperty("vendor")
    private String vendor;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceType")
    private String deviceType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("uiVersion")
    private String uiVersion;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("assignmentStatus")
    private String assignmentStatus;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lastUpdateUserName")
    private String lastUpdateUserName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("overridingDefaults")
    private Integer overridingDefaults;
    @JsonProperty("maxBandwidthUpdates")
    private Integer maxBandwidthUpdates;
    @JsonProperty("tvQualityInterest")
    private String tvQualityInterest;
    @JsonProperty("assignedProfile")
    private String assignedProfile;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("drmId")
    private String drmId;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The deviceId
     */
    @JsonProperty("deviceId")
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * (Required)
     * 
     * @param deviceId
     *     The deviceId
     */
    @JsonProperty("deviceId")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceDto withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The serialNumber
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * 
     * (Required)
     * 
     * @param serialNumber
     *     The serialNumber
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceDto withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The ipAddress
     */
    @JsonProperty("ipAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 
     * @param ipAddress
     *     The ipAddress
     */
    @JsonProperty("ipAddress")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public DeviceDto withIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * 
     * @return
     *     The extIPAddress
     */
    @JsonProperty("extIPAddress")
    public String getExtIPAddress() {
        return extIPAddress;
    }

    /**
     * 
     * @param extIPAddress
     *     The extIPAddress
     */
    @JsonProperty("extIPAddress")
    public void setExtIPAddress(String extIPAddress) {
        this.extIPAddress = extIPAddress;
    }

    public DeviceDto withExtIPAddress(String extIPAddress) {
        this.extIPAddress = extIPAddress;
        return this;
    }

    /**
     * 
     * @return
     *     The deviceName
     */
    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 
     * @param deviceName
     *     The deviceName
     */
    @JsonProperty("deviceName")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceDto withDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    /**
     * 
     * @return
     *     The softwareVersion
     */
    @JsonProperty("softwareVersion")
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * 
     * @param softwareVersion
     *     The softwareVersion
     */
    @JsonProperty("softwareVersion")
    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public DeviceDto withSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The model
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * 
     * @param model
     *     The model
     */
    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    public DeviceDto withModel(String model) {
        this.model = model;
        return this;
    }

    /**
     * 
     * @return
     *     The vendor
     */
    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    /**
     * 
     * @param vendor
     *     The vendor
     */
    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public DeviceDto withVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The deviceType
     */
    @JsonProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 
     * (Required)
     * 
     * @param deviceType
     *     The deviceType
     */
    @JsonProperty("deviceType")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public DeviceDto withDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The platform
     */
    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    /**
     * 
     * (Required)
     * 
     * @param platform
     *     The platform
     */
    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public DeviceDto withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    /**
     * 
     * @return
     *     The uiVersion
     */
    @JsonProperty("uiVersion")
    public String getUiVersion() {
        return uiVersion;
    }

    /**
     * 
     * @param uiVersion
     *     The uiVersion
     */
    @JsonProperty("uiVersion")
    public void setUiVersion(String uiVersion) {
        this.uiVersion = uiVersion;
    }

    public DeviceDto withUiVersion(String uiVersion) {
        this.uiVersion = uiVersion;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assignmentStatus
     */
    @JsonProperty("assignmentStatus")
    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    /**
     * 
     * (Required)
     * 
     * @param assignmentStatus
     *     The assignmentStatus
     */
    @JsonProperty("assignmentStatus")
    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public DeviceDto withAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The lastUpdateTime
     */
    @JsonProperty("lastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 
     * (Required)
     * 
     * @param lastUpdateTime
     *     The lastUpdateTime
     */
    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public DeviceDto withLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The lastUpdateUserName
     */
    @JsonProperty("lastUpdateUserName")
    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    /**
     * 
     * (Required)
     * 
     * @param lastUpdateUserName
     *     The lastUpdateUserName
     */
    @JsonProperty("lastUpdateUserName")
    public void setLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
    }

    public DeviceDto withLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The overridingDefaults
     */
    @JsonProperty("overridingDefaults")
    public Integer getOverridingDefaults() {
        return overridingDefaults;
    }

    /**
     * 
     * (Required)
     * 
     * @param overridingDefaults
     *     The overridingDefaults
     */
    @JsonProperty("overridingDefaults")
    public void setOverridingDefaults(Integer overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
    }

    public DeviceDto withOverridingDefaults(Integer overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
        return this;
    }

    /**
     * 
     * @return
     *     The maxBandwidthUpdates
     */
    @JsonProperty("maxBandwidthUpdates")
    public Integer getMaxBandwidthUpdates() {
        return maxBandwidthUpdates;
    }

    /**
     * 
     * @param maxBandwidthUpdates
     *     The maxBandwidthUpdates
     */
    @JsonProperty("maxBandwidthUpdates")
    public void setMaxBandwidthUpdates(Integer maxBandwidthUpdates) {
        this.maxBandwidthUpdates = maxBandwidthUpdates;
    }

    public DeviceDto withMaxBandwidthUpdates(Integer maxBandwidthUpdates) {
        this.maxBandwidthUpdates = maxBandwidthUpdates;
        return this;
    }

    /**
     * 
     * @return
     *     The tvQualityInterest
     */
    @JsonProperty("tvQualityInterest")
    public String getTvQualityInterest() {
        return tvQualityInterest;
    }

    /**
     * 
     * @param tvQualityInterest
     *     The tvQualityInterest
     */
    @JsonProperty("tvQualityInterest")
    public void setTvQualityInterest(String tvQualityInterest) {
        this.tvQualityInterest = tvQualityInterest;
    }

    public DeviceDto withTvQualityInterest(String tvQualityInterest) {
        this.tvQualityInterest = tvQualityInterest;
        return this;
    }

    /**
     * 
     * @return
     *     The assignedProfile
     */
    @JsonProperty("assignedProfile")
    public String getAssignedProfile() {
        return assignedProfile;
    }

    /**
     * 
     * @param assignedProfile
     *     The assignedProfile
     */
    @JsonProperty("assignedProfile")
    public void setAssignedProfile(String assignedProfile) {
        this.assignedProfile = assignedProfile;
    }

    public DeviceDto withAssignedProfile(String assignedProfile) {
        this.assignedProfile = assignedProfile;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The drmId
     */
    @JsonProperty("drmId")
    public String getDrmId() {
        return drmId;
    }

    /**
     * 
     * (Required)
     * 
     * @param drmId
     *     The drmId
     */
    @JsonProperty("drmId")
    public void setDrmId(String drmId) {
        this.drmId = drmId;
    }

    public DeviceDto withDrmId(String drmId) {
        this.drmId = drmId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deviceId).append(serialNumber).append(ipAddress).append(extIPAddress).append(deviceName).append(softwareVersion).append(model).append(vendor).append(deviceType).append(platform).append(uiVersion).append(assignmentStatus).append(lastUpdateTime).append(lastUpdateUserName).append(overridingDefaults).append(maxBandwidthUpdates).append(tvQualityInterest).append(assignedProfile).append(drmId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeviceDto) == false) {
            return false;
        }
        DeviceDto rhs = ((DeviceDto) other);
        return new EqualsBuilder().append(deviceId, rhs.deviceId).append(serialNumber, rhs.serialNumber).append(ipAddress, rhs.ipAddress).append(extIPAddress, rhs.extIPAddress).append(deviceName, rhs.deviceName).append(softwareVersion, rhs.softwareVersion).append(model, rhs.model).append(vendor, rhs.vendor).append(deviceType, rhs.deviceType).append(platform, rhs.platform).append(uiVersion, rhs.uiVersion).append(assignmentStatus, rhs.assignmentStatus).append(lastUpdateTime, rhs.lastUpdateTime).append(lastUpdateUserName, rhs.lastUpdateUserName).append(overridingDefaults, rhs.overridingDefaults).append(maxBandwidthUpdates, rhs.maxBandwidthUpdates).append(tvQualityInterest, rhs.tvQualityInterest).append(assignedProfile, rhs.assignedProfile).append(drmId, rhs.drmId).isEquals();
    }

}
