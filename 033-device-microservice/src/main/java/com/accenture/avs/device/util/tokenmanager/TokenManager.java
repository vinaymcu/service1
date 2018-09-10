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

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;

import com.accenture.avs.device.config.ConfigurationProperties;
import com.accenture.avs.device.exception.TokenException;
import com.accenture.avs.device.util.SpringBeanUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
/**
 * @author surendra.kumar
 *
 */
public class TokenManager {
	
	/** configProperties */
	//ConfigurationProperties configProperties = SpringBeanUtils.getBean(ConfigurationProperties.class);

	/** keyMap */
	private static HashMap<String, SecretKey> keyMap = new HashMap<String, SecretKey>();
	
	/** PAYLOAD */
	private static final String PAYLOAD = "payload";
	
	
	/**
	 * Method copied from AESCryptoUtil
	 * 
	 * @param algorithmAES
	 * @param strToEncrypt
	 * @param secretKey
	 * @return
	 */
	/*public static String encrypt(String algorithmAES, String strToEncrypt, SecretKey secretKey) {
		try {
			Cipher cipher = Cipher.getInstance(algorithmAES);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			final String encryptedString = new String(Base64.encodeBase64(cipher.doFinal(strToEncrypt.getBytes())));
			return encryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/*private static String generateSignatureKey() {
		SecretKey signatureKey = null;
		try {
			signatureKey = KeyGenerator.getInstance(ALGORITHM).generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// get base64 encoded version of the key
		String encodedKey = java.util.Base64.getEncoder().encodeToString(signatureKey.getEncoded());
		return encodedKey;
	}*/

	private static SecretKey getKey(String key, String algorithm) {
		if (key != null && !key.trim().isEmpty()) {
			SecretKey secretKey = keyMap.get(key);
			if (secretKey == null) {
				byte[] keyBytes = new byte[16];
				java.math.BigInteger b = new java.math.BigInteger(key, 16);
				byte[] bigBytes = b.toByteArray();
				System.arraycopy(bigBytes, 0, keyBytes, 0, Math.min(keyBytes.length, bigBytes.length));
				secretKey = new SecretKeySpec(keyBytes, algorithm);
				keyMap.put(key, secretKey);
			}
			return secretKey;
		}
		return null;
	}

	/**
	 * 
	 * @param token
	 * @return
	 * @throws TokenException
	 */
	public static Token parseJWT(String token) throws TokenException {
		ConfigurationProperties configProperties = SpringBeanUtils.getBean(ConfigurationProperties.class);
		SecretKey secretKey = getKey(configProperties.getPayloadSecretKey(), configProperties.getAlgorithm());

		Token tokenBean = null;
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(configProperties.getSignatureKey()))
					.parseClaimsJws(token).getBody();

			if (claims != null) {
				String payloadEcripted = (String) claims.get(PAYLOAD);
				String payloadPlain = decrypt(configProperties.getAlgorithmEas(), payloadEcripted, secretKey);
				TokenPayload p;
				tokenBean = new Token();

				p = new ObjectMapper().readValue(payloadPlain, TokenPayload.class);

				tokenBean.setIss(claims.getIssuer());
				tokenBean.setPayload(p);
				tokenBean.setIat(claims.getIssuedAt().getTime());
				tokenBean.setExp(claims.getExpiration().getTime());
				tokenBean.setJti(claims.getId());
				tokenBean.setSub(claims.getSubject());

			}
		} catch(MalformedJwtException |UnsupportedJwtException |ExpiredJwtException | 
				SignatureException | IllegalArgumentException|IOException ioe) {
			throw new TokenException(ioe);
		}
		return tokenBean;

	}
	
	

	private static String decrypt(String algorithmAES, String strToDecrypt, SecretKey secretKey) throws TokenException {
		try {
			Cipher cipher = Cipher.getInstance(algorithmAES);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt.getBytes())));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException |InvalidKeyException |
				IllegalBlockSizeException | BadPaddingException  exception) {
			throw new TokenException(exception);
		}
	}

/*	public static boolean isExpired(Claims claims) {
		if (claims == null) {
			return true;
		}
		Date expiresOn = claims.getExpiration();
		if (expiresOn != null) {
			return new Date().getTime() > expiresOn.getTime();
		} else {
			return false;
		}
	}*/

}
