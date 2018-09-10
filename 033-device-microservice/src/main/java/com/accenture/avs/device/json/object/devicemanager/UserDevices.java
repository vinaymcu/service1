
package com.accenture.avs.device.json.object.devicemanager;

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
    "totalResults",
    "userDevicesList"
})
public class UserDevices {

    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("userDevicesList")
    private List<UserDevicesListDto> userDevicesList = new ArrayList<UserDevicesListDto>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The totalResults
     */
    @JsonProperty("totalResults")
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The totalResults
     */
    @JsonProperty("totalResults")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The userDevicesList
     */
    @JsonProperty("userDevicesList")
    public List<UserDevicesListDto> getUserDevicesList() {
        return userDevicesList;
    }

    /**
     * 
     * @param userDevicesList
     *     The userDevicesList
     */
    @JsonProperty("userDevicesList")
    public void setUserDevicesList(List<UserDevicesListDto> userDevicesList) {
        this.userDevicesList = userDevicesList;
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalResults).append(userDevicesList).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserDevices) == false) {
            return false;
        }
        UserDevices rhs = ((UserDevices) other);
        return new EqualsBuilder().append(totalResults, rhs.totalResults).append(userDevicesList, rhs.userDevicesList).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
