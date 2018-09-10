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

import java.io.IOException;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.accenture.avs.device.util.Constants;

/** 
 * Rest Client Interceptor class for adding headers to calling api
 *
 */
@Component("restClientHttpRequestInterceptor")
public class RestClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution
			execution)
			throws IOException {	
		request.getHeaders().add(Constants.LoggingParams.X_AVS_USER_NAME, ThreadContext.get(Constants.LoggingParams.USER));
		request.getHeaders().add(Constants.LoggingParams.HEADER_CHANNEL, ThreadContext.get(Constants.LoggingParams.PLATFORM));
		request.getHeaders().add(Constants.LoggingParams.X_AVS_TRANSACTION_ID, ThreadContext.get(Constants.LoggingParams.TN));
		request.getHeaders().add(Constants.LoggingParams.X_AVS_SESSION_ID, ThreadContext.get(Constants.LoggingParams.SID));
		request.getHeaders().add(Constants.LoggingParams.HEADER_CLIENTIP, ThreadContext.get(Constants.LoggingParams.CLIENT_IP));
		return execution.execute(request, body);
	}

}
