
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
    "QoeRCCEnableDefault",
    "QoeRETEnableDefault",
    "AllowRCCOverSubscription"
})
public class GlobalQoESettings implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("QoeRCCEnableDefault")
    private Boolean qoeRCCEnableDefault;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("QoeRETEnableDefault")
    private Boolean qoeRETEnableDefault;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AllowRCCOverSubscription")
    private Boolean allowRCCOverSubscription;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The qoeRCCEnableDefault
     */
    @JsonProperty("QoeRCCEnableDefault")
    public Boolean getQoeRCCEnableDefault() {
        return qoeRCCEnableDefault;
    }

    /**
     * 
     * (Required)
     * 
     * @param qoeRCCEnableDefault
     *     The QoeRCCEnableDefault
     */
    @JsonProperty("QoeRCCEnableDefault")
    public void setQoeRCCEnableDefault(Boolean qoeRCCEnableDefault) {
        this.qoeRCCEnableDefault = qoeRCCEnableDefault;
    }

    public GlobalQoESettings withQoeRCCEnableDefault(Boolean qoeRCCEnableDefault) {
        this.qoeRCCEnableDefault = qoeRCCEnableDefault;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The qoeRETEnableDefault
     */
    @JsonProperty("QoeRETEnableDefault")
    public Boolean getQoeRETEnableDefault() {
        return qoeRETEnableDefault;
    }

    /**
     * 
     * (Required)
     * 
     * @param qoeRETEnableDefault
     *     The QoeRETEnableDefault
     */
    @JsonProperty("QoeRETEnableDefault")
    public void setQoeRETEnableDefault(Boolean qoeRETEnableDefault) {
        this.qoeRETEnableDefault = qoeRETEnableDefault;
    }

    public GlobalQoESettings withQoeRETEnableDefault(Boolean qoeRETEnableDefault) {
        this.qoeRETEnableDefault = qoeRETEnableDefault;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The allowRCCOverSubscription
     */
    @JsonProperty("AllowRCCOverSubscription")
    public Boolean getAllowRCCOverSubscription() {
        return allowRCCOverSubscription;
    }

    /**
     * 
     * (Required)
     * 
     * @param allowRCCOverSubscription
     *     The AllowRCCOverSubscription
     */
    @JsonProperty("AllowRCCOverSubscription")
    public void setAllowRCCOverSubscription(Boolean allowRCCOverSubscription) {
        this.allowRCCOverSubscription = allowRCCOverSubscription;
    }

    public GlobalQoESettings withAllowRCCOverSubscription(Boolean allowRCCOverSubscription) {
        this.allowRCCOverSubscription = allowRCCOverSubscription;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(qoeRCCEnableDefault).append(qoeRETEnableDefault).append(allowRCCOverSubscription).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GlobalQoESettings) == false) {
            return false;
        }
        GlobalQoESettings rhs = ((GlobalQoESettings) other);
        return new EqualsBuilder().append(qoeRCCEnableDefault, rhs.qoeRCCEnableDefault).append(qoeRETEnableDefault, rhs.qoeRETEnableDefault).append(allowRCCOverSubscription, rhs.allowRCCOverSubscription).isEquals();
    }

}
