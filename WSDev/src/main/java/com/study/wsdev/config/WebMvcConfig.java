package com.study.wsdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@SuppressWarnings({ "deprecation", "deprecation" })
@Configuration
@EnableWebMvc
@ComponentScan("com.study.wsdev.*")
@Import({ AspectConfig.class, BatchConfig.class, DataSourceConfig.class, ContextSqlMapper.class,
		TransactionConfig.class })
public class WebMvcConfig  implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();  
		jspViewResolver.setPrefix("/WEB-INF/view/");  
		jspViewResolver.setOrder(2);
		jspViewResolver.setSuffix(".jsp");
		return jspViewResolver;
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
        tilesConfigurer.setDefinitions(
          new String[] { "/WEB-INF/tiles-def.xml" });
        tilesConfigurer.setCheckRefresh(true);
         
        return tilesConfigurer;
    }

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
