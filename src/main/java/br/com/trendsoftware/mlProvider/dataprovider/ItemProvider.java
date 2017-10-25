package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;

import br.com.trendsoftware.mlClient.exception.MessageException;
import br.com.trendsoftware.mlClient.exception.ServiceException;
import br.com.trendsoftware.mlClient.exception.ProviderException;
import br.com.trendsoftware.mlClient.response.RestResponse;
import br.com.trendsoftware.mlClient.util.ExceptionUtil;
import br.com.trendsoftware.mlProvider.dto.Item;
import br.com.trendsoftware.mlProvider.dto.ItemResponse;
import br.com.trendsoftware.mlProvider.dto.ItemStatus;
import br.com.trendsoftware.mlProvider.dto.ItemUpdate;
import br.com.trendsoftware.mlProvider.dto.ListingType;
import br.com.trendsoftware.mlProvider.dto.Error;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.ItemService;

public class ItemProvider extends MlProvider{

	private ItemService itemService;
	
	public ItemProvider() {
		
		initializeService();
		
	}
	
	@Override
	protected void initializeService() {
	
		itemService = new ItemService();
	}
	
	public RestResponse listUserProducts(String sellerId, ItemStatus itenStatus,Integer offSet, String accessToken) throws ProviderException{

		try {

			getLogger().trace("searching user itens");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = itemService.getItens(sellerId,itenStatus.getName(),offSet.toString(),accessToken);

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
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
	public Response searchItemById(String itemId, String accessToken) throws ProviderException{

		try {

			getLogger().trace("searching item " + itemId);

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = itemService.getItemById(itemId,accessToken);

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
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
	public Response addItem(Item item, String accessToken) throws ProviderException{

		try {

			getLogger().trace("adding item");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = itemService.add(getParser().toJson(item),accessToken);

			if(response.getStatusCode()!=HttpStatus.SC_CREATED){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}
			
			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			Response mlResponse = Response.getPrototype(response, after - before);
						
			return mlResponse;
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
	public Response updateItem(String idItem, ItemUpdate item, String accessToken) throws ProviderException{

		try {

			getLogger().trace("adding item");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = itemService.update(idItem,getParser().toJson(item),accessToken);

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

			Response mlResponse = Response.getPrototype(response, after - before);
			
			mlResponse.setBody(getParser().toJson(item));
			
			return mlResponse;
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
	public Response changeItemListingType(String idItem, ListingType listingType, String accessToken) throws ProviderException{

		try {

			getLogger().trace("changing item listing type to "+ listingType.getName());

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = itemService.changeListingType(idItem,getParser().toJson(listingType.getName()),accessToken);

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

			Response mlResponse = Response.getPrototype(response, after - before);
						
			return mlResponse;
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
	public Response changeItemStatus(String idItem, ItemStatus status, String accessToken) throws ProviderException{

		try {

			getLogger().trace("changing item status to "+ status.getName());

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = itemService.update(idItem,getParser().toJson(status.getName()),accessToken);

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

			Response mlResponse = Response.getPrototype(response, after - before);
						
			return mlResponse;
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
	public Response validate(ItemResponse item, String accessToken) throws ProviderException{

		try {

			getLogger().trace("validate item publishing");

			long before = System.currentTimeMillis();

			com.ning.http.client.Response response = itemService.validate(getParser().toJson(item),accessToken);

			if(response.getStatusCode()!=HttpStatus.SC_NO_CONTENT){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}
			
			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			Response mlResponse = Response.getPrototype(response, after - before);
			
			mlResponse.setBody(getParser().toJson(item));
			
			return mlResponse;
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}
	
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}
