package com.study.wsdev.config;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.study.wsdev.utils.ResourceUtils;
/**
 * <h3>
 * A class that defines preference beans. 
 * This class defines the beans that are used after the application starts.
 * </h3>
 * 
 * @version 1.0.0
 * @since 1/24/20
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 */
@Configuration
public class CommonConfig{

	@Autowired
	private static ApplicationContext applicationContext;

	/**
	 * <pre>Register beans to manage configuration.</pre>
	 * @return {@link PropertySourcesPlaceholderConfigurer}
	 * @throws IOException
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
			throws IOException {
		PropertySourcesPlaceholderConfigurer configurer
			= new PropertySourcesPlaceholderConfigurer();

		Resource[] propertiesLocations 
			= ResourceUtils.getResources(SystemEnvironment.PROP_LOCATION.getElement(String.class));

		configurer.setLocations(propertiesLocations);
		configurer.setIgnoreResourceNotFound(true);
		configurer.setNullValue("null");
		
		return configurer;
	}
}
