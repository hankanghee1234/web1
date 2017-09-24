package org.kanghee.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kanghee.domain.BoardVO;
import org.kanghee.persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;
	
	@Test
	public void createTest() throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("매너좀");
		vo.setContent("짜증나게 졸라 싸우네");
		vo.setMember_name("지하철");
		
		dao.create(vo);
		System.out.println(vo);
		
	}
	

}
