package com.javalabs.client.ui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.javalabs.shared.dto.BillingRecord;

public class BillingRecordPanel extends TitledPanel {

	private List<BillingRecord> BILLING_RECORDS;
	
	public BillingRecordPanel(String fileName) {
		super(/*"Imported Billing Records: " +*/ fileName.replace(".txt", ""));

		BILLING_RECORDS = Arrays.asList(
				new BillingRecord(1L, "fileName 1", new Date()),
				new BillingRecord(2L, "fileName 2", new Date()),
				new BillingRecord(3L, "fileName 3", new Date())
		);
		
		this.setSpacing(20);		
		this.init();
	}
	
	private void init() {

		  CellTable<BillingRecord> table = new CellTable<BillingRecord>();
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
		
		  // Set the total row count. This isn't strictly necessary,
		  // but it affects paging calculations, so its good habit to
		  // keep the row count up to date.
		  table.setRowCount(BILLING_RECORDS.size(), true);
		
		  // Push the data into the widget.
		  table.setRowData(0, BILLING_RECORDS);
		
		  VerticalPanel panel = new VerticalPanel();
		  panel.setBorderWidth(1);	    
		  panel.setWidth("400");
		  panel.add(table);
		
		  // Add the widgets to the root panel.
		  this.add(panel);
	}		

}
