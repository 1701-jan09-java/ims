package com.ims.dao;

public interface DAOInventory {
	
	//basic CRUD
	//void createInventory();
	//void deleteInventory();
	void updateInventory(int productID, int retailer);
	
	//Query
	int getInventory(int productID, int retailerID);
}