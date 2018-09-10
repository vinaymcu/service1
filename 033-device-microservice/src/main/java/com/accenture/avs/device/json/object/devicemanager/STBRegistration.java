
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
    "IPAddress",
    "SerialNumber",
    "MasterPIN",
    "Password",
    "HardwareVersion",
    "SoftwareVersion",
    "UIVersion",
    "CASDeviceId",
    "STBName",
    "SupportedModes",
    "VMXClientId"
})
public class STBRegistration implements Serializable
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
    @JsonProperty("IPAddress")
    private String iPAddress;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SerialNumber")
    private String serialNumber;
    @JsonProperty("MasterPIN")
    private Integer masterPIN;
    @JsonProperty("Password")
    private String password;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("HardwareVersion")
    private String hardwareVersion;
    @JsonProperty("SoftwareVersion")
    private String softwareVersion;
    @JsonProperty("UIVersion")
    private String uIVersion;
    @JsonProperty("CASDeviceId")
    private String cASDeviceId;
    @JsonProperty("STBName")
    private String sTBName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SupportedModes")
    private String supportedModes;
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

    public STBRegistration withAccountNumber(String accountNumber) {
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

    public STBRegistration withMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
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

    public STBRegistration withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
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

    public STBRegistration withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The masterPIN
     */
    @JsonProperty("MasterPIN")
    public Integer getMasterPIN() {
        return masterPIN;
    }

    /**
     * 
     * @param masterPIN
     *     The MasterPIN
     */
    @JsonProperty("MasterPIN")
    public void setMasterPIN(Integer masterPIN) {
        this.masterPIN = masterPIN;
    }

    public STBRegistration withMasterPIN(Integer masterPIN) {
        this.masterPIN = masterPIN;
        return this;
    }

    /**
     * 
     * @return
     *     The password
     */
    @JsonProperty("Password")
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     *     The Password
     */
    @JsonProperty("Password")
    public void setPassword(String password) {
        this.password = password;
    }

    public STBRegistration withPassword(String password) {
        this.password = password;
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

    public STBRegistration withHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
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

    public STBRegistration withSoftwareVersion(String softwareVersion) {
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

    public STBRegistration withUIVersion(String uIVersion) {
        this.uIVersion = uIVersion;
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

    public STBRegistration withCASDeviceId(String cASDeviceId) {
        this.cASDeviceId = cASDeviceId;
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

    public STBRegistration withSTBName(String sTBName) {
        this.sTBName = sTBName;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The supportedModes
     */
    @JsonProperty("SupportedModes")
    public String getSupportedModes() {
        return supportedModes;
    }

    /**
     * 
     * (Required)
     * 
     * @param supportedModes
     *     The SupportedModes
     */
    @JsonProperty("SupportedModes")
    public void setSupportedModes(String supportedModes) {
        this.supportedModes = supportedModes;
    }

    public STBRegistration withSupportedModes(String supportedModes) {
        this.supportedModes = supportedModes;
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

    public STBRegistration withVMXClientId(String vMXClientId) {
        this.vMXClientId = vMXClientId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountNumber).append(mACAddress).append(iPAddress).append(serialNumber).append(masterPIN).append(password).append(hardwareVersion).append(softwareVersion).append(uIVersion).append(cASDeviceId).append(sTBName).append(supportedModes).append(vMXClientId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBRegistration) == false) {
            return false;
        }
        STBRegistration rhs = ((STBRegistration) other);
        return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(mACAddress, rhs.mACAddress).append(iPAddress, rhs.iPAddress).append(serialNumber, rhs.serialNumber).append(masterPIN, rhs.masterPIN).append(password, rhs.password).append(hardwareVersion, rhs.hardwareVersion).append(softwareVersion, rhs.softwareVersion).append(uIVersion, rhs.uIVersion).append(cASDeviceId, rhs.cASDeviceId).append(sTBName, rhs.sTBName).append(supportedModes, rhs.supportedModes).append(vMXClientId, rhs.vMXClientId).isEquals();
    }

}
