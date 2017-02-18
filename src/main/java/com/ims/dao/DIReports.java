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
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> sellDollarsByProduct() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrderLine.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("cost"))
						.add(Projections.groupProperty("product")));
		
		List<Product> productList = criteria.list();
		return productList;
	}

	@Override
	public List<Product> sellQuantityByProduct() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrderLine.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("quantity"))
						.add(Projections.groupProperty("product")));
		
		List<Product> productList = criteria.list();
		return productList;
		
	}

	@Override
	public List<Product> avgSellDollarsByProduct() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrderLine.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.avg("cost"))
						.add(Projections.groupProperty("product")));
		
		List<Product> productList = criteria.list();
		return productList;
	}

	@Override
	public List<Product> avgQuantityByProduct() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrderLine.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.avg("quantity"))
						.add(Projections.groupProperty("product")));
		
		List<Product> productList = criteria.list();
		return productList;
	}

	@Override
	public List<Retailer> sellDollarsByRetailer() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrder.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("cost"))
						.add(Projections.groupProperty("retailer")));
		
		List<Retailer> retailerList = criteria.list();
		
		return retailerList;
	}

	@Override
	public List<Retailer> sellQuantityByRetailer() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrder.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("retailer"))
						.add(Projections.groupProperty("retailer")));
		
		List<Retailer> retailerList = criteria.list();
		
		return retailerList;
	}

	@Override
	public List<Supplier> sellDollarsBySupplier() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrder.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("cost"))
						.add(Projections.groupProperty("supplier")));
		
		List<Supplier> supplierList = criteria.list();
		
		return supplierList;
	}

	@Override
	public List<Supplier> sellQuantityBySupplier() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PurchaseOrder.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("supplier"))
						.add(Projections.groupProperty("supplier")));
		
		List<Supplier> supplierList = criteria.list();
		
		return supplierList;
	}

	@Override
	public List<Product> inventoryByProductByRetailer() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("productQuantity"))
						.add(Projections.groupProperty("product"))
						.add(Projections.groupProperty("retailer")));
		
		List<Product> productList = criteria.list();
		
		return productList;
	}

	@Override
	public List<Product> avgInventoryByProductByRetailer() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("product"))
						.add(Projections.groupProperty("product"))
						.add(Projections.groupProperty("retailer")));
		
		List<Product> productList = criteria.list();
		
		return productList;
	}

	@Override
	public List<Product> inventoryThresholdByProduct() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("productQuantity"))
						.add(Projections.groupProperty("product"))
						.add(Projections.groupProperty("productThreshold")));
		
		List<Product> productList = criteria.list();
		
		return productList;
	}
	
	@Override
	public List<Product> inventoryThresholdByProductByRetailer() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("productQuantity"))
						.add(Projections.groupProperty("product"))
						.add(Projections.groupProperty("retailer"))
						.add(Projections.groupProperty("productThreshold")));
		
		List<Product> productList = criteria.list();
		
		return productList;
	}

	@Override
	public List<Product> inventoryByProduct() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		criteria.setProjection(Projections.projectionList()
						.add(Projections.sum("productQuantity"))
						.add(Projections.groupProperty("product")));
		
		List<Product> productList = criteria.list();
		
		return productList;
	}


}
