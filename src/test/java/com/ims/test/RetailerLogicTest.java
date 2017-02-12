package com.ims.test;

import org.junit.Test;

import com.ims.domain.Retailer;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static com.ims.logic.RetailerLogic.*;

public class RetailerLogicTest {
	
	@Test
	public void testviewRetailerById() {
		
		assertEquals("viewRetailerById(1) = Lenore Fuentes", "Retailer [id=1, name=Lenore Fuentes, address=248 Powers Street, Mesa,  AZ, 85206]", viewRetailerById(1).toString());
		assertEquals("viewRetailerById(2) = Sharon Slater", "Retailer [id=2, name=Sharon Slater, address=123 A Street, Pheonix,  AZ, 85204]", viewRetailerById(2).toString());
		assertEquals("viewRetailerById(3) = Isadora Pickett", "Retailer [id=3, name=Isadora Pickett, address=245 B Street, Pheonix,  AZ, 85203]", viewRetailerById(3).toString());
		assertEquals("viewRetailerById(4) = Tiger P. Porter", "Retailer [id=4, name=Tiger P. Porter, address=4553 Orange Street, Somewhere,  NM, 48853]", viewRetailerById(4).toString());
		assertEquals("viewRetailerById(5) = Cedric Burns", "Retailer [id=5, name=Cedric Burns, address=Ap #880-7809 Ut Rd., Lakewood,  CO, 35710]", viewRetailerById(5).toString());
	}
	
	@Test
	public void testviewAllRetailers() {
		
		String expected = "[Retailer [id=1, name=Lenore Fuentes, address=248 Powers Street, Mesa,  AZ, 85206], "+ 
						"Retailer [id=2, name=Sharon Slater, address=123 A Street, Pheonix,  AZ, 85204], "+
						"Retailer [id=3, name=Isadora Pickett, address=245 B Street, Pheonix,  AZ, 85203], "+
						"Retailer [id=4, name=Tiger P. Porter, address=4553 Orange Street, Somewhere,  NM, 48853], "+
						"Retailer [id=5, name=Cedric Burns, address=Ap #880-7809 Ut Rd., Lakewood,  CO, 35710]]";
		String actual = viewAllRetailers().toString();
		
		assertEquals(expected, actual);
		
	}
}
