package com.ims.DAO;

import org.hibernate.cfg.NotYetImplementedException;

public class DIInventory implements DAOInventory {

	@Override
	public void updateInventory(int productID, int retailer) {
		throw new NotYetImplementedException();
		
	}

	@Override
	public int inventory(int productID, int retailerID) {
		throw new NotYetImplementedException();
		return 0;
	}

}
