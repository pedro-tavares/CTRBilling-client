package com.javalabs.shared.dto;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.QueryParam;

public class FTPFileInfo implements Serializable {

	private static final long serialVersionUID = 3L;
	
	@QueryParam("name")
	private String name;
	@QueryParam("date")
	private Date date;

	public FTPFileInfo() {}
	
	public FTPFileInfo(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}