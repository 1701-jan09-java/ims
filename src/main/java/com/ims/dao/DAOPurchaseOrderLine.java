package com.ims.dao;

import java.util.List;

public interface DAOPurchaseOrderLine {
	//basic CRUD
	void createPurchaseOrderLine(PurchaseOrder po);
	PurchaseOrderLine getPurchaseOrderLine(int poLineId);
	List<PurchaseOrderLine> getAllPurchaseOrderLines();
	void updatePurchaseOrderLine(int poLineId);
	void deletePurchaseOrderLine(int poLineId);
	
	

}
