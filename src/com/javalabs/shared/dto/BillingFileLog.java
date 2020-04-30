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

	public BillingFileLog() {}
	
	public BillingFileLog(String fileName, Date timestamp) {
		super();
		FileName = fileName;
		Timestamp = timestamp;
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
	
}
