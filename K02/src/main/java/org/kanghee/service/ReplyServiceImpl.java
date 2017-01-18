package org.kanghee.service;

import java.util.List;

import org.kanghee.domain.Criteria;
import org.kanghee.domain.ReplyVO;
import org.kanghee.persistence.ReplyDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAOImpl dao;
	
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		
		dao.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(Integer uno) throws Exception {
		
		return dao.list(uno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		
		dao.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		
		dao.delete(rno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer uno, Criteria cri) throws Exception {
		
		return dao.listPage(uno, cri);
	}

	@Override
	public int count(Integer uno) throws Exception {
		
		return dao.count(uno);
	}

}
