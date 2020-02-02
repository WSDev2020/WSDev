package com.study.wsdev.utils;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

/**
 * <p>Utility class for using functions associated with resources</p>
 * 
 * @version 1.0.0
 * @since 1/24/20
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 *
 */
public class ResourceUtils implements ApplicationContextAware {

	private static ResourcePatternResolver resourceResolver
		= new PathMatchingResourcePatternResolver();
	
	/**
	 * <p>inject application context for resource Loading at application</p>
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ResourceUtils.resourceResolver = applicationContext;
	}

	public static Resource getResource(String location) {
		return resourceResolver.getResource(location);
	}
	
	public static Resource[] getResources(String pattern) throws IOException {
		return resourceResolver.getResources(pattern);
	}
}
