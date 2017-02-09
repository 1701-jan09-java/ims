package com.ims.dao;

import java.util.List;

import com.ims.domain.Category;

public interface DAOCategory {

	//basic CRUD
	Category getCategory(int id);
	
	//Query
	List<Category> getAllCategories();
}
