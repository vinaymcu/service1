
package com.accenture.avs.device.json.object.devicemanager;

import java.util.HashMap;
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
    "resultCode",
    "resultDescription",
    "resultObj",
    "executionTime"
})
public class GetDeviceAuditLogsResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("resultCode")
    private String resultCode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("resultDescription")
    private String resultDescription;
    /**
     * 
     */
    @JsonProperty("resultObj")
    private DeviceLogs resultObj;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("executionTime")
    private Integer executionTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 
     * (Required)
     * 
     * @param resultCode
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     * 
     * (Required)
     * 
     * @param resultDescription
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    /**
     * 
     * @return
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public DeviceLogs getResultObj() {
        return resultObj;
    }

    /**
     * 
     * @param resultObj
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public void setResultObj(DeviceLogs resultObj) {
        this.resultObj = resultObj;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The executionTime
     */
    @JsonProperty("executionTime")
    public Integer getExecutionTime() {
        return executionTime;
    }

    /**
     * 
     * (Required)
     * 
     * @param executionTime
     *     The executionTime
     */
    @JsonProperty("executionTime")
    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
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
        return new HashCodeBuilder().append(resultCode).append(resultDescription).append(resultObj).append(executionTime).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetDeviceAuditLogsResponse) == false) {
            return false;
        }
        GetDeviceAuditLogsResponse rhs = ((GetDeviceAuditLogsResponse) other);
        return new EqualsBuilder().append(resultCode, rhs.resultCode).append(resultDescription, rhs.resultDescription).append(resultObj, rhs.resultObj).append(executionTime, rhs.executionTime).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
