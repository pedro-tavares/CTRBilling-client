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
		
		  TextColumn<BillingRecord> idColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getId().toString();
		     }
		  };
		  table.addColumn(idColumn, "ID");

/*		  
		  TextColumn<BillingRecord> fileNameColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getFileName().toString();
		     }
		  };
		  table.addColumn(fileNameColumn, "File");
*/
/*
		  TextColumn<BillingRecord> timestampColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getTimestamp().toString();
		     }
		  };
		  table.addColumn(timestampColumn, "Imported on");
*/
/*
		  TextColumn<BillingRecord> callTypeColumn = 
		  new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getCallType().toString();
		     }
		  };
		  table.addColumn(callTypeColumn, "Call Type");
*/
/*		  
		  TextColumn<BillingRecord> callCauseColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getCallCause().toString();
		     }
		  };
		  table.addColumn(callCauseColumn, "Call Cause");
*/
		  TextColumn<BillingRecord> customerIdentifirColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getCustomerIdentifir().toString();
		     }
		  };
		  table.addColumn(customerIdentifirColumn, "Customer Identifier");

		  TextColumn<BillingRecord> telephoneNumberDialledColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getTelephoneNumberDialled().toString();
		     }
		  };
		  table.addColumn(telephoneNumberDialledColumn, "Telephone Number Dialled");

		  TextColumn<BillingRecord> callDateColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getCallDate().toString();
		     }
		  };
		  table.addColumn(callDateColumn, "Call Date");

		  TextColumn<BillingRecord> callTimeColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getCallTime().toString();
		     }
		  };
		  table.addColumn(callTimeColumn, "Call Time");

		  TextColumn<BillingRecord> durationColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getDuration().toString();
		     }
		  };
		  table.addColumn(durationColumn, "Duration");
/*
		  TextColumn<BillingRecord> bytesTransmittedColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getBytesTransmitted().toString();
		     }
		  };
		  table.addColumn(bytesTransmittedColumn, "Bytes Transmitted");
*/
/*		  
		  TextColumn<BillingRecord> bytesReceivedColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getBytesReceived().toString();
		     }
		  };
		  table.addColumn(bytesReceivedColumn, "Bytes Received");
*/
/*		  
		  TextColumn<BillingRecord> descriptionColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getDescription().toString();
		     }
		  };
		  table.addColumn(descriptionColumn, "Description");
*/
		  TextColumn<BillingRecord> chargeCodeColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getChargecode().toString();
		     }
		  };
		  table.addColumn(chargeCodeColumn, "Charge Code");
/*
		  TextColumn<BillingRecord> timeBandColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getTimeBand().toString();
		     }
		  };
		  table.addColumn(timeBandColumn, "Time Band");
*/
/*		  
		  TextColumn<BillingRecord> salesPriceColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getSalesprice().toString();
		     }
		  };
		  table.addColumn(salesPriceColumn, "Sales Price");
*/
		  TextColumn<BillingRecord> salesPricePreBundleColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getSalespricePreBundle().toString();
		     }
		  };
		  table.addColumn(salesPricePreBundleColumn, "Sales Price (Pre Bundle)");

		  TextColumn<BillingRecord> extensionColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return object.getExtension().toString();
		     }
		  };
		  table.addColumn(extensionColumn, "Extension");

/*		  
		  TextColumn<BillingRecord> DDIBundleColumn = new TextColumn<BillingRecord>() {
		     @Override
		     public String getValue(BillingRecord object) {
		        return (object.getDDI() != null) ? object.getDDI() : "";
		     }
		  };
		  table.addColumn(DDIBundleColumn, "DDI");		  
*/
/*		  
		  TextColumn<BillingRecord> groupingIDColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getGroupingID().toString();
			  }
		  };
		  table.addColumn(groupingIDColumn, "Grouping ID");
*/
/*		  
		  TextColumn<BillingRecord> callClassColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getCallClass().toString();
			  }
		  };
		  table.addColumn(callClassColumn, "Call Class");
*/
/*		  
		  TextColumn<BillingRecord> carrierColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getCarrier().toString();
			  }
		  };
		  table.addColumn(carrierColumn, "Carrier");
*/
/*		  
		  TextColumn<BillingRecord> recordingColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getRecording().toString();
			  }
		  };
		  table.addColumn(recordingColumn, "Recording");
*/
/*		  
		  TextColumn<BillingRecord> VATColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return (object.getVAT() != null) ? object.getVAT() : "";
			  }
		  };
		  table.addColumn(VATColumn, "VAT");
*/
/*		  
		  TextColumn<BillingRecord> countryOfOriginColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getCountryOfOrigin().toString();
			  }
		  };
		  table.addColumn(countryOfOriginColumn, "Country Of Origin");
*/
/*		  
		  TextColumn<BillingRecord> networkColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getNetwork().toString();
			  }
		  };
		  table.addColumn(networkColumn, "Network");
*/
/*		  
		  TextColumn<BillingRecord> retailTariffCodeColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getRetailTariffCode().toString();
			  }
		  };
		  table.addColumn(retailTariffCodeColumn, "Retail Tariff Code");
*/
/*		  
		  TextColumn<BillingRecord> remoteNetworkColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getRemoteNetwork().toString();
			  }
		  };
		  table.addColumn(remoteNetworkColumn, "Remote Network");
*/
/*		  
		  TextColumn<BillingRecord> apnColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return (object.getAPN() != null) ? object.getAPN() : "";
			  }
		  };
		  table.addColumn(apnColumn, "APN");
*/
/*		  
		  TextColumn<BillingRecord> divertedNumberColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getDivertedNumber().toString();
			  }
		  };
		  table.addColumn(divertedNumberColumn, "Diverted Number");
*/
/*		  
		  TextColumn<BillingRecord> ringTimeColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getRingTime().toString();
			  }
		  };
		  table.addColumn(ringTimeColumn, "Ring Time");
*/
/*		  
		  TextColumn<BillingRecord> recordIDColumn = new TextColumn<BillingRecord>() {
			  @Override
			  public String getValue(BillingRecord object) {
				  return object.getRecordID().toString();
			  }
		  };
		  table.addColumn(recordIDColumn, "Record ID");
*/

		  SimplePager.Resources resources = GWT.create(SimplePager.Resources.class); 
		  SimplePager simplePager = new SimplePager(TextLocation.CENTER, resources , false, 0, true);
		  simplePager.setDisplay(table);
		  simplePager.setPageSize(5);
		  this.add(simplePager);

		  // Add a selection model to handle user selection.
		  final SingleSelectionModel<BillingRecord> selectionModel = new SingleSelectionModel<BillingRecord>();
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
		
		GWT.log("BILLING_RECORDS.size: " + BILLING_RECORDS.size());
		
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
