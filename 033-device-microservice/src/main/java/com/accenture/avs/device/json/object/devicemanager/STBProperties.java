
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
    "Properties"
})
public class STBProperties implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Properties")
    private List<Property> properties = new ArrayList<Property>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The properties
     */
    @JsonProperty("Properties")
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * 
     * (Required)
     * 
     * @param properties
     *     The Properties
     */
    @JsonProperty("Properties")
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public STBProperties withProperties(List<Property> properties) {
        this.properties = properties;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(properties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBProperties) == false) {
            return false;
        }
        STBProperties rhs = ((STBProperties) other);
        return new EqualsBuilder().append(properties, rhs.properties).isEquals();
    }

}
