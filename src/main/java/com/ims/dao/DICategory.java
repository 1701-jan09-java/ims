package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ims.domain.Category;
import com.ims.domain.Product;
import com.ims.domain.util.HibernateUtil;

public class DICategory implements DAOCategory{

	@Override
	public Category getCategory(int id) {
		Session session = HibernateUtil.getSession();

		Category category = (Category) session.get(Category.class, id);

		session.close();

		return category;		
	}

	@Override
	public List<Category> getAllCategories() {
		Session session = HibernateUtil.getSession();

		Criteria criteria = session.createCriteria(Category.class);

		List<Category> categories = criteria.list();
		
		return categories;
		
	}

	@Override
	public List<Category> getAllCategoriesByProduct(int productID) {
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery("from Category where id = :idvalue");
		query.setInteger("idvalue",productID);
		
		List<Category> categories = query.list();

		session.close();
		return categories;
	}

}
