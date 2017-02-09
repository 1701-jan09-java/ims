package com.ims.dao;

import java.util.List;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;

public interface DAOPurchaseOrderLine {
	//basic CRUD
	void createPurchaseOrderLine(PurchaseOrder po);
	PurchaseOrderLine getPurchaseOrderLine(int poLineId);
	List<PurchaseOrderLine> getAllPurchaseOrderLines();
	void updatePurchaseOrderLine(int poLineId);
	void deletePurchaseOrderLine(int poLineId);
	
	

}
