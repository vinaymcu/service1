
package com.accenture.avs.device.json.object.resourcemanager;

import java.io.Serializable;
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
    "Subscriber"
})
public class GetProfileReq implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Subscriber")
    private Subscriber subscriber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The subscriber
     */
    @JsonProperty("Subscriber")
    public Subscriber getSubscriber() {
        return subscriber;
    }

    /**
     * 
     * (Required)
     * 
     * @param subscriber
     *     The Subscriber
     */
    @JsonProperty("Subscriber")
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public GetProfileReq withSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
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

    public GetProfileReq withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(subscriber).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetProfileReq) == false) {
            return false;
        }
        GetProfileReq rhs = ((GetProfileReq) other);
        return new EqualsBuilder().append(subscriber, rhs.subscriber).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
