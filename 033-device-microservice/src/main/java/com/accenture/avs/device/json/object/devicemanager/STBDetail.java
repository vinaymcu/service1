
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
    "IPAddress",
    "STBName",
    "SoftwareVersion",
    "HardwareVersion",
    "TVQualityInterest",
    "UIVersion",
    "OverridingDefaults",
    "MaxBandwidthUpdates",
    "AssignedResources",
    "CASDeviceId",
    "VMXClientId",
    "SetTopBoxUDFs"
})
public class STBDetail implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EquipmentId")
    private Integer equipmentId;
    @JsonProperty("IPAddress")
    private String iPAddress;
    @JsonProperty("STBName")
    private String sTBName;
    @JsonProperty("SoftwareVersion")
    private String softwareVersion;
    @JsonProperty("HardwareVersion")
    private String hardwareVersion;
    @JsonProperty("TVQualityInterest")
    private String tVQualityInterest;
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

    public STBDetail withEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
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

    public STBDetail withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
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

    public STBDetail withSTBName(String sTBName) {
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

    public STBDetail withSoftwareVersion(String softwareVersion) {
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

    public STBDetail withHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
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

    public STBDetail withTVQualityInterest(String tVQualityInterest) {
        this.tVQualityInterest = tVQualityInterest;
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

    public STBDetail withUIVersion(String uIVersion) {
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

    public STBDetail withOverridingDefaults(Integer overridingDefaults) {
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

    public STBDetail withMaxBandwidthUpdates(Integer maxBandwidthUpdates) {
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

    public STBDetail withAssignedResources(List<AssignedResources> assignedResources) {
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

    public STBDetail withCASDeviceId(String cASDeviceId) {
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

    public STBDetail withVMXClientId(String vMXClientId) {
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

    public STBDetail withSetTopBoxUDFs(List<SetTopBoxUDF> setTopBoxUDFs) {
        this.setTopBoxUDFs = setTopBoxUDFs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(equipmentId).append(iPAddress).append(sTBName).append(softwareVersion).append(hardwareVersion).append(tVQualityInterest).append(uIVersion).append(overridingDefaults).append(maxBandwidthUpdates).append(assignedResources).append(cASDeviceId).append(vMXClientId).append(setTopBoxUDFs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBDetail) == false) {
            return false;
        }
        STBDetail rhs = ((STBDetail) other);
        return new EqualsBuilder().append(equipmentId, rhs.equipmentId).append(iPAddress, rhs.iPAddress).append(sTBName, rhs.sTBName).append(softwareVersion, rhs.softwareVersion).append(hardwareVersion, rhs.hardwareVersion).append(tVQualityInterest, rhs.tVQualityInterest).append(uIVersion, rhs.uIVersion).append(overridingDefaults, rhs.overridingDefaults).append(maxBandwidthUpdates, rhs.maxBandwidthUpdates).append(assignedResources, rhs.assignedResources).append(cASDeviceId, rhs.cASDeviceId).append(vMXClientId, rhs.vMXClientId).append(setTopBoxUDFs, rhs.setTopBoxUDFs).isEquals();
    }

}
