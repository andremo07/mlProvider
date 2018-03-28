package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;

import com.google.gson.JsonSyntaxException;

import br.com.trendsoftware.mlProvider.dto.Error;
import br.com.trendsoftware.mlProvider.dto.ItemResponse;
import br.com.trendsoftware.mlProvider.dto.Order;
import br.com.trendsoftware.mlProvider.dto.OrderItem;
import br.com.trendsoftware.mlProvider.dto.OrderList;
import br.com.trendsoftware.mlProvider.dto.OrderStatus;
import br.com.trendsoftware.mlProvider.dto.Shipping;
import br.com.trendsoftware.mlProvider.dto.ShippingStatus;
import br.com.trendsoftware.mlProvider.dto.ShippingSubStatus;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.ItemService;
import br.com.trendsoftware.mlProvider.service.OrderService;
import br.com.trendsoftware.mlProvider.service.ShippingService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class OrderProvider extends MlProvider{

	private OrderService orderService;

	private ItemService itemService;

	private ShippingService shippingService;

	public OrderProvider(){
		initializeService();
	}

	@Override
	protected void initializeService() {
		orderService = new OrderService();
		itemService = new ItemService();
		shippingService = new ShippingService();
	}

	public Response searchOrderById(String userId, String orderId, String accessToken) throws ProviderException {

		try {

			getLogger().trace("searching order by id="+orderId);

			long before = System.currentTimeMillis();

			com.ning.http.client.Response rawResponse = orderService.getOrderById(userId,orderId,accessToken);

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

			OrderList orderList = getParser().fromJson(response.getBody(), OrderList.class);
			Order order = orderList.getOrders().get(0);

			setOrderItensCompletedInfo(order, accessToken);
			setOrderShippingInfo(order, accessToken);

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

	public Response listOrdersByDate(String sellerId, Date fromDt, Date toDate, OrderStatus orderStatus, Integer offset, Integer limit, String accessToken) throws ProviderException {

		try {

			getLogger().trace("searching orders from "+fromDt+" to "+toDate);

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			String fromDtString = dateFormat.format(fromDt);
			String toDateString = dateFormat.format(toDate);

			long before = System.currentTimeMillis();

			com.ning.http.client.Response rawResponse = orderService.getOrdersByDate(sellerId,fromDtString,toDateString,orderStatus.getName(),offset.toString(), limit.toString(),accessToken);

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

			for(Order order: orders){
				setOrderItensCompletedInfo(order, accessToken);
				setOrderShippingInfo(order, accessToken);
			}

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

	public Response listOrdersByShippingStatus(String sellerId,  ShippingStatus shippingStatus, ShippingSubStatus shippingSubStatus, Integer offset, Integer limit, String accessToken) throws ProviderException {

		try {

			getLogger().trace("searching "+ shippingStatus.getName() + " orders");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response rawResponse = orderService.getOrdersByShippingStatus(sellerId,shippingStatus.getName(),shippingSubStatus.getName(),offset.toString(), limit.toString(),accessToken);

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
			for(Order order: orders){
				setOrderItensCompletedInfo(order, accessToken);
				setOrderShippingInfo(order, accessToken);
			}

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
			for(Order order: orders){
				setOrderItensCompletedInfo(order, accessToken);
				setOrderShippingInfo(order, accessToken);
			}

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
			String sku = orderItem.getItem().getSellerCustomField();
			com.ning.http.client.Response rawResponse = itemService.getItemById(orderItem.getItem().getId(), accessToken);
			ItemResponse item  = getParser().fromJson(rawResponse.getResponseBody(), ItemResponse.class);
			item.setSellerCustomField(sku);
			orderItem.setItem(item);		
		}

	}

	private void setOrderShippingInfo(Order order, String accessToken) throws ServiceException, JsonSyntaxException, IOException{
		if(order.getShipping().getId()!=null){
			String shippingId = order.getShipping().getId().toString();
			com.ning.http.client.Response rawResponse = shippingService.getShippingById(shippingId, accessToken);
			Shipping shipping = getParser().fromJson(rawResponse.getResponseBody(), Shipping.class);
			order.setShipping(shipping);
		}
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
