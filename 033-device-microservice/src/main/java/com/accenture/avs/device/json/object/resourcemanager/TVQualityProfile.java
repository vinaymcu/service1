
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
    "TvQualityInterest",
    "TvQualityMaxBW"
})
public class TVQualityProfile {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("TvQualityInterest")
    private String tvQualityInterest;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("TvQualityMaxBW")
    private Integer tvQualityMaxBW;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tvQualityInterest
     */
    @JsonProperty("TvQualityInterest")
    public String getTvQualityInterest() {
        return tvQualityInterest;
    }

    /**
     * 
     * (Required)
     * 
     * @param tvQualityInterest
     *     The TvQualityInterest
     */
    @JsonProperty("TvQualityInterest")
    public void setTvQualityInterest(String tvQualityInterest) {
        this.tvQualityInterest = tvQualityInterest;
    }

    public TVQualityProfile withTvQualityInterest(String tvQualityInterest) {
        this.tvQualityInterest = tvQualityInterest;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tvQualityMaxBW
     */
    @JsonProperty("TvQualityMaxBW")
    public Integer getTvQualityMaxBW() {
        return tvQualityMaxBW;
    }

    /**
     * 
     * (Required)
     * 
     * @param tvQualityMaxBW
     *     The TvQualityMaxBW
     */
    @JsonProperty("TvQualityMaxBW")
    public void setTvQualityMaxBW(Integer tvQualityMaxBW) {
        this.tvQualityMaxBW = tvQualityMaxBW;
    }

    public TVQualityProfile withTvQualityMaxBW(Integer tvQualityMaxBW) {
        this.tvQualityMaxBW = tvQualityMaxBW;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tvQualityInterest).append(tvQualityMaxBW).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TVQualityProfile) == false) {
            return false;
        }
        TVQualityProfile rhs = ((TVQualityProfile) other);
        return new EqualsBuilder().append(tvQualityInterest, rhs.tvQualityInterest).append(tvQualityMaxBW, rhs.tvQualityMaxBW).isEquals();
    }

}
