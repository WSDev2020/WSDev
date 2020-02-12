package com.study.wsdev.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.UserIdSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * <h2> User Information Service Vo Elements </h2>
 *
 * @version 1.0.0
 * @since 2/1/20
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 * 
 * @see HashMap
 */

public class User implements UserIdSource, Serializable{
	
	public static class UserDatail {
		
		/** authenticated type (G,N,F ..) */
		private static String AUTH_G   = "AUTH_G";
		
		/** usr idx(index or pk) */
		private static String USR_IDX   = "USR_IDX"   ;
		
		/** usr idenfy key (non required PK) */
		private static String USR_ID    = "USR_ID"    ;
		
		/** usr name for application view */
		private static String USR_NM    = "USR_NM"    ;
		
		/** usr email */
		private static String USR_EMAIL = "USR_EMAIL" ;
		
		/** usr short name */
		private static String USR_NICK  = "USR_NICK"  ;
		
		/** login device time */
		private static String LOGIN_TM  = "LOGIN_TM"  ;
		
		/** login ip connected */
		private static String LOGIN_IP  = "LOGIN_IP"  ;
		
		/** usr token code */
		private static String LOGIN_TK  = "LOGIN_TK"  ;
	}

	
	public void setAUTH_G(String AUTH_G) {
		
		elements.put(UserDatail.AUTH_G, AUTH_G);
	}
	
	public String getAUTH_G() {
		
		return elements.get(UserDatail.AUTH_G);
	}
	
	
	
	public void setUSR_IDX(String USR_IDX) {

		elements.put(UserDatail.USR_IDX, USR_IDX);
	}

	public String getUSR_IDX() {

		return elements.get(UserDatail.USR_IDX);
	}
	
	
	
	public void setUSR_ID(String USR_ID) {
		
		elements.put(UserDatail.USR_ID, USR_ID);
	}
	
	public String getUSR_ID() {
		
		return elements.get(UserDatail.USR_ID);
	}
	
	
	
	public void setUSR_NM(String USR_NM) {
		
		elements.put(UserDatail.USR_NM, USR_NM);
	}
	
	public String getUSR_NM() {
		
		return elements.get(UserDatail.USR_NM);
	}
	
	
	
	
	public void setUSR_EMAIL(String USR_EMAIL) {
		
		elements.put(UserDatail.USR_EMAIL, USR_EMAIL);
	}
	
	public String getUSR_EMAIL() {
		
		return elements.get(UserDatail.USR_EMAIL);
	}
	
	
	
	public void setUSR_NICK(String USR_NICK) {
		
		elements.put(UserDatail.USR_NICK, USR_NICK);
	}
	
	public String getUSR_NICK() {
		
		return elements.get(UserDatail.USR_NICK);
	}
	
	
	
	public void setLOGIN_TM(String LOGIN_TM) {
		
		elements.put(UserDatail.LOGIN_TM, LOGIN_TM);
	}
	
	public String getLOGIN_TM() {
		
		return elements.get(UserDatail.LOGIN_TM);
	}
	
	
	
	public void setLOGIN_IP(String LOGIN_IP) {
		
		elements.put(UserDatail.LOGIN_IP, LOGIN_IP);
	}
	
	public String getLOGIN_IP() {
		
		return elements.get(UserDatail.LOGIN_IP);
	}
	
	
	public void setLOGIN_TK(String LOGIN_TK) {
		
		elements.put(UserDatail.LOGIN_TK, LOGIN_TK);
	}
	
	public String getLOGIN_TK() {
		
		return elements.get(UserDatail.LOGIN_TK);
	}


	/**  User Vo Elements */
	private Map<String, String> elements = new HashMap<String, String>();

	/** adapting spring (-) social */
	public String getUserId() {
		return elements.get(UserDatail.USR_EMAIL);
	}

}
