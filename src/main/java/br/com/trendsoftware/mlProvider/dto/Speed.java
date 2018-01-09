
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Speed {

    @SerializedName("shipping")
    @Expose
    private Object shipping;
    @SerializedName("handling")
    @Expose
    private Object handling;

    public Object getShipping() {
        return shipping;
    }

    public void setShipping(Object shipping) {
        this.shipping = shipping;
    }

    public Object getHandling() {
        return handling;
    }

    public void setHandling(Object handling) {
        this.handling = handling;
    }

}
