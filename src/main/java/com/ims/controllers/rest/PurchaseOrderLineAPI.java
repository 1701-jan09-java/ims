package com.ims.controllers.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.PurchaseOrderLine;
import com.ims.logic.PurchaseOrderLineLogic;

@RestController
@RequestMapping(value="/purchaseorderline")
public class PurchaseOrderLineAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public PurchaseOrderLine getPurchaseOrderLine(@PathVariable("id") Integer id) {
		PurchaseOrderLine pol = PurchaseOrderLineLogic.getPurchaseOrderLine(id);
		return pol;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="po/{id}")
	public List<PurchaseOrderLine> getAllPurchaseOrderLinesByPO(@PathVariable("id") Integer id) {
		List<PurchaseOrderLine> purchaseOrderLine = PurchaseOrderLineLogic.getAllPurchaseOrderLinesByPO(id);
		return purchaseOrderLine;
	}

}
