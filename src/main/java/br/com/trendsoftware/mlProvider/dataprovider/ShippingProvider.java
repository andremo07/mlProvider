package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.MlServiceException;
import br.com.trendsoftware.mlClient.exception.ProviderException;
import br.com.trendsoftware.mlClient.ml.dto.Error;
import br.com.trendsoftware.mlClient.util.ExceptionUtil;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.ShippingService;

public class ShippingProvider extends MlProvider{

	private ShippingService shippingService;
	
	public ShippingProvider(){
		initializeService();
	}
	
	@Override
	protected void initializeService() {
		
		shippingService = new ShippingService();
	}
	
	public Response searchShippingById(String shippingId,String accessToken) throws ProviderException{

		try {

			getLogger().trace("searching user info");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = shippingService.getShippingById(shippingId,accessToken);

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

	public void setShippingService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

}
