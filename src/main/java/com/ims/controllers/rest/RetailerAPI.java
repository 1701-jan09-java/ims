package com.ims.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Retailer;
import com.ims.logic.RetailerLogic;

@RestController 
@RequestMapping(value="/retailer")
public class RetailerAPI {
	
	@Autowired
	private RetailerLogic retailerLogic;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Retailer getRetailer(@PathVariable("id") Integer id) {
		
		Retailer retailer = retailerLogic.viewRetailerById(id);
		
		return retailer;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public List<Retailer> getAllRetailers() {
		
		List<Retailer> retailers = retailerLogic.viewAllRetailers();
		
		return retailers;
		
	}
	
	
}
