package com.ims.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ims.dao.DAOPurchaseOrder;
import com.ims.dao.DAOPurchaseOrderLine;
import com.ims.dao.DIPurchaseOrder;
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

	
	public List<PurchaseOrderLine> getAllPurchaseOrderLines(int pol_po) {
		
		
		List<PurchaseOrderLine> polList = dao.getAllPurchaseOrderLines(pol_po);
		
		return polList;
		
	}

	
	public void updatePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		dao.updatePurchaseOrderLine(poLineId);
		
	}

	
	public void deletePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		dao.deletePurchaseOrderLine(poLineId);
		
	}

}
