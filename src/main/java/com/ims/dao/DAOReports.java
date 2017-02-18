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
	
	List<Product> avgSellDollarsByProduct();
	List<Product> avgQuantityByProduct();
	
	List<Retailer> sellDollarsByRetailer();
	List<Retailer> sellQuantityByRetailer();
	
	List<Supplier> sellDollarsBySupplier();
	List<Supplier> sellQuantityBySupplier();
	
	List<Product> inventoryByProductByRetailer();
	List<Product> avgInventoryByProductByRetailer();
	
	List<Product> inventoryThresholdByProduct();
	List<Product> inventoryThresholdByProductByRetailer();
	
	List<Product> inventoryByProduct();
	
	
	
	

}
