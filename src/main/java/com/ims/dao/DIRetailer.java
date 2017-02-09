package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.util.HibernateUtil;
import com.ims.logic.RetailerLogic;
import com.ims.domain.Retailer;

public class DIRetailer implements DAORetailer {

	@Override
	public Retailer getRetailer(int id) {
		
		Session session = HibernateUtil.getSession(); 
		Transaction tx = session.beginTransaction();	
		
		Retailer retailer = (Retailer) session.get(Retailer.class, id);
		
		session.close();
		tx.commit();
		
		return retailer;
	}

	@Override
	public List<Retailer> getAllRetailers() {
		
		Session session = HibernateUtil.getSession(); 
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Retailer");
		List<Retailer> allRetailers = query.list();
		
		session.close();
		tx.commit();
		
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
