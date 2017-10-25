
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CostComponents {

    @SerializedName("special_discount")
    @Expose
    private Long specialDiscount;

    public Long getSpecialDiscount() {
        return specialDiscount;
    }

    public void setSpecialDiscount(Long specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

}
