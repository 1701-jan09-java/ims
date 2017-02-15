package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOPurchaseOrder;
import com.ims.dao.DAORetailer;
import com.ims.dao.DAOSupplier;
import com.ims.dao.DIRetailer;
import com.ims.dao.DISupplier;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.Retailer;
import com.ims.domain.Supplier;
import com.ims.dto.PurchaseOrderDTO;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class PurchaseOrderLogic {

	@Autowired
	private DAOPurchaseOrder dao;
	private SupplierLogic suppLogic;
	private RetailerLogic retLogic;
	
	public PurchaseOrder getPurchaseOrder(int poId) {
		
		PurchaseOrder po = dao.getPurchaseOrder(poId);
		return po;
	}
	
	public List<PurchaseOrder> getAllPurchaseOrders() {
		
		List<PurchaseOrder> poList = dao.getAllPurchaseOrders();
		return poList;
	}
	
	public List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID) {
		
		List<PurchaseOrder> poList = dao.getAllPurchaseOrdersByRetailer(retailerID);
		return poList;
	}
	
	public void createPurchaseOrder(PurchaseOrder po) {
		dao.createPurchaseOrder(po);
	}
	
	public PurchaseOrder createPurchaseOrder(int supplierId, int retailerId, double cost) {
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
	
	public void updatePurchaseOrder(PurchaseOrder po) {
		dao.updatePurchaseOrder(po);
	}
	
	public void deletePurchaseOrder(PurchaseOrder po) {
		dao.deletePurchaseOrder(po);
	}
	
	public PurchaseOrder createPurchaseOrder(PurchaseOrderDTO poDto) {
		Supplier supplier = suppLogic.getSupplier(poDto.getSupId());
		Retailer retailer = retLogic.viewRetailerById(poDto.getRetId());
		PurchaseOrder po = new PurchaseOrder(supplier, retailer, poDto.getCost());
		createPurchaseOrder(po);
		// stuff for lines
		return po;
	}
}
