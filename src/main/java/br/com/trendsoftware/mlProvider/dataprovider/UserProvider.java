package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;

import br.com.trendsoftware.mlProvider.dto.Error;
import br.com.trendsoftware.mlProvider.dto.User;
import br.com.trendsoftware.mlProvider.dto.UserToken;
import br.com.trendsoftware.mlProvider.exception.AuthorizationException;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.UserService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class UserProvider extends MlProvider{

	private UserService userService;
	
	public UserProvider(){
		initializeService();
	}
	
	@Override
	protected void initializeService() {
		userService = new UserService();
	}

	public Response login(Long clientId, String clientSecret, String code, String redirectUri) throws ProviderException{
		
		try {

			getLogger().trace("searching user info");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response rawResponse = userService.authorize(String.valueOf(clientId),clientSecret,code,redirectUri);

			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}
			
			long after = System.currentTimeMillis();
			
			Response response = Response.getPrototype(rawResponse, after - before);
			
			UserToken token = getParser().fromJson(response.getBody(), UserToken.class);
			
			response.setData(token);

			getLogger().trace(rawResponse.toString());

			return response;
		}
		catch (AuthorizationException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}
		
	}
	
	public Response login(String clientId, String clientSecret, String refreshToken) throws ProviderException{
		
		try {

			getLogger().trace("searching user info");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response rawResponse = userService.refreshAccessToken(String.valueOf(clientId),clientSecret,refreshToken);

			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}

			long after = System.currentTimeMillis();
			
			Response response = Response.getPrototype(rawResponse, after - before);
			
			UserToken token = getParser().fromJson(response.getBody(), UserToken.class);
			
			response.setData(token);

			getLogger().trace(response.toString());

			return response;
		}
		catch (AuthorizationException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}
		
	}
	
	public Response getUserInfo(String accessToken) throws ProviderException{

		try {

			getLogger().trace("searching user info");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response rawResponse = userService.getUserInfo(accessToken);

			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}
			
			long after = System.currentTimeMillis();
			
			Response response = Response.getPrototype(rawResponse, after - before);
			
			User user = getParser().fromJson(response.getBody(), User.class);
			
			response.setData(user);

			getLogger().trace(response.toString());

			return response;
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
}
