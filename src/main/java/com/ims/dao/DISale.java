package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;

import com.ims.domain.Retailer;
import com.ims.domain.Sale;
import com.ims.domain.util.HibernateUtil;

public class DISale implements DAOSale{

	@Override
	public void createSale(Sale sale) {
		
		Session session = HibernateUtil.getSession(); 
		Transaction tx = session.beginTransaction();
		
		session.save(sale);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateSale(Sale sale) {
		
		Session session = HibernateUtil.getSession(); 
		Transaction tx = session.beginTransaction();
		
		session.update(sale);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public void deleteSale(Sale sale) {
		
		Session session = HibernateUtil.getSession(); 
		Transaction tx = session.beginTransaction();
		
		session.delete(sale);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public Sale getSale(int id) {
		
		Session session = HibernateUtil.getSession(); 
		
		Sale sale = (Sale) session.get(Sale.class, id);
		
		session.close();
		
		return sale;
		
	}

	@Override
	public List<Sale> getAllSales() {
		
		Session session = HibernateUtil.getSession(); 
		
		Query query = session.createQuery("from Sale");
		List<Sale> allSales = query.list();
	
		session.close();
		
		return allSales;
		
	}

	@Override
	public List<Sale> getAllSalesByRetailer(int retailerID) {
		
		Session session = HibernateUtil.getSession(); 
		
		Query query = session.createQuery("from Sale where retailer = :selectedRet");
		query.setInteger("selectedRet", retailerID);
		List<Sale> salesByRet = query.list();
		
		session.close();
		
		if (salesByRet.isEmpty()) {
			
			System.out.println("No such retailer has sales");
			return null;
			
		}
		
		return salesByRet;
		
	
		
	}

}
