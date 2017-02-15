package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOInventory;

import com.ims.domain.Inventory;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class InventoryLogic {
	
	@Autowired
	private DAOInventory daoInv;
		
	public  List<Inventory> viewAllInventory(int retailerId){
		List<Inventory> list = daoInv.getAllInventory(retailerId);
		return list;
	}
	
	public static void main(String[] args) {
		
		InventoryLogic invy = new InventoryLogic();
		String testInv = invy.viewAllInventory(5).toString();
		
		System.out.println(testInv);
		
	}
	

}
