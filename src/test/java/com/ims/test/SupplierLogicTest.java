package com.ims.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ims.dao.DAOSupplier;
import com.ims.dao.DISupplier;
import com.ims.domain.Supplier;
import com.ims.domain.util.HibernateUtil;
import com.ims.logic.SupplierLogic;

import static com.ims.logic.SupplierLogic.*;

public class SupplierLogicTest {
	
	@Test
	public void testGetSupplierByIdSuccess() throws Exception {
		
		//Setup
		
//		HibernateUtil mockHib = mock(HibernateUtil.class);
//		Transaction mockTx = mock(Transaction.class);
		
		DAOSupplier mockDAOSupplier = mock(DAOSupplier.class);
		
//		DISupplier sup = mock(DISupplier.class);
		
//		SupplierLogic supLog = mock(SupplierLogic.class);
		
		
		
		
//		sup.getSupplier(mockDAOSupplier);
		
//		Session session = HibernateUtil.getSession();
		
		
		
//		Supplier supplier1 = mock(Supplier.class, "supplier1");
//		Supplier supplier2 = mock(Supplier.class, "supplier2");
//		Supplier supplier3 = mock(Supplier.class, "supplier3");
		
//		supplier1.setId(1);
//		supplier2.setId(2);
//		supplier3.setId(3);
		
		//Execution
//		Supplier result = supLog.getSupplier(1);
		
		//Verification
//		when(supLog.getSupplier(1)).thenReturn(supplier1);
		Supplier supplier1 = new Supplier();
		
		when(mockDAOSupplier.getSupplier(1)).thenReturn(supplier1);
		
		SupplierLogic supLog = new SupplierLogic();
		supLog.setDaoSup(mockDAOSupplier);
		
		assertEquals(supplier1, supLog.getSupplier(2));
		
//		return supplier1;
		
		
	
	}

}
