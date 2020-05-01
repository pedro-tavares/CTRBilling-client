package com.javalabs.client.ui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.ColumnChart;
import com.googlecode.gwt.charts.client.corechart.ColumnChartOptions;
import com.googlecode.gwt.charts.client.options.HAxis;
import com.googlecode.gwt.charts.client.options.VAxis;
	
public class ColumnChartPanel extends VerticalPanel {

	private ColumnChart chart;
	
	public ColumnChartPanel() {
		super();
		//super(Unit.PX);
		
		init();
	}
	
	private void init() {
		
		ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
		chartLoader.loadApi(new Runnable() {

			@Override
			public void run() {
				// Create and attach the chart
				chart = new ColumnChart();
				add(chart);
				draw();
			}
		});
	}
	
	private void draw() {
		String[] countries = new String[] { "Austria", "Bulgaria", "Denmark", "Greece" };
		int[] years = new int[] { 2003, 2004, 2005, 2006, 2007, 2008 };
		int[][] values = new int[][] { { 1336060, 1538156, 1576579, 1600652, 1968113, 1901067 },
				{ 400361, 366849, 440514, 434552, 393032, 517206 },
				{ 1001582, 1119450, 993360, 1004163, 979198, 916965 },
				{ 997974, 941795, 930593, 897127, 1080887, 1056036 } };
	
		// Prepare the data
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Year");
		for (int i = 0; i < countries.length; i++) {
			dataTable.addColumn(ColumnType.NUMBER, countries[i]);
		}
		dataTable.addRows(years.length);
		for (int i = 0; i < years.length; i++) {
			dataTable.setValue(i, 0, String.valueOf(years[i]));
		}
		for (int col = 0; col < values.length; col++) {
			for (int row = 0; row < values[col].length; row++) {
				dataTable.setValue(row, col + 1, values[col][row]);
			}
		}
	
		// Set options
		ColumnChartOptions options = ColumnChartOptions.create();
		options.setFontName("Tahoma");
		options.setTitle("Call Information per day");
		options.setHAxis(HAxis.create("Calls"));
		options.setVAxis(VAxis.create("Day"));
	
		// Draw the chart
		chart.setPixelSize(500, 250);
		chart.draw(dataTable, options);
	}
}
