package br.com.trendsoftware.mlProvider.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.mlProvider.http.client.MeliClient;
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
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.get(MeliClient.API_URL,"/shipments/"+shippingId,params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_SHIPPING_INFO, e.getMessage()), e);
		}
		
	}
	
	public Response getShippingTags(List<String> listShippingIds, String accessToken)throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			params.put("savePdf", Collections.singletonList("Y"));
			
			StringBuilder shippingIds = new StringBuilder();
			if(!listShippingIds.isEmpty()){
				String prefix = "";
				for(String shippingId: listShippingIds){
					shippingIds.append(prefix);
					prefix = ",";
					shippingIds.append(shippingId);
				}
			}
			params.put("shipment_ids", Collections.singletonList(shippingIds.toString()));
			
			Response response = MeliClient.get(MeliClient.API_URL,"/shipment_labels",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_SHIPPING_INFO, e.getMessage()), e);
		}
		
	}	
	
	public Response getMunicipyCodeByCep(String cep) throws ServiceException{

		try {
			return ViaCepClient.get(ViaCepClient.API_URL,String.format("/ws/%s/json/", cep));
			
		} catch (RestClientException e) {
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_MUNICIPY_CODE, e.getMessage()), e);
		}
	}

}
