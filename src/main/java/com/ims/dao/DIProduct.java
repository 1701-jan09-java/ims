package com.ims.dao;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.Product;

public class DIProduct implements DAOProduct{

	@Override
	public Product getProduct(int id) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Product> getAllProducts() {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Product> getAllProductsByCategory(int categoryID) {
		throw new NotYetImplementedException();
	}

}
