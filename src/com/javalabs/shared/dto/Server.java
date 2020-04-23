package com.javalabs.shared.dto;

import java.io.Serializable;

public class Server implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private String name;
	private String ipAddress;
	private int port;
	private String username;
	private String password;

	public Server() {}
	
	public Server(String name, String ipAddress, int port, String username, String password) {
		this.name = name;
		this.ipAddress = ipAddress;
		this.port = port;
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
