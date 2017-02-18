package com.ims.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOReports;
import com.ims.domain.Product;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.Retailer;
import com.ims.domain.Supplier;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class ReportsLogic {
	
	@Autowired
	private DAOReports daoRep;
	
	
	public List<Product> sellDollarsByProduct() {
		
		List<Product> productList = daoRep.sellDollarsByProduct();
		return productList;
		
	}
	
	public List<Product> sellQuantityByProduct() {
		
		List<Product> productList = daoRep.sellQuantityByProduct();
		return productList;
		
	}
	
	public List<Product> avgSellDollarsByProduct() {
		
		List<Product> productList = daoRep.avgSellDollarsByProduct();
		return productList;
		
	}
	
	public List<Product> avgQuantityByProduct() {
		
		List<Product> productList = daoRep.avgQuantityByProduct();
		return productList;
		
	}
	
	public List<Retailer> sellDollarsByRetailer() {
		
		List<Retailer> retailerList = daoRep.sellDollarsByRetailer();
		return retailerList;
	}
	
	public List<Retailer> sellQuantityByRetailer() {
		
		List<Retailer> retailerList = daoRep.sellQuantityByRetailer();
		return retailerList;
		
	}
	
	public List<Supplier> sellDollarsBySupplier() {
		
		List<Supplier> supplierList = daoRep.sellDollarsBySupplier();
		return supplierList;
	}
	
	public List<Supplier> sellQuantityBySupplier() {
		
		List<Supplier> supplierList = daoRep.sellQuantityBySupplier();
		return supplierList;
	}
	
	public List<Product> inventoryByProductByRetailer() {
		
		List<Product> productList = daoRep.inventoryByProductByRetailer();
		return productList;
	}
	
	public List<Product> avgInventoryByProductByRetailer() {
		
		List<Product> productList = daoRep.avgInventoryByProductByRetailer();
		return productList;
	}
	
	public List<Product> inventoryThresholdByProduct() {
		
		List<Product> productList = daoRep.inventoryThresholdByProduct();
		return productList;
	}
	
public List<Product> inventoryThresholdByProductByRetailer() {
		
		List<Product> productList = daoRep.inventoryThresholdByProductByRetailer();
		return productList;
	}
	
	public List<Product> inventoryByProduct() {
		
		List<Product> productList = daoRep.inventoryByProduct();
		return productList;
	}

}
