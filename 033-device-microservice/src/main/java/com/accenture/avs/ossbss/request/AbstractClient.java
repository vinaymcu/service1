package com.accenture.avs.ossbss.request;

import org.apache.http.HttpResponse;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.ossbss.config.Configuration;
import com.accenture.avs.ossbss.config.ConfigurationProvider;
import com.accenture.avs.ossbss.config.RequestMetadata;
import com.accenture.avs.ossbss.exception.OSSBSSClientException;
import com.accenture.avs.ossbss.resource.ResourceRepository;
import com.accenture.avs.ossbss.transformer.Transformer;
import com.accenture.avs.ossbss.validator.Validator;

/**
 * @author <a href="Sumit.Sharma@rsystems.com">Sumit Kumar Sharma</a>
 * @version Sep 27, 2016
 */
public abstract class AbstractClient {
	
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(AbstractClient.class);

	/** The configuration. */
	protected final Configuration configuration;

	/** The application metadata. */
	protected final ConfigurationProvider configurationProvider;

	/** The request metadata. */
	protected final RequestMetadata requestMetadata;

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
	public AbstractClient(final Configuration configuration, final ConfigurationProvider configurationProvider,
			final RequestMetadata requestMetadata) {
		super();
		this.configuration = configuration;
		this.configurationProvider = configurationProvider;
		this.requestMetadata = requestMetadata;
	}

	/**
	 * @param requestData
	 * @return HttpResponse
	 */
	public abstract HttpResponse doExchange(final String requestData);

	/**
	 * Exchange.
	 *
	 * @param requestObject
	 *            the request object
	 * @throws Exception
	 *             the exception
	 */
	public void exchange(final Object requestObject) throws OSSBSSClientException {
		final String data = prepareRequestData(requestObject);
		LOGGER.logMessage("Request data prepared [\n {} \n] ", data);
		final HttpResponse response = doExchange(data);
		LOGGER.logMessage("Response [\n {} \n] ", response);
	}

	/**
	 * Exchange.
	 *
	 * @param <T>
	 *            the generic type
	 * @param requestObject
	 *            the request object
	 * @param responseType
	 *            the response type
	 * @return the t
	 */
	public <T> T exchange(final Object requestObject, final Class<T> responseType) throws OSSBSSClientException {
		final T response = null;
		final String data = prepareRequestData(requestObject);
		LOGGER.logMessage("Request data prepared [\n {} \n] ", data);
		final HttpResponse httpResponse = doExchange(data);
		LOGGER.logMessage("Response [\n {} \n] ", httpResponse);
		return response;
	}

	/**
	 * Prepare request data.
	 *
	 * @param object
	 *            the object
	 * @return the string
	 */
	private String prepareRequestData(final Object object) {
		final String requestJson = configuration.getJsonHelper().toJsonString(object);
		final ResourceRepository resourceRepository = configuration.getResourceRepositoryFactory()
				.newInstance(configurationProvider.getRepositoryType());

		final String mappingString = resourceRepository.findMapper(configurationProvider.getApplicationName(),
				requestMetadata.getMapperPath());
		final String schemaString = resourceRepository.findSchema(configurationProvider.getApplicationName(),
				requestMetadata.getSchemaPath());

		final String contentType = requestMetadata.getContentType() != null ? requestMetadata.getContentType()
				: configurationProvider.getContentType();

		final Transformer transformer = configuration.getTransformerFactory().newInstance(contentType);

		final String transformedRequestData = transformer.transform(requestJson, requestMetadata.getRootElement(),
				mappingString);

		final Validator validator = configuration.getValidatorFactory().newInstance(contentType);
		validator.validate(transformedRequestData, schemaString);

		return transformedRequestData;
	}

}
