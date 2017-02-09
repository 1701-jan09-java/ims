package com.ims.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ims.domain.*;
import com.ims.domain.util.HibernateUtil;
import com.ims.logic.*;

public class MyMain {

	public static void main(String[] args) {
		
		/*
		// Test Retail Logic methods
		RetailerLogic retLogic = new RetailerLogic();
		
		Retailer testRet = retLogic.viewRetailerById(2);
		
		System.out.println(testRet);
		
		List<Retailer> testAllRet = retLogic.viewAllRetailers();
		
		for(Retailer all : testAllRet) {
			System.out.println(all);
		}
		*/
		
		//Session session = HibernateUtil.getSession(); 
		//Transaction tx = session.beginTransaction();
		
		//Date date = new Date();
		
		/*
		Supplier supplier = (Supplier) session.get(Supplier.class, 100);		
		Retailer retailer = (Retailer) session.get(Retailer.class, 5);				
		Product product = (Product) session.get(Product.class, 100);		
		*/
		
		/*
		// Test Purchase Order		
		PurchaseOrder purchaseOrder = new PurchaseOrder(date, supplier, retailer, 79.99);		
		session.save(purchaseOrder);			
		
		PurchaseOrder purchaseOrder = (PurchaseOrder) session.get(PurchaseOrder.class, 108);
		System.out.println(purchaseOrder.toString());
		*/
		
		/*
		// Test Purchase Order Line		
		PurchaseOrder purchaseOrder = (PurchaseOrder) session.get(PurchaseOrder.class, 106);
		PurchaseOrderLine poLine = new PurchaseOrderLine(purchaseOrder, product, 25, 50);
		session.save(poLine);		
		
		PurchaseOrderLine poLine = (PurchaseOrderLine) session.get(PurchaseOrderLine.class, 104);
		System.out.println(poLine.toString());
		*/
		
		/*
		// Test Sale	
		Sale sale = new Sale(retailer, product, 45, 49.99, date);
		session.save(sale);				
		
		Sale sale = (Sale) session.get(Sale.class, 102);
		System.out.println(sale.toString());
		*/	
		
		/*
		// Test Inventory
		Inventory inv = new Inventory(retailer, product, 150, 150);		
		session.save(inv);	
		
		Inventory inv = (Inventory) session.get(Inventory.class, 101);
		System.out.println(inv.toString());
		*/
		
		//tx.commit();
		//session.close(); 
	}
	
}
