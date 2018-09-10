
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
    "AssignSTBs"
})
public class CreateAndAssignSTB implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssignSTBs")
    private List<AssignSTB> assignSTBs = new ArrayList<AssignSTB>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assignSTBs
     */
    @JsonProperty("AssignSTBs")
    public List<AssignSTB> getAssignSTBs() {
        return assignSTBs;
    }

    /**
     * 
     * (Required)
     * 
     * @param assignSTBs
     *     The AssignSTBs
     */
    @JsonProperty("AssignSTBs")
    public void setAssignSTBs(List<AssignSTB> assignSTBs) {
        this.assignSTBs = assignSTBs;
    }

    public CreateAndAssignSTB withAssignSTBs(List<AssignSTB> assignSTBs) {
        this.assignSTBs = assignSTBs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(assignSTBs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateAndAssignSTB) == false) {
            return false;
        }
        CreateAndAssignSTB rhs = ((CreateAndAssignSTB) other);
        return new EqualsBuilder().append(assignSTBs, rhs.assignSTBs).isEquals();
    }

}
