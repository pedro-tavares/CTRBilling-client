package com.javalabs.client.service;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.javalabs.shared.dto.User;

@Path("http://localhost:8088" + "/user")
public interface IUserService extends RestService {

	@POST
	@Path("/login")
	public void login(@BeanParam User user, MethodCallback<User> callback);
	
	@POST
	@Path("/save")
	public void save(@BeanParam User user, MethodCallback<User> callback);

	@GET
	@Path("/getAll")
	public void getAll(MethodCallback<List<User>> callback);
	
}
