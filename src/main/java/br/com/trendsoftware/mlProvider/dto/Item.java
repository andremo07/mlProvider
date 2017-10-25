
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("available_quantity")
    @Expose
    private Long availableQuantity;
    @SerializedName("buying_mode")
    @Expose
    private String buyingMode;
    @SerializedName("listing_type_id")
    @Expose
    private String listingTypeId;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("warranty")
    @Expose
    private String warranty;
    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;
    @SerializedName("variations")
    @Expose
    private List<Variation> variations = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Item withCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Item withCurrencyId(String currencyId) {
        this.currencyId = currencyId;
        return this;
    }
    
    public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Item withAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
        return this;
    }

    public String getBuyingMode() {
        return buyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    public Item withBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
        return this;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    public Item withListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Item withCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Item withVideoId(String videoId) {
        this.videoId = videoId;
        return this;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Item withWarranty(String warranty) {
        this.warranty = warranty;
        return this;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Item withPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

    public Item withVariations(List<Variation> variations) {
        this.variations = variations;
        return this;
    }

}
