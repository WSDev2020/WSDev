package com.study.wsdev.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.study.wsdev.utils.StringUtils;

/**
 * <h3>
 * Registers serialized bean information related to the httpServlet.
 * Register sessions related to the user's request,
 * beans and screen layout related to the session.</h3>
 * 
 * @version 1.0.0
 * @since 1/24/20
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 * 
 * @description
 * <p>CommonConfig - Setting information that requires common processing</p>
 * <p>AspectConfig - Setting information that requires aspect processing</p>
 * <p>BatchConfig - Setup information that requires batch processing</p>
 * <p>DataSourceConfig - Setup information that requires database processing</p>
 * <p>ContextSqlMapper - Configuration Information That Requires MyBatis Processing</p>
 * <p>TransactionConfig - Setting information that requires transaction processing</p>
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.study.wsdev")
@Import({ CommonConfig.class
	    , AspectConfig.class
	    , BatchConfig.class
	    , DataSourceConfig.class
	    , ContextSqlMapper.class
	    , TransactionConfig.class })
public class WebMvcConfig implements WebMvcConfigurer {

	/**  ViewResolver Prefix */
	@Value("${servlet.view.prefix}")
	private String viewResolverPrefix;
	
	/** ViewResolver Suffix */
	@Value("${servlet.view.suffix}")
	private String viewResolverSuffix;
	
	/** ViewResolver ViewName */
	@Value("${servlet.view.viewName}")
	private String viewResolverViewName;
	
	/** ViewResolver ViewName */
	@Value("${servlet.tiles.definition}")
	private String tilesDefinition;
	
	/**
	 * <pre>
	 * Register the ViewResolver.
	 * The default mapping rule for ViewResolver is treated 
	 * as Prefix + Request Url + Suffix.
	 * </pre>
	 * 
	 * @return ViewResolver
	 */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        
        viewResolver.setViewNames(viewResolverViewName);
        viewResolver.setPrefix(viewResolverPrefix);
        viewResolver.setSuffix(viewResolverSuffix);
 
        return viewResolver;
    }
	
	
	@Bean
    public TilesViewResolver setupViewTilesResolver() {
		
        TilesViewResolver resolver = new TilesViewResolver();
        
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(1);
        
        return resolver;
    }

	@Bean
    public TilesConfigurer tilesConfigurer() {
		
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        
        tilesConfigurer.setDefinitions(StringUtils.toArray(tilesDefinition));
        tilesConfigurer.setCheckRefresh(true);

        return tilesConfigurer;
    }

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**")
		        .addResourceLocations("/resources/");
	}

}
