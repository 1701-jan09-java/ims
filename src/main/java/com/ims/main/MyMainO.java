package com.ims.main;

import java.util.List;

import com.ims.dao.DAOProduct;
import com.ims.domain.Product;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.dto.POLineDTO;
import com.ims.logic.PurchaseOrderLineLogic;
import com.ims.logic.PurchaseOrderLogic;
import com.ims.logic.ReportsLogic;
import com.ims.logic.RetailerLogic;
import com.ims.logic.SupplierLogic;


public class MyMainO {

	
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
//		POLineDTO polDTO = new POLineDTO();
//		
//		polDTO.setProdId(100);
//		polDTO.setCount(5);
//		polDTO.setCost(150);
		
//		Product prod = daoProd.getProduct(num);
//		PurchaseOrderLine pol = new PurchaseOrderLine();
//		PurchaseOrder po = new PurchaseOrder();
//		po.setId(104);
//		pol.setId(120);
//		pol.setCost(15);
//		pol.setPurchaseOrder(po);
//		PurchaseOrderLineLogic polLogic = new PurchaseOrderLineLogic();
//		PurchaseOrderLine pol = new PurchaseOrderLine();
//		polLogic.updatePurchaseOrderLine(pol);;
//		polLogic.createPurchaseOrderLine(polDTO, 104);
		ReportsLogic repLogic = new ReportsLogic();
//		List<PurchaseOrder> repList = repLogic.getAllPurchaseOrdersOver5k();
//		System.out.println(repLogic);
//		List<PurchaseOrderLine> pol = polLogic.getAllPurchaseOrderLines(104);
//		for(PurchaseOrder poS : repList){
//			System.out.println(poS);
//		};

	}
}
