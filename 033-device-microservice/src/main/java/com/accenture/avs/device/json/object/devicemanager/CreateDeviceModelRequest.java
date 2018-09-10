package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "deviceModel",
    "vendor",
    "platform",
    "osName",
    "osVersion",
    "swId",
    "qoeCapable",
    "uiVersion",
    "sdChannelTimeshiftBuffer",
    "hdChannelTimeshiftBuffer",
    "status",
    "vqeProfile",
    "tstvBufferSize",
    "hdCapable",
    "deviceAutoRegistration",    
    "maxStreamsPerQuality"
})
public class CreateDeviceModelRequest implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceModel")
    private String deviceModel;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendor")
    private String vendor;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("osName")
    private String osName;
    @JsonProperty("osVersion")
    private String osVersion;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("swId")
    private String swId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("qoeCapable")
    private Boolean qoeCapable;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uiVersion")
    private String uiVersion;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sdChannelTimeshiftBuffer")
    private Integer sdChannelTimeshiftBuffer;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("hdChannelTimeshiftBuffer")
    private Integer hdChannelTimeshiftBuffer;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vqeProfile")
    private String vqeProfile;
    @JsonProperty("tstvBufferSize")
    private Integer tstvBufferSize;
    @JsonProperty("hdCapable")
    private Boolean hdCapable;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceAutoRegistration")
    private Boolean deviceAutoRegistration;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("maxStreamsPerQuality")
    private List<MaxStreamsPerQuality> maxStreamsPerQuality = new ArrayList<MaxStreamsPerQuality>();
    private final static long serialVersionUID = -3672796335392126897L;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The deviceModel
     */
    @JsonProperty("deviceModel")
    public String getDeviceModel() {
        return deviceModel;
    }

    /**
     * 
     * (Required)
     * 
     * @param deviceModel
     *     The deviceModel
     */
    @JsonProperty("deviceModel")
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    /**
     * 
     * (Required)
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
     * (Required)
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
     *     The osName
     */
    @JsonProperty("osName")
    public String getOsName() {
        return osName;
    }

    /**
     * 
     * @param osName
     *     The osName
     */
    @JsonProperty("osName")
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * 
     * @return
     *     The osVersion
     */
    @JsonProperty("osVersion")
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * 
     * @param osVersion
     *     The osVersion
     */
    @JsonProperty("osVersion")
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The swId
     */
    @JsonProperty("swId")
    public String getSwId() {
        return swId;
    }

    /**
     * 
     * (Required)
     * 
     * @param swId
     *     The swId
     */
    @JsonProperty("swId")
    public void setSwId(String swId) {
        this.swId = swId;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The qoeCapable
     */
    @JsonProperty("qoeCapable")
    public Boolean getQoeCapable() {
        return qoeCapable;
    }

    /**
     * 
     * (Required)
     * 
     * @param qoeCapable
     *     The qoeCapable
     */
    @JsonProperty("qoeCapable")
    public void setQoeCapable(Boolean qoeCapable) {
        this.qoeCapable = qoeCapable;
    }

    /**
     * 
     * (Required)
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
     * (Required)
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
     *     The sdChannelTimeshiftBuffer
     */
    @JsonProperty("sdChannelTimeshiftBuffer")
    public Integer getSdChannelTimeshiftBuffer() {
        return sdChannelTimeshiftBuffer;
    }

    /**
     * 
     * (Required)
     * 
     * @param sdChannelTimeshiftBuffer
     *     The sdChannelTimeshiftBuffer
     */
    @JsonProperty("sdChannelTimeshiftBuffer")
    public void setSdChannelTimeshiftBuffer(Integer sdChannelTimeshiftBuffer) {
        this.sdChannelTimeshiftBuffer = sdChannelTimeshiftBuffer;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The hdChannelTimeshiftBuffer
     */
    @JsonProperty("hdChannelTimeshiftBuffer")
    public Integer getHdChannelTimeshiftBuffer() {
        return hdChannelTimeshiftBuffer;
    }

    /**
     * 
     * (Required)
     * 
     * @param hdChannelTimeshiftBuffer
     *     The hdChannelTimeshiftBuffer
     */
    @JsonProperty("hdChannelTimeshiftBuffer")
    public void setHdChannelTimeshiftBuffer(Integer hdChannelTimeshiftBuffer) {
        this.hdChannelTimeshiftBuffer = hdChannelTimeshiftBuffer;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The vqeProfile
     */
    @JsonProperty("vqeProfile")
    public String getVqeProfile() {
        return vqeProfile;
    }

    /**
     * 
     * (Required)
     * 
     * @param vqeProfile
     *     The vqeProfile
     */
    @JsonProperty("vqeProfile")
    public void setVqeProfile(String vqeProfile) {
        this.vqeProfile = vqeProfile;
    }

    /**
     * 
     * @return
     *     The tstvBufferSize
     */
    @JsonProperty("tstvBufferSize")
    public Integer getTstvBufferSize() {
        return tstvBufferSize;
    }

    /**
     * 
     * @param tstvBufferSize
     *     The tstvBufferSize
     */
    @JsonProperty("tstvBufferSize")
    public void setTstvBufferSize(Integer tstvBufferSize) {
        this.tstvBufferSize = tstvBufferSize;
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
     *     The deviceAutoRegistration
     */
    @JsonProperty("deviceAutoRegistration")
    public Boolean getDeviceAutoRegistration() {
        return deviceAutoRegistration;
    }

    /**
     * 
     * (Required)
     * 
     * @param deviceAutoRegistration
     *     The deviceAutoRegistration
     */
    @JsonProperty("deviceAutoRegistration")
    public void setDeviceAutoRegistration(Boolean deviceAutoRegistration) {
        this.deviceAutoRegistration = deviceAutoRegistration;	
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The maxStreamsPerQuality
     */
    @JsonProperty("maxStreamsPerQuality")
    public List<MaxStreamsPerQuality> getMaxStreamsPerQuality() {
        return maxStreamsPerQuality;
    }

    /**
     * 
     * (Required)
     * 
     * @param maxStreamsPerQuality
     *     The maxStreamsPerQuality
     */
    @JsonProperty("maxStreamsPerQuality")
    public void setMaxStreamsPerQuality(List<MaxStreamsPerQuality> maxStreamsPerQuality) {
        this.maxStreamsPerQuality = maxStreamsPerQuality;
    }

}
