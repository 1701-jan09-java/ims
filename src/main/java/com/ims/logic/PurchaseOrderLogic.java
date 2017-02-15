package com.ims.logic;

import java.util.List;

import com.ims.dao.DAOPurchaseOrder;
import com.ims.dao.DAORetailer;
import com.ims.dao.DAOSupplier;
import com.ims.dao.DIPurchaseOrder;
import com.ims.dao.DIRetailer;
import com.ims.dao.DISupplier;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.Retailer;
import com.ims.domain.Supplier;
import com.ims.dto.PurchaseOrderDTO;

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
	
	public static PurchaseOrder createPurchaseOrder(int supplierId, int retailerId, double cost) {
		DAORetailer daoRet = new DIRetailer();
		DAOSupplier daoSupp = new DISupplier();
		PurchaseOrder po = new PurchaseOrder();
		po.setRetailer(daoRet.getRetailer(retailerId));
		po.setSupplier(daoSupp.getSupplier(supplierId));
		po.setCost(cost);
		dao.createPurchaseOrder(po);
		po = dao.getPurchaseOrder(po.getId());
		return po;
	}
	
	public static void updatePurchaseOrder(PurchaseOrder po) {
		dao.updatePurchaseOrder(po);
	}
	
	public static void deletePurchaseOrder(PurchaseOrder po) {
		dao.deletePurchaseOrder(po);
	}
	
	public static PurchaseOrder createPurchaseOrder(PurchaseOrderDTO poDto) {
		Supplier supplier = SupplierLogic.getSupplier(poDto.getSupId());
		Retailer retailer = RetailerLogic.viewRetailerById(poDto.getRetId());
		PurchaseOrder po = new PurchaseOrder(supplier, retailer, poDto.getCost());
		createPurchaseOrder(po);
		// stuff for lines
		return po;
	}
}
