package com.ims.test;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.ims.dao.DAOPurchaseOrder;
import com.ims.dao.DAOPurchaseOrderLine;
import com.ims.domain.PurchaseOrderLine;

public class DIPurchaseOrderLineTest {
	
	@Test
	public void testCreatePurchaseOrderLine() {
		
		//Setup
		DAOPurchaseOrderLine mockDaoPurchaseOrderLine = mock(DAOPurchaseOrderLine.class);
		DAOPurchaseOrder mockDaoPurchaseOrder = mock(DAOPurchaseOrder.class);
		
		//Execution
		
		PurchaseOrderLine poLine1 = new PurchaseOrderLine();
		PurchaseOrderLine poLine2 = new PurchaseOrderLine();
		PurchaseOrderLine poLine3 = new PurchaseOrderLine();
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		when(mockDaoPurchaseOrderLine.save(po)).thenReturn(poLine1);

		
	}
	
	
}
