package org.kanghee.web;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kanghee.domain.UserVO;
import org.kanghee.dto.LoginDTO;
import org.kanghee.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	private UserVO vo;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto){
		logger.info("login GET................");
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("login POST................");
		
		vo = service.login(dto);
		
		if(vo != null){
			return;
		}
		
		model.addAttribute("userVO", vo);
		
		if(dto.isUseCookie()){
			int amount = 60 * 60 * 24 * 7;
			
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			
			service.keepLogin(vo.getUid(), session.getId(), sessionLimit);
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		logger.info("logout GET.................");
		
		Object obj = session.getAttribute("login");
		
		if(obj != null){
			UserVO vo = (UserVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null){
				
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getUid(), session.getId(), new Date());
			}
		}
		
		return "user/logout";
	}
}
