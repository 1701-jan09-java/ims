package com.ims.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Supplier;
import com.ims.logic.SupplierLogic;

@RestController 
@RequestMapping(value="/supplier")
public class SupplierAPI {
	
	@Autowired
	private SupplierLogic supplierLogic;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Supplier getSupplier(@PathVariable("id") Integer id) {
		
		Supplier supplier = supplierLogic.getSupplier(id);
		
		return supplier;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public List<Supplier> getAllSuppliers() {
		
		List<Supplier> suppliers = supplierLogic.getAllSuppliers();
		
		return suppliers;
		
	}
	
	
}
