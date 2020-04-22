package com.javalabs.client.factory;

import java.util.ArrayList;
import java.util.List;

import com.javalabs.shared.dto.Server;

public class ServerFactory {

	private static List<Server> serverList = new ArrayList<Server>();
	
	static {
		serverList.add(new Server("UBOSS", "ftp.uboss.com", 21, "RES_1024", "$CTr1o24*"));
		serverList.add(new Server("ICUK", "cdr.interdns.co.uk", 21, "ctrservicesuk", "Alibaserf12!"));
		serverList.add(new Server("Voicehost", "ftp.voicehost.co.uk", 21, "19981", "L85n7MyL6Aub"));
		serverList.add(new Server("Daisy", "dwp.daisywholesale.com", 21, "NDD02797", "7BwKFjFNF"));
	}
	
	public ServerFactory() {}
	
	public static List<Server> getServers() {
		return serverList;
	}
}
