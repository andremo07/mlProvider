package br.com.trendsoftware.mlProvider.service;

import java.util.List;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

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
	
	public Response getShippingTags(List<String> listShippingIds, String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			params.add("savePdf", "Y");
			
			StringBuilder shippingIds = new StringBuilder();
			if(!listShippingIds.isEmpty()){
				String prefix = "";
				for(String shippingId: listShippingIds){
					shippingIds.append(prefix);
					prefix = ",";
					shippingIds.append(shippingId);
				}
			}
			params.add("shipment_ids", shippingIds.toString());
			
			Response response = meli.get("/shipment_labels",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_SHIPPING_INFO, e.getMessage()), e);
		}
		
	}	

}
