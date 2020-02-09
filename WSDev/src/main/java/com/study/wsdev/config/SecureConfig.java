package com.study.wsdev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <h3>
 * Registers bean related to security processing setting written</br>
 * in Spring Security and reflects basic structure</br>
 * by applying Spring Security and oAuth2 of relevant class.</br>
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
 *       
 * @see Configuration
 */

@Configuration
//@EnableWebSecurity
public class SecureConfig 
//extends WebSecurityConfigurerAdapter
{

//	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
        http.antMatcher("/**")
	        .authorizeRequests()
	        .antMatchers("/", "/h2-console/**", "/favicon.ico").permitAll()
	        .and().logout().logoutSuccessUrl("/").permitAll()
	        .and().headers().frameOptions().sameOrigin()
	        .and().csrf().disable();
        
//		http.authorizeRequests()
//		    .antMatchers("/login/**")
//		    .permitAll()
//		    .antMatchers("/app/**")
//		    .authenticated()
//		    .and().csrf().disable()
//		    ;
		
		

		/*
		http.authorizeRequests()
		    .antMatchers("/*")
	        .authenticated();

		http.formLogin()
		    .loginPage("/login")
		    .loginProcessingUrl("/")
		    .permitAll();
		*/
	}

//	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
	}
	
	

}
