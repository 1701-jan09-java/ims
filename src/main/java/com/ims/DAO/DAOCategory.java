package com.ims.DAO;

import java.util.List;

public interface DAOCategory {

	//basic CRUD
	Category getCategory(int id);
	
	//Query
	List<Category> getAllCategories();
}
