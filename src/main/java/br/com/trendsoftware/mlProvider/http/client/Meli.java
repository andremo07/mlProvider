package br.com.trendsoftware.mlProvider.http.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

import br.com.trendsoftware.mlProvider.exception.MeliException;

import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

public class Meli {

	public static String apiUrl = "https://api.mercadolibre.com";

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

	private String accessToken;
	private String refreshToken;
	private Long clientId;
	private String clientSecret;
	private AsyncHttpClient http;

	{
		AsyncHttpClientConfig cf = new AsyncHttpClientConfig.Builder()
				.setUserAgent("MELI-JAVA-SDK-0.0.4").build();
		http = new AsyncHttpClient(cf);
	} 

	public Meli(Long clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public Meli(Long clientId, String clientSecret, String accessToken) {
		this.accessToken = accessToken;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public Meli(Long clientId, String clientSecret, String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

	public Response get(String path) throws MeliException {
		return get(path, new FluentStringsMap());
	}

	private BoundRequestBuilder prepareGet(String path, FluentStringsMap params) {
		return http.prepareGet(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParams(params);
	}

	private BoundRequestBuilder prepareGet(String path, FluentStringsMap params, FluentCaseInsensitiveStringsMap headers) {
		headers.add("Accept", "application/json");
		return http.prepareGet(apiUrl + path)
				.setQueryParams(params).setHeaders(headers);
	}

	private BoundRequestBuilder prepareDelete(String path,
			FluentStringsMap params) {
		return http.prepareDelete(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParams(params);
	}

	private BoundRequestBuilder preparePost(String path,
			FluentStringsMap params, String body) {
		return http.preparePost(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParams(params)
				.setHeader("Content-Type", "application/json").setBody(body)
				.setBodyEncoding("UTF-8");
	}

	private BoundRequestBuilder preparePut(String path,
			FluentStringsMap params, String body) {
		return http.preparePut(apiUrl + path)
				.addHeader("Accept", "application/json")
				.setQueryParams(params)
				.setHeader("Content-Type", "application/json").setBody(body)
				.setBodyEncoding("UTF-8");
	}

	public Response get(String path, FluentStringsMap params, FluentCaseInsensitiveStringsMap headers) throws MeliException {

		BoundRequestBuilder r = prepareGet(path, params, headers);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}

		return response;
	}

	public Response get(String path, FluentStringsMap params) throws MeliException {

		BoundRequestBuilder r = prepareGet(path, params);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}

		return response;
	}

	/**
	 * 
	 * @param callback: The callback URL. Must be the applications redirect URI 
	 * @param authUrl: The authorization URL. Get from Meli.AuthUrls
	 * @return the authorization URL
	 */
	public String getAuthUrl(String callback, AuthUrls authUrl) {
		try {
			return authUrl.getValue() + "/authorization?response_type=code&client_id="
					+ clientId
					+ "&redirect_uri="
					+ URLEncoder.encode(callback, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return authUrl+"/authorization?response_type=code&client_id="
					+ clientId + "&redirect_uri=" + callback;
		}
	}

	public boolean hasRefreshToken() {
		return this.refreshToken != null && !this.refreshToken.isEmpty();
	}

	public Response post(String path, FluentStringsMap params, String body) throws MeliException {

		BoundRequestBuilder r = preparePost(path, params, body);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}


		return response;
	}

	public Response put(String path, FluentStringsMap params, String body) throws MeliException {

		BoundRequestBuilder r = preparePut(path, params, body);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}

		return response;
	}

	public Response delete(String path, FluentStringsMap params) throws MeliException {
		BoundRequestBuilder r = prepareDelete(path, params);

		Response response;
		try {
			response = r.execute().get();
		} catch (Exception e) {
			throw new MeliException(e);
		}

		return response;
	}

	public BoundRequestBuilder head(String path) {
		return null;
	}

	public BoundRequestBuilder options(String path) {
		return null;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
