package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOProduct;
import com.ims.domain.Product;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class ProductLogic {

	@Autowired
	private DAOProduct dao;
	
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
