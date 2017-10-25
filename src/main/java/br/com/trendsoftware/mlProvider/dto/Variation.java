
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variation {

    @SerializedName("attribute_combinations")
    @Expose
    private List<AttributeCombination> attributeCombinations = null;
    @SerializedName("price")
    @Expose
    private Long price;
    @SerializedName("available_quantity")
    @Expose
    private Long availableQuantity;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("sold_quantity")
    @Expose
    private Long soldQuantity;
    @SerializedName("picture_ids")
    @Expose
    private List<String> pictureIds = null;

    public List<AttributeCombination> getAttributeCombinations() {
        return attributeCombinations;
    }

    public void setAttributeCombinations(List<AttributeCombination> attributeCombinations) {
        this.attributeCombinations = attributeCombinations;
    }

    public Variation withAttributeCombinations(List<AttributeCombination> attributeCombinations) {
        this.attributeCombinations = attributeCombinations;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Variation withPrice(Long price) {
        this.price = price;
        return this;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Variation withAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
        return this;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Variation withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Variation withSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
        return this;
    }

    public List<String> getPictureIds() {
        return pictureIds;
    }

    public void setPictureIds(List<String> pictureIds) {
        this.pictureIds = pictureIds;
    }

    public Variation withPictureIds(List<String> pictureIds) {
        this.pictureIds = pictureIds;
        return this;
    }

}
