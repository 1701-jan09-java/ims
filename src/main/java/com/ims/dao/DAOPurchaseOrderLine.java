package com.ims.dao;

import java.util.List;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;

public interface DAOPurchaseOrderLine {
	//basic CRUD
	void createPurchaseOrderLine(PurchaseOrderLine pol);
	PurchaseOrderLine getPurchaseOrderLine(int poLineId);
	List<PurchaseOrderLine> getAllPurchaseOrderLines(PurchaseOrder poId);
	void updatePurchaseOrderLine(int poLineId);
	void deletePurchaseOrderLine(int poLineId);
	
	

}
