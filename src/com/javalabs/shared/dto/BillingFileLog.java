package com.javalabs.shared.dto;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.QueryParam;

public class BillingFileLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@QueryParam("id")	
	private Long id;
	@QueryParam("FileName")
	private String FileName;
	@QueryParam("Timestamp")
	private Date Timestamp;
	@QueryParam("Type")
	private String Type;

	public BillingFileLog() {}
	
	public BillingFileLog(String fileName, Date timestamp, String type) {
		super();
		FileName = fileName;
		Timestamp = timestamp;
		Type = type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public Date getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
}
