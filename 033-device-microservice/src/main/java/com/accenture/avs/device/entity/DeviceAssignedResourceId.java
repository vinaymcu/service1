package com.accenture.avs.device.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Composite Primary Key for DEVICE_ASSIGNED_RESOURCES table
 * 
 * @author Singh.Saurabh
 *
 */
@Embeddable
public class DeviceAssignedResourceId implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -7196720957310951728L;

	/** equipmentId */
	@Column(name = "EQUIPMENT_ID", nullable = false, unique = false, precision = 9, scale = 0)
	private Long equipmentId;

	/** resourceId */
	@Column(name = "RESOURCE_ID", nullable = false, unique = false, precision = 9, scale = 0)
	private Long resourceId;

	/**
	 * Creates a new DeviceAssignedResourceId object.
	 * 
	 */
	public DeviceAssignedResourceId() {
	}

	/**
	 * Creates a new DeviceAssignedResourceId object
	 * 
	 * @param equipmentId
	 * @param resourceId
	 */
	public DeviceAssignedResourceId(Long equipmentId, Long resourceId) {
		this.equipmentId = equipmentId;
		this.resourceId = resourceId;
	}

	/**
	 * Gets equipmentId
	 * 
	 * @return Long
	 */
	public Long getEquipmentId() {
		return equipmentId;
	}

	/**
	 * Sets equipmentId
	 * 
	 * @param equipmentId
	 */
	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * Gets resourceId
	 * 
	 * @return Long
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * Sets resourceId
	 * 
	 * @param resourceId
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) equipmentId;
		hash += (long) resourceId;
		return hash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals()
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof DeviceAssignedResourceId)) {
			return false;
		}

		final DeviceAssignedResourceId other = (DeviceAssignedResourceId) obj;

		if (resourceId == null) {
			if (other.resourceId != null) {
				return false;
			}
		} else if (!resourceId.equals(other.resourceId)) {
			return false;
		}

		if (equipmentId == null) {
			if (other.equipmentId != null) {
				return false;
			}
		} else if (!equipmentId.equals(other.equipmentId)) {
			return false;
		}

		return true;
	}
}