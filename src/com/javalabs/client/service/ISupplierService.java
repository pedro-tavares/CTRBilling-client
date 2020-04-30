package com.javalabs.client.service;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.javalabs.IUIConstants;
import com.javalabs.shared.dto.Supplier;

@Path("http://83.170.124.17:" + IUIConstants.PORT + "/supplier")
public interface ISupplierService extends RestService {

	@POST
	@Path("/save")
	public void saveSupplier(@BeanParam Supplier supplier, MethodCallback<String> methodCallback);
	
	@POST
	@Path("/get_suppliers")
	public void getSuppliers(MethodCallback<List<Supplier>> methodCallback);
	
}
