package com.javalabs.client.ui;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.javalabs.client.JavaLabs;
import com.javalabs.client.factory.ServerFactory;
import com.javalabs.client.service.ServiceFactory;
import com.javalabs.shared.dto.DowloadFTPFileInfo;
import com.javalabs.shared.dto.FTPFileInfo;
import com.javalabs.shared.dto.Server;

public class FTPTransferPanel extends TitledPanel {

	private Button buttonTestConnection;
	private Button 
		buttonGetAvailableFiles,
		downloadProcessButton;
	private Label 
		labelAvailableFiles,
		labelFileStatus;
	private FTPTransferAvailableFilesPanel panelFTPTransferAvailableFiles;
	
	public FTPTransferPanel() {
		super("FTP Transfer");

		this.setSpacing(20);
		this.init();
	}
	
	@SuppressWarnings("deprecation")
	private void init() {
		
		Label labelSelectedDownloadFile = new Label();
		
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
		buttonTestConnection = new Button("Test Connection");
		buttonTestConnection.addClickHandler(event -> {
			//Window.alert("Test FOKING Connection:" + listBoxServers.getSelectedValue());
			Server server = ServerFactory.getServerByName(listBoxServers.getSelectedValue());
			callFTPLoginService(server);
		});
		this.add(buttonTestConnection);

		// download and process
		downloadProcessButton = new Button("Download and Process");
		downloadProcessButton.setVisible(false);
		downloadProcessButton.addClickHandler(event -> {
			Server server = ServerFactory.getServerByName(listBoxServers.getSelectedValue());
			callFTPDownloadFileService(server, labelSelectedDownloadFile.getText());
		});
		
		// available files
		labelAvailableFiles = new Label("Available Files:");
		this.add(labelAvailableFiles);
		
		panelFTPTransferAvailableFiles = new FTPTransferAvailableFilesPanel();
		panelFTPTransferAvailableFiles.setVisible(false);

		final SingleSelectionModel<FTPFileInfo> singleSelectionModel = new SingleSelectionModel<FTPFileInfo>();
		panelFTPTransferAvailableFiles.getModelTable().setSelectionModel(singleSelectionModel);
	    singleSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
	    	FTPFileInfo selectedFileInfo = singleSelectionModel.getSelectedObject();
	        if (selectedFileInfo != null) {
	          //Window.alert("Selected: " + selectedFileInfo.getName());
	        	labelSelectedDownloadFile.setText(selectedFileInfo.getName());
	        	downloadProcessButton.setVisible(true);
	        }
	      }
	    });		
		this.add(panelFTPTransferAvailableFiles);

		buttonGetAvailableFiles = new Button("Get Available Files");
		buttonGetAvailableFiles.addClickHandler(event -> {
			Server server = ServerFactory.getServerByName(listBoxServers.getSelectedValue());
			callFTPDirService(server);
		});
		this.add(buttonGetAvailableFiles);

		this.add(downloadProcessButton);
		
		labelFileStatus = new Label("");
		labelFileStatus.setStyleName("labelFileStatus");
		this.add(labelFileStatus);
	}

	private void showBillingRecords(String fileName) {
		Window.alert("KARALHO!!!");
		BillingRecordPanel panelBillingRecords = new BillingRecordPanel(fileName);
		this.add(panelBillingRecords);
		Window.alert("THE FOK!!!");
		JavaLabs.GET().showView(panelBillingRecords);
	}
	
	private void callFTPLoginService(Server server) {
		buttonTestConnection.getElement().getStyle().setCursor(Cursor.WAIT);
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);
		
		labelFileStatus.setText("Logging in...");
		
		ServiceFactory.FTP_SERVICE.login(server, new MethodCallback<String>() {

			@Override
			public void onSuccess(Method method, String response) {
				buttonTestConnection.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.removeStyleName("errorLbl");
				
				Window.alert("FTP login  - SUCCESS to server:\n" + server.getName() + ":" + server.getIpAddress());
				labelFileStatus.setText("FTP login  - SUCCESS to server:\n" + server.getName() + ":" + server.getIpAddress());
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				buttonTestConnection.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
				labelFileStatus.setText("FTP login  - FAILURE:\n"  + method.getResponse().getText());
		        Window.alert("FTP login  - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}

	private void callFTPDirService(Server server) {
		buttonGetAvailableFiles.getElement().getStyle().setCursor(Cursor.WAIT);
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);
		
		labelFileStatus.setText("Fetching files...");
		
		ServiceFactory.FTP_SERVICE.dir(server, new MethodCallback<List<FTPFileInfo>>() {

			@Override
			public void onSuccess(Method method, List<FTPFileInfo> response) {
				buttonGetAvailableFiles.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.removeStyleName("errorLbl");
				
				//Window.alert("FTP dir  - SUCCESS to server:\n" + server.getName() + ":" + server.getIpAddress());
				labelFileStatus.setText("FTP dir  - SUCCESS to server:\n" + server.getName() + ":" + server.getIpAddress());
				
				labelAvailableFiles.setText("Available Files (" + response.size() + "):");
				
				panelFTPTransferAvailableFiles.setVisible(true);
				panelFTPTransferAvailableFiles.setModel(response);
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				buttonGetAvailableFiles.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
				labelFileStatus.setText("FTP dir  - FAILURE:\n"  + method.getResponse().getText());
		        Window.alert("FTP dir  - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}

	private void callFTPDownloadFileService(Server server, String fileName) {
		buttonGetAvailableFiles.getElement().getStyle().setCursor(Cursor.WAIT);
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);

		labelFileStatus.setText("Downloading file...");
		
		DowloadFTPFileInfo fileInfo = new DowloadFTPFileInfo(server, fileName);

		ServiceFactory.FTP_SERVICE.downloadFile(fileInfo, new MethodCallback<String>() {

			@Override
			public void onSuccess(Method method, String response) {
				buttonGetAvailableFiles.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				labelFileStatus.setText("FTP downloadFile  - SUCCESS fileName:\n" + fileName);
				//Window.alert("FTP downloadFile  - SUCCESS fileName:\n" + fileName);
				
				callBillingProcessFileService(server, fileName);
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				buttonGetAvailableFiles.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
				labelFileStatus.setText("FTP downloadFile  - FAILURE:\n"  + method.getResponse().getText());
		        Window.alert("FTP downloadFile  - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}

	private void callBillingProcessFileService(Server server, String fileName) {
		buttonGetAvailableFiles.getElement().getStyle().setCursor(Cursor.WAIT);
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);

		labelFileStatus.setText("Processing file...");
		
		DowloadFTPFileInfo fileInfo = new DowloadFTPFileInfo(server, fileName);

		ServiceFactory.BILLING_SERVICE.processFile(fileInfo, new MethodCallback<String>() {

			@Override
			public void onSuccess(Method method, String response) {
				downloadProcessButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				labelFileStatus.setText("BILLING processFile - SUCCESS fileName:\n" + fileName);
				//Window.alert("BILLING processFile - SUCCESS fileName:\n" + fileName);

				showBillingRecords(fileName);
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				downloadProcessButton.getElement().getStyle().setCursor(Cursor.DEFAULT);
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//serverResponseLabel.addStyleName("errorLbl");
				//showDialogBox("Login  - FAILURE", method.getResponse().getText());
				
		        //errorLbl.setText(responseObj.get("message").isString().stringValue());
				labelFileStatus.setText("BILLING processFile - FAILURE:\n"  + method.getResponse().getText());
		        Window.alert("BILLING processFile - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}
	
}	
