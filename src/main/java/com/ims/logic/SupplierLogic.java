package com.ims.logic;

import java.util.List;

import com.ims.dao.DAOSupplier;
import com.ims.dao.DISupplier;
import com.ims.domain.Supplier;

public class SupplierLogic {	
	
	private static DAOSupplier daoSup = new DISupplier();
		
		static public Supplier getSupplier(int id) {
			// TODO Auto-generated method stub
			Supplier sup = daoSup.getSupplier(id);
			return sup;
		}
		
		static public List<Supplier> getAllSuppliers() {
			// TODO Auto-generated method stub
			
			List<Supplier> supList = daoSup.getAllSuppliers();
			return supList;
		}

		public static void setDaoSup(DAOSupplier daoSup) {
			SupplierLogic.daoSup = daoSup;
		}

}
