package com.study.wsdev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <pre>
 * application root annoteted configuration on WSDev
 * </pre>
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 *       
 * @see Configuration
 *
 */
public class InitConfig 
	extends AbstractAnnotationConfigDispatcherServletInitializer{

	/* servlet Configuration Classes */
	final Class<?>[] ServletConfigurationClassFiles
		= new Class[] {WebMvcConfig.class};
	
	/* Root Configuration Classes */
	final Class<?>[] ApplicationConfigurationClassFiles
	    = new Class[] {ApplicationConfig.class};
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return ServletConfigurationClassFiles;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return ApplicationConfigurationClassFiles;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
