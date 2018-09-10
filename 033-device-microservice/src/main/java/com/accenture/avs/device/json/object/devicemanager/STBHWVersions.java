
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
    "AllHardwares",
    "STBHWVersion"
})
public class STBHWVersions implements Serializable
{

    @JsonProperty("AllHardwares")
    private Boolean allHardwares;
    @JsonProperty("STBHWVersion")
    private List<String> sTBHWVersion = new ArrayList<String>();

    /**
     * 
     * @return
     *     The allHardwares
     */
    @JsonProperty("AllHardwares")
    public Boolean getAllHardwares() {
        return allHardwares;
    }

    /**
     * 
     * @param allHardwares
     *     The AllHardwares
     */
    @JsonProperty("AllHardwares")
    public void setAllHardwares(Boolean allHardwares) {
        this.allHardwares = allHardwares;
    }

    public STBHWVersions withAllHardwares(Boolean allHardwares) {
        this.allHardwares = allHardwares;
        return this;
    }

    /**
     * 
     * @return
     *     The sTBHWVersion
     */
    @JsonProperty("STBHWVersion")
    public List<String> getSTBHWVersion() {
        return sTBHWVersion;
    }

    /**
     * 
     * @param sTBHWVersion
     *     The STBHWVersion
     */
    @JsonProperty("STBHWVersion")
    public void setSTBHWVersion(List<String> sTBHWVersion) {
        this.sTBHWVersion = sTBHWVersion;
    }

    public STBHWVersions withSTBHWVersion(List<String> sTBHWVersion) {
        this.sTBHWVersion = sTBHWVersion;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(allHardwares).append(sTBHWVersion).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof STBHWVersions) == false) {
            return false;
        }
        STBHWVersions rhs = ((STBHWVersions) other);
        return new EqualsBuilder().append(allHardwares, rhs.allHardwares).append(sTBHWVersion, rhs.sTBHWVersion).isEquals();
    }

}
