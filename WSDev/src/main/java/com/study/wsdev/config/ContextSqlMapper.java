package com.study.wsdev.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.study.wsdev.utils.ResourceUtils;

/**
 * <h3>@최초 작성자가 작성하도록 함</h3>
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
public class ContextSqlMapper {

	@Value("${mybatis.prop.configLocation}")
	private String configLocation;
	
	@Value("${mybatis.prop.mapperLocation}")
	private String mapperLocation;
	
	/**
	 * <pre>
	 * Register sqlSessionFactoryBean that sets mappers(mybatis).
	 * </pre>
	 * @param dataSource {@link DataSourceConfig#dataSource}
	 * @return sqlSessionFactoryBean
	 * @throws IOException
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
		
	   SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

	   sqlSessionFactoryBean.setDataSource(dataSource);
	   sqlSessionFactoryBean.setConfigLocation(ResourceUtils.getResource(configLocation));
	   sqlSessionFactoryBean.setMapperLocations(ResourceUtils.getResources(mapperLocation));

       return sqlSessionFactoryBean;
	}
	
	/**
	 * <pre>
	 * When requested by the mapper,
	 * the factory bean is used to register the bean that issues a session.
	 * </pre>
	 * @param sqlSessionFactory {@link this#sqlSessionFactory}
	 * @return sqlSessionTemplate
	 */
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		
		return sqlSessionTemplate;
	}
}
