
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
    "DeleteUDFs"
})
public class UDFDelete implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DeleteUDFs")
    private List<String> deleteUDFs = new ArrayList<String>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The deleteUDFs
     */
    @JsonProperty("DeleteUDFs")
    public List<String> getDeleteUDFs() {
        return deleteUDFs;
    }

    /**
     * 
     * (Required)
     * 
     * @param deleteUDFs
     *     The DeleteUDFs
     */
    @JsonProperty("DeleteUDFs")
    public void setDeleteUDFs(List<String> deleteUDFs) {
        this.deleteUDFs = deleteUDFs;
    }

    public UDFDelete withDeleteUDFs(List<String> deleteUDFs) {
        this.deleteUDFs = deleteUDFs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deleteUDFs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UDFDelete) == false) {
            return false;
        }
        UDFDelete rhs = ((UDFDelete) other);
        return new EqualsBuilder().append(deleteUDFs, rhs.deleteUDFs).isEquals();
    }

}
