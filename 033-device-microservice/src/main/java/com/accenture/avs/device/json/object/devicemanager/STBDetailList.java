package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
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
    "HardwareType",
    "AssignedConnectionMode",
    "SupportedConnectionModes",
    "AssignedProfile",
    "AssignedResources",
    "CASDeviceId",
    "VMXClientId",
    "PortMappings",
    "SetTopBoxUDFs"
})
public class STBDetailList implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EquipmentId")
    private String equipmentId;
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
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("OverridingDefaults")
    private String overridingDefaults;
    @JsonProperty("MaxBandwidthUpdates")
    private String maxBandwidthUpdates;
    @JsonProperty("TVQualityInterest")
    private String tVQualityInterest;
    @JsonProperty("HardwareType")
    private String hardwareType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssignedConnectionMode")
    private String assignedConnectionMode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SupportedConnectionModes")
    private String supportedConnectionModes;
    @JsonProperty("AssignedProfile")
    private String assignedProfile;
    @JsonProperty("AssignedResources")
    private List<AssignedResources> assignedResources = new ArrayList<AssignedResources>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("CASDeviceId")
    private String cASDeviceId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("VMXClientId")
    private String vMXClientId;
    @JsonProperty("PortMappings")
    private List<PortMapping> portMappings = new ArrayList<PortMapping>();
    @JsonProperty("SetTopBoxUDFs")
    private List<SetTopBoxUDF> setTopBoxUDFs = new ArrayList<SetTopBoxUDF>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The equipmentId
     */
    @JsonProperty("EquipmentId")
    public String getEquipmentId() {
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
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public STBDetailList withEquipmentId(String equipmentId) {
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

    public STBDetailList withSerialNumber(String serialNumber) {
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

    public STBDetailList withMACAddress(String mACAddress) {
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

    public STBDetailList withIPAddress(String iPAddress) {
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

    public STBDetailList withExtIPAddress(String extIPAddress) {
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

    public STBDetailList withSTBName(String sTBName) {
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

    public STBDetailList withSoftwareVersion(String softwareVersion) {
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

    public STBDetailList withHardwareVersion(String hardwareVersion) {
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

    public STBDetailList withUIVersion(String uIVersion) {
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

    public STBDetailList withAssignmentStatus(String assignmentStatus) {
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

    public STBDetailList withLastUpdateTime(String lastUpdateTime) {
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

    public STBDetailList withLastUpdateUserName(String lastUpdateUserName) {
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

    public STBDetailList withLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The overridingDefaults
     */
    @JsonProperty("OverridingDefaults")
    public String getOverridingDefaults() {
        return overridingDefaults;
    }

    /**
     * 
     * (Required)
     * 
     * @param overridingDefaults
     *     The OverridingDefaults
     */
    @JsonProperty("OverridingDefaults")
    public void setOverridingDefaults(String overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
    }

    public STBDetailList withOverridingDefaults(String overridingDefaults) {
        this.overridingDefaults = overridingDefaults;
        return this;
    }

    /**
     * 
     * @return
     *     The maxBandwidthUpdates
     */
    @JsonProperty("MaxBandwidthUpdates")
    public String getMaxBandwidthUpdates() {
        return maxBandwidthUpdates;
    }

    /**
     * 
     * @param maxBandwidthUpdates
     *     The MaxBandwidthUpdates
     */
    @JsonProperty("MaxBandwidthUpdates")
    public void setMaxBandwidthUpdates(String maxBandwidthUpdates) {
        this.maxBandwidthUpdates = maxBandwidthUpdates;
    }

    public STBDetailList withMaxBandwidthUpdates(String maxBandwidthUpdates) {
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

    public STBDetailList withTVQualityInterest(String tVQualityInterest) {
        this.tVQualityInterest = tVQualityInterest;
        return this;
    }

    /**
     * 
     * @return
     *     The hardwareType
     */
    @JsonProperty("HardwareType")
    public String getHardwareType() {
        return hardwareType;
    }

    /**
     * 
     * @param hardwareType
     *     The HardwareType
     */
    @JsonProperty("HardwareType")
    public void setHardwareType(String hardwareType) {
        this.hardwareType = hardwareType;
    }

    public STBDetailList withHardwareType(String hardwareType) {
        this.hardwareType = hardwareType;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param assignedConnectionMode
     *     The AssignedConnectionMode
     */
    @JsonProperty("AssignedConnectionMode")
    public void setAssignedConnectionMode(String assignedConnectionMode) {
        this.assignedConnectionMode = assignedConnectionMode;
    }

    public STBDetailList withAssignedConnectionMode(String assignedConnectionMode) {
        this.assignedConnectionMode = assignedConnectionMode;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param supportedConnectionModes
     *     The SupportedConnectionModes
     */
    @JsonProperty("SupportedConnectionModes")
    public void setSupportedConnectionModes(String supportedConnectionModes) {
        this.supportedConnectionModes = supportedConnectionModes;
    }

    public STBDetailList withSupportedConnectionModes(String supportedConnectionModes) {
        this.supportedConnectionModes = supportedConnectionModes;
        return this;
    }

    /**
     * 
     * @return
     *     The assignedProfile
     */
    @JsonProperty("AssignedProfile")
    public String getAssignedProfile() {
        return assignedProfile;
    }

    /**
     * 
     * @param assignedProfile
     *     The AssignedProfile
     */
    @JsonProperty("AssignedProfile")
    public void setAssignedProfile(String assignedProfile) {
        this.assignedProfile = assignedProfile;
    }

    public STBDetailList withAssignedProfile(String assignedProfile) {
        this.assignedProfile = assignedProfile;
        return this;
    }

    /**
     * 
     * @return
     *     The assignedResources
     */
    @JsonProperty("AssignedResources")
    public List<AssignedResources> getAssignedResources() {
        return assignedResources;
    }

    /**
     * 
     * @param assignedResources
     *     The AssignedResources
     */
    @JsonProperty("AssignedResources")
    public void setAssignedResources(List<AssignedResources> assignedResources) {
        this.assignedResources = assignedResources;
    }

    public STBDetailList withAssignedResources(List<AssignedResources> assignedResources) {
        this.assignedResources = assignedResources;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param cASDeviceId
     *     The CASDeviceId
     */
    @JsonProperty("CASDeviceId")
    public void setCASDeviceId(String cASDeviceId) {
        this.cASDeviceId = cASDeviceId;
    }

    public STBDetailList withCASDeviceId(String cASDeviceId) {
        this.cASDeviceId = cASDeviceId;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param vMXClientId
     *     The VMXClientId
     */
    @JsonProperty("VMXClientId")
    public void setVMXClientId(String vMXClientId) {
        this.vMXClientId = vMXClientId;
    }

    public STBDetailList withVMXClientId(String vMXClientId) {
        this.vMXClientId = vMXClientId;
        return this;
    }

    /**
     * 
     * @return
     *     The portMappings
     */
    @JsonProperty("PortMappings")
    public List<PortMapping> getPortMappings() {
        return portMappings;
    }

    /**
     * 
     * @param portMappings
     *     The PortMappings
     */
    @JsonProperty("PortMappings")
    public void setPortMappings(List<PortMapping> portMappings) {
        this.portMappings = portMappings;
    }

    public STBDetailList withPortMappings(List<PortMapping> portMappings) {
        this.portMappings = portMappings;
        return this;
    }

    /**
     * 
     * @return
     *     The setTopBoxUDFs
     */
    @JsonProperty("SetTopBoxUDFs")
    public List<SetTopBoxUDF> getSetTopBoxUDFs() {
        return setTopBoxUDFs;
    }

    /**
     * 
     * @param setTopBoxUDFs
     *     The SetTopBoxUDFs
     */
    @JsonProperty("SetTopBoxUDFs")
    public void setSetTopBoxUDFs(List<SetTopBoxUDF> setTopBoxUDFs) {
        this.setTopBoxUDFs = setTopBoxUDFs;
    }

    public STBDetailList withSetTopBoxUDFs(List<SetTopBoxUDF> setTopBoxUDFs) {
        this.setTopBoxUDFs = setTopBoxUDFs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(equipmentId).append(serialNumber).append(mACAddress).append(iPAddress).append(extIPAddress).append(sTBName).append(softwareVersion).append(hardwareVersion).append(uIVersion).append(assignmentStatus).append(lastUpdateTime).append(lastUpdateUserName).append(locationId).append(overridingDefaults).append(maxBandwidthUpdates).append(tVQualityInterest).append(hardwareType).append(assignedConnectionMode).append(supportedConnectionModes).append(assignedProfile).append(assignedResources).append(cASDeviceId).append(vMXClientId).append(portMappings).append(setTopBoxUDFs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBDetailList) == false) {
            return false;
        }
        STBDetailList rhs = ((STBDetailList) other);
        return new EqualsBuilder().append(equipmentId, rhs.equipmentId).append(serialNumber, rhs.serialNumber).append(mACAddress, rhs.mACAddress).append(iPAddress, rhs.iPAddress).append(extIPAddress, rhs.extIPAddress).append(sTBName, rhs.sTBName).append(softwareVersion, rhs.softwareVersion).append(hardwareVersion, rhs.hardwareVersion).append(uIVersion, rhs.uIVersion).append(assignmentStatus, rhs.assignmentStatus).append(lastUpdateTime, rhs.lastUpdateTime).append(lastUpdateUserName, rhs.lastUpdateUserName).append(locationId, rhs.locationId).append(overridingDefaults, rhs.overridingDefaults).append(maxBandwidthUpdates, rhs.maxBandwidthUpdates).append(tVQualityInterest, rhs.tVQualityInterest).append(hardwareType, rhs.hardwareType).append(assignedConnectionMode, rhs.assignedConnectionMode).append(supportedConnectionModes, rhs.supportedConnectionModes).append(assignedProfile, rhs.assignedProfile).append(assignedResources, rhs.assignedResources).append(cASDeviceId, rhs.cASDeviceId).append(vMXClientId, rhs.vMXClientId).append(portMappings, rhs.portMappings).append(setTopBoxUDFs, rhs.setTopBoxUDFs).isEquals();
    }

}
