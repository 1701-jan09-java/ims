package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
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
	public List<PurchaseOrderLine> getAllPurchaseOrderLines(PurchaseOrder poId) {
		
		Session session = HibernateUtil.getSession();
		
		Criteria criteria = session.createCriteria(PurchaseOrderLine.class);
		
		List<PurchaseOrderLine> pOLs = criteria.list();
		
		return pOLs;

	}

	@Override
	public void updatePurchaseOrderLine(int poLineId) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		session.update(poLineId);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public void deletePurchaseOrderLine(int poLineId) {
		
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		session.delete(poLineId);
		
		tx.commit();
		session.close();
		
	}

}
