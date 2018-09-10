
package com.accenture.avs.device.json.object.swupgradecount;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "swVersion",
    "upgradeCount"
})
public class ResultObj implements Serializable
{

    /**
     * Software version
     * (Required)
     * 
     */
    @JsonProperty("swVersion")
    @JsonPropertyDescription("")
    private String swVersion;
    /**
     * Number of Devices upgraded to the SW
     * (Required)
     * 
     */
    @JsonProperty("upgradeCount")
    @JsonPropertyDescription("")
    private Integer upgradeCount;
    private final static long serialVersionUID = 5735230961483295451L;

    /**
     * Software version
     * (Required)
     * 
     * @return
     *     The swVersion
     */
    @JsonProperty("swVersion")
    public String getSwVersion() {
        return swVersion;
    }

    /**
     * Software version
     * (Required)
     * 
     * @param swVersion
     *     The swVersion
     */
    @JsonProperty("swVersion")
    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

    /**
     * Number of Devices upgraded to the SW
     * (Required)
     * 
     * @return
     *     The upgradeCount
     */
    @JsonProperty("upgradeCount")
    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    /**
     * Number of Devices upgraded to the SW
     * (Required)
     * 
     * @param upgradeCount
     *     The upgradeCount
     */
    @JsonProperty("upgradeCount")
    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

}
