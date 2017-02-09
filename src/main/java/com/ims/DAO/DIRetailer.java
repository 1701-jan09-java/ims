package com.ims.DAO;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

public class DIRetailer implements DAORetailer {

	@Override
	public Retailer getRetailer(int id) {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<Retailer> getAllRetailers() {
		throw new NotYetImplementedException();
		return null;
	}

}
