package com.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ims.domain.PurchaseOrderLine;

@Component
public class DIPurchaseOrderLine implements DAOPurchaseOrderLine {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createPurchaseOrderLine(PurchaseOrderLine pol) {

		Session session = sessionFactory.getCurrentSession();
		
		session.save(pol);	        
		
	}

	@Override
	public PurchaseOrderLine getPurchaseOrderLine(int poLineId) {
		
		Session session = sessionFactory.getCurrentSession();
		PurchaseOrderLine pol = (PurchaseOrderLine) session.get(PurchaseOrderLine.class, poLineId);
				
		return pol;
		
		
	}

	@Override
	public List<PurchaseOrderLine> getAllPurchaseOrderLinesByPO(int poId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from PurchaseOrderLine where purchaseOrder.id = :idvalue");
		query.setInteger("idvalue", poId);
		
		List<PurchaseOrderLine> pOLs = query.list();
				
		return pOLs;

	}

	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		Session session = sessionFactory.getCurrentSession();
				
		session.update(poLineId);
		
		
	}

	@Override
	public void deletePurchaseOrderLine(PurchaseOrderLine poLineId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		
		session.delete(poLineId);
		
	}

}
