
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
    "AccountNumber",
    "MACAddress",
    "SerialNumber",
    "IPAddress",
    "ExtIPAddress",
    "SupportedConnectionModes",
    "HardwareVersion",
    "CASDeviceId",
    "SoftwareVersion",
    "UIVersion",
    "STBName",
    "VMXClientId"
})
public class AssignSTB implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AccountNumber")
    private String accountNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("MACAddress")
    private String mACAddress;
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
    @JsonProperty("IPAddress")
    private String iPAddress;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ExtIPAddress")
    private String extIPAddress;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SupportedConnectionModes")
    private String supportedConnectionModes;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("HardwareVersion")
    private String hardwareVersion;
    @JsonProperty("CASDeviceId")
    private String cASDeviceId;
    @JsonProperty("SoftwareVersion")
    private String softwareVersion;
    @JsonProperty("UIVersion")
    private String uIVersion;
    @JsonProperty("STBName")
    private String sTBName;
    @JsonProperty("VMXClientId")
    private String vMXClientId;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The accountNumber
     */
    @JsonProperty("AccountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 
     * (Required)
     * 
     * @param accountNumber
     *     The AccountNumber
     */
    @JsonProperty("AccountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AssignSTB withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public AssignSTB withMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
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

    public AssignSTB withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param iPAddress
     *     The IPAddress
     */
    @JsonProperty("IPAddress")
    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public AssignSTB withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param extIPAddress
     *     The ExtIPAddress
     */
    @JsonProperty("ExtIPAddress")
    public void setExtIPAddress(String extIPAddress) {
        this.extIPAddress = extIPAddress;
    }

    public AssignSTB withExtIPAddress(String extIPAddress) {
        this.extIPAddress = extIPAddress;
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

    public AssignSTB withSupportedConnectionModes(String supportedConnectionModes) {
        this.supportedConnectionModes = supportedConnectionModes;
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

    public AssignSTB withHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
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

    public AssignSTB withCASDeviceId(String cASDeviceId) {
        this.cASDeviceId = cASDeviceId;
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

    public AssignSTB withSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
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

    public AssignSTB withUIVersion(String uIVersion) {
        this.uIVersion = uIVersion;
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

    public AssignSTB withSTBName(String sTBName) {
        this.sTBName = sTBName;
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

    public AssignSTB withVMXClientId(String vMXClientId) {
        this.vMXClientId = vMXClientId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountNumber).append(mACAddress).append(serialNumber).append(iPAddress).append(extIPAddress).append(supportedConnectionModes).append(hardwareVersion).append(cASDeviceId).append(softwareVersion).append(uIVersion).append(sTBName).append(vMXClientId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AssignSTB) == false) {
            return false;
        }
        AssignSTB rhs = ((AssignSTB) other);
        return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(mACAddress, rhs.mACAddress).append(serialNumber, rhs.serialNumber).append(iPAddress, rhs.iPAddress).append(extIPAddress, rhs.extIPAddress).append(supportedConnectionModes, rhs.supportedConnectionModes).append(hardwareVersion, rhs.hardwareVersion).append(cASDeviceId, rhs.cASDeviceId).append(softwareVersion, rhs.softwareVersion).append(uIVersion, rhs.uIVersion).append(sTBName, rhs.sTBName).append(vMXClientId, rhs.vMXClientId).isEquals();
    }

}
