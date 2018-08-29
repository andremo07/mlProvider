package br.com.trendsoftware.mlProvider.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.mlProvider.dto.OrderStatus;
import br.com.trendsoftware.mlProvider.http.client.MeliClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class OrderService extends MlService{
	
	public Response getOrderById(String sellerId,String orderId,String accessToken) throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			Map<String,String> headers = new HashMap<String,String>();
			headers.put("x-format-new", "true");
			params.put("access_token", Collections.singletonList(accessToken));
			params.put("seller",  Collections.singletonList(sellerId));
			params.put("q", Collections.singletonList(orderId));
			Response response = MeliClient.get(MeliClient.API_URL,"/orders/search",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getOrdersByDate(String sellerId, String begin, String end, String orderStatus, String offset, String limit, String accessToken) throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("seller",  Collections.singletonList(sellerId));
			params.put("order.status",  Collections.singletonList(orderStatus));
			params.put("order.date_created.from",  Collections.singletonList(begin));
			params.put("order.date_created.to",  Collections.singletonList(end));
			params.put("offset",  Collections.singletonList(offset));
			params.put("limit",  Collections.singletonList(limit));
			params.put("access_token",  Collections.singletonList(accessToken));
			params.put("sort",  Collections.singletonList("date_desc"));
			Response response = MeliClient.get(MeliClient.API_URL,"/orders/search",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getRecentOrders(String sellerId,String accessToken) throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("seller",  Collections.singletonList(sellerId));
			params.put("access_token",  Collections.singletonList(accessToken));
			params.put("sort",  Collections.singletonList("date_desc"));
			Response response = MeliClient.get(MeliClient.API_URL,"/orders/search/recent",params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getOrdersByShippingStatus(String sellerId, String shippingStatus, String shippingSubStatus, String offset, String limit, String accessToken) throws ServiceException{
		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			Map<String,String> headers = new HashMap<String,String>();
			headers.put("x-format-new", "true");
			params.put("seller",  Collections.singletonList(sellerId));
			params.put("access_token",  Collections.singletonList(accessToken));
			params.put("order.status",  Collections.singletonList(OrderStatus.PAID.getName()));
			params.put("shipping.status",  Collections.singletonList(shippingStatus));
			//params.put("shipping.substatus", shippingSubStatus);
			params.put("offset",  Collections.singletonList(offset));
			params.put("limit",  Collections.singletonList(limit));
			params.put("sort",  Collections.singletonList("date_desc"));
			Response response = MeliClient.get(MeliClient.API_URL,"/orders/search/recent",params,headers);
			return response;
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}

	}
	
	public Response getOrderMessages(String orderId,String accessToken) throws ServiceException{

		try {
			Map<String,List<String>> params = new HashMap<String,List<String>>();
			params.put("access_token",  Collections.singletonList(accessToken));
			Response response = MeliClient.get(MeliClient.API_URL,"/messages/orders/"+orderId,params);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER_MESSAGES, e.getMessage()), e);
		}
		
	}
	

}
