package com.ims.main;

import java.util.List;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.logic.PurchaseOrderLineLogic;
import com.ims.logic.PurchaseOrderLogic;
import com.ims.logic.RetailerLogic;
import com.ims.logic.SupplierLogic;

public class DummyMain {
	
	
	
	public static void main(String[] args) {
		
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
		PurchaseOrderLineLogic polLogic = new PurchaseOrderLineLogic();
		List<PurchaseOrderLine> pol = polLogic.getAllPurchaseOrderLines(104);
		for(PurchaseOrderLine pols : pol){
			System.out.println(pols);
		};
	}
}
