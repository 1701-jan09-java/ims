package com.ims.controllers.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Product;
import com.ims.logic.ProductLogic;

@RestController
@RequestMapping(value="/product")
public class ProductAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		Product product = ProductLogic.getProduct(id);
		return product;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public List<Product> getAllProducts() {
		List<Product> products = ProductLogic.getAllProducts();
		return products;
	}
	
//	@RequestMapping(method=RequestMethod.GET, value="/", params={"limit","offset"})
//	public List<Product> getAllProducts(@RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
//		
//		List<Product> products = ProductLogic.getAllProducts();
//		return products;
//	}
		
}
