package com.ims.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;


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
		Session session = HibernateUtil.getSession();

		Criteria criteria = session.createCriteria(Product.class);

		List<Product> products = criteria.list();
		return products;	
	}

	@Override
	public List<Product> getAllProductsByCategory(int categoryID) {
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery("from Product where id = :idvalue");
		query.setInteger("idvalue",categoryID);
		
		List<Product> products = query.list();

		session.close();
		return products;
	}

}
