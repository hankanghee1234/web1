package org.kanghee.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kanghee.domain.MemberVO;
import org.kanghee.service.MemberServiceImpl;
import org.kanghee.util.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void memberRegistGET() throws Exception {
		logger.info("regist PAGE GET............");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(MemberVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register POST............");
	    logger.info(vo.toString());

	    memberService.create(vo);
	    rttr.addFlashAttribute("msg", "registSuccess");
	      
	    return "redirect:/index";
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public boolean loginCheck(String member_id) throws Exception {
	      
		boolean check = memberService.loginCheck(member_id);  
		logger.info("중복체크..." + check);
	      
		return check;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest req, HttpServletResponse res, MemberVO vo) throws Exception {
	      logger.info("logout: " + vo);
	     
	      String member_id = vo.getMember_id();
	     
	      return LoginUtil.logout(req, res, member_id);
	}
}
