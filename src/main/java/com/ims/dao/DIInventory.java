package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.criterion.Restrictions;

import com.ims.domain.Inventory;
import com.ims.domain.util.HibernateUtil;

public class DIInventory implements DAOInventory {

		
	
	@Override
	public void updateInventory(Inventory inventory) {
		
		Session session = HibernateUtil.getSession();
		Transaction trax = session.beginTransaction();
		session.update(inventory);
		trax.commit();
		session.close();
		
	}

	/**
	 * 
	 * @param productID - the product desired
	 * @param retailerID - the retailer that holds the product
	 * @return Inventory object - to get int value --> Inventory.getProductQuantity()
	 */
	@Override
	public Inventory getInventoryObject(int productID, int retailerID) {
		try{
			Session session = HibernateUtil.getSession();
			
			/*
			 * changed return type to Inventory object
			 * 	- green commented out sections are for returning an int 
			 * 	  based on the original return 
			 */
			
			Criteria criteria = session.createCriteria(Inventory.class);	
			DAOProduct daoProd = new DIProduct();
			DAORetailer daoRet = new DIRetailer();
			criteria.add(Restrictions.eq("product", daoProd.getProduct(productID)));
			criteria.add(Restrictions.eq("retailer", daoRet.getRetailer(retailerID)));
			Inventory inventory = (Inventory) criteria.uniqueResult();
			session.close();
			return inventory; 
		}catch (NullPointerException e) {
			System.out.println("no such object");
			return null; 
		}
	}
	
	
	@Override
	public int getInventory(int productID, int retailerID) {
		try{
			Session session = HibernateUtil.getSession();
			
			/*
			 * changed return type to Inventory object
			 * 	- green commented out sections are for returning an int 
			 * 	  based on the original return 
			 */
			
			Criteria criteria = session.createCriteria(Inventory.class);	
			DAOProduct daoProd = new DIProduct();
			DAORetailer daoRet = new DIRetailer();
			criteria.add(Restrictions.eq("product", daoProd.getProduct(productID)));
			criteria.add(Restrictions.eq("retailer", daoRet.getRetailer(retailerID)));
			Inventory inventory = (Inventory) criteria.uniqueResult();
			session.close();
			return inventory.getProductQuantity();
		}catch (NullPointerException e) {
			System.out.println("no such object");
			return 0; 
		}
	}
	
	@Override
	public List<Inventory> getAllInventory(int retailerID) {
		Session session = HibernateUtil.getSession();
		DAORetailer daoRet = new DIRetailer();
		Criteria criteria = session.createCriteria(Inventory.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("retailer", daoRet.getRetailer(retailerID)));
		List<Inventory> list = criteria.list();
		session.close();
		return list;
	}

	
	public static void main(String[] args) {
		
		DAOInventory dao = new DIInventory();
		List<Inventory> list = dao.getAllInventory(5);
		System.out.println(list);
		
//		Inventory inventory = dao.getInventory(100, 5);
//		int howMany = inventory.getProductQuantity();
//		System.out.println(howMany);
	}




	
}
