package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOProduct;
import com.ims.dao.DAOPurchaseOrder;
import com.ims.dao.DAOPurchaseOrderLine;
import com.ims.domain.Product;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.PurchaseOrderLine;
import com.ims.dto.POLineDTO;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class PurchaseOrderLineLogic {
	
	@Autowired
	private DAOPurchaseOrderLine dao;
	@Autowired
	private DAOProduct daoProd;
	@Autowired
	private DAOPurchaseOrder daoPO;
	
	public void createPurchaseOrderLine(POLineDTO polDTO, int poId) {
		
		PurchaseOrderLine poLine = new PurchaseOrderLine();
		Product prod = daoProd.getProduct(polDTO.getProdId());
		PurchaseOrder po = daoPO.getPurchaseOrder(poId);
		poLine.setProduct(prod);
		poLine.setCost(polDTO.getCost());
		poLine.setQuantity(polDTO.getCount());
		poLine.setPurchaseOrder(po);
				
		dao.createPurchaseOrderLine(poLine);
		
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
