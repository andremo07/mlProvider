
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ratings {

    @SerializedName("positive")
    @Expose
    private Double positive;
    @SerializedName("negative")
    @Expose
    private Double negative;
    @SerializedName("neutral")
    @Expose
    private Double neutral;

    public Double getPositive() {
        return positive;
    }

    public void setPositive(Double positive) {
        this.positive = positive;
    }

    public Double getNegative() {
        return negative;
    }

    public void setNegative(Double negative) {
        this.negative = negative;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

}
