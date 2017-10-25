package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.ServiceException;
import br.com.trendsoftware.mlClient.exception.ProviderException;
import br.com.trendsoftware.mlClient.util.ExceptionUtil;
import br.com.trendsoftware.mlProvider.dto.OrderStatus;
import br.com.trendsoftware.mlProvider.dto.Error;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.OrderService;

public class OrderProvider extends MlProvider{

	private OrderService orderService;

	public OrderProvider(){
		initializeService();
	}
	
	@Override
	protected void initializeService() {
		
		orderService = new OrderService();
	}
	
	public Response searchOrderById(String orderId, String accessToken) throws ProviderException {

		try {

			getLogger().trace("searching order by id="+orderId);

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = orderService.getOrderById(orderId,accessToken);
			
			if(response.getStatusCode()!=HttpStatus.SC_OK){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return Response.getPrototype(response, after - before);

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
			
			com.ning.http.client.Response response = orderService.getOrdersByDate(sellerId,fromDt,toDate,orderStatus.getName(),page.toString(),accessToken);
			
			if(response.getStatusCode()!=HttpStatus.SC_OK){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return Response.getPrototype(response, after - before);

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
			
			com.ning.http.client.Response response = orderService.getRecentOrders(sellerId,accessToken);
			
			if(response.getStatusCode()!=HttpStatus.SC_OK){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return Response.getPrototype(response, after - before);

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
