package com.ims.test;

import com.ims.logic.CategoryLogic;
import com.ims.logic.InventoryLogic;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class InventoryLogicTest {
	
	@Autowired
	private InventoryLogic inventoryLogic;
	
	@Test
	public void testViewAllInventory(){
		
		String stringExp = "[Inventory [id=506, retailer=Retailer [id=24, name=tortor eu, address=[street=1918 Spohn Plaza, city=Sacramento, state=California, zip=95818]], product=Product [id=140, name=ipsum, supplierPrice=27.62, retailerPrice=468.14, categories=[Qualitest Pharmaceuticals]], productQuantity=7956, productThreshold=3721]]";
	
		String stringAct = inventoryLogic.viewAllInventory(24).toString();

		assertEquals("Inventory ID 24", stringExp, stringAct);
	}
	
	

}
