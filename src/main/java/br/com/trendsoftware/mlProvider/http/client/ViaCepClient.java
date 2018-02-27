package br.com.trendsoftware.mlProvider.http.client;

import br.com.trendsoftware.restProvider.http.client.RestClient;

public class ViaCepClient extends RestClient{

	public static final String API_URL = "https://viacep.com.br";
	
	@Override
	public String getApiUrl() {	
		return API_URL;
	}

}
