package com.javalabs.shared.dto;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.QueryParam;

public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;

	@QueryParam("id")	
	private Long id;
	@QueryParam("name")
	private String name;
	@QueryParam("email")
	private String email;	
	@QueryParam("timestamp")
	private Date timestamp;

	public Supplier() {}
	
	public Supplier(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		this.timestamp = new Date();
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
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
