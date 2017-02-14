package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.util.HibernateUtil;

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
	public void deletePurchaseOrder(PurchaseOrder po) {
		Session session = HibernateUtil.getSession();

		Transaction tx = session.beginTransaction();
		
		session.delete(po);

		tx.commit();
		session.close();
		
	}

	@Override
	public PurchaseOrder getPurchaseOrder(int id) {
		Session session = HibernateUtil.getSession();

		PurchaseOrder po = (PurchaseOrder) session.get(PurchaseOrder.class, id);

		session.close();

		return po;
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		Session session = HibernateUtil.getSession();

		Criteria criteria = session.createCriteria(PurchaseOrder.class);

		List<PurchaseOrder> poList = criteria.list();
		return poList;
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID) {
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery("from PurchaseOrder where retailer.id = :idvalue");
		query.setInteger("idvalue",retailerID);
		
		List<PurchaseOrder> poList = query.list();

		session.close();
		return poList;
	}

}
