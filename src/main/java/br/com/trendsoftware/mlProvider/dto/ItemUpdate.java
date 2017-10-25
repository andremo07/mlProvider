
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemUpdate {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("available_quantity")
    @Expose
    private Long availableQuantity;
    @SerializedName("buying_mode")
    @Expose
    private String buyingMode;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;
    @SerializedName("video_id")
    @Expose
    private Object videoId;
    @SerializedName("descriptions")
    @Expose
    private List<Object> descriptions = null;
    @SerializedName("non_mercado_pago_payment_methods")
    @Expose
    private List<Object> nonMercadoPagoPaymentMethods = null;
    @SerializedName("shipping")
    @Expose
    private Shipping shipping;;
    @SerializedName("warranty")
    @Expose
    private Object warranty;
    @SerializedName("seller_custom_field")
    @Expose
    private String sellerCustomField;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getBuyingMode() {
		return buyingMode;
	}
	public void setBuyingMode(String buyingMode) {
		this.buyingMode = buyingMode;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public List<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	public Object getVideoId() {
		return videoId;
	}
	public void setVideoId(Object videoId) {
		this.videoId = videoId;
	}
	public List<Object> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<Object> descriptions) {
		this.descriptions = descriptions;
	}
	public List<Object> getNonMercadoPagoPaymentMethods() {
		return nonMercadoPagoPaymentMethods;
	}
	public void setNonMercadoPagoPaymentMethods(List<Object> nonMercadoPagoPaymentMethods) {
		this.nonMercadoPagoPaymentMethods = nonMercadoPagoPaymentMethods;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public Object getWarranty() {
		return warranty;
	}
	public void setWarranty(Object warranty) {
		this.warranty = warranty;
	}
	public String getSellerCustomField() {
		return sellerCustomField;
	}
	public void setSellerCustomField(String sellerCustomField) {
		this.sellerCustomField = sellerCustomField;
	}
     
}
