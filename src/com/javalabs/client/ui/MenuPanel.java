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
	private static SupplierPanel panelSupplier;

	private VerticalPanel panelDashboard = new VerticalPanel();
	private VerticalPanel panelBilling = new VerticalPanel();
	
	@SuppressWarnings("deprecation")
	public MenuPanel() {
		super(Unit.EM);
		
		// Dashboard
		
		Hyperlink linkDashboardInsights = new Hyperlink("Insights", "");
		linkDashboardInsights.addClickHandler(event -> {
			//panelFTPTransfer = new FTPTransferPanel();
			//JavaLabs.GET().showView(panelFTPTransfer);
			Window.alert("FOK");
		});
		linkDashboardInsights.setWidth("191px");
		
		panelDashboard.add(linkDashboardInsights);
		
		//Download
		
		Hyperlink linkFTPDownload = new Hyperlink("FTP Download", "");
		linkFTPDownload.addClickHandler(event -> {
			panelFTPTransfer = new FTPTransferPanel();
			JavaLabs.GET().showView(panelFTPTransfer);
		});
		linkFTPDownload.setWidth("191px");
		
		Hyperlink linkFTPLog = new Hyperlink("FTP Log", "");
		linkFTPLog.addClickHandler(event -> {
			panelBillingFileLog = new BillingFileLogPanel();
			JavaLabs.GET().showView(panelBillingFileLog);
		});

		panelBilling.add(linkFTPDownload);
		panelBilling.add(linkFTPLog);

		// Config
		Hyperlink linkConfigSuppliers = new Hyperlink("Suppliers", "");
		linkConfigSuppliers.addClickHandler(event -> {
			panelSupplier = new SupplierPanel(); 
			JavaLabs.GET().showView(panelSupplier);
		});
		
		this.add(panelDashboard, new HTML("Dashboard"), 4);   
		this.add(new HTML("My Account  options"), new HTML("My Account"), 4);  
		this.add(new HTML("Client options"), new HTML("Client"), 4);
		this.add(panelBilling, new HTML("Billing"), 4);
		this.add(linkConfigSuppliers, new HTML("Configuration"), 4);

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
