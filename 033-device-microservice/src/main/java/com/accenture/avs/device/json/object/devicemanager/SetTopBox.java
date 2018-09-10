
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
    "SerialNumber",
    "MACAddress",
    "IPAddress",
    "SoftwareVersion",
    "HardwareVersion",
    "UIVersion",
    "OverridingDefaults",
    "MaxBandwidthUpdates",
    "AssignedResources",
    "CASDeviceId",
    "VMXClientId",
    "SetTopBoxUDFs"
})
public class SetTopBox implements Serializable
{

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
    @JsonProperty("SoftwareVersion")
    private String softwareVersion;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("HardwareVersion")
    private String hardwareVersion;
    @JsonProperty("UIVersion")
    private String uIVersion;
    @JsonProperty("OverridingDefaults")
    private Integer overridingDefaults;
    @JsonProperty("MaxBandwidthUpdates")
    private Integer maxBandwidthUpdates;
    @JsonProperty("AssignedResources")
    private List<AssignedResources> assignedResources = new ArrayList<AssignedResources>();
    @JsonProperty("CASDeviceId")
    private String cASDeviceId;
    @JsonProperty("VMXClientId")
    private String vMXClientId;
    @JsonProperty("SetTopBoxUDFs")
    private List<SetTopBoxUDF> setTopBoxUDFs = new ArrayList<SetTopBoxUDF>();

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

    public SetTopBox withSerialNumber(String serialNumber) {
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

    public SetTopBox withMACAddress(String mACAddress) {
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

    public SetTopBox withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
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

    public SetTopBox withSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param hardwareVersion
     *     The HardwareVersion
     */
    @JsonProperty("HardwareVersion")
    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public SetTopBox withHardwareVersion(String hardwareVersion) {
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

    public SetTopBox withUIVersion(String uIVersion) {
        this.uIVersion = uIVersion;
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

    public SetTopBox withOverridingDefaults(Integer overridingDefaults) {
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

    public SetTopBox withMaxBandwidthUpdates(Integer maxBandwidthUpdates) {
        this.maxBandwidthUpdates = maxBandwidthUpdates;
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

    public SetTopBox withAssignedResources(List<AssignedResources> assignedResources) {
        this.assignedResources = assignedResources;
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

    public SetTopBox withCASDeviceId(String cASDeviceId) {
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

    public SetTopBox withVMXClientId(String vMXClientId) {
        this.vMXClientId = vMXClientId;
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

    public SetTopBox withSetTopBoxUDFs(List<SetTopBoxUDF> setTopBoxUDFs) {
        this.setTopBoxUDFs = setTopBoxUDFs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serialNumber).append(mACAddress).append(iPAddress).append(softwareVersion).append(hardwareVersion).append(uIVersion).append(overridingDefaults).append(maxBandwidthUpdates).append(assignedResources).append(cASDeviceId).append(vMXClientId).append(setTopBoxUDFs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetTopBox) == false) {
            return false;
        }
        SetTopBox rhs = ((SetTopBox) other);
        return new EqualsBuilder().append(serialNumber, rhs.serialNumber).append(mACAddress, rhs.mACAddress).append(iPAddress, rhs.iPAddress).append(softwareVersion, rhs.softwareVersion).append(hardwareVersion, rhs.hardwareVersion).append(uIVersion, rhs.uIVersion).append(overridingDefaults, rhs.overridingDefaults).append(maxBandwidthUpdates, rhs.maxBandwidthUpdates).append(assignedResources, rhs.assignedResources).append(cASDeviceId, rhs.cASDeviceId).append(vMXClientId, rhs.vMXClientId).append(setTopBoxUDFs, rhs.setTopBoxUDFs).isEquals();
    }

}
