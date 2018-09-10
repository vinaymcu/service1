
package com.accenture.avs.device.json.object.devicemanager;

import java.util.ArrayList;
import java.util.List;
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
    "totalResults",
    "Properties"
})
public class StbPropertiesResultObj {

    @JsonProperty("totalResults")
    private Integer totalResults;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Properties")
    private List<Property> properties = new ArrayList<Property>();

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

    public StbPropertiesResultObj withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The properties
     */
    @JsonProperty("Properties")
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * 
     * (Required)
     * 
     * @param properties
     *     The Properties
     */
    @JsonProperty("Properties")
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public StbPropertiesResultObj withProperties(List<Property> properties) {
        this.properties = properties;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalResults).append(properties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StbPropertiesResultObj) == false) {
            return false;
        }
        StbPropertiesResultObj rhs = ((StbPropertiesResultObj) other);
        return new EqualsBuilder().append(totalResults, rhs.totalResults).append(properties, rhs.properties).isEquals();
    }

}
