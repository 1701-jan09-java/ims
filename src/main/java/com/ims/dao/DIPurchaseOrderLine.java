package com.ims.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.domain.util.HibernateUtil;

public class DIPurchaseOrderLine implements DAOPurchaseOrderLine {

	@Override
	public void createPurchaseOrderLine(PurchaseOrder po) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		PurchaseOrder purchaseOrder = (PurchaseOrder) session.save(po);
		
		tx.commit();
		session.close();
	        
		
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
