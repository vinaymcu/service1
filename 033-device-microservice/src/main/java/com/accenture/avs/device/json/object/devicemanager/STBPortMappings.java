
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
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
    "IPAddress",
    "STBPortMappings"
})
public class STBPortMappings implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("IPAddress")
    private String iPAddress;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBPortMappings")
    private List<STBPortMapping> sTBPortMappings = new ArrayList<STBPortMapping>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The iPAddress
     */
    @JsonProperty("IPAddress")
    public String getIPAddress() {
        return iPAddress;
    }

    /**
     * 
     * (Required)
     * 
     * @param iPAddress
     *     The IPAddress
     */
    @JsonProperty("IPAddress")
    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public STBPortMappings withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBPortMappings
     */
    @JsonProperty("STBPortMappings")
    public List<STBPortMapping> getSTBPortMappings() {
        return sTBPortMappings;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBPortMappings
     *     The STBPortMappings
     */
    @JsonProperty("STBPortMappings")
    public void setSTBPortMappings(List<STBPortMapping> sTBPortMappings) {
        this.sTBPortMappings = sTBPortMappings;
    }

    public STBPortMappings withSTBPortMappings(List<STBPortMapping> sTBPortMappings) {
        this.sTBPortMappings = sTBPortMappings;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iPAddress).append(sTBPortMappings).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBPortMappings) == false) {
            return false;
        }
        STBPortMappings rhs = ((STBPortMappings) other);
        return new EqualsBuilder().append(iPAddress, rhs.iPAddress).append(sTBPortMappings, rhs.sTBPortMappings).isEquals();
    }

}
