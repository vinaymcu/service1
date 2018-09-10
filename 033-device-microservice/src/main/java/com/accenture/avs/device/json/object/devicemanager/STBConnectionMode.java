
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
    "ConnectionMode"
})
public class STBConnectionMode implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ConnectionMode")
    private STBConnectionMode.ConnectionMode connectionMode;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The connectionMode
     */
    @JsonProperty("ConnectionMode")
    public STBConnectionMode.ConnectionMode getConnectionMode() {
        return connectionMode;
    }

    /**
     * 
     * (Required)
     * 
     * @param connectionMode
     *     The ConnectionMode
     */
    @JsonProperty("ConnectionMode")
    public void setConnectionMode(STBConnectionMode.ConnectionMode connectionMode) {
        this.connectionMode = connectionMode;
    }

    public STBConnectionMode withConnectionMode(STBConnectionMode.ConnectionMode connectionMode) {
        this.connectionMode = connectionMode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(connectionMode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBConnectionMode) == false) {
            return false;
        }
        STBConnectionMode rhs = ((STBConnectionMode) other);
        return new EqualsBuilder().append(connectionMode, rhs.connectionMode).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public enum ConnectionMode {

        BRIDGED("Bridged"),
        IMPLICIT_NAT("Implicit NAT"),
        U_PN_P_NAPT("UPnP NAPT");
        private final String value;
        private final static Map<String, STBConnectionMode.ConnectionMode> CONSTANTS = new HashMap<String, STBConnectionMode.ConnectionMode>();

        static {
            for (STBConnectionMode.ConnectionMode c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ConnectionMode(String value) {
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
        public static STBConnectionMode.ConnectionMode fromValue(String value) {
            STBConnectionMode.ConnectionMode constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
