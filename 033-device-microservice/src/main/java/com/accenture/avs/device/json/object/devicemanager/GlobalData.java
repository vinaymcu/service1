
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
    "Languages",
    "Locations",
    "ConnectionModes",
    "DefaultPortMappings",
    "GlobalQoESettings",
    "HWVersion"
})
public class GlobalData implements Serializable
{

    @JsonProperty("Languages")
    private List<Language> languages = new ArrayList<Language>();
    @JsonProperty("Locations")
    private List<Location> locations = new ArrayList<Location>();
    @JsonProperty("ConnectionModes")
    private List<ConnectionMode> connectionModes = new ArrayList<ConnectionMode>();
    @JsonProperty("DefaultPortMappings")
    private List<DefaultPortMapping> defaultPortMappings = new ArrayList<DefaultPortMapping>();
    /**
     * 
     */
    @JsonProperty("GlobalQoESettings")
    private GlobalQoESettings globalQoESettings;
    @JsonProperty("HWVersion")
    private List<HWVersion> hWVersion = new ArrayList<HWVersion>();

    /**
     * 
     * @return
     *     The languages
     */
    @JsonProperty("Languages")
    public List<Language> getLanguages() {
        return languages;
    }

    /**
     * 
     * @param languages
     *     The Languages
     */
    @JsonProperty("Languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public GlobalData withLanguages(List<Language> languages) {
        this.languages = languages;
        return this;
    }

    /**
     * 
     * @return
     *     The locations
     */
    @JsonProperty("Locations")
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *     The Locations
     */
    @JsonProperty("Locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public GlobalData withLocations(List<Location> locations) {
        this.locations = locations;
        return this;
    }

    /**
     * 
     * @return
     *     The connectionModes
     */
    @JsonProperty("ConnectionModes")
    public List<ConnectionMode> getConnectionModes() {
        return connectionModes;
    }

    /**
     * 
     * @param connectionModes
     *     The ConnectionModes
     */
    @JsonProperty("ConnectionModes")
    public void setConnectionModes(List<ConnectionMode> connectionModes) {
        this.connectionModes = connectionModes;
    }

    public GlobalData withConnectionModes(List<ConnectionMode> connectionModes) {
        this.connectionModes = connectionModes;
        return this;
    }

    /**
     * 
     * @return
     *     The defaultPortMappings
     */
    @JsonProperty("DefaultPortMappings")
    public List<DefaultPortMapping> getDefaultPortMappings() {
        return defaultPortMappings;
    }

    /**
     * 
     * @param defaultPortMappings
     *     The DefaultPortMappings
     */
    @JsonProperty("DefaultPortMappings")
    public void setDefaultPortMappings(List<DefaultPortMapping> defaultPortMappings) {
        this.defaultPortMappings = defaultPortMappings;
    }

    public GlobalData withDefaultPortMappings(List<DefaultPortMapping> defaultPortMappings) {
        this.defaultPortMappings = defaultPortMappings;
        return this;
    }

    /**
     * 
     * @return
     *     The globalQoESettings
     */
    @JsonProperty("GlobalQoESettings")
    public GlobalQoESettings getGlobalQoESettings() {
        return globalQoESettings;
    }

    /**
     * 
     * @param globalQoESettings
     *     The GlobalQoESettings
     */
    @JsonProperty("GlobalQoESettings")
    public void setGlobalQoESettings(GlobalQoESettings globalQoESettings) {
        this.globalQoESettings = globalQoESettings;
    }

    public GlobalData withGlobalQoESettings(GlobalQoESettings globalQoESettings) {
        this.globalQoESettings = globalQoESettings;
        return this;
    }

    /**
     * 
     * @return
     *     The hWVersion
     */
    @JsonProperty("HWVersion")
    public List<HWVersion> getHWVersion() {
        return hWVersion;
    }

    /**
     * 
     * @param hWVersion
     *     The HWVersion
     */
    @JsonProperty("HWVersion")
    public void setHWVersion(List<HWVersion> hWVersion) {
        this.hWVersion = hWVersion;
    }

    public GlobalData withHWVersion(List<HWVersion> hWVersion) {
        this.hWVersion = hWVersion;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(languages).append(locations).append(connectionModes).append(defaultPortMappings).append(globalQoESettings).append(hWVersion).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GlobalData) == false) {
            return false;
        }
        GlobalData rhs = ((GlobalData) other);
        return new EqualsBuilder().append(languages, rhs.languages).append(locations, rhs.locations).append(connectionModes, rhs.connectionModes).append(defaultPortMappings, rhs.defaultPortMappings).append(globalQoESettings, rhs.globalQoESettings).append(hWVersion, rhs.hWVersion).isEquals();
    }

}
