package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserCredencials {
	
	@SerializedName("access_token")
	@Expose
	private String accessToken;
	
	@SerializedName("refresh_token")
	@Expose
	private String refreshToken;
	
	@SerializedName("expires_in")
	@Expose
	private Long   expiresIn;
	
	@SerializedName("scope")
	@Expose
	private String scope;
	
	@SerializedName("user_id")
	@Expose
	private String userId;
	
	@SerializedName("token_type")
	@Expose
	private String tokenType;
	
	public UserCredencials(){
		
	}
		
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
		
}
