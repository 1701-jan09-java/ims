package com.ims.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ims.logic.CategoryLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/beans.xml"})
public class CategoryLogicTest {
	
	@Autowired
	private CategoryLogic categoryLogic;
	
	@Test
	public void testgetProduct() {
		
		assertEquals("Category [id=7, name=Home and Garden]", categoryLogic.getCategory(7).toString());
		assertEquals("Category [id=100, name=Pet Supplies]", categoryLogic.getCategory(100).toString());
		
	}
	
	@Test
	public void testgetAllProducts() {
		
		String expected = "[Category [id=100, name=Pet Supplies], Category [id=7, name=Home and Garden],"
				+ " Category [id=6, name=Fine Art], Category [id=10, name=Books], Category [id=2, name=Clothing],"
				+ " Category [id=1, name=Beauty], Category [id=3, name=Handmade], Category [id=8, name=Toys and Games],"
				+ " Category [id=5, name=Baby Products]]";
		String actual = categoryLogic.getAllCategories().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testgetAllProductsByCategory() {
		
		String expected = "[Category [id=100, name=Pet Supplies]]";
		String actual = categoryLogic.getAllCategoriesByProduct(100).toString();
		
		assertEquals(expected, actual);
	}
}
