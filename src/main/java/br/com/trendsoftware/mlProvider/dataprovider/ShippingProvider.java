package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.trendsoftware.mlProvider.dto.Error;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.ShippingService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class ShippingProvider extends MlProvider{

	public Response searchShippingById(String shippingId,String accessToken) throws ProviderException{

		try {

			getLogger().trace("searching user info");
			
			ShippingService shippingService = new ShippingService();

			long before = System.currentTimeMillis();

			org.asynchttpclient.Response response = shippingService.getShippingById(shippingId,accessToken);

			if(response.getStatusCode()!=HttpStatus.SC_OK){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return Response.getPrototype(response, after - before);
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

	public InputStream printTags(List<String> listShippingIds,String accessToken) throws ProviderException{

		try {

			getLogger().trace("printing shipping tags");
			
			ShippingService shippingService = new ShippingService();

			org.asynchttpclient.Response response = shippingService.getShippingTags(listShippingIds, accessToken);

			if(response.getStatusCode()!=HttpStatus.SC_OK)
				throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());

			getLogger().trace(response.toString());

			return response.getResponseBodyAsStream();
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}

	}

	
	public Integer searchMunicipyCodeByCep(String cep) throws ProviderException{

		try {

			getLogger().trace("searching municipy code of cep "+cep.toString());
			
			ShippingService shippingService = new ShippingService();

			org.asynchttpclient.Response response = shippingService.getMunicipyCodeByCep(cep);

			if(response.getStatusCode()!=HttpStatus.SC_OK){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}
			
			JsonObject jsonObject = getParser().fromJson(response.getResponseBody(), JsonObject.class);
			JsonElement jsonCodMunicipio = jsonObject.get("ibge");
			
			getLogger().trace(response.toString());

			return jsonCodMunicipio.getAsInt();
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}

	}
}
