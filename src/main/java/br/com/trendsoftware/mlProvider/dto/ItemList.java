package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {
	
	@SerializedName("paging")
	@Expose
	private Paging paging;
	
    @SerializedName("results")
    @Expose
    private List<String> itenIds = null;

    
	public List<String> getItenIds() {
		return itenIds;
	}

	public void setItenIds(List<String> itenIds) {
		this.itenIds = itenIds;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
}
