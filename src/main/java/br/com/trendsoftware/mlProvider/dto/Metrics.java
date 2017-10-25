
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metrics {

    @SerializedName("sales")
    @Expose
    private Sales sales;
    
    @SerializedName("claims")
    @Expose
    private Claims claims;
    
    @SerializedName("delayed_handling_time")
    @Expose
    private DelayedHandlingTime delayedHandlingTime;

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public DelayedHandlingTime getDelayedHandlingTime() {
        return delayedHandlingTime;
    }

    public void setDelayedHandlingTime(DelayedHandlingTime delayedHandlingTime) {
        this.delayedHandlingTime = delayedHandlingTime;
    }

}
