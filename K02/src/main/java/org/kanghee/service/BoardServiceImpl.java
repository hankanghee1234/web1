package org.kanghee.service;

import java.util.List;

import org.kanghee.domain.BoardVO;
import org.kanghee.persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		
		dao.create(vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		
		dao.update(vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> list() throws Exception {
		
		return dao.list();
	}

}
