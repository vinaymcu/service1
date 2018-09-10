
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "SubscriberId",
    "Name",
    "City",
    "Status",
    "LocationId",
    "Type",
    "PhoneNumber",
    "SubscriberBWProfile",
    "MaxBWOverride",
    "MaxSTBsPerContentQuality",
    "QoeControlBandwidth",
    "RetEnable",
    "RccEnable",
    "NetworkBufferSize"
})
public class SubscriberUpdate implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SubscriberId")
    private String subscriberId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("LocationId")
    private Integer locationId;
    /**
     * Region/location name of the subscriber.
     * 
     */
    @JsonProperty("Type")
    @JsonPropertyDescription("")
    private String type;
    /**
     * Region/location name of the subscriber.
     * 
     */
    @JsonProperty("PhoneNumber")
    @JsonPropertyDescription("")
    private String phoneNumber;
    @JsonProperty("SubscriberBWProfile")
    private String subscriberBWProfile;
    @JsonProperty("MaxBWOverride")
    private Integer maxBWOverride;
    @JsonProperty("MaxSTBsPerContentQuality")
    private List<MaxSTBsPerContentQuality> maxSTBsPerContentQuality = new ArrayList<MaxSTBsPerContentQuality>();
    @JsonProperty("QoeControlBandwidth")
    private Integer qoeControlBandwidth;
    @JsonProperty("RetEnable")
    private Boolean retEnable;
    @JsonProperty("RccEnable")
    private Boolean rccEnable;
    @JsonProperty("NetworkBufferSize")
    private Integer networkBufferSize;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The subscriberId
     */
    @JsonProperty("SubscriberId")
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * 
     * (Required)
     * 
     * @param subscriberId
     *     The SubscriberId
     */
    @JsonProperty("SubscriberId")
    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public SubscriberUpdate withSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
        return this;
    }

    /**
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
     * @param name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    public SubscriberUpdate withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The city
     */
    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The City
     */
    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    public SubscriberUpdate withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The Status
     */
    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    public SubscriberUpdate withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The locationId
     */
    @JsonProperty("LocationId")
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * 
     * @param locationId
     *     The LocationId
     */
    @JsonProperty("LocationId")
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public SubscriberUpdate withLocationId(Integer locationId) {
        this.locationId = locationId;
        return this;
    }

    /**
     * Region/location name of the subscriber.
     * 
     * @return
     *     The type
     */
    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    /**
     * Region/location name of the subscriber.
     * 
     * @param type
     *     The Type
     */
    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    public SubscriberUpdate withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Region/location name of the subscriber.
     * 
     * @return
     *     The phoneNumber
     */
    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Region/location name of the subscriber.
     * 
     * @param phoneNumber
     *     The PhoneNumber
     */
    @JsonProperty("PhoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SubscriberUpdate withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The subscriberBWProfile
     */
    @JsonProperty("SubscriberBWProfile")
    public String getSubscriberBWProfile() {
        return subscriberBWProfile;
    }

    /**
     * 
     * @param subscriberBWProfile
     *     The SubscriberBWProfile
     */
    @JsonProperty("SubscriberBWProfile")
    public void setSubscriberBWProfile(String subscriberBWProfile) {
        this.subscriberBWProfile = subscriberBWProfile;
    }

    public SubscriberUpdate withSubscriberBWProfile(String subscriberBWProfile) {
        this.subscriberBWProfile = subscriberBWProfile;
        return this;
    }

    /**
     * 
     * @return
     *     The maxBWOverride
     */
    @JsonProperty("MaxBWOverride")
    public Integer getMaxBWOverride() {
        return maxBWOverride;
    }

    /**
     * 
     * @param maxBWOverride
     *     The MaxBWOverride
     */
    @JsonProperty("MaxBWOverride")
    public void setMaxBWOverride(Integer maxBWOverride) {
        this.maxBWOverride = maxBWOverride;
    }

    public SubscriberUpdate withMaxBWOverride(Integer maxBWOverride) {
        this.maxBWOverride = maxBWOverride;
        return this;
    }

    /**
     * 
     * @return
     *     The maxSTBsPerContentQuality
     */
    @JsonProperty("MaxSTBsPerContentQuality")
    public List<MaxSTBsPerContentQuality> getMaxSTBsPerContentQuality() {
        return maxSTBsPerContentQuality;
    }

    /**
     * 
     * @param maxSTBsPerContentQuality
     *     The MaxSTBsPerContentQuality
     */
    @JsonProperty("MaxSTBsPerContentQuality")
    public void setMaxSTBsPerContentQuality(List<MaxSTBsPerContentQuality> maxSTBsPerContentQuality) {
        this.maxSTBsPerContentQuality = maxSTBsPerContentQuality;
    }

    public SubscriberUpdate withMaxSTBsPerContentQuality(List<MaxSTBsPerContentQuality> maxSTBsPerContentQuality) {
        this.maxSTBsPerContentQuality = maxSTBsPerContentQuality;
        return this;
    }

    /**
     * 
     * @return
     *     The qoeControlBandwidth
     */
    @JsonProperty("QoeControlBandwidth")
    public Integer getQoeControlBandwidth() {
        return qoeControlBandwidth;
    }

    /**
     * 
     * @param qoeControlBandwidth
     *     The QoeControlBandwidth
     */
    @JsonProperty("QoeControlBandwidth")
    public void setQoeControlBandwidth(Integer qoeControlBandwidth) {
        this.qoeControlBandwidth = qoeControlBandwidth;
    }

    public SubscriberUpdate withQoeControlBandwidth(Integer qoeControlBandwidth) {
        this.qoeControlBandwidth = qoeControlBandwidth;
        return this;
    }

    /**
     * 
     * @return
     *     The retEnable
     */
    @JsonProperty("RetEnable")
    public Boolean getRetEnable() {
        return retEnable;
    }

    /**
     * 
     * @param retEnable
     *     The RetEnable
     */
    @JsonProperty("RetEnable")
    public void setRetEnable(Boolean retEnable) {
        this.retEnable = retEnable;
    }

    public SubscriberUpdate withRetEnable(Boolean retEnable) {
        this.retEnable = retEnable;
        return this;
    }

    /**
     * 
     * @return
     *     The rccEnable
     */
    @JsonProperty("RccEnable")
    public Boolean getRccEnable() {
        return rccEnable;
    }

    /**
     * 
     * @param rccEnable
     *     The RccEnable
     */
    @JsonProperty("RccEnable")
    public void setRccEnable(Boolean rccEnable) {
        this.rccEnable = rccEnable;
    }

    public SubscriberUpdate withRccEnable(Boolean rccEnable) {
        this.rccEnable = rccEnable;
        return this;
    }

    /**
     * 
     * @return
     *     The networkBufferSize
     */
    @JsonProperty("NetworkBufferSize")
    public Integer getNetworkBufferSize() {
        return networkBufferSize;
    }

    /**
     * 
     * @param networkBufferSize
     *     The NetworkBufferSize
     */
    @JsonProperty("NetworkBufferSize")
    public void setNetworkBufferSize(Integer networkBufferSize) {
        this.networkBufferSize = networkBufferSize;
    }

    public SubscriberUpdate withNetworkBufferSize(Integer networkBufferSize) {
        this.networkBufferSize = networkBufferSize;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(subscriberId).append(name).append(city).append(status).append(locationId).append(type).append(phoneNumber).append(subscriberBWProfile).append(maxBWOverride).append(maxSTBsPerContentQuality).append(qoeControlBandwidth).append(retEnable).append(rccEnable).append(networkBufferSize).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubscriberUpdate) == false) {
            return false;
        }
        SubscriberUpdate rhs = ((SubscriberUpdate) other);
        return new EqualsBuilder().append(subscriberId, rhs.subscriberId).append(name, rhs.name).append(city, rhs.city).append(status, rhs.status).append(locationId, rhs.locationId).append(type, rhs.type).append(phoneNumber, rhs.phoneNumber).append(subscriberBWProfile, rhs.subscriberBWProfile).append(maxBWOverride, rhs.maxBWOverride).append(maxSTBsPerContentQuality, rhs.maxSTBsPerContentQuality).append(qoeControlBandwidth, rhs.qoeControlBandwidth).append(retEnable, rhs.retEnable).append(rccEnable, rhs.rccEnable).append(networkBufferSize, rhs.networkBufferSize).isEquals();
    }

}
