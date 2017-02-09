package com.ims.DAO;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

public class DIProduct implements DAOProduct{

	@Override
	public Product getProduct(int id) {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<Product> getAllProductsByCategory(int categoryID) {
		throw new NotYetImplementedException();
		return null;
	}

}
