package com.ims.logic;

import java.util.Date;
import java.util.List;

import com.ims.dao.DAOSale;
import com.ims.dao.DISale;
import com.ims.domain.Product;
import com.ims.domain.Retailer;
import com.ims.domain.Sale;

public class SaleLogic {
	
	private static DAOSale daoSale = new DISale();
	
	public static void createSale(Sale sale) {		
		
		//sale = new Sale(sale.getRetailer(), sale.getProduct(), sale.getProductQuantity(), sale.getCost(), sale.getSaleDate());
		
		daoSale.createSale(sale);
		
	}
	
	public static void updateSale(Sale sale) {
		
		daoSale.updateSale(sale);
		
	}
	
	public static void deleteSale(Sale sale) {
		
		daoSale.deleteSale(sale);
		
	}
	
	public static Sale getSale(int id) {
		
		Sale sale = daoSale.getSale(id);
		
		return sale;
	}
	
	public static List<Sale> getAllSales() {
		
		List<Sale> allSales = daoSale.getAllSales();
		
		return allSales;
	}
	
	public static List<Sale> getSalesByRetailer(int retID) {
		
		List<Sale> salesByRet = daoSale.getAllSalesByRetailer(retID);
		
		return salesByRet;
		
	}
	
	
	public static void main(String[] args) {
		
//		Retailer retail = RetailerLogic.viewRetailerById(4); 
//		Product prod = ProductLogic.getProduct(200);
//		Date date = new Date();
//		
//		Sale vikri = new Sale(retail, prod, 27, 150.00, date);		
//		createSale(vikri);
		
//		Sale sale = getSale(104);
//		sale.setCost(39.99);
//		System.out.println(sale.toString());
//		updateSale(sale);		
//		deleteSale(getSale(104));
		
//		List<Sale> all = getAllSales();
//		
//		for (Sale sal : all) {
//			System.out.println(sal.toString());
//		}
		
		List<Sale> salesByRet = getSalesByRetailer(2);
		
		
		for (Sale ret : salesByRet) {		
			
			System.out.println(ret.toString());
		}
	}

}
