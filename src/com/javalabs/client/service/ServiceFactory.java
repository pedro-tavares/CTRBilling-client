package com.javalabs.client.service;

import com.google.gwt.core.client.GWT;

public class ServiceFactory {

	public static final IUserService USER_SERVICE = GWT.create(IUserService.class);
	public static final IFTPService FTP_SERVICE = GWT.create(IFTPService.class);
	public static final IBillingService BILLING_SERVICE = GWT.create(IBillingService.class);
	public static final IBillingFileLogService BILLING_FILE_LOG_SERVICE = GWT.create(IBillingFileLogService.class);
	public static final ISupplierService SUPPLIER_SERVICE = GWT.create(ISupplierService.class);

}
