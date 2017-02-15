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
	
	public void updateInventory(Inventory inventory){
		daoInv.updateInventory(inventory);
	}
	
	public Inventory getInventoryObject(int productID, int retailerID){
		Inventory inv = daoInv.getInventoryObject(productID, retailerID);
		return inv;
	}
	
	public int getInventoryAmount(int productID, int retailerID){
		int amt = daoInv.getInventoryAmount(productID, retailerID);
		return amt;
	}
	
	public  List<Inventory> viewAllInventory(int retailerId){
		List<Inventory> list = daoInv.getAllInventory(retailerId);
		return list;
	}

}
