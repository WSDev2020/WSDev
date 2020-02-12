package com.study.wsdev.config.social;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@Configuration
public class GoogleConfiguration{
	
	/** application identify ID */
	@Value("${security.prop.google.clientId}")
	private String app_id;
	
	/** application secret key */
	@Value("${security.prop.google.apikey}")
	private String app_key;
	
	/** application use resource Scope only read and find ID */
	@Value("${security.prop.google.scope}")
	private String app_scope;
	
	/** application callback redirect URL-PATH */
	@Value("${security.prop.google.redirectUrl}")
	private String app_redirectUrl;
	
	/**
	 * <h3>Token response object to return a token information</h3>
	 * 
	 * @version 1.0.0
	 * @since 1/24/20
	 * 
	 * @author Justin hanry
	 */
	public class GoogleAuthorizationTokenRequestUrl {
		
		private GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow;
		private String redirectUri;

		public GoogleAuthorizationTokenRequestUrl(GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow, String redirectUri) {
			
			this.googleAuthorizationCodeFlow = googleAuthorizationCodeFlow;
			this.redirectUri = redirectUri;
		}
		
		public GoogleAuthorizationCodeTokenRequest newTokenRequest(String authorizationCode) {
			
			return googleAuthorizationCodeFlow.newTokenRequest(authorizationCode)
					                          .setRedirectUri(this.redirectUri);
		}
	}

	/**
	 * <p> authentication url(usr info) </p>
	 * @return
	 */
	@Bean("usrUrl")
	public GenericUrl getUserinforationUrl() {
		return new GenericUrl("https://www.googleapis.com/oauth2/v2/userinfo");      // Make an authenticated request.
	}


	/**
	 * <p> builder on google application authenticate </p>
	 * @return
	 */
	@Bean
	public GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow() {

		return new GoogleAuthorizationCodeFlow.Builder(
				  new NetHttpTransport()
				, new JacksonFactory()
				, app_id
				, app_key
				, Arrays.asList(app_scope.split(","))).build();
	}
	
	/**
	 * <p> google flow request URL </p>
	 * @param googleAuthorizationCodeFlow
	 * @return
	 */
	@Bean
	public GoogleAuthorizationCodeRequestUrl googleAuthorizationCodeRequestUrl(GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow) {
		
		return googleAuthorizationCodeFlow.newAuthorizationUrl()
				                          .setAccessType("offline")
				                          .setApprovalPrompt("force")
                                          .setRedirectUri(app_redirectUrl);
	}

	/**
	 * <p> google refresh token update </p>
	 * @param googleAuthorizationCodeFlow
	 * @return
	 */
	@Bean
	public GoogleAuthorizationTokenRequestUrl googleAuthorizationTokenRequestUrl(GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow) {

		return new GoogleAuthorizationTokenRequestUrl(googleAuthorizationCodeFlow, app_redirectUrl);
	}
}