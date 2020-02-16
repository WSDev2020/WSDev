package com.study.wsdev.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.query.RedisOperationChain;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import com.study.wsdev.utils.ResourceUtils;

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
	private String redisHostName;
	
	@Value("${datasource.prop.redis.port}")
	private String redisPort;
	
	@Value("${datasource.prop.redis.password}")
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
	 * <pre>Memorial Cache redis Factory Object</pre>
	 * @return {@link JedisPoolConfig}
	 */
	@Bean
    public LettuceConnectionFactory connectionFactory() {

	    LettuceConnectionFactory lettuceConnectionFactory =
	            new LettuceConnectionFactory();

	    lettuceConnectionFactory.setHostName(redisHostName);
	    lettuceConnectionFactory.setPort(Integer.parseInt(redisPort));
	    lettuceConnectionFactory.setPassword(redisPassword);
	    
        return lettuceConnectionFactory;
    }
	
	@Bean
	public RedisTemplate redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
		RedisTemplate redisTemplate = new RedisTemplate<>();
		
		redisTemplate.setConnectionFactory(lettuceConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());

		return redisTemplate;
	}
	

}
