
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingOption {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("list_cost")
    @Expose
    private Double listCost;
    @SerializedName("cost")
    @Expose
    private Double cost;
    @SerializedName("speed")
    @Expose
    private Speed speed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Double getListCost() {
        return listCost;
    }

    public void setListCost(Double listCost) {
        this.listCost = listCost;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Object getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

}
