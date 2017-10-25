
package br.com.trendsoftware.mlProvider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SenderAddress {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("address_line")
    @Expose
    private String addressLine;
    @SerializedName("street_name")
    @Expose
    private String streetName;
    @SerializedName("street_number")
    @Expose
    private String streetNumber;
    @SerializedName("comment")
    @Expose
    private Object comment;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("neighborhood")
    @Expose
    private Neighborhood neighborhood;
    @SerializedName("municipality")
    @Expose
    private Municipality municipality;
    @SerializedName("types")
    @Expose
    private List<String> types = null;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("geolocation_type")
    @Expose
    private Object geolocationType;
    @SerializedName("agency")
    @Expose
    private Object agency;
    @SerializedName("is_valid_for_carrier")
    @Expose
    private Object isValidForCarrier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getGeolocationType() {
        return geolocationType;
    }

    public void setGeolocationType(Object geolocationType) {
        this.geolocationType = geolocationType;
    }

    public Object getAgency() {
        return agency;
    }

    public void setAgency(Object agency) {
        this.agency = agency;
    }

    public Object getIsValidForCarrier() {
        return isValidForCarrier;
    }

    public void setIsValidForCarrier(Object isValidForCarrier) {
        this.isValidForCarrier = isValidForCarrier;
    }

}
