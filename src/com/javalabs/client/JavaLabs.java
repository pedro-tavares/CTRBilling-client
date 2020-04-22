package com.javalabs.client;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.dispatcher.DefaultFilterawareDispatcher;
import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;
import com.javalabs.client.ui.CenterPanel;
import com.javalabs.client.ui.LoggedinPanel;
import com.javalabs.client.ui.LoginPanel;
import com.javalabs.client.ui.MenuPanel;
import com.javalabs.shared.dto.User;

public class JavaLabs implements EntryPoint {

	private static JavaLabs INSTANCE;
	private static User user;
	
	private static CenterPanel centerPanel = new CenterPanel();
	private static LoginPanel loginPanel = new LoginPanel();
	private static Image 
		centerImg,
		centerImgLoggedIn;
	//private static Image loginImg;
	private static HorizontalPanel topPanel;
	private static LoggedinPanel loggedinPanel;
	private static MenuPanel menuPanel;
	
	@Override
	public void onModuleLoad() {
		INSTANCE = this;
		createUI();
		doSTUFF();
	}

	public static JavaLabs GET() {
		return INSTANCE;
	}
	
	private void createUI() {
				
		centerImg = new Image("images/login.png");
		centerImg.setStyleName("centerImg");
		RootPanel.get().add(centerImg, 0, 76);
		
		topPanel = new HorizontalPanel();
		topPanel.setStyleName("topPanel");
		topPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		//Image logoImg = new Image("images/JavaLabs_Logo.jpg");
		Image logoImg = new Image("images/Spiro_Logo.png");
		logoImg.setStyleName("logoImg");
		logoImg.setPixelSize(199, 75);
		
		RootPanel.get().add(topPanel, 0, 0);
		topPanel.add(logoImg);
		topPanel.setCellHorizontalAlignment(logoImg, HasHorizontalAlignment.ALIGN_LEFT);
		
		loginPanel.setStyleName("loginPanel");
		topPanel.add(loginPanel);
		
		resize();
		
		Window.addResizeHandler(new ResizeHandler() {

			@Override
			public void onResize(ResizeEvent event) {
				resize();				
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
			topPanel.add(loginPanel);
		}

	}
	
	private static void resize() {
		if (menuPanel != null) {
			menuPanel.setPixelSize(200, Window.getClientHeight() - 75);
		}
	}
	
	public static void letsGo(User userLetsGo) {
		user = userLetsGo;
		setCookie();
		
		loginPanel.removeFromParent();

		centerImg.removeFromParent();
		centerImgLoggedIn = new Image("images/login_greyscale.png");
		centerImgLoggedIn.setStyleName("centerImgLoggedin");
		RootPanel.get().add(centerImgLoggedIn, 201, 76);

		topPanel.removeFromParent();
		topPanel.setStyleName("topPanel");
		topPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		RootPanel.get().add(topPanel, 0, 0);
		
		loggedinPanel = new LoggedinPanel(user);
		loggedinPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.add(loggedinPanel);

		doMenu();
	}
	
	public static void logOut() {
		deleteCookie();
		
		centerImgLoggedIn.removeFromParent();
		centerImg = new Image("images/login.png");
		centerImg.setStyleName("centerImg");
		RootPanel.get().add(centerImg, 0, 76);
		
		menuPanel.removeFromParent();
		
		loginPanel.clear();
		
		topPanel.remove(loggedinPanel);
		topPanel.add(loginPanel);		
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
	
	private static void doMenu() {
		/*
		 menuPanel = new StackLayoutPanel(Unit.EM);   
		 menuPanel.add(new HTML("Dashboard"), new HTML("Dashboard"), 4);   
		 menuPanel.add(new HTML("Customers"), new HTML("Customers"), 4);  
		 menuPanel.add(new HTML("Telephone"), new HTML("Telephone"), 4);
		 menuPanel.add(new HTML("Products"), new HTML("Products"), 4);
		 menuPanel.add(new HTML("Products"), new HTML(""), 4);
		 menuPanel.add(new HTML("Rate Scheme"), new HTML(""), 4);
		 menuPanel.add(new HTML("Invoice Group"), new HTML(""), 4);
		 menuPanel.add(new HTML("Invoice History"), new HTML(""), 4);
		 menuPanel.add(new HTML("File History"), new HTML(""), 4);
		 menuPanel.add(new HTML("Reports"), new HTML(""), 4);
		 menuPanel.add(new HTML("File Upload"), new HTML(""), 4);
		 */
		 
		 menuPanel = new MenuPanel();
		 
		 RootPanel.get().add(menuPanel, 0, 76);
		 
		 resize();
	}

	public void showView(Panel viewPanel) {
		Window.alert("showView:\n" + viewPanel.toString());
		
		RootPanel.get().add(viewPanel, 201, 76);		
	}
	
	// EXPERIMENTS *************************************************************************************************
	private void doSTUFF() {
		
	}
}
