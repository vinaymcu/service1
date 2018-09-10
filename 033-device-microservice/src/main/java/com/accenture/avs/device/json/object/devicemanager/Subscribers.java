
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
    "SubscriberDetails"
})
public class Subscribers implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SubscriberDetails")
    private List<SubscriberDetail> subscriberDetails = new ArrayList<SubscriberDetail>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The subscriberDetails
     */
    @JsonProperty("SubscriberDetails")
    public List<SubscriberDetail> getSubscriberDetails() {
        return subscriberDetails;
    }

    /**
     * 
     * (Required)
     * 
     * @param subscriberDetails
     *     The SubscriberDetails
     */
    @JsonProperty("SubscriberDetails")
    public void setSubscriberDetails(List<SubscriberDetail> subscriberDetails) {
        this.subscriberDetails = subscriberDetails;
    }

    public Subscribers withSubscriberDetails(List<SubscriberDetail> subscriberDetails) {
        this.subscriberDetails = subscriberDetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(subscriberDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Subscribers) == false) {
            return false;
        }
        Subscribers rhs = ((Subscribers) other);
        return new EqualsBuilder().append(subscriberDetails, rhs.subscriberDetails).isEquals();
    }

}
