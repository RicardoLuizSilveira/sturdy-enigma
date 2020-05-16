package com.projetochernobyl.sturdyenigma.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.services.validation.ClientUpdate;

@ClientUpdate
public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Field should not be empty")
	@Size(min = 5, max = 20, message = "Field must have between 5 and 20 letters")
	private String name;
	
	@NotEmpty(message = "Field should not be empty")
	@Email(message = "this is not a valid email")
	private String email;
	
	public ClientDTO() {
	}

	public ClientDTO(Client obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
