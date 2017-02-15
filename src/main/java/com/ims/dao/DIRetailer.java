package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.Retailer;

@Component
public class DIRetailer implements DAORetailer {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Retailer getRetailer(int id) {
		Session session = sessionFactory.getCurrentSession(); 
		Retailer retailer = (Retailer) session.get(Retailer.class, id);
		return retailer;
	}

	@Override
	public List<Retailer> getAllRetailers() {
		Session session = sessionFactory.getCurrentSession(); 
		Criteria criteria = session.createCriteria(Retailer.class);
		List<Retailer> allRetailers = criteria.list();
		return allRetailers;
	}
}
