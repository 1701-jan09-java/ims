package com.ims.controllers.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Category;
import com.ims.logic.CategoryLogic;

@RestController
@RequestMapping(value="/category")
public class CategoryAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Category getCategory(@PathVariable("id") Integer id) {
		Category category = CategoryLogic.getCategory(id);
		return category;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public List<Category> getAllCategories() {
		List<Category> categories = CategoryLogic.getAllCategories();
		return categories;
	}
		
}