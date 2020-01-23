package com.study.wsdev.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <h3>
 * Registers serialized beans associated with database configuration.
 * Do not set more than 3tir data in this configuration file.(EDI)
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
@EnableTransactionManagement
public class DataSourceConfig {
	
	@Autowired
	private Environment environment;

	/**
	 * 데이터 소스 등록
	 */
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("datasource.prop.driverName"));
		dataSource.setUrl(environment.getProperty("datasource.prop.url"));
		dataSource.setUsername(environment.getProperty("datasource.prop.userName"));
		dataSource.setPassword(environment.getProperty("datasource.prop.password"));
		dataSource.setDefaultAutoCommit(false);
		return dataSource;
	}
	
	/**
	 * 트랜잭션 매니저 등록
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
