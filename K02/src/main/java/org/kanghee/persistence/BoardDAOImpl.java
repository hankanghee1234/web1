package org.kanghee.persistence;

import org.apache.ibatis.session.SqlSession;
import org.kanghee.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	private String NAME = "org.kanghee.dao.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		
		session.insert(NAME + ".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		
		return session.selectOne(NAME + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		
		session.update(NAME + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		
		session.delete(NAME + ".delete", bno);
	}

}
