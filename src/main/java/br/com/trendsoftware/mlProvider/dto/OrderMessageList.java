package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderMessageList {
	
	@SerializedName("paging")
	@Expose
	private Paging paging;
	
    @SerializedName("results")
    @Expose
    private List<OrderMessage> orderMessages = null;

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public List<OrderMessage> getOrderMessages() {
		return orderMessages;
	}

	public void setOrderMessages(List<OrderMessage> orderMessages) {
		this.orderMessages = orderMessages;
	}
	
}
