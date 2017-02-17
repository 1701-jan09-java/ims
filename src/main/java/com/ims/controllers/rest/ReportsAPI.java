package com.ims.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.PurchaseOrder;
import com.ims.domain.Retailer;
import com.ims.logic.ReportsLogic;

@RestController
@RequestMapping(value="/reports")
public class ReportsAPI {
	
	@Autowired
	private ReportsLogic reportsLogic;
	
//	@RequestMapping(method=RequestMethod.GET, value="/po5k")
//	public List<PurchaseOrder> getAllPurchaseOrdersOver5k() {
//		List<PurchaseOrder> purchaseOrder = reportsLogic.getAllPurchaseOrdersOver5k();
//		return purchaseOrder;
//	}
	
	@RequestMapping(method=RequestMethod.GET, value="/dollars-by-retailer")
	public List<Retailer> sellDollarsByRetailer() {
		List<Retailer> retailers = reportsLogic.sellDollarsByRetailer();
		return retailers;
	}

}
