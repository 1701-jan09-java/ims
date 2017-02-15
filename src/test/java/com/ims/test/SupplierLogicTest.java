package com.ims.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

<<<<<<< HEAD
import com.ims.dao.DAOSupplier;
import com.ims.domain.Supplier;
import com.ims.logic.SupplierLogic;

import static com.ims.logic.SupplierLogic.*;
=======
import com.ims.logic.SupplierLogic;
>>>>>>> SubmitPO

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class SupplierLogicTest {
	
<<<<<<< HEAD
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
=======
	@Autowired
	private SupplierLogic supplierLogic;
	
	@Test
	public void testGetSupplier() {
		
		assertEquals("Supplier [id=100, name=TestSupplier, address=[street=24916 Square Street, city=Pheonix, state=AZ, zip=85203]]", supplierLogic.getSupplier(100).toString());
		assertEquals("Supplier [id=122, name=Apple, address=[street=245 B Street, city=Pheonix, state=AZ, zip=85203]]", supplierLogic.getSupplier(122).toString());
		assertEquals("Supplier [id=123, name=TestSupplier2, address=[street=Ap #532-4097 Vel, Avenue, city=Carson City, state=NV, zip=82529]]", supplierLogic.getSupplier(123).toString());
		assertEquals("Supplier [id=124, name=TestSupplier3, address=[street=845-6559 Aliquam Rd., city=Shreveport, state=Louisiana, zip=49344]]", supplierLogic.getSupplier(124).toString());
	}
>>>>>>> SubmitPO
	
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
