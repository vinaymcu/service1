package com.accenture.avs.device.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author SUMIT
 * @since 1.0
 */
@Component
public class SpringBeanUtils implements ApplicationContextAware {

	private static ApplicationContext APPLICATION_CONTEXT;


	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return APPLICATION_CONTEXT.getBean(clazz);
	}

	/**
	 * @param applicationContext
	 * @throws
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringBeanUtils.APPLICATION_CONTEXT = applicationContext;
	}
	
	public ApplicationContext getApplicationContext(){
		return APPLICATION_CONTEXT;
	}
}
