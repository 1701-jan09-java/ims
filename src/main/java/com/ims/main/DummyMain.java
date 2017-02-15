package com.ims.main;

import com.ims.domain.PurchaseOrder;
import com.ims.logic.PurchaseOrderLogic;
import com.ims.logic.RetailerLogic;
import com.ims.logic.SupplierLogic;

public class DummyMain {
	
	
	
	public static void main(String[] args) {
		
//		System.out.println(PurchaseOrderLogic.getAllPurchaseOrders());
		PurchaseOrder po = PurchaseOrderLogic.createPurchaseOrder(123, 5, 400);
		System.out.println(po);
		
//		PurchaseOrder po = new PurchaseOrder();
//		po.setRetailer(RetailerLogic.viewRetailerById(5));
//		po.setSupplier(SupplierLogic.getSupplier(100));
//		po.setCost(1000);
//		System.out.println(po);
//		PurchaseOrderLogic.createPurchaseOrder(po);
//		po.setCost(95);
//		PurchaseOrderLogic.updatePurchaseOrder(po);
//		System.out.println(PurchaseOrderLogic.getPurchaseOrder(po.getId()));
//		PurchaseOrderLogic.deletePurchaseOrder(po);
//		System.out.println(PurchaseOrderLogic.getPurchaseOrder(po.getId()));
//		
//		System.out.println(PurchaseOrderLogic.getAllPurchaseOrders());
//		System.out.println(PurchaseOrderLogic.getAllPurchaseOrdersByRetailer(1));
	}
}
