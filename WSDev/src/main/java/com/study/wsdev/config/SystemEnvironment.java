package com.study.wsdev.config;

/**
 * <p>Classes that manage system configuration information</p>
 * 
 * @version 1.0.0
 * @since 1/24/20
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 * @author User
 */
public enum SystemEnvironment {
	
	/* properties locations patter :: CommonConfig */
	 PROP_LOCATION("classpath:config/props/*.properties")
	 
	 /* servlet mapping url :: InitConfig */
	,SERVLET_MAPPING_URL(new String[]{"/"})

	/* Root Configuration Classes :: InitConfig */
	,APPLICATION_CONFIGURATION_CLASS(ApplicationConfig.class)
	
	 /* servlet Configuration Classes :: InitConfig */
	,SERVLET_CONFIGURATION_CLASS(WebMvcConfig.class)
	
	;

	private Object element;
	
	private SystemEnvironment(String element) {
		this.element = element;
	}
	
	private SystemEnvironment(String... element) {
		this.element = element;
	}
	
	private SystemEnvironment(Class<?>... elementClasses) {
		this.element = elementClasses;
	}
	
	public <T> T getElement(Class<T> castClass) {

		return castClass.cast(element);
	}
	
	public Object getElement() {
		return element;
	}
}
