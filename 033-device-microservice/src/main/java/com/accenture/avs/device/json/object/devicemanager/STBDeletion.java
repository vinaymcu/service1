
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "IdType",
    "Value"
})
public class STBDeletion implements Serializable
{

    @JsonProperty("IdType")
    private STBDeletion.IdType idType;
    @JsonProperty("Value")
    private String value;

    /**
     * 
     * @return
     *     The idType
     */
    @JsonProperty("IdType")
    public STBDeletion.IdType getIdType() {
        return idType;
    }

    /**
     * 
     * @param idType
     *     The IdType
     */
    @JsonProperty("IdType")
    public void setIdType(STBDeletion.IdType idType) {
        this.idType = idType;
    }

    public STBDeletion withIdType(STBDeletion.IdType idType) {
        this.idType = idType;
        return this;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The Value
     */
    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    public STBDeletion withValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idType).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBDeletion) == false) {
            return false;
        }
        STBDeletion rhs = ((STBDeletion) other);
        return new EqualsBuilder().append(idType, rhs.idType).append(value, rhs.value).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public enum IdType {

        MAC_ADDRESS("MACAddress"),
        EQUIPMENT_ID("EquipmentId"),
        EXT_IP_ADDRESS("ExtIPAddress");
        private final String value;
        private final static Map<String, STBDeletion.IdType> CONSTANTS = new HashMap<String, STBDeletion.IdType>();

        static {
            for (STBDeletion.IdType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private IdType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static STBDeletion.IdType fromValue(String value) {
            STBDeletion.IdType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
