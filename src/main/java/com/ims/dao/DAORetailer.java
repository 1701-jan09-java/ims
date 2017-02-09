package com.ims.dao;

import java.util.List;

import com.ims.domain.Retailer;

public interface DAORetailer {
	
	//basic CRUD
	//void createRetailer(Retailer retailer);
	//void updateRetailer(Retailer retailer);
	//void deleteRetailer(Retailer retailer);
	Retailer getRetailer(int id);
	
	//Query
	List<Retailer> getAllRetailers();

}
