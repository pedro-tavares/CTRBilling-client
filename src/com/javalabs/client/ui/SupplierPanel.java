package com.javalabs.client.ui;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.javalabs.client.service.ServiceFactory;
import com.javalabs.shared.dto.Supplier;;

public class SupplierPanel extends TitledPanel {

	private List<Supplier> SUPPLIER_DATA;
	private CellTable<Supplier> table;
	
	public SupplierPanel() {
		super("Suppliers");

		this.setSpacing(20);		
		this.init();

		callGetSuppliersService();
	}
	
	private void init() {

		  table = new CellTable<Supplier>();
		  table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		  TextColumn<Supplier> idColumn = new TextColumn<Supplier>() {
		     @Override
		     public String getValue(Supplier object) {
		        return object.getId().toString();
		     }
		  };
		  table.addColumn(idColumn, "ID");

		  TextColumn<Supplier> fileNameColumn = new TextColumn<Supplier>() {
		     @Override
		     public String getValue(Supplier object) {
		        return object.getName().toString();
		     }
		  };
		  table.addColumn(fileNameColumn, "Name");

		  TextColumn<Supplier> typeColumn = new TextColumn<Supplier>() {
		     @Override
		     public String getValue(Supplier object) {
		        return object.getEmail().toString();
		     }
		  };
		  table.addColumn(typeColumn, "Email");
		  

		  SimplePager.Resources resources = GWT.create(SimplePager.Resources.class); 
		  SimplePager simplePager = new SimplePager(TextLocation.CENTER, resources , false, 0, true);
		  simplePager.setDisplay(table);
		  simplePager.setPageSize(5);
		  this.add(simplePager);

		  // Add a selection model to handle user selection.
		  final SingleSelectionModel<Supplier> selectionModel = new SingleSelectionModel<Supplier>();
		  table.setSelectionModel(selectionModel);
		  selectionModel.addSelectionChangeHandler(
		  new SelectionChangeEvent.Handler() {
		     public void onSelectionChange(SelectionChangeEvent event) {
		    	 Supplier selected = selectionModel.getSelectedObject();
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

	public void setModel(List<Supplier> model) {
		SUPPLIER_DATA = model;

		
		
		GWT.log("SUPPLIER_RECORDS.size: " + SUPPLIER_DATA.size());
		
		table.setPageSize(50);
		table.setRowData(0, SUPPLIER_DATA);
		table.setRowCount(SUPPLIER_DATA.size(), true);
	}
	
	private void callGetSuppliersService() {
		RootPanel.getBodyElement().getStyle().setCursor(Cursor.WAIT);
		
		ServiceFactory.SUPPLIER_SERVICE.getSuppliers(new MethodCallback<List<Supplier>>() {

			@Override
			public void onSuccess(Method method, List<Supplier> response) {
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
				//Window.alert("callGetSuppliersService - SUCCESS\n");
				
				setModel(response);
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				RootPanel.getBodyElement().getStyle().setCursor(Cursor.DEFAULT);
				
		        Window.alert("callGetSuppliersService - FAILURE:\n"  + method.getResponse().getText());
			}
		});
	}
	
}
