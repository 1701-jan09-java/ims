package com.ims.dao;

import java.util.List;

import com.ims.domain.Category;
import com.ims.domain.Inventory;
import com.ims.domain.Product;
import com.ims.domain.Retailer;
import com.ims.domain.Supplier;

public interface DAOReports {
	
	//Query
	List<Product> sellDollarsByProduct();
	List<Product> sellQuantityByProduct();
	
	List<Category> sellDollarsByCategory();
	List<Category> sellQuantityByCategory();
	
	List<Retailer> sellDollarsByRetailer();
	List<Retailer> sellQuantityByRetailer();
	
	List<Supplier> sellDollarsBySupplier();
	List<Supplier> sellQuantityBySupplier();
	
	List<Product> inventoryByProductByRetailer();
	List<Product> inventoryByProductBySupplier();
	
	List<Product> inventoryByCategory();
	
	List<Product> inventoryByProduct();
	
	
	
	

}
