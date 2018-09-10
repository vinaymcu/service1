
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
    "SetTopBoxes"
})
public class STBs implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SetTopBoxes")
    private List<SetTopBox> setTopBoxes = new ArrayList<SetTopBox>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The setTopBoxes
     */
    @JsonProperty("SetTopBoxes")
    public List<SetTopBox> getSetTopBoxes() {
        return setTopBoxes;
    }

    /**
     * 
     * (Required)
     * 
     * @param setTopBoxes
     *     The SetTopBoxes
     */
    @JsonProperty("SetTopBoxes")
    public void setSetTopBoxes(List<SetTopBox> setTopBoxes) {
        this.setTopBoxes = setTopBoxes;
    }

    public STBs withSetTopBoxes(List<SetTopBox> setTopBoxes) {
        this.setTopBoxes = setTopBoxes;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(setTopBoxes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBs) == false) {
            return false;
        }
        STBs rhs = ((STBs) other);
        return new EqualsBuilder().append(setTopBoxes, rhs.setTopBoxes).isEquals();
    }

}
