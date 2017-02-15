package com.ims.logic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOSale;
import com.ims.dao.DISale;
import com.ims.domain.Product;
import com.ims.domain.Retailer;
import com.ims.domain.Sale;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class SaleLogic {
	
	@Autowired
	private DAOSale dao;
	
	public void createSale(Sale sale) {	
		dao.createSale(sale);
		
	}
	
	public void updateSale(Sale sale) {
		
		dao.updateSale(sale);
		
	}
	
	public void deleteSale(Sale sale) {
		
		dao.deleteSale(sale);
		
	}
	
	public Sale getSale(int id) {
		
		Sale sale = dao.getSale(id);
		
		return sale;
	}
	
	public List<Sale> getAllSales() {
		
		List<Sale> allSales = dao.getAllSales();
		
		return allSales;
	}
	
	public List<Sale> getSalesByRetailer(int retID) {
		
		List<Sale> salesByRet = dao.getAllSalesByRetailer(retID);
		
		return salesByRet;
		
	}
}
