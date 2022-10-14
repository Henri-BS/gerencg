package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.util.List;

import com.altercode.gerencg.entity.Authority;
import com.altercode.gerencg.entity.User;


public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Boolean enabled;

	public UserDTO() {}
	
	public UserDTO(User entity) {
		id = entity.getId();
		userName = entity.getUsername();
		password = entity.getPassword();
		email = entity.getEmail();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		phoneNumber = entity.getPhoneNumber();
		enabled = entity.getEnabled();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	
}
