package com.ims.logic;

import java.util.List;

import com.ims.dao.DAOSupplier;
import com.ims.dao.DISupplier;
import com.ims.domain.Supplier;

public class SupplierLogic {	
	
	private DAOSupplier daoSup = new DISupplier();
	
	
		
		public void setDaoSup(DAOSupplier daoSup) {
		this.daoSup = daoSup;
	}

		public Supplier getSupplier(int id) {
			// TODO Auto-generated method stub
			Supplier sup = daoSup.getSupplier(id);
			return sup;
		}
		
		public List<Supplier> getAllSuppliers() {
			// TODO Auto-generated method stub
			
			List<Supplier> supList = daoSup.getAllSuppliers();
			return supList;
		}

}
