
package com.accenture.avs.device.json.object.devicemanager;

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
    "STBAssigned"
})
public class StbAssignedResultObj {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBAssigned")
    private STBAssigned sTBAssigned;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBAssigned
     */
    @JsonProperty("STBAssigned")
    public STBAssigned getSTBAssigned() {
        return sTBAssigned;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBAssigned
     *     The STBAssigned
     */
    @JsonProperty("STBAssigned")
    public void setSTBAssigned(STBAssigned sTBAssigned) {
        this.sTBAssigned = sTBAssigned;
    }

    public StbAssignedResultObj withSTBAssigned(STBAssigned sTBAssigned) {
        this.sTBAssigned = sTBAssigned;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sTBAssigned).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StbAssignedResultObj) == false) {
            return false;
        }
        StbAssignedResultObj rhs = ((StbAssignedResultObj) other);
        return new EqualsBuilder().append(sTBAssigned, rhs.sTBAssigned).isEquals();
    }

}
