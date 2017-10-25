package br.com.trendsoftware.mlProvider.service;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.RestClientException;
import br.com.trendsoftware.mlClient.exception.ServiceException;

public class ItemService extends MlService{


	public Response getItemById(String itemId,String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.get("/items/"+itemId,params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITEM, e.getMessage()), e);
		}

	}

	public Response getItens(String sellerId, String itemStatus, String offset,String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("offset", offset);
			params.add("status", itemStatus);
			params.add("access_token", accessToken);
			Response response = meli.get("/users/"+sellerId+"/items/search",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}

	}
	
	public Response validate(String json,String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.post("/items/validate",params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}

	} 
	
	public Response add(String json,String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.post("/items",params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_ADD_ITEM, e.getMessage()), e);
		}
		
	} 
	
	public Response update(String idItem, String json,String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.put("/items/"+idItem,params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_UPDATE_ITEM, e.getMessage()), e);
		}
		
	}
	
	public Response changeListingType(String idItem, String json,String accessToken)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.post("/items/"+idItem+"/listing_type",params, json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_ADD_ITEM, e.getMessage()), e);
		}
		
	}

}
