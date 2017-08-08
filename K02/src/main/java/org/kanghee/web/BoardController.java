package org.kanghee.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kanghee.domain.BoardVO;
import org.kanghee.domain.MemberVO;
import org.kanghee.service.BoardServiceImpl;
import org.kanghee.service.MemberServiceImpl;
import org.kanghee.util.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.info("registGET load............");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, Model model) throws Exception {
		logger.info("registPOST load............");
		logger.info(vo.toString());
	
		boardService.create(vo);
		model.addAttribute("vo", vo);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void viewGET(@RequestParam("bno")Integer bno, Model model) throws Exception {
		logger.info("viewPage GET.............");
		
		model.addAttribute("read", boardService.read(bno));
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(Model model, HttpServletRequest req) throws Exception {
		logger.info("List Page 이동");
		
		HttpSession session = req.getSession();
	    String member_id = session.getAttribute("member_id").toString();      
	    System.out.println(member_id);
	      
	    model.addAttribute("read", memberService.read(member_id)); 
		model.addAttribute("list", boardService.list());
	
	} //로그인한 Member_ID에 게시글만 보여주기 	
	
	@RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest req, HttpServletResponse res, MemberVO vo, RedirectAttributes rttr) throws Exception {

	      String member_id = vo.getMember_id();
	      String member_pw = vo.getMember_pw();
	      
	      boolean check = memberService.memberLogin(vo);

	      if (check == true) {
	         rttr.addFlashAttribute("msg", "loginSuccess");
	         logger.info("로그인성공..." + check);
	         
	         return LoginUtil.Success(req, res, member_id, member_pw);
	         
	      } else {
	    	 rttr.addFlashAttribute("msg", "loginFail");
	         logger.info("로그인실패..." + check);
	        
	         return LoginUtil.Fail(req, res);
	      }
	   }
	
	/*@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("uno")Integer uno, @ModelAttribute("cri")SearchCriteria cri, 
			Model model) throws Exception {
		logger.info("update GET................");
		
		model.addAttribute("read", service.read(uno));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(MemberVO vo, SearchCriteria cri, Model model
			, RedirectAttributes rttr) throws Exception {
		logger.info("update POST...............");
		logger.info(cri.toString());
		logger.info(vo.toString());
		
		service.update(vo);
		model.addAttribute("vo", vo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		logger.info(rttr.toString());
		
		return "redirect:./list?page=1";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(@RequestParam("uno")Integer uno, SearchCriteria cri, Model model,
			RedirectAttributes rttr) throws Exception {
		logger.info("delete POST.............");
		logger.info(cri.toString());
		
		service.delete(uno);
		model.addAttribute("uno", uno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		logger.info(rttr.toString());
		
		return "redirect:./list?page=1";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")SearchCriteria cri, Model model) throws Exception {
		logger.info("ListAll with Criteria GET load............");
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}*/
}
