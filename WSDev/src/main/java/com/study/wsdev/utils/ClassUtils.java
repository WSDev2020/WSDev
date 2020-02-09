package com.study.wsdev.utils;

/**
 * <p>Utility class for using functions associated with Class Information</p>
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
public class ClassUtils {
	
	/**
	 * <p>A function that returns a class using the class name</p>
	 * @param className
	 * @return Class Type Object
	 */
	public static Class<?> findClass(String className) {

		Class<?> cls = null;

		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			cls = Object.class;
		}
		
		return cls;
	}
}
