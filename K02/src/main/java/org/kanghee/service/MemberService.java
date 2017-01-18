package org.kanghee.service;

import java.util.List;

import org.kanghee.domain.Criteria;
import org.kanghee.domain.MemberVO;
import org.kanghee.domain.SearchCriteria;

public interface MemberService {
	
	public void create(MemberVO vo) throws Exception;
	
	public MemberVO read(Integer uno) throws Exception;
	
	public void update(MemberVO vo) throws Exception;
	
	public void delete(Integer uno) throws Exception;
	
	public List<MemberVO> list() throws Exception;
	
	public List<MemberVO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<MemberVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
}

