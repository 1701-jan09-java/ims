package com.ims.dao;

import java.util.List;

import com.ims.domain.Supplier;

public interface DAOSupplier {
	
	//basic CRUD
	//void createSupplier(Supplier supplier);
	//void updateSupplier(Supplier supplier);
	//void deleteSupplier(Supplier supplier);
	Supplier getSupplier(int id);
	
	//Query
	List<Supplier> getAllSuppliers();
	
}
