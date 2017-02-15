package com.ims;

import static com.ims.logic.InventoryLogic.*;
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert.*;
public class InventoryLogicTest {
	
//	@Before
//	public void setup() {
//		System.out.println("Setup - creating InventoryLogic Object");
//		daoInv = new DIInventory();
//	}
//	
	
	@Test
	public void testViewAllInventory(){
		String stringExp = "[Inventory [id=101, retailer=Retailer [id=5, name=Cedric Burns, address=[street=Ap #880-7809 Ut Rd., city=Lakewood, state=CO, zip=35710]], product=Product [id=300, name=Test, supplierPrice=5, retailerPrice=55, categories=[]], productQuantity=250, productThreshold=350], Inventory [id=102, retailer=Retailer [id=5, name=Cedric Burns, address=[street=Ap #880-7809 Ut Rd., city=Lakewood, state=CO, zip=35710]], product=Product [id=300, name=Test, supplierPrice=5, retailerPrice=55, categories=[]], productQuantity=350, productThreshold=400], Inventory [id=103, retailer=Retailer [id=5, name=Cedric Burns, address=[street=Ap #880-7809 Ut Rd., city=Lakewood, state=CO, zip=35710]], product=Product [id=100, name=Dog Carrier, supplierPrice=40, retailerPrice=50, categories=[Category [id=100, name=Pet Supplies]]], productQuantity=150, productThreshold=150]]";
		String stringAct = viewAllInventory(5).toString();
		assertEquals("Inventory ID 5", stringExp, stringAct);
	}
	
	

}
