package com.ims.dao;

import java.util.List;

public interface DAOPurchaseOrder {
	
	//basic CRUD
	void createPurchaseOrder(PurchaseOrder po);
	void updatePurchaseOrder(PurchaseOrder po);
	void deleteRPurchaseOrder(PurchaseOrder po);
	PurchaseOrder getPurchaseOrder(int id);
	
	//Query
	List<PurchaseOrder> getAllPurchaseOrders();
	List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID);
}
