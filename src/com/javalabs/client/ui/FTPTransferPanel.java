package com.javalabs.client.ui;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FTPTransferPanel extends VerticalPanel {

	public FTPTransferPanel() {
		super();
		
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
