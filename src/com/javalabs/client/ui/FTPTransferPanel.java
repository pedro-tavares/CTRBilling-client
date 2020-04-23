package com.javalabs.client.ui;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.javalabs.client.JavaLabs;
import com.javalabs.client.factory.ServerFactory;
import com.javalabs.client.service.ServiceFactory;
import com.javalabs.shared.dto.Server;
import com.javalabs.shared.dto.User;

public class FTPTransferPanel extends TitledPanel {

	private Button testConnectionButton;
	
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
		
		testConnectionButton = new Button("Test Connection");
		testConnectionButton.addClickHandler(event -> {
			Window.alert("Test FOKING Connection:" + listBoxServers.getSelectedValue());
			Server server = ServerFactory.getServerByName(listBoxServers.getSelectedValue());
			callFTPLoginService(server);
		});
		this.add(testConnectionButton);
	}
	
	private void callFTPLoginService(Server server) {
		testConnectionButton.getElement().getStyle().setCursor(Cursor.WAIT);
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);
		
		ServiceFactory.FTP_SERVICE.login(server, new MethodCallback<String>() {

			@Override
			public void onSuccess(Method method, String response) {
				testConnectionButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.removeStyleName("errorLbl");
				
				Window.alert("FTP Login  - SUCCESS to server:" + server.getIpAddress() + "/" + server.getName());
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				testConnectionButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
				//JSONValue responseValue = JSONParser.parse(method.getResponse().getText());
		        //JSONObject responseObj = responseValue.isObject();
		        
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
		        Window.alert("Login  - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}
	
}	
