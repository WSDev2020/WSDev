package com.study.wsdev.vo;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class OauthAuthentication implements Authentication{
	
	private static final long serialVersionUID = -198757782;
	
	private boolean isAuthenticated = false;

	private OauthPrincipal oauthPrincipal;
	
	public OauthAuthentication(User usr) {
		this.oauthPrincipal = new OauthPrincipal(usr);
	}

	static class OauthPrincipal implements Principal, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 4141583389678075063L;

		private User user;

		public OauthPrincipal(User user) {
			this.user = user;
		}

		@Override
		public String getName() {

			return user.getUSR_NM();
		}
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return oauthPrincipal;
	}

	@Override
	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.isAuthenticated = isAuthenticated;
	}
	

	// not use
	@Override
	public Object getCredentials() {
		return null;
	}

	// not use
	@Override
	public Object getDetails() {
		return null;
	}
}
