package com.javalabs.client.ui;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.javalabs.client.service.ServiceFactory;
import com.javalabs.shared.dto.BillingRecord;

public class BillingRecordPanel extends TitledPanel {

	private List<BillingRecord> BILLING_RECORDS;
	private CellTable<BillingRecord> table;
	
	public BillingRecordPanel(String fileName) {
		super(/*"Imported Billing Records: " +*/ fileName.replace(".txt", ""));

		/*
		BILLING_RECORDS = Arrays.asList(
				new BillingRecord(1L, "fileName 1", new Date()),
				new BillingRecord(2L, "fileName 2", new Date()),
				new BillingRecord(3L, "fileName 3", new Date())
		);
		*/
		
		this.setSpacing(20);		
		this.init();

		callBillingGetBillingRecordsService(fileName);
	}
	
	private void init() {

		  table = new CellTable<BillingRecord>();
		  table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		  TextColumn<BillingRecord> idColumn = 
		  new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getId().toString();
		     }
		  };
		  table.addColumn(idColumn, "ID");

		  TextColumn<BillingRecord> fileNameColumn = 
		  new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getFileName().toString();
		     }
		  };
		  table.addColumn(fileNameColumn, "FileName");
		  
		  TextColumn<BillingRecord> timestampColumn = 
		  new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getTimestamp().toString();
		     }
		  };
		  table.addColumn(timestampColumn, "Imported on");
		
		  // Add a selection model to handle user selection.
		  final SingleSelectionModel<BillingRecord> selectionModel 
		  = new SingleSelectionModel<BillingRecord>();
		  table.setSelectionModel(selectionModel);
		  selectionModel.addSelectionChangeHandler(
		  new SelectionChangeEvent.Handler() {
		     public void onSelectionChange(SelectionChangeEvent event) {
		    	 BillingRecord selected = selectionModel.getSelectedObject();
		        if (selected != null) {
		           //Window.alert("You selected: " + selected.getId());
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

	public void setModel(List<BillingRecord> model) {
		BILLING_RECORDS = model;
		table.setPageSize(50);
		table.setRowData(0, BILLING_RECORDS);
		table.setRowCount(BILLING_RECORDS.size(), true);
	}
	
	private void callBillingGetBillingRecordsService(String fileName) {
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);

		ServiceFactory.BILLING_SERVICE.getBillingRecords(fileName, new MethodCallback<List<BillingRecord>>() {

			@Override
			public void onSuccess(Method method, List<BillingRecord> response) {
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//Window.alert("BILLING getBillingRecords - SUCCESS fileName:\n" + fileName);

				setModel(response);
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
		        Window.alert("BILLING getBillingRecords - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}
	
}
