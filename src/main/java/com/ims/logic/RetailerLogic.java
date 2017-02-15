package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAORetailer;
import com.ims.dao.DIRetailer;
import com.ims.domain.Retailer;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class RetailerLogic {
	
	@Autowired
	private DAORetailer dao;

	public Retailer viewRetailerById(int id) {		
		Retailer retailer = dao.getRetailer(id);	
		return retailer;
	}

	public List<Retailer> viewAllRetailers() {		
		List<Retailer> retailers = dao.getAllRetailers();	
		return retailers;
	}
}

