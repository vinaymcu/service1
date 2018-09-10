
package com.accenture.avs.device.json.object.resourcemanager;

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
    "TvQuality",
    "TvQualityMaxDevice"
})
public class MaxDeviceProfile {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("TvQuality")
    private String tvQuality;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("TvQualityMaxDevice")
    private Integer tvQualityMaxDevice;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tvQuality
     */
    @JsonProperty("TvQuality")
    public String getTvQuality() {
        return tvQuality;
    }

    /**
     * 
     * (Required)
     * 
     * @param tvQuality
     *     The TvQuality
     */
    @JsonProperty("TvQuality")
    public void setTvQuality(String tvQuality) {
        this.tvQuality = tvQuality;
    }

    public MaxDeviceProfile withTvQuality(String tvQuality) {
        this.tvQuality = tvQuality;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tvQualityMaxDevice
     */
    @JsonProperty("TvQualityMaxDevice")
    public Integer getTvQualityMaxDevice() {
        return tvQualityMaxDevice;
    }

    /**
     * 
     * (Required)
     * 
     * @param tvQualityMaxDevice
     *     The TvQualityMaxDevice
     */
    @JsonProperty("TvQualityMaxDevice")
    public void setTvQualityMaxDevice(Integer tvQualityMaxDevice) {
        this.tvQualityMaxDevice = tvQualityMaxDevice;
    }

    public MaxDeviceProfile withTvQualityMaxDevice(Integer tvQualityMaxDevice) {
        this.tvQualityMaxDevice = tvQualityMaxDevice;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tvQuality).append(tvQualityMaxDevice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MaxDeviceProfile) == false) {
            return false;
        }
        MaxDeviceProfile rhs = ((MaxDeviceProfile) other);
        return new EqualsBuilder().append(tvQuality, rhs.tvQuality).append(tvQualityMaxDevice, rhs.tvQualityMaxDevice).isEquals();
    }

}
