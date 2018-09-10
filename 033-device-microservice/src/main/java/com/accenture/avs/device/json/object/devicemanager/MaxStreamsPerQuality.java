
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "contentQuality",
    "streamLimit"
})
public class MaxStreamsPerQuality implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contentQuality")
    private String contentQuality;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("streamLimit")
    private Integer streamLimit;
    private final static long serialVersionUID = -2911717582983086143L;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The contentQuality
     */
    @JsonProperty("contentQuality")
    public String getContentQuality() {
        return contentQuality;
    }

    /**
     * 
     * (Required)
     * 
     * @param contentQuality
     *     The contentQuality
     */
    @JsonProperty("contentQuality")
    public void setContentQuality(String contentQuality) {
        this.contentQuality = contentQuality;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The streamLimit
     */
    @JsonProperty("streamLimit")
    public Integer getStreamLimit() {
        return streamLimit;
    }

    /**
     * 
     * (Required)
     * 
     * @param streamLimit
     *     The streamLimit
     */
    @JsonProperty("streamLimit")
    public void setStreamLimit(Integer streamLimit) {
        this.streamLimit = streamLimit;
    }

}
