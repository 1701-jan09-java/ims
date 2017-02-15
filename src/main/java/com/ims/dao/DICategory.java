package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.Category;
import com.ims.domain.util.HibernateUtil;

@Component
public class DICategory implements DAOCategory{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Category getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();

		Category category = (Category) session.get(Category.class, id);

		return category;		
	}

	@Override
	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Category.class);

		List<Category> categories = criteria.list();
		
		return categories;
		
	}

	@Override
	public List<Category> getAllCategoriesByProduct(int productID) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Category where id = :idvalue");
		query.setInteger("idvalue",productID);
		
		List<Category> categories = query.list();

		return categories;
	}

}
