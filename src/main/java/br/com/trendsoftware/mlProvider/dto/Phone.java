package br.com.trendsoftware.mlProvider.dto;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 882727523221061366L;

	@SerializedName("area_code")
    @Expose
	private String areaCode;
	
	@SerializedName("number")
    @Expose
	private String number;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
