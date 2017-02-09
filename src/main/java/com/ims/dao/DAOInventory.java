package com.ims.dao;

import java.util.List;

import com.ims.domain.Inventory;

public interface DAOInventory {
	
	//basic CRUD
	//void createInventory();
	//void deleteInventory();
	void updateInventory(int productID, int retailer);
	
	//Query
	
	/* this was originally to return an int */ 
	
	Inventory getInventory(int productID, int retailerID);
	
	/* Added by Efren -  2/9/17 */ 
	List<Inventory> getAllInventory(int retailerID);
	
	
}
