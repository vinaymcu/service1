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
package com.accenture.avs.device.util.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller for Schema Validation.
 * 
 * @author
 * 
 */
@RestController
@RequestMapping(value = "/schema")
public class ValidationSchemaRestController {

	/***
	 * This method maps the static resources for schema JSON file.
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/**")
	public ResponseEntity<Resource> getSchemaResoucePath(HttpServletRequest request) {
		try {
			String path = StringUtils.substringAfter(request.getRequestURI(), "schema/");
			StringBuilder pathBuilder = new StringBuilder();
			pathBuilder.append("/public/schema/").append(path);
			if (!StringUtils.contains(path, ".")) {
				pathBuilder.append(".json");
			}
			return ResponseEntity.ok(new ClassPathResource(pathBuilder.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
