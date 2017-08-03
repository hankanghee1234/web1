package org.kanghee.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUtil {

	public static String Success(HttpServletRequest req, HttpServletResponse res, String member_id, String member_pw)
			throws Exception {
		
		System.out.println("아이디 : " + member_id);
		System.out.println("비밀번호 : " + member_pw);
		
		HttpSession session = req.getSession();
		session.setAttribute("member_id", member_id);
		req.setAttribute("member_id", member_id);
		
		Cookie loginCookie = new Cookie("login", member_id);
		loginCookie.setPath("/");
		loginCookie.setMaxAge(60 * 60 * 24);
		res.addCookie(loginCookie);
		
		System.out.println("로그인쿠키.. : " + loginCookie.getValue());
		
		return "redirect:./list";
	}

	public static String Fail(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("로그인실패..");
		
		return "redirect:/login";
	}
	
	public static String logout(HttpServletRequest req, HttpServletResponse res, String member_id) throws Exception {
	      
	      System.out.println("아이디 : " + member_id);
	      
	      HttpSession session = req.getSession();
	      session.setAttribute("member_id", member_id);
	      req.setAttribute("member_id", member_id);
	      
	      Cookie loginCookie = new Cookie("login", member_id);
	      loginCookie.setPath("/");
	      loginCookie.setMaxAge(0 * 0 * 0);
	      res.addCookie(loginCookie);
	      
	      System.out.println("쿠키값확인 : " + loginCookie.getValue());
	      
	      return "redirect:/login";
	   }
}
