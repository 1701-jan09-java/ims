package com.ims.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ims.dao.DAOPurchaseOrderLine;
import com.ims.dao.DIPurchaseOrderLine;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.domain.util.HibernateUtil;

public class PurchaseOrderLineLogic {
	
	private static DAOPurchaseOrderLine dao = new DIPurchaseOrderLine();
	
	public void createPurchaseOrderLine(PurchaseOrderLine pol) {
		
		dao.createPurchaseOrderLine(pol);
		
	}

	public PurchaseOrderLine getPurchaseOrderLine(int poLineId) {
		
		PurchaseOrderLine pol = dao.getPurchaseOrderLine(poLineId);
		return pol;
		
	}

	
	public List<PurchaseOrderLine> getAllPurchaseOrderLines(PurchaseOrder poId) {
		
		List<PurchaseOrderLine> polList = dao.getAllPurchaseOrderLines(poId);
		
		return polList;
		
	}

	
	public void updatePurchaseOrderLine(int poLineId) {
		
		dao.updatePurchaseOrderLine(poLineId);
		
	}

	
	public void deletePurchaseOrderLine(int poLineId) {
		
		dao.deletePurchaseOrderLine(poLineId);
		
	}

}
