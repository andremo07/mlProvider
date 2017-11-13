package br.com.trendsoftware.mlProvider.response;

import java.io.IOException;

import br.com.trendsoftware.restProvider.response.RestResponse;

public class Response<T> extends RestResponse
{	
	private T data;
	
	public boolean isResponseOK() {
		return getStatusCode().equals(200);
	}
	
	public static Response getPrototype(com.ning.http.client.Response response, Long timeLapsed) throws IOException
	{
		Response mlReponse = new Response();
		
		mlReponse.setBody(response.getResponseBody());
		mlReponse.setContentType(response.getContentType());
		mlReponse.setStatusCode(response.getStatusCode());
		mlReponse.setStatusMessage(response.getStatusText());
		mlReponse.setTimeLapsed(timeLapsed);
		
		return mlReponse;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
