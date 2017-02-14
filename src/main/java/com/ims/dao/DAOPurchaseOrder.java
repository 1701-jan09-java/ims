package com.ims.dao;

import java.util.List;

import com.ims.domain.PurchaseOrder;

public interface DAOPurchaseOrder {
	
	//basic CRUD
	void createPurchaseOrder(PurchaseOrder po);
	void updatePurchaseOrder(PurchaseOrder po);
	void deletePurchaseOrder(PurchaseOrder po);
	PurchaseOrder getPurchaseOrder(int id);
	
	//Query
	List<PurchaseOrder> getAllPurchaseOrders();
	List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID);
}
