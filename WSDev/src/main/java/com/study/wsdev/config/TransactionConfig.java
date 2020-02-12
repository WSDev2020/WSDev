package com.study.wsdev.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * <h3>@���� �ۼ��ڰ� �ۼ��ϵ��� ��</h3>
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
public class TransactionConfig {

	
	/** use for application layer */ 
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource; 
	
	/**
	 * <p>create a <strong>PROXY Object</strong> to manage data sources that use transactions.</br>
	 * That object delegates the transaction from the data source.</p>
	 * 
	 * @see {@linkplain DataSourceConfig#dataSource()}
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() {

		return new DataSourceTransactionManager(dataSource);
	}

}
