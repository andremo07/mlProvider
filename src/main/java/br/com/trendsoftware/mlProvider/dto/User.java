package br.com.trendsoftware.mlProvider.dto;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable 
{
	private static final long serialVersionUID = 2617303060675081512L;
	
	@SerializedName("id")
    @Expose
    private String id;

	@SerializedName("nickname")
    @Expose
	private String apelido;
	
	@SerializedName("registration_date")
    @Expose
	private Date dataRegistro;

	@SerializedName("first_name")
    @Expose
	private String firstName;
	
	@SerializedName("last_name")
    @Expose
	private String lastName;
	
	@SerializedName("email")
    @Expose
	private String email;
	
	@SerializedName("identification")
    @Expose
	private Identification identification;
	
	@SerializedName("address")
    @Expose
	private Address address;
	
	@SerializedName("phone")
    @Expose
	private Phone phone;
	
	@SerializedName("seller_reputation")
    @Expose
	private SellerReputation reputation;
	
    public User()
    {
	

    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public SellerReputation getReputation() {
		return reputation;
	}

	public void setReputation(SellerReputation reputation) {
		this.reputation = reputation;
	}
	
}
