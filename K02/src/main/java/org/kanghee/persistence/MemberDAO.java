package org.kanghee.persistence;

import java.util.List;

import org.kanghee.domain.Criteria;
import org.kanghee.domain.MemberVO;
import org.kanghee.domain.SearchCriteria;

public interface MemberDAO {

	public void create(MemberVO vo) throws Exception;
	
	public MemberVO read(Integer uno) throws Exception;
	
	public void update(MemberVO vo) throws Exception;
	
	public void delete(Integer uno) throws Exception;
	
	public List<MemberVO> list() throws Exception;
	
	public List<MemberVO> listPage(int page) throws Exception;
	
	public List<MemberVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	public List<MemberVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}
