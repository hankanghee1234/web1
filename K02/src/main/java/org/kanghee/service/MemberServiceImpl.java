package org.kanghee.service;

import org.kanghee.domain.MemberVO;
import org.kanghee.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public void create(MemberVO vo) throws Exception {
		
		dao.create(vo);
	}

	@Override
	public MemberVO read(String member_id) throws Exception {
		
		return dao.read(member_id);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		
		dao.update(vo);
		
	}

	@Override
	public void delete(String member_id) throws Exception {
		
		dao.delete(member_id);
	}

	@Override
	public boolean memberLogin(MemberVO vo) throws Exception {
		
		return dao.memberLogin(vo);
	}

	@Override
	public boolean loginCheck(String member_id) throws Exception {
		
		return dao.loginCheck(member_id);
	}

	

}
