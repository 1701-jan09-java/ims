package com.ims.dao;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.Supplier;

public class DISupplier implements DAOSupplier{

	@Override
	public Supplier getSupplier(int id) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		throw new NotYetImplementedException();
	}

}
