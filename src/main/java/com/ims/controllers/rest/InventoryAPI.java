package com.ims.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Inventory;
import com.ims.logic.InventoryLogic;

@RestController
@RequestMapping(value="/inventory")
public class InventoryAPI {
	
	
	@Autowired
	private InventoryLogic inventoryLogic;
	
	
	/**
	 * Id relates to the retailer ID, 
	 * and this returns a list of all their inventory objects
	**/
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public  List<Inventory> getAllInventory(@PathVariable("id") Integer id) {
		List<Inventory> invList = inventoryLogic.viewAllInventory(id);
		return invList;
	}
		

}
