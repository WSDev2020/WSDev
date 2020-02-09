package com.study.wsdev.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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
}
