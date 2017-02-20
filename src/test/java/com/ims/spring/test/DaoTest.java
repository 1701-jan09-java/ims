package com.ims.spring.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.*;
import com.ims.domain.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/test/resources/test-beans.xml" })
@Transactional
public class DaoTest {

	@Autowired
	private DAOCategory daoCategory;
	
	@Autowired
	private DAOInventory daoInventory;
	
	@Autowired
	private DAOProduct daoProduct;
	
	@Autowired
	private DAOPurchaseOrder daoPo;
	
	@Autowired
	private DAOPurchaseOrderLine daoPoLine;
	
	@Autowired
	private DAORetailer daoRetailer;
	
	@Autowired
	private DAOSupplier daoSupplier;
	
	@Autowired
	private DAOSale daoSale;	
	
	/* Test Category: */
	
	@Test
	public void testGetCategory() {
		Category category = daoCategory.getCategory(1);
		System.out.println(category);
	}
	
	@Test
	public void testGetAllCategories() {
		List<Category> categories = daoCategory.getAllCategories();
		System.out.println(categories);
	}
	
	/* Test Inventory: */
	
	@Test
	public void testGetInventory() {
		Inventory inventory = daoInventory.getInventoryObject(1, 1);
		System.out.println(inventory);
	}
	
	@Test 
	public void testGetAllInventory() {
		List<Inventory> allInv = daoInventory.getAllInventory(1);
		System.out.println(allInv.toString());
	}
	
	/* Test Product: */
	
	@Test
	public void testGetProduct() {
		Product product = daoProduct.getProduct(1);
		System.out.println(product);
	}
	
	@Test
	public void testGetProductByCategory() {
		List<Product> products = daoProduct.getAllProductsByCategory(1);
		System.out.println(products);
	}
	
	@Test
	public void testGetAllProducts() {
		List<Product> products = daoProduct.getAllProducts();
		System.out.println(products);		
	}
	
	/* Test PurchaseOrder: (DIPurchaseOrder Implementation has not been pulled into this branch... )*/

	
	@Test
	public void testCreatePurchaseOrder() {
		
		Date date = new Date();
		PurchaseOrder pOrder = new PurchaseOrder(date,daoSupplier.getSupplier(1), daoRetailer.getRetailer(1), 9.99);
		daoPo.createPurchaseOrder(pOrder);
		
	}
	
	@Test
	public void testGetPurchaseOrder() {
		
		PurchaseOrder pOrder = daoPo.getPurchaseOrder(1);
		System.out.println(pOrder);
		
	}
	
	@Test
	public void testGetPurchaseOrdersByRetailer() {
		
		List<PurchaseOrder> pOrders = daoPo.getAllPurchaseOrdersByRetailer(1);
		System.out.println(pOrders);
		
	}
	
	@Test
	public void testGetAllPurchaseOrders() {
		
		List<PurchaseOrder> allPOrders = daoPo.getAllPurchaseOrders();
		System.out.println(allPOrders);
		
	}
	
	
	/* Test PurchaseOrderLine (DIPurchaseOrderLine Implementation has not been pulled into this branch... ) */

	
	@Test
	public void testGetPurchaseOrderLine() {
		
		PurchaseOrderLine poLine = daoPoLine.getPurchaseOrderLine(1);
		System.out.println(poLine);
	}
	
	@Test
	public void testGetAllPurchaseOrderLines() {
		List<PurchaseOrderLine> allPoLines = daoPoLine.getAllPurchaseOrderLinesByPO(1);
		
		System.out.println(allPoLines);
	}
	
	
	/* Test Retailer: */
	
	@Test
	public void testGetRetailer() {
		
		Retailer retailer = daoRetailer.getRetailer(1);
		System.out.println(retailer);
	}
	
	@Test
	public void testGetAllRetailers() {
		
		List<Retailer> allRetailers = daoRetailer.getAllRetailers();
		System.out.println(allRetailers.toString());
	}

	/* Test Supplier: */
	
	@Test
	public void testGetSupplier() {
		
		Supplier supplier = daoSupplier.getSupplier(1);
		System.out.println(supplier);
	}
	
	@Test
	public void testGetAllSuppliers() {
		
		List<Supplier> allSuppliers = daoSupplier.getAllSuppliers();
		System.out.println(allSuppliers.toString());
	}
	
	/* Test Sale: */
	
	public void testCreateSale() {
		
		Date date = new Date();
		Sale sale = new Sale(daoRetailer.getRetailer(1), daoProduct.getProduct(1), 200, 40.00, date);
		daoSale.createSale(sale);
	}
	
	public void testGetSale() {
		
		Sale sale = daoSale.getSale(1);
		System.out.println(sale);
	}
	
	public void testGetAllSales() {
		
		List<Sale> allSales = daoSale.getAllSales();
		System.out.println(allSales.toString());
	}
	
	public void testGetSalesByRetailer() {
		
		List<Sale> salesByRet = daoSale.getAllSalesByRetailer(1);
		System.out.println(salesByRet.toString());
	}
	
}
