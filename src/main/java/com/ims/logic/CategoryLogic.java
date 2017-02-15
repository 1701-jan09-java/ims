package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOCategory;
import com.ims.domain.Category;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class CategoryLogic {

	@Autowired
	private DAOCategory dao;
	
	public Category getCategory(int categoryID) {
		
		Category category = dao.getCategory(categoryID);
		return category;
		
	}
	
	public List<Category> getAllCategories() {
		
		List<Category> categories = dao.getAllCategories();
		return categories;
		
	}
	
	public List<Category> getAllCategoriesByProduct(int productID) {
		
		List<Category> categories = dao.getAllCategoriesByProduct(productID);
		return categories;
		
	}
	
}