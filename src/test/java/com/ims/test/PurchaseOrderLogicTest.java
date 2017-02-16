package com.ims.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ims.domain.PurchaseOrder;
import com.ims.logic.PurchaseOrderLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class PurchaseOrderLogicTest {

	@Autowired
	private PurchaseOrderLogic poLogic;
	
	@Test
	public void testGetPurchaseOrder(){
		assertEquals("PurchaseOrder [id=104, purchaseDate=2017-02-08, supplier=Supplier "
				+ "[id=100, name=TestSupplier, address=[street=24916 Square Street, city=Pheonix, state=AZ, zip=85203]], retailer=Retailer "
				+ "[id=1, name=Lenore Fuentes, address=[street=248 Powers Street, city=Mesa, state=AZ, zip=85206]], cost=50.0]", 
				poLogic.getPurchaseOrder(104).toString());
	}
	
	
}
