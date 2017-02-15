package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.Supplier;


@Component
public class DISupplier implements DAOSupplier{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Supplier getSupplier(int id) {
		Session session = sessionFactory.getCurrentSession(); 
		Supplier sup = (Supplier) session.get(Supplier.class, id);
		return sup;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		Session session = sessionFactory.getCurrentSession(); 
		Query query = session.createQuery("FROM Supplier");
		List<Supplier> supList = query.list();
		return supList;
		
	}

}
