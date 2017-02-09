package com.ims.logic;

import java.util.List;

import com.ims.domain.Product;
import com.ims.domain.Category;
import com.ims.dao.DaoProduct;

public class ProductLogic {

	DAOProduct dao = new DIProduct();
	
	public Product getProduct(int prodID) {
		
		Product product = dao.getProduct(prodID);
		return product;
		
	}
	
	public List<Product> getAllProducts() {
		
		List<Product> products = dao.getAllProducts();
		return products;
		
	}
	
	public List<Product> getAllProductsByCategory(int categoryID) {
		
		List<Product> products = dao.getAllProductsByCategory(categoryID);
		return products;
		
	}
	
}
