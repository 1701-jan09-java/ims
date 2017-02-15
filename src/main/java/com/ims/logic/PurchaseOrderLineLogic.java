package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOPurchaseOrderLine;
import com.ims.dao.DIPurchaseOrderLine;
import com.ims.domain.Product;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class PurchaseOrderLineLogic {
	
	@Autowired
	private DAOPurchaseOrderLine dao = new DIPurchaseOrderLine();
	private PurchaseOrder po;
	private Product prod;
	
	public void createPurchaseOrderLine(PurchaseOrderLine pol) {
		
		p
		dao.createPurchaseOrderLine(pol);
		
	}

	public PurchaseOrderLine getPurchaseOrderLine(int poLineId) {
		
		PurchaseOrderLine pol = dao.getPurchaseOrderLine(poLineId);
		return pol;
		
	}

	
	public List<PurchaseOrderLine> getAllPurchaseOrderLinesByPO(int pol_po) {
		
		
		List<PurchaseOrderLine> polList = dao.getAllPurchaseOrderLinesByPO(pol_po);
		
		return polList;
		
	}

	
	public void updatePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		dao.updatePurchaseOrderLine(poLineId);
		
	}

	
	public void deletePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		dao.deletePurchaseOrderLine(poLineId);
		
	}

}
