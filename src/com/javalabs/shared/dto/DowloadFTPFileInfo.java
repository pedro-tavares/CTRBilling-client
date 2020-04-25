package com.javalabs.shared.dto;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

public class DowloadFTPFileInfo implements Serializable {

	private static final long serialVersionUID = 4L;
	
	@QueryParam("server")
	private Server server;
	@QueryParam("fileName")
	private String fileName;

	public DowloadFTPFileInfo() {}
	
	public DowloadFTPFileInfo(Server server, String fileName) {
		this.server = server;
		this.fileName = fileName;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}