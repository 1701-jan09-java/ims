package com.ims.logic;

import java.util.List;

import com.ims.dao.DAOCategory;
import com.ims.dao.DICategory;
import com.ims.domain.Category;
import com.ims.domain.Product;

public class CategoryLogic {

	private static DAOCategory dao = new DICategory();
	
	public static Category getCategory(int categoryID) {
		
		Category category = dao.getCategory(categoryID);
		return category;
		
	}
	
	public static List<Category> getAllCategories() {
		
		List<Category> categories = dao.getAllCategories();
		return categories;
		
	}
	
	public static List<Category> getAllCategoriesByProduct(int productID) {
		
		List<Category> categories = dao.getAllCategoriesByProduct(productID);
		return categories;
		
	}
	
}