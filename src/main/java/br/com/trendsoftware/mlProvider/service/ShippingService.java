package br.com.trendsoftware.mlProvider.service;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.RestClientException;
import br.com.trendsoftware.mlClient.exception.ServiceException;

public class ShippingService extends MlService{
		
	
	public Response getShippingById(String shippingId, String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.get("/shipments/"+shippingId,params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_SHIPPING_INFO, e.getMessage()), e);
		}
		
	}
	

}
