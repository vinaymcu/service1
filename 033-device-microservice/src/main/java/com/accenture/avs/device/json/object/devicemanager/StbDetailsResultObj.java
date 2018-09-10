
package com.accenture.avs.device.json.object.devicemanager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "totalResults",
    "STBDetailList",
    "Error"
})
public class StbDetailsResultObj {

    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("STBDetailList")
    private List<STBDetailList> sTBDetailList = new ArrayList<STBDetailList>();
    @JsonProperty("Error")
    private List<Error> error = new ArrayList<Error>();

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

    public StbDetailsResultObj withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    /**
     * 
     * @return
     *     The sTBDetailList
     */
    @JsonProperty("STBDetailList")
    public List<STBDetailList> getSTBDetailList() {
        return sTBDetailList;
    }

    /**
     * 
     * @param sTBDetailList
     *     The STBDetailList
     */
    @JsonProperty("STBDetailList")
    public void setSTBDetailList(List<STBDetailList> sTBDetailList) {
        this.sTBDetailList = sTBDetailList;
    }

    public StbDetailsResultObj withSTBDetailList(List<STBDetailList> sTBDetailList) {
        this.sTBDetailList = sTBDetailList;
        return this;
    }

    /**
     * 
     * @return
     *     The error
     */
    @JsonProperty("Error")
    public List<Error> getError() {
        return error;
    }

    /**
     * 
     * @param error
     *     The Error
     */
    @JsonProperty("Error")
    public void setError(List<Error> error) {
        this.error = error;
    }

    public StbDetailsResultObj withError(List<Error> error) {
        this.error = error;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalResults).append(sTBDetailList).append(error).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StbDetailsResultObj) == false) {
            return false;
        }
        StbDetailsResultObj rhs = ((StbDetailsResultObj) other);
        return new EqualsBuilder().append(totalResults, rhs.totalResults).append(sTBDetailList, rhs.sTBDetailList).append(error, rhs.error).isEquals();
    }

}
