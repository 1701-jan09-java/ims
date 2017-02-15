package com.ims.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import com.ims.dao.DAOPurchaseOrder;
import com.ims.dao.DAOPurchaseOrderLine;
import com.ims.dao.DIPurchaseOrderLine;
import com.ims.domain.Product;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.domain.Retailer;
import com.ims.domain.Supplier;

public class DIPurchaseOrderLineTest {
	
	@Test
	public void testCreatePurchaseOrderLine() {
		
		//Setup
		DAOPurchaseOrderLine mockDaoPurchaseOrderLine = mock(DAOPurchaseOrderLine.class);
//		DAOPurchaseOrder mockDaoPurchaseOrder = mock(DAOPurchaseOrder.class);
		DIPurchaseOrderLine diPurchaseOrderLine = new DIPurchaseOrderLine();
		
		//Execution
		
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();
		
		//product1
		product1.setCategories(null);
		product1.setId(1);
		product1.setName("apple");
		product1.setRetailerPrice(5);
		product1.setSupplierPrice(2);
		
		//product2
		product2.setCategories(null);
		product2.setId(2);
		product2.setName("orange");
		product2.setRetailerPrice(3);
		product2.setSupplierPrice(1);
		
		//product3
		product3.setCategories(null);
		product3.setId(3);
		product3.setName("potatoe");
		product3.setRetailerPrice(3);
		product3.setSupplierPrice(1);
		
		//product4
		product4.setCategories(null);
		product4.setId(4);
		product4.setName("straw");
		product4.setRetailerPrice(10);
		product4.setSupplierPrice(1);
		
		Date purchaseDate = new Date();
		
		Supplier supplier = new Supplier();
		
		Retailer retailer = new Retailer();
		
		PurchaseOrder purchaseOrder1 = new PurchaseOrder(purchaseDate, supplier, retailer, 15);
		PurchaseOrder purchaseOrder2 = new PurchaseOrder(purchaseDate, supplier, retailer, 30);
		PurchaseOrder purchaseOrder3 = new PurchaseOrder(purchaseDate, supplier, retailer, 45);
		
		purchaseOrder1.setId(1);
		
		PurchaseOrderLine poLine1 = new PurchaseOrderLine(purchaseOrder1, product1, 3, 15);
		PurchaseOrderLine poLine2 = new PurchaseOrderLine(purchaseOrder1, product2, 6, 15);
		PurchaseOrderLine poLine3 = new PurchaseOrderLine(purchaseOrder1, product3, 9, 15);
		
		
		
		
		doNothing().when(mockDaoPurchaseOrderLine).createPurchaseOrderLine(purchaseOrder1);
		
//		assertEquals(purchaseOrder1, diPurchaseOrderLine.createPurchaseOrderLine(purchaseOrder1));
		Mockito.verify(mockDaoPurchaseOrderLine).createPurchaseOrderLine(purchaseOrder1);

		
	}
	
	
}
