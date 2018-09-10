package com.accenture.avs.device.json.object.devicemanager;

import java.io.Serializable;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "device" })
public class CreateDeviceRequest implements Serializable {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("device")
	private DeviceDto device;

	/**
	 * 
	 * (Required)
	 * 
	 * @return The device
	 */
	@JsonProperty("device")
	public DeviceDto getDevice() {
		return device;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param device
	 *            The device
	 */
	@JsonProperty("device")
	public void setDevice(DeviceDto device) {
		this.device = device;
	}

	public CreateDeviceRequest withDevice(DeviceDto device) {
		this.device = device;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(device).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof CreateDeviceRequest) == false) {
			return false;
		}
		CreateDeviceRequest rhs = ((CreateDeviceRequest) other);
		return new EqualsBuilder().append(device, rhs.device).isEquals();
	}

}
