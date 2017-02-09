package com.ims.dao;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.Retailer;

public class DIRetailer implements DAORetailer {

	@Override
	public Retailer getRetailer(int id) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Retailer> getAllRetailers() {
		throw new NotYetImplementedException();
	}

}
