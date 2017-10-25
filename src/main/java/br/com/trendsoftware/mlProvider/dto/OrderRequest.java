
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderRequest {

    @SerializedName("return")
    @Expose
    private Object _return;
    @SerializedName("change")
    @Expose
    private Object change;

    public Object getReturn() {
        return _return;
    }

    public void setReturn(Object _return) {
        this._return = _return;
    }

    public Object getChange() {
        return change;
    }

    public void setChange(Object change) {
        this.change = change;
    }

}
