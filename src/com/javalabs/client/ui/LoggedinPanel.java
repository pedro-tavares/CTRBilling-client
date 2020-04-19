package com.javalabs.client.ui;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.javalabs.shared.dto.User;

public class LoggedinPanel extends HorizontalPanel {

	public LoggedinPanel(User user) {
		this.setStyleName("loggedinPanel");
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		Label loggedinLabel = new Label("Logged in as: " + user.getEmail());
		loggedinLabel.addStyleName("loggedinLabel");
		this.add(loggedinLabel);
		
		Image userAvatarImage = new Image("images/user_avatar.jpg");
		userAvatarImage.setPixelSize(50, 50);
		this.add(userAvatarImage);
	}
}
