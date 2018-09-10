
package com.accenture.avs.device.json.object.resourcemanager;

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
    "MDCBitrate",
    "UseGlobalQoEBW",
    "VideoTypeList",
    "AvailableResolutionTypes",
    "HWList",
    "BWProfileList"
})
public class UpdateConfigurationData {

    @JsonProperty("MDCBitrate")
    private Integer mDCBitrate;
    @JsonProperty("UseGlobalQoEBW")
    private Boolean useGlobalQoEBW;
    @JsonProperty("VideoTypeList")
    private List<VideoTypeList> videoTypeList = new ArrayList<VideoTypeList>();
    @JsonProperty("AvailableResolutionTypes")
    private List<AvailableResolutionType> availableResolutionTypes = new ArrayList<AvailableResolutionType>();
    @JsonProperty("HWList")
    private List<HWList> hWList = new ArrayList<HWList>();
    @JsonProperty("BWProfileList")
    private List<BWProfileList> bWProfileList = new ArrayList<BWProfileList>();

    /**
     * 
     * @return
     *     The mDCBitrate
     */
    @JsonProperty("MDCBitrate")
    public Integer getMDCBitrate() {
        return mDCBitrate;
    }

    /**
     * 
     * @param mDCBitrate
     *     The MDCBitrate
     */
    @JsonProperty("MDCBitrate")
    public void setMDCBitrate(Integer mDCBitrate) {
        this.mDCBitrate = mDCBitrate;
    }

    public UpdateConfigurationData withMDCBitrate(Integer mDCBitrate) {
        this.mDCBitrate = mDCBitrate;
        return this;
    }

    /**
     * 
     * @return
     *     The useGlobalQoEBW
     */
    @JsonProperty("UseGlobalQoEBW")
    public Boolean getUseGlobalQoEBW() {
        return useGlobalQoEBW;
    }

    /**
     * 
     * @param useGlobalQoEBW
     *     The UseGlobalQoEBW
     */
    @JsonProperty("UseGlobalQoEBW")
    public void setUseGlobalQoEBW(Boolean useGlobalQoEBW) {
        this.useGlobalQoEBW = useGlobalQoEBW;
    }

    public UpdateConfigurationData withUseGlobalQoEBW(Boolean useGlobalQoEBW) {
        this.useGlobalQoEBW = useGlobalQoEBW;
        return this;
    }

    /**
     * 
     * @return
     *     The videoTypeList
     */
    @JsonProperty("VideoTypeList")
    public List<VideoTypeList> getVideoTypeList() {
        return videoTypeList;
    }

    /**
     * 
     * @param videoTypeList
     *     The VideoTypeList
     */
    @JsonProperty("VideoTypeList")
    public void setVideoTypeList(List<VideoTypeList> videoTypeList) {
        this.videoTypeList = videoTypeList;
    }

    public UpdateConfigurationData withVideoTypeList(List<VideoTypeList> videoTypeList) {
        this.videoTypeList = videoTypeList;
        return this;
    }

    /**
     * 
     * @return
     *     The availableResolutionTypes
     */
    @JsonProperty("AvailableResolutionTypes")
    public List<AvailableResolutionType> getAvailableResolutionTypes() {
        return availableResolutionTypes;
    }

    /**
     * 
     * @param availableResolutionTypes
     *     The AvailableResolutionTypes
     */
    @JsonProperty("AvailableResolutionTypes")
    public void setAvailableResolutionTypes(List<AvailableResolutionType> availableResolutionTypes) {
        this.availableResolutionTypes = availableResolutionTypes;
    }

    public UpdateConfigurationData withAvailableResolutionTypes(List<AvailableResolutionType> availableResolutionTypes) {
        this.availableResolutionTypes = availableResolutionTypes;
        return this;
    }

    /**
     * 
     * @return
     *     The hWList
     */
    @JsonProperty("HWList")
    public List<HWList> getHWList() {
        return hWList;
    }

    /**
     * 
     * @param hWList
     *     The HWList
     */
    @JsonProperty("HWList")
    public void setHWList(List<HWList> hWList) {
        this.hWList = hWList;
    }

    public UpdateConfigurationData withHWList(List<HWList> hWList) {
        this.hWList = hWList;
        return this;
    }

    /**
     * 
     * @return
     *     The bWProfileList
     */
    @JsonProperty("BWProfileList")
    public List<BWProfileList> getBWProfileList() {
        return bWProfileList;
    }

    /**
     * 
     * @param bWProfileList
     *     The BWProfileList
     */
    @JsonProperty("BWProfileList")
    public void setBWProfileList(List<BWProfileList> bWProfileList) {
        this.bWProfileList = bWProfileList;
    }

    public UpdateConfigurationData withBWProfileList(List<BWProfileList> bWProfileList) {
        this.bWProfileList = bWProfileList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mDCBitrate).append(useGlobalQoEBW).append(videoTypeList).append(availableResolutionTypes).append(hWList).append(bWProfileList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateConfigurationData) == false) {
            return false;
        }
        UpdateConfigurationData rhs = ((UpdateConfigurationData) other);
        return new EqualsBuilder().append(mDCBitrate, rhs.mDCBitrate).append(useGlobalQoEBW, rhs.useGlobalQoEBW).append(videoTypeList, rhs.videoTypeList).append(availableResolutionTypes, rhs.availableResolutionTypes).append(hWList, rhs.hWList).append(bWProfileList, rhs.bWProfileList).isEquals();
    }

}
