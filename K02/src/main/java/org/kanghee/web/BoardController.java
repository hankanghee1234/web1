package org.kanghee.web;


import org.kanghee.domain.BoardVO;
import org.kanghee.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.info("registGET load............");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("registPOST load............");
		logger.info(vo.toString());
	
		service.create(vo);
		model.addAttribute("vo", vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(Model model) throws Exception {
		logger.info("list Page GET...........");
		
		model.addAttribute("list", service.list());
	} 
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void viewPageGET(Model model, @RequestParam("bno")Integer bno) throws Exception {
		logger.info("view Page GET..........");
		
		model.addAttribute("read", service.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String deletePOST(@RequestParam("bno")Integer bno, RedirectAttributes rttr) throws Exception {
		logger.info("Remove Page POST........");
		
		service.delete(bno);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void updateGET(Integer bno, Model model) throws Exception {
		logger.info("Modify Page GET........");
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String updatePOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("Modify Page POST........");
		
		service.update(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/list";
	}
}
