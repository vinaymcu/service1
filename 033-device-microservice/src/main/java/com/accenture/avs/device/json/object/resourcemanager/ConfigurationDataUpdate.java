
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
    "UpdateConfigurationData",
    "required"
})
public class ConfigurationDataUpdate implements Serializable
{

    @JsonProperty("UpdateConfigurationData")
    private UpdateConfigurationData updateConfigurationData;
    @JsonProperty("required")
    private Object required;

    /**
     * 
     * @return
     *     The updateConfigurationData
     */
    @JsonProperty("UpdateConfigurationData")
    public UpdateConfigurationData getUpdateConfigurationData() {
        return updateConfigurationData;
    }

    /**
     * 
     * @param updateConfigurationData
     *     The UpdateConfigurationData
     */
    @JsonProperty("UpdateConfigurationData")
    public void setUpdateConfigurationData(UpdateConfigurationData updateConfigurationData) {
        this.updateConfigurationData = updateConfigurationData;
    }

    public ConfigurationDataUpdate withUpdateConfigurationData(UpdateConfigurationData updateConfigurationData) {
        this.updateConfigurationData = updateConfigurationData;
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

    public ConfigurationDataUpdate withRequired(Object required) {
        this.required = required;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(updateConfigurationData).append(required).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConfigurationDataUpdate) == false) {
            return false;
        }
        ConfigurationDataUpdate rhs = ((ConfigurationDataUpdate) other);
        return new EqualsBuilder().append(updateConfigurationData, rhs.updateConfigurationData).append(required, rhs.required).isEquals();
    }

}
