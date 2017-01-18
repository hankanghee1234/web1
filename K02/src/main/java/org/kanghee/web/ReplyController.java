package org.kanghee.web;

import java.util.List;

import org.kanghee.domain.ReplyVO;
import org.kanghee.service.ReplyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	private ReplyServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@RequestMapping(value = "/addReply", method = RequestMethod.POST)
	public @ResponseBody String addReply(ReplyVO vo) throws Exception {
		logger.info("addReply" + vo);
		service.addReply(vo);
		
		return "addReplySuccess";
	}

	@RequestMapping(value = "/updateReply", method = RequestMethod.POST)
	public String updateReply(ReplyVO vo) throws Exception {
		logger.info("modifyReply" + vo);
		service.modifyReply(vo);
		
		return "updateSuccess";
	}

	@RequestMapping(value = "/delReply", method = RequestMethod.POST)
	public @ResponseBody String deleteReply(Integer rno) throws Exception {
		logger.info("removeReply" + rno);
		service.removeReply(rno);
		
		return "deleteSuccess";

	}

	@RequestMapping(value = "/view/{uno}", method = RequestMethod.GET)
	public @ResponseBody List<ReplyVO> view(@PathVariable("uno") Integer uno) throws Exception {
		logger.info("listReply", uno);
		
		return service.listReply(uno);
	}
	
}
