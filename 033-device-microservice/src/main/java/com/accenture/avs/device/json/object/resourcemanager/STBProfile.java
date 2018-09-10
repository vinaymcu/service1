
package com.accenture.avs.device.json.object.resourcemanager;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "resultCode",
    "resultDescription",
    "resultObject",
    "systemTime"
})
public class STBProfile implements Serializable
{

    /**
     * It will be valorized only in case of generic Error, that is only in case the MS will not able to execute the requested interface , for example in case of the DataBase is down( ACN_300). See CreateSTB_errorResponse on attachment. In the other case it will be not present.
     * 
     */
    @JsonProperty("resultCode")
    @JsonPropertyDescription("")
    private String resultCode;
    /**
     * Description Error. Example:  300-GENERIC ERROR.  See CreateSTB_errorResponse on attachment. In the other case it will be not present.
     * 
     */
    @JsonProperty("resultDescription")
    @JsonPropertyDescription("")
    private String resultDescription;
    /**
     * 
     */
    @JsonProperty("resultObject")
    private List<ResultObject> resultObject = new ArrayList<ResultObject>();
    /**
     * GM Time in Milliseconds
     * 
     */
    @JsonProperty("systemTime")
    @JsonPropertyDescription("")
    private String systemTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * It will be valorized only in case of generic Error, that is only in case the MS will not able to execute the requested interface , for example in case of the DataBase is down( ACN_300). See CreateSTB_errorResponse on attachment. In the other case it will be not present.
     * 
     * @return
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public String getResultCode() {
        return resultCode;
    }

    /**
     * It will be valorized only in case of generic Error, that is only in case the MS will not able to execute the requested interface , for example in case of the DataBase is down( ACN_300). See CreateSTB_errorResponse on attachment. In the other case it will be not present.
     * 
     * @param resultCode
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public STBProfile withResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * Description Error. Example:  300-GENERIC ERROR.  See CreateSTB_errorResponse on attachment. In the other case it will be not present.
     * 
     * @return
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     * Description Error. Example:  300-GENERIC ERROR.  See CreateSTB_errorResponse on attachment. In the other case it will be not present.
     * 
     * @param resultDescription
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public STBProfile withResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }

    /**
     * 
     * @return
     *     The resultObject
     */
    @JsonProperty("resultObject")
    public List<ResultObject> getResultObject() {
        return resultObject;
    }

    /**
     * 
     * @param resultObject
     *     The resultObject
     */
    @JsonProperty("resultObject")
    public void setResultObject(List<ResultObject> resultObject) {
        this.resultObject = resultObject;
    }

    public STBProfile withResultObject(List<ResultObject> resultObject) {
        this.resultObject = resultObject;
        return this;
    }

    /**
     * GM Time in Milliseconds
     * 
     * @return
     *     The systemTime
     */
    @JsonProperty("systemTime")
    public String getSystemTime() {
        return systemTime;
    }

    /**
     * GM Time in Milliseconds
     * 
     * @param systemTime
     *     The systemTime
     */
    @JsonProperty("systemTime")
    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public STBProfile withSystemTime(String systemTime) {
        this.systemTime = systemTime;
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

    public STBProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resultCode).append(resultDescription).append(resultObject).append(systemTime).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBProfile) == false) {
            return false;
        }
        STBProfile rhs = ((STBProfile) other);
        return new EqualsBuilder().append(resultCode, rhs.resultCode).append(resultDescription, rhs.resultDescription).append(resultObject, rhs.resultObject).append(systemTime, rhs.systemTime).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
