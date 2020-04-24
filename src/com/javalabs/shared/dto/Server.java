package com.javalabs.shared.dto;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

public class Server implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@QueryParam("name")
	private String name;
	@QueryParam("ipAddress")
	private String ipAddress;
	@QueryParam("port")
	private int port;
	@QueryParam("path")
	private String path;
	@QueryParam("username")
	private String username;
	@QueryParam("password")
	private String password;

	public Server() {}
	
	public Server(String name, String ipAddress, int port, String path, String username, String password) {
		this.name = name;
		this.ipAddress = ipAddress;
		this.port = port;
		this.path = path;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
