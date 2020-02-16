package com.study.wsdev.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.study.wsdev.config.social.GoogleConfiguration.GoogleAuthorizationTokenRequestUrl;
import com.study.wsdev.utils.ServiceUtils;
import com.study.wsdev.vo.Modules;
import com.study.wsdev.vo.User;

/**
 * <p> login connection controller </p>
 * 
 * @version 1.0.0
 * @since 2/02/20
 * 
 * @author Justin hanry
 * @author Lily
 * @author NHW
 * @author Dexter
 * @author Jizero
 */
@Controller
public class LoginController {
	
	/** connection repository */
	@Autowired
    private GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow;
	
	/** connection new Token */
	@Autowired
	@Qualifier("googleAuthorizationCodeRequestUrl")
	private GoogleAuthorizationCodeRequestUrl googleAuthorizationCodeRequestUrl;

	/** connection reflash Token */
	@Autowired
	@Qualifier("googleAuthorizationTokenRequestUrl")
	private GoogleAuthorizationTokenRequestUrl googleAuthorizationTokenRequestUrl;

    @GetMapping("/login")
	public String form_login() {

		return Modules.IDENTI.getPath("/login");
	}

    @GetMapping("/login/google")
    public String google(HttpServletRequest req) {
    	
    	if(Objects.isNull(req.getSession().getAttribute("userInfo"))) {

	    	String state = ServiceUtils.getSecureTokenCode();
	    	
	    	String url = googleAuthorizationCodeRequestUrl.setState(state)
	    			                                      .build();

	    	req.getSession().setAttribute("state", state);
	
	    	return "redirect:"+url;
    	} else {

	    	return "redirect:/";
    	}
    }
    
    @RequestMapping(value="/login/googleSignin", method={RequestMethod.GET, RequestMethod.POST})
    public String google_signin(HttpServletRequest request, HttpServletResponse resp
    		                  , @RequestParam("code") String authorizationCode) throws IOException {

        if (request.getSession().getAttribute("state") == null
            || !request.getParameter("state").equals((String) request.getSession().getAttribute("state"))) {

          resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

      	  return "redirect:/";
        }

        request.getSession().removeAttribute("state");     // Remove one-time use state.

        final TokenResponse tokenResponse = googleAuthorizationTokenRequestUrl.newTokenRequest(authorizationCode).execute();
        final Credential credential = googleAuthorizationCodeFlow.createAndStoreCredential(tokenResponse, null);
        final HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory(credential);

        final GenericUrl url         = new GenericUrl("https://www.googleapis.com/oauth2/v2/userinfo");      // Make an authenticated request.
        final HttpRequest httpReqest = requestFactory.buildGetRequest(url);

        httpReqest.getHeaders().setContentType("application/json");

        final String jsonIdentity = httpReqest.execute().parseAsString();

        HashMap<String, String> userIdResult = new ObjectMapper().readValue(jsonIdentity, HashMap.class);

        User usr = new User();
        
        usr.setAUTH_G("G");
        usr.setUSR_ID(userIdResult.get("id"));
        usr.setUSR_NM(userIdResult.get("name"));
        usr.setUSR_EMAIL(userIdResult.get("email"));
        usr.setLOGIN_IP(request.getRemoteAddr());

        // From this map, extract the relevant profile info and store it in the session.
        request.getSession().setAttribute("usr", usr);
        
    	return "redirect:/";
    }
    
}
