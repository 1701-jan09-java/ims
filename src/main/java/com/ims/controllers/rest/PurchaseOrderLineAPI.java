package com.ims.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.PurchaseOrderLine;
import com.ims.logic.PurchaseOrderLineLogic;

@RestController
@RequestMapping(value="/purchase-order-line")
public class PurchaseOrderLineAPI {
	
	@Autowired
	private PurchaseOrderLineLogic polLogic;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public PurchaseOrderLine getPurchaseOrderLine(@PathVariable("id") Integer id) {
		PurchaseOrderLine pol = polLogic.getPurchaseOrderLine(id);
		return pol;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="po/{id}")
	public List<PurchaseOrderLine> getAllPurchaseOrderLinesByPO(@PathVariable("id") Integer id) {
		List<PurchaseOrderLine> purchaseOrderLine = polLogic.getAllPurchaseOrderLinesByPO(id);
		return purchaseOrderLine;
	}
	

}
