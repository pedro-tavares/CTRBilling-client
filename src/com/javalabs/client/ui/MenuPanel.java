package com.javalabs.client.ui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.javalabs.client.JavaLabs;

public class MenuPanel extends StackLayoutPanel {
	
	private static FTPTransferPanel fptTransferPanel = new FTPTransferPanel();
	
	@SuppressWarnings("deprecation")
	public MenuPanel() {
		super(Unit.EM);
		
		Hyperlink ftpDownloadLink = new Hyperlink("FTP Download", "");
		ftpDownloadLink.addClickHandler(event -> {
			JavaLabs.GET().showView(fptTransferPanel);
		});
		
		this.add(new HTML("Dashboard options"), new HTML("Dashboard"), 4);   
		this.add(new HTML("My Account  options"), new HTML("My Account"), 4);  
		this.add(new HTML("Client options"), new HTML("Client"), 4);
		this.add(new HTML("Billing options"), new HTML("Billing"), 4);
		this.add(ftpDownloadLink, new HTML("FTP Transfer"), 4);
		
		//TODO
		/*
		 this.add(new HTML("Dashboard"), new HTML("Dashboard"), 4);   
		 this.add(new HTML("Customers"), new HTML("Customers"), 4);  
		 this.add(new HTML("Telephone"), new HTML("Telephone"), 4);
		 this.add(new HTML("Products"), new HTML("Products"), 4);
		 this.add(new HTML("Products"), new HTML(""), 4);
		 this.add(new HTML("Rate Scheme"), new HTML(""), 4);
		 this.add(new HTML("Invoice Group"), new HTML(""), 4);
		 this.add(new HTML("Invoice History"), new HTML(""), 4);
		 this.add(new HTML("File History"), new HTML(""), 4);
		 this.add(new HTML("Reports"), new HTML(""), 4);
		 this.add(new HTML("File Upload"), new HTML(""), 4);
		*/
	}

}
