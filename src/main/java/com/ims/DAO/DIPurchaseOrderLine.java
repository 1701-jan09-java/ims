package com.ims.DAO;

import java.util.EmptyStackException;
import java.util.List;

public class DIPurchaseOrderLine implements DAOPurchaseOrderLine {

	@Override
	public void createPurchaseOrderLine(PurchaseOrder po) {
		// TODO Auto-generated method stub
		if (po == null) {
	        throw new EmptyStackException();
	    }
		
	}

	@Override
	public PurchaseOrderLine getPurchaseOrderLine(int poLineId) {
		// TODO Auto-generated method stub
		if (poLineId == null) {
	        throw new EmptyStackException();
	    }
		return null;
	}

	@Override
	public List<PurchaseOrderLine> getAllPurchaseOrderLines() {
		// TODO Auto-generated method stub
	        throw new EmptyStackException();
		return null;
	}

	@Override
	public void updatePurchaseOrderLine(int poLineId) {
		// TODO Auto-generated method stub
		if (poLineId == null) {
	        throw new EmptyStackException();
	    }
		
	}

	@Override
	public void deletePurchaseOrderLine(int poLineId) {
		// TODO Auto-generated method stub
		if (poLineId == null) {
	        throw new EmptyStackException();
	    }
		
	}

}
