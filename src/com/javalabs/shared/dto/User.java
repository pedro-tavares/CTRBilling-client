package com.javalabs.shared.dto;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@QueryParam("name")
	private Long id;
	@QueryParam("name")
	private String name;
	@QueryParam("email")
	private String email;
	@QueryParam("password")
	private String password;

	public User() {}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
