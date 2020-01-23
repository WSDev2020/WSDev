package com.study.wsdev.vo;

import java.util.HashMap;

/**
 * <h3>
 * In order to process the VO data created on the screen in common,</br>
 * a map has been added. This map will proxy(over) all the resulting values ​</br>
 * to their lower-case set and return them.</br>
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
 * @see HashMap
 *
 */
public class LowerCaseMap extends HashMap<String, String>{
	
	/** not sync */
	private static final long serialVersionUID = -1L;

	@Override
	public String put(String key, String value) {
		
		return super.put(key.toLowerCase(), value);
	}
}
