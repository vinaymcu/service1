
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
    "drmId",
    "userName",
    "ipAddress",
    "assignmentStatus",
    "model",
    "vendor",
    "deviceType",
    "platform",
    "softwareVersion"
})
public class DeviceListDto {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceId")
    private String deviceId;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("drmId")
    private String drmId;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("ipAddress")
    private String ipAddress;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("assignmentStatus")
    private String assignmentStatus;
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
    @JsonProperty("softwareVersion")
    private String softwareVersion;

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
     *     The drmId
     */
    @JsonProperty("drmId")
    public String getDrmId() {
        return drmId;
    }

    /**
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deviceId).append(serialNumber).append(drmId).append(userName).append(ipAddress).append(assignmentStatus).append(model).append(vendor).append(deviceType).append(platform).append(softwareVersion).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeviceListDto) == false) {
            return false;
        }
        DeviceListDto rhs = ((DeviceListDto) other);
        return new EqualsBuilder().append(deviceId, rhs.deviceId).append(serialNumber, rhs.serialNumber).append(drmId, rhs.drmId).append(userName, rhs.userName).append(ipAddress, rhs.ipAddress).append(assignmentStatus, rhs.assignmentStatus).append(model, rhs.model).append(vendor, rhs.vendor).append(deviceType, rhs.deviceType).append(platform, rhs.platform).append(softwareVersion, rhs.softwareVersion).isEquals();
    }

}
