package com.ing.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ing.exception.UnAuthorizedUser;
import com.ing.exception.UserIDFormatException;

@Component
public class UserInterceptor implements HandlerInterceptor{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		 if(request.getHeader("Authorization")==null||request.getHeader("Authorization").trim().equalsIgnoreCase("")||!request.getHeader("Authorization").trim().contains("Bearer")) {
			throw new UnAuthorizedUser("Invalid User");
		}
		
		
			
			String req=request.getRequestURI().trim();
			String reqParam[]=req.split("/");
			
		    if(reqParam.length!=3) {
		    	throw new UserIDFormatException("User ID is not correct. UserID should be numeric");
		    }
		    
		   if(req.contains("fetchuser")||req.contains("update")) {
		  try{
			  Integer.parseInt(reqParam[2]);
		  }
		  catch(Exception e) {
			  
			  throw new UserIDFormatException("User ID is not correct. UserID should be numeric");
		  }
		   }
		
		  
		 
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	

}
