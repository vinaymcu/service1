
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
    "STBRegistration"
})
public class AutoConfig implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBRegistration")
    private STBRegistration sTBRegistration;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBRegistration
     */
    @JsonProperty("STBRegistration")
    public STBRegistration getSTBRegistration() {
        return sTBRegistration;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBRegistration
     *     The STBRegistration
     */
    @JsonProperty("STBRegistration")
    public void setSTBRegistration(STBRegistration sTBRegistration) {
        this.sTBRegistration = sTBRegistration;
    }

    public AutoConfig withSTBRegistration(STBRegistration sTBRegistration) {
        this.sTBRegistration = sTBRegistration;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sTBRegistration).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AutoConfig) == false) {
            return false;
        }
        AutoConfig rhs = ((AutoConfig) other);
        return new EqualsBuilder().append(sTBRegistration, rhs.sTBRegistration).isEquals();
    }

}
