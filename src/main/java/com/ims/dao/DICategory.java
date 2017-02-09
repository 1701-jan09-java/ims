package com.ims.dao;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.Category;

public class DICategory implements DAOCategory{

	@Override
	public Category getCategory(int id) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public List<Category> getAllCategories() {
		throw new NotYetImplementedException();
		
	}

}
