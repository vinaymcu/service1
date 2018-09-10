
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
    "Name",
    "Status"
})
public class ConnectionMode implements Serializable
{

    @JsonProperty("Name")
    private ConnectionMode.Name name;
    @JsonProperty("Status")
    private ConnectionMode.Status status;

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("Name")
    public ConnectionMode.Name getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(ConnectionMode.Name name) {
        this.name = name;
    }

    public ConnectionMode withName(ConnectionMode.Name name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("Status")
    public ConnectionMode.Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The Status
     */
    @JsonProperty("Status")
    public void setStatus(ConnectionMode.Status status) {
        this.status = status;
    }

    public ConnectionMode withStatus(ConnectionMode.Status status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConnectionMode) == false) {
            return false;
        }
        ConnectionMode rhs = ((ConnectionMode) other);
        return new EqualsBuilder().append(name, rhs.name).append(status, rhs.status).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public enum Name {

        BRIDGED("Bridged"),
        IMPLICIT_NAT("Implicit NAT"),
        U_PN_P_NAPT("UPnP NAPT");
        private final String value;
        private final static Map<String, ConnectionMode.Name> CONSTANTS = new HashMap<String, ConnectionMode.Name>();

        static {
            for (ConnectionMode.Name c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Name(String value) {
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
        public static ConnectionMode.Name fromValue(String value) {
            ConnectionMode.Name constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public enum Status {

        ENABLED("Enabled"),
        DISABLED("Disabled");
        private final String value;
        private final static Map<String, ConnectionMode.Status> CONSTANTS = new HashMap<String, ConnectionMode.Status>();

        static {
            for (ConnectionMode.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Status(String value) {
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
        public static ConnectionMode.Status fromValue(String value) {
            ConnectionMode.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
