
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
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
    "Required",
    "Length",
    "Numeric",
    "Format",
    "Unique"
})
public class Rule implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Required")
    private Boolean required;
    @JsonProperty("Length")
    private Integer length;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Numeric")
    private Boolean numeric;
    @JsonProperty("Format")
    private String format;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Unique")
    private Boolean unique;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The required
     */
    @JsonProperty("Required")
    public Boolean getRequired() {
        return required;
    }

    /**
     * 
     * (Required)
     * 
     * @param required
     *     The Required
     */
    @JsonProperty("Required")
    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Rule withRequired(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * 
     * @return
     *     The length
     */
    @JsonProperty("Length")
    public Integer getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The Length
     */
    @JsonProperty("Length")
    public void setLength(Integer length) {
        this.length = length;
    }

    public Rule withLength(Integer length) {
        this.length = length;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The numeric
     */
    @JsonProperty("Numeric")
    public Boolean getNumeric() {
        return numeric;
    }

    /**
     * 
     * (Required)
     * 
     * @param numeric
     *     The Numeric
     */
    @JsonProperty("Numeric")
    public void setNumeric(Boolean numeric) {
        this.numeric = numeric;
    }

    public Rule withNumeric(Boolean numeric) {
        this.numeric = numeric;
        return this;
    }

    /**
     * 
     * @return
     *     The format
     */
    @JsonProperty("Format")
    public String getFormat() {
        return format;
    }

    /**
     * 
     * @param format
     *     The Format
     */
    @JsonProperty("Format")
    public void setFormat(String format) {
        this.format = format;
    }

    public Rule withFormat(String format) {
        this.format = format;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The unique
     */
    @JsonProperty("Unique")
    public Boolean getUnique() {
        return unique;
    }

    /**
     * 
     * (Required)
     * 
     * @param unique
     *     The Unique
     */
    @JsonProperty("Unique")
    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Rule withUnique(Boolean unique) {
        this.unique = unique;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(required).append(length).append(numeric).append(format).append(unique).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rule) == false) {
            return false;
        }
        Rule rhs = ((Rule) other);
        return new EqualsBuilder().append(required, rhs.required).append(length, rhs.length).append(numeric, rhs.numeric).append(format, rhs.format).append(unique, rhs.unique).isEquals();
    }

}
