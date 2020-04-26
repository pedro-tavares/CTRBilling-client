package com.javalabs.client.service;

import com.google.gwt.core.client.GWT;

public class ServiceFactory {

	public static final IUserService USER_SERVICE = GWT.create(IUserService.class);
	public static final IFTPService FTP_SERVICE = GWT.create(IFTPService.class);
	public static final IBillingService BILLING_SERVICE = GWT.create(IBillingService.class);

}
