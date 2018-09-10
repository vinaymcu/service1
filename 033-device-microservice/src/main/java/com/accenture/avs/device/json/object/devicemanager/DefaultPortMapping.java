
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
    "ServiceName",
    "DefaultInternalPort",
    "DefaultExternalPort",
    "Protocol",
    "STBHWVersions"
})
public class DefaultPortMapping implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ServiceName")
    private String serviceName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DefaultInternalPort")
    private Integer defaultInternalPort;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DefaultExternalPort")
    private Integer defaultExternalPort;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Protocol")
    private String protocol;
    @JsonProperty("STBHWVersions")
    private STBHWVersions sTBHWVersions;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The serviceName
     */
    @JsonProperty("ServiceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 
     * (Required)
     * 
     * @param serviceName
     *     The ServiceName
     */
    @JsonProperty("ServiceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public DefaultPortMapping withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The defaultInternalPort
     */
    @JsonProperty("DefaultInternalPort")
    public Integer getDefaultInternalPort() {
        return defaultInternalPort;
    }

    /**
     * 
     * (Required)
     * 
     * @param defaultInternalPort
     *     The DefaultInternalPort
     */
    @JsonProperty("DefaultInternalPort")
    public void setDefaultInternalPort(Integer defaultInternalPort) {
        this.defaultInternalPort = defaultInternalPort;
    }

    public DefaultPortMapping withDefaultInternalPort(Integer defaultInternalPort) {
        this.defaultInternalPort = defaultInternalPort;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The defaultExternalPort
     */
    @JsonProperty("DefaultExternalPort")
    public Integer getDefaultExternalPort() {
        return defaultExternalPort;
    }

    /**
     * 
     * (Required)
     * 
     * @param defaultExternalPort
     *     The DefaultExternalPort
     */
    @JsonProperty("DefaultExternalPort")
    public void setDefaultExternalPort(Integer defaultExternalPort) {
        this.defaultExternalPort = defaultExternalPort;
    }

    public DefaultPortMapping withDefaultExternalPort(Integer defaultExternalPort) {
        this.defaultExternalPort = defaultExternalPort;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The protocol
     */
    @JsonProperty("Protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * 
     * (Required)
     * 
     * @param protocol
     *     The Protocol
     */
    @JsonProperty("Protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public DefaultPortMapping withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * 
     * @return
     *     The sTBHWVersions
     */
    @JsonProperty("STBHWVersions")
    public STBHWVersions getSTBHWVersions() {
        return sTBHWVersions;
    }

    /**
     * 
     * @param sTBHWVersions
     *     The STBHWVersions
     */
    @JsonProperty("STBHWVersions")
    public void setSTBHWVersions(STBHWVersions sTBHWVersions) {
        this.sTBHWVersions = sTBHWVersions;
    }

    public DefaultPortMapping withSTBHWVersions(STBHWVersions sTBHWVersions) {
        this.sTBHWVersions = sTBHWVersions;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceName).append(defaultInternalPort).append(defaultExternalPort).append(protocol).append(sTBHWVersions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DefaultPortMapping) == false) {
            return false;
        }
        DefaultPortMapping rhs = ((DefaultPortMapping) other);
        return new EqualsBuilder().append(serviceName, rhs.serviceName).append(defaultInternalPort, rhs.defaultInternalPort).append(defaultExternalPort, rhs.defaultExternalPort).append(protocol, rhs.protocol).append(sTBHWVersions, rhs.sTBHWVersions).isEquals();
    }

}
