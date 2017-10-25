
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusHistory {

    @SerializedName("date_shipped")
    @Expose
    private Object dateShipped;
    @SerializedName("date_delivered")
    @Expose
    private Object dateDelivered;

    public Object getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Object dateShipped) {
        this.dateShipped = dateShipped;
    }

    public Object getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Object dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

}
