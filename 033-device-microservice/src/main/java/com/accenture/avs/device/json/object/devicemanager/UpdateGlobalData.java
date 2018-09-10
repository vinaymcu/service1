
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
    "GlobalData"
})
public class UpdateGlobalData implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("GlobalData")
    private GlobalData globalData;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The globalData
     */
    @JsonProperty("GlobalData")
    public GlobalData getGlobalData() {
        return globalData;
    }

    /**
     * 
     * (Required)
     * 
     * @param globalData
     *     The GlobalData
     */
    @JsonProperty("GlobalData")
    public void setGlobalData(GlobalData globalData) {
        this.globalData = globalData;
    }

    public UpdateGlobalData withGlobalData(GlobalData globalData) {
        this.globalData = globalData;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(globalData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateGlobalData) == false) {
            return false;
        }
        UpdateGlobalData rhs = ((UpdateGlobalData) other);
        return new EqualsBuilder().append(globalData, rhs.globalData).isEquals();
    }

}
