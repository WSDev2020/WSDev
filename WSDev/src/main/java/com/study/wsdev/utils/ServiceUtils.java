package com.study.wsdev.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

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
	
	@Autowired
	static public UserUtils userUtils;

	@Autowired
	static public RedisUtils redisUtils;
	
	

	public ServiceUtils() {
		
		System.out.println("======================================================================================");
	}


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
	@Component
	static class UserUtils {
		
		/**
		 * <p>get User information</p>
		 */
		public static User getUser() {
			
			return new User();
		}
		
		
	}
	

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

}
