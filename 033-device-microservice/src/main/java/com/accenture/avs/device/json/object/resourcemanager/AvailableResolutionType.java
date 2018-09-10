
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
    "ResolutionTypeName"
})
public class AvailableResolutionType {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ResolutionTypeName")
    private String resolutionTypeName;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The resolutionTypeName
     */
    @JsonProperty("ResolutionTypeName")
    public String getResolutionTypeName() {
        return resolutionTypeName;
    }

    /**
     * 
     * (Required)
     * 
     * @param resolutionTypeName
     *     The ResolutionTypeName
     */
    @JsonProperty("ResolutionTypeName")
    public void setResolutionTypeName(String resolutionTypeName) {
        this.resolutionTypeName = resolutionTypeName;
    }

    public AvailableResolutionType withResolutionTypeName(String resolutionTypeName) {
        this.resolutionTypeName = resolutionTypeName;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resolutionTypeName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AvailableResolutionType) == false) {
            return false;
        }
        AvailableResolutionType rhs = ((AvailableResolutionType) other);
        return new EqualsBuilder().append(resolutionTypeName, rhs.resolutionTypeName).isEquals();
    }

}
