package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.domain.util.HibernateUtil;

public class DIPurchaseOrderLine implements DAOPurchaseOrderLine {

	@Override
	public void createPurchaseOrderLine(PurchaseOrderLine pol) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(pol);
		
		tx.commit();
		session.close();
	        
		
	}

	@Override
	public PurchaseOrderLine getPurchaseOrderLine(int poLineId) {
		
		Session session = HibernateUtil.getSession();
		PurchaseOrderLine pol = (PurchaseOrderLine) session.get(PurchaseOrderLine.class, poLineId);
		
		session.close();
		
		return pol;
		
		
	}

	@Override
	public List<PurchaseOrderLine> getAllPurchaseOrderLines(int poId) {
		
		Session session = HibernateUtil.getSession();
		
		Query query = session.createQuery("from PurchaseOrderLine where purchaseOrder.id = :idvalue");
		query.setInteger("idvalue", poId);
		
		List<PurchaseOrderLine> pOLs = query.list();
		
		session.close();
		
		return pOLs;

	}

	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		session.update(poLineId);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public void deletePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
//		Query query = session.createQuery("delete PurchaseOrderLine where purchaseOrder.id = :idvalue");
//		query.setInteger("idvalue", poLineId);
		
		session.delete(poLineId);

		
		tx.commit();
		
		
		session.close();
		
	}

}
