
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
    "SubscriberUpdates"
})
public class UpdateSubscriber implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SubscriberUpdates")
    private List<SubscriberUpdate> subscriberUpdates = new ArrayList<SubscriberUpdate>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The subscriberUpdates
     */
    @JsonProperty("SubscriberUpdates")
    public List<SubscriberUpdate> getSubscriberUpdates() {
        return subscriberUpdates;
    }

    /**
     * 
     * (Required)
     * 
     * @param subscriberUpdates
     *     The SubscriberUpdates
     */
    @JsonProperty("SubscriberUpdates")
    public void setSubscriberUpdates(List<SubscriberUpdate> subscriberUpdates) {
        this.subscriberUpdates = subscriberUpdates;
    }

    public UpdateSubscriber withSubscriberUpdates(List<SubscriberUpdate> subscriberUpdates) {
        this.subscriberUpdates = subscriberUpdates;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(subscriberUpdates).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateSubscriber) == false) {
            return false;
        }
        UpdateSubscriber rhs = ((UpdateSubscriber) other);
        return new EqualsBuilder().append(subscriberUpdates, rhs.subscriberUpdates).isEquals();
    }

}
