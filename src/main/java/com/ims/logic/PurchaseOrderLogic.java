package com.ims.logic;

import java.util.List;

import com.ims.dao.DAOPurchaseOrder;
import com.ims.dao.DIPurchaseOrder;
import com.ims.domain.Product;
import com.ims.domain.PurchaseOrder;

public class PurchaseOrderLogic {

	private static DAOPurchaseOrder dao = new DIPurchaseOrder();
	
	public static PurchaseOrder getPurchaseOrder(int poId) {
		
		PurchaseOrder po = dao.getPurchaseOrder(poId);
		return po;
	}
	
	public static List<PurchaseOrder> getAllPurchaseOrders() {
		
		List<PurchaseOrder> poList = dao.getAllPurchaseOrders();
		return poList;
	}
	
	public static List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID) {
		
		List<PurchaseOrder> poList = dao.getAllPurchaseOrdersByRetailer(retailerID);
		return poList;
	}
	
	public static void createPurchaseOrder(PurchaseOrder po) {
		dao.createPurchaseOrder(po);
	}
	
	public static void updatePurchaseOrder(PurchaseOrder po) {
		dao.updatePurchaseOrder(po);
	}
	
	public static void deletePurchaseOrder(PurchaseOrder po) {
		dao.deletePurchaseOrder(po);
	}
}
