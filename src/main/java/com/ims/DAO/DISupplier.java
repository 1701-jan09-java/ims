package com.ims.DAO;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

public class DISupplier implements DAOSupplier{

	@Override
	public Supplier getSupplier(int id) {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		throw new NotYetImplementedException();
		return null;
	}

}
