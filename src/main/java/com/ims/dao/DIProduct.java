package com.ims.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.NotYetImplementedException;


import com.ims.domain.Product;
import com.ims.domain.util.HibernateUtil;

public class DIProduct implements DAOProduct{

	@Override
	public Product getProduct(int id) {
		Session session = HibernateUtil.getSession();
		Product product = (Product) session.get(Product.class, id);
		session.close();
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Product> getAllProductsByCategory(int categoryID) {
		throw new NotYetImplementedException();
	}
	
	public static void main(String[] args) {
		DAOProduct dao = new DIProduct();
		
		Product product1 = dao.getProduct(100);
		System.out.println(product1);
	}

}
