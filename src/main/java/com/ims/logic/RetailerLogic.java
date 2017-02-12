package com.ims.logic;

import java.util.List;

import com.ims.dao.DAORetailer;
import com.ims.dao.DIRetailer;
import com.ims.domain.Retailer;

public class RetailerLogic {
	
	private static DAORetailer daoRet = new DIRetailer();

	public static Retailer viewRetailerById(int id) {
		
		Retailer retailer = daoRet.getRetailer(id);
		
		return retailer;
	}
	
	public static List<Retailer> viewAllRetailers() {
		
		List<Retailer> retailers = daoRet.getAllRetailers();
		
		return retailers;
	}
}

