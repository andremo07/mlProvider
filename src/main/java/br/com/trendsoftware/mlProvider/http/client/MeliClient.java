package br.com.trendsoftware.mlProvider.http.client;

import br.com.trendsoftware.mlClient.http.client.RestClient;

public class MeliClient extends RestClient{

	public static final String API_URL = "https://api.mercadolibre.com";

	/**
	 *	Availables auth sites. One user - application can only operate in one site
	 *
	 */

	public static enum AuthUrls {
		
		MLB("https://auth.mercadolivre.com.br"); // Brasil

		private String value;

		private AuthUrls(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	};
	
	@Override
	public String getApiUrl() {	
		return API_URL;
	}

}
