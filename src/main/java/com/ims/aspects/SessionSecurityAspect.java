package com.ims.aspects;

import com.ims.exceptions.ForbiddenException;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SessionSecurityAspect {
	
    @Autowired
    private HttpSession session;

	@Before("execution(* com.ims.controllers.rest.*API.*(..)) && !execution(* com.ims.controllers.rest.LoginAPI.*(..))")
	public void checkAuthentication() throws Throwable{
            System.out.println("AOP test");
            if (session.getAttribute("authenticated") != "true") {
                System.out.println("not authenticated");
                // This exception returns a response with 403 Forbidden status
                throw new ForbiddenException();
            } 
	}
	
}