package com.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.Category;
import com.ims.domain.Inventory;
import com.ims.domain.Product;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.domain.Retailer;
import com.ims.domain.Sale;
import com.ims.domain.Supplier;

@Component
public class DIReports implements DAOReports {
	
//	Session session = sessionFactory.getCurrentSession();
//	Criteria criteria = session.createCriteria(PurchaseOrder.class);
//	criteria.add(Restrictions.gt("po_cost", 5000));
//	List<PurchaseOrder> poList = criteria.list();
//	return poList;
	
	@Autowired
	Retailer ret;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> sellDollarsByProduct() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		
		List<Product> productList = criteria.list();
		return null;
	}

	@Override
	public List<Product> sellQuantityByProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> sellDollarsByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> sellQuantityByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retailer> sellDollarsByRetailer() {
		
		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(Retailer.class).setProjection(Projections.projectionList().add(PurchaseOrder.class).add(Projections.groupProperty(ret.id)));
		Criteria criteria = session.createCriteria(Retailer.class);
		List<Retailer> retailerList = criteria.add(Restrictions.sqlRestriction("SELECT ims_retailer.R_NAME,SUM(ims_purchase_order.po_cost) AS OrderTotal FROM ims_purchase_order LEFT JOIN ims_retailer ON ims_retailer.R_ID=ims_purchase_order.po_retailer GROUP BY r_name;")).list();
//		List<Retailer> retailerList = criteria.list();
		System.out.println("is it real");
		
		return retailerList;
	}

	@Override
	public List<Retailer> sellQuantityByRetailer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> sellDollarsBySupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> sellQuantityBySupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> inventoryByProductByRetailer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> inventoryByProductBySupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> inventoryByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> inventoryByProduct() {
		// TODO Auto-generated method stub
		return null;
	}


}
