
package com.accenture.avs.device.json.object.resourcemanager;

import java.io.Serializable;
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
    "CreateConfigurationData",
    "required"
})
public class ConfigurationData implements Serializable
{

    /**
     * 
     */
    @JsonProperty("CreateConfigurationData")
    private CreateConfigurationData createConfigurationData;
    @JsonProperty("required")
    private Object required;

    /**
     * 
     * @return
     *     The createConfigurationData
     */
    @JsonProperty("CreateConfigurationData")
    public CreateConfigurationData getCreateConfigurationData() {
        return createConfigurationData;
    }

    /**
     * 
     * @param createConfigurationData
     *     The CreateConfigurationData
     */
    @JsonProperty("CreateConfigurationData")
    public void setCreateConfigurationData(CreateConfigurationData createConfigurationData) {
        this.createConfigurationData = createConfigurationData;
    }

    public ConfigurationData withCreateConfigurationData(CreateConfigurationData createConfigurationData) {
        this.createConfigurationData = createConfigurationData;
        return this;
    }

    /**
     * 
     * @return
     *     The required
     */
    @JsonProperty("required")
    public Object getRequired() {
        return required;
    }

    /**
     * 
     * @param required
     *     The required
     */
    @JsonProperty("required")
    public void setRequired(Object required) {
        this.required = required;
    }

    public ConfigurationData withRequired(Object required) {
        this.required = required;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(createConfigurationData).append(required).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConfigurationData) == false) {
            return false;
        }
        ConfigurationData rhs = ((ConfigurationData) other);
        return new EqualsBuilder().append(createConfigurationData, rhs.createConfigurationData).append(required, rhs.required).isEquals();
    }

}
