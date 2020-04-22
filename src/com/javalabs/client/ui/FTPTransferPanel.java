package com.javalabs.client.ui;

import com.google.gwt.user.client.ui.ListBox;

public class FTPTransferPanel extends TitledPanel {

	public FTPTransferPanel() {
		super("FTP Transfer");

		this.setSpacing(20);
		
		ListBox listBoxServers = new ListBox();
		listBoxServers.addItem("First");
		listBoxServers.addItem("Second");
		listBoxServers.addItem("Third");
		listBoxServers.addItem("Fourth");
		listBoxServers.addItem("Fifth");

		listBoxServers.setVisibleItemCount(5);
		
		this.add(listBoxServers);
	}
	
	
	
}
