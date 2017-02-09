package com.ims.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.criterion.Restrictions;

import com.ims.domain.Inventory;
import com.ims.domain.util.HibernateUtil;

public class DIInventory implements DAOInventory {

	@Override
	public void updateInventory(int productID, int retailer) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public int getInventory(int productID, int retailerID) {
		try{
			Session session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(Inventory.class);	
			DAOProduct daoProd = new DIProduct();
			DAORetailer daoRet = new DIRetailer();
			criteria.add(Restrictions.eq("product", daoProd.getProduct(productID)));
			criteria.add(Restrictions.eq("retailer", daoRet.getRetailer(retailerID)));
			Inventory inventory = (Inventory) criteria.uniqueResult();
			System.out.println(inventory);
			session.close();
			return inventory.getProductQuantity();
		}catch (NullPointerException e) {
			System.out.println("no such object");
			return 0; 
		}
	}

	
	public static void main(String[] args) {
		
		DAOInventory dao = new DIInventory();
		
		int howMany = dao.getInventory(100, 5);
		System.out.println(howMany);
	}
}
