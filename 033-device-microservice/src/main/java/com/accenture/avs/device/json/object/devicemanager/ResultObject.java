
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import javax.annotation.Generated;
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
    "id"
})
public class ResultObject implements Serializable
{

    /**
     * ACN_200 in case of success response, ACN_XXXX in case of error
     * (Required)
     * 
     */
    @JsonProperty("resultCode")
    @JsonPropertyDescription("")
    private Object resultCode;
    /**
     * OK if resultCode is ACN_200, otherwise it will be the description of the error.
     * (Required)
     * 
     */
    @JsonProperty("resultDescription")
    @JsonPropertyDescription("")
    private Object resultDescription;
    /**
     * Id of the entity processed  in the request. For e.g. it will be MAC Address in case of STB, account number in case of subscriber etc.
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("")
    private String id;

    /**
     * ACN_200 in case of success response, ACN_XXXX in case of error
     * (Required)
     * 
     * @return
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public Object getResultCode() {
        return resultCode;
    }

    /**
     * ACN_200 in case of success response, ACN_XXXX in case of error
     * (Required)
     * 
     * @param resultCode
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public void setResultCode(Object resultCode) {
        this.resultCode = resultCode;
    }

    public ResultObject withResultCode(Object resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * OK if resultCode is ACN_200, otherwise it will be the description of the error.
     * (Required)
     * 
     * @return
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public Object getResultDescription() {
        return resultDescription;
    }

    /**
     * OK if resultCode is ACN_200, otherwise it will be the description of the error.
     * (Required)
     * 
     * @param resultDescription
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public void setResultDescription(Object resultDescription) {
        this.resultDescription = resultDescription;
    }

    public ResultObject withResultDescription(Object resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }

    /**
     * Id of the entity processed  in the request. For e.g. it will be MAC Address in case of STB, account number in case of subscriber etc.
     * (Required)
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Id of the entity processed  in the request. For e.g. it will be MAC Address in case of STB, account number in case of subscriber etc.
     * (Required)
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public ResultObject withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resultCode).append(resultDescription).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResultObject) == false) {
            return false;
        }
        ResultObject rhs = ((ResultObject) other);
        return new EqualsBuilder().append(resultCode, rhs.resultCode).append(resultDescription, rhs.resultDescription).append(id, rhs.id).isEquals();
    }

}
