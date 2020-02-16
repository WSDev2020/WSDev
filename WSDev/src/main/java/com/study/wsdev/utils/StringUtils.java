package com.study.wsdev.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.tiles.request.collection.KeySet;

/**
 * <p>Utility class for using functions associated with String.class</p>
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
 */
public class StringUtils {

	/**
	 * <pre>
	 * Convert a regular string to a set of array unit strings
	 * </pre>
	 * @param arguments String.class
	 * @return [LString.class
	 */
	public static String[] toArray(String... arguments) {
		
		return arguments;
	}
	
	public static void main(String[] args) {
		
		//make up System property values 
		List<Object> list = new ArrayList<Object>(System.getProperties().values());
		
		// collect environment argument boot application
		list.addAll(Arrays.asList(args));

		// stream open
		list.stream()
		    .sorted()
		    .filter(e->((String)e).trim().length() > 0)
		    .forEach(t -> Arrays.asList(((String)t).split(";"))
		    		            .stream()
		    		            .filter(e->((String)e).trim().length() > 0)
		    		            .sorted()
		    		            .forEach(System.out::println));
	}
}
