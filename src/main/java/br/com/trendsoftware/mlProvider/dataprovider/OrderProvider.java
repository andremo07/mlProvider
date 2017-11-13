package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;

import com.google.gson.JsonSyntaxException;

import br.com.trendsoftware.mlProvider.dto.Error;
import br.com.trendsoftware.mlProvider.dto.ItemResponse;
import br.com.trendsoftware.mlProvider.dto.Order;
import br.com.trendsoftware.mlProvider.dto.OrderItem;
import br.com.trendsoftware.mlProvider.dto.OrderList;
import br.com.trendsoftware.mlProvider.dto.OrderStatus;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.ItemService;
import br.com.trendsoftware.mlProvider.service.OrderService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class OrderProvider extends MlProvider{

	private OrderService orderService;
	
	private ItemService itemService;

	public OrderProvider(){
		initializeService();
	}
	
	@Override
	protected void initializeService() {
		
		orderService = new OrderService();
		itemService = new ItemService();
	}
	
	public Response searchOrderById(String orderId, String accessToken) throws ProviderException {

		try {

			getLogger().trace("searching order by id="+orderId);

			long before = System.currentTimeMillis();

			com.ning.http.client.Response rawResponse = orderService.getOrderById(orderId,accessToken);
			
			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(rawResponse.toString());

			Response<Order> response = Response.getPrototype(rawResponse, after - before);
			
			Order order = getParser().fromJson(response.getBody(), Order.class);
			
			setOrderItensCompletedInfo(order, accessToken);
			
			response.setData(order);

			return response;

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public Response listOrdersByDate(String sellerId, String fromDt, String toDate, OrderStatus orderStatus, Integer page, String accessToken) throws ProviderException {

		try {

			getLogger().trace("searching orders from "+fromDt+" to "+toDate);

			long before = System.currentTimeMillis();
			
			com.ning.http.client.Response rawResponse = orderService.getOrdersByDate(sellerId,fromDt,toDate,orderStatus.getName(),page.toString(),accessToken);
			
			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(rawResponse.toString());
			
			Response<OrderList> response = Response.getPrototype(rawResponse, after - before);
			
			OrderList orderList = getParser().fromJson(response.getBody(), OrderList.class);
			
			List<Order> orders = orderList.getOrders();
			for(Order order: orders)
				setOrderItensCompletedInfo(order, accessToken);
			
			response.setData(orderList);

			return response;

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public Response searchRecentOrders(String sellerId, String accessToken) throws ProviderException {

		try {

			getLogger().trace("searching recent orders");

			long before = System.currentTimeMillis();
			
			com.ning.http.client.Response rawResponse = orderService.getRecentOrders(sellerId,accessToken);
			
			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(rawResponse.toString());
			
			Response<OrderList> response = Response.getPrototype(rawResponse, after - before);
			
			OrderList orderList = getParser().fromJson(response.getBody(), OrderList.class);
			
			List<Order> orders = orderList.getOrders();
			for(Order order: orders)
				setOrderItensCompletedInfo(order, accessToken);
			
			response.setData(orderList);

			return response;

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	private void setOrderItensCompletedInfo(Order order, String accessToken) throws ServiceException, JsonSyntaxException, IOException{
		
		List<OrderItem> ordemItens = order.getOrderItems();
		for(OrderItem orderItem: ordemItens){	
			com.ning.http.client.Response rawResponse = itemService.getItemById(orderItem.getItem().getId(), accessToken);
			ItemResponse item  = getParser().fromJson(rawResponse.getResponseBody(), ItemResponse.class);
			orderItem.setItem(item);		
		}
	
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
