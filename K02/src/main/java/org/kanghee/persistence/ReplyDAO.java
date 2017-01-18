package org.kanghee.persistence;

import java.util.List;

import org.kanghee.domain.Criteria;
import org.kanghee.domain.ReplyVO;

public interface ReplyDAO {

	public void create(ReplyVO vo) throws Exception;

	public List<ReplyVO> list(Integer uno) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
	public List<ReplyVO> listPage(Integer uno, Criteria cri) throws Exception;
	
	public int count(Integer uno) throws Exception;
}
