package com.ims.DAO;

import java.util.List;

public interface DAORetailer {
	
	//basic CRUD
	void createRetailer(Retailer retailer);
	void updateRetailer(Retailer retailer);
	void deleteRetailer(Retailer retailer);
	Retailer getRetailer(int id);
	
	//Query
	List<Retailer> getAllRetailers();

}
