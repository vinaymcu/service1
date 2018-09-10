
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
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
    "Action",
    "EquipmentId",
    "SerialNumber",
    "MACAddress",
    "IPAddress",
    "ExtIPAddress",
    "STBName",
    "SoftwareVersion",
    "HardwareVersion",
    "UIVersion",
    "AssignmentStatus",
    "LastUpdateTime",
    "LastUpdateUserName",
    "LocationId",
    "OverridingDefaults",
    "MaxBandwidthUpdates",
    "TVQualityInterest",
    "AssignedConnectionMode",
    "SupportedConnectionModes",
    "AssignedToSubscriber",
    "CASDeviceId",
    "VMXClientId"
})
public class STBUpdateLog implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Action")
    private String action;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EquipmentId")
    private Integer equipmentId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SerialNumber")
    private String serialNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("MACAddress")
    private String mACAddress;
    @JsonProperty("IPAddress")
    private String iPAddress;
    @JsonProperty("ExtIPAddress")
    private String extIPAddress;
    @JsonProperty("STBName")
    private String sTBName;
    @JsonProperty("SoftwareVersion")
    private String softwareVersion;
    @JsonProperty("HardwareVersion")
    private String hardwareVersion;
    @JsonProperty("UIVersion")
    private String uIVersion;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssignmentStatus")
    private String assignmentStatus;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("LastUpdateUserName")
    private String lastUpdateUserName;
    @JsonProperty("LocationId")
    private String locationId;
    @JsonProperty("OverridingDefaults")
    private Integer overridingDefaults;
    @JsonProperty("MaxBandwidthUpdates")
    private Integer maxBandwidthUpdates;
    @JsonProperty("TVQualityInterest")
    private String tVQualityInterest;
    @JsonProperty("AssignedConnectionMode")
    private String assignedConnectionMode;
    @JsonProperty("SupportedConnectionModes")
    private String supportedConnectionModes;
    @JsonProperty("AssignedToSubscriber")
    private String assignedToSubscriber;
    @JsonProperty("CASDeviceId")
    private String cASDeviceId;
    @JsonProperty("VMXClientId")
    private String vMXClientId;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The action
     */
    @JsonProperty("Action")
    public String getAction() {
        return action;
    }

    /**
     * 
     * (Required)
     * 
     * @param action
     *     The Action
     */
    @JsonProperty("Action")
    public void setAction(String action) {
        this.action = action;
    }

    public STBUpdateLog withAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The equipmentId
     */
    @JsonProperty("EquipmentId")
    public Integer getEquipmentId() {
        return equipmentId;
    }

    /**
     * 
     * (Required)
     * 
     * @param equipmentId
     *     The EquipmentId
     */
    @JsonProperty("EquipmentId")
    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public STBUpdateLog withEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The serialNumber
     */
    @JsonProperty("SerialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * 
     * (Required)
     * 
     * @param serialNumber
     *     The SerialNumber
     */
    @JsonProperty("SerialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public STBUpdateLog withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The mACAddress
     */
    @JsonProperty("MACAddress")
    public String getMACAddress() {
        return mACAddress;
    }

    /**
     * 
     * (Required)
     * 
     * @param mACAddress
     *     The MACAddress
     */
    @JsonProperty("MACAddress")
    public void setMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
    }

    public STBUpdateLog withMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
        return this;
    }

    /**
     * 
     * @return
     *     The iPAddress
     */
    @JsonProperty("IPAddress")
    public String getIPAddress() {
        return iPAddress;
    }

    /**
     * 
     * @param iPAddress
     *     The IPAddress
     */
    @JsonProperty("IPAddress")
    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public STBUpdateLog withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

    /**
     * 
     * @return
     *     The extIPAddress
     */
    @JsonProperty("ExtIPAddress")
    public String getExtIPAddress() {
        return extIPAddress;
    }

    /**
     * 
     * @param extIPAddress
     *     The ExtIPAddress
     */
    @JsonProperty("ExtIPAddress")
    public void setExtIPAddress(String extIPAddress) {
        this.extIPAddress = extIPAddress;
    }

    public STBUpdateLog withExtIPAddress(String extIPAddress) {
        this.extIPAddress = extIPAddress;
        return this;
    }

    /**
     * 
     * @return
     *     The sTBName
     */
    @JsonProperty("STBName")
    public String getSTBName() {
        return sTBName;
    }

    /**
     * 
     * @param sTBName
     *     The STBName
     */
    @JsonProperty("STBName")
    public void setSTBName(String sTBName) {
        this.sTBName = sTBName;
    }

    public STBUpdateLog withSTBName(String sTBName) {
        this.sTBName = sTBName;
        return this;
    }

    /**
     * 
     * @return
     *     The softwareVersion
     */
    @JsonProperty("SoftwareVersion")
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * 
     * @param softwareVersion
     *     The SoftwareVersion
     */
    @JsonProperty("SoftwareVersion")
    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public STBUpdateLog withSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The hardwareVersion
     */
    @JsonProperty("HardwareVersion")
    public String getHardwareVersion() {
        return hardwareVersion;
    }

    /**
     * 
     * @param hardwareVersion
     *     The HardwareVersion
     */
    @JsonProperty("HardwareVersion")
    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public STBUpdateLog withHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The uIVersion
     */
    @JsonProperty("UIVersion")
    public String getUIVersion() {
        return uIVersion;
    }

    /**
     * 
     * @param uIVersion
     *     The UIVersion
     */
    @JsonProperty("UIVersion")
    public void setUIVersion(String uIVersion) {
        this.uIVersion = uIVersion;
    }

    public STBUpdateLog withUIVersion(String uIVersion) {
        this.uIVersion = uIVersion;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assignmentStatus
     */
    @JsonProperty("AssignmentStatus")
    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    /**
     * 
     * (Required)
     * 
     * @param assignmentStatus
     *     The AssignmentStatus
     */
    @JsonProperty("AssignmentStatus")
    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public STBUpdateLog withAssignmentStatus(String assignmentStatus) {
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
    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 
     * (Required)
     * 
     * @param lastUpdateTime
     *     The LastUpdateTime
     */
    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public STBUpdateLog withLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    /**
     * 
     * @return
     *     The lastUpdateUserName
     */
    @JsonProperty("LastUpdateUserName")
    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    /**
     * 
     * @param lastUpdateUserName
     *     The LastUpdateUserName
     */
    @JsonProperty("LastUpdateUserName")
    public void setLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
    }

    public STBUpdateLog withLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
        return this;
    }

    /**
     * 
     * @return
     *     The locationId
     */
    @JsonProperty("LocationId")
    public String getLocationId() {
        return locationId;
    }

    /**
     * 
     * @param locationId
     *     The LocationId
     */
    @JsonProperty("LocationId")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public STBUpdateLog withLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }

    /**
     * 
     * @return
     *     The overridingDefaults
     */
    @JsonProperty("OverridingDefaults")
    public Integer getOverridingDefaults() {
        return overridingDefaults;
    }

    /**
     * 
     * @param overridingDefaults
     *     The OverridingDefaults
     */
    @JsonProperty("OverridingDefaults")
    public void setOverridingDefaults(Integer overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
    }

    public STBUpdateLog withOverridingDefaults(Integer overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
        return this;
    }

    /**
     * 
     * @return
     *     The maxBandwidthUpdates
     */
    @JsonProperty("MaxBandwidthUpdates")
    public Integer getMaxBandwidthUpdates() {
        return maxBandwidthUpdates;
    }

    /**
     * 
     * @param maxBandwidthUpdates
     *     The MaxBandwidthUpdates
     */
    @JsonProperty("MaxBandwidthUpdates")
    public void setMaxBandwidthUpdates(Integer maxBandwidthUpdates) {
        this.maxBandwidthUpdates = maxBandwidthUpdates;
    }

    public STBUpdateLog withMaxBandwidthUpdates(Integer maxBandwidthUpdates) {
        this.maxBandwidthUpdates = maxBandwidthUpdates;
        return this;
    }

    /**
     * 
     * @return
     *     The tVQualityInterest
     */
    @JsonProperty("TVQualityInterest")
    public String getTVQualityInterest() {
        return tVQualityInterest;
    }

    /**
     * 
     * @param tVQualityInterest
     *     The TVQualityInterest
     */
    @JsonProperty("TVQualityInterest")
    public void setTVQualityInterest(String tVQualityInterest) {
        this.tVQualityInterest = tVQualityInterest;
    }

    public STBUpdateLog withTVQualityInterest(String tVQualityInterest) {
        this.tVQualityInterest = tVQualityInterest;
        return this;
    }

    /**
     * 
     * @return
     *     The assignedConnectionMode
     */
    @JsonProperty("AssignedConnectionMode")
    public String getAssignedConnectionMode() {
        return assignedConnectionMode;
    }

    /**
     * 
     * @param assignedConnectionMode
     *     The AssignedConnectionMode
     */
    @JsonProperty("AssignedConnectionMode")
    public void setAssignedConnectionMode(String assignedConnectionMode) {
        this.assignedConnectionMode = assignedConnectionMode;
    }

    public STBUpdateLog withAssignedConnectionMode(String assignedConnectionMode) {
        this.assignedConnectionMode = assignedConnectionMode;
        return this;
    }

    /**
     * 
     * @return
     *     The supportedConnectionModes
     */
    @JsonProperty("SupportedConnectionModes")
    public String getSupportedConnectionModes() {
        return supportedConnectionModes;
    }

    /**
     * 
     * @param supportedConnectionModes
     *     The SupportedConnectionModes
     */
    @JsonProperty("SupportedConnectionModes")
    public void setSupportedConnectionModes(String supportedConnectionModes) {
        this.supportedConnectionModes = supportedConnectionModes;
    }

    public STBUpdateLog withSupportedConnectionModes(String supportedConnectionModes) {
        this.supportedConnectionModes = supportedConnectionModes;
        return this;
    }

    /**
     * 
     * @return
     *     The assignedToSubscriber
     */
    @JsonProperty("AssignedToSubscriber")
    public String getAssignedToSubscriber() {
        return assignedToSubscriber;
    }

    /**
     * 
     * @param assignedToSubscriber
     *     The AssignedToSubscriber
     */
    @JsonProperty("AssignedToSubscriber")
    public void setAssignedToSubscriber(String assignedToSubscriber) {
        this.assignedToSubscriber = assignedToSubscriber;
    }

    public STBUpdateLog withAssignedToSubscriber(String assignedToSubscriber) {
        this.assignedToSubscriber = assignedToSubscriber;
        return this;
    }

    /**
     * 
     * @return
     *     The cASDeviceId
     */
    @JsonProperty("CASDeviceId")
    public String getCASDeviceId() {
        return cASDeviceId;
    }

    /**
     * 
     * @param cASDeviceId
     *     The CASDeviceId
     */
    @JsonProperty("CASDeviceId")
    public void setCASDeviceId(String cASDeviceId) {
        this.cASDeviceId = cASDeviceId;
    }

    public STBUpdateLog withCASDeviceId(String cASDeviceId) {
        this.cASDeviceId = cASDeviceId;
        return this;
    }

    /**
     * 
     * @return
     *     The vMXClientId
     */
    @JsonProperty("VMXClientId")
    public String getVMXClientId() {
        return vMXClientId;
    }

    /**
     * 
     * @param vMXClientId
     *     The VMXClientId
     */
    @JsonProperty("VMXClientId")
    public void setVMXClientId(String vMXClientId) {
        this.vMXClientId = vMXClientId;
    }

    public STBUpdateLog withVMXClientId(String vMXClientId) {
        this.vMXClientId = vMXClientId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(action).append(equipmentId).append(serialNumber).append(mACAddress).append(iPAddress).append(extIPAddress).append(sTBName).append(softwareVersion).append(hardwareVersion).append(uIVersion).append(assignmentStatus).append(lastUpdateTime).append(lastUpdateUserName).append(locationId).append(overridingDefaults).append(maxBandwidthUpdates).append(tVQualityInterest).append(assignedConnectionMode).append(supportedConnectionModes).append(assignedToSubscriber).append(cASDeviceId).append(vMXClientId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBUpdateLog) == false) {
            return false;
        }
        STBUpdateLog rhs = ((STBUpdateLog) other);
        return new EqualsBuilder().append(action, rhs.action).append(equipmentId, rhs.equipmentId).append(serialNumber, rhs.serialNumber).append(mACAddress, rhs.mACAddress).append(iPAddress, rhs.iPAddress).append(extIPAddress, rhs.extIPAddress).append(sTBName, rhs.sTBName).append(softwareVersion, rhs.softwareVersion).append(hardwareVersion, rhs.hardwareVersion).append(uIVersion, rhs.uIVersion).append(assignmentStatus, rhs.assignmentStatus).append(lastUpdateTime, rhs.lastUpdateTime).append(lastUpdateUserName, rhs.lastUpdateUserName).append(locationId, rhs.locationId).append(overridingDefaults, rhs.overridingDefaults).append(maxBandwidthUpdates, rhs.maxBandwidthUpdates).append(tVQualityInterest, rhs.tVQualityInterest).append(assignedConnectionMode, rhs.assignedConnectionMode).append(supportedConnectionModes, rhs.supportedConnectionModes).append(assignedToSubscriber, rhs.assignedToSubscriber).append(cASDeviceId, rhs.cASDeviceId).append(vMXClientId, rhs.vMXClientId).isEquals();
    }

}
