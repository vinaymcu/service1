
package com.accenture.avs.device.json.object.devicemanager;

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
    "resultCode",
    "resultDescription",
    "executionTime",
    "resultObj"
})
public class GetDeviceListResponse {

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
     * (Required)
     * 
     */
    @JsonProperty("executionTime")
    private Integer executionTime;
    @JsonProperty("resultObj")
    private DeviceList resultObj;

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

    /**
     * 
     * @return
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public DeviceList getResultObj() {
        return resultObj;
    }

    /**
     * 
     * @param resultObj
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public void setResultObj(DeviceList resultObj) {
        this.resultObj = resultObj;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resultCode).append(resultDescription).append(executionTime).append(resultObj).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetDeviceListResponse) == false) {
            return false;
        }
        GetDeviceListResponse rhs = ((GetDeviceListResponse) other);
        return new EqualsBuilder().append(resultCode, rhs.resultCode).append(resultDescription, rhs.resultDescription).append(executionTime, rhs.executionTime).append(resultObj, rhs.resultObj).isEquals();
    }

}
