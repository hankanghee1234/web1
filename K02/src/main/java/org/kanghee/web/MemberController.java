package org.kanghee.web;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.kanghee.domain.MemberVO;
import org.kanghee.domain.PageMaker;
import org.kanghee.domain.SearchCriteria;
import org.kanghee.service.MemberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@GetMapping(value = "/show", produces = { "image/gif", "image/jpeg", "image/jpg", "image/png" })
	public @ResponseBody byte[] show(String name) throws Exception {

		InputStream in = new FileInputStream("C:\\zzz\\" + name);

		return IOUtils.toByteArray(in);
	}
	
	@PostMapping("/uploadFile")
	@ResponseBody 
	public String uploadFile(MultipartFile file) throws Exception {

		UUID uid = UUID.randomUUID();
		
		InputStream is = file.getInputStream();
		String fileName = file.getOriginalFilename();

		String uploadName = uid + "_" + fileName;
		
		FileOutputStream fos = new FileOutputStream("C:\\zzz\\" + fileName); 
		FileOutputStream foss = new FileOutputStream("C:\\zzz\\" + uploadName); 
		
		BufferedImage origin = ImageIO.read(is);
		
		BufferedImage destImg = Scalr.resize(origin,
				Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100); 
		
		ImageIO.write(origin, "jpg", fos);
		ImageIO.write(destImg, "jpg", foss);
		
		fos.close();
		foss.close();
		
		return uploadName;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.info("registGET load............");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(MemberVO vo, Model model) throws Exception {
		logger.info("registPOST load............");
		logger.info(vo.toString());
	
		service.create(vo);
		model.addAttribute("vo", vo);
		
		return "redirect:./list?page=1";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void viewGET(@RequestParam("uno")Integer uno, @ModelAttribute("cri")SearchCriteria cri, 
			Model model) throws Exception {
		logger.info("viewPage GET.............");
		
		model.addAttribute("read", service.read(uno));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
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
	}
	
	
}
