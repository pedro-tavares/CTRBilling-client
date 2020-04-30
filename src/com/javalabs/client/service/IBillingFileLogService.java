package com.javalabs.client.service;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.javalabs.IUIConstants;
import com.javalabs.shared.dto.BillingFileLog;

@Path("http://83.170.124.17:" + IUIConstants.PORT + "/billing_file_log")
public interface IBillingFileLogService extends RestService {

	@POST
	@Path("/get_billing_file_log_records")
	public void getBillingFileLogRecords(@BeanParam String dummy, MethodCallback<List<BillingFileLog>> methodCallback);
	
}
