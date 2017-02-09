package com.ims.DAO;

import java.util.List;

public interface DAOSupplier {
	
	//basic CRUD
	//void createSupplier(Supplier supplier);
	//void updateSupplier(Supplier supplier);
	//void deleteSupplier(Supplier supplier);
	Supplier getSupplier(int id);
	
	//Query
	List<Supplier> getAllSuppliers();
	
}
