package com.accenture.avs.device.json.object.devicemanager;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "device" })
public class DeviceDetailsResultObject {

	/**
	 * 
	 */
	@JsonProperty("device")
	private DeviceDto device;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The device
	 */
	@JsonProperty("device")
	public DeviceDto getDevice() {
		return device;
	}

	/**
	 * 
	 * @param device
	 *            The device
	 */
	@JsonProperty("device")
	public void setDevice(DeviceDto device) {
		this.device = device;
	}

	public DeviceDetailsResultObject withDevice(DeviceDto device) {
		this.device = device;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public DeviceDetailsResultObject withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(device).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DeviceDetailsResultObject) == false) {
			return false;
		}
		DeviceDetailsResultObject rhs = ((DeviceDetailsResultObject) other);
		return new EqualsBuilder().append(device, rhs.device).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}
