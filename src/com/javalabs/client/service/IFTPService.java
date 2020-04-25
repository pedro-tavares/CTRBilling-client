package com.javalabs.client.service;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.javalabs.IUIConstants;
import com.javalabs.shared.dto.DowloadFTPFileInfo;
import com.javalabs.shared.dto.FTPFileInfo;
import com.javalabs.shared.dto.Server;

//@Path("http://" + IUIConstants.SERVER + ":" + IUIConstants.PORT + "/ftp")
@Path("http://83.170.124.17:" + IUIConstants.PORT + "/ftp")
public interface IFTPService extends RestService {

	@POST
	@Path("/login")
	public void login(@BeanParam Server server, MethodCallback<String> callback);

	@POST
	@Path("/dir")
	public void dir(@BeanParam Server server, MethodCallback<List<FTPFileInfo>> callback);
	
	@POST
	@Path("/download_file")
	public void downloadFile(@BeanParam DowloadFTPFileInfo fileInfo, MethodCallback<String> callback);

}
