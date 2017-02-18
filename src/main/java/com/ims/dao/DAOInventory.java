package com.ims.dao;

import java.util.List;

import com.ims.domain.Inventory;

public interface DAOInventory {
	
	//basic CRUD
	//void createInventory();
	//void deleteInventory();
	
	void updateInventory(Inventory inventory);
	
	//Query
 
	Inventory getInventoryObject(int productID, int retailerID);
	
	int getInventoryAmount(int productID, int retailerID);
	
	List<Inventory> getAllInventory(int retailerID);

	
	
	
}
