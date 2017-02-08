package com.ims.DAO;

import java.util.List;

public interface DAOProduct {
	
	//basic CRUD
	void createProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	Product getProduct(int id);
	
	//Query
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(Category id);

}
