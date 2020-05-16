package com.projetochernobyl.sturdyenigma.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.projetochernobyl.sturdyenigma.services.validation.ClientInsert;

@ClientInsert
public class ClientNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Field should not be empty")
	@Size(min = 5, max = 20, message = "Field must have between 5 and 20 letters")
	private String name;
	
	@NotEmpty(message = "Field should not be empty")
	@Email(message = "this is not a valid email")
	private String email;
	private String ninOrNif;
	private Integer type;
	
	@NotEmpty(message = "Field should not be empty")
	private String street;
	
	@NotEmpty(message = "Field should not be empty")
	private String number;
	private String neighborhood;
	private String zipCode;
	
	@NotEmpty(message = "Field should not be empty")
	private String phoneNumber1;
	private String phoneNumber2;
	private String phoneNumber3;
	
	private Long cityId;
	
	public ClientNewDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNinOrNif() {
		return ninOrNif;
	}

	public void setNinOrNif(String ninOrNif) {
		this.ninOrNif = ninOrNif;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}

	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
