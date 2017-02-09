package com.ims.dao;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

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
		return null;
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID) {
		throw new NotYetImplementedException();
		return null;
	}

}
