package com.ims.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Sale;
import com.ims.logic.SaleLogic;

@RestController 
@RequestMapping(value="/sale")
public class SaleAPI {
	
	@Autowired
	private SaleLogic saleLogic;
	
	@RequestMapping(method=RequestMethod.GET, value="") 
	public List<Sale> getAllSales() {
		
		List<Sale> sales = saleLogic.getAllSales();
		
		return sales;
	}
	
	@RequestMapping(value="/sail", method=RequestMethod.GET) 
	public Sale getSale(@RequestParam("id") Integer id) {
		
		Sale sale = saleLogic.getSale(id);
		
		return sale;
	}
	
	@RequestMapping(value="/retail", method=RequestMethod.GET) 
	public List<Sale> getSaleByRetailer(@RequestParam("id") Integer id) {
		
		List<Sale> salesByRet = saleLogic.getSalesByRetailer(id);
		
		return salesByRet;
	}
	
}	
	
	
	
	
	
	




