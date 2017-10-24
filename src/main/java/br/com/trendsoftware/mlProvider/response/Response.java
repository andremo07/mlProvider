package br.com.trendsoftware.mlProvider.response;

import java.io.IOException;

import br.com.trendsoftware.mlClient.response.RestResponse;

public class Response extends RestResponse
{	
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
	
}
