
package com.accenture.avs.device.json.object.resourcemanager;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "VideoTypeName",
    "BitRate",
    "ResolutionType"
})
public class VideoTypeList {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("VideoTypeName")
    private String videoTypeName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("BitRate")
    private String bitRate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ResolutionType")
    private String resolutionType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The videoTypeName
     */
    @JsonProperty("VideoTypeName")
    public String getVideoTypeName() {
        return videoTypeName;
    }

    /**
     * 
     * (Required)
     * 
     * @param videoTypeName
     *     The VideoTypeName
     */
    @JsonProperty("VideoTypeName")
    public void setVideoTypeName(String videoTypeName) {
        this.videoTypeName = videoTypeName;
    }

    public VideoTypeList withVideoTypeName(String videoTypeName) {
        this.videoTypeName = videoTypeName;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The bitRate
     */
    @JsonProperty("BitRate")
    public String getBitRate() {
        return bitRate;
    }

    /**
     * 
     * (Required)
     * 
     * @param bitRate
     *     The BitRate
     */
    @JsonProperty("BitRate")
    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public VideoTypeList withBitRate(String bitRate) {
        this.bitRate = bitRate;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The resolutionType
     */
    @JsonProperty("ResolutionType")
    public String getResolutionType() {
        return resolutionType;
    }

    /**
     * 
     * (Required)
     * 
     * @param resolutionType
     *     The ResolutionType
     */
    @JsonProperty("ResolutionType")
    public void setResolutionType(String resolutionType) {
        this.resolutionType = resolutionType;
    }

    public VideoTypeList withResolutionType(String resolutionType) {
        this.resolutionType = resolutionType;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public VideoTypeList withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(videoTypeName).append(bitRate).append(resolutionType).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VideoTypeList) == false) {
            return false;
        }
        VideoTypeList rhs = ((VideoTypeList) other);
        return new EqualsBuilder().append(videoTypeName, rhs.videoTypeName).append(bitRate, rhs.bitRate).append(resolutionType, rhs.resolutionType).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
