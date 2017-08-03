package org.kanghee.service;

import org.kanghee.domain.MemberVO;

public interface MemberService {
	
	public void create(MemberVO vo) throws Exception;
	
	public MemberVO read(String member_id) throws Exception;
	
	public void update(MemberVO vo) throws Exception;
	
	public void delete(String member_id) throws Exception;
	
	public boolean memberLogin(MemberVO vo) throws Exception;

	public boolean loginCheck(String member_id) throws Exception;
}

