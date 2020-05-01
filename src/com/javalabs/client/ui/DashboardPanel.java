package com.javalabs.client.ui;

import com.google.gwt.user.client.Window;

public class DashboardPanel extends TitledPanel {
	
	private static ColumnChartPanel columnChartPanel;

	public DashboardPanel() {
		super("Dashboard PROTOTYPE");
		
		this.setSpacing(20);		
		this.init();

	}
	
	private void init() {
		columnChartPanel = new ColumnChartPanel();
		this.add(columnChartPanel);
	}
}
