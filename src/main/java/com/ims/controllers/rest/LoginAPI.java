package com.ims.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/login")
public class LoginAPI {
	
	@Autowired
	private HttpSession session;
	
	private String username = System.getenv("IMS_USER");
	private String password = System.getenv("IMS_PASS");
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public boolean validLogin(HttpServletRequest request, HttpServletResponse response){
		if(this.username.equals(request.getAttribute("username")) && this.password.equals(request.getAttribute("password"))){
			return true;
		}
		return false;
	}

}
