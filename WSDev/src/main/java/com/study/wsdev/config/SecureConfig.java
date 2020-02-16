package com.study.wsdev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

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
@EnableWebSecurity
public class SecureConfig 
extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		    .antMatchers("/login/**").permitAll()
		    .antMatchers("/resources/**").permitAll()
		    .antMatchers("/**")
		    .authenticated()
		    .and()
		    .formLogin().loginPage("/login")
		    .permitAll()
		    .and().csrf().disable()
	        ;

		// *proxy resolve filter
		// 1.  SecurityContextPersistenceFilter
		// 2.  logoutfilter
		//              <-- OAuthSessionFilterChainProvider
		// 3.  UsernamePasswordAuthenticationFilter
		// 4.  DefaultLoginPageGeneratingFilter
		// 5.  BasicAuthenticationFilter
		// 6.  RemeberMeAtuhenticationFilter
		// 7.  SecurityContextHolderAwareRequestFilter
		// 8.  AnonymouseAuthenticationFilter
		// 9.  SessionManagementFilter
		// 10. ExceptionTranslationFilter
		// 11. FilterSecurityInterceptor
		http.addFilterBefore(new OAuthSessionFilterChainProvider(), UsernamePasswordAuthenticationFilter.class);

	}

}
