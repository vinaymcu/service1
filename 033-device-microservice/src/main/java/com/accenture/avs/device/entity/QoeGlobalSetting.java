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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for QOE_GLOBAL_SETTINGS table.
 * 
 * @author rajesh.karna
 *
 */
@Entity
@Table(name = "GLOBAL_SETTINGS")
public class QoeGlobalSetting implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, precision = 9, scale = 0)
	private Long id;
	
	/** qoeRccEnableDefault */
	@Column(name = "QOE_RCC_ENABLE_DEFAULT", columnDefinition="TINYINT", length = 1)
	private Boolean qoeRccEnableDefault;

	/** qoeRetEnableDefault */
	@Column(name = "QOE_RET_ENABLE_DEFAULT", columnDefinition="TINYINT", length = 1)
	private Boolean qoeRetEnableDefault;

	/** allowRCCOverSubscription */
	@Column(name = "ALLOW_RCC_OVERSUBSCRIPTION", columnDefinition="TINYINT", length = 1)
	private Boolean allowRccOverSubscription;
	
	/**
	 * Gets id.
	 * 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id.
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets qoe RCC enable default.
	 * @return Boolean
	 */
	public Boolean getQoeRccEnableDefault() {
		return qoeRccEnableDefault;
	}

	/**
	 * Sets qoe RCC enable default.
	 * 
	 * @param qoeRccEnableDefault
	 */
	public void setQoeRccEnableDefault(Boolean qoeRccEnableDefault) {
		this.qoeRccEnableDefault = qoeRccEnableDefault;
	}

	/**
	 * Gets qoe RET enable default.
	 * 
	 * @return Boolean
	 */
	public Boolean getQoeRetEnableDefault() {
		return qoeRetEnableDefault;
	}

	/**
	 * Sets qoe RET enable default.
	 * 
	 * @param QoeRETEnableDefault
	 */
	public void setQoeRetEnableDefault(Boolean QoeRETEnableDefault) {
		this.qoeRetEnableDefault = QoeRETEnableDefault;
	}

	/**
	 * Gets allow RCC Over subscription.
	 * 
	 * @return Boolean
	 */
	public Boolean getAllowRccOverSubscription() {
		return allowRccOverSubscription;
	}

	/**
	 * Sets allow RCC Over subscription.
	 * 
	 * @param allowRCCOverSubscription
	 */
	public void setAllowRccOverSubscription(Boolean allowRCCOverSubscription) {
		this.allowRccOverSubscription = allowRCCOverSubscription;
	}
	
	
}
