
package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "totalResults",
    "deviceModelList"
})
public class DeviceModelResultObj implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalResults")
    private Integer totalResults;
    /**
     * List of device models
     * (Required)
     * 
     */
    @JsonProperty("deviceModelList")
    @JsonPropertyDescription("")
    private List<DeviceModelListDto> deviceModelList = new ArrayList<DeviceModelListDto>();
    private final static long serialVersionUID = 5027311313547776015L;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The totalResults
     */
    @JsonProperty("totalResults")
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * (Required)
     * 
     * @param totalResults
     *     The totalResults
     */
    @JsonProperty("totalResults")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * List of device models
     * (Required)
     * 
     * @return
     *     The deviceModelList
     */
    @JsonProperty("deviceModelList")
    public List<DeviceModelListDto> getDeviceModelList() {
        return deviceModelList;
    }

    /**
     * List of device models
     * (Required)
     * 
     * @param deviceModelList
     *     The deviceModelList
     */
    @JsonProperty("deviceModelList")
    public void setDeviceModelList(List<DeviceModelListDto> deviceModelList) {
        this.deviceModelList = deviceModelList;
    }

}
