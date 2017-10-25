
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SellerReputation {

    @SerializedName("level_id")
    @Expose
    private String levelId;
    
    @SerializedName("power_seller_status")
    @Expose
    private String powerSellerStatus;
    
    @SerializedName("transactions")
    @Expose
    private Transactions transactions;
    
    @SerializedName("metrics")
    @Expose
    private Metrics metrics;

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getPowerSellerStatus() {
        return powerSellerStatus;
    }

    public void setPowerSellerStatus(String powerSellerStatus) {
        this.powerSellerStatus = powerSellerStatus;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

}
