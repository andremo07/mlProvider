
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payment {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("payer_id")
    @Expose
    private Long payerId;
    @SerializedName("collector")
    @Expose
    private Collector collector;
    @SerializedName("card_id")
    @Expose
    private Long cardId;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("payment_method_id")
    @Expose
    private String paymentMethodId;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("installments")
    @Expose
    private Integer installments;
    @SerializedName("issuer_id")
    @Expose
    private Object issuerId;
    @SerializedName("atm_transfer_reference")
    @Expose
    private AtmTransferReference atmTransferReference;
    @SerializedName("coupon_id")
    @Expose
    private Object couponId;
    @SerializedName("activation_uri")
    @Expose
    private Object activationUri;
    @SerializedName("operation_type")
    @Expose
    private String operationType;
    @SerializedName("payment_type")
    @Expose
    private String paymentType;
    @SerializedName("available_actions")
    @Expose
    private List<Object> availableActions = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private Object statusCode;
    @SerializedName("status_detail")
    @Expose
    private String statusDetail;
    @SerializedName("transaction_amount")
    @Expose
    private Double transactionAmount;
    @SerializedName("shipping_cost")
    @Expose
    private Double shippingCost;
    @SerializedName("coupon_amount")
    @Expose
    private Double couponAmount;
    @SerializedName("overpaid_amount")
    @Expose
    private Double overpaidAmount;
    @SerializedName("total_paid_amount")
    @Expose
    private Double totalPaidAmount;
    @SerializedName("installment_amount")
    @Expose
    private Object installmentAmount;
    @SerializedName("deferred_period")
    @Expose
    private Object deferredPeriod;
    @SerializedName("date_approved")
    @Expose
    private String dateApproved;
    @SerializedName("authorization_code")
    @Expose
    private Object authorizationCode;
    @SerializedName("transaction_order_id")
    @Expose
    private Object transactionOrderId;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_last_modified")
    @Expose
    private String dateLastModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public Object getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Object getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Object issuerId) {
        this.issuerId = issuerId;
    }

    public AtmTransferReference getAtmTransferReference() {
        return atmTransferReference;
    }

    public void setAtmTransferReference(AtmTransferReference atmTransferReference) {
        this.atmTransferReference = atmTransferReference;
    }

    public Object getCouponId() {
        return couponId;
    }

    public void setCouponId(Object couponId) {
        this.couponId = couponId;
    }

    public Object getActivationUri() {
        return activationUri;
    }

    public void setActivationUri(Object activationUri) {
        this.activationUri = activationUri;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<Object> getAvailableActions() {
        return availableActions;
    }

    public void setAvailableActions(List<Object> availableActions) {
        this.availableActions = availableActions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Object statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Double getOverpaidAmount() {
        return overpaidAmount;
    }

    public void setOverpaidAmount(Double overpaidAmount) {
        this.overpaidAmount = overpaidAmount;
    }

    public Double getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(Double totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public Object getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Object installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Object getDeferredPeriod() {
        return deferredPeriod;
    }

    public void setDeferredPeriod(Object deferredPeriod) {
        this.deferredPeriod = deferredPeriod;
    }

    public String getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(String dateApproved) {
        this.dateApproved = dateApproved;
    }

    public Object getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(Object authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public Object getTransactionOrderId() {
        return transactionOrderId;
    }

    public void setTransactionOrderId(Object transactionOrderId) {
        this.transactionOrderId = transactionOrderId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(String dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

}
