
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
    "SetTopBoxUDFs"
})
public class STBUDFValues implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SetTopBoxUDFs")
    private List<SetTopBoxUDF> setTopBoxUDFs = new ArrayList<SetTopBoxUDF>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The setTopBoxUDFs
     */
    @JsonProperty("SetTopBoxUDFs")
    public List<SetTopBoxUDF> getSetTopBoxUDFs() {
        return setTopBoxUDFs;
    }

    /**
     * 
     * (Required)
     * 
     * @param setTopBoxUDFs
     *     The SetTopBoxUDFs
     */
    @JsonProperty("SetTopBoxUDFs")
    public void setSetTopBoxUDFs(List<SetTopBoxUDF> setTopBoxUDFs) {
        this.setTopBoxUDFs = setTopBoxUDFs;
    }

    public STBUDFValues withSetTopBoxUDFs(List<SetTopBoxUDF> setTopBoxUDFs) {
        this.setTopBoxUDFs = setTopBoxUDFs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(setTopBoxUDFs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBUDFValues) == false) {
            return false;
        }
        STBUDFValues rhs = ((STBUDFValues) other);
        return new EqualsBuilder().append(setTopBoxUDFs, rhs.setTopBoxUDFs).isEquals();
    }

}
