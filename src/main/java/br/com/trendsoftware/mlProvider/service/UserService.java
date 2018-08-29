package br.com.trendsoftware.mlProvider.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.mlProvider.exception.AuthorizationException;
import br.com.trendsoftware.mlProvider.http.client.MeliClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class UserService extends MlService{

	public Response authorize(String clientId, String clientSecret, String code, String redirectUri) throws AuthorizationException {

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();

			params.put("grant_type", Collections.singletonList("authorization_code"));
			params.put("client_id", Collections.singletonList(clientId));
			params.put("client_secret", Collections.singletonList(clientSecret));
			params.put("code", Collections.singletonList(code));
			params.put("redirect_uri", Collections.singletonList(redirectUri));

			Response response = MeliClient.post(MeliClient.API_URL,"/oauth/token", params,null);
			return response;
		} catch (RestClientException e) {	
			throw new AuthorizationException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()));
		}

	}

	public Response refreshAccessToken(String clientId, String clientSecret,String refreshToken) throws AuthorizationException {
		
		try{	
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("grant_type", Collections.singletonList("refresh_token"));
			params.put("client_id", Collections.singletonList(clientId));
			params.put("client_secret", Collections.singletonList(clientSecret));
			params.put("refresh_token", Collections.singletonList(refreshToken));
			
			Response response = MeliClient.post(MeliClient.API_URL,"/oauth/token", params,null);
			return response;
		} catch (RestClientException e) {	
			throw new AuthorizationException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()));
		}
		
	}

	public Response getUserInfo(String accessToken)throws ServiceException{
		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.get(MeliClient.API_URL,"/users/me",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()), e);
		}
	}
}
