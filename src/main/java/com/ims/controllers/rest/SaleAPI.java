package com.ims.controllers.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Sale;
import com.ims.logic.SaleLogic;

@RestController 
@RequestMapping(value="/sale")
public class SaleAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="") 
	public List<Sale> getAllSales() {
		
		List<Sale> sales = SaleLogic.getAllSales();
		
		return sales;
	}
	
	@RequestMapping(value="/sail", method=RequestMethod.GET) 
	public Sale getSale(@RequestParam("ID") Integer id) {
		
		Sale sale = SaleLogic.getSale(id);
		
		return sale;
	}
	
	@RequestMapping(value="/retail", method=RequestMethod.GET) 
	public List<Sale> getSaleByRetailer(@RequestParam("ID") Integer id) {
		
		List<Sale> salesByRet = SaleLogic.getSalesByRetailer(id);
		
		return salesByRet;
	}
	
}	
	
	
	
	
	
	




