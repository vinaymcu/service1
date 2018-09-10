
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
    "STBAssignmentDetails"
})
public class AssignSetTopBox implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBAssignmentDetails")
    private List<STBAssignmentDetail> sTBAssignmentDetails = new ArrayList<STBAssignmentDetail>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBAssignmentDetails
     */
    @JsonProperty("STBAssignmentDetails")
    public List<STBAssignmentDetail> getSTBAssignmentDetails() {
        return sTBAssignmentDetails;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBAssignmentDetails
     *     The STBAssignmentDetails
     */
    @JsonProperty("STBAssignmentDetails")
    public void setSTBAssignmentDetails(List<STBAssignmentDetail> sTBAssignmentDetails) {
        this.sTBAssignmentDetails = sTBAssignmentDetails;
    }

    public AssignSetTopBox withSTBAssignmentDetails(List<STBAssignmentDetail> sTBAssignmentDetails) {
        this.sTBAssignmentDetails = sTBAssignmentDetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sTBAssignmentDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AssignSetTopBox) == false) {
            return false;
        }
        AssignSetTopBox rhs = ((AssignSetTopBox) other);
        return new EqualsBuilder().append(sTBAssignmentDetails, rhs.sTBAssignmentDetails).isEquals();
    }

}
