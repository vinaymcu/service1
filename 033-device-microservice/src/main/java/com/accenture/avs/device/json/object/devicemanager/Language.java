
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
    "Type",
    "Display Name",
    "AvailableForUI",
    "AvailableForAudio"
})
public class Language implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Type")
    private String type;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Display Name")
    private String displayName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AvailableForUI")
    private Boolean availableForUI;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AvailableForAudio")
    private Boolean availableForAudio;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The type
     */
    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     * @param type
     *     The Type
     */
    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    public Language withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The displayName
     */
    @JsonProperty("Display Name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * (Required)
     * 
     * @param displayName
     *     The Display Name
     */
    @JsonProperty("Display Name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Language withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The availableForUI
     */
    @JsonProperty("AvailableForUI")
    public Boolean getAvailableForUI() {
        return availableForUI;
    }

    /**
     * 
     * (Required)
     * 
     * @param availableForUI
     *     The AvailableForUI
     */
    @JsonProperty("AvailableForUI")
    public void setAvailableForUI(Boolean availableForUI) {
        this.availableForUI = availableForUI;
    }

    public Language withAvailableForUI(Boolean availableForUI) {
        this.availableForUI = availableForUI;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The availableForAudio
     */
    @JsonProperty("AvailableForAudio")
    public Boolean getAvailableForAudio() {
        return availableForAudio;
    }

    /**
     * 
     * (Required)
     * 
     * @param availableForAudio
     *     The AvailableForAudio
     */
    @JsonProperty("AvailableForAudio")
    public void setAvailableForAudio(Boolean availableForAudio) {
        this.availableForAudio = availableForAudio;
    }

    public Language withAvailableForAudio(Boolean availableForAudio) {
        this.availableForAudio = availableForAudio;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(displayName).append(availableForUI).append(availableForAudio).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Language) == false) {
            return false;
        }
        Language rhs = ((Language) other);
        return new EqualsBuilder().append(type, rhs.type).append(displayName, rhs.displayName).append(availableForUI, rhs.availableForUI).append(availableForAudio, rhs.availableForAudio).isEquals();
    }

}
