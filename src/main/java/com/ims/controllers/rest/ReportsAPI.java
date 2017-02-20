package com.ims.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Product;
import com.ims.domain.Retailer;
import com.ims.domain.Supplier;
import com.ims.logic.ReportsLogic;

@RestController
@RequestMapping(value="/reports")
public class ReportsAPI {
	
	@Autowired
	private ReportsLogic reportsLogic;
	
	//Fongi
	//Pie localhost:8080/ims/reports/dollars-by-product
	@RequestMapping(method=RequestMethod.GET, value="/dollars-by-product")
	public List<Product> sellDollarsByProduct() {
		List<Product> productList = reportsLogic.sellDollarsByProduct();
		return productList;
	}
	
	//Anthony
	//Pie
	@RequestMapping(method=RequestMethod.GET, value="/quantity-by-product")
	public List<Product> sellQuantityByProduct() {
		List<Product> productList = reportsLogic.sellQuantityByProduct();
		return productList;
	}
	
	//Fongi
	//Bar localhost:8080/ims/reports/avg-dollars-by-product
	@RequestMapping(method=RequestMethod.GET, value="/avg-dollars-by-product")
	public List<Product> avgSellDollarsByProduct() {
		List<Product> productList = reportsLogic.avgSellDollarsByProduct();
		return productList;
	}
	
	//Anthony
	//Polar
	@RequestMapping(method=RequestMethod.GET, value="/avg-quantity-by-product")
	public List<Product> avgQuantityByProduct() {
		List<Product> productList = reportsLogic.avgQuantityByProduct();
		return productList;
	}
	
	//Anthony
	//Radar
	@RequestMapping(method=RequestMethod.GET, value="/dollars-by-retailer")
	public List<Retailer> sellDollarsByRetailer() {
		List<Retailer> retailers = reportsLogic.sellDollarsByRetailer();
		return retailers;
	}
	
	//Anthony
	//Bar
	@RequestMapping(method=RequestMethod.GET, value="/quantity-by-retailer")
	public List<Retailer> sellQuantityByRetailer() {
		List<Retailer> retailers = reportsLogic.sellQuantityByRetailer();
		return retailers;
	}
	
	//Fongi
	//Bar localhost:8080/ims/reports/dollars-by-supplier
	@RequestMapping(method=RequestMethod.GET, value="/dollars-by-supplier")
	public List<Supplier> sellDollarsBySupplier() {
		List<Supplier> suppliers = reportsLogic.sellDollarsBySupplier();
		return suppliers;
	}
	
	//Fongi
	//Radar localhost:8080/ims/reports/quantity-by-supplier
	@RequestMapping(method=RequestMethod.GET, value="/quantity-by-supplier")
	public List<Supplier> sellQuantityBySupplier() {
		List<Supplier> suppliers = reportsLogic.sellQuantityBySupplier();
		return suppliers;
	}
	
	//bubble chart
	//Fongi  localhost:8080/ims/reports/inventory-by-product-by-retailer
	@RequestMapping(method=RequestMethod.GET, value="/inventory-by-product-by-retailer")
	public List<Product> inventoryByProductByRetailer() {
		List<Product> productList = reportsLogic.inventoryByProductByRetailer();
		return productList;
	}
	
	//bubble chart
	//Anthony
	@RequestMapping(method=RequestMethod.GET, value="/avg-inventory-by-product-by-retailer")
	public List<Product> avgInventoryByProductByRetailer() {
		List<Product> productList = reportsLogic.avgInventoryByProductByRetailer();
		return productList;
	}
	
	//Fongi
	//Polar localhost:8080/ims/reports/inventory-threshold-by-product
	@RequestMapping(method=RequestMethod.GET, value="/inventory-threshold-by-product")
	public List<Product> inventoryThresholdByProduct() {
		List<Product> productList = reportsLogic.inventoryThresholdByProduct();
		return productList;
	}
	
	//bubble chart
	//Anthony
	@RequestMapping(method=RequestMethod.GET, value="/inventory-threshold-by-product-by-retailer")
	public List<Product> inventoryThresholdByProductByRetailer() {
		List<Product> productList = reportsLogic.inventoryThresholdByProductByRetailer();
		return productList;
	}
	
	//Anthony
	//Pie
	@RequestMapping(method=RequestMethod.GET, value="/inventory-by-product")
	public List<Product> inventoryByProduct() {
		List<Product> productList = reportsLogic.inventoryByProduct();
		return productList;
	}

}