package br.com.trendsoftware.mlProvider.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.mlProvider.http.client.MeliClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class ItemService extends MlService{


	public Response getItemById(String itemId,String accessToken)throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.get(MeliClient.API_URL,"/items/"+itemId,params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITEM, e.getMessage()), e);
		}

	}

	public Response getItens(String sellerId, String itemStatus, String offset,String accessToken)throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("offset", Collections.singletonList(offset));
			params.put("status", Collections.singletonList(itemStatus));
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.get(MeliClient.API_URL,"/users/"+sellerId+"/items/search",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}

	}
	
	public Response validate(String json,String accessToken)throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.post(MeliClient.API_URL,"/items/validate",params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}

	} 
	
	public Response add(String json,String accessToken)throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.post(MeliClient.API_URL,"/items",params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_ADD_ITEM, e.getMessage()), e);
		}
		
	} 
	
	public Response update(String idItem, String json,String accessToken)throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.put(MeliClient.API_URL,"/items/"+idItem,params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_UPDATE_ITEM, e.getMessage()), e);
		}
		
	}
	
	public Response changeListingType(String idItem, String json,String accessToken)throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token", Collections.singletonList(accessToken));
			Response response = MeliClient.post(MeliClient.API_URL,"/items/"+idItem+"/listing_type",params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_ADD_ITEM, e.getMessage()), e);
		}
		
	}

}
