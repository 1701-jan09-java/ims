package com.ims.main;

import org.springframework.beans.factory.annotation.Autowired;

import com.ims.domain.Category;
import com.ims.domain.Product;
import com.ims.logic.ProductLogic;

public class DummyMain {

	
	public static void main(String[] args) {
		
		
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		
//		Retailer retailer1 = new Retailer();
//		retailer1.setName("TestRetailer1");
//		Address address1 = new Address("123 A Street","Pheonix","AZ","85204");
//		retailer1.setAddress(address1);
//		session.save(address1);
//		session.save(retailer1);
//		
//		Supplier supplier = new Supplier();
//		supplier.setName("TestSupplier");
//		Address address2 = new Address("24916 Square Street","Pheonix","AZ","85203");
//		supplier.setAddress(address2);
//		session.save(address2);
//		session.save(supplier);
		
//		Product product = new Product();
//		product.setName("Dog Carrier");
//		product.setRetailerPrice(50);
//		product.setSupplierPrice(40);
//		Category category = new Category();
//		category.setName("Pet Supplies");
//		category.setProducts(Arrays.asList(product));
//		
		
//		Product product = (Product) session.get(Product.class, 100);
//		Category category = (Category) session.get(Category.class, 100);
//		
//		System.out.println(product+"\n"+category+", "+category.getProducts());
//		//session.save(product);
//		//session.save(category);
//		
//		tx.commit();
//		session.close();
		

	}
}
