package com.ims.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.PurchaseOrder;

@Component
public class DIPurchaseOrder implements DAOPurchaseOrder {

	@Autowired
	private SessionFactory sessionFactory;
	
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
