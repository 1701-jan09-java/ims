package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.ims.domain.Retailer;
import com.ims.domain.util.HibernateUtil;

public class DIRetailer implements DAORetailer {

	@Override
	public Retailer getRetailer(int id) {
		
		Session session = HibernateUtil.getSession(); 
	
		Retailer retailer = (Retailer) session.get(Retailer.class, id);
		
		session.close();	
		
		return retailer;
	}

	@Override
	public List<Retailer> getAllRetailers() {
		
		Session session = HibernateUtil.getSession(); 
		
		Criteria criteria = session.createCriteria(Retailer.class);
		
		List<Retailer> allRetailers = criteria.list();
		
		return allRetailers;
		
	}
}
