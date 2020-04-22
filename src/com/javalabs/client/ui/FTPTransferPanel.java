package com.javalabs.client.ui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.javalabs.client.factory.ServerFactory;
import com.javalabs.shared.dto.Server;

public class FTPTransferPanel extends TitledPanel {

	public FTPTransferPanel() {
		super("FTP Transfer");

		this.setSpacing(20);
		
		ListBox listBoxServers = new ListBox();
		listBoxServers.setStyleName("listBoxServers");
		
		for (Server server: ServerFactory.getServers()) {
			listBoxServers.addItem(server.getName());
		}
		listBoxServers.setVisibleItemCount(ServerFactory.getServers().size());
		
		this.add(new Label("Available Servers:"));
		this.add(listBoxServers);
		
		Button testConnectionButton = new Button("Test Connection");
		testConnectionButton.addClickHandler(event -> {
			Window.alert("Test FOKING Connection");
		});
		this.add(testConnectionButton);
	}
	
}	
