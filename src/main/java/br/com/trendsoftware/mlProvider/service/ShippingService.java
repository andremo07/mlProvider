package br.com.trendsoftware.mlProvider.service;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.MlServiceException;
import br.com.trendsoftware.mlProvider.exception.MeliException;

public class ShippingService extends MlService{
		
	
	public Response getShippingById(String shippingId, String accessToken)throws MlServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.get("/shipments/"+shippingId,params);
			return response;	
		} catch (MeliException e) {	
			throw new MlServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_SHIPPING_INFO, e.getMessage()), e);
		}
		
	}
	

}
