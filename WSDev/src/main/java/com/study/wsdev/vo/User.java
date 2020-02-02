package com.study.wsdev.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
public class User {
	
	public static class UserDatail {
		
		public static String USR_IDX   = "USR_IDX"   ;
		public static String USR_ID    = "USR_ID"    ;
		public static String USR_NM    = "USR_NM"    ;
		public static String USR_EMAIL = "USR_EMAIL" ;
		public static String USR_NICK  = "USR_NICK"  ;
		
		public static String LOGIN_TM  = "LOGIN_TM"  ;
		public static String LOGIN_IP  = "LOGIN_IP"  ;
	}
	
	public void setUSR_IDX(String user_idx) {

		elements.put(UserDatail.USR_IDX, user_idx);
	}

	public String getUSR_IDX() {

		return elements.get(UserDatail.USR_IDX);
	}
	
	public void setUSR_ID(String user_idx) {
		
		elements.put(UserDatail.USR_ID, user_idx);
	}
	
	public String getUSR_ID() {
		
		return elements.get(UserDatail.USR_ID);
	}
	
	public void setUSR_NM(String user_idx) {
		
		elements.put(UserDatail.USR_NM, user_idx);
	}
	
	public String getUSR_NM() {
		
		return elements.get(UserDatail.USR_NM);
	}
	
	public void setUSR_EMAIL(String user_idx) {
		
		elements.put(UserDatail.USR_EMAIL, user_idx);
	}
	
	public String getUSR_EMAIL() {
		
		return elements.get(UserDatail.USR_EMAIL);
	}
	
	public void setUSR_NICK(String user_idx) {
		
		elements.put(UserDatail.USR_NICK, user_idx);
	}
	
	public String getUSR_NICK() {
		
		return elements.get(UserDatail.USR_NICK);
	}
	
	public void setLOGIN_TM(String user_idx) {
		
		elements.put(UserDatail.LOGIN_TM, user_idx);
	}
	
	public String getLOGIN_TM() {
		
		return elements.get(UserDatail.LOGIN_TM);
	}
	
	public void setLOGIN_IP(String user_idx) {
		
		elements.put(UserDatail.LOGIN_IP, user_idx);
	}
	
	public String getLOGIN_IP() {
		
		return elements.get(UserDatail.LOGIN_IP);
	}
	
	
	
	/**  User Vo Elements */
	private Map<String, String> elements = new HashMap<String, String>();

}
