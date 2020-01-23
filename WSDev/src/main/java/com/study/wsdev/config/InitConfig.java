package com.study.wsdev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <pre>
 * application root annoteted configuration on WSDev
 * </pre>
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
 * @see Configuration
 */
public class InitConfig 
	extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return SystemEnvironment.APPLICATION_CONFIGURATION_CLASS
                                .getElement(Class[].class);
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return SystemEnvironment.SERVLET_CONFIGURATION_CLASS
				                .getElement(Class[].class);
	}

	@Override
	protected String[] getServletMappings() {
		return SystemEnvironment.SERVLET_MAPPING_URL
                                .getElement(String[].class);
	}

}
