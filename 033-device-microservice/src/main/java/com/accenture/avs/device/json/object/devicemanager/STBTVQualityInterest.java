
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
    "MACAddress",
    "TVQualityInterest"
})
public class STBTVQualityInterest implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("MACAddress")
    private String mACAddress;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("TVQualityInterest")
    private String tVQualityInterest;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The mACAddress
     */
    @JsonProperty("MACAddress")
    public String getMACAddress() {
        return mACAddress;
    }

    /**
     * 
     * (Required)
     * 
     * @param mACAddress
     *     The MACAddress
     */
    @JsonProperty("MACAddress")
    public void setMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
    }

    public STBTVQualityInterest withMACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tVQualityInterest
     */
    @JsonProperty("TVQualityInterest")
    public String getTVQualityInterest() {
        return tVQualityInterest;
    }

    /**
     * 
     * (Required)
     * 
     * @param tVQualityInterest
     *     The TVQualityInterest
     */
    @JsonProperty("TVQualityInterest")
    public void setTVQualityInterest(String tVQualityInterest) {
        this.tVQualityInterest = tVQualityInterest;
    }

    public STBTVQualityInterest withTVQualityInterest(String tVQualityInterest) {
        this.tVQualityInterest = tVQualityInterest;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mACAddress).append(tVQualityInterest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBTVQualityInterest) == false) {
            return false;
        }
        STBTVQualityInterest rhs = ((STBTVQualityInterest) other);
        return new EqualsBuilder().append(mACAddress, rhs.mACAddress).append(tVQualityInterest, rhs.tVQualityInterest).isEquals();
    }

}
