
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
    "STBDetails"
})
public class SetTopBoxUpdate implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBDetails")
    private List<STBDetail> sTBDetails = new ArrayList<STBDetail>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBDetails
     */
    @JsonProperty("STBDetails")
    public List<STBDetail> getSTBDetails() {
        return sTBDetails;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBDetails
     *     The STBDetails
     */
    @JsonProperty("STBDetails")
    public void setSTBDetails(List<STBDetail> sTBDetails) {
        this.sTBDetails = sTBDetails;
    }

    public SetTopBoxUpdate withSTBDetails(List<STBDetail> sTBDetails) {
        this.sTBDetails = sTBDetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sTBDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetTopBoxUpdate) == false) {
            return false;
        }
        SetTopBoxUpdate rhs = ((SetTopBoxUpdate) other);
        return new EqualsBuilder().append(sTBDetails, rhs.sTBDetails).isEquals();
    }

}
