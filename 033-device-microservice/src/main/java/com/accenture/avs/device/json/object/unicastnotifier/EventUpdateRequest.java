
package com.accenture.avs.device.json.object.unicastnotifier;

import java.util.HashMap;
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
    "EventUpdate"
})
public class EventUpdateRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("EventUpdate")
    private EventUpdate eventUpdate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The eventUpdate
     */
    @JsonProperty("EventUpdate")
    public EventUpdate getEventUpdate() {
        return eventUpdate;
    }

    /**
     * 
     * (Required)
     * 
     * @param eventUpdate
     *     The EventUpdate
     */
    @JsonProperty("EventUpdate")
    public void setEventUpdate(EventUpdate eventUpdate) {
        this.eventUpdate = eventUpdate;
    }

    public EventUpdateRequest withEventUpdate(EventUpdate eventUpdate) {
        this.eventUpdate = eventUpdate;
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

    public EventUpdateRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventUpdate).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EventUpdateRequest) == false) {
            return false;
        }
        EventUpdateRequest rhs = ((EventUpdateRequest) other);
        return new EqualsBuilder().append(eventUpdate, rhs.eventUpdate).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
