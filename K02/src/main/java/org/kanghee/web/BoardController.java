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


@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardServiceImpl boardService;
	
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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(Model model) throws Exception {
		logger.info("list Page GET...........");
		
		model.addAttribute("list", boardService.list());
	} 
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public void viewPageGET(Model model, Integer bno) throws Exception {
		logger.info("view Page GET..........");
		
		model.addAttribute("read", boardService.read(bno));
	}
	
	
}
