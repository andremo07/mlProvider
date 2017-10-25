package br.com.trendsoftware.mlProvider.service;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class OrderService extends MlService{
	
	public Response getOrderById(String orderId,String accessToken) throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			FluentCaseInsensitiveStringsMap headers = new FluentCaseInsensitiveStringsMap();
			headers.add("x-format-new", "true");
			params.add("access_token", accessToken);
			Response response = meli.get("/orders/"+orderId,params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getOrdersByDate(String sellerId, String begin, String end, String orderStatus, String offset,String accessToken) throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("seller", sellerId);
			params.add("order.status", orderStatus);
			params.add("order.date_created.from", begin);
			params.add("order.date_created.to", end);
			params.add("offset", offset);
			params.add("access_token", accessToken);
			params.add("sort", "date_desc");
			Response response = meli.get("/orders/search",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getRecentOrders(String sellerId,String accessToken) throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("seller", sellerId);
			params.add("access_token", accessToken);
			params.add("sort", "date_desc");
			Response response = meli.get("/orders/recent",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getOrderMessages(String orderId,String accessToken) throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("access_token", accessToken);
			Response response = meli.get("/messages/orders/"+orderId,params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER_MESSAGES, e.getMessage()), e);
		}
		
	}
	

}
