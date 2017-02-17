package com.ims.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOReports;
import com.ims.domain.PurchaseOrder;
import com.ims.domain.Retailer;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class ReportsLogic {
	
	@Autowired
	private DAOReports daoRep;
	
	
//	public List<PurchaseOrder> getAllPurchaseOrdersOver5k() {
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(PurchaseOrder.class);
//		criteria.add(Restrictions.gt("po_cost", 5000));
//		List<PurchaseOrder> poList = criteria.list();
//		return poList;
//	}
	
	public List<Retailer> sellDollarsByRetailer() {
		
		List<Retailer> retailerList = daoRep.sellDollarsByRetailer();
		return retailerList;
	}

}
