package com.study.wsdev.vo;

import java.util.Objects;

import org.springframework.context.annotation.Configuration;

/**
 * <h3>
 * Final variables created to define module information
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
public enum Modules {
	
	  /** part of normally application */
	  APP("app")
	  
	  /** for identified by all request */
	, IDENTI("login")
	;

	final private String module;
	
	final private String defaultUrl = "/"; 

	private Modules(String module) {
		this.module = module;
	}
	
	public String getPath(String url) {

		return Objects.isNull(url) ? 
			  this.module + defaultUrl : this.module + url;
	}
	
}
