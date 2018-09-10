
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
    "ContentQuality",
    "STBLimit"
})
public class MaxSTBsPerContentQuality implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ContentQuality")
    private String contentQuality;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBLimit")
    private Integer sTBLimit;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The contentQuality
     */
    @JsonProperty("ContentQuality")
    public String getContentQuality() {
        return contentQuality;
    }

    /**
     * 
     * (Required)
     * 
     * @param contentQuality
     *     The ContentQuality
     */
    @JsonProperty("ContentQuality")
    public void setContentQuality(String contentQuality) {
        this.contentQuality = contentQuality;
    }

    public MaxSTBsPerContentQuality withContentQuality(String contentQuality) {
        this.contentQuality = contentQuality;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBLimit
     */
    @JsonProperty("STBLimit")
    public Integer getSTBLimit() {
        return sTBLimit;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBLimit
     *     The STBLimit
     */
    @JsonProperty("STBLimit")
    public void setSTBLimit(Integer sTBLimit) {
        this.sTBLimit = sTBLimit;
    }

    public MaxSTBsPerContentQuality withSTBLimit(Integer sTBLimit) {
        this.sTBLimit = sTBLimit;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contentQuality).append(sTBLimit).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MaxSTBsPerContentQuality) == false) {
            return false;
        }
        MaxSTBsPerContentQuality rhs = ((MaxSTBsPerContentQuality) other);
        return new EqualsBuilder().append(contentQuality, rhs.contentQuality).append(sTBLimit, rhs.sTBLimit).isEquals();
    }

}
