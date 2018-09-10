
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
    "UnassignSTBs"
})
public class UnassignSetTopBox implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("UnassignSTBs")
    private List<UnassignSTB> unassignSTBs = new ArrayList<UnassignSTB>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The unassignSTBs
     */
    @JsonProperty("UnassignSTBs")
    public List<UnassignSTB> getUnassignSTBs() {
        return unassignSTBs;
    }

    /**
     * 
     * (Required)
     * 
     * @param unassignSTBs
     *     The UnassignSTBs
     */
    @JsonProperty("UnassignSTBs")
    public void setUnassignSTBs(List<UnassignSTB> unassignSTBs) {
        this.unassignSTBs = unassignSTBs;
    }

    public UnassignSetTopBox withUnassignSTBs(List<UnassignSTB> unassignSTBs) {
        this.unassignSTBs = unassignSTBs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unassignSTBs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UnassignSetTopBox) == false) {
            return false;
        }
        UnassignSetTopBox rhs = ((UnassignSetTopBox) other);
        return new EqualsBuilder().append(unassignSTBs, rhs.unassignSTBs).isEquals();
    }

}
