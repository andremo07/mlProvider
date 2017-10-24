package br.com.trendsoftware.mlProvider.service;


import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.MlServiceException;
import br.com.trendsoftware.mlProvider.exception.AuthorizationException;
import br.com.trendsoftware.mlProvider.exception.MeliException;
import br.com.trendsoftware.mlProvider.http.client.Meli;

public class UserService extends MlService{

	public UserService(Meli meli){

		this.meli = meli;

	}

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
		} catch (MeliException e) {	
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
		} catch (MeliException e) {	
			throw new AuthorizationException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()));
		}
		
	}

	public Response getUserInfo(String accessToken)throws MlServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.get("/users/me",params);
			return response;	
		} catch (MeliException e) {	
			throw new MlServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()), e);
		}

	}


}
