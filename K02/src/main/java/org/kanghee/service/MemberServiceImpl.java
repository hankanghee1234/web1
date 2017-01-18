package org.kanghee.service;

import java.util.List;

import org.kanghee.domain.Criteria;
import org.kanghee.domain.MemberVO;
import org.kanghee.domain.SearchCriteria;
import org.kanghee.persistence.MemberDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAOImpl dao;
	
	@Transactional
	@Override
	public void create(MemberVO vo) throws Exception {
		
		dao.create(vo);
	}

	@Override
	public MemberVO read(Integer uno) throws Exception {
		
		return dao.read(uno);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		
		dao.update(vo);
	}

	@Override
	public void delete(Integer uno) throws Exception {
		
		dao.delete(uno);
	}

	@Override
	public List<MemberVO> list() throws Exception {
		
		return dao.list();
	}

	@Override
	public List<MemberVO> listCriteria(Criteria cri) throws Exception {
		
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		
		return dao.countPaging(cri);
	}

	@Override
	public List<MemberVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}

}
