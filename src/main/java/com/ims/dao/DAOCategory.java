package com.ims.dao;

import java.util.List;

import com.ims.domain.Category;
import com.ims.domain.Product;

public interface DAOCategory {

	//basic CRUD
	Category getCategory(int id);
	
	//Query
	List<Category> getAllCategories();
	List<Category> getAllCategoriesByProduct(int productID);
}
