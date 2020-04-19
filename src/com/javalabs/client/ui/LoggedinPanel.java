package com.javalabs.client.ui;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.javalabs.shared.dto.User;

public class LoggedinPanel extends HorizontalPanel {

	public LoggedinPanel(User user) {
		Label loggedinLabel = new Label("Logged in as: " + user.getEmail());
		loggedinLabel.addStyleName("loggedinLabel");
		this.add(loggedinLabel);
	}
}
