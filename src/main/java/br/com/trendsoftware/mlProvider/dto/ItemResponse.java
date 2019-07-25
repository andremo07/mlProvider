
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("seller_id")
    @Expose
    private Long sellerId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("official_store_id")
    @Expose
    private String officialStoreId;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("base_price")
    @Expose
    private Double basePrice;
    @SerializedName("original_price")
    @Expose
    private Double originalPrice;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("initial_quantity")
    @Expose
    private Long initialQuantity;
    @SerializedName("available_quantity")
    @Expose
    private Long availableQuantity;
    @SerializedName("sold_quantity")
    @Expose
    private Long soldQuantity;
    @SerializedName("buying_mode")
    @Expose
    private String buyingMode;
    @SerializedName("listing_type_id")
    @Expose
    private String listingTypeId;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("stop_time")
    @Expose
    private String stopTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("secure_thumbnail")
    @Expose
    private String secureThumbnail;
    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("descriptions")
    @Expose
    private List<Object> descriptions = null;
    @SerializedName("accepts_mercadopago")
    @Expose
    private Boolean acceptsMercadopago;
    @SerializedName("non_mercado_pago_payment_methods")
    @Expose
    private List<Object> nonMercadoPagoPaymentMethods = null;
    @SerializedName("shipping")
    @Expose
    private Shipping shipping;
    @SerializedName("international_delivery_mode")
    @Expose
    private String internationalDeliveryMode;
    @SerializedName("seller_address")
    @Expose
    private SellerAddress sellerAddress;
    @SerializedName("seller_contact")
    @Expose
    private Object sellerContact;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("geolocation")
    @Expose
    private Geolocation geolocation;
    @SerializedName("coverage_areas")
    @Expose
    private List<Object> coverageAreas = null;
    @SerializedName("attributes")
    @Expose
    private List<Object> attributes = null;
    @SerializedName("warnings")
    @Expose
    private List<Object> warnings = null;
    @SerializedName("listing_source")
    @Expose
    private String listingSource;
    @SerializedName("variations")
    @Expose
    private List<Object> variations = null;
    @SerializedName("variation_id")
    @Expose
    private Object variationId;
    @SerializedName("variation_attributes")
    @Expose
    private List<Object> variationAttributes = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sub_status")
    @Expose
    private List<Object> subStatus = null;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("warranty")
    @Expose
    private String warranty;
    @SerializedName("catalog_product_id")
    @Expose
    private String catalogProductId;
    @SerializedName("seller_custom_field")
    @Expose
    private String sellerCustomField;
    @SerializedName("seller_sku")
    @Expose
    private String sellerSku;
    @SerializedName("parent_item_id")
    @Expose
    private String parentItemId;
    @SerializedName("differential_pricing")
    @Expose
    private String differentialPricing;
    @SerializedName("deal_ids")
    @Expose
    private List<String> dealIds = null;
    @SerializedName("automatic_relist")
    @Expose
    private Boolean automaticRelist;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getOfficialStoreId() {
        return officialStoreId;
    }

    public void setOfficialStoreId(String officialStoreId) {
        this.officialStoreId = officialStoreId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Long initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getBuyingMode() {
        return buyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    public void setSecureThumbnail(String secureThumbnail) {
        this.secureThumbnail = secureThumbnail;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public List<Object> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Object> descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
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

    public String getInternationalDeliveryMode() {
        return internationalDeliveryMode;
    }

    public void setInternationalDeliveryMode(String internationalDeliveryMode) {
        this.internationalDeliveryMode = internationalDeliveryMode;
    }

    public SellerAddress getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public Object getSellerContact() {
        return sellerContact;
    }

    public void setSellerContact(Object sellerContact) {
        this.sellerContact = sellerContact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public List<Object> getCoverageAreas() {
        return coverageAreas;
    }

    public void setCoverageAreas(List<Object> coverageAreas) {
        this.coverageAreas = coverageAreas;
    }

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

    public String getListingSource() {
        return listingSource;
    }

    public void setListingSource(String listingSource) {
        this.listingSource = listingSource;
    }

    public List<Object> getVariations() {
        return variations;
    }

    public Object getVariationId() {
		return variationId;
	}

	public void setVariationId(Object variationId) {
		this.variationId = variationId;
	}

	public List<Object> getVariationAttributes() {
		return variationAttributes;
	}

	public void setVariationAttributes(List<Object> variationAttributes) {
		this.variationAttributes = variationAttributes;
	}

	public void setVariations(List<Object> variations) {
        this.variations = variations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(List<Object> subStatus) {
        this.subStatus = subStatus;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Object getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getCatalogProductId() {
        return catalogProductId;
    }

    public void setCatalogProductId(String catalogProductId) {
        this.catalogProductId = catalogProductId;
    }

    public String getSellerCustomField() {
        return sellerCustomField;
    }

    public void setSellerCustomField(String sellerCustomField) {
        this.sellerCustomField = sellerCustomField;
    }
    
    public String getSellerSku() {
		return sellerSku;
	}

	public void setSellerSku(String sellerSku) {
		this.sellerSku = sellerSku;
	}

	public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public String getDifferentialPricing() {
        return differentialPricing;
    }

    public void setDifferentialPricing(String differentialPricing) {
        this.differentialPricing = differentialPricing;
    }

    public List<String> getDealIds() {
        return dealIds;
    }

    public void setDealIds(List<String> dealIds) {
        this.dealIds = dealIds;
    }

    public Boolean getAutomaticRelist() {
        return automaticRelist;
    }

    public void setAutomaticRelist(Boolean automaticRelist) {
        this.automaticRelist = automaticRelist;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
