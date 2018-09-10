
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
    "HWList",
    "AvaliableResources"
})
public class ParameterList implements Serializable
{

    /**
     * 
     */
    @JsonProperty("HWList")
    private HWList hWList;
    /**
     * 
     */
    @JsonProperty("AvaliableResources")
    private AvaliableResources avaliableResources;

    /**
     * 
     * @return
     *     The hWList
     */
    @JsonProperty("HWList")
    public HWList getHWList() {
        return hWList;
    }

    /**
     * 
     * @param hWList
     *     The HWList
     */
    @JsonProperty("HWList")
    public void setHWList(HWList hWList) {
        this.hWList = hWList;
    }

    public ParameterList withHWList(HWList hWList) {
        this.hWList = hWList;
        return this;
    }

    /**
     * 
     * @return
     *     The avaliableResources
     */
    @JsonProperty("AvaliableResources")
    public AvaliableResources getAvaliableResources() {
        return avaliableResources;
    }

    /**
     * 
     * @param avaliableResources
     *     The AvaliableResources
     */
    @JsonProperty("AvaliableResources")
    public void setAvaliableResources(AvaliableResources avaliableResources) {
        this.avaliableResources = avaliableResources;
    }

    public ParameterList withAvaliableResources(AvaliableResources avaliableResources) {
        this.avaliableResources = avaliableResources;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hWList).append(avaliableResources).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ParameterList) == false) {
            return false;
        }
        ParameterList rhs = ((ParameterList) other);
        return new EqualsBuilder().append(hWList, rhs.hWList).append(avaliableResources, rhs.avaliableResources).isEquals();
    }

}
