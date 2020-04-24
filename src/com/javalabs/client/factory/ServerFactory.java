package com.javalabs.client.factory;

import java.util.ArrayList;
import java.util.List;

import com.javalabs.shared.dto.Server;

public class ServerFactory {

	private static List<Server> serverList = new ArrayList<Server>();
	
	static {
		serverList.add(new Server("UBOSS", "ftp.uboss.com", 21, "/Export", "RES_1024", "$CTr1o24*"));
		// TODO configure below PATHs
		serverList.add(new Server("ICUK", "cdr.interdns.co.uk", 21, "/daily", "ctrservicesuk", "Alibaserf12!"));
		serverList.add(new Server("Voicehost", "ftp.voicehost.co.uk", 21, "/daily", "19981", "L85n7MyL6Aub"));
		serverList.add(new Server("Daisy", "dwp.daisywholesale.com", 21, "/daily", "NDD02797", "7BwKFjFNF"));
	}
	
	public ServerFactory() {}
	
	public static List<Server> getServers() {
		return serverList;
	}
	
	public static Server getServerByName(String name) {
		for (Server s: serverList) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		
		return null;
	}
}
