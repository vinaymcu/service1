
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "resultCode",
    "resultDescription",
    "executionTime",
    "resultObj"
})
public class GetDeviceModelListResponse implements Serializable
{

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
    /**
     * 
     */
    @JsonProperty("resultObj")
    private DeviceModelResultObj resultObj;
    private final static long serialVersionUID = 5607706636763809207L;

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
    public DeviceModelResultObj getResultObj() {
        return resultObj;
    }

    /**
     * 
     * @param resultObj
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public void setResultObj(DeviceModelResultObj resultObj) {
        this.resultObj = resultObj;
    }

}
