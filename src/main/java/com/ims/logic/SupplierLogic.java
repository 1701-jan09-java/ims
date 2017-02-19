package com.ims.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.DAOSupplier;
import com.ims.domain.Supplier;

@Service
@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
public class SupplierLogic {	
	
	@Autowired
	private DAOSupplier dao;
		
		 public Supplier getSupplier(int id) {
			// TODO Auto-generated method stub
			Supplier sup = dao.getSupplier(id);
			return sup;
		}
		
		 public List<Supplier> getAllSuppliers() {
			// TODO Auto-generated method stub
			
			List<Supplier> supList = dao.getAllSuppliers();
			return supList;
		}


}
