package com.accenture.avs.device.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Composite Primary Key for RESOURCES table
 * 
 * @author Singh.Saurabh
 *
 */
@Embeddable
public class ResourceId implements java.io.Serializable {

	private static final long serialVersionUID = -7924362793072799690L;

	/** id */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "RESOURCE_ID", nullable = false, unique = false, precision = 9, scale = 0)
	private Long id;

	/** name */
	@Column(name = "NAME", nullable = false, unique = false, length = 20)
	private String name;

	/**
	 * Creates a new ResourceId object.
	 * 
	 */
	public ResourceId() {
	}

	/**
	 * Creates a new ResourceId object
	 * 
	 * @param id
	 * @param name
	 */
	public ResourceId(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Gets Id
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets Id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) id;
		hash += (name != null ? name.hashCode() : 0);
		return hash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals()
	 */
	@Override
	public boolean equals(Object object) {

		if (object == null) {
			return false;
		}

		if (!(object instanceof ResourceId)) {
			return false;
		}

		final ResourceId other = (ResourceId) object;

		if (name == null) {

			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		if (id == null) {

			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}

		return true;
	}
	
}
