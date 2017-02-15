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
		
		assertEquals("viewRetailerById(1) = Lenore Fuentes", "Retailer [id=1, name=Lenore Fuentes, address=[street=248 Powers Street, city=Mesa, state=AZ, zip=85206]]", viewRetailerById(1).toString());
		assertEquals("viewRetailerById(2) = Sharon Slater", "Retailer [id=2, name=Sharon Slater, address=[street=123 A Street, city=Pheonix, state=AZ, zip=85204]]", viewRetailerById(2).toString());
		assertEquals("viewRetailerById(3) = Isadora Pickett", "Retailer [id=3, name=Isadora Pickett, address=[street=245 B Street, city=Pheonix, state=AZ, zip=85203]]", viewRetailerById(3).toString());
		assertEquals("viewRetailerById(4) = Tiger P. Porter", "Retailer [id=4, name=Tiger P. Porter, address=[street=4553 Orange Street, city=Somewhere, state=NM, zip=48853]]", viewRetailerById(4).toString());
		assertEquals("viewRetailerById(5) = Cedric Burns", "Retailer [id=5, name=Cedric Burns, address=[street=Ap #880-7809 Ut Rd., city=Lakewood, state=CO, zip=35710]]", viewRetailerById(5).toString());
	}
	
	@Test
	public void testviewAllRetailers() {
		
		String expected = "[Retailer [id=3, name=Isadora Pickett, address=[street=245 B Street, city=Pheonix, state=AZ, zip=85203]], "+ 
						"Retailer [id=1, name=Lenore Fuentes, address=[street=248 Powers Street, city=Mesa, state=AZ, zip=85206]], "+
						"Retailer [id=4, name=Tiger P. Porter, address=[street=4553 Orange Street, city=Somewhere, state=NM, zip=48853]], "	+					
						"Retailer [id=5, name=Cedric Burns, address=[street=Ap #880-7809 Ut Rd., city=Lakewood, state=CO, zip=35710]], " +
						"Retailer [id=2, name=Sharon Slater, address=[street=123 A Street, city=Pheonix, state=AZ, zip=85204]]]";
		String actual = viewAllRetailers().toString();
		
		assertEquals(expected, actual);
		
	}
}
