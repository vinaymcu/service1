
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
    "STBTVQualityInterest"
})
public class UpdateTVQualityInterest implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBTVQualityInterest")
    private STBTVQualityInterest sTBTVQualityInterest;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBTVQualityInterest
     */
    @JsonProperty("STBTVQualityInterest")
    public STBTVQualityInterest getSTBTVQualityInterest() {
        return sTBTVQualityInterest;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBTVQualityInterest
     *     The STBTVQualityInterest
     */
    @JsonProperty("STBTVQualityInterest")
    public void setSTBTVQualityInterest(STBTVQualityInterest sTBTVQualityInterest) {
        this.sTBTVQualityInterest = sTBTVQualityInterest;
    }

    public UpdateTVQualityInterest withSTBTVQualityInterest(STBTVQualityInterest sTBTVQualityInterest) {
        this.sTBTVQualityInterest = sTBTVQualityInterest;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sTBTVQualityInterest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateTVQualityInterest) == false) {
            return false;
        }
        UpdateTVQualityInterest rhs = ((UpdateTVQualityInterest) other);
        return new EqualsBuilder().append(sTBTVQualityInterest, rhs.sTBTVQualityInterest).isEquals();
    }

}
