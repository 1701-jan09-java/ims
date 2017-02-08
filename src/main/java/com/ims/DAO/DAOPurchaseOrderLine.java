package com.ims.DAO;

public interface DAOPurchaseOrderLine {
	//basic CRUD
	void createPurchaseOrderLine();
	PurchaseOrderLine getPurchaseOrderLine(int poLineId);
	List<PurchaseOrderLine> getAllPurchaseOrderLines();
	void updatePurchaseOrderLine(int poLineId);
	void deletePurchaseOrderLine(int poLineId);
	
	

}
