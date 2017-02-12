package com.ims.test;

import org.junit.Test;

import static org.junit.Assert.*;

import static com.ims.logic.ProductLogic.*;

public class ProductLogicTest {
	
	@Test
	public void testgetProduct() {
		
		assertEquals("Product [id=100, name=Dog Carrier, supplierPrice=40, retailerPrice=50, categories=[Category [id=100, name=Pet Supplies]]]", getProduct(100).toString());
		assertEquals("Product [id=200, name=test, supplierPrice=5, retailerPrice=55, categories=[]]", getProduct(200).toString());
		
	}
	
	@Test
	public void testgetAllProducts() {
		
		String expected = "[Product [id=100, name=Dog Carrier, supplierPrice=40, retailerPrice=50, categories="
				+ "[Category [id=100, name=Pet Supplies]]], Product [id=200, name=test, supplierPrice=5, retailerPrice=55, categories=[]], "
				+ "Product [id=300, name=Test, supplierPrice=5, retailerPrice=55, categories=[]]]";
		String actual = getAllProducts().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testgetAllProductsByCategory() {
		
		String expected = "[Product [id=100, name=Dog Carrier, supplierPrice=40, retailerPrice=50, categories=[Category [id=100, name=Pet Supplies]]]]";
		String actual = getAllProductsByCategory(100).toString();
		
		assertEquals(expected, actual);
	}
}
