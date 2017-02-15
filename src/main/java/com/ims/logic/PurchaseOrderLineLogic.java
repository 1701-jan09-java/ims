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

	public static PurchaseOrderLine getPurchaseOrderLine(int poLineId) {
		
		PurchaseOrderLine pol = dao.getPurchaseOrderLine(poLineId);
		return pol;
		
	}

	
	public static List<PurchaseOrderLine> getAllPurchaseOrderLinesByPO(int pol_po) {
		
		
		List<PurchaseOrderLine> polList = dao.getAllPurchaseOrderLinesByPO(pol_po);
		
		return polList;
		
	}

	
	public static void updatePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		dao.updatePurchaseOrderLine(poLineId);
		
	}

	
	public static void deletePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		dao.deletePurchaseOrderLine(poLineId);
		
	}

}
