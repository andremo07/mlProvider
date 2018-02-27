package br.com.trendsoftware.mlProvider.service;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.mlProvider.http.client.ViaCepClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class ShippingService extends MlService{
	
	ViaCepClient viaCepClient;
	
	public ShippingService(){
		viaCepClient = new ViaCepClient();
	}
	
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
	
	public Response getMunicipyCodeByCep(String cep) throws ServiceException{

		try {
			return viaCepClient.get(String.format("/ws/%s/json/", cep));
			
		} catch (RestClientException e) {
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_MUNICIPY_CODE, e.getMessage()), e);
		}
	}

}
