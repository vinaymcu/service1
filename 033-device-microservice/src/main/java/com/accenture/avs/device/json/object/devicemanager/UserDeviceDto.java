
package com.accenture.avs.device.json.object.devicemanager;

import java.util.ArrayList;
import java.util.List;
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
    "uiLanguage",
    "audioLanguage",
    "hdCapable",
    "profile",
    "genericDeviceSettings",
    "drmId"
})
public class UserDeviceDto {

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
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("softwareVersion")
    private String softwareVersion;
    /**
     * 
     * (Required)
     * 
     */
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
    @JsonProperty("lastUpdateUserName")
    private String lastUpdateUserName;
    @JsonProperty("overridingDefaults")
    private Integer overridingDefaults;
    @JsonProperty("maxBandwidthUpdates")
    private Integer maxBandwidthUpdates;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tvQualityInterest")
    private String tvQualityInterest;
    @JsonProperty("uiLanguage")
    private String uiLanguage;
    @JsonProperty("audioLanguage")
    private String audioLanguage;
    @JsonProperty("hdCapable")
    private Boolean hdCapable;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("genericDeviceSettings")
    private List<GenericDeviceSetting> genericDeviceSettings = new ArrayList<GenericDeviceSetting>();
    /**
     * 
     * (Required)
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
     * (Required)
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
     * (Required)
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
     * (Required)
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
     * (Required)
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
     *     The assignmentStatus
     */
    @JsonProperty("assignmentStatus")
    public String getAssignmentStatus() {
        return assignmentStatus;
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
     * @return
     *     The lastUpdateUserName
     */
    @JsonProperty("lastUpdateUserName")
    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    /**
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
    public Integer getOverridingDefaults() {
        return overridingDefaults;
    }

    /**
     * 
     * @param overridingDefaults
     *     The overridingDefaults
     */
    @JsonProperty("overridingDefaults")
    public void setOverridingDefaults(Integer overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
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

    /**
     * 
     * (Required)
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
     * (Required)
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
     *     The uiLanguage
     */
    @JsonProperty("uiLanguage")
    public String getUiLanguage() {
        return uiLanguage;
    }

    /**
     * 
     * @param uiLanguage
     *     The uiLanguage
     */
    @JsonProperty("uiLanguage")
    public void setUiLanguage(String uiLanguage) {
        this.uiLanguage = uiLanguage;
    }

    /**
     * 
     * @return
     *     The audioLanguage
     */
    @JsonProperty("audioLanguage")
    public String getAudioLanguage() {
        return audioLanguage;
    }

    /**
     * 
     * @param audioLanguage
     *     The audioLanguage
     */
    @JsonProperty("audioLanguage")
    public void setAudioLanguage(String audioLanguage) {
        this.audioLanguage = audioLanguage;
    }

    /**
     * 
     * @return
     *     The hdCapable
     */
    @JsonProperty("hdCapable")
    public Boolean getHdCapable() {
        return hdCapable;
    }

    /**
     * 
     * @param hdCapable
     *     The hdCapable
     */
    @JsonProperty("hdCapable")
    public void setHdCapable(Boolean hdCapable) {
        this.hdCapable = hdCapable;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The profile
     */
    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    /**
     * 
     * (Required)
     * 
     * @param profile
     *     The profile
     */
    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * 
     * @return
     *     The genericDeviceSettings
     */
    @JsonProperty("genericDeviceSettings")
    public List<GenericDeviceSetting> getGenericDeviceSettings() {
        return genericDeviceSettings;
    }

    /**
     * 
     * @param genericDeviceSettings
     *     The genericDeviceSettings
     */
    @JsonProperty("genericDeviceSettings")
    public void setGenericDeviceSettings(List<GenericDeviceSetting> genericDeviceSettings) {
        this.genericDeviceSettings = genericDeviceSettings;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deviceId).append(serialNumber).append(ipAddress).append(extIPAddress).append(deviceName).append(softwareVersion).append(model).append(vendor).append(deviceType).append(platform).append(uiVersion).append(assignmentStatus).append(lastUpdateTime).append(lastUpdateUserName).append(overridingDefaults).append(maxBandwidthUpdates).append(tvQualityInterest).append(uiLanguage).append(audioLanguage).append(hdCapable).append(profile).append(genericDeviceSettings).append(drmId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserDeviceDto) == false) {
            return false;
        }
        UserDeviceDto rhs = ((UserDeviceDto) other);
        return new EqualsBuilder().append(deviceId, rhs.deviceId).append(serialNumber, rhs.serialNumber).append(ipAddress, rhs.ipAddress).append(extIPAddress, rhs.extIPAddress).append(deviceName, rhs.deviceName).append(softwareVersion, rhs.softwareVersion).append(model, rhs.model).append(vendor, rhs.vendor).append(deviceType, rhs.deviceType).append(platform, rhs.platform).append(uiVersion, rhs.uiVersion).append(assignmentStatus, rhs.assignmentStatus).append(lastUpdateTime, rhs.lastUpdateTime).append(lastUpdateUserName, rhs.lastUpdateUserName).append(overridingDefaults, rhs.overridingDefaults).append(maxBandwidthUpdates, rhs.maxBandwidthUpdates).append(tvQualityInterest, rhs.tvQualityInterest).append(uiLanguage, rhs.uiLanguage).append(audioLanguage, rhs.audioLanguage).append(hdCapable, rhs.hdCapable).append(profile, rhs.profile).append(genericDeviceSettings, rhs.genericDeviceSettings).append(drmId, rhs.drmId).isEquals();
    }

}
