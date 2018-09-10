
package com.accenture.avs.device.json.object.resourcemanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "BWProfileName",
    "Bandwidth",
    " BWVideoTypeNameList "
})
public class BWProfileList {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("BWProfileName")
    private String bWProfileName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Bandwidth")
    private String bandwidth;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty(" BWVideoTypeNameList ")
    private List<String> bWVideoTypeNameList = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The bWProfileName
     */
    @JsonProperty("BWProfileName")
    public String getBWProfileName() {
        return bWProfileName;
    }

    /**
     * 
     * (Required)
     * 
     * @param bWProfileName
     *     The BWProfileName
     */
    @JsonProperty("BWProfileName")
    public void setBWProfileName(String bWProfileName) {
        this.bWProfileName = bWProfileName;
    }

    public BWProfileList withBWProfileName(String bWProfileName) {
        this.bWProfileName = bWProfileName;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The bandwidth
     */
    @JsonProperty("Bandwidth")
    public String getBandwidth() {
        return bandwidth;
    }

    /**
     * 
     * (Required)
     * 
     * @param bandwidth
     *     The Bandwidth
     */
    @JsonProperty("Bandwidth")
    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public BWProfileList withBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The bWVideoTypeNameList
     */
    @JsonProperty(" BWVideoTypeNameList ")
    public List<String> getBWVideoTypeNameList() {
        return bWVideoTypeNameList;
    }

    /**
     * 
     * (Required)
     * 
     * @param bWVideoTypeNameList
     *     The  BWVideoTypeNameList 
     */
    @JsonProperty(" BWVideoTypeNameList ")
    public void setBWVideoTypeNameList(List<String> bWVideoTypeNameList) {
        this.bWVideoTypeNameList = bWVideoTypeNameList;
    }

    public BWProfileList withBWVideoTypeNameList(List<String> bWVideoTypeNameList) {
        this.bWVideoTypeNameList = bWVideoTypeNameList;
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

    public BWProfileList withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bWProfileName).append(bandwidth).append(bWVideoTypeNameList).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BWProfileList) == false) {
            return false;
        }
        BWProfileList rhs = ((BWProfileList) other);
        return new EqualsBuilder().append(bWProfileName, rhs.bWProfileName).append(bandwidth, rhs.bandwidth).append(bWVideoTypeNameList, rhs.bWVideoTypeNameList).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
