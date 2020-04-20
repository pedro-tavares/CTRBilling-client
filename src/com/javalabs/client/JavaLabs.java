package com.javalabs.client;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.dispatcher.DefaultFilterawareDispatcher;
import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Cookies;
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
import com.javalabs.client.ui.MenuStackPanel;
import com.javalabs.shared.dto.User;

public class JavaLabs implements EntryPoint {

	private static User user;
	
	private static CenterPanel centerPanel = new CenterPanel();
	private static LoginPanel loginPanel = new LoginPanel();
	private static Image centerImg;
	private static HorizontalPanel topPanel;
	private static LoggedinPanel loggedinPanel;
	
	@Override
	public void onModuleLoad() {
		createUI();
	}
	
	private void createUI() {
				
		centerImg = new Image("images/background_greyscale.png");
		centerImg.setStyleName("centerImg");
		RootPanel.get().add(centerImg, 0, 0);
		
		topPanel = new HorizontalPanel();
		topPanel.setStyleName("topPanel");
		//Image logoImg = new Image("images/JavaLabs_Logo.jpg");
		Image logoImg = new Image("images/Spiro_Logo.png");
		logoImg.setPixelSize(199, 75);
		topPanel.add(logoImg);
		RootPanel.get().add(topPanel, 0, 0);

		loginPanel.setStyleName("loginPanel");
		
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
		
		String userEmail = getCookie();
		if (userEmail != null) {
			user = new User();
			user.setEmail(userEmail);
			letsGo(user);
			
		} else {
			centerPanel.add(loginPanel);
		}

	}
	
	private void resize() {
	}
	
	public static void letsGo(User userLetsGo) {
		user = userLetsGo;
		setCookie();
		
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
		
		loggedinPanel = new LoggedinPanel(user);
		loggedinPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.add(loggedinPanel);
		
		MenuStackPanel menuPanel = new MenuStackPanel();
		menuPanel.setStyleName("menuPanel");
		RootPanel.get().add(menuPanel, 0, 0);
		
	}
	
	public static void logOut() {
		deleteCookie();
		
		centerImg.removeFromParent();
		centerImg = new Image("images/background.png");
		centerImg.setStyleName("centerImg");
		RootPanel.get().add(centerImg, 0, 0);		
		
		loginPanel.clear();
		
		topPanel.remove(loggedinPanel);
		centerPanel.add(loginPanel);		
	}
	
	private static void setCookie() {
		if (Cookies.isCookieEnabled()) {
			final long DURATION = 1000 * 60 * 60 * 24 * 7; //duration remembering login - 1 week
			Date expires = new Date(System.currentTimeMillis() + DURATION);
	
			Cookies.setCookie("SPIRO", user.getEmail(), expires, null, "/", false);
		}
	}
	
	private static String getCookie() {
		if (Cookies.isCookieEnabled()) {
			return Cookies.getCookie("SPIRO");
		}
		return null;
	}
	
	private static void deleteCookie() {
		if (Cookies.isCookieEnabled()) {
			Cookies.removeCookie("SPIRO");
		}
	}
}
