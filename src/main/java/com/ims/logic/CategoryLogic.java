package com.ims.logic;

import java.util.List;

import com.ims.dao.DAOCategory;
import com.ims.dao.DICategory;
import com.ims.domain.Category;

public class CategoryLogic {

	DAOCategory dao = new DICategory();
	
	public Category getCategory(int categoryID) {
		
		Category category = dao.getCategory(categoryID);
		return category;
		
	}
	
	public List<Category> getAllCategories() {
		
		List<Category> categories = dao.getAllCategories();
		return categories;
		
	}
	
}