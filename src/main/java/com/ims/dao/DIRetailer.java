package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.util.HibernateUtil;
import com.ims.logic.RetailerLogic;
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
		Query query = session.createQuery("from Retailer");
		List<Retailer> allRetailers = query.list();
		return allRetailers;
		
	}

	public static void main(String[] args) {
		
		Retailer testRet = RetailerLogic.viewRetailerById(4);
		
		System.out.println(testRet);
		
		List<Retailer> testAllRet = RetailerLogic.viewAllRetailers();
		
		for(Retailer all : testAllRet) {
			System.out.println(all);
		}
		
	}
}
