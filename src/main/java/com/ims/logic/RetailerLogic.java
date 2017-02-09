package com.ims.logic;

import java.util.List;

import com.ims.dao.DAORetailer;
import com.ims.dao.DIRetailer;
import com.ims.domain.Retailer;

public class RetailerLogic {
	
	DAORetailer daoRet = new DIRetailer();

	public Retailer viewRetailerById(int id) {
		
		Retailer retailer = daoRet.getRetailer(id);
		
		return retailer;
	}
	
	public List<Retailer> viewAllRetailers() {
		
		List<Retailer> retailers = daoRet.getAllRetailers();
		
		return retailers;
	}
}

