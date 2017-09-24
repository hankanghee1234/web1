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
		vo.setTitle("�ų���");
		vo.setContent("¥������ ���� �ο��");
		vo.setMember_name("����ö");
		
		dao.create(vo);
		System.out.println(vo);
		
	}
	

}
