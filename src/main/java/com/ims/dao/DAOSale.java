package com.ims.dao;

import java.util.List;

import com.ims.domain.Sale;

public interface DAOSale {
	
	//basic CRUD
	void createSale(Sale sale);
	void updateSale(Sale sale);
	void deleteSale(Sale sale);
	Sale getSale(int id);
	
	//Query
	List<Sale> getAllSales();
	List<Sale> getAllSalesByRetailer(int retailerID);

}
