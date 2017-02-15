package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.Product;

@Component
public class DIProduct implements DAOProduct{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product getProduct(int id) {
		Session session = sessionFactory.getCurrentSession();

		Product product = (Product) session.get(Product.class, id);

		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Product.class);

		List<Product> products = criteria.list();
		return products;	
	}

	@Override
	public List<Product> getAllProductsByCategory(int categoryID) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Product where id = :idvalue");
		query.setInteger("idvalue",categoryID);
		
		List<Product> products = query.list();

		return products;
	}

}
