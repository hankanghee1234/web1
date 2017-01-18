package org.kanghee.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kanghee.domain.UserVO;
import org.kanghee.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserServiceImpl service;

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	private void saveDest(HttpServletRequest req) {
		
		String uri = req.getRequestURI();
		
		String query = req.getQueryString();
		
		if(query == null || query.equals("null")){
			
			query = "";
			
		}else{
			
			query = "?" + query;
		}
		
		if(req.getMethod().equals("GET")){
			
			logger.info("dest: " + (uri + query));
			req.getSession().setAttribute("dest", uri + query);
		}	
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// login 
		HttpSession session = request.getSession();
		
		System.out.println("1---------------------------");
		System.out.println("1---------------------------");
		System.out.println("1---------------------------");
		System.out.println("1---------------------------");
		System.out.println("1---------------------------");
		System.out.println("1---------------------------");
		
		if(session.getAttribute("login") != null){
			logger.info("current user is not logined");
			System.out.println("current user is not logined");
			
			response.sendRedirect("/user/login");
			return false;
			
		}else {
			
			saveDest(request);
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null){
				
				System.out.println("login cookie is not null");
				
				UserVO userVO = service.checkLoginBefore(loginCookie.getValue());
				logger.info("USERVO: " + userVO);
				
				if(userVO != null){
					
					session.setAttribute("login", userVO);
					return true;
				}
			}
			return true;
		}
	}
	
	
	
	
}
