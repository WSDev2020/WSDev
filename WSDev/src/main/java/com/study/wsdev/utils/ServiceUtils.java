package com.study.wsdev.utils;

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

	static public UserUtils userUtils = new UserUtils();

	/**
	 * <h3> Use service Extention Utils Plugin</h3>
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
	static class UserUtils {
		
		/**
		 * <p>get User information</p>
		 */
		public static User getUser() {
			
			return new User();
		}
		
		
	}

}
