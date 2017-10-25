package br.com.trendsoftware.mlProvider.dto;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Identification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5608228262424315366L;

	@SerializedName("type")
    @Expose
	private String type;
	
	@SerializedName("number")
    @Expose
	private String number;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
