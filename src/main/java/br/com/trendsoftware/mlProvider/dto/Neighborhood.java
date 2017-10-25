
package br.com.trendsoftware.mlProvider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Neighborhood {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("name")
    @Expose
    private Object name;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

}
