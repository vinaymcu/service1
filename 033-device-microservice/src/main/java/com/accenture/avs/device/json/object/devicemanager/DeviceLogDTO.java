
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
    "userName",
    "lastUpdateTime",
    "lastUpdateUserName",
    "overridingDefaults",
    "maxBandwidthUpdates",
    "tvQualityInterest",
    "assignedProfile",
    "drmId",
    "operation"
})
public class DeviceLogDTO {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceId")
    private String deviceId;   
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
    @JsonProperty("userName")
    private String userName;
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
    @JsonProperty("overridingDefaults")
    private String overridingDefaults;
    @JsonProperty("maxBandwidthUpdates")
    private String maxBandwidthUpdates;
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
     */
    @JsonProperty("operation")
    private String operation;

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

    /**
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
     * @param serialNumber
     *     The serialNumber
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    /**
     * 
     * @return
     *     The userName
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName
     *     The userName
     */
    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**    
     * 
     * @return
     *     The overridingDefaults
     */
    @JsonProperty("overridingDefaults")
    public String getOverridingDefaults() {
        return overridingDefaults;
    }

    /**   
     * 
     * @param overridingDefaults
     *     The overridingDefaults
     */
    @JsonProperty("overridingDefaults")
    public void setOverridingDefaults(String overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
    }

    /**
     * 
     * @return
     *     The maxBandwidthUpdates
     */
    @JsonProperty("maxBandwidthUpdates")
    public String getMaxBandwidthUpdates() {
        return maxBandwidthUpdates;
    }

    /**
     * 
     * @param maxBandwidthUpdates
     *     The maxBandwidthUpdates
     */
    @JsonProperty("maxBandwidthUpdates")
    public void setMaxBandwidthUpdates(String maxBandwidthUpdates) {
        this.maxBandwidthUpdates = maxBandwidthUpdates;
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

    /**
     * 
     * (Required)
     * 
     * @return
     *     The operation
     */
    @JsonProperty("operation")
    public String getOperation() {
        return operation;
    }

    /**
     * 
     * (Required)
     * 
     * @param operation
     *     The operation
     */
    @JsonProperty("operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deviceId).append(serialNumber).append(ipAddress).append(extIPAddress).append(deviceName).append(softwareVersion).append(model).append(vendor).append(deviceType).append(platform).append(uiVersion).append(assignmentStatus).append(userName).append(lastUpdateTime).append(lastUpdateUserName).append(overridingDefaults).append(maxBandwidthUpdates).append(tvQualityInterest).append(assignedProfile).append(drmId).append(operation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeviceLogDTO) == false) {
            return false;
        }
        DeviceLogDTO rhs = ((DeviceLogDTO) other);
        return new EqualsBuilder().append(deviceId, rhs.deviceId).append(serialNumber, rhs.serialNumber).append(ipAddress, rhs.ipAddress).append(extIPAddress, rhs.extIPAddress).append(deviceName, rhs.deviceName).append(softwareVersion, rhs.softwareVersion).append(model, rhs.model).append(vendor, rhs.vendor).append(deviceType, rhs.deviceType).append(platform, rhs.platform).append(uiVersion, rhs.uiVersion).append(assignmentStatus, rhs.assignmentStatus).append(userName, rhs.userName).append(lastUpdateTime, rhs.lastUpdateTime).append(lastUpdateUserName, rhs.lastUpdateUserName).append(overridingDefaults, rhs.overridingDefaults).append(maxBandwidthUpdates, rhs.maxBandwidthUpdates).append(tvQualityInterest, rhs.tvQualityInterest).append(assignedProfile, rhs.assignedProfile).append(drmId, rhs.drmId).append(operation, rhs.operation).isEquals();
    }

}
