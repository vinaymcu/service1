
package com.accenture.avs.device.json.object.resourcemanager;

import java.util.HashMap;
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
    "id",
    "ResSubscriber"
})
public class ResultObject {

    /**
     * OK if resultDescription is ACN_200, KO otherwise
     * 
     */
    @JsonProperty("resultCode")
    @JsonPropertyDescription("")
    private String resultCode;
    /**
     * ACN_200 in case of success response, ACN_XXXX in case of error
     * 
     */
    @JsonProperty("resultDescription")
    @JsonPropertyDescription("")
    private String resultDescription;
    /**
     * Id of the entity processed  in the request. For e.g. it will be MAC Address in case of STB, account number in case of subscriber etc.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("")
    private String id;
    /**
     * 
     */
    @JsonProperty("ResSubscriber")
    private ResSubscriber resSubscriber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * OK if resultDescription is ACN_200, KO otherwise
     * 
     * @return
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public String getResultCode() {
        return resultCode;
    }

    /**
     * OK if resultDescription is ACN_200, KO otherwise
     * 
     * @param resultCode
     *     The resultCode
     */
    @JsonProperty("resultCode")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public ResultObject withResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * ACN_200 in case of success response, ACN_XXXX in case of error
     * 
     * @return
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     * ACN_200 in case of success response, ACN_XXXX in case of error
     * 
     * @param resultDescription
     *     The resultDescription
     */
    @JsonProperty("resultDescription")
    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public ResultObject withResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
        return this;
    }

    /**
     * Id of the entity processed  in the request. For e.g. it will be MAC Address in case of STB, account number in case of subscriber etc.
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

    /**
     * 
     * @return
     *     The resSubscriber
     */
    @JsonProperty("ResSubscriber")
    public ResSubscriber getResSubscriber() {
        return resSubscriber;
    }

    /**
     * 
     * @param resSubscriber
     *     The ResSubscriber
     */
    @JsonProperty("ResSubscriber")
    public void setResSubscriber(ResSubscriber resSubscriber) {
        this.resSubscriber = resSubscriber;
    }

    public ResultObject withResSubscriber(ResSubscriber resSubscriber) {
        this.resSubscriber = resSubscriber;
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

    public ResultObject withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resultCode).append(resultDescription).append(id).append(resSubscriber).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(resultCode, rhs.resultCode).append(resultDescription, rhs.resultDescription).append(id, rhs.id).append(resSubscriber, rhs.resSubscriber).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
