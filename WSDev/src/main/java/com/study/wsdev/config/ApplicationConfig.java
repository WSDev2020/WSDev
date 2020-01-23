package com.study.wsdev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <h3> Classes to manage common beans that manage applications</h3>
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
@Import({
	SecureConfig.class
})
public class ApplicationConfig {
	
}
