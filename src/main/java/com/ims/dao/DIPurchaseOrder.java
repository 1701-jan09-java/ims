package com.ims.dao;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.PurchaseOrder;

public class DIPurchaseOrder implements DAOPurchaseOrder {

	@Override
	public void createPurchaseOrder(PurchaseOrder po) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public void deleteRPurchaseOrder(PurchaseOrder po) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public PurchaseOrder getPurchaseOrder(int id) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		throw new NotYetImplementedException();
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID) {
		throw new NotYetImplementedException();
	}

}
