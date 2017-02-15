package com.ims.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ims.logic.SupplierLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class SupplierLogicTest {
	
	@Autowired
	private SupplierLogic supplierLogic;
	
	@Test
	public void testGetSupplier() {
		
		assertEquals("Supplier [id=100, name=TestSupplier, address=[street=24916 Square Street, city=Pheonix, state=AZ, zip=85203]]", supplierLogic.getSupplier(100).toString());
		assertEquals("Supplier [id=122, name=Apple, address=[street=245 B Street, city=Pheonix, state=AZ, zip=85203]]", supplierLogic.getSupplier(122).toString());
		assertEquals("Supplier [id=123, name=TestSupplier2, address=[street=Ap #532-4097 Vel, Avenue, city=Carson City, state=NV, zip=82529]]", supplierLogic.getSupplier(123).toString());
		assertEquals("Supplier [id=124, name=TestSupplier3, address=[street=845-6559 Aliquam Rd., city=Shreveport, state=Louisiana, zip=49344]]", supplierLogic.getSupplier(124).toString());
	}
	
	@Test
	public void testGetAllSuppliers() {
		String expected = "[Supplier [id=123, name=TestSupplier2, address=[street=Ap #532-4097 Vel, Avenue, city=Carson City, state=NV, zip=82529]]," + 
						" Supplier [id=124, name=TestSupplier3, address=[street=845-6559 Aliquam Rd., city=Shreveport, state=Louisiana, zip=49344]]," + 
						" Supplier [id=100, name=TestSupplier, address=[street=24916 Square Street, city=Pheonix, state=AZ, zip=85203]]," + 
						" Supplier [id=122, name=Apple, address=[street=245 B Street, city=Pheonix, state=AZ, zip=85203]]]";
		String actual = supplierLogic.getAllSuppliers().toString();
		
		assertEquals(expected, actual);
	}

}
