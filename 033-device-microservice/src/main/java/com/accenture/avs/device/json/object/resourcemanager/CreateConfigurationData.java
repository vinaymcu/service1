
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
    "BWProfileList"
})
public class CreateConfigurationData {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("MDCBitrate")
    private Integer mDCBitrate;
    @JsonProperty("UseGlobalQoEBW")
    private Boolean useGlobalQoEBW;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("VideoTypeList")
    private List<VideoTypeList> videoTypeList = new ArrayList<VideoTypeList>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AvailableResolutionTypes")
    private List<AvailableResolutionType> availableResolutionTypes = new ArrayList<AvailableResolutionType>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("BWProfileList")
    private List<BWProfileList> bWProfileList = new ArrayList<BWProfileList>();

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param mDCBitrate
     *     The MDCBitrate
     */
    @JsonProperty("MDCBitrate")
    public void setMDCBitrate(Integer mDCBitrate) {
        this.mDCBitrate = mDCBitrate;
    }

    public CreateConfigurationData withMDCBitrate(Integer mDCBitrate) {
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

    public CreateConfigurationData withUseGlobalQoEBW(Boolean useGlobalQoEBW) {
        this.useGlobalQoEBW = useGlobalQoEBW;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param videoTypeList
     *     The VideoTypeList
     */
    @JsonProperty("VideoTypeList")
    public void setVideoTypeList(List<VideoTypeList> videoTypeList) {
        this.videoTypeList = videoTypeList;
    }

    public CreateConfigurationData withVideoTypeList(List<VideoTypeList> videoTypeList) {
        this.videoTypeList = videoTypeList;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param availableResolutionTypes
     *     The AvailableResolutionTypes
     */
    @JsonProperty("AvailableResolutionTypes")
    public void setAvailableResolutionTypes(List<AvailableResolutionType> availableResolutionTypes) {
        this.availableResolutionTypes = availableResolutionTypes;
    }

    public CreateConfigurationData withAvailableResolutionTypes(List<AvailableResolutionType> availableResolutionTypes) {
        this.availableResolutionTypes = availableResolutionTypes;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param bWProfileList
     *     The BWProfileList
     */
    @JsonProperty("BWProfileList")
    public void setBWProfileList(List<BWProfileList> bWProfileList) {
        this.bWProfileList = bWProfileList;
    }

    public CreateConfigurationData withBWProfileList(List<BWProfileList> bWProfileList) {
        this.bWProfileList = bWProfileList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mDCBitrate).append(useGlobalQoEBW).append(videoTypeList).append(availableResolutionTypes).append(bWProfileList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateConfigurationData) == false) {
            return false;
        }
        CreateConfigurationData rhs = ((CreateConfigurationData) other);
        return new EqualsBuilder().append(mDCBitrate, rhs.mDCBitrate).append(useGlobalQoEBW, rhs.useGlobalQoEBW).append(videoTypeList, rhs.videoTypeList).append(availableResolutionTypes, rhs.availableResolutionTypes).append(bWProfileList, rhs.bWProfileList).isEquals();
    }

}
