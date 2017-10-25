
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("value_name")
    @Expose
    private String valueName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Attribute withId(String id) {
        this.id = id;
        return this;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Attribute withValueName(String valueName) {
        this.valueName = valueName;
        return this;
    }

}
