package com.ims.logic;

import java.util.List;

import org.hibernate.Session;

import com.ims.dao.DAOInventory;
import com.ims.dao.DIInventory;
import com.ims.domain.Inventory;
import com.ims.domain.util.HibernateUtil;

public class InventoryLogic {
	private static DAOInventory daoInv = new DIInventory();
	
	
	
	public static List<Inventory> viewAllInventory(int retailerId){
		List<Inventory> list = daoInv.getAllInventory(retailerId);
		return list;
	}
	
	public static Inventory getInventoryObject(int retailerID, int productID){
		Inventory inv = daoInv.getInventoryObject(productID, retailerID);
		return inv;
	}
	
	public static void updateInventory(Inventory inventory){
		daoInv.updateInventory(inventory);		
	}

}
