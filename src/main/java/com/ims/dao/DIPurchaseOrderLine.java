package com.ims.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;

@Component
public class DIPurchaseOrderLine implements DAOPurchaseOrderLine {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void createPurchaseOrderLine(PurchaseOrder po) {
		// TODO Auto-generated method stub
	        throw new NotYetImplementedException();
		
	}

	@Override
	public PurchaseOrderLine getPurchaseOrderLine(int poLineId) {
		// TODO Auto-generated method stub
	        throw new NotYetImplementedException();
	}

	@Override
	public List<PurchaseOrderLine> getAllPurchaseOrderLines() {
		// TODO Auto-generated method stub
	        throw new NotYetImplementedException();
	}

	@Override
	public void updatePurchaseOrderLine(int poLineId) {
		// TODO Auto-generated method stub
	        throw new NotYetImplementedException();
		
	}

	@Override
	public void deletePurchaseOrderLine(int poLineId) {
		// TODO Auto-generated method stub
	        throw new NotYetImplementedException();
		
	}

}
