package com.study.wsdev.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.study.wsdev.vo.User;

/**
 * <p>Utility class for using functions associated with Services</p>
 * 
 * @version 1.0.0
 * @since 2/2/20
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 */
public class ServiceUtils {
	
	/**
	 * <h3> Use service Extention Utils Plugin (Users)</h3>
	 * 
	 * @version 1.0.0
	 * @since 2/2/20
	 * 
	 * @author Justin hanry
	 * @author Lily
	 * @author NHW
	 * @author Dexter
	 * @author Jizero
	 */
	

	/**
	 * <h3> Use service Extention Utils Plugin (Redis)</h3>
	 * 
	 * @version 1.0.0
	 * @since 2/2/20
	 * 
	 * @author Justin hanry
	 * @author Lily
	 * @author NHW
	 * @author Dexter
	 * @author Jizero
	 */
	@Component
	static class RedisUtils {
		
		@Resource(name = "redisTemplate")
		private ValueOperations<String, String> valusOps;
		
		@Autowired
		private RedisConnectionFactory redisConnection;

	}
	
	
	/**
	 * <h3> Issue a security code that cannot be tampered with. This code is 130 bytes long. </h3>
	 * @return Secured code
	 */
	public static String getSecureTokenCode() {
		
		return new BigInteger(130, new SecureRandom()).toString(32);
	}

	/**
	 * <p>get User information on login</p>
	 * @return login User {Object}
	 */
	public static User getUser() {
		
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest req = servletRequestAttributes.getRequest();

		User usr = (User)req.getSession().getAttribute("usr");

		return Objects.isNull(usr) ? new User() : usr;
	}
}
