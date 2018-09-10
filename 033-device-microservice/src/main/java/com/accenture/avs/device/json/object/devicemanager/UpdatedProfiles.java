
package com.accenture.avs.device.json.object.devicemanager;

import java.util.ArrayList;
import java.util.List;
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
    "totalResults",
    "UpdatedAccounts"
})
public class UpdatedProfiles {

    @JsonProperty("totalResults")
    private Integer totalResults;
    /**
     * List of subscribers updated within a time frame
     * 
     */
    @JsonProperty("UpdatedAccounts")
    @JsonPropertyDescription("")
    private List<UpdatedAccount> updatedAccounts = new ArrayList<UpdatedAccount>();

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

    public UpdatedProfiles withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    /**
     * List of subscribers updated within a time frame
     * 
     * @return
     *     The updatedAccounts
     */
    @JsonProperty("UpdatedAccounts")
    public List<UpdatedAccount> getUpdatedAccounts() {
        return updatedAccounts;
    }

    /**
     * List of subscribers updated within a time frame
     * 
     * @param updatedAccounts
     *     The UpdatedAccounts
     */
    @JsonProperty("UpdatedAccounts")
    public void setUpdatedAccounts(List<UpdatedAccount> updatedAccounts) {
        this.updatedAccounts = updatedAccounts;
    }

    public UpdatedProfiles withUpdatedAccounts(List<UpdatedAccount> updatedAccounts) {
        this.updatedAccounts = updatedAccounts;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalResults).append(updatedAccounts).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdatedProfiles) == false) {
            return false;
        }
        UpdatedProfiles rhs = ((UpdatedProfiles) other);
        return new EqualsBuilder().append(totalResults, rhs.totalResults).append(updatedAccounts, rhs.updatedAccounts).isEquals();
    }

}
