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
package com.accenture.avs.device.tenant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

/**
 * Enable support for Multitenant DataSource.
 *
 * @author Sumit.Sharma
 * @since 1.0
 *
 */
@Configuration
@EnableConfigurationProperties
public class MultitenantDataSourceConfiguration {

	@Autowired
	private com.accenture.avs.device.config.ConfigurationProperties config;

	/** The application context. */
	@Autowired
	private ApplicationContext applicationContext;

	/** The resolved data sources. */
	private final Map<Object, Object> resolvedDataSources = new ConcurrentHashMap<>();

	/**
	 * Checks if is tenant enabled.
	 *
	 * @param tenant
	 *            the tenant
	 * @return true, if is tenant enabled
	 */
	public boolean isTenantEnabled(final Object tenant) {
		return resolvedDataSources.containsKey(tenant);
	}

	/**
	 * Multitenancy datasource bean initialization .
	 *
	 * @return the data source
	 */
	@Bean
	@Primary
	@DependsOn(value = { "readDataSource", "writeDataSource" })
	public DataSource multitenantDataSource() {
		resolvedDataSources.put(Tenants.WRITE, applicationContext.getBean("writeDataSource"));
		resolvedDataSources.put(Tenants.READ, applicationContext.getBean("readDataSource"));
		final MultitenantDataSource dataSource = new MultitenantDataSource();
		dataSource.setDefaultTargetDataSource(resolvedDataSources.get(Tenants.READ));
		dataSource.setTargetDataSources(resolvedDataSources);
		return dataSource;
	}

	@Bean(name = "readDataSource")
	@ConfigurationProperties(prefix = "spring.multitenancy.read")
	public DataSource readDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(config.getReadJndiName());
		return dataSource;
	}

	@Bean(name = "writeDataSource")
	@ConfigurationProperties(prefix = "spring.multitenancy.write")
	public DataSource writeDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(config.getWriteJndiName());
		return dataSource;
	}

}
