package com.ims.controllers.rest;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.PurchaseOrder;
import com.ims.dto.PurchaseOrderDTO;
import com.ims.logic.PurchaseOrderLogic;

@RestController
@RequestMapping(value="/purchase-order")
public class PurchaseOrderAPI {
	
	@Autowired
	private PurchaseOrderLogic poLogic;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public PurchaseOrder getPurchaseOrder(@PathVariable("id") Integer id) {
		throw new NotYetImplementedException();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public List<PurchaseOrder> getAllProducts() {
		throw new NotYetImplementedException();
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="", params={"supplierId","retailerId","cost"})
//	public boolean createPurchaseOrder(HttpServletRequest request) {
//		int supplierId = Integer.parseInt(request.getParameter("supplierId"));
//		int retailerId = Integer.parseInt(request.getParameter("retailerId"));
//		int cost = Integer.parseInt(request.getParameter("cost"));
//		PurchaseOrder po = PurchaseOrderLogic.createPurchaseOrder(supplierId, retailerId, cost);
//		
//		if (po == null) {
//			return false;
//		}
//		
//		else return true;
//	}
	
	@RequestMapping(method=RequestMethod.POST, value="", consumes="application/json")
	public boolean createPurchaseOrder(@RequestBody PurchaseOrderDTO json) {
		System.out.println(json);
		
		PurchaseOrder po = poLogic.createPurchaseOrder(json);
		
		if (po == null) {
			return false;
		}
		
		else return true;

	}
		
}
