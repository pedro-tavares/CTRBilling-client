package com.javalabs.client.ui;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.javalabs.shared.dto.BillingRecord;
import com.javalabs.shared.dto.DowloadFTPFileInfo;
import com.javalabs.shared.dto.FTPFileInfo;

public class FTPTransferAvailableFilesPanel extends VerticalPanel {

	private List<FTPFileInfo> AVAILABLE_FILES;
	private CellTable<FTPFileInfo> table;
	
	public FTPTransferAvailableFilesPanel() {
		super();

		AVAILABLE_FILES = Arrays.asList();
		
		this.setSpacing(20);		
		this.init();
	}
	
	private void init() {

		  table = new CellTable<FTPFileInfo>();
		  table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		  TextColumn<FTPFileInfo> idColumn = 
		  new TextColumn<FTPFileInfo>() {
		     @Override
		     public String getValue(FTPFileInfo object) {
		        return object.getName().toString();
		     }
		  };
		  table.addColumn(idColumn, "File Name");

		  TextColumn<FTPFileInfo> fileNameColumn = 
		  new TextColumn<FTPFileInfo>() {
		     @Override
		     public String getValue(FTPFileInfo object) {
		        return object.getDate().toString();
		     }
		  };
		  table.addColumn(fileNameColumn, "Date");
		
		  // Add a selection model to handle user selection.
		  final SingleSelectionModel<FTPFileInfo> selectionModel = new SingleSelectionModel<FTPFileInfo>();
		  table.setSelectionModel(selectionModel);
		  selectionModel.addSelectionChangeHandler(
		  new SelectionChangeEvent.Handler() {
		     public void onSelectionChange(SelectionChangeEvent event) {
		    	 FTPFileInfo selected = selectionModel.getSelectedObject();
		        if (selected != null) {
		           //Window.alert("You selected: " + selected.getId());
		        }
		     }
		  });
		
		  // Set the total row count. This isn't strictly necessary,
		  // but it affects paging calculations, so its good habit to
		  // keep the row count up to date.
		  table.setRowCount(AVAILABLE_FILES.size(), true);
		
		  // Push the data into the widget.
		  table.setRowData(0, AVAILABLE_FILES);
		
		  VerticalPanel panel = new VerticalPanel();
		  panel.setBorderWidth(1);	    
		  panel.setWidth("400");
		  panel.add(table);
		
		  // Add the widgets to the root panel.
		  this.add(panel);
	}		

	public void setModel(List<FTPFileInfo> model) {
		AVAILABLE_FILES = model;
		table.setRowData(0, AVAILABLE_FILES);
	}
	
	public CellTable<FTPFileInfo> getModelTable() {
		return table;
	}
	
}
