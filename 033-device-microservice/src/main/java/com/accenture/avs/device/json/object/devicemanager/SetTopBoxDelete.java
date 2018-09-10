
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
    "STBDeletions"
})
public class SetTopBoxDelete implements Serializable
{

    @JsonProperty("STBDeletions")
    private List<STBDeletion> sTBDeletions = new ArrayList<STBDeletion>();

    /**
     * 
     * @return
     *     The sTBDeletions
     */
    @JsonProperty("STBDeletions")
    public List<STBDeletion> getSTBDeletions() {
        return sTBDeletions;
    }

    /**
     * 
     * @param sTBDeletions
     *     The STBDeletions
     */
    @JsonProperty("STBDeletions")
    public void setSTBDeletions(List<STBDeletion> sTBDeletions) {
        this.sTBDeletions = sTBDeletions;
    }

    public SetTopBoxDelete withSTBDeletions(List<STBDeletion> sTBDeletions) {
        this.sTBDeletions = sTBDeletions;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sTBDeletions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetTopBoxDelete) == false) {
            return false;
        }
        SetTopBoxDelete rhs = ((SetTopBoxDelete) other);
        return new EqualsBuilder().append(sTBDeletions, rhs.sTBDeletions).isEquals();
    }

}
