package com.pokemonteambuilder.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message="Please enter an email address")
	@Email(message="Please enter a valid email address")
	private String email;

	@NotEmpty(message="Please enter a password")
	@Size(min=8, max=32, message="Password must be between 8 and 32 characters long")
	private String password;
	
	public LoginUser() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
