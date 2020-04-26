package com.javalabs.client.service;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.javalabs.IUIConstants;
import com.javalabs.shared.dto.DowloadFTPFileInfo;

//@Path("http://" + IUIConstants.SERVER + ":" + IUIConstants.PORT + "/billing")
@Path("http://83.170.124.17:" + IUIConstants.PORT + "/billing")
public interface IBillingService extends RestService {

	@POST
	@Path("/process_file")
	public void processFile(@BeanParam DowloadFTPFileInfo fileInfo, MethodCallback<String> callback);
	
}
