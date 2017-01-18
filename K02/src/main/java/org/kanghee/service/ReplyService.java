package org.kanghee.service;

import java.util.List;

import org.kanghee.domain.Criteria;
import org.kanghee.domain.ReplyVO;

public interface ReplyService {

	public void addReply(ReplyVO vo) throws Exception;
	
	public List<ReplyVO> listReply(Integer uno) throws Exception;
	
	public void modifyReply(ReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<ReplyVO> listReplyPage(Integer uno, Criteria cri) throws Exception;
	
	public int count(Integer uno) throws Exception;
}
