
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_closed")
    @Expose
    private String dateClosed;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("feedback")
    @Expose
    private Feedback feedback;
    @SerializedName("mediations")
    @Expose
    private List<Object> mediations = null;
    @SerializedName("comments")
    @Expose
    private Object comments;
    @SerializedName("order_request")
    @Expose
    private OrderRequest orderRequest;
    @SerializedName("fulfilled")
    @Expose
    private Object fulfilled;
    @SerializedName("shipping")
    @Expose
    private Shipping shipping;
    @SerializedName("expiration_date")
    @Expose
    private String expirationDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_detail")
    @Expose
    private Object statusDetail;
    @SerializedName("order_items")
    @Expose
    private List<OrderItem> orderItems = null;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("buyer")
    @Expose
    private Buyer buyer;
    @SerializedName("seller")
    @Expose
    private Seller seller;
    @SerializedName("payments")
    @Expose
    private List<Payment> payments = null;
    @SerializedName("coupon")
    @Expose
    private Coupon coupon;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("total_amount")
    @Expose
    private Double totalAmount;
    @SerializedName("total_amount_with_shipping")
    @Expose
    private Double totalAmountWithShipping;
    @SerializedName("paid_amount")
    @Expose
    private Double paidAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public List<Object> getMediations() {
        return mediations;
    }

    public void setMediations(List<Object> mediations) {
        this.mediations = mediations;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public Object getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(Object fulfilled) {
        this.fulfilled = fulfilled;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(Object statusDetail) {
        this.statusDetail = statusDetail;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmountWithShipping() {
        return totalAmountWithShipping;
    }

    public void setTotalAmountWithShipping(Double totalAmountWithShipping) {
        this.totalAmountWithShipping = totalAmountWithShipping;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

}
