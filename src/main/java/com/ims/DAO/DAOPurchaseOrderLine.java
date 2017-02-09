package com.ims.DAO;

import java.util.List;

public interface DAOPurchaseOrderLine {
	//basic CRUD
	void createPurchaseOrderLine(PurchaseOrder po);
	PurchaseOrderLine getPurchaseOrderLine(int poLineId);
	List<PurchaseOrderLine> getAllPurchaseOrderLines();
	void updatePurchaseOrderLine(int poLineId);
	void deletePurchaseOrderLine(int poLineId);
	
	

}
