package com.study.wsdev.config;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

import com.study.wsdev.vo.OauthAuthentication;
import com.study.wsdev.vo.User;

public class OAuthSessionFilterChainProvider implements Filter{
	

	@Autowired
    private RedisConnectionFactory connectionFactory;

	
	public OAuthSessionFilterChainProvider() { }

	public OAuthSessionFilterChainProvider(
			RedisConnectionFactory connectionFactory) {

		this.connectionFactory = connectionFactory;
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)req).getSession();
		
		User usr = (User)session.getAttribute("usr");
		
		if(!Objects.isNull(usr)) {
		
			SecurityContext securityContext = SecurityContextHolder.getContext();
			
			if(Objects.isNull(securityContext.getAuthentication())) {

				OauthAuthentication oauthAuthentication = new OauthAuthentication(usr);
				
				oauthAuthentication.setAuthenticated(true);
				
				SecurityContextHolder.getContext().setAuthentication(oauthAuthentication);
			}
		}
		
		filter.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
