package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.PurchaseOrder;

@Component
public class DIPurchaseOrder implements DAOPurchaseOrder {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createPurchaseOrder(PurchaseOrder po) {
		Session session = sessionFactory.getCurrentSession();
		session.save(po);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
		Session session = sessionFactory.getCurrentSession();
		session.update(po);
	}

	@Override
	public void deletePurchaseOrder(PurchaseOrder po) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(po);
	}

	@Override
	public PurchaseOrder getPurchaseOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		PurchaseOrder po = (PurchaseOrder) session.get(PurchaseOrder.class, id);
		return po;
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrder.class);
		List<PurchaseOrder> poList = criteria.list();
		return poList;
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrdersByRetailer(int retailerID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PurchaseOrder where retailer.id = :idvalue");
		query.setInteger("idvalue",retailerID);
		List<PurchaseOrder> poList = query.list();
		return poList;
	}

}
