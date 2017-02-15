package com.ims.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static com.ims.logic.SupplierLogic.*;

public class SupplierLogicTest {
	
	@Test
	public void testGetSupplier() {
		
		assertEquals("Supplier [id=100, name=TestSupplier, address=[street=24916 Square Street, city=Pheonix, state=AZ, zip=85203]]", getSupplier(100).toString());
		assertEquals("Supplier [id=122, name=Apple, address=[street=245 B Street, city=Pheonix, state=AZ, zip=85203]]", getSupplier(122).toString());
		assertEquals("Supplier [id=123, name=TestSupplier2, address=[street=Ap #532-4097 Vel, Avenue, city=Carson City, state=NV, zip=82529]]", getSupplier(123).toString());
		assertEquals("Supplier [id=124, name=TestSupplier3, address=[street=845-6559 Aliquam Rd., city=Shreveport, state=Louisiana, zip=49344]]", getSupplier(124).toString());
	}
	
	@Test
	public void testGetAllSuppliers() {
		String expected = "[Supplier [id=123, name=TestSupplier2, address=[street=Ap #532-4097 Vel, Avenue, city=Carson City, state=NV, zip=82529]]," + 
						" Supplier [id=124, name=TestSupplier3, address=[street=845-6559 Aliquam Rd., city=Shreveport, state=Louisiana, zip=49344]]," + 
						" Supplier [id=100, name=TestSupplier, address=[street=24916 Square Street, city=Pheonix, state=AZ, zip=85203]]," + 
						" Supplier [id=122, name=Apple, address=[street=245 B Street, city=Pheonix, state=AZ, zip=85203]]]";
		String actual = getAllSuppliers().toString();
		
		assertEquals(expected, actual);
	}

}
