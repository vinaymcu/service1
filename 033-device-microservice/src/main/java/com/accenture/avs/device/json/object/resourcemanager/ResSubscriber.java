
package com.accenture.avs.device.json.object.resourcemanager;

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
    "Id",
    "freeBW",
    "AssignedDeviceProfile"
})
public class ResSubscriber {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Id")
    private String id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("freeBW")
    private Integer freeBW;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssignedDeviceProfile")
    private List<AssignedDeviceProfile> assignedDeviceProfile = new ArrayList<AssignedDeviceProfile>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The id
     */
    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     * @param id
     *     The Id
     */
    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    public ResSubscriber withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The freeBW
     */
    @JsonProperty("freeBW")
    public Integer getFreeBW() {
        return freeBW;
    }

    /**
     * 
     * (Required)
     * 
     * @param freeBW
     *     The freeBW
     */
    @JsonProperty("freeBW")
    public void setFreeBW(Integer freeBW) {
        this.freeBW = freeBW;
    }

    public ResSubscriber withFreeBW(Integer freeBW) {
        this.freeBW = freeBW;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assignedDeviceProfile
     */
    @JsonProperty("AssignedDeviceProfile")
    public List<AssignedDeviceProfile> getAssignedDeviceProfile() {
        return assignedDeviceProfile;
    }

    /**
     * 
     * (Required)
     * 
     * @param assignedDeviceProfile
     *     The AssignedDeviceProfile
     */
    @JsonProperty("AssignedDeviceProfile")
    public void setAssignedDeviceProfile(List<AssignedDeviceProfile> assignedDeviceProfile) {
        this.assignedDeviceProfile = assignedDeviceProfile;
    }

    public ResSubscriber withAssignedDeviceProfile(List<AssignedDeviceProfile> assignedDeviceProfile) {
        this.assignedDeviceProfile = assignedDeviceProfile;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(freeBW).append(assignedDeviceProfile).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResSubscriber) == false) {
            return false;
        }
        ResSubscriber rhs = ((ResSubscriber) other);
        return new EqualsBuilder().append(id, rhs.id).append(freeBW, rhs.freeBW).append(assignedDeviceProfile, rhs.assignedDeviceProfile).isEquals();
    }

}
