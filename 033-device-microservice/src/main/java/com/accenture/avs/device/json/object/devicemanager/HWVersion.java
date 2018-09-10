
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
    "Name",
    "QoECapable",
    "DisableSTBAutoRegistration",
    "VideoTypeProfile"
})
public class HWVersion implements Serializable
{

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
    @JsonProperty("QoECapable")
    private Boolean qoECapable;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DisableSTBAutoRegistration")
    private Boolean disableSTBAutoRegistration;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("VideoTypeProfile")
    private List<String> videoTypeProfile = new ArrayList<String>();

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

    public HWVersion withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The qoECapable
     */
    @JsonProperty("QoECapable")
    public Boolean getQoECapable() {
        return qoECapable;
    }

    /**
     * 
     * (Required)
     * 
     * @param qoECapable
     *     The QoECapable
     */
    @JsonProperty("QoECapable")
    public void setQoECapable(Boolean qoECapable) {
        this.qoECapable = qoECapable;
    }

    public HWVersion withQoECapable(Boolean qoECapable) {
        this.qoECapable = qoECapable;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The disableSTBAutoRegistration
     */
    @JsonProperty("DisableSTBAutoRegistration")
    public Boolean getDisableSTBAutoRegistration() {
        return disableSTBAutoRegistration;
    }

    /**
     * 
     * (Required)
     * 
     * @param disableSTBAutoRegistration
     *     The DisableSTBAutoRegistration
     */
    @JsonProperty("DisableSTBAutoRegistration")
    public void setDisableSTBAutoRegistration(Boolean disableSTBAutoRegistration) {
        this.disableSTBAutoRegistration = disableSTBAutoRegistration;
    }

    public HWVersion withDisableSTBAutoRegistration(Boolean disableSTBAutoRegistration) {
        this.disableSTBAutoRegistration = disableSTBAutoRegistration;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The videoTypeProfile
     */
    @JsonProperty("VideoTypeProfile")
    public List<String> getVideoTypeProfile() {
        return videoTypeProfile;
    }

    /**
     * 
     * (Required)
     * 
     * @param videoTypeProfile
     *     The VideoTypeProfile
     */
    @JsonProperty("VideoTypeProfile")
    public void setVideoTypeProfile(List<String> videoTypeProfile) {
        this.videoTypeProfile = videoTypeProfile;
    }

    public HWVersion withVideoTypeProfile(List<String> videoTypeProfile) {
        this.videoTypeProfile = videoTypeProfile;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(qoECapable).append(disableSTBAutoRegistration).append(videoTypeProfile).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HWVersion) == false) {
            return false;
        }
        HWVersion rhs = ((HWVersion) other);
        return new EqualsBuilder().append(name, rhs.name).append(qoECapable, rhs.qoECapable).append(disableSTBAutoRegistration, rhs.disableSTBAutoRegistration).append(videoTypeProfile, rhs.videoTypeProfile).isEquals();
    }

}
