
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
    "UDFDefinitions"
})
public class UDFDefinitions implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("UDFDefinitions")
    private List<UDFDefinition> uDFDefinitions = new ArrayList<UDFDefinition>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The uDFDefinitions
     */
    @JsonProperty("UDFDefinitions")
    public List<UDFDefinition> getUDFDefinitions() {
        return uDFDefinitions;
    }

    /**
     * 
     * (Required)
     * 
     * @param uDFDefinitions
     *     The UDFDefinitions
     */
    @JsonProperty("UDFDefinitions")
    public void setUDFDefinitions(List<UDFDefinition> uDFDefinitions) {
        this.uDFDefinitions = uDFDefinitions;
    }

    public UDFDefinitions withUDFDefinitions(List<UDFDefinition> uDFDefinitions) {
        this.uDFDefinitions = uDFDefinitions;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(uDFDefinitions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UDFDefinitions) == false) {
            return false;
        }
        UDFDefinitions rhs = ((UDFDefinitions) other);
        return new EqualsBuilder().append(uDFDefinitions, rhs.uDFDefinitions).isEquals();
    }

}
