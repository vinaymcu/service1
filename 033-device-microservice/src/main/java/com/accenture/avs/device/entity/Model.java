/*******com.accenture.avs.device.entity******************************************
 * Copyright (C) Accenture
 *
 * The reproduction, transmission or use of this document or its contents is not permitted without
 * prior express written consent of Accenture. Offenders will be liable for damages. All rights,
 * including but not limited to rights created by patent grant or registration of a utility model or
 * design, are reserved.
 *
 * Accenture reserves the right to modify technical specifications and features.
 *
 * Technical specifications and features are binding only insofar as they are specifically and
 * expressly agreed upon in a written contract.
 *
 **************************************************************************/

package com.accenture.avs.device.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class for MODEL table.
 * 
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "MODEL")
public class Model implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** modelName */
	@Id
	@Column(name = "MODEL_NAME", length = 20)
	private String modelName;

	/** qoeCapable */
	@Column(name = "QOECAPABLE", columnDefinition = "TINYINT", length = 1)
	private Boolean qoeCapable;

	/** disableDeviceAutoRegistration */
	@Column(name = "DEVICEAUTOREGISTRATION", columnDefinition = "TINYINT", length = 1)
	private Boolean disableDeviceAutoRegistration;

	/** vendor */
	@Column(name = "VENDOR", length = 20)
	private String vendor;

	/** platform */
	@Column(name = "PLATFORM", length = 20)
	private String platform;

	/** osName */
	@Column(name = "OSNAME", length = 20)
	private String osName;

	/** osVersion */
	@Column(name = "OSVERSION", length = 20)
	private String osVersion;

	/** softwareVersion */ 
	@Column(name = "SOFTWARE_VERSION", length = 20)
	private String softwareVersion;

	/** uiVersion */
	@Column(name = "UIVERSION", length = 20)
	private String uiVersion;

	/** sdChannelTimeshiftBuffer */
	@Column(name = "SDCHANNELTIMESHIFTBUFFER", precision = 10, scale = 0)
	private Long sdChannelTimeshiftBuffer;

	/** hdChannelTimeshiftBuffer */
	@Column(name = "HDCHANNELTIMESHIFTBUFFER", precision = 10, scale = 0)
	private Long hdChannelTimeshiftBuffer;

	/** status */
	@Column(name = "STATUS", columnDefinition = "TINYINT", length = 1)
	private Boolean status;

	/** vqeProfile */
	@Column(name = "VQEPROFILE", length = 20)
	private String vqeProfile;

	/** tstvBufferSize */
	@Column(name = "TSTVBUFFERSIZE", precision = 10, scale = 0)
	private Long tstvBufferSize;

	/** hdCapable */
	@Column(name = "HDCAPABLE", columnDefinition = "TINYINT", length = 1)
	private Boolean hdCapable;

	/** lastUpdatedDatetime */
	@Column(name = "LAST_UPDATED_DATETIME", nullable = false, precision = 20, scale = 0)
	private Long lastUpdatedDatetime;

	/** lastUpdateUsername */ 
	@Column(name = "LAST_UPDATE_USERNAME", nullable = false, length = 30)
	private String lastUpdateUsername;

	/** lastUpdateInterface */
	@Column(name = "LAST_UPDATE_INTERFACE", nullable = false, length = 30)
	private String lastUpdateInterface;

	/** modelMaxStreamsAllowedPerQuality */
	@JoinColumn(name = "MODEL_NAME", referencedColumnName = "MODEL_NAME", updatable=false)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ModelMaxStreamsAllowedPerQuality> modelMaxStreamsAllowedPerQuality;
	
	/**
	 * Default Constructor
	 * 
	 */
	public Model() {
	}

	/**
	 * Constructor
	 * 
	 */
	public Model(String modelName) {
		this.modelName = modelName;
	}

	public Model(String modelName, Boolean qoeCapable, Boolean disableDeviceAutoRegistration,
			String vendor, String platform, String osName, String osVersion, String softwareVersion, String uiVersion,
			Long sdChannelTimeshiftBuffer, Long hdChannelTimeshiftBuffer, Boolean status, String vqeProfile,
			Long tstvBufferSize, Boolean hdCapable, Long lastUpdatedDatetime, String lastUpdateUsername,
			String lastUpdateInterface) {
		super();
		this.modelName = modelName;
		this.qoeCapable = qoeCapable;
		this.disableDeviceAutoRegistration = disableDeviceAutoRegistration;
		this.vendor = vendor;
		this.platform = platform;
		this.osName = osName;
		this.osVersion = osVersion;
		this.softwareVersion = softwareVersion;
		this.uiVersion = uiVersion;
		this.sdChannelTimeshiftBuffer = sdChannelTimeshiftBuffer;
		this.hdChannelTimeshiftBuffer = hdChannelTimeshiftBuffer;
		this.status = status;
		this.vqeProfile = vqeProfile;
		this.tstvBufferSize = tstvBufferSize;
		this.hdCapable = hdCapable;
		this.lastUpdatedDatetime = lastUpdatedDatetime;
		this.lastUpdateUsername = lastUpdateUsername;
		this.lastUpdateInterface = lastUpdateInterface;
	}

	/**
	 * Gets the name of model name.
	 * 
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Sets the name of model name.
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		if (modelName != null) {
			this.modelName = modelName;
		}
	}

	/**
	 * Sets qoeCapable of hardware version.
	 * 
	 * @return Boolean
	 */
	public Boolean getQoeCapable() {
		return qoeCapable;
	}

	/**
	 * Gets qoeCapable of hardware version.
	 * 
	 * @param qoeCapable
	 */
	public void setQoeCapable(Boolean qoeCapable) {
		if (qoeCapable != null) {
			this.qoeCapable = qoeCapable;
		}
	}

	/**
	 * Gets disbleStbAutoRegistration of hardware version.
	 * 
	 * @return Boolean
	 */
	public Boolean getDisableStbAutoRegistration() {
		return disableDeviceAutoRegistration;
	}

	/**
	 * Sets disableDeviceAutoRegistration of hardware version.
	 * 
	 * @param disableDeviceAutoRegistration
	 */
	public void setDisableDeviceAutoRegistration(Boolean disableDeviceAutoRegistration) {
		if (disableDeviceAutoRegistration != null) {
			this.disableDeviceAutoRegistration = disableDeviceAutoRegistration;
		}
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor
	 *            the vendor to set
	 */
	public void setVendor(String vendor) {
		if (vendor != null) {
			this.vendor = vendor;
		}
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		if (platform != null && "OTT".equals(platform)) {
			this.platform = platform;
		}else{
			this.platform = "IPTV";
		}
	}

	/**
	 * @return the osName
	 */
	public String getOsName() {
		return osName;
	}

	/**
	 * @param osName
	 *            the osName to set
	 */
	public void setOsName(String osName) {
		if (osName != null && !osName.isEmpty()) {
			this.osName = osName;
		}
	}

	/**
	 * @return the osVersion
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * @param osVersion
	 *            the osVersion to set
	 */
	public void setOsVersion(String osVersion) {
		if (osVersion != null && !osVersion.isEmpty()) {
			this.osVersion = osVersion;
		}
	}

	/**
	 * @return the softwareVersion
	 */
	public String getSoftwareVersion() {
		return softwareVersion;
	}

	/**
	 * @param softwareVersion
	 *            the softwareVersion to set
	 */
	public void setSoftwareVersion(String softwareVersion) {
		if (softwareVersion != null) {
			this.softwareVersion = softwareVersion;
		}
	}

	/**
	 * @return the uiVersion
	 */
	public String getUiVersion() {
		return uiVersion;
	}

	/**
	 * @param uiVersion
	 *            the uiVersion to set
	 */
	public void setUiVersion(String uiVersion) {
		if (uiVersion != null) {
			this.uiVersion = uiVersion;
		}
	}

	/**
	 * @return the sdChannelTimeshiftBuffer
	 */
	public Long getSdChannelTimeshiftBuffer() {
		return sdChannelTimeshiftBuffer;
	}

	/**
	 * @param sdChannelTimeshiftBuffer
	 *            the sdChannelTimeshiftBuffer to set
	 */
	public void setSdChannelTimeshiftBuffer(Long sdChannelTimeshiftBuffer) {
		if (sdChannelTimeshiftBuffer != null) {
			this.sdChannelTimeshiftBuffer = sdChannelTimeshiftBuffer;
		}
	}

	/**
	 * @return the hdChannelTimeshiftBuffer
	 */
	public Long getHdChannelTimeshiftBuffer() {
		return hdChannelTimeshiftBuffer;
	}

	/**
	 * @param hdChannelTimeshiftBuffer
	 *            the hdChannelTimeshiftBuffer to set
	 */
	public void setHdChannelTimeshiftBuffer(Long hdChannelTimeshiftBuffer) {
		if (hdChannelTimeshiftBuffer != null) {
			this.hdChannelTimeshiftBuffer = hdChannelTimeshiftBuffer;
		}
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Boolean status) {
		if (status != null) {
			this.status = status;
		}
	}

	/**
	 * @return the vqeProfile
	 */
	public String getVqeProfile() {
		return vqeProfile;
	}

	/**
	 * @param vqeProfile
	 *            the vqeProfile to set
	 */
	public void setVqeProfile(String vqeProfile) {
		if (vqeProfile != null) {
			this.vqeProfile = vqeProfile;
		}
	}

	/**
	 * @return the tstvBufferSize
	 */
	public Long getTstvBufferSize() {
		return tstvBufferSize;
	}

	/**
	 * @param tstvBufferSize
	 *            the tstvBufferSize to set
	 */
	public void setTstvBufferSize(Long tstvBufferSize) {
		if (tstvBufferSize != null) {
			this.tstvBufferSize = tstvBufferSize;
		}
	}

	/**
	 * @return the hdCapable
	 */
	public Boolean getHdCapable() {
		return hdCapable;
	}

	/**
	 * @param hdCapable
	 *            the hdCapable to set
	 */
	public void setHdCapable(Boolean hdCapable) {
		if (hdCapable != null) {
			this.hdCapable = hdCapable;
		}
	}

	/**
	 * @return the lastUpdatedDatetime
	 */
	public Long getLastUpdatedDatetime() {
		return lastUpdatedDatetime;
	}

	/**
	 * @param lastUpdatedDatetime
	 *            the lastUpdatedDatetime to set
	 */
	public void setLastUpdatedDatetime(Long lastUpdatedDatetime) {
		if (lastUpdatedDatetime != null) {
			this.lastUpdatedDatetime = lastUpdatedDatetime;
		}
	}

	/**
	 * @return the lastUpdateUsername
	 */
	public String getLastUpdateUsername() {
		return lastUpdateUsername;
	}

	/**
	 * @param lastUpdateUsername
	 *            the lastUpdateUsername to set
	 */
	public void setLastUpdateUsername(String lastUpdateUsername) {
		if (lastUpdateUsername != null) {
			this.lastUpdateUsername = lastUpdateUsername;
		}
	}

	/**
	 * @return the disableDeviceAutoRegistration
	 */
	public Boolean getDisableDeviceAutoRegistration() {
		return disableDeviceAutoRegistration;
	}

	/**
	 * @return the lastUpdateInterface
	 */
	public String getLastUpdateInterface() {
		return lastUpdateInterface;
	}

	/**
	 * @param lastUpdateInterface
	 *            the lastUpdateInterface to set
	 */
	public void setLastUpdateInterface(String lastUpdateInterface) {
		if (lastUpdateInterface != null) {
			this.lastUpdateInterface = lastUpdateInterface;
		}
	}

	/**
	 * @return the modelMaxStreamsAllowedPerQuality
	 */
	public List<ModelMaxStreamsAllowedPerQuality> getModelMaxStreamsAllowedPerQuality() {
		return modelMaxStreamsAllowedPerQuality;
	}

	/**
	 * @param modelMaxStreamsAllowedPerQuality the modelMaxStreamsAllowedPerQuality to set
	 */
	public void setModelMaxStreamsAllowedPerQuality(
			List<ModelMaxStreamsAllowedPerQuality> modelMaxStreamsAllowedPerQuality) {
		this.modelMaxStreamsAllowedPerQuality = modelMaxStreamsAllowedPerQuality;
	}

	/**
	 * Override hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (modelName != null ? modelName.hashCode() : 0);
		return hash;
	}

	/**
	 * Override equals()
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Model)) {
			return false;
		}

		final Model other = (Model) obj;

		if (modelName == null) {
			if (other.modelName != null) {
				return false;
			}
		} else if (!modelName.equals(other.modelName)) {
			return false;
		}
		return true;
	}
}
