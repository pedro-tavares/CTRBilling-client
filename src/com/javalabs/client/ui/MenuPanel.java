package com.javalabs.client.ui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.javalabs.client.JavaLabs;

public class MenuPanel extends StackLayoutPanel {
	
	private static FTPTransferPanel panelFTPTransfer;
	private static BillingFileLogPanel panelBillingFileLog;

	private VerticalPanel panelBilling = new VerticalPanel();
	
	@SuppressWarnings("deprecation")
	public MenuPanel() {
		super(Unit.EM);
		
		Hyperlink linkFTPDownload = new Hyperlink("FTP Download", "");
		linkFTPDownload.addClickHandler(event -> {
			panelFTPTransfer = new FTPTransferPanel();
			JavaLabs.GET().showView(panelFTPTransfer);
		});

		Hyperlink linkFTPLog = new Hyperlink("FTP Log", "");
		linkFTPLog.addClickHandler(event -> {
			panelBillingFileLog = new BillingFileLogPanel();
			JavaLabs.GET().showView(panelBillingFileLog);
		});

		linkFTPDownload.setWidth("191px");
		
		panelBilling.add(linkFTPDownload);
		panelBilling.add(linkFTPLog);
		
		this.add(new HTML("Dashboard options"), new HTML("Dashboard"), 4);   
		this.add(new HTML("My Account  options"), new HTML("My Account"), 4);  
		this.add(new HTML("Client options"), new HTML("Client"), 4);
		this.add(panelBilling, new HTML("Billing"), 4);

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
