package com.ims.logic;

import java.util.List;

import org.hibernate.Session;

import com.ims.dao.DAOInventory;
import com.ims.dao.DIInventory;
import com.ims.domain.Inventory;
import com.ims.domain.util.HibernateUtil;

public class InventoryLogic {
	private static DAOInventory daoInv = new DIInventory();
	
	public List<Inventory> viewAllInventory(int retailerId){
		List<Inventory> list = daoInv.getAllInventory(retailerId);
		return list;
	}
	
	
	public static void main(String[] args) {
		InventoryLogic invy = new InventoryLogic();
		List<Inventory> dogsAndMoreDogs = invy.viewAllInventory(5);
		
		System.out.println(dogsAndMoreDogs);
		
	}
	

}
