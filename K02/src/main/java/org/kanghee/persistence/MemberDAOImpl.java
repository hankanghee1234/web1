package org.kanghee.persistence;

import org.apache.ibatis.session.SqlSession;
import org.kanghee.domain.MemberVO;
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
	public MemberVO read(String member_id) throws Exception {
		
		return session.selectOne(NAME + ".read", member_id);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		
		session.update(NAME + ".update", vo);
		
	}

	@Override
	public void delete(String member_id) throws Exception {
		
		session.delete(NAME + ".delete", member_id);
	}
	
	@Override
	public boolean memberLogin(MemberVO vo) throws Exception {
		
		String member_id = session.selectOne(NAME + ".memberLogin", vo);
		
		if(member_id != null) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean loginCheck(String member_id) throws Exception {
		
		String checkID = session.selectOne(NAME + ".loginCheck", member_id);
		
		if(checkID != null) {
			return true;
		}else {
			return false;
		}
	}


}
