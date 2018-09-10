
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
    "AccountNumber",
    "Name",
    "SubscriberId",
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
public class SubscriberDetail implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AccountNumber")
    private String accountNumber;
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
    @JsonProperty("SubscriberId")
    private String subscriberId;
    @JsonProperty("City")
    private String city;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Status")
    private String status;
    /**
     * 
     * (Required)
     * 
     */
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
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SubscriberBWProfile")
    private String subscriberBWProfile;
    @JsonProperty("MaxBWOverride")
    private Integer maxBWOverride;
    /**
     * 
     * (Required)
     * 
     */
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
     *     The accountNumber
     */
    @JsonProperty("AccountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 
     * (Required)
     * 
     * @param accountNumber
     *     The AccountNumber
     */
    @JsonProperty("AccountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public SubscriberDetail withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public SubscriberDetail withName(String name) {
        this.name = name;
        return this;
    }

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

    public SubscriberDetail withSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
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

    public SubscriberDetail withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param status
     *     The Status
     */
    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    public SubscriberDetail withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param locationId
     *     The LocationId
     */
    @JsonProperty("LocationId")
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public SubscriberDetail withLocationId(Integer locationId) {
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

    public SubscriberDetail withType(String type) {
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

    public SubscriberDetail withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param subscriberBWProfile
     *     The SubscriberBWProfile
     */
    @JsonProperty("SubscriberBWProfile")
    public void setSubscriberBWProfile(String subscriberBWProfile) {
        this.subscriberBWProfile = subscriberBWProfile;
    }

    public SubscriberDetail withSubscriberBWProfile(String subscriberBWProfile) {
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

    public SubscriberDetail withMaxBWOverride(Integer maxBWOverride) {
        this.maxBWOverride = maxBWOverride;
        return this;
    }

    /**
     * 
     * (Required)
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
     * (Required)
     * 
     * @param maxSTBsPerContentQuality
     *     The MaxSTBsPerContentQuality
     */
    @JsonProperty("MaxSTBsPerContentQuality")
    public void setMaxSTBsPerContentQuality(List<MaxSTBsPerContentQuality> maxSTBsPerContentQuality) {
        this.maxSTBsPerContentQuality = maxSTBsPerContentQuality;
    }

    public SubscriberDetail withMaxSTBsPerContentQuality(List<MaxSTBsPerContentQuality> maxSTBsPerContentQuality) {
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

    public SubscriberDetail withQoeControlBandwidth(Integer qoeControlBandwidth) {
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

    public SubscriberDetail withRetEnable(Boolean retEnable) {
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

    public SubscriberDetail withRccEnable(Boolean rccEnable) {
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

    public SubscriberDetail withNetworkBufferSize(Integer networkBufferSize) {
        this.networkBufferSize = networkBufferSize;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountNumber).append(name).append(subscriberId).append(city).append(status).append(locationId).append(type).append(phoneNumber).append(subscriberBWProfile).append(maxBWOverride).append(maxSTBsPerContentQuality).append(qoeControlBandwidth).append(retEnable).append(rccEnable).append(networkBufferSize).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubscriberDetail) == false) {
            return false;
        }
        SubscriberDetail rhs = ((SubscriberDetail) other);
        return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(name, rhs.name).append(subscriberId, rhs.subscriberId).append(city, rhs.city).append(status, rhs.status).append(locationId, rhs.locationId).append(type, rhs.type).append(phoneNumber, rhs.phoneNumber).append(subscriberBWProfile, rhs.subscriberBWProfile).append(maxBWOverride, rhs.maxBWOverride).append(maxSTBsPerContentQuality, rhs.maxSTBsPerContentQuality).append(qoeControlBandwidth, rhs.qoeControlBandwidth).append(retEnable, rhs.retEnable).append(rccEnable, rhs.rccEnable).append(networkBufferSize, rhs.networkBufferSize).isEquals();
    }

}
