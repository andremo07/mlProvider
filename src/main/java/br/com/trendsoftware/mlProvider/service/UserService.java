package br.com.trendsoftware.mlProvider.service;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.RestClientException;
import br.com.trendsoftware.mlClient.exception.ServiceException;
import br.com.trendsoftware.mlProvider.exception.AuthorizationException;
import br.com.trendsoftware.mlProvider.http.client.MeliClient.AuthUrls;

public class UserService extends MlService{

	public Response authorize(String clientId, String clientSecret, String code, String redirectUri) throws AuthorizationException {

		try {
			FluentStringsMap params = new FluentStringsMap();

			params.add("grant_type", "authorization_code");
			params.add("client_id", clientId);
			params.add("client_secret", clientSecret);
			params.add("code", code);
			params.add("redirect_uri", redirectUri);

			Response response = meli.post("/oauth/token", params,null);
			return response;
		} catch (RestClientException e) {	
			throw new AuthorizationException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()));
		}

	}

	public Response refreshAccessToken(String clientId, String clientSecret,String refreshToken) throws AuthorizationException {
		
		try{	
			FluentStringsMap params = new FluentStringsMap();
			params.add("grant_type", "refresh_token");
			params.add("client_id", clientId);
			params.add("client_secret", clientSecret);
			params.add("refresh_token", refreshToken);
			
			Response response = meli.post("/oauth/token", params,null);
			return response;
		} catch (RestClientException e) {	
			throw new AuthorizationException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()));
		}
		
	}

	public Response getUserInfo(String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.get("/users/me",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()), e);
		}

	}
	
	/**
	 * 
	 * @param callback: The callback URL. Must be the applications redirect URI 
	 * @param authUrl: The authorization URL. Get from Meli.AuthUrls
	 * @return the authorization URL
	 */
	public String getAuthUrl(String clientId, String callback, AuthUrls authUrl) {
		try {
			return authUrl.getValue() + "/authorization?response_type=code&client_id="
					+ clientId
					+ "&redirect_uri="
					+ URLEncoder.encode(callback, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return authUrl+"/authorization?response_type=code&client_id="
					+ clientId + "&redirect_uri=" + callback;
		}
	}

}
