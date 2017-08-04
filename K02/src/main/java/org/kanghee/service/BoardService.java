package org.kanghee.service;

import java.util.List;

import org.kanghee.domain.BoardVO;

public interface BoardService {

	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> list() throws Exception;
}
