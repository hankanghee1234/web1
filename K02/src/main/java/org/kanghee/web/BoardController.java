package org.kanghee.web;

import org.kanghee.domain.BoardVO;
import org.kanghee.service.BoardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardServiceImpl service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.info("registGET load............");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, Model model) throws Exception {
		logger.info("registPOST load............");
		logger.info(vo.toString());
	
		service.create(vo);
		model.addAttribute("vo", vo);
		
		return "redirect:./list?page=1";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void viewGET(@RequestParam("bno")Integer bno, Model model) throws Exception {
		logger.info("viewPage GET.............");
		
		model.addAttribute("read", service.read(bno));
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
