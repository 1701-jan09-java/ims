package com.ims.logic;

import java.util.List;

import com.ims.domain.Product;
import com.ims.domain.Category;
import com.ims.dao.DaoCategory;

public class CategoryLogic {

	DAOCategory dao = new DICategory();
	
	public Category getCategory(int categoryID) {
		
		Category category = dao.getCategory(categoryID);
		return category;
		
	}
	
	public List<Category> getAllCategorys() {
		
		List<Category> categories = dao.getAllCategories();
		return categories;
		
	}
	
	public List<Category> getAllProductsByCategory(int categoryID) {
		
		List<Product> products = dao.getAllProductsByCategory(categoryID);
		return products;
		
	}
	
}
