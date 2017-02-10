package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.Supplier;
import com.ims.domain.util.HibernateUtil;

public class DISupplier implements DAOSupplier{

	@Override
	public Supplier getSupplier(int id) {
//		throw new NotYetImplementedException();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Supplier sup = (Supplier) session.get(Supplier.class, id);
		
		tx.commit();
		session.close();
		
		return sup;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Supplier");
		List<Supplier> supList = query.list();
		
		tx.commit();
		session.close();	
		
		return supList;
		
	}

}
