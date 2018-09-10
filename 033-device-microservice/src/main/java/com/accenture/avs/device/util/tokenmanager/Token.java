/***************************************************************************
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
package com.accenture.avs.device.util.tokenmanager;

/**
 * @author surendra.kumar
 *
 */
public class Token {
	private TokenPayload payload;
	/** Id */
	private String jti;
	/** Issue at */
	private Long iat;
	/** Subject */
	private String sub;
	/** Issuer */
	private String iss;
	/** Expiry */
	private Long exp;

	/**
	 * @return the payload
	 */
	public TokenPayload getPayload() {
		return payload;
	}
	/**
	 * @param payload the payload to set
	 */
	public void setPayload(TokenPayload payload) {
		this.payload = payload;
	}


	
	/**
	 * @return the jti
	 */
	public String getJti() {
		return jti;
	}
	/**
	 * @param jti the jti to set
	 */
	public void setJti(String jti) {
		this.jti = jti;
	}
	/**
	 * @return the iat
	 */
	public Long getIat() {
		return iat;
	}
	/**
	 * @param iat the iat to set
	 */
	public void setIat(Long iat) {
		this.iat = iat;
	}
	/**
	 * @return the sub
	 */
	public String getSub() {
		return sub;
	}
	/**
	 * @param sub the sub to set
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}
	/**
	 * @return the iss
	 */
	public String getIss() {
		return iss;
	}
	/**
	 * @param iss the iss to set
	 */
	public void setIss(String iss) {
		this.iss = iss;
	}
	/**
	 * @return the exp
	 */
	public Long getExp() {
		return exp;
	}
	/**
	 * @param exp the exp to set
	 */
	public void setExp(Long exp) {
		this.exp = exp;
	}
	   

	
}
