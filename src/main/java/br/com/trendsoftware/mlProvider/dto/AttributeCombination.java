
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttributeCombination {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value_id")
    @Expose
    private String valueId;
    @SerializedName("value_name")
    @Expose
    private String valueName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeCombination withName(String name) {
        this.name = name;
        return this;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public AttributeCombination withValueId(String valueId) {
        this.valueId = valueId;
        return this;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public AttributeCombination withValueName(String valueName) {
        this.valueName = valueName;
        return this;
    }

}
