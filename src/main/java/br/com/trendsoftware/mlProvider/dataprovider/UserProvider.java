package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.MlServiceException;
import br.com.trendsoftware.mlClient.exception.ProviderException;
import br.com.trendsoftware.mlClient.ml.dto.Error;
import br.com.trendsoftware.mlClient.util.ExceptionUtil;
import br.com.trendsoftware.mlProvider.exception.AuthorizationException;
import br.com.trendsoftware.mlProvider.http.client.Meli;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.UserService;

public class UserProvider extends MlProvider{

	private UserService userService;
	
	public UserProvider(){
		initializeService();
	}
	
	@Override
	protected void initializeService() {
		Meli meli =  new Meli(clientId,clientSecret);
		userService = new UserService(meli);
	}

	public Response login(String code, String redirectUri) throws ProviderException{
		
		try {

			getLogger().trace("searching user info");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = userService.authorize(String.valueOf(clientId),clientSecret,code,redirectUri);

			if(response.getStatusCode()!=HttpStatus.SC_OK){
				Error error = getParser().fromJson(response.getResponseBody(), Error.class);
				throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return Response.getPrototype(response, after - before);
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
	
	public Response login(String refreshToken) throws ProviderException{
		
		try {

			getLogger().trace("searching user info");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = userService.refreshAccessToken(String.valueOf(clientId),clientSecret,refreshToken);

			if(response.getStatusCode()!=HttpStatus.SC_OK){
				Error error = getParser().fromJson(response.getResponseBody(), Error.class);
				throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return Response.getPrototype(response, after - before);
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

			com.ning.http.client.Response response = userService.getUserInfo(accessToken);

			if(response.getStatusCode()!=HttpStatus.SC_OK){
				Error error = getParser().fromJson(response.getResponseBody(), Error.class);
				throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return Response.getPrototype(response, after - before);
		}
		catch (MlServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
