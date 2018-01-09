
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReturnDetails {

    @SerializedName("tracking_number")
    @Expose
    private Object trackingNumber;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("date_estimated_delivery")
    @Expose
    private String dateEstimatedDelivery;
    @SerializedName("date_returned")
    @Expose
    private String dateReturned;

    public Object getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Object trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateEstimatedDelivery() {
        return dateEstimatedDelivery;
    }

    public void setDateEstimatedDelivery(String dateEstimatedDelivery) {
        this.dateEstimatedDelivery = dateEstimatedDelivery;
    }

    public String getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(String dateReturned) {
        this.dateReturned = dateReturned;
    }

}
