
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
    "DeleteSubscribers"
})
public class SubscriberDelete implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DeleteSubscribers")
    private List<String> deleteSubscribers = new ArrayList<String>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The deleteSubscribers
     */
    @JsonProperty("DeleteSubscribers")
    public List<String> getDeleteSubscribers() {
        return deleteSubscribers;
    }

    /**
     * 
     * (Required)
     * 
     * @param deleteSubscribers
     *     The DeleteSubscribers
     */
    @JsonProperty("DeleteSubscribers")
    public void setDeleteSubscribers(List<String> deleteSubscribers) {
        this.deleteSubscribers = deleteSubscribers;
    }

    public SubscriberDelete withDeleteSubscribers(List<String> deleteSubscribers) {
        this.deleteSubscribers = deleteSubscribers;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deleteSubscribers).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubscriberDelete) == false) {
            return false;
        }
        SubscriberDelete rhs = ((SubscriberDelete) other);
        return new EqualsBuilder().append(deleteSubscribers, rhs.deleteSubscribers).isEquals();
    }

}
