package br.com.trendsoftware.mlProvider.dto;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3658441270495588216L;
		
	@SerializedName("state")
    @Expose
	private String state;
	
	@SerializedName("city")
    @Expose
	private String city;
	
	@SerializedName("address")
    @Expose
	private String address;
	
	@SerializedName("zip_code")
    @Expose
	private String zipCode;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
