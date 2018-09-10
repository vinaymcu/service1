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

package com.accenture.avs.device.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.util.Constants;

/**
 * Logger Interceptor class for adding common logging params to logger
 * ThreadContext {@link ThreadContext}.
 * 
 * @author Sumit.Sharma
 *
 */

@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(LoggingInterceptor.class);

	/** The application name. */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
	 * preHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Value("${spring.application.name}")
	private String applicationName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
	 * preHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ThreadContext.put(Constants.LoggingParams.APP_ID, applicationName);
		ThreadContext.put(Constants.LoggingParams.API_TYPE, Constants.ApiType.B2B);
		String user = request.getHeader(Constants.LoggingParams.X_AVS_USER_NAME);
		if (StringUtils.isBlank(user)) {			
			ThreadContext.put(Constants.LoggingParams.USER, Constants.DEFAULT_USER_NAME);
		} else {
			ThreadContext.put(Constants.LoggingParams.USER, user);
		}
		String platform = request.getParameter("channel");
		if (null != platform) {
			ThreadContext.put(Constants.LoggingParams.PLATFORM, platform);
		} else {
			ThreadContext.put(Constants.LoggingParams.PLATFORM, "");
		}
		String transactionId = request.getHeader(Constants.LoggingParams.X_AVS_TRANSACTION_ID);
		if (null != transactionId) {
			ThreadContext.put(Constants.LoggingParams.TN, transactionId);
		} else {
			ThreadContext.put(Constants.LoggingParams.TN, UUID.randomUUID().toString());
		}
		String sessionId = request.getHeader(Constants.LoggingParams.X_AVS_SESSION_ID);
		if (null != sessionId) {
			ThreadContext.put(Constants.LoggingParams.SID, sessionId);
		} else {
			ThreadContext.put(Constants.LoggingParams.SID, "");
		}
		ThreadContext.put(Constants.LoggingParams.API, request.getRequestURI());
		ThreadContext.put(Constants.LoggingParams.CLIENT_IP, getIp(request));
		
		return true;
	}

	/**
	 * Method to get client IP from request or x-forward-for header
	 * 
	 * @param request
	 * 
	 * @return String client IP
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = getIpFromHeaderWrapped(request);
		if (StringUtils.isEmpty(ip)) {
			ip = request.getHeader("X-FORWARDED-FOR");
		}
		if (StringUtils.isEmpty(ip)) {
			ip = request.getRemoteAddr();
		}
		if (StringUtils.isEmpty(ip)) {
			LOGGER.logMessage("Cannot retrieve ip address neither in session nor in header");
		}
		return ip;
	}

	/**
	 * Method to get client IP from request parameters
	 * 
	 * @param request
	 * 
	 * @return String client IP
	 */
	private static String getIpFromHeaderWrapped(HttpServletRequest request) {
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			if (Constants.LoggingParams.HEADER_CLIENTIP.equalsIgnoreCase(name)) {
				String ip = request.getHeader(name);
				LOGGER.logMessage("ClientIp found in header. ClientIP: {}", ip);
				return ip;
			}
		}
		try {
			InetAddress addr = InetAddress.getLocalHost();
			LOGGER.logMessage("clientIp parameter not found in header! [ hostAddress= {} ], [ hostname= {} ]",
					addr.getHostAddress(), addr.getHostName());
		} catch (UnknownHostException e) {
			LOGGER.logError(e);
		}
		return null;
	}

}