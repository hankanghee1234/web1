package org.kanghee.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kanghee.domain.Criteria;
import org.kanghee.domain.ReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;
	
	private String NAME = "org.kanghee.dao.ReplyMapper";
	
	@Override
	public void create(ReplyVO vo) throws Exception {
		
		session.insert(NAME + ".create", vo);
	}

	@Override
	public List<ReplyVO> list(Integer uno) throws Exception {
		
		return session.selectList(NAME + ".list", uno);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		
		session.update(NAME + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		
		session.delete(NAME + ".delete", rno);
	}

	@Override
	public List<ReplyVO> listPage(Integer uno, Criteria cri) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("uno", uno);
		paramMap.put("cri", cri);
		
		return session.selectList(NAME + ".listPage", paramMap);
	}

	@Override
	public int count(Integer uno) throws Exception {
		
		return session.selectOne(NAME + ".count", uno);
	}

}
