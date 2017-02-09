package com.ims.DAO;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

public class DISale implements DAOSale{

	@Override
	public void createSale(Sale sale) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public void updateSale(Sale sale) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public void deleteSale(Sale sale) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public Sale getSale(int id) {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<Sale> getAllSales() {
		throw new NotYetImplementedException();
		return null;
	}

	@Override
	public List<Sale> getAllSalesByRetailer(int retailerID) {
		throw new NotYetImplementedException();
		return null;
	}

}
