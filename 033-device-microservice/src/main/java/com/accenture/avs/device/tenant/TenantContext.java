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

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.accenture.avs.commons.lib.LoggerWrapper;

/**
 * The helper Class to set/get Tenant lookup key to thread-bound context.
 *
 * @author Sumit.Sharma
 * @version 1.0
 *
 */

@Component
public class TenantContext implements ApplicationContextAware {
  
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(TenantContext.class);
  
  /** The current tenant. */
  private static ThreadLocal<Object> currentTenant = new ThreadLocal<>();
  
  /** The multitenant data source configuration. */
  private static MultitenantDataSourceConfiguration multitenantDataSourceConfiguration;
  
  /**
   * Gets the tenant lookup key from thread-bound context.
   *
   *
   * @return the current tenant lookup key, <code> Tenants.READ </code> if null.
   */
  public static Object getCurrentTenant() {
    final Object tenant = currentTenant.get() == null ? Tenants.READ : currentTenant.get(); 
    if(LOGGER.isDebugEnabled()){
    	LOGGER.logMessage("Getting current for lookup key i.e  [" + tenant + "] ");
    }
    return tenant;
  }
  
  /**
   * Sets the tenant lookup key to thread-bound context.
   *
   * @param tenant the new current tenant
   */
  
  public static void setCurrentTenant(final Object tenant) {
    if (!multitenantDataSourceConfiguration.isTenantEnabled(tenant)) {
      throw new IllegalStateException("Tenant [] not configured.");
    }
    if(LOGGER.isDebugEnabled()){
    	LOGGER.logMessage("Setting current tenant lookup key i.e  [" + tenant + "] ");
    }
    currentTenant.set(tenant);
  }
  
  /**
   * Sets the application context.
   *
   * @param applicationContext the new application context
   */
  /*
   * (non-Javadoc)
   *
   * @see
   * org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework
   * .context.ApplicationContext)
   */
  @Override
  public void setApplicationContext(final ApplicationContext applicationContext) {
    TenantContext.multitenantDataSourceConfiguration =
        applicationContext.getBean(MultitenantDataSourceConfiguration.class);
  }
}
