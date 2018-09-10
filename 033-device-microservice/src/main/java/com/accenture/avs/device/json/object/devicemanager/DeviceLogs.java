
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
    "deviceLogs"
})
public class DeviceLogs {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalResults")
    private Integer totalResults;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deviceLogs")
    private List<DeviceLogDTO> deviceLogDto = new ArrayList<DeviceLogDTO>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
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
     * (Required)
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
     * (Required)
     * 
     * @return
     *     The deviceLogs
     */
    @JsonProperty("deviceLogs")
    public List<DeviceLogDTO> getDeviceLogs() {
        return deviceLogDto;
    }

    /**
     * 
     * (Required)
     * 
     * @param deviceLogs
     *     The deviceLogs
     */
    @JsonProperty("deviceLogs")
    public void setDeviceLogs(List<DeviceLogDTO> deviceLogs) {
        this.deviceLogDto = deviceLogs;
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
        return new HashCodeBuilder().append(totalResults).append(deviceLogDto).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeviceLogs) == false) {
            return false;
        }
        DeviceLogs rhs = ((DeviceLogs) other);
        return new EqualsBuilder().append(totalResults, rhs.totalResults).append(deviceLogDto, rhs.deviceLogDto).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
