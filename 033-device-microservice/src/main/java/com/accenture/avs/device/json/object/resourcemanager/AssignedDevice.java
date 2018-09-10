
package com.accenture.avs.device.json.object.resourcemanager;

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
    "HWVersion",
    "TvQualityInterest",
    "AssigmentDateTime"
})
public class AssignedDevice {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EquipmentID")
    private String equipmentID;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("HWVersion")
    private String hWVersion;
    @JsonProperty("TvQualityInterest")
    private String tvQualityInterest;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssigmentDateTime")
    private String assigmentDateTime;

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

    public AssignedDevice withEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The hWVersion
     */
    @JsonProperty("HWVersion")
    public String getHWVersion() {
        return hWVersion;
    }

    /**
     * 
     * (Required)
     * 
     * @param hWVersion
     *     The HWVersion
     */
    @JsonProperty("HWVersion")
    public void setHWVersion(String hWVersion) {
        this.hWVersion = hWVersion;
    }

    public AssignedDevice withHWVersion(String hWVersion) {
        this.hWVersion = hWVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The tvQualityInterest
     */
    @JsonProperty("TvQualityInterest")
    public String getTvQualityInterest() {
        return tvQualityInterest;
    }

    /**
     * 
     * @param tvQualityInterest
     *     The TvQualityInterest
     */
    @JsonProperty("TvQualityInterest")
    public void setTvQualityInterest(String tvQualityInterest) {
        this.tvQualityInterest = tvQualityInterest;
    }

    public AssignedDevice withTvQualityInterest(String tvQualityInterest) {
        this.tvQualityInterest = tvQualityInterest;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assigmentDateTime
     */
    @JsonProperty("AssigmentDateTime")
    public String getAssigmentDateTime() {
        return assigmentDateTime;
    }

    /**
     * 
     * (Required)
     * 
     * @param assigmentDateTime
     *     The AssigmentDateTime
     */
    @JsonProperty("AssigmentDateTime")
    public void setAssigmentDateTime(String assigmentDateTime) {
        this.assigmentDateTime = assigmentDateTime;
    }

    public AssignedDevice withAssigmentDateTime(String assigmentDateTime) {
        this.assigmentDateTime = assigmentDateTime;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(equipmentID).append(hWVersion).append(tvQualityInterest).append(assigmentDateTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AssignedDevice) == false) {
            return false;
        }
        AssignedDevice rhs = ((AssignedDevice) other);
        return new EqualsBuilder().append(equipmentID, rhs.equipmentID).append(hWVersion, rhs.hWVersion).append(tvQualityInterest, rhs.tvQualityInterest).append(assigmentDateTime, rhs.assigmentDateTime).isEquals();
    }

}
