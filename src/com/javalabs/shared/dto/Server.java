package com.javalabs.shared.dto;

import java.io.Serializable;

public class Server implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private String ipAddress;
	private int port;
	private String username;
	private String password;
	
	public void Server(String ipAddress, int port, String username, String password) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.username = username;
		this.password = password;
	}

}
