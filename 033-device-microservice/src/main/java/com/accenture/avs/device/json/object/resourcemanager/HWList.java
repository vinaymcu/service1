
package com.accenture.avs.device.json.object.resourcemanager;

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
    "HWVersion",
    "QoECapable",
    "HWVIDEOTYPENAMELIST",
    "required",
    "additionalProperties"
})
public class HWList {

    @JsonProperty("HWVersion")
    private String hWVersion;
    @JsonProperty("QoECapable")
    private Boolean qoECapable;
    @JsonProperty("HWVIDEOTYPENAMELIST")
    private List<String> hWVIDEOTYPENAMELIST = new ArrayList<String>();
    @JsonProperty("required")
    private Object required;
    @JsonProperty("additionalProperties")
    private Object additionalProperties;

    /**
     * 
     * @return
     *     The hWVersion
     */
    @JsonProperty("HWVersion")
    public String getHWVersion() {
        return hWVersion;
    }

    /**
     * 
     * @param hWVersion
     *     The HWVersion
     */
    @JsonProperty("HWVersion")
    public void setHWVersion(String hWVersion) {
        this.hWVersion = hWVersion;
    }

    public HWList withHWVersion(String hWVersion) {
        this.hWVersion = hWVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The qoECapable
     */
    @JsonProperty("QoECapable")
    public Boolean getQoECapable() {
        return qoECapable;
    }

    /**
     * 
     * @param qoECapable
     *     The QoECapable
     */
    @JsonProperty("QoECapable")
    public void setQoECapable(Boolean qoECapable) {
        this.qoECapable = qoECapable;
    }

    public HWList withQoECapable(Boolean qoECapable) {
        this.qoECapable = qoECapable;
        return this;
    }

    /**
     * 
     * @return
     *     The hWVIDEOTYPENAMELIST
     */
    @JsonProperty("HWVIDEOTYPENAMELIST")
    public List<String> getHWVIDEOTYPENAMELIST() {
        return hWVIDEOTYPENAMELIST;
    }

    /**
     * 
     * @param hWVIDEOTYPENAMELIST
     *     The HWVIDEOTYPENAMELIST
     */
    @JsonProperty("HWVIDEOTYPENAMELIST")
    public void setHWVIDEOTYPENAMELIST(List<String> hWVIDEOTYPENAMELIST) {
        this.hWVIDEOTYPENAMELIST = hWVIDEOTYPENAMELIST;
    }

    public HWList withHWVIDEOTYPENAMELIST(List<String> hWVIDEOTYPENAMELIST) {
        this.hWVIDEOTYPENAMELIST = hWVIDEOTYPENAMELIST;
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

    public HWList withRequired(Object required) {
        this.required = required;
        return this;
    }

    /**
     * 
     * @return
     *     The additionalProperties
     */
    @JsonProperty("additionalProperties")
    public Object getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * 
     * @param additionalProperties
     *     The additionalProperties
     */
    @JsonProperty("additionalProperties")
    public void setAdditionalProperties(Object additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public HWList withAdditionalProperties(Object additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hWVersion).append(qoECapable).append(hWVIDEOTYPENAMELIST).append(required).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HWList) == false) {
            return false;
        }
        HWList rhs = ((HWList) other);
        return new EqualsBuilder().append(hWVersion, rhs.hWVersion).append(qoECapable, rhs.qoECapable).append(hWVIDEOTYPENAMELIST, rhs.hWVIDEOTYPENAMELIST).append(required, rhs.required).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
