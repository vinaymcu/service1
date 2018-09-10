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

package com.accenture.avs.ossbss.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.ossbss.config.Configuration;
import com.accenture.avs.ossbss.config.ConfigurationProvider;
import com.accenture.avs.ossbss.config.RequestMetadata;
import com.accenture.avs.ossbss.exception.ErrorCode;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;

/**
 * The Class Client.
 *
 * @author <a href="Sumit.Sharma@rsystems.com">Sumit.Sharma</a>
 * @version Sep 16, 2016
 *
 *
 *
 */

public class Client extends AbstractClient {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(Client.class);

	/**
	 * Instantiates a new client.
	 *
	 * @param configuration
	 *            the configuration
	 * @param configurationProvider
	 *            the application metadata
	 * @param requestMetadata
	 *            the request metadata
	 */
	public Client(final Configuration configuration, final ConfigurationProvider configurationProvider,
			final RequestMetadata requestMetadata) {
		super(configuration, configurationProvider, requestMetadata);
	}

	@Override
	public HttpResponse doExchange(String requestData) {
		HttpResponse httpResponse;
		try {
			LOGGER.logMessage("RequestData="+requestData);
			final HttpClient client = prepareHttpClient();
			final HttpUriRequest request = prepareRequest(requestData);
			httpResponse = client.execute(request);
			if (httpResponse.getStatusLine().getStatusCode() != 200) {
				throw new OSSBSSClientException(ErrorCode.ERROR_OCCURRED_MAKING_HTTP_CALL);
			}
		} catch (final OSSBSSClientException e) {
			LOGGER.logError(e, "Something went wrong.");
			throw e;
		} catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException
				| CertificateException | IOException e) {
			LOGGER.logError(e,"Something went wrong.");
			throw new OSSBSSClientException(ErrorCode.ERROR_OCCURRED_MAKING_HTTP_CALL, e);
		}
		return httpResponse;
	}

	/**
	 * Prepare http client.
	 *
	 * @return the http client
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws UnrecoverableKeyException
	 * @throws KeyManagementException
	 * @throws IOException
	 * @throws CertificateException
	 *
	 */
	private HttpClient prepareHttpClient() throws KeyManagementException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
		HttpClient client = null;
		if (StringUtils.startsWithIgnoreCase(configurationProvider.getUrl(), "https")
				|| configurationProvider.isSecurityEnabled()) {
			final KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			InputStream is = null;
			if (StringUtils.contains(configurationProvider.getSecurityKeystorePath(), "file:")) {
				is = new FileInputStream(
						new File(StringUtils.substringAfter(configurationProvider.getSecurityKeystorePath(), "file:")));
			} else {
				is = Client.class.getResourceAsStream(
						StringUtils.substringAfter(configurationProvider.getSecurityKeystorePath(), "classpath:"));
			}
			try {
				trustStore.load(is, configurationProvider.getSecurityPassword().toCharArray());
			} finally {
				if (is != null) {
					is.close();
				}
			}
			final SSLContext SSLContext = SSLContexts.custom()
					.loadKeyMaterial(trustStore, configurationProvider.getSecurityPassword().toCharArray()).build();
			SSLConnectionSocketFactory sslsf = null;
			if (ArrayUtils.isEmpty(configurationProvider.getSecurityProtocols())
					|| ArrayUtils.isEmpty(configurationProvider.getSecurityCiphersuites())) {
				sslsf = new SSLConnectionSocketFactory(SSLContext);
			} else {
				sslsf = new SSLConnectionSocketFactory(SSLContext, configurationProvider.getSecurityProtocols(),
						configurationProvider.getSecurityCiphersuites(),
						SSLConnectionSocketFactory.getDefaultHostnameVerifier());
			}
			client = HttpClientBuilder.create().setSSLSocketFactory(sslsf).build();
		} else {
			client = HttpClientBuilder.create().build();
		}
		return client;
	}

	/**
	 * Prepare request.
	 *
	 * @param requestData
	 *            the request data
	 * @return the http uri request
	 * @throws UnsupportedEncodingException
	 *
	 */
	private HttpUriRequest prepareRequest(final String requestData) throws UnsupportedEncodingException {
		final String contentType;
		if (requestMetadata.getContentType() != null) {
			contentType = requestMetadata.getContentType();
		} else {
			contentType = configurationProvider.getContentType();
		}
		String uri = configurationProvider.getUrl();
		uri += requestMetadata.getPath();

		HttpEntityEnclosingRequestBase request;

		if ("PUT".equalsIgnoreCase(requestMetadata.getMethod())) {
			request = new HttpPut(uri);
		} else {
			request = new HttpPost(uri);
		}
		if (MapUtils.isNotEmpty(requestMetadata.getHeaders())) {
			for (final Entry<String, String> entry : requestMetadata.getHeaders().entrySet()) {
				request.setHeader(entry.getKey(), entry.getValue());
			}
		}
		request.setHeader("Content-Type", contentType);
		final StringEntity reqEntity = new StringEntity(requestData);
		reqEntity.setContentType(contentType);
		reqEntity.setChunked(true);
		request.setEntity(reqEntity);
		return request;
	}

}
