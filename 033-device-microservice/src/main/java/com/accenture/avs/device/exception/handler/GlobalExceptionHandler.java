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

package com.accenture.avs.device.exception.handler;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.device.config.SystemMessage;
import com.accenture.avs.device.config.client.ConfigurationClient;
import com.accenture.avs.device.enums.IdentificationType;
import com.accenture.avs.device.exception.BaseException;
import com.accenture.avs.device.exception.ErrorCode;
import com.accenture.avs.device.json.object.devicemanager.GenericResponse;

/**
 * The Class GlobalExceptionHandler
 * 
 * @author Singh.Saurabh
 *
 */
@Order(value = 1)
@EnableWebMvc
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(GlobalExceptionHandler.class);

	/** configClient */
	@Autowired
	private ConfigurationClient configClient;

	/**
	 * The Init method.
	 */
	@PostConstruct
	public void init() {
		LOGGER.logMessage("Initializing Global Exception Handler  . ");
	}

	/**
	 * Handle Software Upgrade Count Resource Not Found Exception.
	 *
	 * @param request
	 * @param exception
	 * 
	 * @return the response
	 */
	@ExceptionHandler({ NoHandlerFoundException.class})
	public ResponseEntity<GenericResponse> handleResourceNotFoundException(final HttpServletRequest request,
			final Exception exception) {
		return getGenericErrorResponse(ErrorCode.RESOURCE_NOT_FOUND.getCode(), null, exception);
	}

	/**
	 * Handle Software Upgrade Count Bad Request Exception.
	 *
	 * @param request
	 * @param exception
	 * 
	 * @return the response
	 */
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, HttpRequestMethodNotSupportedException.class, MissingServletRequestParameterException.class })
	public ResponseEntity<GenericResponse> handleBadRequestException(final HttpServletRequest request,
			final Exception exception) {
		return getGenericErrorResponse(ErrorCode.BAD_REQUEST.getCode(), null, exception);
	}

	/**
	 * Handle base exception.
	 *
	 * @param request
	 * @param exception
	 * 
	 * @return the response
	 */
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(value = BaseException.class)
	public ResponseEntity<GenericResponse> handleBaseException(final HttpServletRequest request,
			final BaseException exception) {
		return getGenericErrorResponse(exception.getErrorCode().getCode(), exception.getArgs(), exception);
	}

	/**
	 * Handle exception.
	 *
	 * @param request
	 * @param exception
	 * 
	 * @return the response
	 */
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<GenericResponse> handleException(final HttpServletRequest request,
			final Exception exception) {
		String messageKey = ErrorCode.GENERIC_ERROR.getCode();
		if (exception instanceof HttpMessageNotReadableException) {
			messageKey = ErrorCode.JSON_PARSING_FAILED.getCode();
		}else if(exception instanceof ServletRequestBindingException) {
			LOGGER.logError(exception);
		}
		return getGenericErrorResponse(messageKey, null, exception);
	}

	/**
	 * This method returns the Generic Error Response for provided message key
	 * 
	 * @param messageKey
	 * @param param
	 * @param exception
	 * @return
	 */
	private ResponseEntity<GenericResponse> getGenericErrorResponse(String messageKey, Object[] param,
			Exception exception) {
		SystemMessage sysMessage = configClient.findSystemMessage(IdentificationType.defaultLanguage.getProperty(),
				messageKey);

		StringBuilder errorDescription = new StringBuilder(sysMessage.getMessageText());
		if (!ArrayUtils.isEmpty(param)) {
			errorDescription.append(" : ");
			errorDescription.append(param[0]);
		}

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setResultCode(sysMessage.getMessageCode());
		genericResponse.setResultDescription(errorDescription.toString());
		genericResponse.setResultObj(null);
		genericResponse.setExecutionTime(0);
		LOGGER.logError(exception, errorDescription.toString());
		return ResponseEntity.status(sysMessage.getRestStatus()).body(genericResponse);
	}
}
