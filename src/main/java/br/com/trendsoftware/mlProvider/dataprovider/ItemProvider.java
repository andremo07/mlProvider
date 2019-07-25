package br.com.trendsoftware.mlProvider.dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;

import br.com.trendsoftware.mlProvider.dto.Error;
import br.com.trendsoftware.mlProvider.dto.Item;
import br.com.trendsoftware.mlProvider.dto.ItemList;
import br.com.trendsoftware.mlProvider.dto.ItemResponse;
import br.com.trendsoftware.mlProvider.dto.ItemStatus;
import br.com.trendsoftware.mlProvider.dto.ItemUpdate;
import br.com.trendsoftware.mlProvider.dto.ListingType;
import br.com.trendsoftware.mlProvider.response.Response;
import br.com.trendsoftware.mlProvider.service.ItemService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.response.RestResponse;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class ItemProvider extends MlProvider{
	
	public RestResponse listUserProducts(String sellerId, ItemStatus itenStatus,Integer offSet, String accessToken) throws ProviderException{

		try {

			//getLogger().trace("searching user itens");
			
			ItemService itemService = new ItemService();

			long before = System.currentTimeMillis();

			org.asynchttpclient.Response rawResponse = itemService.getItens(sellerId,itenStatus.getName(),offSet.toString(),accessToken);

			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}

			long after = System.currentTimeMillis();
			
			Response<ItemList> response = Response.getPrototype(rawResponse, after - before);
			
			ItemList itens = getParser().fromJson(response.getBody(), ItemList.class);
			
			List<String> itensIds = itens.getItenIds();
			
			Long total = itens.getPaging().getTotal();
			
			int offset = 50;
			
			while(offset<total) 
			{
				rawResponse = itemService.getItens(sellerId,itenStatus.getName(),offSet.toString(),accessToken);
				response = Response.getPrototype(rawResponse, after - before);
				itens = getParser().fromJson(response.getBody(), ItemList.class);
				itensIds.addAll(itens.getItenIds());
				offset = offset + 50;
			}
			
			List<Item> ads =  new ArrayList<Item>();

			itensIds.forEach(itemId -> {
				Item item = null;
				try {
					item = searchItemById(itemId,accessToken);
				} catch (ProviderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ads.add(item);
			});
			
			//getLogger().trace(response.toString());

			return Response.getPrototype(rawResponse, after - before);
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
	
	public Item searchItemById(String itemId, String accessToken) throws ProviderException{

		try {

			getLogger().trace("searching item " + itemId);
			
			ItemService itemService = new ItemService();

			long before = System.currentTimeMillis();

			org.asynchttpclient.Response rawResponse = itemService.getItemById(itemId,accessToken);

			if(rawResponse.getStatusCode()!=HttpStatus.SC_OK){
				if(rawResponse.getResponseBody()!=null && !rawResponse.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(rawResponse.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(rawResponse.getStatusCode()+"-"+rawResponse.getStatusText());
			}

			long after = System.currentTimeMillis();
			
			Response<ItemList> response = Response.getPrototype(rawResponse, after - before);
			
			Item item = getParser().fromJson(response.getBody(), Item.class);

			getLogger().trace(response.toString());

			return item;
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
			
			ItemService itemService = new ItemService();

			long before = System.currentTimeMillis();

			org.asynchttpclient.Response response = itemService.add(getParser().toJson(item),accessToken);

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
			
			ItemService itemService = new ItemService();

			long before = System.currentTimeMillis();

			org.asynchttpclient.Response response = itemService.update(idItem,getParser().toJson(item),accessToken);

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
			
			ItemService itemService = new ItemService();

			long before = System.currentTimeMillis();

			org.asynchttpclient.Response response = itemService.changeListingType(idItem,getParser().toJson(listingType.getName()),accessToken);

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
			
			ItemService itemService = new ItemService();

			long before = System.currentTimeMillis();

			org.asynchttpclient.Response response = itemService.update(idItem,getParser().toJson(status.getName()),accessToken);

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
			
			ItemService itemService = new ItemService();

			org.asynchttpclient.Response response = itemService.validate(getParser().toJson(item),accessToken);

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
}
