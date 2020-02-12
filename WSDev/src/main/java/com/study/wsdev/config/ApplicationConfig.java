package com.study.wsdev.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import com.google.errorprone.annotations.concurrent.LazyInit;
import com.study.wsdev.utils.ResourceUtils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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
@EnableRedisHttpSession
@Import({
	SecureConfig.class
})
public class ApplicationConfig extends AbstractHttpSessionApplicationInitializer{
	
	@Value("${datasource.prop.redis.host}")
	@LazyInit
	private String redisHostName;
	
	@Value("${datasource.prop.redis.port}")
	@LazyInit
	private String redisPort;
	
	@Value("${datasource.prop.redis.password}")
	@LazyInit
	private String redisPassword;

	/**
	 * <p>Treading executor for async processing</p>
	 * @return
	 */
	public TaskExecutor poolExecutor() {

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        taskExecutor.setCorePoolSize(4);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(10);
        taskExecutor.setThreadNamePrefix("exec-");
        taskExecutor.initialize();

        return taskExecutor;
		
	}
	
	/**
	 * <pre>Register beans to manage configuration.</pre>
	 * @return {@link PropertySourcesPlaceholderConfigurer}
	 * @throws IOException
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
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

	/**
	 * <pre>Memorial Cache redis.</pre>
	 * @return {@link JedisPoolConfig}
	 */
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

		return jedisPoolConfig;
	}

	/**
	 * <pre>Memorial Cache redis Factory Object</pre>
	 * @return {@link JedisPoolConfig}
	 */
	@Bean
    public RedisConnectionFactory connectionFactory(JedisPoolConfig jedisPoolConfig) {
 	   
        JedisConnectionFactory connection = new JedisConnectionFactory(jedisPoolConfig); 

        connection.setHostName(redisHostName);
        connection.setPort(Integer.parseInt(redisPort));
        connection.setPassword(redisPassword);
        connection.setUsePool(true);
        
        
        return connection;
    }
}
