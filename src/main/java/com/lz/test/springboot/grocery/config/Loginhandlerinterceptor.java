package com.lz.test.springboot.grocery.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class Loginhandlerinterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		// TODO Auto-generated method stub
		Object loginUser=request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			request.setAttribute("msg", "please login first");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}else {
			return true;
		}
		
	}
	
}
