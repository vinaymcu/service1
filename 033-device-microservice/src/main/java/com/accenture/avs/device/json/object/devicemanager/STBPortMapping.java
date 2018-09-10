
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
    "ServiceType",
    "ExternalPort",
    "InternalPort"
})
public class STBPortMapping implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ServiceType")
    private String serviceType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ExternalPort")
    private Integer externalPort;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("InternalPort")
    private Integer internalPort;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The serviceType
     */
    @JsonProperty("ServiceType")
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 
     * (Required)
     * 
     * @param serviceType
     *     The ServiceType
     */
    @JsonProperty("ServiceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public STBPortMapping withServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The externalPort
     */
    @JsonProperty("ExternalPort")
    public Integer getExternalPort() {
        return externalPort;
    }

    /**
     * 
     * (Required)
     * 
     * @param externalPort
     *     The ExternalPort
     */
    @JsonProperty("ExternalPort")
    public void setExternalPort(Integer externalPort) {
        this.externalPort = externalPort;
    }

    public STBPortMapping withExternalPort(Integer externalPort) {
        this.externalPort = externalPort;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The internalPort
     */
    @JsonProperty("InternalPort")
    public Integer getInternalPort() {
        return internalPort;
    }

    /**
     * 
     * (Required)
     * 
     * @param internalPort
     *     The InternalPort
     */
    @JsonProperty("InternalPort")
    public void setInternalPort(Integer internalPort) {
        this.internalPort = internalPort;
    }

    public STBPortMapping withInternalPort(Integer internalPort) {
        this.internalPort = internalPort;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceType).append(externalPort).append(internalPort).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBPortMapping) == false) {
            return false;
        }
        STBPortMapping rhs = ((STBPortMapping) other);
        return new EqualsBuilder().append(serviceType, rhs.serviceType).append(externalPort, rhs.externalPort).append(internalPort, rhs.internalPort).isEquals();
    }

}
