
package com.accenture.avs.device.json.object.devicemanager;

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
    "serviceName",
    "externalPort",
    "internalPort"
})
public class PortMapping implements Serializable
{

    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("externalPort")
    private Integer externalPort;
    @JsonProperty("internalPort")
    private Integer internalPort;

    /**
     * 
     * @return
     *     The serviceName
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 
     * @param serviceName
     *     The serviceName
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public PortMapping withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    /**
     * 
     * @return
     *     The externalPort
     */
    @JsonProperty("externalPort")
    public Integer getExternalPort() {
        return externalPort;
    }

    /**
     * 
     * @param externalPort
     *     The externalPort
     */
    @JsonProperty("externalPort")
    public void setExternalPort(Integer externalPort) {
        this.externalPort = externalPort;
    }

    public PortMapping withExternalPort(Integer externalPort) {
        this.externalPort = externalPort;
        return this;
    }

    /**
     * 
     * @return
     *     The internalPort
     */
    @JsonProperty("internalPort")
    public Integer getInternalPort() {
        return internalPort;
    }

    /**
     * 
     * @param internalPort
     *     The internalPort
     */
    @JsonProperty("internalPort")
    public void setInternalPort(Integer internalPort) {
        this.internalPort = internalPort;
    }

    public PortMapping withInternalPort(Integer internalPort) {
        this.internalPort = internalPort;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceName).append(externalPort).append(internalPort).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PortMapping) == false) {
            return false;
        }
        PortMapping rhs = ((PortMapping) other);
        return new EqualsBuilder().append(serviceName, rhs.serviceName).append(externalPort, rhs.externalPort).append(internalPort, rhs.internalPort).isEquals();
    }

}
