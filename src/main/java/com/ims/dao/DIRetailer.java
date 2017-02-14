package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ims.domain.util.HibernateUtil;
import com.ims.logic.RetailerLogic;
import com.ims.domain.Retailer;

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
		
		Query query = session.createQuery("from Retailer");
		List<Retailer> allRetailers = query.list();
	
		session.close();
		
		return allRetailers;
		
	}

	/*public static void main(String[] args) {
		
		Retailer testRet = RetailerLogic.viewRetailerById(4);
		
		System.out.println(testRet);
		
		List<Retailer> testAllRet = RetailerLogic.viewAllRetailers();
		
		for(Retailer all : testAllRet) {
			System.out.println(all);
		}
		
	}*/
}
