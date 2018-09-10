
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
    "FieldName",
    "Description",
    "EnumValues",
    "DefaultValue",
    "Rule"
})
public class UDFDefinition implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("FieldName")
    private String fieldName;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("EnumValues")
    private String enumValues;
    @JsonProperty("DefaultValue")
    private String defaultValue;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Rule")
    private Rule rule;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The fieldName
     */
    @JsonProperty("FieldName")
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 
     * (Required)
     * 
     * @param fieldName
     *     The FieldName
     */
    @JsonProperty("FieldName")
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public UDFDefinition withFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The Description
     */
    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public UDFDefinition withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The enumValues
     */
    @JsonProperty("EnumValues")
    public String getEnumValues() {
        return enumValues;
    }

    /**
     * 
     * @param enumValues
     *     The EnumValues
     */
    @JsonProperty("EnumValues")
    public void setEnumValues(String enumValues) {
        this.enumValues = enumValues;
    }

    public UDFDefinition withEnumValues(String enumValues) {
        this.enumValues = enumValues;
        return this;
    }

    /**
     * 
     * @return
     *     The defaultValue
     */
    @JsonProperty("DefaultValue")
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 
     * @param defaultValue
     *     The DefaultValue
     */
    @JsonProperty("DefaultValue")
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public UDFDefinition withDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The rule
     */
    @JsonProperty("Rule")
    public Rule getRule() {
        return rule;
    }

    /**
     * 
     * (Required)
     * 
     * @param rule
     *     The Rule
     */
    @JsonProperty("Rule")
    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public UDFDefinition withRule(Rule rule) {
        this.rule = rule;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fieldName).append(description).append(enumValues).append(defaultValue).append(rule).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UDFDefinition) == false) {
            return false;
        }
        UDFDefinition rhs = ((UDFDefinition) other);
        return new EqualsBuilder().append(fieldName, rhs.fieldName).append(description, rhs.description).append(enumValues, rhs.enumValues).append(defaultValue, rhs.defaultValue).append(rule, rhs.rule).isEquals();
    }

}
