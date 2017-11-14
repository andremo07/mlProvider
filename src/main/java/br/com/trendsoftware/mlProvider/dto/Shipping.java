
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipping {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("order_cost")
    @Expose
    private Double orderCost;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("substatus")
    @Expose
    private String substatus;
    @SerializedName("status_history")
    @Expose
    private StatusHistory statusHistory;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("tracking_number")
    @Expose
    private String trackingNumber;
    @SerializedName("tracking_method")
    @Expose
    private String trackingMethod;
    @SerializedName("service_id")
    @Expose
    private Long serviceId;
    @SerializedName("carrier_info")
    @Expose
    private String carrierInfo;
    @SerializedName("sender_id")
    @Expose
    private Long senderId;
    @SerializedName("sender_address")
    @Expose
    private SenderAddress senderAddress;
    @SerializedName("receiver_id")
    @Expose
    private Long receiverId;
    @SerializedName("receiver_address")
    @Expose
    private ReceiverAddress receiverAddress;
    @SerializedName("shipping_items")
    @Expose
    private List<ShippingItem> shippingItems = null;
    @SerializedName("shipping_option")
    @Expose
    private ShippingOption shippingOption;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("date_first_printed")
    @Expose
    private String dateFirstPrinted;
    @SerializedName("market_place")
    @Expose
    private String marketPlace;
    @SerializedName("return_details")
    @Expose
    private String returnDetails;
    @SerializedName("return_tracking_number")
    @Expose
    private String returnTrackingNumber;
    @SerializedName("carrier_id")
    @Expose
    private String carrierId;
    @SerializedName("cost_components")
    @Expose
    private CostComponents costComponents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubstatus() {
        return substatus;
    }

    public void setSubstatus(String substatus) {
        this.substatus = substatus;
    }

    public StatusHistory getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(StatusHistory statusHistory) {
        this.statusHistory = statusHistory;
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

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingMethod() {
        return trackingMethod;
    }

    public void setTrackingMethod(String trackingMethod) {
        this.trackingMethod = trackingMethod;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getCarrierInfo() {
        return carrierInfo;
    }

    public void setCarrierInfo(String carrierInfo) {
        this.carrierInfo = carrierInfo;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public SenderAddress getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(SenderAddress senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public ReceiverAddress getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(ReceiverAddress receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public List<ShippingItem> getShippingItems() {
        return shippingItems;
    }

    public void setShippingItems(List<ShippingItem> shippingItems) {
        this.shippingItems = shippingItems;
    }

    public ShippingOption getShippingOption() {
        return shippingOption;
    }

    public void setShippingOption(ShippingOption shippingOption) {
        this.shippingOption = shippingOption;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDateFirstPrinted() {
        return dateFirstPrinted;
    }

    public void setDateFirstPrinted(String dateFirstPrinted) {
        this.dateFirstPrinted = dateFirstPrinted;
    }

    public String getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(String marketPlace) {
        this.marketPlace = marketPlace;
    }

    public String getReturnDetails() {
        return returnDetails;
    }

    public void setReturnDetails(String returnDetails) {
        this.returnDetails = returnDetails;
    }

    public String getReturnTrackingNumber() {
        return returnTrackingNumber;
    }

    public void setReturnTrackingNumber(String returnTrackingNumber) {
        this.returnTrackingNumber = returnTrackingNumber;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public CostComponents getCostComponents() {
        return costComponents;
    }

    public void setCostComponents(CostComponents costComponents) {
        this.costComponents = costComponents;
    }

}
