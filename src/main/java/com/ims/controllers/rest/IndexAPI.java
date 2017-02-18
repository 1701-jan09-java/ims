package com.ims.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class IndexAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}
		
}
