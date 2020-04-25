package com.javalabs.client.ui;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.javalabs.client.JavaLabs;
import com.javalabs.client.factory.ServerFactory;
import com.javalabs.client.service.ServiceFactory;
import com.javalabs.shared.dto.DowloadFTPFileInfo;
import com.javalabs.shared.dto.FTPFileInfo;
import com.javalabs.shared.dto.Server;

public class FTPTransferPanel extends TitledPanel {

	private Button testConnectionButton;
	private Button getAvailableFilesButton;
	private Label labelAvailableFiles;
	private ListBox listBoxAvailableFiles;
	
	public FTPTransferPanel() {
		super("FTP Transfer");

		this.setSpacing(20);
		this.init();
	}
	
	@SuppressWarnings("deprecation")
	private void init() {
		Label selectedDownloadFileLabel = new Label();
		
		ListBox listBoxServers = new ListBox();
		listBoxServers.setStyleName("listBoxServers");
		
		for (Server server: ServerFactory.getServers()) {
			listBoxServers.addItem(server.getName());
		}
		listBoxServers.setVisibleItemCount(ServerFactory.getServers().size());
		listBoxServers.setSelectedIndex(0);
		
		this.add(new Label("Available Servers:"));
		this.add(listBoxServers);
		
		// test connection
		testConnectionButton = new Button("Test Connection");
		testConnectionButton.addClickHandler(event -> {
			//Window.alert("Test FOKING Connection:" + listBoxServers.getSelectedValue());
			Server server = ServerFactory.getServerByName(listBoxServers.getSelectedValue());
			callFTPLoginService(server);
		});
		this.add(testConnectionButton);

		// download and process
		Button downloadProcessButton = new Button("Download and Process");
		downloadProcessButton.setVisible(false);
		downloadProcessButton.addClickHandler(event -> {
			Server server = ServerFactory.getServerByName(listBoxServers.getSelectedValue());
			callFTPDownloadFileService(server, selectedDownloadFileLabel.getText());
		});
		
		// available files
		listBoxAvailableFiles = new ListBox();
		labelAvailableFiles = new Label("Available Files:");
		listBoxAvailableFiles.addChangeListener(event -> {
			selectedDownloadFileLabel.setText(listBoxAvailableFiles.getSelectedItemText().substring(0, listBoxAvailableFiles.getSelectedItemText().indexOf(',')));
			Window.alert(selectedDownloadFileLabel.getText());
			downloadProcessButton.setVisible(true);
		});
		this.add(labelAvailableFiles);
		this.add(listBoxAvailableFiles);
		
		getAvailableFilesButton = new Button("Get Available Files");
		getAvailableFilesButton.addClickHandler(event -> {
			Server server = ServerFactory.getServerByName(listBoxServers.getSelectedValue());
			callFTPDirService(server);
		});
		this.add(getAvailableFilesButton);

		this.add(downloadProcessButton);
		
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
				
				Window.alert("FTP login  - SUCCESS to server:\n" + server.getName() + ":" + server.getIpAddress());
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				testConnectionButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
		        Window.alert("FTP login  - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}

	private void callFTPDirService(Server server) {
		getAvailableFilesButton.getElement().getStyle().setCursor(Cursor.WAIT);
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);
		
		ServiceFactory.FTP_SERVICE.dir(server, new MethodCallback<List<FTPFileInfo>>() {

			@Override
			public void onSuccess(Method method, List<FTPFileInfo> response) {
				getAvailableFilesButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.removeStyleName("errorLbl");
				
				//Window.alert("FTP dir  - SUCCESS to server:\n" + server.getName() + ":" + server.getIpAddress());
				
				labelAvailableFiles.setText("Available Files (" + response.size() + "):");
				listBoxAvailableFiles.clear();
				for (FTPFileInfo fileInfo: response) {
					listBoxAvailableFiles.addItem(fileInfo.getName() + ", " + fileInfo.getDate());
				}
				listBoxAvailableFiles.setVisibleItemCount(25);

			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				getAvailableFilesButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
				//JSONValue responseValue = JSONParser.parse(method.getResponse().getText());
		        //JSONObject responseObj = responseValue.isObject();
		        
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
		        Window.alert("FTP dir  - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}

	private void callFTPDownloadFileService(Server server, String fileName) {
		getAvailableFilesButton.getElement().getStyle().setCursor(Cursor.WAIT);
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);
		
		DowloadFTPFileInfo fileInfo = new DowloadFTPFileInfo(server, fileName);
		ServiceFactory.FTP_SERVICE.downloadFile(fileInfo, new MethodCallback<String>() {

			@Override
			public void onSuccess(Method method, String response) {
				getAvailableFilesButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.removeStyleName("errorLbl");
				
				Window.alert("FTP downloadFile  - SUCCESS fileName:\n" + fileName);
				
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				getAvailableFilesButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
		        Window.alert("FTP downloadFile  - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}
	
}	
