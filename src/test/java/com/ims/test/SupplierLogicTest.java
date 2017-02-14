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
		
		DAOSupplier mockDAOSupplier = mock(DAOSupplier.class);
		
		
		//Execution

		Supplier supplier1 = new Supplier();
		
		when(mockDAOSupplier.getSupplier(1)).thenReturn(supplier1);
		
		SupplierLogic supLog = new SupplierLogic();
		supLog.setDaoSup(mockDAOSupplier);
		
		assertEquals(supplier1, supLog.getSupplier(2));		
		
	
	}

}
