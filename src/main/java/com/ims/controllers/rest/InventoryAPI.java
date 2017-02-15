package com.ims.controllers.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Category;
import com.ims.domain.Inventory;
import com.ims.logic.InventoryLogic;

@RestController
@RequestMapping(value="/inventory")
public class InventoryAPI {
	
	
//	@RequestMapping(method=RequestMethod.GET, value="/{id}")
//	public Category getCategory(@PathVariable("id") Integer id) {
//		Category category = CategoryLogic.getCategory(id);
//		return category;
//	}
	
	/**
	 * Id relates to the retailer ID, 
	 * and this returns a list of all their inventory objects
	**/
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public  List<Inventory> getAllInventory(@PathVariable("id") Integer id) {
		List<Inventory> invList = InventoryLogic.viewAllInventory(id);
		return invList;
	}
	
	
	

}
