package com.ims.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.ims.dao.DAOSupplier;
import com.ims.domain.Supplier;
import com.ims.logic.SupplierLogic;

import static com.ims.logic.SupplierLogic.*;

public class SupplierLogicTest {
	
//	@Test
//	public void testGetSupplier() {
//		
//		//Setup
//		DAOSupplier mockDaoSupplier = mock(DAOSupplier.class);
//		
//		//Execution
//		
//		Supplier supplier1 = new Supplier();
//		Supplier supplier2 = new Supplier();
//		Supplier supplier3 = new Supplier();
//		
//		when(mockDaoSupplier.DISupplier.getSupplier(1)).thenReturn(supplier1);
//		
//		SupplierLogic supplierLogic = new SupplierLogic();
//		supplierLogic.setDaoSup(mockDaoSupplier);
//		
//		assertEquals(supplier1, supplierLogic.getSupplier(1));
//	}
	
	@Test
	public void testGetAllSuppliers() {
		String expected = "[Supplier [id=123, name=TestSupplier2, address=Ap #532-4097 Vel, Avenue, Carson City,  NV, 82529]," + 
						" Supplier [id=124, name=TestSupplier3, address=845-6559 Aliquam Rd., Shreveport,  Louisiana, 49344]," + 
						" Supplier [id=100, name=TestSupplier, address=24916 Square Street, Pheonix,  AZ, 85203]," + 
						" Supplier [id=122, name=Apple, address=245 B Street, Pheonix,  AZ, 85203]]";
		String actual = getAllSuppliers().toString();
		
		assertEquals(expected, actual);
	}

}
