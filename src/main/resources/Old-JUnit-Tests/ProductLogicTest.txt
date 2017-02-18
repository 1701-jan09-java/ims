package com.ims.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ims.logic.ProductLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class ProductLogicTest {
	
	@Autowired
	private ProductLogic productLogic;
	
	@Test
	public void testgetProduct() {
		
		assertEquals("Product [id=100, name=Dog Carrier, supplierPrice=40, retailerPrice=50, categories=[Category [id=100, name=Pet Supplies]]]", productLogic.getProduct(100).toString());
		assertEquals("Product [id=200, name=test, supplierPrice=5, retailerPrice=55, categories=[]]", productLogic.getProduct(200).toString());
		
	}
	
	@Test
	public void testgetAllProducts() {
		
		String expected = "[Product [id=100, name=Dog Carrier, supplierPrice=40, retailerPrice=50, categories="
				+ "[Category [id=100, name=Pet Supplies]]], Product [id=200, name=test, supplierPrice=5, retailerPrice=55, categories=[]], "
				+ "Product [id=300, name=Test, supplierPrice=5, retailerPrice=55, categories=[]]]";
		String actual = productLogic.getAllProducts().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testgetAllProductsByCategory() {
		
		String expected = "[Product [id=100, name=Dog Carrier, supplierPrice=40, retailerPrice=50, categories=[Category [id=100, name=Pet Supplies]]]]";
		String actual = productLogic.getAllProductsByCategory(100).toString();
		
		assertEquals(expected, actual);
	}
}
