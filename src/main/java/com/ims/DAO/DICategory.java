package com.ims.DAO;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

public class DICategory implements DAOCategory{

	@Override
	public Category getCategory(int id) {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		throw new NotYetImplementedException();
		return null;
	}

}
