package org.kanghee.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kanghee.domain.Criteria;
import org.kanghee.domain.MemberVO;
import org.kanghee.domain.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession session;
	
	private String NAME = "org.kanghee.dao.MemberMapper";
	
	@Override
	public void create(MemberVO vo) throws Exception {
		
		session.insert(NAME + ".create", vo);
	}

	@Override
	public MemberVO read(Integer uno) throws Exception {
		
		return session.selectOne(NAME + ".read", uno);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		
		session.update(NAME + ".update", vo);
	}

	@Override
	public void delete(Integer uno) throws Exception {
		
		session.delete(NAME + ".delete", uno);
	}

	@Override
	public List<MemberVO> list() throws Exception {
		
		return session.selectList(NAME + ".list");
	}

	@Override
	public List<MemberVO> listPage(int page) throws Exception {
		
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		
		return session.selectList(NAME + ".listPage", page);
	}

	@Override
	public List<MemberVO> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(NAME + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return session.selectOne(NAME + ".countPaging", cri);
	}

	@Override
	public List<MemberVO> listSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(NAME + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne(NAME + ".listSearchCount", cri);
	}

	

}
