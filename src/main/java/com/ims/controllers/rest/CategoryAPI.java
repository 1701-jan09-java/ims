package com.ims.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Category;
import com.ims.logic.CategoryLogic;

@RestController
@RequestMapping(value="/category")
public class CategoryAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="/get-category")
	public Category getCategory(int categoryID) {
		return CategoryLogic.getCategory(categoryID);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/get-all-categories")
	public ResponseEntity<Category> getAllCategories() {
		CategoryLogic.getAllCategories();
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(category);
	}
		
}