
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
    "ConnectionModes",
    "DefaultPortMappings",
    "ParameterList"
})
public class STBGlobalData implements Serializable
{

    @JsonProperty("ConnectionModes")
    private List<ConnectionMode> connectionModes = new ArrayList<ConnectionMode>();
    @JsonProperty("DefaultPortMappings")
    private List<DefaultPortMapping> defaultPortMappings = new ArrayList<DefaultPortMapping>();
    @JsonProperty("ParameterList")
    private ParameterList parameterList;

    /**
     * 
     * @return
     *     The connectionModes
     */
    @JsonProperty("ConnectionModes")
    public List<ConnectionMode> getConnectionModes() {
        return connectionModes;
    }

    /**
     * 
     * @param connectionModes
     *     The ConnectionModes
     */
    @JsonProperty("ConnectionModes")
    public void setConnectionModes(List<ConnectionMode> connectionModes) {
        this.connectionModes = connectionModes;
    }

    public STBGlobalData withConnectionModes(List<ConnectionMode> connectionModes) {
        this.connectionModes = connectionModes;
        return this;
    }

    /**
     * 
     * @return
     *     The defaultPortMappings
     */
    @JsonProperty("DefaultPortMappings")
    public List<DefaultPortMapping> getDefaultPortMappings() {
        return defaultPortMappings;
    }

    /**
     * 
     * @param defaultPortMappings
     *     The DefaultPortMappings
     */
    @JsonProperty("DefaultPortMappings")
    public void setDefaultPortMappings(List<DefaultPortMapping> defaultPortMappings) {
        this.defaultPortMappings = defaultPortMappings;
    }

    public STBGlobalData withDefaultPortMappings(List<DefaultPortMapping> defaultPortMappings) {
        this.defaultPortMappings = defaultPortMappings;
        return this;
    }

    /**
     * 
     * @return
     *     The parameterList
     */
    @JsonProperty("ParameterList")
    public ParameterList getParameterList() {
        return parameterList;
    }

    /**
     * 
     * @param parameterList
     *     The ParameterList
     */
    @JsonProperty("ParameterList")
    public void setParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public STBGlobalData withParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(connectionModes).append(defaultPortMappings).append(parameterList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBGlobalData) == false) {
            return false;
        }
        STBGlobalData rhs = ((STBGlobalData) other);
        return new EqualsBuilder().append(connectionModes, rhs.connectionModes).append(defaultPortMappings, rhs.defaultPortMappings).append(parameterList, rhs.parameterList).isEquals();
    }

}
