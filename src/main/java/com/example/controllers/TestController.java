package com.example.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(method=RequestMethod.GET, value="/cat")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("name", "John");
		return "dog";
	}
	
	
	
}
