
package com.accenture.avs.device.json.object.resourcemanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "BWProfile",
    "MaxDeviceProfile",
    "VqEBW",
    "OverrideBW",
    "AssignedDevices"
})
public class Subscriber {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("BWProfile")
    private String bWProfile;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("MaxDeviceProfile")
    private List<MaxDeviceProfile> maxDeviceProfile = new ArrayList<MaxDeviceProfile>();
    @JsonProperty("VqEBW")
    private Integer vqEBW;
    @JsonProperty("OverrideBW")
    private Integer overrideBW;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AssignedDevices")
    private List<AssignedDevice> assignedDevices = new ArrayList<AssignedDevice>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The bWProfile
     */
    @JsonProperty("BWProfile")
    public String getBWProfile() {
        return bWProfile;
    }

    /**
     * 
     * (Required)
     * 
     * @param bWProfile
     *     The BWProfile
     */
    @JsonProperty("BWProfile")
    public void setBWProfile(String bWProfile) {
        this.bWProfile = bWProfile;
    }

    public Subscriber withBWProfile(String bWProfile) {
        this.bWProfile = bWProfile;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The maxDeviceProfile
     */
    @JsonProperty("MaxDeviceProfile")
    public List<MaxDeviceProfile> getMaxDeviceProfile() {
        return maxDeviceProfile;
    }

    /**
     * 
     * (Required)
     * 
     * @param maxDeviceProfile
     *     The MaxDeviceProfile
     */
    @JsonProperty("MaxDeviceProfile")
    public void setMaxDeviceProfile(List<MaxDeviceProfile> maxDeviceProfile) {
        this.maxDeviceProfile = maxDeviceProfile;
    }

    public Subscriber withMaxDeviceProfile(List<MaxDeviceProfile> maxDeviceProfile) {
        this.maxDeviceProfile = maxDeviceProfile;
        return this;
    }

    /**
     * 
     * @return
     *     The vqEBW
     */
    @JsonProperty("VqEBW")
    public Integer getVqEBW() {
        return vqEBW;
    }

    /**
     * 
     * @param vqEBW
     *     The VqEBW
     */
    @JsonProperty("VqEBW")
    public void setVqEBW(Integer vqEBW) {
        this.vqEBW = vqEBW;
    }

    public Subscriber withVqEBW(Integer vqEBW) {
        this.vqEBW = vqEBW;
        return this;
    }

    /**
     * 
     * @return
     *     The overrideBW
     */
    @JsonProperty("OverrideBW")
    public Integer getOverrideBW() {
        return overrideBW;
    }

    /**
     * 
     * @param overrideBW
     *     The OverrideBW
     */
    @JsonProperty("OverrideBW")
    public void setOverrideBW(Integer overrideBW) {
        this.overrideBW = overrideBW;
    }

    public Subscriber withOverrideBW(Integer overrideBW) {
        this.overrideBW = overrideBW;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The assignedDevices
     */
    @JsonProperty("AssignedDevices")
    public List<AssignedDevice> getAssignedDevices() {
        return assignedDevices;
    }

    /**
     * 
     * (Required)
     * 
     * @param assignedDevices
     *     The AssignedDevices
     */
    @JsonProperty("AssignedDevices")
    public void setAssignedDevices(List<AssignedDevice> assignedDevices) {
        this.assignedDevices = assignedDevices;
    }

    public Subscriber withAssignedDevices(List<AssignedDevice> assignedDevices) {
        this.assignedDevices = assignedDevices;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Subscriber withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bWProfile).append(maxDeviceProfile).append(vqEBW).append(overrideBW).append(assignedDevices).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Subscriber) == false) {
            return false;
        }
        Subscriber rhs = ((Subscriber) other);
        return new EqualsBuilder().append(bWProfile, rhs.bWProfile).append(maxDeviceProfile, rhs.maxDeviceProfile).append(vqEBW, rhs.vqEBW).append(overrideBW, rhs.overrideBW).append(assignedDevices, rhs.assignedDevices).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
