package com.javalabs.client.ui;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.CellPreviewEvent.Handler;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import com.javalabs.client.service.ServiceFactory;
import com.javalabs.shared.dto.BillingRecord;
import com.javalabs.shared.dto.BillingFileLog;;

public class BillingFileLogPanel extends TitledPanel {

	private List<BillingFileLog> BILLING_FILE_LOG_RECORDS;
	private CellTable<BillingFileLog> table;
	
	public BillingFileLogPanel() {
		super("Billing File Log");

		this.setSpacing(20);		
		this.init();

		callGetBillingFileLogRecordsService();
	}
	
	private void init() {

		  table = new CellTable<BillingFileLog>();
		  table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		  TextColumn<BillingFileLog> idColumn = new TextColumn<BillingFileLog>() {
		     @Override
		     public String getValue(BillingFileLog object) {
		        return object.getId().toString();
		     }
		  };
		  table.addColumn(idColumn, "ID");

		  TextColumn<BillingFileLog> fileNameColumn = new TextColumn<BillingFileLog>() {
		     @Override
		     public String getValue(BillingFileLog object) {
		        return object.getFileName().toString();
		     }
		  };
		  table.addColumn(fileNameColumn, "File name");

		  TextColumn<BillingFileLog> typeColumn = new TextColumn<BillingFileLog>() {
		     @Override
		     public String getValue(BillingFileLog object) {
		        return object.getType().toString();
		     }
		  };
		  table.addColumn(typeColumn, "UP/Down");
		  

		  SimplePager.Resources resources = GWT.create(SimplePager.Resources.class); 
		  SimplePager simplePager = new SimplePager(TextLocation.CENTER, resources , false, 0, true);
		  simplePager.setDisplay(table);
		  simplePager.setPageSize(5);
		  this.add(simplePager);

		  // Add a selection model to handle user selection.
		  final SingleSelectionModel<BillingFileLog> selectionModel = new SingleSelectionModel<BillingFileLog>();
		  table.setSelectionModel(selectionModel);
		  selectionModel.addSelectionChangeHandler(
		  new SelectionChangeEvent.Handler() {
		     public void onSelectionChange(SelectionChangeEvent event) {
		    	 BillingFileLog selected = selectionModel.getSelectedObject();
		        if (selected != null) {
		        	Window.alert("You selected: " + selected.getId());
		        }
		     }
		  });
		  
		  VerticalPanel panel = new VerticalPanel();
		  panel.setBorderWidth(1);	    
		  panel.setWidth("400");
		  panel.add(table);
		
		  // Add the widgets to the root panel.
		  this.add(panel);
	}		

	public void setModel(List<BillingFileLog> model) {
		BILLING_FILE_LOG_RECORDS = model;
		
		GWT.log("BILLING_FILE_LOG.size: " + BILLING_FILE_LOG_RECORDS.size());
		
		table.setPageSize(50);
		table.setRowData(0, BILLING_FILE_LOG_RECORDS);
		table.setRowCount(BILLING_FILE_LOG_RECORDS.size(), true);
	}
	
	private void callGetBillingFileLogRecordsService() {
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);
		
		ServiceFactory.BILLING_FILE_LOG_SERVICE.getBillingFileLogRecords("", new MethodCallback<List<BillingFileLog>>() {

			@Override
			public void onSuccess(Method method, List<BillingFileLog> response) {
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//Window.alert("BILLING getBillingFileLogRecords - SUCCESS\n");
				
				setModel(response);
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
		        Window.alert("BILLING getBillingFileLogRecords - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}
	
}
