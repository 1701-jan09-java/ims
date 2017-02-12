package com.ims.test;

import org.junit.Test;

import static org.junit.Assert.*;

import static com.ims.logic.CategoryLogic.*;

public class CategoryLogicTest {
	
	@Test
	public void testgetProduct() {
		
		assertEquals("Category [id=7, name=Home and Garden]", getCategory(7).toString());
		assertEquals("Category [id=100, name=Pet Supplies]", getCategory(100).toString());
		
	}
	
	@Test
	public void testgetAllProducts() {
		
		String expected = "[Category [id=100, name=Pet Supplies], Category [id=7, name=Home and Garden],"
				+ " Category [id=6, name=Fine Art], Category [id=10, name=Books], Category [id=2, name=Clothing],"
				+ " Category [id=1, name=Beauty], Category [id=3, name=Handmade], Category [id=8, name=Toys and Games],"
				+ " Category [id=5, name=Baby Products]]";
		String actual = getAllCategories().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testgetAllProductsByCategory() {
		
		String expected = "[Category [id=100, name=Pet Supplies]]";
		String actual = getAllCategoriesByProduct(100).toString();
		
		assertEquals(expected, actual);
	}
}
