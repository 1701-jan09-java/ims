package com.ims.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class LoginAPI {
	
	@Autowired
	private HttpSession session;
	
	private final String username = System.getenv("IMS_USER");
	private final String password = System.getenv("IMS_PASS");
	
	@RequestMapping(method=RequestMethod.POST, value="login")
	public boolean validLogin(HttpServletRequest request, HttpServletResponse response){
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
                System.out.println("com.ims.controllers.rest.LoginAPI.validLogin()");
		if(username.equals(user) && password.equals(pass)){
			session.setAttribute("authenticated", "true");
			// invalidate session after 20 minutes
			session.setMaxInactiveInterval(20*60);
			return true;
		}
		session.setAttribute("authenticated", "false");
		return false;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="login")
	public boolean verifyLogin(){
		System.out.println("Update timer");
		return session.getAttribute("authenticated") == "true";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="logout")
	public void logout(){
		session.invalidate();
	}

}
