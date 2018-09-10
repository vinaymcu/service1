
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
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
    "STBUpdateLogs"
})
public class SetTopBoxAuditLogs implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("STBUpdateLogs")
    private List<STBUpdateLog> sTBUpdateLogs = new ArrayList<STBUpdateLog>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sTBUpdateLogs
     */
    @JsonProperty("STBUpdateLogs")
    public List<STBUpdateLog> getSTBUpdateLogs() {
        return sTBUpdateLogs;
    }

    /**
     * 
     * (Required)
     * 
     * @param sTBUpdateLogs
     *     The STBUpdateLogs
     */
    @JsonProperty("STBUpdateLogs")
    public void setSTBUpdateLogs(List<STBUpdateLog> sTBUpdateLogs) {
        this.sTBUpdateLogs = sTBUpdateLogs;
    }

    public SetTopBoxAuditLogs withSTBUpdateLogs(List<STBUpdateLog> sTBUpdateLogs) {
        this.sTBUpdateLogs = sTBUpdateLogs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sTBUpdateLogs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetTopBoxAuditLogs) == false) {
            return false;
        }
        SetTopBoxAuditLogs rhs = ((SetTopBoxAuditLogs) other);
        return new EqualsBuilder().append(sTBUpdateLogs, rhs.sTBUpdateLogs).isEquals();
    }

}
