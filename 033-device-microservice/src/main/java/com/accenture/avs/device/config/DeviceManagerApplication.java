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
package com.accenture.avs.device.config;

import java.util.HashMap;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import com.accenture.avs.commons.lib.LoggerWrapper;
import com.accenture.avs.commons.lib.LoggerWrapper.ErrorType;
import com.accenture.avs.device.exception.DeviceManagerException;

/**
 * The Class DeviceManagerApplication.
 */
@PropertySource("file:${BE_PROPERTIES}/${spring.application.name}/devicemanager.properties")
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.accenture.avs.device.entity" })
@SpringBootApplication(scanBasePackages = { "com.accenture.avs.device" })
@EnableJpaRepositories(basePackages = { "com.accenture.avs.device.repository" })
@ComponentScan(basePackages = { "com.accenture.avs.device" })
@EnableConfigurationProperties(value = { CRMConfigurationProvider.class })
public class DeviceManagerApplication extends SpringBootServletInitializer {
	
	/** log4jConfigLocation */
	@Value("${log4j.config.location}")
	private String log4jConfigLocation;
	
	/** Wire ConfigurationProperties bean */
	@Autowired
	private ConfigurationProperties configProp;
	
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(DeviceManagerApplication.class);

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DeviceManagerApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.addUrlMappings("/*");
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return registration;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Message source.
	 *
	 * @return the reloadable resource bundle message source
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages/message");
		return messageSource;
	}
	
	@Bean(name = "configurationDb")
	public DataSource configurationDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource(configProp.getAvsbeConfigurationJndi());
	}

	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("configurationDb") DataSource configurationDataSource) {
		return new JdbcTemplate(configurationDataSource);
	}

	/**
	 * Message source accessor.
	 *
	 * @return the message source accessor
	 */
	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messageSource(), Locale.ENGLISH);
	}

	/**
	 * The Init method.
	 */
	@PostConstruct
	public void init() {
		LOGGER.logMessage("Initializing Device Manager Application  .. ");
		HashMap<Class, ErrorType> errorMap = new HashMap<>();
		errorMap.put(DeviceManagerException.class, ErrorType.EXPECTED_ERROR);
		LoggerWrapper.initialize(log4jConfigLocation, errorMap);
	}

}
