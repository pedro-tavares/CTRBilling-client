package com.javalabs.client;

import java.io.UnsupportedEncodingException;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.dispatcher.DefaultFilterawareDispatcher;
import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;
import com.javalabs.client.ui.CenterPanel;
import com.javalabs.client.ui.LoggedinPanel;
import com.javalabs.client.ui.LoginPanel;
import com.javalabs.shared.dto.User;

public class JavaLabs implements EntryPoint {

	private static User user;
	
	private static CenterPanel centerPanel = new CenterPanel();
	private static LoginPanel loginPanel = new LoginPanel();
	private static Image centerImg;
	private static HorizontalPanel topPanel;
	
	@Override
	public void onModuleLoad() {
		addAuthHeaders();
		createUI();
	}

	private void addAuthHeaders() {
		Defaults.setDispatcher(new DefaultFilterawareDispatcher(new DispatcherFilter() {

			@Override
			public boolean filter(Method method, RequestBuilder builder) {
				try {
					String basicAuthHeaderValue = createBasicAuthHeader("user", "user");
					builder.setHeader("Authorization", basicAuthHeaderValue);
				} catch (UnsupportedEncodingException e) {
					return false;
				}
				return true;
			}

			private String createBasicAuthHeader(String userName, String password) throws UnsupportedEncodingException {
				String credentials = userName + ":" + password;
				String encodedCredentials = new String(Base64.encode(credentials.getBytes()), "UTF-8");
				return "Basic " + encodedCredentials;
			}
		}));

	}
	
	private void createUI() {
				
		centerImg = new Image("images/background.png");
		centerImg.setStyleName("centerImg");
		RootPanel.get().add(centerImg, 0, 0);
		
		topPanel = new HorizontalPanel();
		topPanel.setStyleName("topPanel");
		//Image logoImg = new Image("images/JavaLabs_Logo.jpg");
		Image logoImg = new Image("images/Spiro_Logo.png");
		logoImg.setPixelSize(199, 75);
		topPanel.add(logoImg);
		RootPanel.get().add(topPanel, 0, 0);
		
		resize();
		
		Window.addResizeHandler(new ResizeHandler() {
			
			  Timer resizeTimer = new Timer() {  
			    @Override
			    public void run() {
			      resize();
			    }
			  };

			  @Override
			  public void onResize(ResizeEvent event) {
			    resizeTimer.cancel();
			    resizeTimer.schedule(10);
			  }
			});
		
		createCenterPanel();
	}
	
	private void createCenterPanel() {
		RootPanel.get().add(centerPanel, 0, 150);
		centerPanel.add(loginPanel);	

	}
	
	private void resize() {
	}
	
	public static void letsGo(User user) {
		centerPanel.remove(loginPanel);

		centerImg.removeFromParent();
		centerImg = new Image("images/background_greyscale.png");
		centerImg.setStyleName("centerImg");
		RootPanel.get().add(centerImg, 0, 0);

		topPanel.removeFromParent();
		topPanel.setStyleName("topPanel");
		topPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		RootPanel.get().add(topPanel, 0, 0);
		
		LoggedinPanel loggedinPanel = new LoggedinPanel(user);
		loggedinPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.add(loggedinPanel);
	}
}
