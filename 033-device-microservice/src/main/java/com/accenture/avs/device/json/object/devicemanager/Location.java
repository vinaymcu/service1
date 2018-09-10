
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
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
    "ID",
    "ParentID",
    "Name",
    "TVRegionID"
})
public class Location implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ID")
    private Integer iD;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ParentID")
    private Integer parentID;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("TVRegionID")
    private Integer tVRegionID;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The iD
     */
    @JsonProperty("ID")
    public Integer getID() {
        return iD;
    }

    /**
     * 
     * (Required)
     * 
     * @param iD
     *     The ID
     */
    @JsonProperty("ID")
    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Location withID(Integer iD) {
        this.iD = iD;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The parentID
     */
    @JsonProperty("ParentID")
    public Integer getParentID() {
        return parentID;
    }

    /**
     * 
     * (Required)
     * 
     * @param parentID
     *     The ParentID
     */
    @JsonProperty("ParentID")
    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Location withParentID(Integer parentID) {
        this.parentID = parentID;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The name
     */
    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     * @param name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    public Location withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tVRegionID
     */
    @JsonProperty("TVRegionID")
    public Integer getTVRegionID() {
        return tVRegionID;
    }

    /**
     * 
     * (Required)
     * 
     * @param tVRegionID
     *     The TVRegionID
     */
    @JsonProperty("TVRegionID")
    public void setTVRegionID(Integer tVRegionID) {
        this.tVRegionID = tVRegionID;
    }

    public Location withTVRegionID(Integer tVRegionID) {
        this.tVRegionID = tVRegionID;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iD).append(parentID).append(name).append(tVRegionID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Location) == false) {
            return false;
        }
        Location rhs = ((Location) other);
        return new EqualsBuilder().append(iD, rhs.iD).append(parentID, rhs.parentID).append(name, rhs.name).append(tVRegionID, rhs.tVRegionID).isEquals();
    }

}
