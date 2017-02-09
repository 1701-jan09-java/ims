package com.ims.logic;

import java.util.List;

import com.ims.dao.DAOProduct;
import com.ims.dao.DIProduct;
import com.ims.domain.Product;

public class ProductLogic {

	private static DAOProduct dao = new DIProduct();
	
	public static Product getProduct(int prodID) {
		
		Product product = dao.getProduct(prodID);
		return product;
		
	}
	
	public static List<Product> getAllProducts() {
		
		List<Product> products = dao.getAllProducts();
		return products;
		
	}
	
	public static List<Product> getAllProductsByCategory(int categoryID) {
		
		List<Product> products = dao.getAllProductsByCategory(categoryID);
		return products;
		
	}
	
}
