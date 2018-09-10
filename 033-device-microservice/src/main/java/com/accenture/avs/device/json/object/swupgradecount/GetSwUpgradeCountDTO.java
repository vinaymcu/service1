
package com.accenture.avs.device.json.object.swupgradecount;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "resultCode",
    "resultDescription",
    "resultObj",
    "executionTime"
})
public class GetSwUpgradeCountDTO implements Serializable
{

    /**
     * In case of success, it will be ACN_200.
     * (Required)
     * 
     */
    @JsonProperty("resultCode")
    @JsonPropertyDescription("")
    private String resultCode;
    /**
     * Description of the result code
     * (Required)
     * 
     */
    @JsonProperty("resultDescription")
    @JsonPropertyDescription("")
    private String resultDescription;
    @JsonProperty("resultObj")
    private List<ResultObj> resultObj = new ArrayList<ResultObj>();
    /**
     * GM Time in Milliseconds
     * (Required)
     * 
     */
    @JsonProperty("executionTime")
    @JsonPropertyDescription("")
    private Integer executionTime;
    private final static long serialVersionUID = 125028469187783064L;

    /**
     * In case of success, it will be ACN_200.
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
     * In case of success, it will be ACN_200.
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
     * Description of the result code
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
     * Description of the result code
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
    public List<ResultObj> getResultObj() {
        return resultObj;
    }

    /**
     * 
     * @param resultObj
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public void setResultObj(List<ResultObj> resultObj) {
        this.resultObj = resultObj;
    }

    /**
     * GM Time in Milliseconds
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
     * GM Time in Milliseconds
     * (Required)
     * 
     * @param executionTime
     *     The executionTime
     */
    @JsonProperty("executionTime")
    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

}
