
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
    "EquipmentID",
    "AssignedProfile",
    "AssignedBW",
    "AssignedVQEOverheadBW",
    "TVQualityProfile"
})
public class AssignedDeviceProfile {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EquipmentID")
    private String equipmentID;
    @JsonProperty("AssignedProfile")
    private String assignedProfile;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssignedBW")
    private Integer assignedBW;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssignedVQEOverheadBW")
    private Integer assignedVQEOverheadBW;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("TVQualityProfile")
    private List<TVQualityProfile> tVQualityProfile = new ArrayList<TVQualityProfile>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The equipmentID
     */
    @JsonProperty("EquipmentID")
    public String getEquipmentID() {
        return equipmentID;
    }

    /**
     * 
     * (Required)
     * 
     * @param equipmentID
     *     The EquipmentID
     */
    @JsonProperty("EquipmentID")
    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public AssignedDeviceProfile withEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
        return this;
    }

    /**
     * 
     * @return
     *     The assignedProfile
     */
    @JsonProperty("AssignedProfile")
    public String getAssignedProfile() {
        return assignedProfile;
    }

    /**
     * 
     * @param assignedProfile
     *     The AssignedProfile
     */
    @JsonProperty("AssignedProfile")
    public void setAssignedProfile(String assignedProfile) {
        this.assignedProfile = assignedProfile;
    }

    public AssignedDeviceProfile withAssignedProfile(String assignedProfile) {
        this.assignedProfile = assignedProfile;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assignedBW
     */
    @JsonProperty("AssignedBW")
    public Integer getAssignedBW() {
        return assignedBW;
    }

    /**
     * 
     * (Required)
     * 
     * @param assignedBW
     *     The AssignedBW
     */
    @JsonProperty("AssignedBW")
    public void setAssignedBW(Integer assignedBW) {
        this.assignedBW = assignedBW;
    }

    public AssignedDeviceProfile withAssignedBW(Integer assignedBW) {
        this.assignedBW = assignedBW;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assignedVQEOverheadBW
     */
    @JsonProperty("AssignedVQEOverheadBW")
    public Integer getAssignedVQEOverheadBW() {
        return assignedVQEOverheadBW;
    }

    /**
     * 
     * (Required)
     * 
     * @param assignedVQEOverheadBW
     *     The AssignedVQEOverheadBW
     */
    @JsonProperty("AssignedVQEOverheadBW")
    public void setAssignedVQEOverheadBW(Integer assignedVQEOverheadBW) {
        this.assignedVQEOverheadBW = assignedVQEOverheadBW;
    }

    public AssignedDeviceProfile withAssignedVQEOverheadBW(Integer assignedVQEOverheadBW) {
        this.assignedVQEOverheadBW = assignedVQEOverheadBW;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tVQualityProfile
     */
    @JsonProperty("TVQualityProfile")
    public List<TVQualityProfile> getTVQualityProfile() {
        return tVQualityProfile;
    }

    /**
     * 
     * (Required)
     * 
     * @param tVQualityProfile
     *     The TVQualityProfile
     */
    @JsonProperty("TVQualityProfile")
    public void setTVQualityProfile(List<TVQualityProfile> tVQualityProfile) {
        this.tVQualityProfile = tVQualityProfile;
    }

    public AssignedDeviceProfile withTVQualityProfile(List<TVQualityProfile> tVQualityProfile) {
        this.tVQualityProfile = tVQualityProfile;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(equipmentID).append(assignedProfile).append(assignedBW).append(assignedVQEOverheadBW).append(tVQualityProfile).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AssignedDeviceProfile) == false) {
            return false;
        }
        AssignedDeviceProfile rhs = ((AssignedDeviceProfile) other);
        return new EqualsBuilder().append(equipmentID, rhs.equipmentID).append(assignedProfile, rhs.assignedProfile).append(assignedBW, rhs.assignedBW).append(assignedVQEOverheadBW, rhs.assignedVQEOverheadBW).append(tVQualityProfile, rhs.tVQualityProfile).isEquals();
    }

}
