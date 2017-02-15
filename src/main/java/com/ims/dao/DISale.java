package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.Retailer;
import com.ims.domain.Sale;
import com.ims.domain.util.HibernateUtil;

@Component
public class DISale implements DAOSale{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createSale(Sale sale) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(sale);	
	}

	@Override
	public void updateSale(Sale sale) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(sale);
	}

	@Override
	public void deleteSale(Sale sale) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(sale);
	}

	@Override
	public Sale getSale(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		Sale sale = (Sale) session.get(Sale.class, id);
		return sale;
		
	}

	@Override
	public List<Sale> getAllSales() {
		
		Session session = sessionFactory.getCurrentSession(); 	
		Query query = session.createQuery("from Sale");
		List<Sale> allSales = query.list();
		
		return allSales;
		
	}

	@Override
	public List<Sale> getAllSalesByRetailer(int retailerID) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Sale where retailer = :selectedRet");
		query.setInteger("selectedRet", retailerID);
		List<Sale> salesByRet = query.list();

		if (salesByRet.isEmpty()) {
			
			System.out.println("This retailer has no sales");
		}
		
		return salesByRet;
		
	}

}
