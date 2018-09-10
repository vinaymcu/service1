
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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
public class GenericResponse implements Serializable
{

    /**
     * It will be valorized  in case of generic Error, that is in case the MS will not able to execute the requested interface, for example in case of the DataBase is down(ACN_300) or in case all entities in the request (or the single entity in case the request is not for list of entities) are successfully executed (ACN_200). In the other case it will be not present.
     * (Required)
     * 
     */
    @JsonProperty("resultCode")
    @JsonPropertyDescription("")
    private String resultCode;
    /**
     * Description Error. Example:  300-GENERIC ERROR.  In the other case it will be not present.
     * (Required)
     * 
     */
    @JsonProperty("resultDescription")
    @JsonPropertyDescription("")
    private String resultDescription;
    @JsonProperty("resultObj")
    private List<ResultObject> resultObj = new ArrayList<ResultObject>();
    /**
     * GM Time in Milliseconds
     * (Required)
     * 
     */
    @JsonProperty("executionTime")
    @JsonPropertyDescription("")
    private Integer executionTime;

    /**
     * It will be valorized  in case of generic Error, that is in case the MS will not able to execute the requested interface, for example in case of the DataBase is down(ACN_300) or in case all entities in the request (or the single entity in case the request is not for list of entities) are successfully executed (ACN_200). In the other case it will be not present.
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
     * It will be valorized  in case of generic Error, that is in case the MS will not able to execute the requested interface, for example in case of the DataBase is down(ACN_300) or in case all entities in the request (or the single entity in case the request is not for list of entities) are successfully executed (ACN_200). In the other case it will be not present.
     * (Required)
     * 
     * @param resultCode
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public GenericResponse withResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * Description Error. Example:  300-GENERIC ERROR.  In the other case it will be not present.
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
     * Description Error. Example:  300-GENERIC ERROR.  In the other case it will be not present.
     * (Required)
     * 
     * @param resultDescription
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public GenericResponse withResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }

    /**
     * 
     * @return
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public List<ResultObject> getResultObj() {
        return resultObj;
    }

    /**
     * 
     * @param resultObj
     *     The resultObj
     */
    @JsonProperty("resultObj")
    public void setResultObj(List<ResultObject> resultObj) {
        this.resultObj = resultObj;
    }

    public GenericResponse withResultObj(List<ResultObject> resultObj) {
        this.resultObj = resultObj;
        return this;
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

    public GenericResponse withExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resultCode).append(resultDescription).append(resultObj).append(executionTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GenericResponse) == false) {
            return false;
        }
        GenericResponse rhs = ((GenericResponse) other);
        return new EqualsBuilder().append(resultCode, rhs.resultCode).append(resultDescription, rhs.resultDescription).append(resultObj, rhs.resultObj).append(executionTime, rhs.executionTime).isEquals();
    }

}
