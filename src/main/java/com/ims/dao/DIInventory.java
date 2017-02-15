package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.Inventory;


@Component
public class DIInventory implements DAOInventory {

		
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DAOProduct daoProd; //needed to match products in get methods
	
	@Autowired
	private DAORetailer daoRet; // needed to match retailer in get methods
	
	@Override
	public void updateInventory(Inventory inventory) {
		Session session = sessionFactory.getCurrentSession();
		session.update(inventory);
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
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Inventory.class);	
//			DAOProduct daoProd = new DIProduct();
//			DAORetailer daoRet = new DIRetailer();
			criteria.add(Restrictions.eq("product", daoProd.getProduct(productID)));
			criteria.add(Restrictions.eq("retailer", daoRet.getRetailer(retailerID)));
			Inventory inventory = (Inventory) criteria.uniqueResult();
			return inventory; 
		}catch (NullPointerException e) {
			System.out.println("no such object");
			return null; 
		}
	}
	
	
	@Override
	public int getInventory(int productID, int retailerID) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Inventory.class);	
			criteria.add(Restrictions.eq("product", daoProd.getProduct(productID)));
			criteria.add(Restrictions.eq("retailer", daoRet.getRetailer(retailerID)));
			Inventory inventory = (Inventory) criteria.uniqueResult();
			return inventory.getProductQuantity();
		}catch (NullPointerException e) {
			System.out.println("no such object");
			return 0; 
		}
	}
	
	@Override
	public List<Inventory> getAllInventory(int retailerID) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("retailer", daoRet.getRetailer(retailerID)));
		List<Inventory> list = criteria.list();
		return list;
	}

	
}
