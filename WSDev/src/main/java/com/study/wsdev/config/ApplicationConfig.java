package com.study.wsdev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
    value={
       "classpath:config/props/common.properties"
      ,"classpath:config/props/datasource.properties"
      ,"classpath:config/props/socket.properties"
    }
  , ignoreResourceNotFound = true)
public class ApplicationConfig {
	
}
